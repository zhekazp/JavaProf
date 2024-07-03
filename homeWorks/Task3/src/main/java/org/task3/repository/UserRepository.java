package org.task3.repository;

import org.task3.entity.Roots;
import org.task3.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserRepository {
    public Integer addUser(User user);
    public Optional<User> getUser(Integer id);
    public List<User> getUsersByUsername(String username);
    public List<User> getAllUsers();
    public boolean removeUser(Integer id);
    public boolean updateUser(User user);
    public boolean setUserRoot(Integer id, Roots root);
}
