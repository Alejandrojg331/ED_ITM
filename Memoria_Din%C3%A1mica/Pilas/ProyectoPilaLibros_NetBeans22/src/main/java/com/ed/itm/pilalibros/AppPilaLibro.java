package com.ed.itm.pilalibros;
import java.io.*; import java.util.*;
public class AppPilaLibro {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Pila pila=new Pila(20);
        try {
            CrudEditorial crud=new CrudEditorial(Archivo.leerEditoriales("Editorial.csv"));
            ManejoPilaLibro manejo=new ManejoPilaLibro();
            int op;
            do {
                System.out.println("\n==============================");
                System.out.println("        PILA DE LIBROS");
                System.out.println("==============================");
                System.out.println("1. Ingresar libro");
                System.out.println("2. Mostrar libros");
                System.out.println("3. Consultar libros por año");
                System.out.println("4. Libro con mayor valor");
                System.out.println("5. Cantidad por género");
                System.out.println("6. Promedio de páginas por editorial");
                System.out.println("7. Mostrar editoriales");
                System.out.println("0. Salir");
                System.out.print("Seleccione una opción: ");op=Integer.parseInt(sc.nextLine());
                switch(op){
                    case 1 -> manejo.ingresarLibro(pila,crud,sc);
                    case 2 -> manejo.mostrar(pila);
                    case 3 -> {System.out.print("Año: ");manejo.publicadosEnAnio(pila,Integer.parseInt(sc.nextLine()));}
                    case 4 -> manejo.mayorValor(pila);
                    case 5 -> {System.out.print("Género: ");manejo.cantidadGenero(pila,sc.nextLine());}
                    case 6 -> {System.out.print("Código editorial: ");manejo.promedioPaginasEditorial(pila,sc.nextLine());}
                    case 7 -> crud.listar().forEach(System.out::println);
                    case 0 -> System.out.println("Programa finalizado.");
                    default -> System.out.println("Opción no válida.");
                }
            } while(op!=0);
        } catch(IOException e){System.out.println("Error al leer Editorial.csv: "+e.getMessage());}
        sc.close();
    }
}