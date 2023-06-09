package com.codeup.codeupspringblog.repositories;

import com.codeup.codeupspringblog.models.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface UserRepository extends JpaRepository<User, Long>{

    List<User> findByUsername(String username);

    User findById(long id);

}
