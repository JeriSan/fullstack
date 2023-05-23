package com.backend.interfaces;

public class MensajeSaludo implements InterfazMensaje {
    @Override
    public void pintarMensaje(String mensaje) {
        System.out.println("Hola: "+mensaje);
    }
    public void pintarOtroMensaje(String mensaje1){
        System.out.println("Otro mensaje: "+mensaje1);
    }
}
