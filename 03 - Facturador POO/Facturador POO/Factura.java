import java.util.*;

public class Factura {
    Date fecha;
    int numeroFactura;
    static int nextNumFactura = 1001;
    Persona cliente;
    Persona vendedor;
    ItemFactura[] arrayItems;
    float total;

    public Factura(Persona cliente, Persona vendedor, ItemFactura[] arrayItems, float total) {
        this.fecha = new Date();
        this.numeroFactura = nextNumFactura;
        nextNumFactura++;
        this.cliente = cliente;
        this.vendedor = vendedor;
        this.arrayItems = arrayItems;
        this.total = total;
    }

    public String getNombresCliente() {
        return this.cliente.nombres;
    }

    public String getNombresVendedor() {
        return this.vendedor.nombres;
    }

    public void verProductos(ItemFactura[] arrayItems ) {
        for(int i = 0; i < arrayItems.length; i++) {
            if (arrayItems[i] != null) {
                System.out.println("Id producto: " + arrayItems[i].producto.id);
                System.out.println("Nombre: " + arrayItems[i].producto.nombre);
                System.out.println("Precio und: " + arrayItems[i].producto.precio);
                System.out.println("Cantidad: " + arrayItems[i].cantidad);
                System.out.println("Subtotal: " + arrayItems[i].subtotal);
            }
            
        }
    }

    



}