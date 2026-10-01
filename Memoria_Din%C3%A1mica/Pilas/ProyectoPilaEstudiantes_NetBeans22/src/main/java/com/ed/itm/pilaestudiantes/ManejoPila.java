package com.ed.itm.pilaestudiantes;

import java.util.Scanner;

public class ManejoPila {
    private final Scanner sc;

    public ManejoPila(Scanner sc) {
        this.sc = sc;
    }

    public Pila ingresarPila(Pila objPila) {
        System.out.print("¿Desea ingresar un estudiante a la pila? 1. Si  2. No: ");
        int op = Integer.parseInt(sc.nextLine());
        while (op == 1) {
            System.out.print("Ingrese el código del nuevo estudiante: ");
            int cod = Integer.parseInt(sc.nextLine());

            if (!buscar(objPila, cod)) {
                Estudiante objE = new Estudiante().leerDatos(cod);
                objPila.push(objE);
                System.out.println("Estudiante agregado correctamente.");
            } else {
                System.out.println("Estudiante ya existe en la pila.");
            }

            System.out.print("¿Desea ingresar otro estudiante? 1. Si  2. No: ");
            op = Integer.parseInt(sc.nextLine());
        }
        return objPila;
    }

    public String imprimir(Pila objPila) {
        Pila pilaAux = new Pila(objPila.obtenerMaxsize());
        StringBuilder texto = new StringBuilder();

        while (!objPila.isEmpty()) {
            Estudiante info = (Estudiante) objPila.pop();
            texto.append(info).append(System.lineSeparator());
            pilaAux.push(info);
        }

        retornoPilaAux(objPila, pilaAux);
        return texto.length() == 0 ? "La pila está vacía" : texto.toString();
    }

    private void retornoPilaAux(Pila objPila, Pila objPilaAux) {
        while (!objPilaAux.isEmpty()) {
            objPila.push(objPilaAux.pop());
        }
    }

    public boolean buscar(Pila objPila, int cod) {
        Pila pilaAux = new Pila(objPila.obtenerMaxsize());
        boolean resp = false;

        while (!objPila.isEmpty()) {
            Estudiante datoE = (Estudiante) objPila.pop();
            if (datoE.obtenerCodigo() == cod) resp = true;
            pilaAux.push(datoE);
        }

        retornoPilaAux(objPila, pilaAux);
        return resp;
    }

    public Estudiante eliminar(Pila objPila, int cod) {
        Pila pilaAux = new Pila(objPila.obtenerMaxsize());
        Estudiante aux = null;

        while (!objPila.isEmpty()) {
            Estudiante info = (Estudiante) objPila.pop();
            if (info.obtenerCodigo() == cod) aux = info;
            else pilaAux.push(info);
        }

        retornoPilaAux(objPila, pilaAux);
        return aux;
    }

    public Estudiante consultar(Pila objPila, int cod) {
        Pila pilaAux = new Pila(objPila.obtenerMaxsize());
        Estudiante aux = null;

        while (!objPila.isEmpty()) {
            Estudiante info = (Estudiante) objPila.pop();
            if (info.obtenerCodigo() == cod) aux = info;
            pilaAux.push(info);
        }

        retornoPilaAux(objPila, pilaAux);
        return aux;
    }

    public void actualizarNotaDef(Pila objPila, int cod) {
        Pila pilaAux = new Pila(objPila.obtenerMaxsize());
        boolean encontrado = false;

        while (!objPila.isEmpty()) {
            Estudiante info = (Estudiante) objPila.pop();
            if (info.obtenerCodigo() == cod) {
                encontrado = true;
                System.out.print("Ingrese la nueva nota definitiva: ");
                double nota = Double.parseDouble(sc.nextLine());
                info.asignarNotaDef(nota);
                System.out.println("La nota fue actualizada exitosamente.");
            }
            pilaAux.push(info);
        }

        retornoPilaAux(objPila, pilaAux);
        if (!encontrado) System.out.println("El código del estudiante no existe en la pila.");
    }
}