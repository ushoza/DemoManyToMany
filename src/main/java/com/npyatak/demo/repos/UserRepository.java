package com.npyatak.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npyatak.demo.User;

public interface UserRepository extends JpaRepository<User, String> {
}
