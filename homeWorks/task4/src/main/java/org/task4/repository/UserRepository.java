package org.task4.repository;


import org.springframework.stereotype.Repository;
import org.task4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
   }

