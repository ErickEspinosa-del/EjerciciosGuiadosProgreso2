package Producto;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 3;
        Producto inventario[] = new Producto[MAX];
        Scanner sc = new Scanner(System.in);
        boolean lleno = false;
        int opc;

        do {
            System.out.println("\n===== INVENTARIO (arreglo completo) =====");
            System.out.println("1. Llenar todo el arreglo");
            System.out.println("2. Mostrar todos los productos");
            System.out.println("3. Aplicar descuento a todos");
            System.out.println("4. Mostrar precio total y producto mas caro");
            System.out.println("5. Intentar poner precio negativo a todos (prueba de validacion)");
            System.out.println("6. Salir");
            System.out.print("Opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            if (opc >= 2 && opc <= 5 && !lleno) {
                System.out.println("Primero debe llenar el arreglo (opcion 1).");
                continue;
            }

            switch (opc) {
                case 1:
                    for (int i = 0; i < inventario.length; i++) {
                        inventario[i] = new Producto();
                        System.out.println("--- Producto " + (i + 1) + " ---");
                        System.out.print("Ingrese el nombre: ");
                        inventario[i].setNombre(sc.nextLine());
                        System.out.print("Ingrese el precio: ");
                        inventario[i].setPrecio(Double.parseDouble(sc.nextLine()));
                        System.out.print("Ingrese la categoria: ");
                        inventario[i].setCategoria(sc.nextLine());
                    }
                    lleno = true;
                    break;
                case 2:
                    for (int i = 0; i < inventario.length; i++) {
                        inventario[i].mostrarDatos();
                    }
                    break;
                case 3:
                    System.out.print("Porcentaje de descuento: ");
                    double porc = Double.parseDouble(sc.nextLine());
                    for (int i = 0; i < inventario.length; i++) {
                        inventario[i].aplicarDescuento(porc);
                    }
                    System.out.println("Descuento aplicado a todos.");
                    break;
                case 4:
                    double total = 0;
                    int mayor = 0;
                    for (int i = 0; i < inventario.length; i++) {
                        total += inventario[i].getPrecio();
                        if (inventario[i].getPrecio() > inventario[mayor].getPrecio()) {
                            mayor = i;
                        }
                    }
                    System.out.println("Precio total: " + total);
                    System.out.println("Producto mas caro: " + inventario[mayor].getNombre()
                            + " (" + inventario[mayor].getPrecio() + ")");
                    break;
                case 5:
                    for (int i = 0; i < inventario.length; i++) {
                        inventario[i].setPrecio(-100);
                        System.out.println(inventario[i].getNombre() + " -> precio sigue en "
                                + inventario[i].getPrecio());
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