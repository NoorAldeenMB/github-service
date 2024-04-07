package com.assignment;

import com.assignment.Model.GetRepoRequest;
import com.assignment.Model.RepoResponse;
import com.assignment.controller.RepoController;
import com.assignment.service.RepoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;


import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RepoControllerTest {

    @Mock
    private RepoService repoService;

    @InjectMocks
    private RepoController repoController;

    @Test
    void whenGetPopularRepositoriesWithValidParams_thenReturnsValidResponse() {
        int page = 1;
        int size = 10;
        String since = "2020-01-01";
        String language = "Java";

        RepoResponse expectedResponse = new RepoResponse();
        when(repoService.getPopularRepositories(any(GetRepoRequest.class))).thenReturn(expectedResponse);
        RepoResponse actualResponse = repoController.getPopularRepositories(page, size, since, language);
        assertEquals(expectedResponse, actualResponse);
        verify(repoService).getPopularRepositories(refEq(GetRepoRequest.builder().page(page).size(size).creatingDate(since).language(language).build()));
    }

}

