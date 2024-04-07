package com.assignment.Model;

import com.fasterxml.jackson.annotation.JsonAlias;
import lombok.*;


@Getter
@ToString
public class Repository {
    private Long id;
    private String name;
    @JsonAlias("full_name")
    private String fullName;
    private Owner owner;
    private License license;
    private String description;
    private String url;
    private String language;

}
