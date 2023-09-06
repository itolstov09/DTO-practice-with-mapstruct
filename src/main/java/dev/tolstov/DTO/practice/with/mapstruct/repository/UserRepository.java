package dev.tolstov.DTO.practice.with.mapstruct.repository;

import dev.tolstov.DTO.practice.with.mapstruct.model.UserModel;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface UserRepository extends JpaRepository<UserModel, UUID> {
}
