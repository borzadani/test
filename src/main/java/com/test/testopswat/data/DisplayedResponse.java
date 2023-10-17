package com.test.testopswat.data;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Data
public class DisplayedResponse {
    private String fileName;
    private Status overallStatus;
    private List<EngineResults> engineResults;

    public static DisplayedResponse createResponse(final FileResponse fileResponse) {
        DisplayedResponse response = new DisplayedResponse();
        if (fileResponse.getFileInfo() != null && fileResponse.getFileInfo().getDisplayName() != null) {
            response.setFileName(fileResponse.getFileInfo().getDisplayName());
        }

        if (fileResponse.getScanResults() != null) {
            List<EngineResults> engines = createEngineResults(fileResponse.getScanResults());

            if (engines.isEmpty()) {
                response.setEngineResults(engines);
                response.setOverallStatus(Status.CLEAN);
            } else {
                response.setEngineResults(engines);
                response.setOverallStatus(assessOverallStatus(engines));
            }
        }

        return response;
    }

    private static List<EngineResults> createEngineResults(ScanResults scanResults) {
        List<EngineResults> engineResultsList = new ArrayList<>();

        for (Map.Entry<String, ScanDetail> entry : scanResults.getScanDetails().entrySet()) {
            String engineName = entry.getKey();
            ScanDetail detail = entry.getValue();

            EngineResults engineResult = new EngineResults();
            engineResult.setEngine(engineName);
            engineResult.setThreatFound(detail.getThreatFound());
            engineResult.setScanResult(detail.getScanResultI());
            engineResult.setDefTime(detail.getDefTime());

            engineResultsList.add(engineResult);
        }

        return engineResultsList;
    }

    public enum Status {
        CLEAN("Clean"),
        ISSUES("Issues"),
        MALWARE("Malware");

        private String value;

        Status(String value) {
            this.value = value;
        }

        @JsonValue
        public String getValue() {
            return value;
        }

        @Override
        public String toString() {
            return String.valueOf(value);
        }

        @JsonCreator
        public static Status fromValue(String value) {
            for (Status b : Status.values()) {
                if (b.value.equals(value)) {
                    return b;
                }
            }
            return null;
        }
    }

    private static Status assessOverallStatus(List<EngineResults> engineResultsList) {
        if (engineResultsList == null || engineResultsList.isEmpty()) {
            throw new IllegalArgumentException("Engine results list cannot be null or empty");
        }

        long totalScans = engineResultsList.stream()
                .filter(engineResult -> engineResult.getScanResult() > 0)
                .count();
        int threatsFound = 0;

        for (EngineResults engine : engineResultsList) {
            if ( engine.getScanResult() > 0) {
                if (engine.getThreatFound() != null && !engine.getThreatFound().isEmpty()) {
                    threatsFound++;
                }
            }
        }

        double threatPercentage = (double) threatsFound / totalScans * 100.0;

        if (threatPercentage <= 10) {
            return Status.CLEAN;
        } else if (threatPercentage <= 50) {
            return Status.ISSUES;
        } else {
            return Status.MALWARE;
        }
    }
}
