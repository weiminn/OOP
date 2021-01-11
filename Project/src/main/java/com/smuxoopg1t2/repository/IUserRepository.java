package com.smuxoopg1t2.repository;

import com.smuxoopg1t2.model.User;
import org.springframework.data.repository.CrudRepository;

public interface IUserRepository extends CrudRepository<User, Integer> {
    User findById(int id);

    User findByEmail(String email);
}