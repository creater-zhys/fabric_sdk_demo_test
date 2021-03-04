package com.example.demo.repositorys;

import com.example.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;

@Repository
public interface UserRepository extends JpaRepository<User, String> {
    User findUserByName(String name);

    @Transactional
    @Modifying
    @Query(value = "insert into user(name, email, telephone, user_type_enum, is_admin, password)" +
            " values(:#{#user.name},:#{#user.email},:#{#user.telephone},:#{#user.userTypeEnum},false,null)",
            nativeQuery = true)
    void insert(@Param("user") User user);

    @Transactional
    @Modifying
    @Query("update User u set u.password = :password where u.name = :name")
    int changePassword(@Param("name") String name, @Param("password") String password);
}
