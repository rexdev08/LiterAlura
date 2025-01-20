package com.rexdev08.LiterAlura.menu;

import java.util.Scanner;

import org.springframework.stereotype.Component;

import com.rexdev08.LiterAlura.autor.AutorService;
import com.rexdev08.LiterAlura.libro.LibroService;

@Component
public class Menu {

    private final Scanner scanner = new Scanner(System.in);
    private final LibroService libroService;
    private final AutorService autorService;

    public Menu(LibroService libroService, AutorService autorService) {
        this.libroService = libroService;
        this.autorService = autorService;
    }

    public void iniciar() {
        while (true) {
            System.out.println("\n--- Menú Principal ---");
            System.out.println("1. Registrar libro");
            System.out.println("2. Consultar libros");
            System.out.println("3. Consultar autores");
            System.out.println("4. Listado de libros por idioma");
            System.out.println("5. Listado de autores en determinado año");
            System.out.println("6. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1 -> registrarLibro();
                case 2 -> consultarLibros();
                case 3 -> consultarAutores();
                case 4 -> listarLibrosPorIdioma();
                case 5 -> listarAutoresPorAno();
                case 6 -> {
                    System.out.println("Saliendo...");
                    return;
                }
                default -> System.out.println("Opción inválida.");
            }
        }
    }

    private void registrarLibro() {
        System.out.print("Título: ");
        String titulo = scanner.nextLine();
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        System.out.print("Año de publicación: ");
        int ano = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Nombre del autor: ");
        String nombreAutor = scanner.nextLine();

        libroService.registrarLibro(titulo, idioma, ano, nombreAutor);
        System.out.println("Libro registrado exitosamente.");
    }

    private void consultarLibros() {
        libroService.consultarLibros().forEach(System.out::println);
    }

    private void consultarAutores() {
        autorService.consultarAutores().forEach(System.out::println);
    }

    private void listarLibrosPorIdioma() {
        System.out.print("Idioma: ");
        String idioma = scanner.nextLine();
        libroService.listarLibrosPorIdioma(idioma).forEach(System.out::println);
    }

    private void listarAutoresPorAno() {
        System.out.print("Año: ");
        int ano = scanner.nextInt();
        autorService.listarAutoresPorAno(ano).forEach(System.out::println);
    }
}
