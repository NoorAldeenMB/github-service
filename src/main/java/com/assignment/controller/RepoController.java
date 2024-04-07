package com.assignment.controller;

import com.assignment.Model.GetRepoRequest;
import com.assignment.Model.RepoResponse;
import com.assignment.constant.Constants;
import com.assignment.service.RepoService;
import jakarta.validation.constraints.NotEmpty;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
@Validated
public class RepoController {

    private final RepoService repoService;

    public RepoController(RepoService repoService) {
        this.repoService = repoService;
    }

    @GetMapping("/repositories/popular")
    public RepoResponse getPopularRepositories(
            @RequestParam(defaultValue = Constants.DEFAULT_PAGE_NUMBER) Integer page,
            @RequestParam(defaultValue = Constants.DEFAULT_SIZE) Integer size,
            @RequestParam(name = "created-date") @NotEmpty(message = Constants.CREATING_DATE) String creatingDate,
            @RequestParam(required = false) String language) {
        return repoService.getPopularRepositories(GetRepoRequest.builder().page(page).size(size)
                .creatingDate(creatingDate).language(language).build());
    }
}


