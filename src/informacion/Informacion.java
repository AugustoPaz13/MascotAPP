package informacion;

import entidades.Mascota;
import entidades.Usuario;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Scanner;

public class Informacion {
    private static final Scanner consola = new Scanner(System.in);
    private static Mascota[] arregloMascotas = new Mascota[100]; // Tamaño fijo
    private static Usuario[] arregloUsuarios = new Usuario[100];
    private static int contadorMascotas = 0; // Índice para saber dónde agregar
    private static int contadorUsuarios = 0;

    public void crearMascota(){
        Mascota mascota = new Mascota();

        System.out.println("¿Cual es el nombre de su mascota?");
        mascota.setNombre(consola.nextLine());
        System.out.println("¿Cual es el apodo de su mascota?");
        mascota.setApodo(consola.nextLine());
        int edad = -1;
        while (edad < 0) {
            System.out.println("¿Cual es la edad de su mascota?");
            try {
                edad = Integer.parseInt(consola.nextLine());
            } catch (NumberFormatException e) {
                System.out.println("Por favor ingrese un número válido.");
            }
        }
        System.out.println("¿Cual es el tipo de mascota?");
        mascota.setTipo(consola.nextLine());
        System.out.println("¿Cual es la raza de su mascota?");
        mascota.setRaza(consola.nextLine());
        System.out.println("¿Cual es el color de su mascota?");
        mascota.setColor(consola.nextLine());
        System.out.println("¿Su mascota tiene cola? true/false");
        mascota.setCola(Boolean.parseBoolean(consola.nextLine()));
        mostrarUsuario(false);
        System.out.print("Ingrese el ID de su dueño: ");
        mascota.setIdUsuario(Integer.parseInt(consola.nextLine()));
        //Mostrar lista de dueños
        boolean datosValidos = true;
        for (int i = 0; i < contadorUsuarios; i++) {
            Usuario usuario = arregloUsuarios[i];
            //Asignar dueño a la mascota
            if(usuario.getId() == mascota.getIdUsuario()){
                mascota.setNombreUsuario(usuario.getNombre());
            }else{
                System.out.println("ID de dueño no encontrada...");
                datosValidos = false;
            }
        }

        if(datosValidos){
            if (contadorMascotas < arregloMascotas.length) {
                arregloMascotas[contadorMascotas++] = mascota; // Guardar en el arreglo
                System.out.println("---------------------------------------------------");
                System.out.println("Mascota creada con éxito con ID: " + mascota.getId());
                System.out.println("---------------------------------------------------");
            } else {
                System.out.println("Error: No se pueden agregar más mascotas, el arreglo está lleno.");
            }
        }else{
            System.out.println("No se pudo crear el usuario debido a un error en los datos.");
        }

    }

    public void crearUsuario(){
        Usuario usuario = new Usuario();
        System.out.println("¿Cual es el nombre del dueño?");
        usuario.setNombre(consola.nextLine());
        System.out.println("¿Cual es el apellido del dueño?");
        usuario.setApellido(consola.nextLine());
        System.out.println("¿Cual es el DNI del dueño?");
        usuario.setDni(Integer.parseInt(consola.nextLine()));
        System.out.println("¿Cual es el pais del dueño?");
        usuario.setPais(consola.nextLine());
        System.out.println("¿Cual es la fecha de nacimiento del dueño? (AAAA-MM-DD)");
        String fechaTexto = consola.nextLine();

        boolean datosValidos = true;

        // Convertir el texto a LocalDate
        try {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd");
            LocalDate fechaNacimiento = LocalDate.parse(fechaTexto, formatter);
            usuario.setNacimiento(fechaNacimiento); // Asegúrate de que el tipo de esta propiedad sea LocalDate
        } catch (Exception e) {
            System.out.println("Error: Formato de fecha inválido. Por favor, utiliza el formato yyyy-MM-dd.");
            datosValidos = false;
        }

        if(datosValidos){
            if (contadorUsuarios < arregloUsuarios.length) {
                arregloUsuarios[contadorUsuarios++] = usuario; // Guardar en el arreglo
                System.out.println("---------------------------------------------------");
                System.out.println("Usuario creado con éxito con ID: " + usuario.getId());
                System.out.println("---------------------------------------------------");

            } else {
                System.out.println("Error: No se pueden agregar más usuarios, el arreglo está lleno.");
            }
        }else {
            System.out.println("No se pudo crear el usuario debido a un error en los datos.");
        }

    }

    public void mostrarUsuario(boolean datosPersonales){
        if (contadorUsuarios == 0) {
            System.out.println("No hay usuarios registrados.");
        } else {
            System.out.println("Lista de usuarios:");
            for (int i = 0; i < contadorUsuarios; i++) {
                Usuario usuario = arregloUsuarios[i];
                if(datosPersonales){
                    System.out.println("ID: " + usuario.getId() +
                            ", Nombre: " + usuario.getNombre() +
                            ", Apellido: " + usuario.getApellido() +
                            ", DNI: " + usuario.getDni() +
                            ", País: " + usuario.getPais() +
                            ", Fecha de nacimiento: " + usuario.getNacimiento());
                }else{
                    System.out.println("ID: " + usuario.getId() +
                            ", Nombre: " + usuario.getNombre() +
                            ", Apellido: " + usuario.getApellido());
                }

            }
        }
    }

    public void mostrarMascota(){
        if (contadorMascotas == 0) {
            System.out.println("No hay mascotas registradas.");
        } else {
            System.out.println("Lista de mascotas:");
            for (int i = 0; i < contadorMascotas; i++) {
                Mascota mascota = arregloMascotas[i];
                System.out.println("ID: " + mascota.getId() +
                        ", Nombre: " + mascota.getNombre() +
                        ", Apodo: " + mascota.getApodo() +
                        ", Edad: " + mascota.getEdad() +
                        ", Tipo: " + mascota.getTipo() +
                        ", Color: " + mascota.getColor() +
                        ", Raza: " + mascota.getRaza() +
                        ", Tiene cola: " + (mascota.isCola() ? "Sí" : "No") +
                        ", Dueño: " + mascota.getNombreUsuario());

            }
        }
    }
}
