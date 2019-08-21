package com.alienvault.service;

import com.alienvault.client.GitHubClient;
import com.alienvault.client.data.Issue;
import com.alienvault.client.data.IssueList;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    private final GitHubClient client;

    private static final Logger log = LoggerFactory.getLogger(GitHubService.class.getName());

    @Autowired
    public GitHubService(GitHubClient client) {
        this.client = client;
    }


    public String  callGetIssues(){

        IssueList issueList = client.getIssues(Arrays.asList("octocat/Hello-World", "octocat/Hello-World"));

        issueList.getIssues().sort(
                Comparator.comparing( Issue::getCreated_atDate));


        Map<LocalDate, Long> s = issueList.getIssues().stream().peek(issue -> log.info(issue.toString())).collect(Collectors.groupingBy(Issue::getCreated_atDate, Collectors.counting()));

        s.entrySet().stream().peek(stringLongEntry -> log.info(stringLongEntry.getKey() + "   "+stringLongEntry.getValue())).count();
        return issueList.toString();

    }


}
