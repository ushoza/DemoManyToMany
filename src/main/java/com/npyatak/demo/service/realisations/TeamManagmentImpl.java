package com.npyatak.demo.service.realisations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.npyatak.demo.Team;
import com.npyatak.demo.items.Item;
import com.npyatak.demo.repos.TeamRepository;
import com.npyatak.demo.repos.UserRepository;
import com.npyatak.demo.service.interfaces.ItemManagment;
import com.npyatak.demo.service.interfaces.TeamManagment;
import com.npyatak.demo.service.interfaces.TeamRequestResult;

@Service
public class TeamManagmentImpl implements TeamManagment
{

    private TeamRepository teamRep;
    private UserRepository userRep;
    private ItemManagment itemManagment;


    @Autowired
    public TeamManagmentImpl(TeamRepository teamRep, UserRepository userRep, ItemManagment itemManagment) {
        this.teamRep = teamRep;
        this.userRep = userRep;
        this.itemManagment = itemManagment;
    }

    @Override
    public TeamRequestResult createTeam(String admin_username, String team_name)
    {
        return null;
    }

    @Override
    public TeamRequestResult addUser(String team_name, String user_name)
    {
        return null;
    }

    @Override
    public TeamRequestResult removeFromTeam(String user_name)
    {
        return null;
    }

    @Override
    public TeamRequestResult deleteTeam(Team team)
    {
        return null;
    }

    @Override
    public Team getTeam(String name)
    {
        return null;
    }

    @Override
    public TeamRequestResult BuyItem(Team team, Item item)
    {
        return null;
    }
}
