package com.company.controller;

import com.company.model.*;
import com.company.view.UIconsola;

import java.text.SimpleDateFormat;
import java.util.*;

public class GameController {

    Jugador mainPlayer = new Jugador();
    Jugador pcPlayer = new Jugador();
    LoggerController logger = new LoggerController();
    UIconsola consola = new UIconsola();
    Random random = new Random();
    Humano humano;
    Elfo elfo;
    Orco orco;

    public void iniciarJuego(String nombre, int opcionCrearJugadores){

        logger.logearNuevaPartida();

        mainPlayer.setNombre(nombre);
        pcPlayer.setNombre("PC");

        if (opcionCrearJugadores == 1) {
            for (int i = 0; i < 3; i++) {
                logearYActualizarVista("          Personaje " + (i + 1) + " de " + nombre);
                crearCarta(mainPlayer, consola.ingresarDatosPersonaje());
                logearYActualizarVista(consola.obtenerDatosPersonaje(mainPlayer.obtenerPersonajeByIndex(i)));

                logearYActualizarVista("          Personaje " + (i + 1) + " de PC");
                crearCarta(pcPlayer, consola.ingresarDatosPersonaje());
                logearYActualizarVista(consola.obtenerDatosPersonaje(pcPlayer.obtenerPersonajeByIndex(i)));
            }
        }
        else {
            for (int i = 0; i < 3; i++) {
                crearCarta(mainPlayer, datosAleatorios());
                logearYActualizarVista("          Personaje " + (i + 1) + " de " + nombre);
                logearYActualizarVista(consola.obtenerDatosPersonaje(mainPlayer.obtenerPersonajeByIndex(i)));

                crearCarta(pcPlayer, datosAleatorios());
                logearYActualizarVista("          Personaje " + (i + 1) + " de PC");
                logearYActualizarVista(consola.obtenerDatosPersonaje(pcPlayer.obtenerPersonajeByIndex(i)));
            }
        }

        iniciarBatalla();

    }

    public Object[] datosAleatorios(){
        int numRaza = random.nextInt(3)+1;

        int numNombre = random.nextInt(29);
        int numApodo = random.nextInt(29);
        String[] nombreApodo = generarNombreYApodo(numNombre, numApodo);
        String nombre = nombreApodo[0];
        String apodo = nombreApodo[1];

        Calendar fechaNacimiento = generarFechaNacimientoAleatoria();
        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        String fechaFormateada = sdf.format(fechaNacimiento.getTime());

        int edad = calcularEdad(fechaNacimiento);

        int velocidad = random.nextInt(10)+1;
        int destreza = random.nextInt(5)+1;
        int fuerza = random.nextInt(10)+1;
        int nivel = random.nextInt(10)+1;
        int armadura = random.nextInt(10)+1;

        return new Object[]{numRaza, nombre, apodo, fechaFormateada, edad, velocidad, destreza, fuerza, nivel, armadura};
    }


    // Metodos auxiliares a datosAleatorios()
    private String[] generarNombreYApodo(int numNombre, int numApodo){

        List<String> nombres = Arrays.asList("Ivar", "Gerda", "Atila", "Eric", "César", "Leónidas", "Helga", "Sigrid", "William", "Ian", "Kruhlu", "Ulumpha", "Anakkin", "Ayleids", "Tjasatheni", "Sinnamnuria", "Trurnuk", "Xoruk", "Dakagrod", "Fëanor", "Legolas", "Arwen", "Isildur", "Lúthien", "Miriel", "Angrod", "Círdan", "Mablung", "Celeborn");

        List<String> apodos = Arrays.asList("El arquero", "La fortaleza", "El húngaro", "El hacha sangrienta", "El Divino", "El hijo del león", "La daga", "La victoria", "El cuervo", "El destructor", "Sangre salvaje", "Martillo estruendoso", "Reliquia del fuego", "Sombra de ira", "Colmillo de demonio", "Rugido silencioso", "Puño de roca", "Furia Gigante", "Golpes de piedra", "Espíritu de fuego", "Hoja verde", "Doncella noble", "Sirviente de la Luna", "Hijo del crepúsculo", "Paso fuerte", "Héroe de hierro", "Carpintero de barcos", "Mano pesada", "Árbol de plata");

        String nombre = nombres.get(numNombre);
        String apodo = apodos.get(numApodo);

        return new String[]{nombre, apodo};
    }

    private Calendar generarFechaNacimientoAleatoria(){
        Calendar fecha = Calendar.getInstance();
        fecha.set (random.nextInt(300)+1723, random.nextInt(12)+1, random.nextInt(30)+1);

        return fecha;
    }


    public int calcularEdad(Calendar fechaDeNacimiento){
        Calendar now = Calendar.getInstance();
        int anio = now.get(Calendar.YEAR) - fechaDeNacimiento.get(Calendar.YEAR);
        if (now.get(Calendar.MONTH) < fechaDeNacimiento.get(Calendar.MONTH) ||
                (now.get(Calendar.MONTH) == fechaDeNacimiento.get(Calendar.MONTH) &&
                        now.get(Calendar.DAY_OF_MONTH) < fechaDeNacimiento.get(Calendar.DAY_OF_MONTH))) {
            anio--;
        }
        return anio;
    }


    public void crearCarta(Jugador player , Object[] datos) {
        int numRaza = (int) datos[0];

        if (numRaza == 1) {
            humano = new Humano();
            player.agregarPersonje(humano.crearPersonaje(datos));
        } else if (numRaza == 2) {
            orco = new Orco();
            player.agregarPersonje(orco.crearPersonaje(datos));
        } else {
            elfo = new Elfo();
            player.agregarPersonje(elfo.crearPersonaje(datos));
        }

    }

    private void logearYActualizarVista(String msj){
        logger.logear(msj + "\n");
        consola.mostrar(msj);
    }

    public void iniciarBatalla() {
        ArrayList<Personaje> listaMainPlayer = mainPlayer.getListaPersonajes();
        ArrayList<Personaje> listaPcPlayer = pcPlayer.getListaPersonajes();

        //Sortear ronda
        int jugadorAtacante = random.nextInt(2)+1;
        logearYActualizarVista("El jugador que comienza es " + ((jugadorAtacante == 1) ? mainPlayer.getNombre() : "PC"));
        int contBatallas = 1;

        while (!listaMainPlayer.isEmpty() && !listaPcPlayer.isEmpty()) {

            logearYActualizarVista("\nBatalla N° " + contBatallas++ + "\n");

            //Sortear personajes
            Personaje pjMainPlayer = mainPlayer.obtenerPersonajeRandom();
            Personaje pjPcPlayer = pcPlayer.obtenerPersonajeRandom();
            logearYActualizarVista(pjMainPlayer.getNombre() + "(" + mainPlayer.getNombre() + ") VS " + pjPcPlayer.getNombre() + "(PC)");

            //Condicionales para empezar la ronda
            int cantAtaquesMainPlayer = 0;
            int cantAtaquesPcPlayer = 0;
            double saludMainPlayer = pjMainPlayer.getSalud();
            double saludPcPlayer = pjPcPlayer.getSalud();


            while ((cantAtaquesMainPlayer != 7 || cantAtaquesPcPlayer != 7) && (saludMainPlayer != 0.00 && saludPcPlayer != 0.00)){
                // COMIENZA LA RONDA X

                if (jugadorAtacante == 1){
                    atacarYActualizarSalud(pjMainPlayer, pjPcPlayer);

                    saludPcPlayer = pjPcPlayer.getSalud();
                    cantAtaquesMainPlayer++;
                    logearYActualizarVista("Cantidad de ataques " + mainPlayer.getNombre() +  ": " + cantAtaquesMainPlayer + "\n");
                    jugadorAtacante = 2;

                }
                else{
                    atacarYActualizarSalud(pjPcPlayer, pjMainPlayer);

                    saludMainPlayer = pjMainPlayer.getSalud();
                    cantAtaquesPcPlayer++;
                    logearYActualizarVista("Cantidad de ataques PC: " + cantAtaquesPcPlayer + "\n");
                    jugadorAtacante = 1;

                }
            }

            if (saludMainPlayer == 0){
                eliminarPersonajeYDarBenficios(mainPlayer, pcPlayer, pjMainPlayer, pjPcPlayer);
                jugadorAtacante = 1;
            }
            else if (saludPcPlayer == 0){
                eliminarPersonajeYDarBenficios(pcPlayer, mainPlayer, pjPcPlayer, pjMainPlayer);
                jugadorAtacante = 2;
            }
            else{
                jugadorAtacante = random.nextInt(2)+1;
                logearYActualizarVista("Fue un empate, la ronda vuelve a empezar.");
            }
        }

        mostrarGanador();

    }

    public void eliminarPersonajeYDarBenficios(Jugador perdedor, Jugador ganador , Personaje pjPerdedor, Personaje pjGanador){
        double saludGanador = pjGanador.getSalud();

        perdedor.eliminarPersonaje(pjPerdedor);
        logearYActualizarVista("El jugador " + ganador.getNombre()  + "gana esta ronda");

        pjGanador.setSalud(saludGanador + 10);
        logearYActualizarVista(pjGanador.getNombre() + " gana +10 de vida");

    }

    public void mostrarGanador(){
        if (mainPlayer.getListaPersonajes().isEmpty()){
            logearYActualizarVista("\n" + mainPlayer.getNombre() + " se quedo sin cartas");
            logearYActualizarVista("El ganador del juego es PC");
        }
        else {
            logearYActualizarVista("\nPC se quedo sin cartas");
            logearYActualizarVista("El ganador del juego es " + mainPlayer.getNombre());
        }
    }

    public void atacarYActualizarSalud(Personaje pj1, Personaje pj2) {
        int valorAtaque, poderDefensa;
        double danioAtaque;

        valorAtaque = pj1.calcularValorDeAtaque(pj1.getDestreza(), pj1.getFuerza(), pj1.getNivel());
        poderDefensa = pj2.calcularPoderDefensa(pj2.getArmadura(), pj2.getVelocidad());

        danioAtaque = pj1.atacar(valorAtaque, poderDefensa);
        logearYActualizarVista("El daño de ataque fue de: " + String.format("%.2f", danioAtaque));

        if (danioAtaque < 0){
            danioAtaque = 0;
        }

        pj2.recibirDanio(danioAtaque);
        double saludPjAtacado = pj2.getSalud();
        logearYActualizarVista( pj2.getNombre() + " queda con " + String.format("%.2f", saludPjAtacado) + " de salud");
    }

}
