package com.ed.itm.pilalibros;
public class Libro {
    private final String codigo,nombre,genero,codEditorial;
    private final int anioPublicacion,numPag;
    private final double valor;
    public Libro(String codigo,String nombre,int anioPublicacion,String genero,int numPag,double valor,String codEditorial){
        this.codigo=codigo;this.nombre=nombre;this.anioPublicacion=anioPublicacion;this.genero=genero;this.numPag=numPag;this.valor=valor;this.codEditorial=codEditorial;
    }
    public String getCodigo(){return codigo;} public String getNombre(){return nombre;}
    public int getAnioPublicacion(){return anioPublicacion;} public String getGenero(){return genero;}
    public int getNumPag(){return numPag;} public double getValor(){return valor;} public String getCodEditorial(){return codEditorial;}
    @Override public String toString(){return "Libro{codigo='"+codigo+"', nombre='"+nombre+"', anio="+anioPublicacion+", genero='"+genero+"', paginas="+numPag+", valor="+valor+", codEditorial='"+codEditorial+"'}";}
}