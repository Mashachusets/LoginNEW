package org.example.service;

import org.example.models.User;
import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findUserById(Long id);

    User save(User user);
}