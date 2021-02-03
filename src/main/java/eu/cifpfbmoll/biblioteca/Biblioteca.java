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
public class Biblioteca {
    private String nombreBiblioteca;
    private ArrayList <Libro> libros = new ArrayList();
    private ArrayList <Persona> personal = new ArrayList();
    private ArrayList <Usuario> usuarios = new ArrayList();
    
    // constructores
    public Biblioteca() {
    }

    public Biblioteca(String nombreBiblioteca) {
        this.setNombreBiblioteca(nombreBiblioteca);
    }
    
    public Biblioteca(Biblioteca biblioteca) {
        this.setNombreBiblioteca(biblioteca.getNombreBiblioteca());
    }
    
    //SEtters y getters
    public String getNombreBiblioteca() {
        return nombreBiblioteca;
    }

    public void setNombreBiblioteca(String nombreBiblioteca) {
        this.nombreBiblioteca = nombreBiblioteca.substring(0, 1).toUpperCase() + nombreBiblioteca.substring(1).toLowerCase();
    }

    public ArrayList<Libro> getLibros() {
        return libros;
    }

    public void setLibros(ArrayList<Libro> Libros) {
        this.libros = Libros;
    }

    public ArrayList<Persona> getPersonal() {
        return personal;
    }

    public void setPersonal(ArrayList<Persona> Personal) {
        this.personal = Personal;
    }

    public ArrayList<Usuario> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(ArrayList<Usuario> usuarios) {
        this.usuarios = usuarios;
    }
    
    // to string

    @Override
    public String toString(){
        return "Biblioteca{" + "nombreBiblioteca=" + nombreBiblioteca + ", libros=" + libros + ", personal=" + personal + ", usuarios=" + usuarios + '}';
    }
    
    
    public void mostrarLibros() {
        for(int i = 0; i < this.libros.size(); i++){
            int ordenLibro = i +1;
            System.out.println("LIBRO "+ ordenLibro+ ": "+libros.get(i).toString());
        }
    }
    
    public void mostrarLibrosDisponibles(){
        int ordenLibro = 1;
        for(int i = 0; i < this.libros.size(); i++){
            if(this.libros.get(i).getNumeroCopiasDisponibles() > 0){ 
                System.out.println("LIBRO "+ ordenLibro+ ": "+libros.get(i).toString());
                ordenLibro++;
            }
        }
  
    }
    
    public void seleccionarUsuario(){
        boolean usuarioNoExiste = true;
        boolean noReservado = true;
        while(usuarioNoExiste && noReservado){
            System.out.println("Selecciona el NIF del usuario que va a reservar el libro");
            for(int i = 0; i< this.usuarios.size(); i++){
                System.out.println(this.usuarios.get(i).toString());
            }
            
            Scanner lector = new Scanner(System.in);
            String usuarioSeleccionado = lector.nextLine();
            
            for (int i = 0; i < this.usuarios.size(); i++){                
                if(usuarioSeleccionado.equals(this.usuarios.get(i).getNif())){
                    if(this.usuarios.get(i).comprobarSiPuedeSacarMasLibros()){
                        usuarioNoExiste = false;
                        int posicionLibro = -1;
                        while(posicionLibro == -1){
                             //mostramos los libros disponibles
                            this.mostrarLibrosDisponibles();
                            posicionLibro = Libro.buscarLibroPorISBN(this.libros);
                            System.out.println(posicionLibro);
                        }
                        
                        System.out.println("Copias antes");
                        System.out.println(this.libros.get(posicionLibro).toString());
                        int copiasLibres = this.libros.get(posicionLibro).getNumeroCopiasDisponibles();
                        this.libros.get(posicionLibro).setNumeroCopiasDisponibles(copiasLibres-1);
                        System.out.println("Copias después");
                        System.out.println(this.libros.get(posicionLibro).toString());
                        noReservado = false;
                        ArrayList librosUsuario = this.usuarios.get(i).getLibrosReservados();
                        librosUsuario.add(0, this.libros.get(posicionLibro));
                        this.usuarios.get(i).setLibrosReservados(librosUsuario);
                    }
                }else {System.out.println("El usuario no puede sacar más libros");}
            }
        }
    
    }
    
    //public void
}
