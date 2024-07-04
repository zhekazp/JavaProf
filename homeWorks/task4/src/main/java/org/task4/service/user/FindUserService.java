package org.task4.service.user;

import org.task4.entity.User;
import org.task4.repository.UserRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class FindUserService {
    UserRepository repository;

    public FindUserService(UserRepository repository) {
        this.repository = repository;
    }

    public List<User> findAllUsers() {
        return repository.findAll();
    }

    public Optional<User> findUserById(int id) {
        return repository.findById(id);
    }
}
