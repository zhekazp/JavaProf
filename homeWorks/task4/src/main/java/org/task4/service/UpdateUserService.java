package org.task4.service;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task4.DTO.UserWithIdDTO;
import org.task4.entity.User;
import org.task4.repository.UserRepository;

@Service
@Transactional
public class UpdateUserService {
    UserRepository repository;
    public UpdateUserService(UserRepository repository) {
        this.repository = repository;
    }

    public boolean EditUser(UserWithIdDTO user){
       return repository.updateAllById(user) > 0;

    }

}
