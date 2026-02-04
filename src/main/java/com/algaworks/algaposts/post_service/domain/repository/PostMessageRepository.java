package com.algaworks.algaposts.post_service.domain.repository;

import com.algaworks.algaposts.post_service.domain.model.PostEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface PostMessageRepository extends JpaRepository<PostEntity, UUID> {
}
