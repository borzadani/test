package com.test.testopswat.properties;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.validation.annotation.Validated;

import javax.validation.constraints.NotBlank;

@Data
@Configuration
@ConfigurationProperties("meta")
@Validated
public class MetaProperties {
    @NotBlank
    private String fileUploadUrl;
    @NotBlank
    private String hashLookupUrl;
    @NotBlank
    private String resultLookupUrl;
    @NotBlank
    private String apiKey;
}
