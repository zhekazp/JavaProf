package org.task4.service.user;

import org.task4.entity.User;
import org.task4.exeption.NotFoundException;
import org.task4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserFindService {
    UserRepository repository;

    public UserFindService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public User findUserById(int id) {
        return repository.findById(id)
                .orElseThrow(()
                        -> new NotFoundException("User with id " + id + " not found"));
    }
}
