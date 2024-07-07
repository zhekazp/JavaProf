package org.task4.service.user;

import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.task4.DTO.user.UserRoleDTO;
import org.task4.DTO.user.UserWithIdDTO;
import org.task4.entity.Role;
import org.task4.entity.User;
import org.task4.exeption.NotFoundException;
import org.task4.repository.RoleRepository;
import org.task4.repository.UserRepository;
import org.task4.service.util.UserConvert;

@Service
@Transactional
@AllArgsConstructor
public class UserUpdateService {
    UserRepository repository;
    RoleRepository roleRepository;
    UserConvert userConvert;
    UserFindService userFindService;

    public void EditUser(UserWithIdDTO user) {
        User oldUser = userFindService.findUserById(user.getId());
        User newUser = userConvert.fromIdDTOtoUser(user, oldUser.getRole());
        repository.save(newUser);
    }

    public void changeRole(UserRoleDTO roleDTO) {
        User newUser = userFindService.findUserById(roleDTO.getUserId());
        Role role = roleRepository.findByName(roleDTO.getRole())
                .orElseThrow(()->new NotFoundException("Role with name: "+roleDTO.getRole()+" not found"));
        newUser.setRole(role);
        repository.save(newUser);
    }



}
