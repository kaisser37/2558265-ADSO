public class ItemFactura {
    Producto producto;
    int cantidad;
    float subtotal;

    public ItemFactura(Producto producto, int cantidad, float subtotal) {
        this.producto = producto;
        this.cantidad = cantidad;
        this.subtotal = subtotal;

    }
}
