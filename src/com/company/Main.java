package com.company;
import com.company.controller.LoggerController;
import com.company.controller.UIcontroller;
import com.company.view.UIconsola;
import com.company.view.UImenu;

import java.util.Scanner;
import java.util.logging.Logger;

public class Main {

    public static void main(String[] args) {

        UIconsola consola = new UIconsola();
        UIcontroller controller = new UIcontroller();
        LoggerController logger = new LoggerController();
        Scanner sc = new Scanner(System.in);

        logger.logear(consola.menu());
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
            opcion = sc.nextInt();
        }

        /*
        UImenu ui = new UImenu();
        ui.setVisible(true);
        */
    }
}

