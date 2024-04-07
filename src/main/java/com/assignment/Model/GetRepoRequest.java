package com.assignment.Model;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class GetRepoRequest {
    private Integer page;
    private Integer size;
    private String creatingDate;
    private String language;
}
