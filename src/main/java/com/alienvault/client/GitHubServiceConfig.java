package com.alienvault.client;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

import javax.annotation.Resource;

@Configuration
public class GitHubServiceConfig {
    @Bean
    @Primary
    public GitHubClient getClient(){
        return new GitHubV3Client();
    }

    @Bean
    @Resource(name = "V4Client")
    public GitHubClient getV4Client(){
        return new GitHubV4Client();
    }
}
