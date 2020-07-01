package com.example.contracts.repositories;

import com.example.contracts.entities.User;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.stream.Collectors;
import javax.annotation.PostConstruct;
import org.springframework.stereotype.Repository;

@Repository
public class UserDataRepository {
    private Map<String, User> dataSet = new HashMap<>();

    @PostConstruct
    private void init(){ // init with data, comment out for empty
        User user = User.builder().id("Name".hashCode()+"")// yes i did :)
                .lastName("LastName")
                .name("Name")
                .build();
        dataSet.put(user.getId(), user);
    }


    public List<User> findByName(String name) {
        return dataSet.values().stream()
                .filter(user -> Objects.equals(user.getName(), name))
                .collect(Collectors.toList());
    }

    public void createUser(User newUser) {
        dataSet.put(newUser.getId(), newUser);
    }
}
