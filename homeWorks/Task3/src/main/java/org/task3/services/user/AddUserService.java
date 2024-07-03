package org.task3.services.user;

import org.springframework.stereotype.Service;
import org.task3.entity.Roots;
import org.task3.entity.User;
import org.task3.entity.UserDTO;
import org.task3.repository.UserRepository;

@Service
public class AddUserService {
    UserRepository repository;

    public AddUserService(UserRepository repository) {
        this.repository = repository;
    }

    public Integer addUser(UserDTO dto) {
       return repository.addUser(new User(dto.getName(),
                dto.getPassword(),
                dto.getEmail(),
                dto.getPhone(), Roots.USER));
    }
}
