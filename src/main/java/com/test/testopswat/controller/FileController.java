package com.test.testopswat.controller;

import com.test.testopswat.data.DisplayedResponse;
import com.test.testopswat.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class FileController {

    @Autowired
    private FileService fileService;

    @PostMapping("/scan-file")
    public ResponseEntity<DisplayedResponse> scanFile(@RequestParam("file") MultipartFile file) throws Exception {
        DisplayedResponse result = fileService.processFile(file);

        return ResponseEntity.ok(result);
    }
}
