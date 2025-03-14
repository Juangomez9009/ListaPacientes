package com.centralpacientes;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ListaPacientes lista = new ListaPacientes();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n1. Agregar Paciente");
            System.out.println("2. Buscar Paciente");
            System.out.println("3. Eliminar Paciente");
            System.out.println("4. Mostrar Todos");
            System.out.println("5. Modificar Paciente");
            System.out.println("6. Salir");
            System.out.print("Elige una opción: ");
            int opcion = scanner.nextInt();

            switch (opcion) {
                case 1:
                    System.out.print("ID: ");
                    int id = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Nombre: ");
                    String nombre = scanner.nextLine();
                    System.out.print("Edad: ");
                    int edad = scanner.nextInt();
                    scanner.nextLine();
                    System.out.print("Clínica: ");
                    String clinica = scanner.nextLine();
                    lista.agregarPaciente(id, nombre, edad, clinica);
                    break;
                case 2:
                    System.out.print("ID del paciente a buscar: ");
                    int idBuscar = scanner.nextInt();
                    Paciente encontrado = lista.buscarPaciente(idBuscar);
                    System.out.println(encontrado != null ? encontrado : "⚠️ Paciente no encontrado.");
                    break;
                case 3:
                    System.out.print("ID del paciente a eliminar: ");
                    int idEliminar = scanner.nextInt();
                    lista.eliminarPaciente(idEliminar);
                    break;
                case 4:
                    lista.mostrarPacientes();
                    break;
                case 5:
                    System.out.print("ID del paciente a modificar: ");
                    int idModificar = scanner.nextInt();
                    lista.modificarPaciente(idModificar, scanner);
                    break;
                case 6:
                    System.out.println("Saliendo...");
                    scanner.close();
                    return;
                default:
                    System.out.println("⚠️ Opción no válida.");
            }
        }
    }
}
