package com.example.searchautocomplete.config;

import lombok.RequiredArgsConstructor;
import org.elasticsearch.client.RestHighLevelClient;
import org.springframework.context.annotation.Bean;
import org.springframework.data.elasticsearch.client.ClientConfiguration;
import org.springframework.data.elasticsearch.client.RestClients;
import org.springframework.stereotype.Component;

/**
 * Connection configuration for elasticsearch
 */
@Component
@RequiredArgsConstructor
public class ElasticsearchConfig {
    private final ElasticsearchConnectionProperties connectionProperties;

    @Bean
    public RestHighLevelClient elasticsearchClient() {

        final ClientConfiguration clientConfiguration = ClientConfiguration.builder()
                .connectedTo(connectionProperties.getHost() + ":"  +connectionProperties.getPort())
                .build();

        return RestClients.create(clientConfiguration).rest();
    }
}
