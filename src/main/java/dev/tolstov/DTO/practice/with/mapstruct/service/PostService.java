package dev.tolstov.DTO.practice.with.mapstruct.service;

import dev.tolstov.DTO.practice.with.mapstruct.DTO.PostCreateRequest;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.PostDTO;
import dev.tolstov.DTO.practice.with.mapstruct.exception.AppException;
import dev.tolstov.DTO.practice.with.mapstruct.mappers.PostMapper;
import dev.tolstov.DTO.practice.with.mapstruct.model.Post;
import dev.tolstov.DTO.practice.with.mapstruct.model.UserModel;
import dev.tolstov.DTO.practice.with.mapstruct.repository.PostRepository;
import dev.tolstov.DTO.practice.with.mapstruct.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class PostService {
    private final PostRepository postRepository;
    private final UserRepository userRepository;
    private final PostMapper postMapper;

    public PostService(
            PostRepository postRepository,
            UserRepository userRepository,
            PostMapper mapper
    ) {
        this.postRepository = postRepository;
        this.userRepository = userRepository;
        this.postMapper = mapper;
    }

    public List<PostDTO> findAllByAuthorId(UUID authorUUID) {
        return postRepository
                .findAllByAuthor_uuid(authorUUID)
                .stream()
                .map(postMapper::toDTO)
                .collect(Collectors.toList());
    }

    public PostDTO save(UUID authorUUID, PostCreateRequest createRequest) {
        UserModel userByID = userRepository.findById(authorUUID).orElseThrow(EntityNotFoundException::new);

        Post post = postMapper.CreateRequestToPost(createRequest);
        post.setAuthor(userByID);
        Post saved = postRepository.save(post);

        return postMapper.toDTO(saved);
    }

    public PostDTO getPostByUserIDAndPostID(UUID userUUID, UUID postUUID) {
        UserModel userModel = userRepository.findById(userUUID).orElseThrow(EntityNotFoundException::new);
        Post post = postRepository.findById(postUUID).orElseThrow(EntityNotFoundException::new);

        if (!userModel.getUuid().equals(post.getAuthor().getUuid())) {
            throw new AppException(
                    String.format("User with id %s is not the author of post with id %s", userUUID, postUUID)
            );
        }

        return postMapper.toDTO(post);
    }
}
