package com.assignment.Model;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.util.List;


public class RepoResponse {
    @JsonProperty("items")
    private List<Repository> repositories;
}
