package Producto2;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        final int MAX = 5;
        Producto productos[] = new Producto[MAX];
        Scanner sc = new Scanner(System.in);
        int indice = 0;
        int opc, cantidad;
        String nombre, categoria, buscado;
        double precio;

        do {
            System.out.println("\n===== PRODUCTOS (" + indice + "/" + MAX + ") =====");
            System.out.println("1. Ingresar una cantidad X de productos");
            System.out.println("2. Buscar un producto por nombre y mostrarlo");
            System.out.println("3. Aplicar descuento a un producto (por nombre)");
            System.out.println("4. Mostrar total de productos creados (static)");
            System.out.println("5. Salir");
            System.out.print("Opcion: ");
            opc = Integer.parseInt(sc.nextLine());

            switch (opc) {
                case 1:
                    System.out.print("Cuantos productos desea ingresar: ");
                    cantidad = Integer.parseInt(sc.nextLine());
                    if (cantidad > 0 && indice + cantidad <= MAX) {
                        int contador = 0;
                        while (contador < cantidad) {
                            System.out.print("Ingrese el nombre: ");
                            nombre = sc.nextLine();
                            System.out.print("Ingrese el precio: ");
                            precio = Double.parseDouble(sc.nextLine());
                            System.out.print("Ingrese la categoria: ");
                            categoria = sc.nextLine();
                            productos[indice++] = new Producto(nombre, precio, categoria);
                            contador++;
                        }
                    } else {
                        System.out.println("No hay espacio");
                    }
                    break;
                case 2:
                case 3:
                    System.out.print("Nombre del producto: ");
                    buscado = sc.nextLine();
                    int encontrado = -1;
                    for (int i = 0; i < indice; i++) {
                        if (productos[i].getNombre().equalsIgnoreCase(buscado)) {
                            encontrado = i;
                            break;
                        }
                    }
                    if (encontrado == -1) {
                        System.out.println("Producto no encontrado.");
                    } else if (opc == 2) {
                        productos[encontrado].mostrarDatos();
                    } else {
                        System.out.print("Porcentaje de descuento: ");
                        productos[encontrado].aplicarDescuento(Double.parseDouble(sc.nextLine()));
                        productos[encontrado].mostrarDatos();
                    }
                    break;
                case 4:
                    System.out.println("Total: " + Producto.getTotalCreados());
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