package com.assignment.client;

import com.assignment.Model.GetRepoRequest;
import com.assignment.Model.RepoResponse;
import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;
import io.github.resilience4j.retry.annotation.Retry;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestClient;
import org.springframework.web.util.UriComponentsBuilder;
import java.net.URI;
import static com.assignment.constant.Constants.*;


@Component
@Slf4j
public class RepoClient {

    @Value("${github.url}")
    private String url;
    private RestClient restClient;

    public RepoClient(RestClient restClient) {
        this.restClient = restClient;
    }

    @Retry(name = INSTANCE)
    @CircuitBreaker(name = INSTANCE)
    @Cacheable(cacheNames = {"popularRepositoriesCache"}, key = "#repoRequest")
    public RepoResponse getPopularRepositories(GetRepoRequest repoRequest) {
        log.debug(repoRequest.toString());
        RepoResponse response = restClient.get().uri(buildGitHubApiUrl(repoRequest)).retrieve().body(RepoResponse.class);
        log.debug(response.toString());
        return response;
    }

    private  URI buildGitHubApiUrl(GetRepoRequest repoRequest) {
        return UriComponentsBuilder.fromHttpUrl(url)
                .queryParam(SORT_KEY, SORT_VALUE)
                .queryParam(ORDER_KEY, ORDER_VALUE)
                .queryParam(PAGE_KEY, repoRequest.getPage())
                .queryParam(PER_PAGE_KEY, repoRequest.getSize())
                .queryParam(QUERY_KEY, CREATED_PREFIX
                        + repoRequest.getCreatingDate() + LANGUAGE_PREFIX
                        + repoRequest.getLanguage())
                .build().toUri();
    }
}
