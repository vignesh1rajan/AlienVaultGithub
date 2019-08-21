package com.alienvault.client.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class IssueList implements Serializable {
    private long id;

    public IssueList(long id, List<Issue> issues) {
        this.id = id;
        this.issues = issues;
    }

    public IssueList(List<Issue> issues) {
        this.issues = issues;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    List<Issue> issues;
}
