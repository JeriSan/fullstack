package com.backend.interfaces;

public class MensajePrueba implements InterfazMensaje {
    @Override
    public void pintarMensaje(String mensaje) {
        System.out.println("Mensaje prueba"+mensaje);
    }
}
