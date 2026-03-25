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

        int ContadorUsuarios = 0;
        int ContadorRegistros = 0;
        
        //esta sera para contar el numero de lineas que hay en las actividades
        int NumAct = 0;

        //Primero Leeremos los archivos
        
        
        int count = 0;//esta variable sera para contar la cantidad de usuarios existentes en la lista
        
        
        
        try {

            File File1 = new File ("Usuarios.txt");
            File File2 = new File("Registros.txt");
            Scanner Usuarios = new Scanner(File1);
            Scanner Registros = new Scanner(File2);


            //Guardaremos en el arreglo users lo que hay en Usuarios.txt
            
            
            while(Usuarios.hasNextLine()) {    //Si hay registro en la siguiente linea
                
            	
            	count++; //sumara 1 por cada usuario extra
                
                
            
            	String linea = Usuarios.nextLine();     // Lee la siguiente línea y la guarda en linea
                String Partes[] = linea.split(";");      // Divide la línea en partes usando ";" como separador
                Users[ContadorUsuarios] = Partes[0];             // Guarda el primer dato de nombres  en Users
                Passwords[ContadorUsuarios] = Partes[1];        // Guarda el primer dato de las contraseñas en Passwords
                
                
                ContadorUsuarios++;                                // Aumenta el contador para guardar el siguiente usuario en la siguiente posición
                }
            Usuarios.close();
            
          //Guardaremos en el arreglo Registros lo que hay en Registros.txt
            
            while(Registros.hasNextLine()) {             //Si hay registro en la siguiente linea
                String linea = Registros.nextLine();     // Lee la siguiente línea y la guarda en linea
                String Partes[] = linea.split(";");      // Divide la línea en partes usando ";" como separador
                ID[ContadorRegistros] = Partes[0];             // Guarda el 1er dato en ID
                Fechas[ContadorRegistros] = Partes[1];        // Guarda el 2do dato en fechas
                Horas[ContadorRegistros] = Partes [2];		//  Guarda el 3er dato en horas
                Actividad[ContadorRegistros] = Partes[3];	//  Guarda el 4to dato en Actividad
                      
                
                NumAct++;
                ContadorRegistros++;    // Aumenta el contador para guardar el siguiente usuario en la siguiente posición            
            }
            Registros.close();            
        }catch (Exception e) {
            System.out.println("Error Al Intentar Leer El Archivo");
        }
        
        //intentare generar un algoritmo que cuente la cantidad de usuarios existentes
        
        
        
        
        
      
        //este es un print de prueba para ver si esta contando bien los usuarios
        System.out.println("hay " + count + " usuarios disponibles");
        //comparare la cantidad de los usuarios con el lenght que estamos usando luego en el menu de usuarios
        System.out.println(Users.length);
        
        
        
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
        
        
        
        //aqui empieza el menu 1
        while(!salir) {
        	switch(option) {
        	case "1":
        		//definiremos 2 variables a comparar siendo el usuario y la contrasena
        		String usuario;
        		String password;
        		
        		//bienvenida
        		System.out.println("**Bienvenido Al Menu De Usuarios**");
        	    //ingreso del usuario
        		System.out.println("Ingrese Su Usuario:");
        		usuario = lector.nextLine();
        		//contraseña
        		System.out.println("Ingrese Su Contrsasena:");
        		password = lector.nextLine();
        		
        	
        		  
        		
        		
        		
        		//Recorrer los arreglos para comparar si el ususario y la contrasena esta registrado
        		
        		boolean Access = false;
        		
        		
        		
        		//nota para seba ahora i < count para que el for recorra la cantidad de usuarios y no la longitud de 300 de la lista
        		for(int i = 0; i<count; i++) {
        			
        			
        			//este if comprueba si coincida usuario y contraseña
        			if(Users[i].equals(usuario)&&Passwords[i].equals(password)) {
        					System.out.println("**Acceso Correcto**");
        					Access = true;
        					if(Users[i]!=null&&Passwords[i]!=null){
        						System.out.println("Bienvenido " + Users[i]);
        						break;
        						
        					}        					        				        					
        			}
        		}
        		
        		//ahora generare un menu para cuando el acceso si sea correcto
        		String MenuUsers = "0";
      
        		while(Access) {
        			

        			System.out.println("Que Deseas Realizar?");
        			System.out.println("1) Registrar Actividad.");
        			System.out.println("2) Modificar Actividad.");
        			System.out.println("3) Eliminar actividad.");
        			System.out.println("4) Cambiar Contraseña.");
        			System.out.println("5) Salir");
        			
        			MenuUsers = lector.nextLine();
        			
        			
        			switch(MenuUsers) {
        			
        			
        			case "1":
        				System.out.println("Que Actividad Deseas Registrar?");
        				
        				System.out.println(NumAct);
        				
        				//tenemos que printear las lineas que posean al usuario correspondiente.
        				for(int i = 0; i < ContadorRegistros; i++) {
        					if(ID[i].equals(usuario)) {
        						System.out.println(i+") "+ID[i]+" "+Fechas[i]+" "+Horas[i]+" "+Actividad[i]);
        						
        					}
        				}
        				
        				
        				break;
        				
        			
        				
        			case "2":
        				System.out.println("Que Actividad Desea Modificar?");
        				
        			case "3":
        				System.out.println("Que Actividad Desea Eliminar?");
        				
        			case "4":
        				System.out.println("Seguro Que Quieres Cambiar La Contraseña?");
        			
        				

        			case "5":
        				System.out.println("Seguro Que Deseas Salir?");
        				
        			}
        		 
        			
        			
        			
        			
        		}
        	    
        		//cuando el access sea negativo se printeara el siguiente mensaje
        		if(!Access) {
				System.out.println("Acceso Denegado");
				Access=false;
				
				
        		}		
        		break;
        		
        		
        	 
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        		
        	//mientras tanto el resto del menu lo dejare sin tocar.	
        	
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
        
        
    
