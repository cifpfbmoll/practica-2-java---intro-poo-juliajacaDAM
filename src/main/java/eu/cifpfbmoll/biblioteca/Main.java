/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package eu.cifpfbmoll.biblioteca;

import java.util.ArrayList;

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
        Libro.añadirLibro(biblioteca.getLibros());
        //System.out.println(biblioteca.toString());
        biblioteca.mostrarLibrosDisponibles();
        
    }
    
}
