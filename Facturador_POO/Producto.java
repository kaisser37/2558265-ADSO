public class Producto {
    static int cumId = 1;
    int id;
    String nombre;
    float precio;

    public Producto(String nombre, float precio){
        this.id = cumId;
        cumId ++;
        this.nombre = nombre;
        this.precio = precio;
    }
    
}
