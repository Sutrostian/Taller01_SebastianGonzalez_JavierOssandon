// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - Por Confirmar
package Taller01_SebastianGonzalez_JavierOssandon;
import java.util.Scanner;
import java.io.File;
import java.io.IOException;
public class Main {
    public static void main(String[] args) {

        //Primero Leeremos los archivos

        try {

            File File1 = new File ("Usuarios.txt");
            File File2 = new File("Registros.txt");
            Scanner Usuarios = new Scanner(File1);
            Scanner Registros = new Scanner(File2);

            String Users[] = new String [3];
            String Passwords[] = new String [3];

            int contador = 0;

            while(Usuarios.hasNextLine()) {             //Si hay registro en la siguiente linea
                String linea = Usuarios.nextLine();     // Lee la siguiente línea y la guarda en linea
                String Partes[] = linea.split(";");      // Divide la línea en partes usando ";" como separador
                Users[contador] = Partes[0];             // Guarda el primer dato de nombres  en Users
                Passwords[contador] = Partes[1];        // Guarda el primer dato de las contraseñas en Passwords
                contador++;                                // Aumenta el contador para guardar el siguiente usuario en la siguiente posición
                }


            for(int i =0; i<Passwords.length; i++) {
                System.out.println(Users[i]);
            }
            for(int i =0; i<Passwords.length; i++) {
                System.out.println(Passwords[i]);
            }




        }catch (Exception e) {

            System.out.println("Error Al Intentar Leer El Archivo");

        }





    }

}
