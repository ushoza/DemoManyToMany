package com.npyatak.demo.service.interfaces;

import java.util.List;

import com.npyatak.demo.Team;
import com.npyatak.demo.User;
import com.npyatak.demo.items.Item;

public interface ItemManagment {
    List<Item> GetTeamItems();
    List<Item> GetUserItems();
    void AddItemTo(Item item, User user);
    void AddItemTo(Item item, Team team);
    Item GetIndexedItem(int index);
}
