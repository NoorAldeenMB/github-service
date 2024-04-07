package com.assignment.service;

import com.assignment.Model.GetRepoRequest;
import com.assignment.Model.RepoResponse;
import com.assignment.client.RepoClient;
import org.springframework.stereotype.Service;

@Service
public class RepoService {

    private RepoClient repoClient;

    public RepoService(RepoClient repoClient) {
        this.repoClient = repoClient;
    }

    public RepoResponse getPopularRepositories(GetRepoRequest repoRequest) {
     return repoClient.getPopularRepositories(repoRequest);
    }
}
