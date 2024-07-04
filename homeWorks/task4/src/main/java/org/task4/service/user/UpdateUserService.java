package org.task4.service.user;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task4.DTO.user.UserRoleDTO;
import org.task4.DTO.user.UserWithIdDTO;
import org.task4.entity.Role;
import org.task4.repository.RoleRepository;
import org.task4.repository.UserRepository;

import java.util.Optional;

@Service
@Transactional
public class UpdateUserService {
    UserRepository repository;
    RoleRepository roleRepository;
    public UpdateUserService(UserRepository repository, RoleRepository roleRepository) {
        this.repository = repository;
        this.roleRepository = roleRepository;
    }

    public boolean EditUser(UserWithIdDTO user){
       return repository.updateAllById(user) > 0;
    }

    public boolean changeRoot(UserRoleDTO role){
        Optional<Role> userRole = roleRepository.findByName(role.getRole());
        if (userRole.isPresent()){
            return repository.setUserRoot(userRole.get(), role.getId())>0;
        }
        return false;
    }

}
