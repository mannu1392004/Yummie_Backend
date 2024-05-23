package com.example.Yummie.services;
import com.example.Yummie.entity.User;
import com.example.Yummie.repository.UserRepository;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean existsByUsername(String username) {
        return userRepository.existsByUsername(username);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public Optional<User> FindByID(ObjectId id){
       return   userRepository.findById(id);
    }




}

