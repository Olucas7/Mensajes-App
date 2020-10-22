package com.mycompany.mensajes_app;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ConnectionDB connection = new ConnectionDB();
        
        try(Connection ctn = connection.get_connection()){
            System.out.println("successful connection");
        }catch(SQLException e){
            System.out.println(e);
        }
        
        Scanner sc = new Scanner(System.in);
        
        int response = 0;
        do{
            System.out.println("\n-------------------");
            System.out.println(" Aplicacion de mensajes");
            System.out.println("1. crear mensaje");
            System.out.println("2. listar mensajes");
            System.out.println("3. borrar mensaje");
            System.out.println("4. editar mensaje");
            System.out.println("5. salir");
            
            response = sc.nextInt();
            
            switch(response){
                case 1:
                    MensajesService.crearMensaje();
                    break;
                case 2:
                    MensajesService.listarMensajes();
                    break;
                case 3:
                    MensajesService.borrarMensaje();
                    break;
                case 4:
                    MensajesService.editarMensaje();
                    break;
                case 5:
                    break;
                default:
                    break;
            }
            
        }while(response != 5);
        
    }
    
}
