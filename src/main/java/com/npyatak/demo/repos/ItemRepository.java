package com.npyatak.demo.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.npyatak.demo.items.Item;

public interface ItemRepository extends JpaRepository<Item, Integer> {
    List<Item> findByForTeams(boolean forTeams);
}


