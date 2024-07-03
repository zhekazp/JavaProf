package org.task3.services.user;

import org.springframework.stereotype.Repository;
import org.task3.RequstDTO.UserWithIdDTO;
import org.task3.entity.Roots;
import org.task3.entity.User;
import org.task3.entity.UserDTO;
import org.task3.repository.UserRepository;
import org.task3.repository.UsersRepository;

@Repository
public class ChangeUserService {
    private final UsersRepository usersRepository;
    UserRepository repository;

    public ChangeUserService(UserRepository repository, UsersRepository usersRepository) {
        this.repository = repository;
        this.usersRepository = usersRepository;
    }
    public boolean removeUser(Integer id) {
        return repository.removeUser(id);
    }
    public boolean editUser(UserWithIdDTO user) {
        User newUser = new User(user.getId(), user.getName(),
                user.getPassword(),
                user.getEmail(),
                user.getPhone(), Roots.USER);
        return repository.updateUser(newUser);
    }
    public boolean changeRoot(Integer id, Roots root){
        return usersRepository.setUserRoot(id, root);
    }
}
