package dev.tolstov.DTO.practice.with.mapstruct.controller;

import dev.tolstov.DTO.practice.with.mapstruct.DTO.PostCreateRequest;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.PostDTO;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.UserModelCreateRequest;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.UserModelDTO;
import dev.tolstov.DTO.practice.with.mapstruct.service.PostService;
import dev.tolstov.DTO.practice.with.mapstruct.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("users")
public class UserController {

    private final UserService userService;
    private final PostService postService;

    public UserController(
            UserService userService,
            PostService postService
    ) {
        this.userService = userService;
        this.postService = postService;
    }

    @GetMapping
    public List<UserModelDTO> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public UserModelDTO findByUUID(@PathVariable(name = "id") UUID uuid) {
        return userService.findByUUID(uuid);
    }

    @PostMapping
    public UserModelDTO createUser(@RequestBody UserModelCreateRequest createRequest) {
        return userService.save(createRequest);
    }

    @GetMapping("{id}/posts")
    public List<PostDTO> findAllPosts(@PathVariable(name = "id") UUID uuid) {
        return postService.findAllByAuthorId(uuid);
    }


    @PostMapping("{id}/posts")
    public PostDTO createPost(
            @PathVariable(name = "id") UUID authorUUID,
            @RequestBody PostCreateRequest createRequest
    ) {
        return postService.save(authorUUID, createRequest);
    }


    // TODO Реализовать позднее, когда будет реализован маппинг
//    @GetMapping("{user_id}/posts/{post_id}")
//    public Post getPostByUserIDAndPostID(
//            @PathVariable(name = "user_id") UUID userUUID,
//            @PathVariable(name = "post_id") UUID postUUID
//    ) {
//
//    }
}
