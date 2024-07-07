package org.task4.controller;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;
import org.task4.DTO.user.UserAddResponseDTO;
import org.task4.DTO.user.UserDTO;
import org.task4.DTO.user.UserRoleDTO;
import org.task4.DTO.user.UserWithIdDTO;
import org.task4.entity.User;
import org.task4.service.user.UserServiceAdd;
import org.task4.service.user.UserFindService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task4.service.user.UserUpdateService;


import java.util.List;

@RestController
@RequestMapping("/user")
@AllArgsConstructor
public class UserController {

    private final UserServiceAdd addUserService;
    private final UserFindService userFindService;
    private final UserUpdateService userUpdateService;


    @GetMapping({"/", ""})
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(userFindService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<UserAddResponseDTO> addUser(@RequestBody @Valid  UserDTO userDTO) {
        return new ResponseEntity<>(addUserService.addUser(userDTO), HttpStatus.CREATED);
    }
 @PostMapping("/update")
    public ResponseEntity<Boolean> updateUser(@RequestBody @Valid UserWithIdDTO user) {
        userUpdateService.EditUser(user);
        return  new ResponseEntity<>(true, HttpStatus.OK);
    }

    @PostMapping("/role")
    public ResponseEntity<Boolean> changeRoot(@RequestBody UserRoleDTO role){
        userUpdateService.changeRole(role);
        return  new ResponseEntity<>(true, HttpStatus.OK);
    }

}
