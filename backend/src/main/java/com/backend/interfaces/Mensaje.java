package com.backend.interfaces;

public class Mensaje {
    public static void main(String[] args) {
      /*  InterfazMensaje interfazMensaje = new MensajeSaludo();
        interfazMensaje.pintarMensaje("sdsd");

        MensajeSaludo mensajeSaludo = (MensajeSaludo)interfazMensaje;
        mensajeSaludo.pintarOtroMensaje("dasdadd");
      */
      InterfazMensaje interfazMensaje = new MensajePrueba();
      interfazMensaje.pintarMensaje("Pintar mensaje");

      InterfazMensaje interfazMensaje2 = new MensajeSaludo();
      interfazMensaje2.pintarMensaje("sdsd");


    }
}
