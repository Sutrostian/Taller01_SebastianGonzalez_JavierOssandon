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
              
        //Primero Leeremos los archivos                       
        try {

            File File1 = new File ("Usuarios.txt");
            File File2 = new File("Registros.txt");
            Scanner Usuarios = new Scanner(File1);
            Scanner Registros = new Scanner(File2);

            //Guardaremos en el arreglo users y passwords lo que hay en Usuarios.txt
                        
            while(Usuarios.hasNextLine()) {    //Si hay registro en la siguiente linea                
            	         
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
                ContadorRegistros++;    // Aumenta el contador para guardar el siguiente usuario en la siguiente posición            
            }
            Registros.close();            
        }catch (Exception e) {
            System.out.println("Error Al Intentar Leer El Archivo");
        }
       
        //Menu Principal
        Scanner lector = new Scanner(System.in);
        boolean salir = false;

        while(!salir) {

            System.out.println("**Bienvenido**");
            System.out.println("**Seleccione Una Opcion**");
            System.out.println("1) Menu Usuarios");
            System.out.println("2) Menu Analisis");
            System.out.println("3) Salir");

            String option = lector.nextLine();

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
        		boolean login = false;	//necesitamos otro booleano para el caso que aprete salir en el sub menu, y lo devuelva al menu general        	
        		for(int i = 0; i<ContadorUsuarios; i++) {
        		
        			if(Users[i].equals(usuario)&&Passwords[i].equals(password)) { //si el usuario y contrasena coinciden
        				System.out.println();
        				System.out.println("**Acceso Correcto**");
        				Access = true;
        				login = true;
        				if(Users[i]!=null&&Passwords[i]!=null){
        					System.out.println();
        					System.out.println("Bienvenido(a) " + Users[i]);
        		break;       						
        				}        					        				        					
        			}
        		}
   
        		while(Access) {//Ahora generare un menu para cuando el acceso si sea correcto   
        		
        			System.out.println("Que Deseas Realizar?");
        			System.out.println("1) Registrar Actividad.");
        			System.out.println("2) Modificar Actividad.");
        			System.out.println("3) Eliminar actividad.");
        			System.out.println("4) Cambiar Contraseña.");
        			System.out.println("5) Salir");
        			        			
        	        String MenuUsers;
        	        MenuUsers = lector.nextLine();
        			       			
        			switch(MenuUsers) {
        			        			
        			case "1": //Agregar nueva
        				System.out.println("Que Actividad Deseas Registrar?");
        				
        				String newA = lector.nextLine();
        				
        				System.out.println("Ingrese Fecha De La Actividad");
						System.out.println("Ingresar Formato DD/MM/AAAA");
						String newF = lector.nextLine();
						if(!newF.matches("\\d{2}/\\d{2}/\\d{4}")) {//este if verifica que el formato DD/MM/AAAA se cumpla, en caso de no cumplirse devolvera al menu de usuario
							System.out.println("Formato de fecha invalido. Use DD/MM/AAAA");
						    break;
						}
						
						
						System.out.println("Ingrese La Duracion De La Actividad");
						String newD = lector.nextLine();
										
						try{ //Este try tiene por proposito verificar que la duracion colocada en el scanner es un numero valido
							int Comprobante = Integer.parseInt(newD);
						}catch(Exception e) {
							System.out.println("La Duracion Debe Ser Un Numero Entero (Horas)");
							break;
						}
						
						
						if(ContadorRegistros<300) {
							ID[ContadorRegistros] = usuario;
							Fechas[ContadorRegistros] = newF;
							Horas[ContadorRegistros] = newD;
							Actividad[ContadorRegistros] = newA;
							ContadorRegistros++;
							System.out.println();
							System.out.println("Agregado Exitosamente");
							System.out.println();
						}else {
							System.out.println("No Se Pueden Agregar Mas Actividades");
						}
        				       				
       				        				
        			break;
        				        	        				
        			case "2": //Modificar
        				
        				System.out.println("¿Que Actividad Desea Modificar?");
        				System.out.println();
        				int valor1 = 1;//esta variable sera para printear el numero en orden de las actividades
        				for(int i = 0; i < ContadorRegistros; i++) { //tenemos que printear las lineas que posean al usuario correspondiente.
        					if(ID[i].equals(usuario)) {
        						System.out.println(i+") "+ID[i]+" "+Fechas[i]+" "+Horas[i]+" "+Actividad[i]);   
        						valor1++;
        					}
        				}
        				
        				String A = lector.nextLine(); //Guarda el n de la actividad que quiero modificar (i)
        				Boolean Match = false;
        				for(int i = 0; i<ContadorRegistros;i++) {
        					if(ID[Integer.parseInt(A)].equals(usuario)) {
        						Match = true;
        						
        					}
        				}
        				
        				if(!Match) {
        					System.out.println("La Actividad No Existe Para El Usuario");
        					break;
        				}
        				
        				System.out.println("Que Deseas Modificar?");
        				System.out.println("0) Regresar.");
        				System.out.println("1) Fecha");
        				System.out.println("2) Duracion");
        				System.out.println("3) Tipo de actividad");
        				
        				String B = lector.nextLine(); //Guarda lo que queremos modificar de la actividad
        				
        				
        				for(int i=0; i<ContadorRegistros;i++) {
        					
        					if(ID[Integer.parseInt(A)].equals(usuario)) {//si el n de actividad esta registrada para el usuario !!!!OJO SE CAE EN ID[200]
        					Match = true;
        					if(Integer.parseInt(A)==i) { //si el n de actividad es igual a la posicion i de la actividad modificamos
        					
        						if(Integer.parseInt(B)==1) {//si apreto fecha
        							System.out.println();
        							System.out.println("Ingrese Nueva Fecha");
        							System.out.println("Ingresar Formato DD/MM/AAAA");
        							String NewF = lector.nextLine();
        							Fechas[Integer.parseInt(A)] = NewF;
        							System.out.println();
        							System.out.println("Modificado Exitosamente");
        							System.out.println();
        						}
        						if(Integer.parseInt(B)==2) {//si apreto duracion
        							System.out.println();
        							System.out.println("Ingrese Nueva Duracion");
        							String NewD = lector.nextLine();
        							Horas[Integer.parseInt(A)] = NewD;
        							System.out.println();
        							System.out.println("Modificado Exitosamente");
        							System.out.println();
        						}
        						if(Integer.parseInt(B)==3) {//si apreto Tipo
        							System.out.println();
        							System.out.println("Ingrese Nuevo Tipo De Actividad");
        							String NewA = lector.nextLine();
        							Actividad[Integer.parseInt(A)] = NewA;
        							System.out.println();
        							System.out.println("Modificado Exitosamente");
        							System.out.println();
        						}
        						if(Integer.parseInt(B)==0) {//si apreto Salir
        						break;	
        						}        					
        					}
        					}        					
        				}        				
        				if(!Match && Integer.parseInt(B)!=0){//si no hizo match con la actividad y no puso 0
    						System.out.println();
    						System.out.println("La Actividad No Coincide Con El Usuario, Intente Nuevamente");
    						System.out.println();    					
    					}        				        				       				
        			break;	
        				
        			case "3":
        				
        				
        				
        				
        				int valor2 = 1; //este numero ayuda a printear el numero en que sale cada actividad 1,2,3 y no 1,30,34 que es el correspondiente al documento
        				
        				System.out.println("Que Actividad Desea Eliminar?");
        				System.out.println();
        				
        				for(int i = 0; i < ContadorRegistros; i++) { //tenemos que printear las lineas que posean al usuario correspondiente.
        					
        					if(ID[i].equals(usuario)) {
        						
        						System.out.println(i+") "+ID[i]+" "+Fechas[i]+" "+Horas[i]+" "+Actividad[i]);
        						valor2++;
        						
        						
        					
        					}
        				}
        				String C = lector.nextLine();  //va a ser el numero de actividad que quiero eliminar
        				Boolean Match2 = false;
        				
        				
        				for(int i = 0; i<ContadorRegistros;i++) {
        					if(ID[Integer.parseInt(C)].equals(usuario)) {
        						Match2 = true;
        					}
        				}
        				if(!Match2) {//si no hace match hay que kickear
        					
        					System.out.println("La Actividad No Existe Para El Usuario");
        					System.out.println();
        					break;
        					
        				}
        				
        				if(Match2) {//si hace match hay que eliminar
        					
        				}
        			break;	
        			case "4"://Cambiar contraseña
        				
        				System.out.println("¿Estas Realmlente Seguro De Cambiar La Contraseña?(si/no)");
        				String seguro = lector.nextLine();
        				
        				if(seguro.equalsIgnoreCase("no")) {
        					break;
        				}
        				if(seguro.equalsIgnoreCase("si")) {
        					
        					for(int i = 0; i<ContadorUsuarios;i++) {
        						
        						if(Users[i].equals(usuario)){
        							
        							System.out.print("Ingrese Contraseña Actual: ");
        							String contrasena = lector.nextLine();
        							if(contrasena.equals(Passwords[i])) {
        								System.out.print("Ingrese Nueva Contraseña: ");
        								String nuevo = lector.nextLine();
        								Passwords[i] = nuevo;
        								System.out.println("Contraseña Cambiada Con Exito");
        								System.out.println("Inicie Sesion Nuevamente");
        								System.out.println();
        								Access = false;
        							
        								
        							}else {
        								System.out.println("Contraseña Incorrecta");
        								System.out.println();
        							}
        							
        							
        						}
        						
        					}
        					
        					
        				}
        				
        			break;        				
        			case "5":
        				Access=false;
        				System.out.println("Has Salido");
        				System.out.println();
        			break;
        				
        			} 
        			
        		}
        		        		
        		if(!login) { //cuando el login sea negativo se printeara el siguiente mensaje
				System.out.println("Acceso Denegado, Intente Nuevamente");
				System.out.println();
				Access=false;								
        		}		
        		break;

        	case "2":
        		System.out.println("**Bienvenido Al Menu Analisis**");
        		System.out.println();
        		System.out.println("1) Actividad Más Realizada");
        		System.out.println("2) Actividad Más Realizada Por Cada Usuario");
        		System.out.println("3) Usuario Con Mayor Procrastinacion");
        		System.out.println("4) Ver Todas Las Actividades ");
        		System.out.println("5) Salir");
        		  option = lector.nextLine();	
        		  
        		  Boolean analisis = true;
        		  String EleccionAnalisis = lector.nextLine();
        		  
        				 
        		  while(analisis) {
        			  
        			  switch(option) {
        			  
        			  case "1": 
        				  System.out.println("La Actividad Mas Realizada es: ");
        				  break;
        				  
        				  
        			  
        			  }
        				  
        			  
        		  }
        		  
        		  
        		  
        		  
        	break;
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	
        	case "3":
        		System.out.println("**Has Salido Con Exito**");        		
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

//Pauta de Evaluación
//Puntaje Total Máximo: 120 puntos

//1. Persistencia de Datos y Archivos (20 puntos)

//[5 pts] Lectura de Usuarios: Lee correctamente el archivo Usuarios.txt, separando los datos por ; y almacenándolos en arreglos.
//[5 pts] Lectura de Registros: Lee correctamente el archivo de registros, separando los datos por ;.
//[5 pts] Escritura de Registros: Los cambios realizados (agregar, modificar, eliminar) se guardan correctamente en el archivo de texto, manteniendo el formato original.
//[5 pts] Escritura de Usuarios: Al cambiar la contraseña, el archivo Usuarios.txt se actualiza correctamente de forma permanente.

//2. Menú de Usuarios: Autenticación y CRUD (36 puntos)
//[5 pts] Login / Autenticación: El sistema solicita credenciales, las valida y permite el acceso solo si son correctas.
//[8 pts] Registrar actividad: Permite ingresar fecha, horas y actividad, añadiéndola al arreglo correspondiente (y posteriormente al archivo).
//[10 pts] Modificar actividad: Muestra las actividades del usuario logueado. Permite seleccionar una por índice y modificar un campo específico (Fecha, Duración o Tipo) de manera exitosa.
//[8 pts] Eliminar actividad: Permite al usuario seleccionar una de sus actividades y borrarla correctamente de los arreglos (reorganizando el arreglo o marcando el espacio como disponible).
//[5 pts] Cambiar contraseña: Actualiza la credencial del usuario actual en el arreglo y refleja el cambio en el archivo.

//3. Menú de Análisis y Lógica (26 puntos)
//[8 pts] Actividad más realizada (Global): Algoritmo que cuenta correctamente las frecuencias de todas las actividades e imprime la que más se repite.
//[8 pts] Actividad más realizada por usuario: Algoritmo que filtra por usuario, cuenta las frecuencias de sus actividades e imprime la mayor para cada uno.
//[5 pts] Usuario con mayor procrastinación: Suma correctamente las horas totales invertidas por cada usuario e identifica al que tiene la mayor cantidad.
//[5 pts] Ver todas las actividades: Imprime por consola el registro completo de forma ordenada y legible.

//4. Control de Errores y Robustez (18 puntos)
//[5 pts] Estructura de codigo: Mantiene un codigo limpio y ordenado con variables descriptivas y no genericas.
//[8 pts] Validación de Índices y Rangos: Evita errores de IndexOutOfBounds (ej. si el usuario selecciona modificar la actividad "10" y solo tiene 3, o si se supera el límite de 300 registros).
//[5 pts] Navegación de Menús: Las opciones de "Regresar" y "Salir" funcionan en todos los submenús sin atrapar al usuario en bucles infinitos.

//5. Uso de GitHub (20 puntos)
//[20 pts] Uso correcto: Estructura correcta del repositorio, commits frecuentes, buena documentacion.
        
        
//Fecha limite -> 03/04/2026    
