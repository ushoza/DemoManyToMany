package com.npyatak.demo.service.interfaces;

import com.npyatak.demo.User;
import com.npyatak.demo.items.Item;

public interface UserManagment {
    UserRequestResult createUser(String name, String password);
    UserRequestResult userClick(String user_name);
    UserRequestResult buyItem(String user_name, Item item);
    User getUser(String name);
    User getAuthUser();
}
