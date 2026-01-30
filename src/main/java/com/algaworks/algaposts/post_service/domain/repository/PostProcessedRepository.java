package com.algaworks.algaposts.post_service.domain.repository;

import com.algaworks.algaposts.post_service.domain.model.PostProcessedInput;
import io.hypersistence.tsid.TSID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PostProcessedRepository extends JpaRepository<PostProcessedInput, TSID> {
}
