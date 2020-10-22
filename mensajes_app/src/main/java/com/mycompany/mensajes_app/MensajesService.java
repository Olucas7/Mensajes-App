package com.mycompany.mensajes_app;

import java.util.Scanner;
/**
 *
 * @author oscarlucas7
 */
public class MensajesService {
    public static void crearMensaje(){
        Mensajes newPost = new Mensajes();
        Scanner sc = new Scanner(System.in);
        System.out.println("------------------");
        System.out.println("Mensaje: ");
        String post = sc.nextLine();
        System.out.println("Autor: ");
        String postAutor = sc.nextLine();
        newPost.setMensajes(post);
        newPost.setAutor_mensaje(postAutor);
        MensajesDAO.crearMensajeDB(newPost);
    }
    
    public static void listarMensajes(){
        MensajesDAO.leerMensajesDB();
    }
    
    public static void borrarMensaje(){
        Scanner sc = new Scanner(System.in);
        do{
            System.out.println("Insert id_message to delete");
            String userImput = sc.nextLine();
            try{
                int id_message = Integer.parseInt(userImput);
                MensajesDAO.borrarMensajeDB(id_message);
                System.out.println("Message deleted successful");
                break;
            }catch(NumberFormatException e){
                System.out.println(e);
                System.out.println("Try it again");
            }
            
        }while(true);
        
    }
    
    public static void editarMensaje(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Update Message...");
        MensajesDAO.leerMensajesDB();
        System.out.println("\n|||||||||||||||||||");
        int response = 1;
        int id_mensajes = 0;
        do{
            System.out.println("Select a Id Message to update it");
            try{
                
                id_mensajes = Integer.parseInt(sc.nextLine()) ;
                response = 0;
            }catch(NumberFormatException e){
                System.out.println("Number selected Failed");
            }
        }while(response != 0);
        Mensajes updatedMessage = new Mensajes();
        updatedMessage.setId_mensaje(id_mensajes);
        System.out.println("Message you need change... ");
        updatedMessage.setMensajes(sc.nextLine());
        System.out.println("Autor: ");
        updatedMessage.setAutor_mensaje(sc.nextLine());
        MensajesDAO.actualizarMensajeDB(updatedMessage);
        
    }
    
}
