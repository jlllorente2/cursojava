package com.curso.java.ficheros;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.curso.java.poo.ejercicios.ejercicio1.Alumno;



public class GestionFicheros {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		//crearArchivo2("fichero.txt");
		String contenidoFichero = leerArchivo("fichero.txt");
		System.out.println(contenidoFichero);
	}

	public static void crearArchivo(String nombre) {
		File archivo = new File(nombre);
		
		BufferedWriter buffer2 = null;

//		try {
//			FileWriter fw = new FileWriter(archivo);	
//			buffer2 = new BufferedWriter(fw,2000);
//
//			buffer2.append("Hola que tal amigos!\n")
//			.append("Todo bien? yo escribiendo en un archivo...\n")
//			.append("Hasta luego Lucas4!\n");
//			
//		}catch(IOException ioe) {
//			System.out.println("Error" + ioe.getMessage());
//		}finally {
//			try {
//				buffer2.close();
//			} catch (IOException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			} catch (NullPointerException npe) {
//				npe.printStackTrace();
//			}
//		}
//		System.out.println("Fichero creado");
	
		
		//Try with resources
		try (BufferedWriter buffer = new BufferedWriter(new FileWriter(archivo, false))) {

			buffer.append("Hola que tal amigos!\n")
					.append("Todo bien? yo escribiendo en un archivo...\n")
					.append("Hasta luego Lucas6!\n");
			// buffer.close();
			System.out.println("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static void crearArchivo2(String nombre) {
		File archivo = new File(nombre);
		
		try (PrintWriter buffer = new PrintWriter("fichero.txt")) {
			// try (PrintWriter buffer = new PrintWriter(new FileWriter(archivo))){

			buffer.println("Hola que tal amigos!");
			buffer.println("Todo bien? yo aquí escribiendo un archivo...");
			buffer.printf("Hasta luego %s! %s", "JoseLuis5", "Cadena");
			// buffer.close();
			System.out.println("El archivo se ha creado con éxito!");
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static String leerArchivo(String nombre) {
		StringBuilder sb = new StringBuilder();
		File archivo = new File(nombre);
//		FileReader fileReader = new FileReader(archivo);
//		BufferedReader reader = new BufferedReader(fileReader);
//
//		String linea;
//		while ((linea = reader.readLine()) != null) {
//			sb.append(linea).append("\n");
//		}

        try (BufferedReader reader = new BufferedReader(new FileReader(archivo))){

            String linea;
            
//            do {
//            	linea = reader.readLine();
//            	
//            }while(linea!=null);
            List<Alumno> listaAlumnos = new ArrayList();
            while ( (linea = reader.readLine()) != null){
//            	//alumno1|1111A|A1|23
//            	String[] datosAlumno = linea.split("|");
//            	String nommbre = datosAlumno[0];
//            	String dni = datosAlumno[1];
//            	String apellido = datosAlumno[2];
//            	int edad = Integer.parseInt(datosAlumno[3]);
            	
//            	Alumno a = new Alumno(dni, nombre, apellido);
//            	listaAlumnos.add(a);
            	
            	sb.append(linea).append("\n");
            }
            System.out.println("Tamaño de la lista"+listaAlumnos.size());
            
        } catch (IOException e) {
        	System.out.println("Error " + e.getMessage());
            //e.printStackTrace();
        }
        System.out.println("Fin");
		return sb.toString();
	}

	public String leerArchivo2(String nombre) {
		StringBuilder sb = new StringBuilder();
		File archivo = new File(nombre);
		try (Scanner s = new Scanner(archivo)) {

			s.useDelimiter("\n");
			while (s.hasNext()) {
				sb.append(s.next()).append("\n");
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		return sb.toString();
	}

	public String leerArchivo3(String nombre) throws IOException{
		Path path = Paths.get(nombre);
		StringBuilder sb = new StringBuilder();

		List<String> lines = Files.readAllLines(path);
		for (String linea : lines) {
			sb.append(linea+"\n");
		}

		return sb.toString();
	}

	public void mostrarContenidoDirectorio(String directorio) {
		File dir = new File(directorio);
		File file1 = new File(directorio, "fichero1.txt");
		File file2 = new File(dir, "fichero1.txt");

		if (dir.isDirectory()) {
			String[] ficheros = dir.list();
			for (String nombreFichero : ficheros) {
				// System.out.print(nombreFichero + " ");
				String nuevoFichero = directorio + nombreFichero;
				System.out.println(nuevoFichero);
				File file = new File(nuevoFichero);
				if (file.isDirectory()) {
					// System.out.println("Es un directorio");
				} else {
					if (file.getName().endsWith(".txt")) {
						System.out.println("Se puede leer:" + file.canRead());
						System.out.println("TAma�o " + file.length());
						System.out.println("Es un fichero");
					}
				}

			}
		} else {
			System.err.println("No es un directorio");
		}
	}
	
}
