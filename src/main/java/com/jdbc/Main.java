package com.jdbc;


import java.sql.*;


public class Main {
    private static final String USERNAME = "root";
    private static final String PASSWORD = "20000103";
    private static final String URL = "jdbc:mysql://localhost:3306/mysql";

    public static void main(String[] args) throws SQLException {
        Connection connection = null;

        try {
            connection = DriverManager.getConnection(URL,USERNAME,PASSWORD);
            Statement statement = connection.createStatement();
            System.out.println("....code");
        } catch (SQLException e) {
            System.out.println("Не удалось соеденить"+e);
            return;
        }
        finally {
            if (connection !=null) {
                connection.close();
            }
            }

    }
}
