package com.assignment;

import com.assignment.service.RepoService;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.AutoConfigureMockMvc;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import static com.assignment.constant.Constants.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureMockMvc
class RepoControllerIntegrationTest {

    @Autowired
    private MockMvc mockMvc;

    @Autowired
    private RepoService repoService;

    @Test
    void whenGetPopularRepositories_thenReturnsValidResponse() throws Exception {
        mockMvc.perform(get("/api/repositories/popular")
                        .param("page", DEFAULT_PAGE_NUMBER.toString())
                        .param("size", DEFAULT_SIZE.toString())
                        .param("created-date", "2022-01-01"))
                .andExpect(status().isOk())
                .andExpect(content().contentType("application/json"))
                .andExpect(jsonPath("$.items").exists());
    }

    @Test
    public void whenConstraintViolation_thenReturnsBadRequest() throws Exception {
        mockMvc.perform(get("/api/repositories/popular")
                        .param("creatingDate", ""))
                .andExpect(status().isBadRequest());
    }

}

