package org.task4.controller;

import org.task4.DTO.UserDTO;
import org.task4.DTO.UserWithIdDTO;
import org.task4.entity.User;
import org.task4.service.AddUserService;
import org.task4.service.FindUserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.task4.service.UpdateUserService;


import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AddUserService addUserService;
    private final FindUserService findUserService;
    private final UpdateUserService updateUserService;


    public UserController(AddUserService addUserService, FindUserService findUserService, UpdateUserService updateUserService) {
        this.addUserService = addUserService;
        this.findUserService = findUserService;
        this.updateUserService = updateUserService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(findUserService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<User> addUser(@RequestBody UserDTO userDTO) {
        System.out.println("addUser: " + userDTO.getName());
        return new ResponseEntity<>(addUserService.addUser(userDTO), HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<User> getUserById(@PathVariable Integer id) {
        Optional<User> user = findUserService.findUserById(id);
        if (user.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(user.get(), HttpStatus.OK);
    }

    @PostMapping("/update")
        public ResponseEntity<Boolean> updateUser(@RequestBody UserWithIdDTO user){
        System.out.println("addUser: " + user.getName());
            return updateUserService.EditUser(user)? new ResponseEntity<>(HttpStatus.OK) :
                    new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }






}