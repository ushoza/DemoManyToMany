package com.npyatak.demo.service.interfaces;

import com.npyatak.demo.Team;
import com.npyatak.demo.items.Item;

public interface TeamManagment {
    TeamRequestResult createTeam(String admin_username, String team_name);
    TeamRequestResult addUser(String team_name, String user_name);
    TeamRequestResult removeFromTeam(String user_name);
    TeamRequestResult deleteTeam(Team team);
    Team getTeam(String name);
    TeamRequestResult BuyItem(Team team, Item item);
}
