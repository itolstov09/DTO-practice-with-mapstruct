package dev.tolstov.DTO.practice.with.mapstruct.controller;

import dev.tolstov.DTO.practice.with.mapstruct.model.Post;
import dev.tolstov.DTO.practice.with.mapstruct.model.UserModel;
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
    public List<UserModel> findAll() {
        return userService.findAll();
    }

    @GetMapping("{id}")
    public UserModel findByUUID(@PathVariable(name = "id") UUID uuid) {
        return userService.findByUUID(uuid);
    }

    @PostMapping
    public UserModel createUser(@RequestBody UserModel userModel) {
        return userService.save(userModel);
    }

    @GetMapping("{id}/posts")
    public List<Post> findAllPosts(@PathVariable(name = "id") UUID uuid) {
        return postService.findAllByAuthorId(uuid);
    }


    @PostMapping("{id}/posts")
    public Post createPost(
            @PathVariable(name = "id") UUID authorUUID,
            @RequestBody Post post
    ) {
        UserModel userByID = userService.findByUUID(authorUUID);
        post.setAuthor(userByID);
        return postService.save(post);
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
