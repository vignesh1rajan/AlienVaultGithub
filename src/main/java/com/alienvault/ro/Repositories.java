package com.alienvault.ro;

import com.fasterxml.jackson.annotation.JsonProperty;

import java.util.List;

public class Repositories {

    @JsonProperty("repositories")
    List<String> repositories;

    public Repositories(List<String> repositories) {
        this.repositories = repositories;
    }

    public Repositories() {

    }

    public List<String> getRepositories() {
        return repositories;
    }

    public void setRepositories(List<String> repositories) {
        this.repositories = repositories;
    }
}
