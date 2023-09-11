package dev.tolstov.DTO.practice.with.mapstruct.service;

import dev.tolstov.DTO.practice.with.mapstruct.DTO.UserModelCreateRequest;
import dev.tolstov.DTO.practice.with.mapstruct.DTO.UserModelDTO;
import dev.tolstov.DTO.practice.with.mapstruct.mappers.UserModelMapper;
import dev.tolstov.DTO.practice.with.mapstruct.model.UserModel;
import dev.tolstov.DTO.practice.with.mapstruct.repository.UserRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class UserService {
    private final UserRepository userRepository;
    private final UserModelMapper mapper;

    public UserService(
            UserRepository userRepository,
            UserModelMapper mapper
    ) {
        this.userRepository = userRepository;
        this.mapper = mapper;
    }

    public List<UserModelDTO> findAll() {
        return mapper.listToDTO(userRepository.findAll());
    }

    public UserModelDTO findByUUID(UUID uuid) {
        return mapper.toDTO(
                userRepository
                        .findById(uuid)
                        .orElseThrow(EntityNotFoundException::new)
        );
    }

    public UserModelDTO save(UserModelCreateRequest createRequest) {
        UserModel userModel = mapper.registrationRequestToUserModel(createRequest);
        UserModel saved = userRepository.save(userModel);
        return mapper.toDTO(saved);
    }
}
