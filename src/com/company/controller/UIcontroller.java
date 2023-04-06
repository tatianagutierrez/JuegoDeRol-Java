package com.company.controller;

public class UIcontroller {

    GameController gameController = new GameController();

    public void crearJuego(String nombre, int opcionCrearJugadores){
        gameController.iniciarJuego(nombre, opcionCrearJugadores);
    }

    public void leerHistorial(){
        System.out.println("Historial");
    }

    public void borrarHistorial(){
        System.out.println("Borrado");
    }
}
