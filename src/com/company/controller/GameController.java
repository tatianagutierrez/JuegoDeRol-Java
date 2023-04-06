package com.company.controller;

import com.company.model.*;
import com.company.view.UIconsola;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Random;

public class GameController {

    //Tengo que tener los objetos model y el view

    Jugador mainPlayer = new Jugador();
    Jugador pcPlayer = new Jugador();
    //Log logger = new Log();
    UIconsola consola = new UIconsola();
    Humano humano;
    Elfo elfo;
    Orco orco;

    //TODO: Constructor??

    public void iniciarJuego(String nombre, int opcionCrearJugadores){

        mainPlayer.setNombre(nombre);
        //logger.crearPartida();

        System.out.println("Bienvenido " + nombre);

        if (opcionCrearJugadores == 1) {
            System.out.println("Ha decidio crear los personajes manualmente");

            for (int i = 0; i < 3; i++) {
                System.out.println("Personaje de main player " + i);
                crearMazo(mainPlayer, consola.ingresarDatosPersonaje());

                System.out.println("Personaje de pc player " + i);
                crearMazo(pcPlayer, consola.ingresarDatosPersonaje());
            }

             //cambiar por UIconsola.printMsg()
        }
        else {
            System.out.println("Ha decidio crear los personajes aleatoriamente");

            for (int i = 0; i < 3; i++) {
                System.out.println("Personaje de main player " + i);
                crearMazo(mainPlayer, datosAleatorios());

                System.out.println("Personaje de pc player " + i);
                crearMazo(pcPlayer, datosAleatorios());
            }

        }

        System.out.println("\nMAIN PLAYER");
        mainPlayer.imprimirLista();
        System.out.println("\nPC PLAYER");
        pcPlayer.imprimirLista();

        iniciarBatalla();

    }

    //TODO: Ver si lo puedo dejar en Personaje aunque sea cLase abstracta
    public Object[] datosAleatorios(){
        Random random = new Random();
        int numRaza = random.nextInt(3)+1;

        /*
        int numNombre = random.nextInt(10)+1;
        String[] nombreApodo = generarNombreYApodo(numRaza, numNombre);
        String nombre = nombreApodo[0];
        String apodo = nombreApodo[1];
         */

        //TODO: Cambiar: esta harcodeado
        String nombre = "Calipsus";
        String apodo = "El gladiador";
        //String fechaNacimiento = generarFechaNacimientoAleatoria();
        String fechaNacimiento = "12/06/2000";

        int edad = random.nextInt(300)+1;
        int velocidad = random.nextInt(10)+1;
        int destreza = random.nextInt(5)+1;
        int fuerza = random.nextInt(10)+1;
        int nivel = random.nextInt(10)+1;
        int armadura = random.nextInt(10)+1;

        return new Object[]{numRaza, nombre, apodo, fechaNacimiento, edad, velocidad, destreza, fuerza, nivel, armadura};
        //return new String[]{nombre, apodo, fechaNacimiento, String.valueOf(edad), String.valueOf(velocidad)};
    }

    //TODO: Cambiar nombre a crearCarta porque crea una a la vez
    public void crearMazo(Jugador player ,Object[] datos) {
        //for (int i = 0; i < 3; i++) {
            int numRaza = (int) datos[0];

            if (numRaza == 1) {
                humano = new Humano();
                player.agregarPersonjae(humano.crearPersonaje(datos));
            } else if (numRaza == 2) {
                orco = new Orco();
                player.agregarPersonjae(orco.crearPersonaje(datos));
            } else {
                elfo = new Elfo();
                player.agregarPersonjae(elfo.crearPersonaje(datos));
            }
        //}
    }

    public void iniciarBatalla() {
        Random random = new Random();
        ArrayList<Personaje> listaMainPlayer = mainPlayer.getListaPersonajes();
        ArrayList<Personaje> listaPcPlayer = pcPlayer.getListaPersonajes();

        //Sortear ronda
        int jugadorAtacante = random.nextInt(2)+1;
        System.out.println("El jugador que comienza es el " + jugadorAtacante);

        while (!listaMainPlayer.isEmpty() && !listaPcPlayer.isEmpty()) {
            //COMIENZA LA BATALLA

            //Sortear personajes
            Personaje pjMainPlayer = mainPlayer.obtenerPersonajeRandom();
            Personaje pjPcPlayer = pcPlayer.obtenerPersonajeRandom();
            System.out.println("\n Personjae Main " + pjMainPlayer);
            System.out.println("\n Personjae PC " + pjPcPlayer);

            //Condicionales para empezar la ronda

            int cantAtaquesMainPlayer = 0;
            int cantAtaquesPcPlayer = 0;
            double saludMainPlayer = pjMainPlayer.getSalud();
            double saludPcPlayer = pjPcPlayer.getSalud();

            double danioAtaque;

            while ((cantAtaquesMainPlayer != 7 && cantAtaquesPcPlayer != 7) && (saludMainPlayer != 0.00 && saludPcPlayer != 0.00)){
                // COMIENZA LA RONDA X
                int valorAtaque, poderDefensa;

                if (jugadorAtacante == 1){
                    //TODO: Ver si puedo poner por ejemplo this.destreza
                    valorAtaque = pjMainPlayer.calcularValorDeAtaque(pjMainPlayer.getDestreza(), pjMainPlayer.getFuerza(), pjMainPlayer.getNivel());
                    poderDefensa = pjPcPlayer.calcularPoderDefensa(pjPcPlayer.getArmadura(), pjPcPlayer.getVelocidad());

                    danioAtaque = pjMainPlayer.atacar(valorAtaque, poderDefensa);
                    System.out.println("El danio de ataque fue de: " + String.format("%.2f", danioAtaque));

                    if (danioAtaque < 0){
                        danioAtaque = 0;
                    }

                    pjPcPlayer.recibirDanio(danioAtaque);
                    saludPcPlayer = pjPcPlayer.getSalud();
                    System.out.println("pcPlayer queda con " + String.format("%.2f", saludPcPlayer) + " de salud");

                    cantAtaquesMainPlayer++;
                    System.out.println("\n Cantidad ataques: " + cantAtaquesMainPlayer);
                    jugadorAtacante = 2;

                }
                else{
                    valorAtaque = pjPcPlayer.calcularValorDeAtaque(pjPcPlayer.getDestreza(), pjPcPlayer.getFuerza(), pjPcPlayer.getNivel());
                    poderDefensa = pjMainPlayer.calcularPoderDefensa(pjMainPlayer.getArmadura(), pjMainPlayer.getVelocidad());

                    danioAtaque = pjPcPlayer.atacar(valorAtaque, poderDefensa);
                    System.out.println("El danio de ataque fue de: " + String.format("%.2f", danioAtaque));

                    if (danioAtaque < 0){
                        danioAtaque = 0;
                    }

                    pjMainPlayer.recibirDanio(danioAtaque);
                    saludMainPlayer = pjMainPlayer.getSalud();
                    System.out.println("mainPlayer queda con " + String.format("%.2f", saludMainPlayer) + " de salud");

                    cantAtaquesPcPlayer++;
                    System.out.println("\n Cantidad ataques: " + cantAtaquesPcPlayer);
                    jugadorAtacante = 1;

                }
            }

            if (saludMainPlayer == 0){
                listaMainPlayer.remove(pjMainPlayer);
                System.out.println("El jugador 2 gana esta ronda");
                jugadorAtacante = 1;

                // Beneficio por haber ganado
                pjPcPlayer.setSalud(saludPcPlayer + 10);
            }
            else if (saludPcPlayer == 0){
                listaPcPlayer.remove(pjPcPlayer);
                System.out.println("El jugador 1 gana esta ronda");
                jugadorAtacante = 2;

                pjMainPlayer.setSalud(saludMainPlayer + 10);

            }
            else{
                jugadorAtacante = random.nextInt(2)+1;
                System.out.println("Fue un empate, la ronda vuelve a empezar.");
            }

        }

        if (listaMainPlayer.isEmpty()){
            System.out.println("\nMain player se quedo sin cartas");
            System.out.println("El ganador del juego es PC Player");
        }
        else {
            System.out.println("\nPC Player se quedo sin cartas");
            System.out.println("El ganador del juego es Main player");
        }

    }


}
