package com.albumspace.userservice.service;
import com.albumspace.userservice.dto.UserDTO;
import com.albumspace.userservice.entity.User;
import java.util.Optional;

public interface UserService {

    Optional<User> findUserByEmail(String email);

    Optional<User> findUserByUsername(String username);

    User saveUser(User user);

    boolean existsByEmail(String email);

    boolean existsByUsername(String username);
    public UserDTO registerUser(UserDTO userDto);

}
