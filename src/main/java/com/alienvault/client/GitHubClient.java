package com.alienvault.client;

import com.alienvault.client.data.IssueList;

import java.util.List;

public interface GitHubClient {
    IssueList getIssues(List<String> repos);
}
