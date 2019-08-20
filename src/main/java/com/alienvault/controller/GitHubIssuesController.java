package com.alienvault.controller;

import com.alienvault.service.GitHubService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class GitHubIssuesController {


    @Autowired
    GitHubService gitHubService;
    @GetMapping
    public String getIssues(){
        return gitHubService.callGetIssues();
    }
}
