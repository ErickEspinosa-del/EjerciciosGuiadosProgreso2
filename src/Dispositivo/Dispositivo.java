package Dispositivo;

public class Dispositivo {
    private String nombre;
    private String tipo;
    private boolean activo;

    public String getNombre() { return nombre; }
    public void setNombre(String nombre) {
        if (nombre != null && !nombre.trim().isEmpty()) {   // no se permite nombre vacio
            this.nombre = nombre;
        }
    }

    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public boolean isActivo() { return activo; }
    public void setActivo(boolean activo) { this.activo = activo; }

    public void activar() { this.activo = true; }
    public void desactivar() { this.activo = false; }

    public void mostrarDatos() {
        System.out.println("Nombre: " + nombre + " | Tipo: " + tipo
                + " | Estado: " + (activo ? "ACTIVO" : "INACTIVO"));
    }
}