// Sebastian Andres Gonzalez Rossi - 21.186.016-2 - Ingenieria Civil Industrial - Sutrostian
// Javier Ignacio Ossandon Calderon - 21.979.689-2 - Ingenieria Civil Industrial - javierossand
package Taller01_SebastianGonzalez_JavierOssandon;
import java.util.Scanner;
import java.io.File;
public class Main {
    public static void main(String[] args) {
    	
    	//Declaramos los arreglos a usar
    	

        String Users[] = new String [300];
        String Passwords[] = new String [300];
        String ID[] = new String [300];
        String Fechas[] = new String [300];
        String Horas[] = new String [300];
        String Actividad[] = new String [300];

        int contador = 0;

        //Primero Leeremos los archivos

        try {

            File File1 = new File ("Usuarios.txt");
            File File2 = new File("Registros.txt");
            Scanner Usuarios = new Scanner(File1);
            Scanner Registros = new Scanner(File2);


            //Guardaremos en el arreglo users lo que hay en Usuarios.txt

            while(Usuarios.hasNextLine()) {             //Si hay registro en la siguiente linea
                String linea = Usuarios.nextLine();     // Lee la siguiente línea y la guarda en linea
                String Partes[] = linea.split(";");      // Divide la línea en partes usando ";" como separador
                Users[contador] = Partes[0];             // Guarda el primer dato de nombres  en Users
                Passwords[contador] = Partes[1];        // Guarda el primer dato de las contraseñas en Passwords
                
                
                contador++;                                // Aumenta el contador para guardar el siguiente usuario en la siguiente posición
                }
            Usuarios.close();
            
          //Guardaremos en el arreglo Registros lo que hay en Registros.txt
            
            while(Registros.hasNextLine()) {             //Si hay registro en la siguiente linea
                String linea = Registros.nextLine();     // Lee la siguiente línea y la guarda en linea
                String Partes[] = linea.split(";");      // Divide la línea en partes usando ";" como separador
                ID[contador] = Partes[0];             // Guarda el 1er dato en ID
                Fechas[contador] = Partes[1];        // Guarda el 2do dato en fechas
                Horas[contador] = Partes [2];		//  Guarda el 3er dato en horas
                Actividad[contador] = Partes[3];	//  Guarda el 4to dato en Actividad
                                
                contador++;                                // Aumenta el contador para guardar el siguiente usuario en la siguiente posición            
            }
            Registros.close();            
        }catch (Exception e) {
            System.out.println("Error Al Intentar Leer El Archivo");
        }
        
        //Menu Principal
      
        
        
        System.out.println("**Bienvenido**");
        System.out.println("**Seleccione Una Opcion**");
        System.out.println("1) Menu Usuarios");
        System.out.println("2) Menu Analisis");
        System.out.println("3) Salir");
        
        Scanner lector = new Scanner(System.in);
        String option;
        option = lector.nextLine();
        
        
        //mientras este booleano sea false el menu 1 se ejecutara
        boolean salir = false;
        
        
        while(!salir) {
        	switch(option) {
        	case "1":
        		//definiremos 2 variables a comparar siendo el usuario y la contrasena
        		String usuario;
        		String password;
        		
        		System.out.println("**Bienvenido Al Menu De Usuarios**");
        	
        		System.out.println("Ingrese Su Usuario:");
        		usuario = lector.nextLine();
        		System.out.println("Ingrese Su Contrsasena:");
        		password = lector.nextLine();
        		
        	
        		  
        		//Recorrer los arreglos para comparar si el ususario y la contrasena esta registrado
        		
        		boolean Access = false;
        		
        		
        		for(int i = 0; i<Users.length; i++) {
        			if(Users[i].equals(usuario)&&Passwords[i].equals(password)) {
        					System.out.println("**Acceso Correcto**");
        					Access = true;
        					if(Users[i]!=null&&Passwords[i]!=null){
        						System.out.println("Bienvenido " + Users[i]);
        					}        					        				        					
        			}
        		}
        		if(!Access) {
				System.out.println("Acceso Denegado");
				Access=false;
        		}		
        		  
        		  
        		  
        		  
        		  
        		  
        		  
        		  
        		  
        		  
        	break;
        	case "2":
        		System.out.println("**Bienvenido Al Menu Analisis**");
        		  option = lector.nextLine();	
        	break;
        	case "3":
        		System.out.println("**Salido Con Exito**");
        		
        		salir = true;	
        	break;
        	
        	default:
        		System.out.println("Ingrese La Opcion Nuevamente");
                option = lector.nextLine();	
            break;    
        	}
        }
        
        
        lector.close();
        }
}        	
        
        
    
