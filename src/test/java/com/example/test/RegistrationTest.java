package com.example.test;

import com.example.test.controller.RegistrationController;
import com.example.test.domain.User;
import com.example.test.repository.UserRepository;
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
            assertEquals("test", connection.getCatalog());
        } catch (SQLException ignored) {
        }
    }

    @Test
    void registration() {
        User user = new User();
        user.setUsername("b v");
        user.setPassword("das ");
        RegistrationController registration = new RegistrationController(repository);
        Map<String, Object> map = new HashMap<>();
        registration.addUser(user,map);
        assertEquals("Password must have a length of more than 8 symbols", map.get("password"));
        assertEquals("Username mustn't contain space", map.get("login"));

        User user1 = new User();
        user1.setUsername("bachromOnlyTheBest");
        user1.setPassword("2353563737373");
        registration.addUser(user1, map);
//        assertNull(map.get("added"));
        assertEquals("User has successfully been added", map.get("added"));
    }

    @Test
    void checkDatabase() {
        User user = repository.findByUsername("lera");
        assertNotNull(user);
        User user1 = repository.findByUsername("chris");
        assertNull(user1);
    }

}