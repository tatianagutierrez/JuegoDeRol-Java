package com.company.controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardOpenOption;
import java.text.SimpleDateFormat;
import java.util.Date;

public class LoggerController {

    private final Path FILE_PATH = Paths.get("src/com/company/Logger/HistorialPartidas.txt");

    public void logearNuevaPartida(){

        String msj = "\n         NUEVA PARTIDA\n" +
                "--------------------------------\n    " +
                        obtenerFehcaActual() +
                "    \n--------------------------------\n\n";

        try {
            Files.writeString(FILE_PATH, msj, StandardOpenOption.CREATE, StandardOpenOption.APPEND);
        } catch(IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void logear(String msj){
        try {
            Files.writeString(FILE_PATH, msj,
                    StandardOpenOption.CREATE,    //Crea el archivo. TODO: Ver si es necesario porque ya esta en logear partida
                    StandardOpenOption.APPEND);   //Si ya exite solo agrega la info

        } catch(IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public void leerArchivo() throws IOException {
        Files.readString(FILE_PATH);
    }

    public void borrarArchivo() throws IOException {
        Files.delete(FILE_PATH);
    }

    private String obtenerFehcaActual(){
        return new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss z").format(new Date());
    }
}
