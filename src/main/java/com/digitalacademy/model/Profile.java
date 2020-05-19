package com.digitalacademy.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.databind.PropertyNamingStrategy;
import com.fasterxml.jackson.databind.annotation.JsonNaming;
import lombok.Data;

@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonNaming(PropertyNamingStrategy.SnakeCaseStrategy.class)
public class Profile {
    private Long id;
    private String username;
    private String firstName;
    private String lastName;
    private int age;
    private String telephone;
    private String graduatedForm;
    private double grade;
    private String major;
    private String job;
}
