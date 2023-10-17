package com.test.testopswat.service;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.test.testopswat.data.DisplayedResponse;
import com.test.testopswat.data.FileResponse;
import com.test.testopswat.properties.MetaProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.*;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.multipart.MultipartFile;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.HashMap;

import static com.test.testopswat.common.HeaderConstants.API_KEY;
import static com.test.testopswat.common.HeaderConstants.FILENAME;

@Service
public class FileService {
    @Autowired
    private MetaProperties metaProperties;
    private final RestTemplate restTemplate = new RestTemplate();

    public DisplayedResponse processFile(MultipartFile file) throws Exception {
        String fileHash = calculateSHA256(file.getBytes());

        ResponseEntity<String> lookupResponse = lookupHash(fileHash);
        if (lookupResponse != null) {
            return createDisplayedResponse(lookupResponse.getBody());
        }

        String dataId = uploadFile(file);

        String results = "";

        if (dataId != null) {
            while (true) {
                Thread.sleep(10000);
                ResponseEntity<String> pollingResponse = pollForResult(dataId);

                if (pollingResponse != null && pollingResponse.getStatusCode() == HttpStatus.OK) {
                    results = pollingResponse.getBody();
                    break;
                }
            }
        }

        return createDisplayedResponse(results);
    }

    private String calculateSHA256(byte[] fileData) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(fileData);
        StringBuilder hexString = new StringBuilder(2 * hash.length);
        for (byte b : hash) {
            hexString.append(String.format("%02x", b));
        }
        return hexString.toString();
    }

    private ResponseEntity<String> lookupHash(String fileHash) throws HttpStatusCodeException {
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_KEY, metaProperties.getApiKey());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(metaProperties.getHashLookupUrl() + fileHash, HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            return null;
        }
    }

    private String uploadFile(MultipartFile file) throws Exception {
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.set(API_KEY, metaProperties.getApiKey());
        headers.set(FILENAME, file.getOriginalFilename());

        HttpEntity<byte[]> entity = new HttpEntity<>(file.getBytes(), headers);

        try {
            ResponseEntity<HashMap> response = restTemplate.postForEntity(metaProperties.getFileUploadUrl(), entity, HashMap.class);
            return (String) response.getBody().get("data_id");
        } catch (Exception e) {
            return null;
        }
    }

    private ResponseEntity<String> pollForResult(String dataId) {
        HttpHeaders headers = new HttpHeaders();
        headers.set(API_KEY, metaProperties.getApiKey());
        HttpEntity<String> entity = new HttpEntity<>(headers);

        try {
            return restTemplate.exchange(metaProperties.getResultLookupUrl() + dataId, HttpMethod.GET, entity, String.class);
        } catch (Exception e) {
            return null;
        }
    }

    private DisplayedResponse createDisplayedResponse(String results) throws JsonProcessingException {
        ObjectMapper objectMapper = new ObjectMapper().registerModule(new JavaTimeModule());
        FileResponse data = objectMapper.readValue(results, FileResponse.class);

        return DisplayedResponse.createResponse(data);
    }
}
