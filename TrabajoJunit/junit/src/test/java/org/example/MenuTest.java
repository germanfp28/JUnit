package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;

import static org.junit.jupiter.api.Assertions.*;

public class MenuTest {

    private Menu menu;

    @BeforeEach
    public void setUp() {
        menu = new Menu();
    }

    @Test
    public void testVerificarUsuarioSinNombre() {
        assertFalse(menu.verificarUsuario());
    }

    @Test
    public void testVerificarUsuarioConNombre() {
        setInput("Juan\n");
        menu.añadirUsuario();
        assertTrue(menu.verificarUsuario());
    }

    @Test
    public void testAñadirIngreso() {
        setInput("Juan\n100.5\n");
        menu.añadirUsuario();
        menu.añadirIngreso();
        assertEquals(100.5, menu.saldo, 0.001);
    }

    @Test
    public void testAñadirGastoConSaldoSuficiente() {
        setInput("Juan\n200\n1\n50\n4\n");
        menu.añadirUsuario();
        menu.saldo = 100.0; // simula ingreso anterior
        menu.añadirGasto();
        assertEquals(50.0, menu.saldo, 0.001);
    }

    @Test
    public void testAñadirGastoConSaldoInsuficiente() {
        setInput("Juan\n1\n150\n4\n");
        menu.añadirUsuario();
        menu.saldo = 100.0;
        menu.añadirGasto();
        assertEquals(100.0, menu.saldo, 0.001); // no debe cambiar
    }

    private void setInput(String data) {
        InputStream inputStream = new ByteArrayInputStream(data.getBytes());
        System.setIn(inputStream);
        menu.leer = new java.util.Scanner(System.in); // actualizar el scanner de la clase
    }
}