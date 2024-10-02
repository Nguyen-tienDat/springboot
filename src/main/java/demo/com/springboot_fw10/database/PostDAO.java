package demo.com.springboot_fw10.database;

import demo.com.springboot_fw10.controllers.SessionController;
import demo.com.springboot_fw10.models.Post;

import java.sql.Connection;

public class PostDAO extends Database {
    public PostDAO () {
        getConnection();
    }
}
