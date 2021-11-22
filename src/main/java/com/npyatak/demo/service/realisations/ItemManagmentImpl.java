package com.npyatak.demo.service.realisations;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npyatak.demo.Team;
import com.npyatak.demo.User;
import com.npyatak.demo.items.Item;
import com.npyatak.demo.repos.ItemRepository;
import com.npyatak.demo.service.interfaces.ItemManagment;

@Service
public class ItemManagmentImpl implements ItemManagment
{

    @Autowired
    private ItemRepository itemRep;

    @Override
    public List<Item> GetTeamItems() {
        return itemRep.findByForTeams(true);
    }

    @Override
    public List<Item> GetUserItems() {
        return itemRep.findByForTeams(false);
    }

    @Override
    public Item GetIndexedItem(int index)
    {
        return null;
    }

    @Override
    public void AddItemTo(Item item, Team team)
    {

    }

    @Override
    public void AddItemTo(Item item, User user)
    {

    }

}
