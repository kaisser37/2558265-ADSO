public class Productos {
    int id;
    String nombre;
    int stock;

    public Productos( int id, String nombre, int stock ){
        this.id = id;
        this.nombre = nombre;
        this.stock = stock;
    }

    public int getId(){
        return this.id;
    }

    public String getNombre(){
        return this.nombre;
    }

    public int getStock(){
        return this.stock;
    }

    public void setId(int id){
        this.id = id;
    }

    public void setNombre(String nombre){
        this.nombre = nombre;
    }

    public void setDireccion(int stock){
        this.stock = stock;
    }
}