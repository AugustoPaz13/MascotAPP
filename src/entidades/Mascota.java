package entidades;

public class Mascota {
    private String nombre;
    private String raza;
    private String apodo;
    private String color;
    //gato,perro,loro,etc
    private String tipo;
    private int edad;
    private int idUsuario;
    private String nombreUsuario;
    private int id;
    private static int contadorId = 1; // Variable estática para generar IDs únicos
    private boolean cola;

    public Mascota() {
        this.id = contadorId++; // Asignar un ID único e incrementar el contador
    }

    public Mascota(String nombre, String raza, String apodo, String color, String tipo, int edad, boolean cola) {
        this.nombre = nombre;
        this.raza = raza;
        this.apodo = apodo;
        this.color = color;
        this.tipo = tipo;
        this.edad = edad;
        this.cola = cola;
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

    public String getRaza() {
        return raza;
    }

    public void setRaza(String raza) {
        this.raza = raza;
    }

    public String getApodo() {
        return apodo;
    }

    public void setApodo(String apodo) {
        this.apodo = apodo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public boolean isCola() {
        return cola;
    }

    public void setCola(boolean cola) {
        this.cola = cola;
    }

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }
}
