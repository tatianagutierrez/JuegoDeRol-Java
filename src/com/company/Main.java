package com.company;
import com.company.controller.LoggerController;
import com.company.controller.UIcontroller;
import com.company.view.UIconsola;

import java.io.IOException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws IOException {

        UIconsola consola = new UIconsola();
        UIcontroller controller = new UIcontroller();
        Scanner sc = new Scanner(System.in);

        System.out.print(consola.menu());
        int opcion = sc.nextInt();

        while (opcion != 4){
            switch (opcion){
                case 1:
                    String nombre = consola.ingresarNombre();
                    int opcionPersonajes = consola.opcionCreacionPersonajes();
                    controller.crearJuego(nombre, opcionPersonajes);
                    break;
                case 2:
                    controller.leerHistorial();
                    break;
                case 3:
                    controller.borrarHistorial();
                    break;
            }

            System.out.print(consola.menu());
            opcion = sc.nextInt();
        }
    }
}

