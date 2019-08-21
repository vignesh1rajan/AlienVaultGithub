package com.alienvault.controller;

import com.alienvault.ro.IssueRO;
import com.alienvault.ro.Repositories;
import com.alienvault.service.GitHubService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;

@RestController
public class GitHubIssuesController {


    @Autowired
    GitHubService gitHubService;

    private static final Logger log = LoggerFactory.getLogger(GitHubIssuesController.class.getName());

    @GetMapping
    public IssueRO getIssues() {

        return gitHubService.callGetIssues(Arrays.asList("octocat/Hello-World", "octocat/Hello-World"));
    }

    @PostMapping
    public IssueRO getIssuesPerRepo(@RequestBody Repositories repos) {

        repos.getRepositories().stream().forEach(s -> log.info(s));

        return gitHubService.callGetIssues(repos.getRepositories());
    }
}
