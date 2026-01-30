package com.algaworks.algaposts.post_service.domain.model;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
public class PostProcessedInput {

    @Id
    @AttributeOverride(name = "value", column = @Column(name = "id", columnDefinition = "BIGINT"))
    private PostId postId;
    private Integer wordCount;
    private Double calculatedValue;
}
