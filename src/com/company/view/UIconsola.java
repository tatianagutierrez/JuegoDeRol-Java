package com.company.view;
import com.company.controller.UIcontroller;

import java.awt.*;
import java.util.Scanner;

public class UIconsola {

    UIcontroller controller;
    Scanner sc = new Scanner(System.in);

    public int elegirOpcion() {
        System.out.println("Bienvenido");
        System.out.println("¿Deseas jugar una partida?");
        System.out.println("1. Jugar");
        System.out.println("2. Leer historial de partidas");
        System.out.println("3. Borrar historial");
        System.out.println("4. Salir");
        System.out.print("Elija una opción: ");

        return sc.nextInt();
    }

    public String ingresarNombre(){
        System.out.println("Vamos a emprezar, primero dime como te llamas: ");
        return sc.next();
    }

    public void ejecutarOpcion(int op) {
        while (op != 4){
            switch (op){
                case 1:
                    controller.crearJuego(ingresarNombre());
                    break;
                case 2:
                    controller.leerHistorial();
                    break;
                case 3:
                    controller.borrarHistorial();
                    break;
            }
            op = elegirOpcion();
        }
    }

    /*
    public void ingresarDatosPersonaje() {



    }

    */

}
