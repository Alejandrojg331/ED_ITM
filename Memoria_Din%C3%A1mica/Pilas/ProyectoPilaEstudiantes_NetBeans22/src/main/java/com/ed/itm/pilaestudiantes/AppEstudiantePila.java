package com.ed.itm.pilaestudiantes;

import java.util.Scanner;

public class AppEstudiantePila {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Pila pila = new Pila(10);
        ManejoPila manejo = new ManejoPila(sc);
        int opcion;

        do {
            System.out.println("\n========================================");
            System.out.println("          GESTIÓN DE PILA");
            System.out.println("========================================");
            System.out.println("1. Ingresar estudiante");
            System.out.println("2. Mostrar estudiantes");
            System.out.println("3. Consultar estudiante");
            System.out.println("4. Buscar estudiante");
            System.out.println("5. Eliminar estudiante");
            System.out.println("6. Actualizar nota definitiva");
            System.out.println("7. Ver elemento en el tope");
            System.out.println("8. Retirar elemento de la pila");
            System.out.println("9. Mostrar estado de la pila");
            System.out.println("0. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = Integer.parseInt(sc.nextLine());

            switch (opcion) {
                case 1 -> pila = manejo.ingresarPila(pila);
                case 2 -> System.out.println("\nESTUDIANTES EN LA PILA\n-----------------------\n" + manejo.imprimir(pila));
                case 3 -> {
                    System.out.print("Ingrese el código del estudiante a consultar: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    Estudiante resultado = manejo.consultar(pila, codigo);
                    System.out.println(resultado == null ? "El estudiante no existe en la pila." : "Estudiante encontrado: " + resultado);
                }
                case 4 -> {
                    System.out.print("Ingrese el código del estudiante a buscar: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    System.out.println(manejo.buscar(pila, codigo) ? "El estudiante existe en la pila." : "El estudiante NO existe en la pila.");
                }
                case 5 -> {
                    System.out.print("Ingrese el código del estudiante a eliminar: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    Estudiante resultado = manejo.eliminar(pila, codigo);
                    System.out.println(resultado == null ? "No se encontró el estudiante." : "Estudiante eliminado: " + resultado);
                }
                case 6 -> {
                    System.out.print("Ingrese el código del estudiante: ");
                    int codigo = Integer.parseInt(sc.nextLine());
                    manejo.actualizarNotaDef(pila, codigo);
                }
                case 7 -> System.out.println(pila.isEmpty() ? "La pila está vacía." : "Elemento en el tope: " + pila.peek());
                case 8 -> System.out.println(pila.isEmpty() ? "La pila está vacía." : "Elemento retirado: " + pila.pop());
                case 9 -> {
                    System.out.println("\nESTADO DE LA PILA");
                    System.out.println("-----------------");
                    System.out.println("Capacidad máxima: " + pila.obtenerMaxsize());
                    System.out.println("Cantidad de elementos: " + pila.obtenerSize());
                    System.out.println("Estado: " + (pila.isEmpty() ? "VACÍA" : pila.isFull() ? "LLENA" : "DISPONIBLE"));
                }
                case 0 -> System.out.println("Programa finalizado.");
                default -> System.out.println("Opción no válida. Intente nuevamente.");
            }
        } while (opcion != 0);
        sc.close();
    }
}