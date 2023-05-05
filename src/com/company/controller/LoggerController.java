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

        String msj = "\n\n         NUEVA PARTIDA\n" +
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
                    StandardOpenOption.CREATE,    //Crea el archivo.
                    StandardOpenOption.APPEND);   //Si ya exite solo agrega la info

        } catch(IOException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public String leerArchivo() throws IOException {
        if (Files.exists(FILE_PATH)){
            return Files.readString(FILE_PATH);
        }
        return "El archivo no existe";
    }

    public String borrarArchivo() throws IOException {
        if (Files.exists(FILE_PATH)){
            Files.delete(FILE_PATH);
            return "El historial se borró exitosamente";
        }
        return "El archivo no existe";
    }

    private String obtenerFehcaActual(){
        return new SimpleDateFormat("dd-MM-yyyy, HH:mm:ss z").format(new Date());
    }
}
