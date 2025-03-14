package com.centralpacientes;

import java.util.Scanner;

public class ListaPacientes {
    private Paciente cabeza; // Primer nodo de la lista enlazada

    public ListaPacientes() {
        this.cabeza = null;
    }

    // Método para agregar un paciente (evitando duplicados)
    public void agregarPaciente(int id, String nombre, int edad, String clinica) {
        if (buscarPaciente(id) != null) {
            System.out.println("⚠️ Error: Ya existe un paciente con el ID " + id);
            return;
        }
        Paciente nuevo = new Paciente(id, nombre, edad, clinica);
        if (cabeza == null) {
            cabeza = nuevo;
        } else {
            Paciente actual = cabeza;
            while (actual.getSiguiente() != null) {
                actual = actual.getSiguiente();
            }
            actual.setSiguiente(nuevo);
        }
        System.out.println("✅ Paciente agregado con éxito.");
    }

    // Método para buscar un paciente por ID
    public Paciente buscarPaciente(int id) {
        Paciente actual = cabeza;
        while (actual != null) {
            if (actual.getId() == id) {
                return actual;
            }
            actual = actual.getSiguiente();
        }
        return null; // No encontrado
    }

    // Método para modificar los datos de un paciente
    public void modificarPaciente(int id, Scanner scanner) {
        Paciente paciente = buscarPaciente(id);
        if (paciente == null) {
            System.out.println("⚠️ No se encontró un paciente con ese ID.");
            return;
        }

        System.out.println("✏️ Modificando datos del paciente:");

        System.out.print("Nuevo nombre (dejar vacío para no cambiar): ");
        scanner.nextLine(); // Consumir salto de línea
        String nuevoNombre = scanner.nextLine().trim();  // Eliminar espacios extra
        if (!nuevoNombre.isEmpty()) {
            paciente.setNombre(nuevoNombre);
        }

        System.out.print("Nueva edad (dejar vacío para no cambiar): ");
        String nuevaEdad = scanner.nextLine().trim();
        if (!nuevaEdad.isEmpty()) {
            try {
                paciente.setEdad(Integer.parseInt(nuevaEdad));
            } catch (NumberFormatException e) {
                System.out.println("⚠️ Edad no válida. No se realizaron cambios.");
            }
        }

        System.out.print("Nueva clínica (dejar vacío para no cambiar): ");
        String nuevaClinica = scanner.nextLine().trim();
        if (!nuevaClinica.isEmpty()) {
            paciente.setClinica(nuevaClinica);
        }

        System.out.println("✅ Datos actualizados con éxito.");
    }

    // Método para eliminar un paciente
    public void eliminarPaciente(int id) {
        if (cabeza == null) {
            System.out.println("⚠️ La lista está vacía.");
            return;
        }

        if (cabeza.getId() == id) {
            cabeza = cabeza.getSiguiente();
            System.out.println("✅ Paciente eliminado.");
            return;
        }

        Paciente actual = cabeza;
        while (actual.getSiguiente() != null) {
            if (actual.getSiguiente().getId() == id) {
                actual.setSiguiente(actual.getSiguiente().getSiguiente());
                System.out.println("✅ Paciente eliminado.");
                return;
            }
            actual = actual.getSiguiente();
        }

        System.out.println("⚠️ No se encontró un paciente con ese ID.");
    }

    // Método para mostrar la lista de pacientes con formato mejorado
    public void mostrarPacientes() {
        if (cabeza == null) {
            System.out.println("⚠️ No hay pacientes registrados.");
            return;
        }

        Paciente actual = cabeza;
        System.out.println("\n📋 Lista de Pacientes:");
        while (actual != null) {
            System.out.println("📌 ID: " + actual.getId());
            System.out.println("👤 Nombre: " + actual.getNombre());
            System.out.println("🎂 Edad: " + actual.getEdad() + " años");
            System.out.println("🏥 Clínica: " + actual.getClinica());
            System.out.println("----------------------------");
            actual = actual.getSiguiente();
        }
    }
}
