package org.example.mapper;

import javax.annotation.Generated;
import org.example.models.User;
import org.example.repository.model.UserDAO;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2023-04-06T21:10:02+0300",
    comments = "version: 1.5.3.Final, compiler: javac, environment: Java 11.0.17 (Oracle Corporation)"
)
@Component
public class UserMapperImpl implements UserMapper {

    @Override
    public UserDAO mapToDAO(User user) {
        if ( user == null ) {
            return null;
        }

        UserDAO.UserDAOBuilder userDAO = UserDAO.builder();

        userDAO.id( user.getId() );
        userDAO.username( user.getUsername() );
        userDAO.email( user.getEmail() );
        userDAO.password( user.getPassword() );
        userDAO.roleType( user.getRoleType() );

        return userDAO.build();
    }

    @Override
    public User mapFromDAO(UserDAO userDAO) {
        if ( userDAO == null ) {
            return null;
        }

        User.UserBuilder user = User.builder();

        user.id( userDAO.getId() );
        user.username( userDAO.getUsername() );
        user.email( userDAO.getEmail() );
        user.password( userDAO.getPassword() );
        user.roleType( userDAO.getRoleType() );

        return user.build();
    }
}
