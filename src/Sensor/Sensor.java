package Sensor;

public class Sensor {
    private static int contador = 0;     // compartido por toda la clase

    private int id;
    private String nombre;
    private String tipo;
    private double lectura;

    public Sensor(String nombre, String tipo) {
        this.nombre = nombre;
        this.tipo = tipo;
        this.lectura = 0;
        contador++;
        this.id = contador;              // identificador automatico
    }

    public static int getTotalCreados() { return contador; }

    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public void setNombre(String nombre) { this.nombre = nombre; }
    public String getTipo() { return tipo; }
    public void setTipo(String tipo) { this.tipo = tipo; }

    public double getLectura() { return lectura; }
    public void setLectura(double lectura) {
        if (lectura >= 0) {              // validacion sencilla: no negativa
            this.lectura = lectura;
        }
    }

    public void actualizarLectura(double nuevaLectura) {
        setLectura(nuevaLectura);
    }

    public void mostrarDatos() {
        System.out.println("ID: " + id + " | Nombre: " + nombre + " | Tipo: " + tipo
                + " | Lectura: " + lectura);
    }
}
