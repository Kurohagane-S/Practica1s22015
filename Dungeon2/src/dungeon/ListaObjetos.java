package dungeon;

public class ListaObjetos {

    public String Name;
    public String ID;    
    public ListaObjetos anterior;
    public ListaObjetos siguiente;
    
    public ListaObjetos(){
        Name=null;
        ID=null;
        anterior=null;
        siguiente=null;
    }
    public ListaObjetos(String Nombre){
        Name=Nombre;
        //ID=Carnet;
        anterior=null;
        siguiente=null;
    }   
    
    
    public String getName(){
        return Name;
    }
    
    public String getID(){
        return ID;
    } 
        
    public void SetNombre(String Nombre){
        this.Name = Nombre;
    }
    
    public void SetData(String Nombre,String Carnet){
        Name=Nombre;
        ID=Carnet;
    }   
}
