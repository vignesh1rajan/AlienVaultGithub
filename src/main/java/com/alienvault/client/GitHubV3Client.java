package com.alienvault.client;

import java.util.List;


public class GitHubV3Client implements GitHubClient{

    @Override
    public String getIssues(List<String> repos) {
        return "V3";
    }
}
