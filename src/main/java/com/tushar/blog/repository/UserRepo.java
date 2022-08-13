package com.tushar.blog.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.tushar.blog.entities.User;

public interface UserRepo extends JpaRepository<User, Integer> {

}
