package com.example.blog.Repository;


import com.example.blog.Model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AuthRepository extends JpaRepository<User, Integer> {
    User findUserById(Integer id);

    User findUserByUsername(String username);
}
