package com.alienvault.client;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

@Configuration
public class GitHubServiceConfig {

    private final
    ObjectMapper mapper;

    @Autowired
    public GitHubServiceConfig(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    @Bean
    @Primary
    public GitHubClient getClient() {
        return new GitHubV3Client(mapper);
    }

    @Bean
    @Qualifier("V4Client")
    public GitHubClient getV4Client() {
        return new GitHubV4Client();
    }
}
