package com.ed.itm.pilalibros;
public class Editorial {
    private final String codigo;
    private final String nombre;
    public Editorial(String codigo, String nombre){this.codigo=codigo;this.nombre=nombre;}
    public String getCodigo(){return codigo;}
    public String getNombre(){return nombre;}
    @Override public String toString(){return "Editorial{codigo='"+codigo+"', nombre='"+nombre+"'}";}
}