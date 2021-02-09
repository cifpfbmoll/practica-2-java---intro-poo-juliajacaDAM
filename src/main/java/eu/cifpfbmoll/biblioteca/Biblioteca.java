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
    
    public void reservarLibro(){
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
    public int devolverPosicionUsuario(){
        int tamañoArrayUsuarios = this.usuarios.size();
        int vueltas = 0;
        System.out.println("Selecciona el nif del usuario");
        for(Usuario user:this.usuarios){
            System.out.println(user.toString());
        }
        Scanner lector = new Scanner(System.in);
        String usuarioSeleccionado = lector.nextLine();
        while(vueltas < tamañoArrayUsuarios){
            if(usuarioSeleccionado.equals(this.usuarios.get(vueltas).getNif())){
                return vueltas;
            }
            vueltas ++;
        }
        return -1; 
    }
    
    public void reservarLibro2(){
        int posicionUsuario = this.devolverPosicionUsuario();
        if(posicionUsuario != -1){
            System.out.println("Usuario encontrado");
            if(this.usuarios.get(posicionUsuario).comprobarSiPuedeSacarMasLibros()){
                this.mostrarLibrosDisponibles();
                int posicionLibro = Libro.buscarLibroPorISBN(this.libros);
                System.out.println(posicionLibro);
                System.out.println("Copias antes");
                System.out.println(this.libros.get(posicionLibro).toString());
                int copiasLibres = this.libros.get(posicionLibro).getNumeroCopiasDisponibles();
                this.libros.get(posicionLibro).setNumeroCopiasDisponibles(copiasLibres-1);
                System.out.println("Copias después");
                System.out.println(this.libros.get(posicionLibro).toString());
                ArrayList librosUsuario = this.usuarios.get(posicionUsuario).getLibrosReservados();
                librosUsuario.add(0, this.libros.get(posicionLibro));
                this.usuarios.get(posicionUsuario).setLibrosReservados(librosUsuario);
                System.out.println(usuarios.get(posicionUsuario).getLibrosReservados());
            }else{
                System.out.println("El usuario no puede sacar más libros");
            }
        }else{
            System.out.println("El usuario no existe");
        }
    }
    
    public void devolverLibro(){
        int posicionUsuario = this.devolverPosicionUsuario();
        if(posicionUsuario != -1){
            System.out.println("Usuario encontrado");
            System.out.println("Las reservas de este usuario son: ");
            System.out.println(this.usuarios.get(posicionUsuario).getLibrosReservados());
            int posicionLibro = Libro.buscarLibroPorISBN(this.usuarios.get(posicionUsuario).getLibrosReservados());
            if(posicionLibro != -1){
                // quito el libro del array de libros reservados del user
                this.usuarios.get(posicionUsuario).getLibrosReservados().remove(posicionLibro);
                //pongo disponible un libro más en el array de libros de la biblio
                int posicionLibroBib = Libro.buscarLibroPorISBN(libros);
                int librosDispAntes = this.libros.get(posicionLibroBib).getNumeroCopiasDisponibles();
                this.libros.get(posicionLibroBib).setNumeroCopiasDisponibles(librosDispAntes+1);
                System.out.println("Libros despues");
                System.out.println(this.libros.get(posicionLibroBib).getNumeroCopiasDisponibles());
                System.out.println(this.usuarios.get(posicionUsuario).toString());
            }else{
                System.out.println("Ese libro no está reservado por el usuario");
            }
        }else{
            System.out.println("Usuario no encontrado");
        }
    }
}
