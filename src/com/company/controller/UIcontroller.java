package com.company.controller;

public class UIcontroller {

    GameController gameController = new GameController();

    public void crearJuego(String nombreJugador){
        gameController.iniciarJuego(nombreJugador);
    }

    public void leerHistorial(){
        System.out.println("Historial");
    }

    public void borrarHistorial(){
        System.out.println("Borrado");
    }
}
