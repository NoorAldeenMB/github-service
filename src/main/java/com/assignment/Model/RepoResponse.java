package com.assignment.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.Data;
import java.util.List;


@Data
public class RepoResponse {
    @JsonAlias("items")
    private List<Repository> repositories;
}
