package com.ruisilva.workshopmongodb.services;

import com.ruisilva.workshopmongodb.domain.User;
import com.ruisilva.workshopmongodb.repository.UserRepository;
import com.ruisilva.workshopmongodb.resources.UserResource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }
}
