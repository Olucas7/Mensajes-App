/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author oscarlucas7
 */
public class MensajesDAO {
    
    public static void crearMensajeDB(Mensajes mensaje){
        ConnectionDB db_connect = new ConnectionDB();
        
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement ps =null;
            try{
                String query ="INSERT INTO mensajes ( mensaje, autor_mensaje) VALUES (?,?)";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensajes());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.executeUpdate();
                System.out.println("mensaje creado");
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void leerMensajesDB(){
        
        ConnectionDB db_connect = new ConnectionDB();
        
        try(Connection connection = db_connect.get_connection()){
            PreparedStatement ps = null;
            ResultSet rs = null;
            
            try{
                String query = "SELECT * FROM Mensajes";
                ps = connection.prepareStatement(query);
                rs = ps.executeQuery();
                
                while(rs.next()){
                    System.out.printf("------------------------\nID: %s \nMensaje: %s \nAutor: %s \nFecha: %s\n",rs.getInt("id_mensajes"),rs.getString("mensaje"),
                            rs.getString("autor_mensaje"),rs.getString("fecha_mensaje"));
                    
                }
            }catch(SQLException e){
                System.out.println(e);
            }
        }catch(SQLException e){
            System.out.println("Data Base Connection Failed");
            System.out.println(e);
        }
        
        
    }
    
    public static void borrarMensajeDB(int id_mensaje){
        ConnectionDB db_connection = new ConnectionDB();
        try(Connection connection = db_connection.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "DELETE FROM Mensajes WHERE Mensajes.id_mensajes = ?";
                ps = connection.prepareStatement(query);
                ps.setInt(1,id_mensaje);
                ps.executeUpdate();
            }catch(SQLException ex){
                System.out.println(ex);
            }
            
            
        }catch(SQLException e){
            System.out.println(e);
        }
        
    }
    
    public static void actualizarMensajeDB(Mensajes mensaje){
        ConnectionDB db_connection = new ConnectionDB();
        try(Connection connection = db_connection.get_connection()){
            PreparedStatement ps = null;
            try{
                String query = "UPDATE Mensajes SET mensaje = ?, autor_mensaje = ? WHERE id_mensajes = ?";
                ps = connection.prepareStatement(query);
                ps.setString(1, mensaje.getMensajes());
                ps.setString(2, mensaje.getAutor_mensaje());
                ps.setInt(3, mensaje.getId_mensaje());
                ps.executeUpdate();
                System.out.println("\nMessage Updated Successful");
            }catch(SQLException ex){
                System.out.println(ex);
            }    
        }catch(SQLException e){
            System.out.println(e);
        }
    }
}