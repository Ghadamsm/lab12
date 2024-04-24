package com.example.blog.Service;


import com.example.blog.Model.User;
import com.example.blog.Repository.AuthRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthService {

    private final AuthRepository authRepository;


    public void register(User user) {

        String hash = new BCryptPasswordEncoder().encode(user.getPassword());

        user.setPassword(hash);

        authRepository.save(user);

    }



    public void delete(Integer id){
        authRepository.deleteById(id);
    }


    public void updateUser(String username, User user){
        User user1 = authRepository.findUserByUsername(username);

        user1.setUsername(username);
        user1.setPassword(user.getPassword());

        authRepository.save(user1);


    }




    public List<User> getAllUser(){
        return authRepository.findAll();
    }

}
