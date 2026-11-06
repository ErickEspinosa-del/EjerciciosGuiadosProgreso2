package Sensor;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 5;
        Sensor sensores[] = new Sensor[MAX];
        Scanner sc = new Scanner(System.in);
        int indice = 0;
        int opc, pos, cantidad;
        String nombre, tipo;

        do {
            System.out.println("\n===== SENSORES (" + indice + "/" + MAX + ") =====");
            System.out.println("1. Ingresar una cantidad X de sensores");
            System.out.println("2. Mostrar un sensor por indice");
            System.out.println("3. Actualizar la lectura de un sensor por indice");
            System.out.println("4. Mostrar total de sensores creados (static)");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Cuantos sensores desea ingresar: ");
                    cantidad = Integer.parseInt(sc.nextLine());
                    if (cantidad > 0 && indice + cantidad <= MAX) {
                        int contador = 0;
                        while (contador < cantidad) {
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el tipo: ");
                            tipo = sc.nextLine();
                            sensores[indice++] = new Sensor(nombre, tipo);
                            contador++;
                        }
                    } else {
                        System.out.println("No hay espacio");
                    }
                    break;
                case 2:
                case 3:
                    System.out.print("Ingrese el indice (0 a " + (indice - 1) + "): ");
                    pos = Integer.parseInt(sc.nextLine());
                    if (pos < 0 || pos >= indice) {
                        System.out.println("Indice invalido o sin datos.");
                        break;
                    }
                    if (opc == 2) {
                        sensores[pos].mostrarDatos();
                    } else {
                        System.out.print("Nueva lectura: ");
                        sensores[pos].actualizarLectura(Double.parseDouble(sc.nextLine()));
                        System.out.println("Lectura actual: " + sensores[pos].getLectura());
                    }
                    break;
                case 4:
                    System.out.println("Total: " + Sensor.getTotalCreados());
                    break;
                case 5:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opc != 5);
    }
}