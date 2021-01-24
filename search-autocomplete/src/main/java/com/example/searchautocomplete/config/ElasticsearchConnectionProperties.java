package com.example.searchautocomplete.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Connection properties for elasticsearch
 */
@Data
@Component
@EnableConfigurationProperties
@ConfigurationProperties(prefix = "elasticsearch")
class ElasticsearchConnectionProperties {
    private String host;
    private String port;

}
