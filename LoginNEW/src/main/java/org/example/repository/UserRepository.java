package org.example.repository;

import org.example.models.ERole;
import org.example.repository.model.UserDAO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
public interface UserRepository extends JpaRepository<UserDAO, Long> {

//    List<UserDAO> findByUsername(String username);
//
//    List<UserDAO> findByRoles(ERole roles);

    Boolean existsByUsername(String username);

    Boolean existsByEmail(String email);
}