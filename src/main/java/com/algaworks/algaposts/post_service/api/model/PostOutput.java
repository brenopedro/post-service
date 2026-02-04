package com.algaworks.algaposts.post_service.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostOutput {

    private UUID id;
    private String title;
    private String body;
    private String author;
    private Integer wordCount;
    private Double calculatedValue;
}
