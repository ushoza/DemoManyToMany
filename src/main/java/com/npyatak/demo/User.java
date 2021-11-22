package com.npyatak.demo;

import java.util.Collection;
import java.util.List;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.npyatak.demo.items.Item;

@Entity
@Table(name="Users")
public class User implements UserDetails {

    @Id
    @Column(name = "username")
    private String username;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "team_name")
    private Team current_team;

    @Column(name="click_count")
    private long clickCount = 0;

    @Column(name="password")
    private String password;

    @ManyToMany(fetch = FetchType.EAGER)
    private Set<Role> roles;

    @ManyToMany
    @JoinTable(name="user_items", joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name=
            "item_id"))
    private List<Item> items;

    /*@OneToMany(mappedBy = "owner")
    private List<items_users> items;*/

    public User() {
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles;
    }

    public List<Item> getItems()
    {
        return items;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }

    public void setItems(List<Item> items)
    {
        this.items = items;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setCurrent_team(Team current_team) {
        this.current_team = current_team;
    }

    public void setClickCount(long clickCount) {
        this.clickCount = clickCount;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRoles(Set<Role> roles) {
        this.roles = roles;
    }

    public Team getCurrent_team() {
        return current_team;
    }

    public long getClickCount() {
        return clickCount;
    }

    public Set<Role> getRoles() {
        return roles;
    }

    public Boolean isLeader() {return getRoles().contains(Role.getLeader());}

    /*public List<items_users> getItems() {
        return items;
    }*/

   /* public void setItems(List<items_users> items) {
        this.items = items;
    }*/
}
