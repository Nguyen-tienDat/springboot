package demo.com.springboot_fw10.database;

import java.sql.Connection;
import java.sql.DriverManager;

public class Database {
    public static final String URL = "jdbc:mysql://localhost:3306/java36";
    public static final String USER = "root";
    public static final String PASSWORD = "11021990";
    public Connection connection;

    public Connection getConnection() {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            return connection;
        }
        catch(Exception e){
            e.printStackTrace();
        }
        return null;
    }

}
