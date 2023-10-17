package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;

public class FileInfo {

    @JsonProperty("file_size")
    private int fileSize;

    @JsonProperty("upload_timestamp")
    private LocalDateTime uploadTimestamp;

    @JsonProperty("md5")
    private String md5;

    @JsonProperty("sha1")
    private String sha1;

    @JsonProperty("sha256")
    private String sha256;

    @JsonProperty("file_type_category")
    private String fileTypeCategory;

    @JsonProperty("file_type_description")
    private String fileTypeDescription;

    @JsonProperty("file_type_extension")
    private String fileTypeExtension;

    @JsonProperty("display_name")
    private String displayName;

    // Standard getters and setters follow
    public int getFileSize() {
        return fileSize;
    }

    public void setFileSize(int fileSize) {
        this.fileSize = fileSize;
    }

    public LocalDateTime getUploadTimestamp() {
        return uploadTimestamp;
    }

    public void setUploadTimestamp(LocalDateTime uploadTimestamp) {
        this.uploadTimestamp = uploadTimestamp;
    }

    public String getMd5() {
        return md5;
    }

    public void setMd5(String md5) {
        this.md5 = md5;
    }

    public String getSha1() {
        return sha1;
    }

    public void setSha1(String sha1) {
        this.sha1 = sha1;
    }

    public String getSha256() {
        return sha256;
    }

    public void setSha256(String sha256) {
        this.sha256 = sha256;
    }

    public String getFileTypeCategory() {
        return fileTypeCategory;
    }

    public void setFileTypeCategory(String fileTypeCategory) {
        this.fileTypeCategory = fileTypeCategory;
    }

    public String getFileTypeDescription() {
        return fileTypeDescription;
    }

    public void setFileTypeDescription(String fileTypeDescription) {
        this.fileTypeDescription = fileTypeDescription;
    }

    public String getFileTypeExtension() {
        return fileTypeExtension;
    }

    public void setFileTypeExtension(String fileTypeExtension) {
        this.fileTypeExtension = fileTypeExtension;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }
}