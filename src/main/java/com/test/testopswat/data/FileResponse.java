package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;
import java.util.Map;
import java.time.LocalDateTime;

@Data
public class FileResponse {
    @JsonProperty("scan_result_history_length")
    private int scanResultHistoryLength;
    @JsonProperty("votes")
    private Votes votes;
    @JsonProperty("sandbox")
    private boolean sandbox;
    @JsonProperty("file_id")
    private String fileId;
    @JsonProperty("data_id")
    private String dataId;
    @JsonProperty("process_info")
    private ProcessInfo processInfo;
    @JsonProperty("scan_results")
    private ScanResults scanResults;
    @JsonProperty("file_info")
    private FileInfo fileInfo;
    @JsonProperty("share_file")
    private int shareFile;
    @JsonProperty("private_processing")
    private boolean privateProcessing;
    @JsonProperty("rest_version")
    private String restVersion;
    @JsonProperty("additional_info")
    private List<String> additionalInfo;
    @JsonProperty("stored")
    private boolean stored;

    public int getScanResultHistoryLength() {
        return scanResultHistoryLength;
    }

    public Votes getVotes() {
        return votes;
    }

    public boolean isSandbox() {
        return sandbox;
    }

    public String getFileId() {
        return fileId;
    }

    public String getDataId() {
        return dataId;
    }

    public ProcessInfo getProcessInfo() {
        return processInfo;
    }

    public ScanResults getScanResults() {
        return scanResults;
    }

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public int getShareFile() {
        return shareFile;
    }

    public boolean isPrivateProcessing() {
        return privateProcessing;
    }

    public String getRestVersion() {
        return restVersion;
    }

    public List<String> getAdditionalInfo() {
        return additionalInfo;
    }

    public boolean isStored() {
        return stored;
    }

    public void setScanResultHistoryLength(int scanResultHistoryLength) {
        this.scanResultHistoryLength = scanResultHistoryLength;
    }

    public void setVotes(Votes votes) {
        this.votes = votes;
    }

    public void setSandbox(boolean sandbox) {
        this.sandbox = sandbox;
    }

    public void setFileId(String fileId) {
        this.fileId = fileId;
    }

    public void setDataId(String dataId) {
        this.dataId = dataId;
    }

    public void setProcessInfo(ProcessInfo processInfo) {
        this.processInfo = processInfo;
    }

    public void setScanResults(ScanResults scanResults) {
        this.scanResults = scanResults;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }

    public void setShareFile(int shareFile) {
        this.shareFile = shareFile;
    }

    public void setPrivateProcessing(boolean privateProcessing) {
        this.privateProcessing = privateProcessing;
    }

    public void setRestVersion(String restVersion) {
        this.restVersion = restVersion;
    }

    public void setAdditionalInfo(List<String> additionalInfo) {
        this.additionalInfo = additionalInfo;
    }

    public void setStored(boolean stored) {
        this.stored = stored;
    }

    @Override
    public String toString() {
        return "FinalResult{" +
                "scanResultHistoryLength=" + scanResultHistoryLength +
                ", votes=" + votes +
                ", sandbox=" + sandbox +
                ", fileId='" + fileId + '\'' +
                ", dataId='" + dataId + '\'' +
                ", processInfo=" + processInfo +
                ", scanResults=" + scanResults +
                ", fileInfo=" + fileInfo +
                ", shareFile=" + shareFile +
                ", privateProcessing=" + privateProcessing +
                ", restVersion='" + restVersion + '\'' +
                ", additionalInfo=" + additionalInfo +
                ", stored=" + stored +
                '}';
    }
}
