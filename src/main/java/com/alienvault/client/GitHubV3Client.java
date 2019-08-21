package com.alienvault.client;

import com.alienvault.client.data.Issue;
import com.alienvault.client.data.IssueList;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class GitHubV3Client implements GitHubClient {


    private static final Logger log = LoggerFactory.getLogger(GitHubV3Client.class.getName());
    private ObjectMapper mapper;
    private static final String baseUrl = "https://api.github.com/repos/";

    @Autowired
    public GitHubV3Client(ObjectMapper mapper) {
        mapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        this.mapper = mapper;
    }


    @Override
    public IssueList getIssues(List<String> repos) {

        RestTemplate restTemplate = new RestTemplate();
        IssueList issueList = new IssueList(new ArrayList<>());

        for (String repo : repos) {
            String url = baseUrl + repo + "/issues";
            log.info("calling url {}", url);

            HttpHeaders headers = new HttpHeaders();
            headers.add(
                    "Authorization", "token 68a33323a770d2d196b0d463b58a1a79013f077");
            ResponseEntity<String> resp = restTemplate.getForEntity(baseUrl + repo + "/issues", String.class, headers);

            String body = resp.getBody();

            log.info("Response body " + body);
            List<Issue> issues = new ArrayList<>();
            try {

                issues = Arrays.asList(mapper.readValue(body, Issue[].class));
                issueList.getIssues().addAll(issues);

            } catch (Exception e) {
                log.error("error mapping object ", e);
            }
        }

        return issueList;
    }

}
