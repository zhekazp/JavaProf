package org.task3.controllers;

import org.springframework.http.HttpInputMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.task3.RequstDTO.RequestRootDTO;
import org.task3.RequstDTO.UserWithIdDTO;
import org.task3.entity.Roots;
import org.task3.entity.User;
import org.task3.entity.UserDTO;
import org.task3.services.user.AddUserService;
import org.task3.services.user.ChangeUserService;
import org.task3.services.user.FindUserService;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/user")
public class UserController {

    private final AddUserService addUserService;
    private final FindUserService findUserService;
    private final ChangeUserService changeUserService;

    public UserController(AddUserService addUserService, FindUserService findUserService, ChangeUserService changeUserService) {
        this.addUserService = addUserService;
        this.findUserService = findUserService;
        this.changeUserService = changeUserService;
    }

    @GetMapping("/")
    public ResponseEntity<List<User>> findAll() {
        return new ResponseEntity<>(findUserService.findAllUsers(), HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<Integer> addUser(@RequestBody UserDTO userDTO) {
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

    @GetMapping("/findn/{name}")
    public ResponseEntity<List<User>> getUserByName(@PathVariable String name) {
        List<User> users = findUserService.findUsersByName(name);

        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/remove/{id}")
    public ResponseEntity<Boolean> RemoveUser(@PathVariable Integer id) {

        return changeUserService.removeUser(id) ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/edit")
    public ResponseEntity<Boolean> editUser(@RequestBody UserWithIdDTO user) {
        return changeUserService.editUser(user) ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping("/root")
    public ResponseEntity<Boolean> changeRoot(@RequestBody RequestRootDTO dto) {

        return changeUserService.changeRoot(dto.getId(), dto.getRoot()) ? new ResponseEntity<>(HttpStatus.OK) :
                new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

}
