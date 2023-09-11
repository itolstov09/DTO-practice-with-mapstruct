package dev.tolstov.DTO.practice.with.mapstruct.mappers;

import dev.tolstov.DTO.practice.with.mapstruct.DTO.PostCreateRequest;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.PostDTO;
import dev.tolstov.DTO.practice.with.mapstruct.model.Post;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface PostMapper {

    @Mapping(target = "authorDTO", source = "author")
    PostDTO toDTO(Post post);

    @Mapping(target = "author", ignore = true)
    Post CreateRequestToPost(PostCreateRequest createRequest);
}
