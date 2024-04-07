package com.assignment;

import com.assignment.Model.GetRepoRequest;
import com.assignment.Model.RepoResponse;
import com.assignment.client.RepoClient;
import com.assignment.service.RepoService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class RepoServiceTest {

    @Mock
    private RepoClient repoClient;

    @InjectMocks
    private RepoService repoService;

    @BeforeEach
    public void setUp() {
        repoService = new RepoService(repoClient);
    }

    @Test
    public void whenGetPopularRepositoriesCalledWithValidValue_ThenRepoClientInvokedOnceWithValidResponse() {
        GetRepoRequest request = GetRepoRequest.builder()
                .page(1)
                .size(10)
                .creatingDate("2022-01-01")
                .language("Java")
                .build();
        RepoResponse expectedResponse = new RepoResponse();
        when(repoClient.getPopularRepositories(request)).thenReturn(expectedResponse);
        RepoResponse actualResponse = repoService.getPopularRepositories(request);
        verify(repoClient, times(1)).getPopularRepositories(request);
        assertEquals(expectedResponse, actualResponse);
    }
}

