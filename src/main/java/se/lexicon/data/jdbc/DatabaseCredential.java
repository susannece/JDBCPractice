package se.lexicon.data.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseCredential {
    private final String URL = "jdbc:mysql://localhost:3306/shopping_practice?autoReconnect=true&useSSL=false&allowPublicKeyRetrieval=true&serverTimezone=Europe/Berlin";
    private final String USER = "root";
    private final String PASSWORD = "1234";

    private static final DatabaseCredential INSTANCE = new DatabaseCredential();

    public DatabaseCredential() {
    }

    public static DatabaseCredential getInstance(){
        if (INSTANCE == null) throw new IllegalArgumentException("INSTANCE not initialized.");
            return INSTANCE;
    }

    public Connection getConnection(){
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        }catch (SQLException e){
            e.printStackTrace();
        }
        return connection;
    }


    public String getURL() {
        return URL;
    }

    public String getUSER() {
        return USER;
    }

    public String getPASSWORD() {
        return PASSWORD;
    }



}
