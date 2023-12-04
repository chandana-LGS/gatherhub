package com.ram.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ram.entity.User;

public interface UserRepository extends JpaRepository<User, Integer> {

	User findByUsername(String username);
}
