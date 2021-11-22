package com.npyatak.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.npyatak.demo.Team;

@Repository
public interface TeamRepository extends JpaRepository<Team, String> {
}
