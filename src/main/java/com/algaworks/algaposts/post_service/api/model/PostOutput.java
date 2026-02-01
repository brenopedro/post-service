package com.algaworks.algaposts.post_service.api.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import io.hypersistence.tsid.TSID;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class PostOutput {

    private TSID id;
    private String title;
    private String body;
    private String author;
    private Integer wordCount;
    private Double calculatedValue;
}
