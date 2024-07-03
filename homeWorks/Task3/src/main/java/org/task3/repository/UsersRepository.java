package org.task3.repository;

import org.springframework.stereotype.Repository;
import org.task3.entity.Roots;
import org.task3.entity.User;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Repository
public class UsersRepository implements UserRepository {
    HashMap<Integer, User> users = new HashMap<>();
    Integer currentUserId = 0;

    @Override
    public Integer addUser(User user) {
        user.setId(++currentUserId);
        users.put(currentUserId, user);
        return currentUserId;
    }

    @Override
    public Optional<User> getUser(Integer id) {
        User user = users.get(id);
        if (user != null) {
            return Optional.of(user);
        }
        return Optional.empty();
    }

    @Override
    public List<User> getUsersByUsername(String username) {
        return users.values().stream().filter(user -> user.getName().equals(username)).toList();
    }

    @Override
    public List<User> getAllUsers() {
        return users.values().stream().toList();
    }

    @Override
    public boolean removeUser(Integer id) {
        return users.remove(id) != null;
    }

    @Override
    public boolean updateUser(User user) {
        User oldUser = users.get(user.getId());
        if (oldUser != null) {
            user.setRoot(oldUser.getRoot());
            users.put(user.getId(), user);
            return true;
        }
        return false;
    }

    @Override
    public boolean setUserRoot(Integer id, Roots root) {
        User oldUser = users.get(id);
        if (oldUser != null) {
            oldUser.setRoot(root);
            return true;
        }
        return false;
    }
}
