package org.task3.services.user;

import org.springframework.stereotype.Service;
import org.task3.entity.User;
import org.task3.repository.UserRepository;

import java.util.List;
import java.util.Optional;

@Service
public class FindUserService {
    UserRepository repository;

    public FindUserService(UserRepository repository) {
        this.repository = repository;
    }

    public Optional<User> findUserById(int id) {
        return repository.getUser(id);
    }

    public List<User> findUsersByName(String name) {
        return repository.getUsersByUsername(name);
    }

    public List<User> findAllUsers() {
        return repository.getAllUsers();
    }
}
