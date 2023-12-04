package com.ram.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.ram.entity.User;

@Repository
public interface DarshanaUserRepository extends JpaRepository<User, Long> {
	List<User>findByUsername(String username);
}
