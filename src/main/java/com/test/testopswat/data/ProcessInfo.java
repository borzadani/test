package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.Arrays;

public class ProcessInfo {

    @JsonProperty("progress_percentage")
    private int progressPercentage;

    @JsonProperty("profile")
    private String profile;

    @JsonProperty("result")
    private String result;

    @JsonProperty("blocked_reason")
    private String blockedReason;

    @JsonProperty("file_type_skipped_scan")
    private boolean fileTypeSkippedScan;

    @JsonProperty("post_processing")
    private PostProcessing postProcessing;

    @JsonProperty("verdicts")
    private String[] verdicts;

    @JsonProperty("blocked_reasons")
    private String[] blockedReasons;

    public int getProgressPercentage() {
        return this.progressPercentage;
    }

    public void setProgressPercentage(int progressPercentage) {
        this.progressPercentage = progressPercentage;
    }

    public String getProfile() {
        return this.profile;
    }

    public void setProfile(String profile) {
        this.profile = profile;
    }

    public String getResult() {
        return this.result;
    }

    public void setResult(String result) {
        this.result = result;
    }

    public String getBlockedReason() {
        return this.blockedReason;
    }

    public void setBlockedReason(String blockedReason) {
        this.blockedReason = blockedReason;
    }

    public boolean isFileTypeSkippedScan() {
        return this.fileTypeSkippedScan;
    }

    public void setFileTypeSkippedScan(boolean fileTypeSkippedScan) {
        this.fileTypeSkippedScan = fileTypeSkippedScan;
    }

    public PostProcessing getPostProcessing() {
        return this.postProcessing;
    }

    public void setPostProcessing(PostProcessing postProcessing) {
        this.postProcessing = postProcessing;
    }

    public String[] getVerdicts() {
        return this.verdicts;
    }

    public void setVerdicts(String[] verdicts) {
        this.verdicts = verdicts;
    }

    public String[] getBlockedReasons() {
        return this.blockedReasons;
    }

    public void setBlockedReasons(String[] blockedReasons) {
        this.blockedReasons = blockedReasons;
    }

    @Override
    public String toString() {
        return "ProcessInfo{" +
                "progressPercentage=" + progressPercentage +
                ", profile='" + profile + '\'' +
                ", result='" + result + '\'' +
                ", blockedReason='" + blockedReason + '\'' +
                ", fileTypeSkippedScan=" + fileTypeSkippedScan +
                ", postProcessing=" + postProcessing +
                ", verdicts=" + Arrays.toString(verdicts) +
                ", blockedReasons=" + Arrays.toString(blockedReasons) +
                '}';
    }
}
