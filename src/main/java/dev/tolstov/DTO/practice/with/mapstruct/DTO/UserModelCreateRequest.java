package dev.tolstov.DTO.practice.with.mapstruct.DTO;

public record UserModelCreateRequest(
        String nickname,

        String email,

        int age,

        String password
) {
}
