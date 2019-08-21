package com.alienvault.client.data;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;


@JsonIgnoreProperties(ignoreUnknown = true)
public class Issue {

    @JsonProperty("id")
    private String id;

    @JsonProperty("state")
    private String state;

    @JsonProperty("title")
    private String title;

    @JsonProperty("repository_url")
    public String repository;

    @JsonProperty("created_at")
    private String created_at;

    public Issue(){}

    public Issue(String id, String state, String title,
                 String created_at) {
        this.id = id;
        this.state = state;
        this.title = title;
        //this.repository = repository;
        this.created_at = created_at;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        String[] str  = repository.split("repos/");

        this.repository = str[1];
    }

    public String getCreated_at() {
        return created_at;
    }

    public void setCreated_at(String created_at) {
        this.created_at = created_at;
    }

    public LocalDate getCreated_atDate() {

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
        LocalDate date = LocalDate.parse(this.created_at.substring(0, 10), formatter);
        return date;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    @Override
    public String toString() {
        return "Issue{" +
                "id='" + id + '\'' +
                ", state='" + state + '\'' +
                ", title='" + title + '\'' +
                ", repository='" + repository + '\'' +
                ", created_at='" + created_at + '\'' +
                '}';
    }
}
