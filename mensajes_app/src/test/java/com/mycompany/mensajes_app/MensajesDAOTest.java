package com.mycompany.mensajes_app;

import org.junit.Before;
import org.junit.jupiter.api.Test;
import static org.junit.Assert.assertEquals;

import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;
import org.mockito.junit.MockitoJUnitRunner;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
class MensajesDAOTest {
    @Spy
    @Mock
    ConnectionDB connectionDBMock = mock(ConnectionDB.class);

    MensajesDAO mensajesDAO = new MensajesDAO(connectionDBMock);

    @Before
    public void setup(){
        System.out.println("setup listo");
        MockitoAnnotations.initMocks(this);

    }

    @Test
    void crearMensajeDB() {
        Connection connectionMock = mock(Connection.class);
        Mensajes sms = new Mensajes("Holis","olis","chou");
        when(connectionDBMock.get_connection()).thenReturn(connectionMock);
        try{
            when(connectionMock.prepareStatement("")).thenReturn(mock(PreparedStatement.class));
        }catch (Exception e){
            System.out.println(e);
        }

        mensajesDAO.crearMensajeDB(sms);
    }

//    @Test
//    void leerMensajesDB() {
//    }
//
//    @Test
//    void borrarMensajeDB() {
//    }
//
//    @Test
//    void actualizarMensajeDB() {
//    }
}