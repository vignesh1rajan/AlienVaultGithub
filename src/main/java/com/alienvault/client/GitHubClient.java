package com.alienvault.client;

import java.util.List;

public interface GitHubClient {
    String getIssues(List<String> repos);
}
