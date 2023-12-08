package com.springboot.utspraktikum.repository;

import com.springboot.utspraktikum.model.*;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
public interface UserRepository extends JpaRepository<User, Integer> {
	List<User> findByUsername(String username);
	List<User> findByPassword(String password);
}
