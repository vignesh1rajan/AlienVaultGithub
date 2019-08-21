package com.alienvault.ro;

import com.alienvault.client.data.Issue;

import java.util.List;

public class IssueRO {

    List<Issue> issues;
    TopDay top_day;

    public IssueRO(List<Issue> issues, TopDay top_day) {
        this.issues = issues;
        this.top_day = top_day;
    }

    public List<Issue> getIssues() {
        return issues;
    }

    public void setIssues(List<Issue> issues) {
        this.issues = issues;
    }

    public TopDay getTop_day() {
        return top_day;
    }

    public void setTop_day(TopDay top_day) {
        this.top_day = top_day;
    }
}
