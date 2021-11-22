package com.npyatak.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.npyatak.demo.Role;

public interface RoleRepository extends JpaRepository<Role, Integer> {
}
