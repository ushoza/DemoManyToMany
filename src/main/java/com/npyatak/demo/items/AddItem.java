package com.npyatak.demo.items;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

import com.npyatak.demo.User;

@Entity
@DiscriminatorValue("AddItem")
public class AddItem extends Item {

    public long getNumber() {
        return number;
    }

    public void setNumber(long number) {
        this.number = number;
    }

    private long number;

    public AddItem() {
        this.priority = 0;
    }

    public AddItem(long number, String name, String desc, boolean forTeams, long cost) {
        this.number = number;
        this.name = name;
        this.description = desc;
        this.forTeams = forTeams;
        this.priority = 0;
        this.cost = cost;
    }

    @Override
    public long modiphyClicks(long clickCount, User user, int numberOfUses)
    {
        return clickCount + number * numberOfUses;
    }
}
