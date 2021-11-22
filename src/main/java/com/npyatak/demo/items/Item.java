package com.npyatak.demo.items;

import java.util.List;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.DiscriminatorType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import com.npyatak.demo.Team;
import com.npyatak.demo.User;

/**
 *
 * @author npyatak
 * @since 19.11.2021
 */
@Entity
@Table(name = "Items")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "type", discriminatorType = DiscriminatorType.STRING)
public abstract class Item
{

    public Item()
    {
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;

    @ManyToMany(mappedBy = "items")
    private List<User> users;

    @ManyToMany(mappedBy = "items")
    private List<Team> teams;

    protected Long cost;

    protected String name;

    protected String description;

    protected boolean forTeams;

    protected int priority;

    public Long getCost()
    {
        return cost;
    }

    public List<Team> getTeams()
    {
        return teams;
    }

    public List<User> getUsers()
    {
        return users;
    }

    public void setCost(Long cost)
    {
        this.cost = cost;
    }

    public int getId()
    {
        return id;
    }

    public String getName()
    {
        return name;
    }

    public boolean isForTeams()
    {
        return forTeams;
    }

    public void setForTeams(boolean forTeams)
    {
        this.forTeams = forTeams;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public abstract long modiphyClicks(long clickCount, User user, int numberOfUses);

    public String getDescription()
    {
        return description;
    }

    public void setDescription(String description)
    {
        this.description = description;
    }

    public int getPriority()
    {
        return priority;
    }
}
