package com.ed.itm.pilalibros;
import java.io.*; import java.nio.file.*; import java.util.*;
public class Archivo {
    public static List<Editorial> leerEditoriales(String ruta) throws IOException {
        List<Editorial> lista=new ArrayList<>();
        Path p=Paths.get(ruta);
        if(!Files.exists(p)){crearEjemplo(ruta); }
        for(String linea:Files.readAllLines(Paths.get(ruta))){
            if(linea.isBlank()||linea.toLowerCase().startsWith("codigo")) continue;
            String[] partes=linea.split(",",2);
            if(partes.length==2) lista.add(new Editorial(partes[0].trim(),partes[1].trim()));
        }
        return lista;
    }
    private static void crearEjemplo(String ruta) throws IOException {
        Path p=Paths.get(ruta); if(p.getParent()!=null) Files.createDirectories(p.getParent());
        Files.writeString(p,"codigo,nombre\nED01,Editorial Alfa\nED02,Editorial Beta\nED03,Editorial Gamma\n");
    }
}