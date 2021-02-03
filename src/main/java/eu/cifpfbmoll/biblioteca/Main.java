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
        Biblioteca biblioteca = new Biblioteca("maria Moliner");
        biblioteca.setLibros(coleccion);
        //biblioteca.mostrarLibros();
        //Libro.añadirLibro(biblioteca.getLibros());
        //System.out.println(biblioteca.toString());
        //biblioteca.mostrarLibros();
        //biblioteca.mostrarLibrosDisponibles();
        
        Persona personaPrueba = new Persona("Rosalia", "De Castro", "100", "123456789");
        ArrayList<Persona> personal = biblioteca.getPersonal();
        personal.add(0, personaPrueba);
        biblioteca.setPersonal(personal);
      
        //Persona.añadirPersona(biblioteca.getPersonal());
        
        //System.out.println(biblioteca.getPersonal());
        //Persona.eliminarPersona(biblioteca.getPersonal());
        
        Usuario usuarioPrueba = new Usuario("Rafaela", "Cerbuna", "200", "123456789");
        ArrayList <Usuario> arrayUsuarios = biblioteca.getUsuarios();
        arrayUsuarios.add(0, usuarioPrueba);
        biblioteca.setUsuarios(arrayUsuarios);
        
        boolean continuar = true;
        while(continuar){
            Scanner lector = new Scanner(System.in);
            System.out.println("Escribe la opción que quieras:" + "\n" + " A: Gestionar Libros" + "\n" + " B: Gestionar Personal" + "\n" + "U: Gestionar Usuarios" +"\n"+ " salir: cerrar la aplicación" );
            String opcionUsuario = lector.nextLine();
            System.out.println("La opción del usuario es " + opcionUsuario);
            switch(opcionUsuario){
            case "A":
                System.out.println("Vas a gestionar los libros");
                boolean gestionarLibros = true;
                while (gestionarLibros){
                    System.out.println("Escribe la opción con libros a realizar");
                    System.out.println("V : Ver todos los libros de la biblioteca");
                    System.out.println("VD: Ver los libros disponibles de la biblioteca");
                    System.out.println("A: Añadir libro a la biblioteca");
                    System.out.println("E: Eliminar libro por ISBN");
                    System.out.println("BI: Buscar libro por ISBN");
                    System.out.println("BT: Buscar libro por título");
                    System.out.println("SalirLibros : para volver al menú principal");
                    String opcionGestionLibros = lector.nextLine();
                    switch(opcionGestionLibros){
                        case "V":
                            System.out.println("Vas a ver todos los libros de la biblioteca");
                            biblioteca.mostrarLibros();
                            break;
                        case "VD":
                            System.out.println("Los libros disponibles son: ");
                            biblioteca.mostrarLibrosDisponibles();
                            break;
                        case "A":
                            System.out.println("Vas a añadir un libro a la biblioteca");
                            Libro.añadirLibro(biblioteca.getLibros());
                            break;
                        case "E":
                            System.out.println("Vas a eliminar un libro");
                            Libro.eliminarLibro(biblioteca.getLibros());
                            break;
                        case "BI":
                            System.out.println("Vas a eliminar un libro por ISBN");
                            System.out.println(Libro.buscarLibroPorISBN(biblioteca.getLibros()));
                            break;
                        case "BT":
                            System.out.println("Vas a buscar un libro por título");
                            Libro.buscarLibroPorTitulo(biblioteca.getLibros());
                            break;
                        case "SalirLibros":
                            System.out.println("Vas a dejar la gestión de libros. Adiós");
                            gestionarLibros = false;
                            break;
                        default:
                            System.out.println("Opción incorrecta. Vuelve a probar");
                    }
                }
                break;
            case "B":
                System.out.println("Vas a gestionar al personal");
                boolean gestionarPersonas = true;
                while(gestionarPersonas){
                    System.out.println("Vas a gestionar personas");
                    System.out.println("A: Añadir Persona");
                    System.out.println("E: Eliminar Persona");
                    System.out.println("V: Ver todas las personas");
                    System.out.println("SalirPersonas: volver al menu principal");
                    String opcionGestionPersonas = lector.nextLine();
                    switch(opcionGestionPersonas){
                        case "A": 
                            System.out.println("Vas a añadir una persona");
                            Persona.añadirPersona(biblioteca.getPersonal());
                            break;
                        case "E":
                            System.out.println("Vas a eliminar una persona");
                            Persona.eliminarPersona(biblioteca.getPersonal());
                            break;
                        case "V":
                            System.out.println("Estas son las personas");
                            System.out.println(biblioteca.getPersonal().toString());
                            break;
                        case "SalirPersonas":
                            System.out.println("Vas a dejar la gestión de las personas");
                            gestionarPersonas = false;
                        default:
                            System.out.println("Opción incorrecta. Vuelve a probar");    
                    }
                }
                break;
            case "U":
                System.out.println("Vas a gestionar usuarios");
                biblioteca.seleccionarUsuario();
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
