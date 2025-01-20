package entidades;

import java.time.LocalDate;

public class Usuario {
    private String nombre;
    private String apellido;
    private String pais;
    private LocalDate nacimiento;
    private int dni;
    private int id;
    private static int contadorId = 1; // Variable estática para generar IDs únicos


    public Usuario() {
        this.id = contadorId++; // Asignar un ID único e incrementar el contador
    }

    public Usuario(String nombre, String apellido, String pais, LocalDate nacimiento, int dni) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.pais = pais;
        this.nacimiento = nacimiento;
        this.dni = dni;
        this.id = contadorId++; // Asignar un ID único e incrementar el contador

    }

    public int getId() {
        return id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getPais() {
        return pais;
    }

    public void setPais(String pais) {
        this.pais = pais;
    }

    public LocalDate getNacimiento() {
        return nacimiento;
    }

    public void setNacimiento(LocalDate nacimiento) {
        this.nacimiento = nacimiento;
    }

    public int getDni() {
        return dni;
    }

    public void setDni(int dni) {
        this.dni = dni;
    }
}
