package com.riwi.PruebaSpringBoot.infrastructure.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import com.riwi.PruebaSpringBoot.api.dto.request.UserRequest;
import com.riwi.PruebaSpringBoot.api.dto.response.UserResponse;
import com.riwi.PruebaSpringBoot.domain.entities.User;
import com.riwi.PruebaSpringBoot.domain.repositories.UserRepository;
import com.riwi.PruebaSpringBoot.infrastructure.abstract_services.IUserService;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class UserService implements IUserService{

    @Autowired
    private final UserRepository userRepository;

    @Override
    public UserResponse create(UserRequest request) {
        User user = this.requestToEntity(request);
        return this.entityToResponse(this.userRepository.save(user));
    }

    @Override
    public UserResponse get(Long id) {
        User user = this.find(id);
        return this.entityToResponse(user);
    }

    @Override
    public UserResponse update(UserRequest request, Long id) {

        User userUpdate = this.requestToEntity(request);
        userUpdate.setId(id);

        return this.entityToResponse(this.userRepository.save(userUpdate));
    }

    @Override
    public void delete(Long id) {
        User user = this.find(id);
        this.userRepository.delete(user);
    }

    @Override
    public Page<UserResponse> getAll(int page, int size) {

        if (page <0) page = 0;

        PageRequest pagination = PageRequest.of(page, size);

        return this.userRepository.findAll(pagination).map(this::entityToResponse);

    }
    
    private User find(Long id) {
        return this.userRepository.findById(id)
            .orElseThrow();
    }

    private UserResponse entityToResponse(User entity){

        return UserResponse.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .active(entity.isActive())
                .build();
    }

    private User requestToEntity(UserRequest entity){

        return User.builder()
                .id(entity.getId())
                .name(entity.getName())
                .email(entity.getEmail())
                .password(entity.getPassword())
                .active(entity.isActive())
                .build();
    }
}
