package com.alienvault.client;

import com.alienvault.client.data.IssueList;

import java.util.ArrayList;
import java.util.List;

public class GitHubV4Client implements GitHubClient {
    @Override
    public IssueList getIssues(List<String> repos) {
        return new IssueList(new ArrayList<>());
    }
}
