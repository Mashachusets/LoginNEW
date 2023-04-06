package org.example.mapper;

import org.example.models.User;
import org.example.repository.model.UserDAO;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface UserMapper {

    UserDAO mapToDAO(User user);

    User mapFromDAO(UserDAO userDAO);
}