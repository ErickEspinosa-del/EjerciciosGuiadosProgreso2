package Producto2;

public class Producto {
    private static int contador = 0;     // compartido por toda la clase

    private int id;
    private String nombre;
    private double precio;
    private String categoria;

    public Producto(String nombre, double precio, String categoria) {
        this.nombre = nombre;
        this.precio = precio >= 0 ? precio : 0;
        this.categoria = categoria;
        contador++;
        this.id = contador;              // identificador automatico
    }

    public static int getTotalCreados() { return contador; }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public double getPrecio() { return precio; }
    public void setPrecio(double precio) {
        if (precio >= 0) {
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
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Precio: " + precio
                + " | Categoria: " + categoria);
    }
}
