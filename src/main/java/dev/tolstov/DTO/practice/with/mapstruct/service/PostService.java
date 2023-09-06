package dev.tolstov.DTO.practice.with.mapstruct.service;

import dev.tolstov.DTO.practice.with.mapstruct.model.Post;
import dev.tolstov.DTO.practice.with.mapstruct.repository.PostRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class PostService {
    private final PostRepository postRepository;

    public PostService(PostRepository postRepository) {
        this.postRepository = postRepository;
    }

    public List<Post> findAllByAuthorId(UUID authorUUID) {
        return postRepository.findAllByAuthor_uuid(authorUUID);
    }

    public Post save(Post post) {
        return postRepository.save(post);
    }
}
