package com.company.controller;

import com.company.model.Jugador;
import com.company.model.Personaje;

import java.util.Random;

public class GameController {

    Jugador jugador = new Jugador();
    Log logger = new Log();

    public void iniciarJuego(String nombreJugador){

        jugador.setNombre(nombreJugador);
        logger.crearPartida();

        //TODO: Desde el UI tengo que ver si el usuaio ingresa el personaje o se crea manualmente
        //pruebo con el personaje aleatorio

    }



    public void iniciarBatalla() {

    }
}
