package com.alienvault.service;

import com.alienvault.client.GitHubClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Arrays;

@Service
public class GitHubService {

    @Autowired
    GitHubClient client;


    public String  callGetIssues(){
      return client.getIssues(Arrays.asList("one", "two"));

    }

}
