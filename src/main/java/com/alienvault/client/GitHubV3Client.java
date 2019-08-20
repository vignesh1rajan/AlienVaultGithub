package com.alienvault.client;

import com.alienvault.client.data.Issue;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GitHubV3Client implements GitHubClient{


    private
    ObjectMapper mapper;

    private static final Logger log = LoggerFactory.getLogger(GitHubV3Client.class.getName());

    @Autowired
    public GitHubV3Client(ObjectMapper mapper) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper = mapper;
    }


    @Override
    public String getIssues(List<String> repos) {

        RestTemplate restTemplate = new RestTemplate();
        ResponseEntity<String> resp = restTemplate.getForEntity("https://api.github.com/repos/octocat/Hello-World/issues",String.class);
        String body = resp.getBody();


        List<Issue> issuesL = new ArrayList<>();
        try {
            issuesL = Arrays.asList(mapper.readValue(body, Issue[].class));

        } catch (Exception e) {
            log.error("error mapping object ", e);
        }
        issuesL.stream().forEach(s -> log.info(s.toString()));

        return "V3";
    }

}
