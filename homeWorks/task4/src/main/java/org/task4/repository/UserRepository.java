package org.task4.repository;

import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.task4.DTO.user.UserWithIdDTO;
import org.task4.entity.Role;
import org.task4.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    @Modifying
   @Query("UPDATE User u set u.name = :#{#user.name}, u.password = :#{#user.password}," +
            "u.email =:#{#user.email}, u.phone = :#{#user.phone} where u.id= :#{#user.id}")
//    @Query("UPDATE User u set u.name = :name where u.id= :id")
//    int updateAllById(@Param("name") String  name, @Param("id") Integer id);
    int updateAllById(@Param("user") UserWithIdDTO user);
    @Modifying
    @Query("UPDATE User u set u.role = :role where u.id = :id")
    int setUserRoot(@Param("role") Role role, @Param("id") Integer id);
}

