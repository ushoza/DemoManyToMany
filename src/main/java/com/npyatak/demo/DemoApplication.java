package com.npyatak.demo;

import java.util.Arrays;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

import com.npyatak.demo.items.AddItem;
import com.npyatak.demo.items.MultiplayItem;
import com.npyatak.demo.repos.ItemRepository;
import com.npyatak.demo.repos.TeamRepository;
import com.npyatak.demo.repos.UserRepository;
import com.npyatak.demo.service.DatabaseInit;

@SpringBootApplication
@ComponentScan("com.npyatak.demo")
@EntityScan("com.npyatak.demo")
@EnableJpaRepositories("com.npyatak.demo.repos")
public class DemoApplication
{

    @Autowired
    private DatabaseInit dbInit;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TeamRepository teamRepository;
    @Autowired
    private ItemRepository itemRepository;

    private static String[] args;

    public static void main(String[] args)
    {
        SpringApplication.run(DemoApplication.class, args);


    }

    @PostConstruct
    private void Init()
    {
        if (args != null && args.length > 0 && "-init".equals(args[0]))
        {
            dbInit.Init();
        }
        Team team = new Team();
        team.setTeam_name("team1");
        teamRepository.save(team);

        Team team2 = new Team();
        team2.setTeam_name("team2");
        teamRepository.save(team2);

        User user = new User();
        user.setUsername("user1");
        user.setCurrent_team(team);
        userRepository.save(user);

        User user2 = new User();
        user2.setUsername("user2");
        user2.setCurrent_team(team2);
        userRepository.save(user2);

        AddItem addItem = new AddItem();
        addItem.setNumber(1);
        addItem.setName("Товар1");
        addItem.setCost(10L);
        itemRepository.save(addItem);

        AddItem addItem2 = new AddItem();
        addItem2.setNumber(2);
        addItem2.setName("Товар2");
        addItem2.setCost(10L);
        itemRepository.save(addItem2);

        MultiplayItem multiplayItem = new MultiplayItem();
        multiplayItem.setName("Товар1 для команд");
        itemRepository.save(multiplayItem);

        MultiplayItem multiplayItem2 = new MultiplayItem();
        multiplayItem2.setName("Товар2 для команд");
        itemRepository.save(multiplayItem2);

        user.setItems(Arrays.asList(addItem, addItem2));
        userRepository.save(user);
        user2.setItems(Arrays.asList(addItem2));
        userRepository.save(user2);

        team.setItems(Arrays.asList(multiplayItem, multiplayItem2));
        teamRepository.save(team);
        team2.setItems(Arrays.asList(multiplayItem2));
        teamRepository.save(team2);
    }
}
