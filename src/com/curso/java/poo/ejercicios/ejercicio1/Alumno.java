package com.curso.java.poo.ejercicios.ejercicio1;

public class Alumno {
	//Variables de instancia
	private String dni;
	private String nombre;
	private String apellidos;
	private boolean mayorEdad;
	private double nota;
	static int contador;
	//Constructores
	public Alumno() {
	}
	
	public Alumno(String dni, String nombre, String apellidos) {
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
	}

	public Alumno(String dni, String nombre, String apellidos, double nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.nota = nota;
	}

	public Alumno(String dni, String nombre, String apellidos, boolean mayorEdad, double nota) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.apellidos = apellidos;
		this.mayorEdad = mayorEdad;
		this.nota = nota;
	}
	
	//Métodos get y set
	public String getDni() {
		return this.dni;
	}
	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellidos() {
		return apellidos;
	}

	public void setApellidos(String apellidos) {
		this.apellidos = apellidos;
	}

	public boolean isMayorEdad() {
		return mayorEdad;
	}

	public void setMayorEdad(boolean mayorEdad) {
		this.mayorEdad = mayorEdad;
	}

	public double getNota() {
		return nota;
	}

	public void setNota(double nota) {
		this.nota = nota;
	}
	

	//Declaramos el método verNota
	public void verNota() {
		if (this.mayorEdad) {
			if (this.nota==0) {
				System.out.println("El alumno no ha estudiado nada");
			}else if (this.nota<5) {
				System.out.println("El alumno ha estudiado poco");
			}else if (this.nota<=9) {
				System.out.println("El alumno ha estudiado mucho");
			}else if (this.nota<=10) {
				System.out.println("El alumno es un genio");
			}else {
				System.out.println("La nota no es correcta");
			}
			
		}else {
			System.out.println("Sin permisos para mostrar la nota");
		}
	}

	@Override
	public String toString() {
		return "Alumno [dni=" + dni + ", nombre=" + nombre + ", apellidos=" + apellidos + ", mayorEdad=" + mayorEdad
				+ ", nota=" + nota + "]";
	}
	
	
	
	
}
