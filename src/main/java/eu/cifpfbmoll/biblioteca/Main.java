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
 * @author USER
 */
public class Main {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        System.out.println("HOLA MUNDO");
        Libro libro1 = new Libro("ISBN1", "El nombre de la rosa","Umberto ECO", "AAA Editores", 20,20);
        System.out.println(libro1.toString());
        ArrayList <Libro> coleccion = new ArrayList <Libro>();
        coleccion.add(0, libro1);
        //System.out.println("Titulos distintos " + Libro.getTitulosDistintos());
        //Libro.añadirLibro(coleccion);
        //Libro.añadirLibro(coleccion);
        //Libro.añadirLibro(coleccion);
        //System.out.println(coleccion);
        //Libro.eliminarLibro(coleccion);
        //System.out.println(Libro.buscarLibroPorISBN(coleccion));
        //Libro.buscarLibroPorTitulo(coleccion);
        //Biblioteca biblioteca = new Biblioteca("maria Moliner");
        //biblioteca.setLibros(coleccion);
        //biblioteca.mostrarLibros();
        //Libro.añadirLibro(biblioteca.getLibros());
        //System.out.println(biblioteca.toString());
        //biblioteca.mostrarLibros();
        //biblioteca.mostrarLibrosDisponibles();
        
        //Persona personaPrueba = new Persona("Rosalia", "De Castro", "100", "123456789");
        //ArrayList<Persona> personal = biblioteca.getPersonal();
        //personal.add(0, personaPrueba);
        //biblioteca.setPersonal(personal);
        //Persona.añadirPersona(biblioteca.getPersonal());
        
        //System.out.println(biblioteca.getPersonal());
        //Persona.eliminarPersona(biblioteca.getPersonal());
        
        boolean continuar = true;
        while(continuar){
            Scanner lector = new Scanner(System.in);
            System.out.println("Escribe la opción que quieras:" + "\n" + " A: Gestionar Libros" + "\n" + " B: Gestionar Personal" + "\n" + " salir: cerrar la aplicación" );
            String opcionUsuario = lector.nextLine();
            System.out.println("La opción del usuario es " + opcionUsuario);
            switch(opcionUsuario){
            case "A":
                System.out.println("Vas a gestionar los libros");
                break;
            case "B":
                System.out.println("Vas a gestionar al personal");
                break;
            case "salir":
                System.out.println("vas a salir");
                continuar = false;
                break;
            default:
                System.out.println("Opción incorrecta");         
        }
        
        }
        
        
    }
    
}
