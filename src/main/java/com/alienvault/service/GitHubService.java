package com.alienvault.service;

import com.alienvault.client.GitHubClient;
import com.alienvault.client.data.Issue;
import com.alienvault.client.data.IssueList;
import com.alienvault.ro.IssueRO;
import com.alienvault.ro.TopDay;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.function.Predicate;
import java.util.stream.Collectors;

@Service
public class GitHubService {

    private final GitHubClient client;

    private static final Logger log = LoggerFactory.getLogger(GitHubService.class.getName());

    @Autowired
    public GitHubService(GitHubClient client) {
        this.client = client;
    }


    public IssueRO callGetIssues(List<String> repos) {

        IssueList issueList = client.getIssues(repos);


        // Sort by LocalDate Field - O(nlog(n))
        issueList.getIssues().sort(
                Comparator.comparing(Issue::getCreated_atDate));

        // Map by Date and count
        Map<LocalDate, Long> issuePerDayMap = issueList.getIssues().stream()
                .peek(issue -> log.info(issue.toString()))
                .collect(Collectors.groupingBy(Issue::getCreated_atDate, Collectors.counting()));


        // Find Top issue day
        Optional<Map.Entry<LocalDate, Long>> maxEntry = issuePerDayMap.entrySet().stream().max(Comparator.comparing(Map.Entry::getValue));
        LocalDate topDate = maxEntry.get().getKey();

        // maxEntry.ifPresent(entry -> log.info("max entry " + entry.getKey().toString() + entry.getValue()));

        // List<Issue> topIssues = issueList.getIssues().stream().filter(issue -> issue.getCreated_atDate().equals(maxEntry.get().getKey())).collect(Collectors.toList());


        // Get list to repos, and count by the top issue date
        Map<String, Long> repoCount = issueList.getIssues().stream().filter(isTopDay(topDate)).collect(Collectors.groupingBy(Issue::getRepository, Collectors.counting()));


        TopDay topDay = new TopDay(maxEntry.get().getKey().toString(), repoCount);
        IssueRO issueRO = new IssueRO(issueList.getIssues(), topDay);


        return issueRO;

    }

    public Predicate<Issue> isTopDay(LocalDate topDay) {
        return s -> s.getCreated_atDate().isEqual(topDay);
    }
}
