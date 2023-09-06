package dev.tolstov.DTO.practice.with.mapstruct.repository;

import dev.tolstov.DTO.practice.with.mapstruct.model.Post;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

public interface PostRepository extends JpaRepository<Post, UUID> {
    List<Post> findAllByAuthor_uuid(UUID authorUUID);
}
