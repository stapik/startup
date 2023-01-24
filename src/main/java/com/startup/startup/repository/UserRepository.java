package com.startup.startup.repository;

import com.startup.startup.entity.User;
import org.springframework.data.repository.Repository;

public interface UserRepository extends Repository<User, Long> {

    User findByUsername(String username);
}
