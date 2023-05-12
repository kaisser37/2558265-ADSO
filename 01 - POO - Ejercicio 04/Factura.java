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
        return this.cliente.nombres;
    }
    



}