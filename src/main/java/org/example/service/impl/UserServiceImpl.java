package org.example.service.impl;

import lombok.extern.log4j.Log4j2;
import org.example.mapper.UserMapper;
import org.example.models.ERole;
import org.example.models.User;
import org.example.repository.UserRepository;
import org.example.repository.model.UserDAO;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.*;
import java.util.stream.Collectors;

@Log4j2
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private UserMapper userMapper;

    @Autowired
    private PasswordEncoder encoder;

    @Autowired
    User user;

    @Override
    public List<User> findAll() {
        log.info("Retrieve list of user accounts");
        List<UserDAO> userDAOList = userRepository.findAll();
        if (userDAOList.isEmpty()) {
            log.warn("User account list is empty! {}", userDAOList);
            return null;
        }
        log.debug("User account list is found. Size: {}", userDAOList::size);
        return userDAOList.stream().map(userMapper::mapFromDAO).collect(Collectors.toList());
    }

    @Override
    public Optional<User> findUserById(Long id) {
        Optional<User> userById = userRepository.findById(id)
                .map(user -> (userMapper.mapFromDAO(user)));
        log.info("User account with id {} is {}", id, userById);
        return userById;
    }

    @Override
    public User save(User user) {
        user.setPassword(encoder.encode(user.getPassword()));
        if(user.getRoleType() == null) {
            user.setRoleType(ERole.USER);
        }
        log.info("Create new user account by passing : {}", user);
        UserDAO userSaved = userRepository.save(userMapper.mapToDAO(user));
        log.info("New account saved: {}", () -> userSaved);
        return userMapper.mapFromDAO(userSaved);
    }
}