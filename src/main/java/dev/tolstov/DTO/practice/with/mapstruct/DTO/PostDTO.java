package dev.tolstov.DTO.practice.with.mapstruct.DTO;

import java.util.UUID;

public record PostDTO(
        UUID uuid,

        UserModelDTO authorDTO,

        String text
) {
}
