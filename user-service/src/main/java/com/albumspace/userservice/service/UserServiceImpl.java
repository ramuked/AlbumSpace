package com.albumspace.userservice.service;

import com.albumspace.userservice.dto.UserDTO;
import com.albumspace.userservice.exception.CustomException;
import com.albumspace.userservice.mapper.UserMapper;
import com.albumspace.userservice.entity.User;
import com.albumspace.userservice.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCrypt;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.UUID;
@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public Optional<User> findUserByEmail(String email) {
        return userRepository.findByEmail(email);
    }

    @Override
    public Optional<User> findUserByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    @Override
    public User saveUser(User user) {
        return userRepository.save(user);
    }

    @Override
    public boolean existsByEmail(String email) {
        return userRepository.existsByEmail(email);
    }

    @Override
    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    @Override
    public UserDTO registerUser(UserDTO userDto) {
        if (userRepository.existsByEmail(userDto.getEmail())) {
            throw new CustomException("Email is already in use", "USER_EMAIL_EXISTS");
        }

        if (userRepository.existsByUsername(userDto.getUsername())) {
            throw new CustomException("Username is already in use", "USER_USERNAME_EXISTS");
        }

        String hashedPassword = hashPassword(userDto.getPassword());
        userDto.setPassword(hashedPassword);

        User userEntity = UserMapper.INSTANCE.toEntity(userDto);

        User savedUser = userRepository.save(userEntity);

        return UserMapper.INSTANCE.toDTO(savedUser);
    }

    private String hashPassword(String plainPassword) {
        // You can use BCrypt or any other password hashing algorithm
        return BCrypt.hashpw(plainPassword, BCrypt.gensalt());
    }
}
