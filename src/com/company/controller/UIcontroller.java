package com.company.controller;

import com.company.view.UIconsola;

import java.io.IOException;

public class UIcontroller {

    UIconsola consola = new UIconsola();
    GameController gameController = new GameController();
    LoggerController logger = new LoggerController();

    public void crearJuego(String nombre1, int opcionCrearJugadores){
        gameController.iniciarJuego(nombre1, opcionCrearJugadores);
    }

    public void leerHistorial() throws IOException {
        consola.mostrar(logger.leerArchivo());
    }

    public void borrarHistorial() throws IOException {
        consola.mostrar(logger.borrarArchivo());
    }
}
