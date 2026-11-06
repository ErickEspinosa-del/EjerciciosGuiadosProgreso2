package Producto;

public class Producto {
    private String nombre;
    private double precio;
    private String categoria;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }

    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio >= 0) {          // un precio no puede ser negativo
            this.precio = precio;
        }
    }

    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }

    public void aplicarDescuento(double porcentaje) {
        if (porcentaje > 0 && porcentaje <= 100) {
            this.precio = this.precio - (this.precio * porcentaje / 100);
        }
    }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " | Precio: " + precio + " | Categoria: " + categoria);
    }
}