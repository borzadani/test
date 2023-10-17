package com.test.testopswat.data;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class EngineResults {
    private String engine;
    private String threatFound;
    private int scanResult;
    private String defTime;
}
