/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author asix
 */
public class Persona {
    private String nombre;
    private String apellido;
    private String nif;
    private String contraseña;
    
    // COnstructores
    public Persona(String nombre, String apellido, String nif, String contraseña) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNif(nif);
        this.setContraseña(contraseña);
    }

    public Persona() {
    }
    
    public Persona(Persona persona) {
        this.setNombre(persona.getNombre());
        this.setApellido(persona.getApellido());
        this.setNif(persona.getNif());
        this.setContraseña(persona.getContraseña());
    }
    
    // Getters y setters
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

    public String getNif() {
        return nif;
    }

    public void setNif(String nif) {
        this.nif = nif;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        while(contraseña.length()< 8){
            System.out.println("La contraseña necesita mínimo 8 caracteres");
            Scanner lector = new Scanner(System.in);
            contraseña = lector.nextLine();
        }
        this.contraseña = contraseña;
    }

    @Override
    public String toString() {
        return "Persona{" + "nombre=" + nombre + ", apellido=" + apellido + ", nif=" + nif + ", contrase\u00f1a=" + contraseña + '}';
    }
    
    // métodos de la clase
    public static void añadirPersona (ArrayList <Persona> arrayPersonas){
        Persona persona = new Persona();
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el nombre");
        persona.setNombre(lector.nextLine());
        System.out.println("Dime el apellido");
        persona.setApellido(lector.nextLine());
        System.out.println("Dime el NIF");
        persona.setNif(lector.nextLine());
        System.out.println("Escribe una contraseña");
        persona.setContraseña(lector.nextLine());
        arrayPersonas.add(persona);  
    }
    
    public static void eliminarPersona(ArrayList <Persona> arrayPersona){
        Scanner lector = new Scanner(System.in);
        Boolean noEncontrado = true;
        int intentos = 0;
        while(noEncontrado && intentos < 5){
            intentos ++;
            System.out.println("Intento nº " + intentos);
            System.out.println("Dime el NIF de la persona a borrar");
            String NIFPersona = lector.nextLine();
            for(int i = 0; i < arrayPersona.size(); i++){
            if (NIFPersona.equals(arrayPersona.get(i).getNif())){
                noEncontrado = false;
                System.out.println("Persona encontrada y eliminada");
                arrayPersona.remove(i);
            }
            }
        }
        if(intentos == 5){
            System.out.println("Te has equivocado de NIf demasiadas veces");
        }
    }
    
    
}
