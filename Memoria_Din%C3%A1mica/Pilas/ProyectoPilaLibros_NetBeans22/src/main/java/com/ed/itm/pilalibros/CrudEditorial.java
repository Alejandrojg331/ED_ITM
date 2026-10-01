package com.ed.itm.pilalibros;
import java.util.*;
public class CrudEditorial {
    private final List<Editorial> editoriales;
    public CrudEditorial(List<Editorial> editoriales){this.editoriales=editoriales;}
    public Editorial consultar(String codigo){for(Editorial e:editoriales)if(e.getCodigo().equalsIgnoreCase(codigo))return e;return null;}
    public boolean existe(String codigo){return consultar(codigo)!=null;}
    public List<Editorial> listar(){return Collections.unmodifiableList(editoriales);}
}