package org.task4.service.user;

import org.task4.DTO.user.UserDTO;
import org.task4.entity.Role;
import org.task4.entity.User;

import org.task4.repository.RoleRepository;
import org.task4.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.task4.service.util.UserConvert;

@Service
public class AddUserService {
    UserRepository repository;
    RoleRepository roleRepository;
    UserConvert userConvert;

    public AddUserService(UserRepository repository, RoleRepository roleRepository, UserConvert userConvert) {
        this.repository = repository;
        this.roleRepository = roleRepository;
        this.userConvert = userConvert;
    }

    public User addUser(UserDTO user) {
        Role role =roleRepository.findByName("USER").get();
        return  repository.saveAndFlush(userConvert.fromDTOtoUser(user, role));
    }
}
