package Dispositivo;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 3;
        Dispositivo dispositivos[] = new Dispositivo[MAX];
        Scanner sc = new Scanner(System.in);
        int indice = 0;      // siguiente posicion libre
        int opc, pos;

        do {
            System.out.println("\n===== DISPOSITIVOS (" + indice + "/" + MAX + ") =====");
            System.out.println("1. Ingresar un dispositivo (1 en 1)");
            System.out.println("2. Mostrar un dispositivo por indice");
            System.out.println("3. Activar un dispositivo por indice");
            System.out.println("4. Desactivar un dispositivo por indice");
            System.out.println("5. Cambiar el nombre de un dispositivo por indice");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    if (indice < MAX) {
                        Dispositivo d = new Dispositivo();
                        System.out.print("Ingrese el nombre: ");
                        d.setNombre(sc.nextLine());
                        System.out.print("Ingrese el tipo: ");
                        d.setTipo(sc.nextLine());
                        dispositivos[indice++] = d;
                    } else {
                        System.out.println("No hay mas memoria");
                    }
                    break;
                case 2:
                case 3:
                case 4:
                case 5:
                    System.out.print("Ingrese el indice (0 a " + (indice - 1) + "): ");
                    pos = Integer.parseInt(sc.nextLine());
                    if (pos < 0 || pos >= indice) {
                        System.out.println("Indice invalido o sin datos.");
                        break;
                    }
                    if (opc == 2) {
                        dispositivos[pos].mostrarDatos();
                    } else if (opc == 3) {
                        dispositivos[pos].activar();
                        System.out.println("Dispositivo activado.");
                    } else if (opc == 4) {
                        dispositivos[pos].desactivar();
                        System.out.println("Dispositivo desactivado.");
                    } else {
                        System.out.print("Nuevo nombre: ");
                        dispositivos[pos].setNombre(sc.nextLine());
                        System.out.println("Nombre actual: " + dispositivos[pos].getNombre());
                    }
                    break;
                case 6:
                    System.out.println("Fin del programa.");
                    break;
                default:
                    System.out.println("Opcion invalida.");
            }
        } while (opc != 6);
    }
}
