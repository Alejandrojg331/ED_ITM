
package pr_listasimple;

public class AppListaSimple {

  
    public static void main(String[] args) 
    {
       ListaSimple lista = new ListaSimple();
       lista.insertarNodoPorFinal(10);
       lista.insertarNodoPorFinal(20);
       lista.insertarNodoPorInicio(5);
       lista.listarNodos();
    }
    
}
