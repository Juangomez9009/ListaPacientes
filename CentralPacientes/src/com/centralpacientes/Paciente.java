package com.centralpacientes;

public class Paciente {
    private int id;
    private String nombre;
    private int edad;
    private String clinica;
    private Paciente siguiente;

    public Paciente(int id, String nombre, int edad, String clinica) {
        this.id = id;
        this.nombre = nombre;
        this.edad = edad;
        this.clinica = clinica;
        this.siguiente = null;
    }

    // Getters
    public int getId() { return id; }
    public String getNombre() { return nombre; }
    public int getEdad() { return edad; }
    public String getClinica() { return clinica; }
    public Paciente getSiguiente() { return siguiente; }
    public void setSiguiente(Paciente siguiente) { this.siguiente = siguiente; }

    // Métodos Set para modificar los datos del paciente
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setEdad(int edad) { this.edad = edad; }
    public void setClinica(String clinica) { this.clinica = clinica; }

    @Override
    public String toString() {
        return "Paciente [ID=" + id + ", Nombre=" + nombre + ", Edad=" + edad + ", Clínica=" + clinica + "]";
    }
}
