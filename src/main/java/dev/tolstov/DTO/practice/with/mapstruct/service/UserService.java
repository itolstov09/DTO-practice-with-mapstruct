package dev.tolstov.DTO.practice.with.mapstruct.service;

import dev.tolstov.DTO.practice.with.mapstruct.model.UserModel;
import dev.tolstov.DTO.practice.with.mapstruct.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<UserModel> findAll() {
        return userRepository.findAll();
    }

    public UserModel findByUUID(UUID uuid) {
        return userRepository
                .findById(uuid)
                .orElseThrow(EntityNotFoundException::new);
    }

    public UserModel save(UserModel userModel) {
        return userRepository.save(userModel);
    }
}
