public class Producto {
    static int nextId = 1;
    int id;
    String nombre;
    float precio;

    public Producto(String nombre, float precio) {
        this.id = nextId;
        nextId++;
        this.nombre = nombre;
        this.precio = precio;
    }
}