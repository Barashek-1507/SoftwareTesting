package org.baggio.sweater.controller;

import org.baggio.sweater.model.User;
import org.baggio.sweater.repository.UserRepository;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import javax.sql.DataSource;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.HashMap;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class RegistrationTest {

    @Autowired
    private DataSource dataSource;

    @Autowired
    private UserRepository repository;

    @Test
    void checkConnection() {
        try {
            Connection connection = dataSource.getConnection();
            assertEquals("sweater", connection.getCatalog());
        } catch (SQLException ignored) {
        }
    }

    @Test
    void registration() {
        User user = new User();
        user.setUsername("b v");
        user.setPassword("das ");
        Registration registration = new Registration(repository);
        Map<String, Object> map = new HashMap<>();
        registration.addUser(user,map);
        assertEquals("Password must have a length of more than 8 symbols", map.get("password"));
        assertEquals("Username mustn't contain space", map.get("login"));

        User user1 = new User();
        user1.setUsername("dasasdasd");
        user1.setPassword("dasdasdasjhdgjas");
        registration.addUser(user1, map);
//        assertNull(map.get("added"));
        assertEquals("User has successfully been added", map.get("added"));
    }

    @Test
    void checkDatabase() {
        User user = repository.findByUsername("baggio");
        assertNotNull(user);
        User user1 = repository.findByUsername("chris");
        assertNull(user1);
    }

}