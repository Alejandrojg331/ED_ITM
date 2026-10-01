package com.ed.itm.pilalibros;
import java.util.*;
public class ManejoPilaLibro {
    public boolean existeCodigo(Pila pila,String codigo){Pila aux=new Pila(pila.maxSize());boolean r=false;while(!pila.isEmpty()){Libro l=(Libro)pila.pop();if(l.getCodigo().equalsIgnoreCase(codigo))r=true;aux.push(l);}restaurar(pila,aux);return r;}
    private void restaurar(Pila p,Pila aux){while(!aux.isEmpty())p.push(aux.pop());}
    public void ingresarLibro(Pila pila,CrudEditorial crud,Scanner sc){
        System.out.print("Código del libro: ");String codigo=sc.nextLine();
        if(existeCodigo(pila,codigo)){System.out.println("El código ya existe en la pila.");return;}
        System.out.print("Nombre: ");String nombre=sc.nextLine();
        System.out.print("Año de publicación: ");int anio=Integer.parseInt(sc.nextLine());
        System.out.print("Género: ");String genero=sc.nextLine();
        System.out.print("Número de páginas: ");int paginas=Integer.parseInt(sc.nextLine());
        System.out.print("Valor: ");double valor=Double.parseDouble(sc.nextLine());
        System.out.print("Código de editorial: ");String codEd=sc.nextLine();
        if(!crud.existe(codEd)){System.out.println("La editorial no existe en Editorial.csv.");return;}
        pila.push(new Libro(codigo,nombre,anio,genero,paginas,valor,codEd));System.out.println("Libro agregado correctamente.");
    }
    public void mostrar(Pila pila){if(pila.isEmpty()){System.out.println("La pila está vacía.");return;}Pila aux=new Pila(pila.maxSize());while(!pila.isEmpty()){Libro l=(Libro)pila.pop();System.out.println(l);aux.push(l);}restaurar(pila,aux);}
    public void publicadosEnAnio(Pila pila,int anio){Pila aux=new Pila(pila.maxSize());boolean hallado=false;while(!pila.isEmpty()){Libro l=(Libro)pila.pop();if(l.getAnioPublicacion()==anio){System.out.println(l);hallado=true;}aux.push(l);}restaurar(pila,aux);if(!hallado)System.out.println("No hay libros publicados en ese año.");}
    public void mayorValor(Pila pila){Pila aux=new Pila(pila.maxSize());Libro mayor=null;while(!pila.isEmpty()){Libro l=(Libro)pila.pop();if(mayor==null||l.getValor()>mayor.getValor())mayor=l;aux.push(l);}restaurar(pila,aux);System.out.println(mayor==null?"La pila está vacía.":"Libro con mayor valor: "+mayor);}
    public void cantidadGenero(Pila pila,String genero){Pila aux=new Pila(pila.maxSize());int cantidad=0;while(!pila.isEmpty()){Libro l=(Libro)pila.pop();if(l.getGenero().equalsIgnoreCase(genero))cantidad++;aux.push(l);}restaurar(pila,aux);System.out.println("Cantidad de libros del género: "+cantidad);}
    public void promedioPaginasEditorial(Pila pila,String codEd){Pila aux=new Pila(pila.maxSize());int cantidad=0,total=0;while(!pila.isEmpty()){Libro l=(Libro)pila.pop();if(l.getCodEditorial().equalsIgnoreCase(codEd)){total+=l.getNumPag();cantidad++;}aux.push(l);}restaurar(pila,aux);if(cantidad==0)System.out.println("No hay libros de esa editorial.");else System.out.println("Promedio de páginas: "+(total/(double)cantidad));}
}