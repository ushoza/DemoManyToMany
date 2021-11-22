package com.npyatak.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npyatak.demo.Role;
import com.npyatak.demo.items.AddItem;
import com.npyatak.demo.items.MultiplayItem;
import com.npyatak.demo.repos.ItemRepository;
import com.npyatak.demo.repos.RoleRepository;

@Service
public class DatabaseInit {

    @Autowired
    private ItemRepository itemRepository;
    private RoleRepository roleRepository;

    public void Init(){
        AddItems();
        AddRoles();
    }

    private void AddRoles(){
        roleRepository.save(Role.getLeader());
        roleRepository.save(Role.getUser());
    }

    private void AddItems(){
        itemRepository.save(new AddItem(1, "+1", "добавляет 1 клику", false, 10));
        itemRepository.save(new MultiplayItem(0.1, "+10%", "добавляет 10% к клику", true, 50));
    }
}
