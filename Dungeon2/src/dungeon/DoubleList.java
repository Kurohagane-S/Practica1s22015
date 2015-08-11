package dungeon;

import java.util.LinkedList;
import javax.swing.JTextArea;

public class DoubleList {
    public ListaObjetos primero;
    public ListaObjetos ultimo;
    
    //-----------lista para POCISIONES DE COLLISIONES
    
    LinkedList Collisions = null;
    
    DoubleList(){
        primero=null;
        ultimo=null;
    }
  
    public boolean estavacio(){
        if(primero==null){ return true;
        }else{ return false;}
    }
  
    public DoubleList SetDatos(String Nombre,String Carnet){
     if(estavacio()){
      ListaObjetos nuevo=new ListaObjetos(/*Nombre,Carnet*/);
      primero=nuevo;
      ultimo=nuevo;
      nuevo.siguiente=nuevo;
      nuevo.anterior=nuevo;
     }else{
      ListaObjetos nuevo=new ListaObjetos(/*Nombre,Carnet*/);
      ultimo.siguiente=nuevo;
      nuevo.anterior=ultimo;
      ultimo=nuevo;//
      primero.anterior=ultimo;
      ultimo.siguiente=primero;
      //ultimo=nuevo; 
     }
     return this;
    }   
    
    public DoubleList SetObjeto(String Nombre){
     if(estavacio()){
      ListaObjetos nuevo=new ListaObjetos(Nombre);
      primero=nuevo;
      ultimo=nuevo;
      nuevo.siguiente=nuevo;
      nuevo.anterior=nuevo;
     }else{
      ListaObjetos nuevo=new ListaObjetos(Nombre);
      ultimo.siguiente=nuevo;
      nuevo.anterior=ultimo;
      ultimo=nuevo;//
      primero.anterior=ultimo;
      ultimo.siguiente=primero;
      //ultimo=nuevo; 
     }
     return this;
    } 
    
    
     
    public void imprimirNombre(){
        ListaObjetos actual;
        actual=primero;
        
        int  i = 0;
        
        while(actual!=ultimo){
            System.out.println(actual.Name + " " + i);
            actual=actual.siguiente;
            i+=1;
        }
        System.out.println(actual.Name + " " + i);
        
        }
    
    public void imprimirObjetos(){
        ListaObjetos actual;
        actual=primero;
        
        int  i = 0;
        
        while(actual!=ultimo){
            if(actual.Name.contains("Deleted")){
            actual=actual.siguiente;
            }else{
                System.out.println( i + " " + actual.Name);
            actual=actual.siguiente;
            i+=1;
            }            
        }
        System.out.println( i + " " + actual.Name);
        
        }
    
    public void AreaObjetos(JTextArea NuevaArea){
        ListaObjetos actual;
        actual=primero;
        
       
        
        int  i = 0;
        
        while(actual!=ultimo){
            if(actual.Name.contains("Deleted")){
            actual=actual.siguiente;
            }else{
                NuevaArea.append(i + " " + actual.Name +"\n");
                
                //System.out.println( i + " " + actual.Name);
            actual=actual.siguiente;
            i+=1;
            }            
        }
        //System.out.println( i + " " + actual.Name);
        NuevaArea.append(i + " " + actual.Name +"\n");
        }
    
    public String List_to_JPG(String Texto){
        ListaObjetos actual;
        actual=primero;
        
         LinkedList<String> objetos = new LinkedList();
        
        int  i = 0;
        Texto = "";
        Texto = "digraph G \n" +
                "{ \n"+ " node [shape=circle];\n" +
                        " node [style=filled];\n" +
                        " node [fillcolor=\"#EEEEEE\"];\n" +
                        " node [color=\"#EEEEEE\"];\n" +
                        " edge [color=\"#31CEF0\"];\n";
        
        String temp;
        
        if(!estavacio()){
        
        while(actual!=ultimo){
            if(actual.Name.contains("Deleted")){
                actual=actual.siguiente;
            }else{  
                Texto += actual.Name + i + " ->" + "\n" ;                    
                //NuevaArea.append(i + " " + actual.Name +"\n");
                //System.out.println( i + " " + actual.Name);
                objetos.add(actual.Name);
                actual=actual.siguiente;
            i+=1;
            }            
        }
        Texto += actual.Name + i +  ";\n";
        
        objetos.add(actual.Name);
        //System.out.println( i + " " + actual.Name);
        //NuevaArea.append(i + " " + actual.Name +"\n");
        try{
            for (int j = objetos.size()-1; j >= 0; j-- ) {
                //System.out.println(objetos.get(j));
                if(j!=0){
                    Texto += objetos.get(j) + j + " ->" + "\n" ;
                }else{
                    Texto += objetos.get(j) + j  ;
                }
                
            }
        }catch(Exception e){}
            
        Texto += ";\nrankdir=LR;\n" +
        "}" ;
        }
        return Texto;
        //System.out.println(Texto);
    }
    
    
    
    
    
    /*public void imprimirID(){
        ListaObjetos actual;
        actual=primero;
        while(actual!=ultimo){
            System.out.println(actual.ID);
            actual=actual.siguiente;}
        System.out.println(actual.ID);
        }*/
}

