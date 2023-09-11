package dev.tolstov.DTO.practice.with.mapstruct.DTO;

import java.util.UUID;

public record UserModelDTO(
        UUID uuid,

        String nickname,

        int age
) {
}
