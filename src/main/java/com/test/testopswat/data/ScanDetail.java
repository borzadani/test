package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.Map;

public class ScanDetail {
    @JsonProperty("scan_time")
    private int scanTime;
    @JsonProperty("def_time")
    private String defTime;
    @JsonProperty("scan_result_i")
    private int scanResultI;
    @JsonProperty("threat_found")
    private String threatFound;

    public int getScanTime() {
        return scanTime;
    }

    public String getDefTime() {
        return defTime;
    }

    public int getScanResultI() {
        return scanResultI;
    }

    public String getThreatFound() {
        return threatFound;
    }

    public void setScanTime(int scanTime) {
        this.scanTime = scanTime;
    }

    public void setDefTime(String defTime) {
        this.defTime = defTime;
    }

    public void setScanResultI(int scanResultI) {
        this.scanResultI = scanResultI;
    }

    public void setThreatFound(String threatFound) {
        this.threatFound = threatFound;
    }
}
