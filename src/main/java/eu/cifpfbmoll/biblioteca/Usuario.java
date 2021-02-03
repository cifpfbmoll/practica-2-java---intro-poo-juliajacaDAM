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
public class Usuario {
    private String nombre;
    private String apellido;
    private String nif;
    private String contraseña;
    private ArrayList <Libro> librosReservados = new ArrayList();
    
    //constructores

    public Usuario(String nombre, String apellido, String nif, String contraseña) {
        this.setNombre(nombre);
        this.setApellido(apellido);
        this.setNif(nif);
        this.setContraseña(contraseña);
    }

    public Usuario() {
    }
    
    public Usuario(Usuario usuario) {
        this.setNombre(usuario.getNombre());
        this.setApellido(usuario.getApellido());
        this.setNif(usuario.getNif());
        this.setContraseña(usuario.getContraseña());
    }
    // getters y setters
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
        this.contraseña = contraseña;
    }

    public ArrayList<Libro> getLibrosReservados() {
        return librosReservados;
    }

    public void setLibrosReservados(ArrayList<Libro> librosReservados) {
        this.librosReservados = librosReservados;
    }
    
    
    
    //To string

    @Override
    public String toString() {
        return "Usuario{" + "nombre=" + nombre + ", apellido=" + apellido + ", nif=" + nif + ", contrase\u00f1a=" + contraseña + ", librosReservados=" + librosReservados + '}';
    }

   
    
    //Método añadir usuario
    public static void añadirUsuario(ArrayList <Usuario> arrayUsuarios){
        Usuario usuario = new Usuario();
        Scanner lector = new Scanner(System.in);
        System.out.println("Dime el nombre del usuario");
        usuario.setNombre(lector.nextLine());
        System.out.println("Dime el apellido del usuario");
        usuario.setApellido(lector.nextLine());
        System.out.println("Dime el nif de la persona");
        usuario.setNif(lector.nextLine());
        System.out.println("Dime la contraseña");
        usuario.setContraseña(lector.nextLine());
        arrayUsuarios.add(usuario);
    }
    
    public static void borrarUsuario(ArrayList <Usuario> arrayUsuarios){
        Scanner lector = new Scanner(System.in);
        Boolean noEncontrado = true;
        int intentos = 0;
        while(noEncontrado && intentos < 5){
            intentos ++;
            System.out.println("INtentos" + intentos);
            System.out.println("Dime un DNI a eliminar");
            String nifPersona = lector.nextLine();
            for(int i = 0; i < arrayUsuarios.size(); i++){
                if(nifPersona.equals(arrayUsuarios.get(i).getNif())){
                    System.out.println("Persona encontrada");
                    noEncontrado = false;
                    arrayUsuarios.remove(i);
                }
            }
        }
        
        if(intentos == 5){
            System.out.println("Te has equivocado de persona demasiadas veces. Adiós");
        }
    }
    
    public boolean comprobarSiPuedeSacarMasLibros(){
        if(this.librosReservados.size() == 5){
            return false;
        }else {
        return true;
        }
    }
    
}
