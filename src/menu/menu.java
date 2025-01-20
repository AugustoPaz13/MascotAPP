package menu;

import entidades.Mascota;

import java.util.Scanner;
import informacion.Informacion;

public class menu {
    public static void main(String[] args) {
        System.out.println("---------------------------------------");
        System.out.println("Aplicación de información para Mascotas");
        System.out.println("---------------------------------------");

        Informacion informacion = new Informacion();
        var consola = new Scanner(System.in);
        int op = 0;

        do{
            System.out.print("""
                    Menú:
                    --------------------
                    1. Crear Usuario
                    2. Registrar Mascota
                    3. Ver Usuario
                    4. Ver Mascota
                    5. Salir
                    ---------------------
                    Elige una opción:
                    """);
            op = Integer.parseInt(consola.nextLine());

            switch (op){
                case 1 -> informacion.crearUsuario();
                case 2 -> informacion.crearMascota();
                case 3 -> informacion.mostrarUsuario(true);
                case 4 -> informacion.mostrarMascota();
                case 5 -> System.out.println("Saliendo del programa...");
                default -> System.out.println("Opción no valida, intente de nuevo...");
            }
        }while(op!=5);

    }

}
