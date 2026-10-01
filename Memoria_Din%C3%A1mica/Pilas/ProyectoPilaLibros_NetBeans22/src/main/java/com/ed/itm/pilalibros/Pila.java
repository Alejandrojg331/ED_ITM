package com.ed.itm.pilalibros;
public class Pila {
    private final int maxSize; private int size; private Nodo top;
    public Pila(int maxSize){this.maxSize=maxSize;}
    public boolean isEmpty(){return size==0;} public boolean isFull(){return size>=maxSize;}
    public void push(Object dato){if(isFull()) throw new IllegalStateException("La pila está llena."); Nodo n=new Nodo(dato);n.setSig(top);top=n;size++;}
    public Object pop(){if(isEmpty()) return null; Object d=top.getDato();top=top.getSig();size--;return d;}
    public Object peek(){return isEmpty()?null:top.getDato();}
    public int size(){return size;} public int maxSize(){return maxSize;}
}