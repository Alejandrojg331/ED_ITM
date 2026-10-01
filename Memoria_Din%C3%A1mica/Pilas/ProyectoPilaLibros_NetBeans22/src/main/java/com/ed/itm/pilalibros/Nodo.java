package com.ed.itm.pilalibros;
public class Nodo {
    private Object dato; private Nodo sig;
    public Nodo(Object dato){this.dato=dato;}
    public Object getDato(){return dato;} public Nodo getSig(){return sig;} public void setSig(Nodo sig){this.sig=sig;}
}