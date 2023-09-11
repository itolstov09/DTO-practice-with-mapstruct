package dev.tolstov.DTO.practice.with.mapstruct.DTO;

public record PostCreateRequest(
        UserModelDTO authorDTO,

        String text
) {
}
