package cantantes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaCantantesFamosos listaCantantes = new ListaCantantesFamosos();
        menuPrincipal menu = new menuPrincipal();
        
        menu.setVisible(true);

        // Añadiendo cantantes manualmente
         System.out.println("Añadir cantantes a la lista:");
        for (int i = 0; i < 2; i++) {
            System.out.println("Cantante " + (i + 1) + ":");
            System.out.print("Nombre: ");
            String nombre = scanner.nextLine();
            System.out.print("Disco con más ventas: ");
            String disco = scanner.nextLine();
            System.out.print("Total de ventas: ");
            int ventas = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            CantanteFamoso cantante = new CantanteFamoso(nombre, disco, ventas);
            listaCantantes.añadirCantante(cantante);
        }

        int opcion;
        do {
            System.out.println("\nMenú:");
            System.out.println("1. Mostrar lista de cantantes");
            System.out.println("2. Eliminar cantante");
            System.out.println("3. Modificar cantante");
            System.out.println("4. Ordenar lista por ventas");
            System.out.println("5. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = scanner.nextInt();
            scanner.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    listaCantantes.mostrarLista();
                    break;
                case 2:
                    System.out.print("Ingrese el nombre del cantante a eliminar: ");
                    String nombreEliminar = scanner.nextLine();
                    listaCantantes.eliminarCantante(nombreEliminar);
                    System.out.println("Cantante eliminado.");
                    break;
                case 3:
                    System.out.print("Ingrese el nombre del cantante a modificar: ");
                    String nombreModificar = scanner.nextLine();
                    System.out.print("Nuevo nombre: ");
                    String nuevoNombre = scanner.nextLine();
                    System.out.print("Nuevo disco con más ventas: ");
                    String nuevoDisco = scanner.nextLine();
                    System.out.print("Nuevas ventas: ");
                    int nuevasVentas = scanner.nextInt();
                    scanner.nextLine(); // Ljuanimpiar el buffer
                    listaCantantes.modificarCantante(nombreModificar, nuevoNombre, nuevoDisco, nuevasVentas);
                    System.out.println("Cantante modificado.");
                    break;
                case 4:
                    listaCantantes.ordenarPorVentas();
                    System.out.println("Lista ordenada por ventas:");
                    listaCantantes.mostrarLista();
                    break;
                case 5:
                    System.out.println("¡Hasta luego!");
                    break;
                default:
                    System.out.println("Opción no válida.");
            }
        } while (opcion != 5);

        scanner.close();
    }
}