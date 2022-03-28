package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDB {
    Connection connection = null;
    public Connection get_connection(){

        System.out.println("Get connection method");
        try{
            connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/mensajes_app","root","");
        }catch(SQLException e){
            System.out.println(e);
        }
        return connection;
    }
}