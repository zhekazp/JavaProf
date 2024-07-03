package org.task4.service;

import org.task4.DTO.UserDTO;
import org.task4.entity.Roots;
import org.task4.entity.User;
import org.task4.repository.UserRepository;
import org.springframework.stereotype.Service;

@Service
public class AddUserService {
    UserRepository repository;

    public AddUserService(UserRepository repository) {
        this.repository = repository;
    }

    public User addUser(UserDTO user) {
        return  repository.saveAndFlush(new User(user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(), Roots.USER));
    }
}
