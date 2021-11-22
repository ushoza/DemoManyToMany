package com.npyatak.demo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.npyatak.demo.items.Item;

@Entity
@Table(name="Teams")
public class Team{

    @Id
    @Column(name = "team_name")
    private String team_name;

    @Column(name="click_count")
    private long click_count = 0;

    @OneToOne
    @JoinColumn(name="admin")
    private User admin;

    @OneToMany(mappedBy="current_team")
    private List<User> users;

    @ManyToMany
    @JoinTable(name="team_items", joinColumns = @JoinColumn(name = "team_id"), inverseJoinColumns = @JoinColumn(name=
            "item_id"))
    private List<Item> items;

    /*@OneToMany(mappedBy = "owner")
    private List<items_teams> items;*/

    public Team() {
    }

    public List<Item> getItems()
    {
        return items;
    }

    public String getTeam_name() {
        return team_name;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    public void setTeam_name(String team_name) {
        this.team_name = team_name;
    }

    public long getClick_count() {
        return click_count;
    }

    public void setClick_count(long click_count) {
        this.click_count = click_count;
    }

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

  /*  public List<items_teams> getItems() {
        return items;
    }*/

 /*   public void setItems(List<items_teams> items) {
        this.items = items;
    }*/

    public List<User> getUsers() {
        return users;
    }
}
