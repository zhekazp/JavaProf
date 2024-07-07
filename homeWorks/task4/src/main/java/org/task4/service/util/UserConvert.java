package org.task4.service.util;

import org.springframework.stereotype.Service;
import org.task4.DTO.user.UserDTO;
import org.task4.DTO.user.UserWithIdDTO;
import org.task4.entity.Role;
import org.task4.entity.User;

@Service
public class UserConvert {
    public User fromDTOtoUser(UserDTO user, Role role) {
        return   new User(user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(), role);
    }
    public User fromIdDTOtoUser(UserWithIdDTO user, Role role) {
        return   new User(user.getId(), user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(), role);
    }
}
