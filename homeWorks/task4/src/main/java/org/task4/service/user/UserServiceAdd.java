package org.task4.service.user;

import lombok.AllArgsConstructor;
import org.task4.DTO.user.UserAddResponseDTO;
import org.task4.DTO.user.UserDTO;
import org.task4.entity.Role;

import org.task4.repository.RoleRepository;
import org.task4.repository.UserRepository;
import org.springframework.stereotype.Service;
import org.task4.service.util.UserConvert;

@Service
@AllArgsConstructor
public class UserServiceAdd {
    UserRepository repository;
    RoleRepository roleRepository;
    UserConvert userConvert;



    public UserAddResponseDTO addUser(UserDTO user) {
        Role role =roleRepository.findByName("USER").get();
        return new UserAddResponseDTO(repository.save(userConvert.fromDTOtoUser(user, role)).getId());
    }
}
