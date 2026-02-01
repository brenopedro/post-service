package com.algaworks.algaposts.post_service.domain.repository;

import com.algaworks.algaposts.post_service.domain.model.PostEntity;
import com.algaworks.algaposts.post_service.domain.model.PostId;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PostMessageRepository extends JpaRepository<PostEntity, PostId> {
}
