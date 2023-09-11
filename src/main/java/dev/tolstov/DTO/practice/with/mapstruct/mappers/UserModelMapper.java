package dev.tolstov.DTO.practice.with.mapstruct.mappers;

import dev.tolstov.DTO.practice.with.mapstruct.DTO.UserModelCreateRequest;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.UserModelDTO;
import dev.tolstov.DTO.practice.with.mapstruct.model.UserModel;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserModelMapper {

    UserModel registrationRequestToUserModel(UserModelCreateRequest request);

    UserModelDTO toDTO(UserModel userModel);
}
