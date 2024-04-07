package com.assignment;

import com.assignment.Model.GetRepoRequest;
import com.assignment.Model.RepoResponse;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.assignment.client.RepoClient;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RepoClientIntegrationTest {

    @Autowired
    private RepoClient repoClient;

    @Test
    void givenValidRequest_whenGetPopularRepositories_thenShouldReturnNonNullResponse() {
        GetRepoRequest request =  GetRepoRequest.builder().page(1).size(10)
                .creatingDate("2022-01-01").language("Java").build();
        RepoResponse response = repoClient.getPopularRepositories(request);
        assertNotNull(response);
    }

}

