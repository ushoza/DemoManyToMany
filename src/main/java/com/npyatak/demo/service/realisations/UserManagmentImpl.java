package com.npyatak.demo.service.realisations;

import java.util.HashSet;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.npyatak.demo.Role;
import com.npyatak.demo.User;
import com.npyatak.demo.items.Item;
import com.npyatak.demo.repos.TeamRepository;
import com.npyatak.demo.repos.UserRepository;
import com.npyatak.demo.service.interfaces.ItemManagment;
import com.npyatak.demo.service.interfaces.UserManagment;
import com.npyatak.demo.service.interfaces.UserRequestResult;

@Service
public class UserManagmentImpl implements UserManagment, UserDetailsService {

    private TeamRepository teamRep;
    private UserRepository userRep;
    private ItemManagment itemManagment;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    @Autowired
    public UserManagmentImpl(TeamRepository teamRep, UserRepository userRep, ItemManagment itemManagment) {
        this.teamRep = teamRep;
        this.userRep = userRep;
        this.itemManagment = itemManagment;
    }

    @Override
    public UserRequestResult createUser(String name, String password) {
        if (userRep.existsById(name))
            return UserRequestResult.Exists;
        var u = new User();
        var roles = new HashSet<Role>();
        roles.add(Role.getUser());
        u.setUsername(name);
        u.setPassword(bCryptPasswordEncoder.encode(password));
        u.setRoles(roles);
        userRep.save(u);
        return UserRequestResult.Success;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException
    {
        return null;
    }

    @Override
    public UserRequestResult userClick(String user_name)
    {
        return null;
    }

    @Override
    public UserRequestResult buyItem(String user_name, Item item)
    {
        return null;
    }

    @Override
    public User getUser(String name)
    {
        return null;
    }

    @Override
    public User getAuthUser()
    {
        return null;
    }
}
