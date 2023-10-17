package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDateTime;
import java.util.Map;

public class ScanResults {
    @JsonProperty("scan_details")
    private Map<String, ScanDetail> scanDetails;

    @JsonProperty("scan_all_result_i")
    private int scanAllResultI;

    @JsonProperty("current_av_result_i")
    private int currentAvResultI;

    @JsonProperty("start_time")
    private LocalDateTime startTime;

    @JsonProperty("total_time")
    private int totalTime;

    @JsonProperty("total_avs")
    private int totalAvs;

    @JsonProperty("total_detected_avs")
    private int totalDetectedAvs;

    @JsonProperty("progress_percentage")
    private int progressPercentage;

    @JsonProperty("scan_all_result_a")
    private String scanAllResultA;

    @JsonProperty("current_av_result_a")
    private String currentAvResultA;

    public Map<String, ScanDetail> getScanDetails() {
        return scanDetails;
    }

    public int getScanAllResultI() {
        return scanAllResultI;
    }

    public int getCurrentAvResultI() {
        return currentAvResultI;
    }

    public LocalDateTime getStartTime() {
        return startTime;
    }

    public int getTotalTime() {
        return totalTime;
    }

    public int getTotalAvs() {
        return totalAvs;
    }

    public int getTotalDetectedAvs() {
        return totalDetectedAvs;
    }

    public int getProgressPercentage() {
        return progressPercentage;
    }

    public String getScanAllResultA() {
        return scanAllResultA;
    }

    public String getCurrentAvResultA() {
        return currentAvResultA;
    }

    public void setScanDetails(Map<String, ScanDetail> scanDetails) {
        this.scanDetails = scanDetails;
    }

    public void setScanAllResultI(int scanAllResultI) {
        this.scanAllResultI = scanAllResultI;
    }

    public void setCurrentAvResultI(int currentAvResultI) {
        this.currentAvResultI = currentAvResultI;
    }

    public void setStartTime(LocalDateTime startTime) {
        this.startTime = startTime;
    }

    public void setTotalTime(int totalTime) {
        this.totalTime = totalTime;
    }

    public void setTotalAvs(int totalAvs) {
        this.totalAvs = totalAvs;
    }

    public void setTotalDetectedAvs(int totalDetectedAvs) {
        this.totalDetectedAvs = totalDetectedAvs;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public void setScanAllResultA(String scanAllResultA) {
        this.scanAllResultA = scanAllResultA;
    }

    public void setCurrentAvResultA(String currentAvResultA) {
        this.currentAvResultA = currentAvResultA;
    }
}
