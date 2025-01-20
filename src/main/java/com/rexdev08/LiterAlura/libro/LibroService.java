package com.rexdev08.LiterAlura.libro;

import java.util.List;

import org.springframework.stereotype.Service;

import com.rexdev08.LiterAlura.autor.Autor;
import com.rexdev08.LiterAlura.autor.AutorRepository;
import com.rexdev08.LiterAlura.gutendex.GutendexService;

@Service
public class LibroService {

    private final LibroRepository libroRepository;
    private final AutorRepository autorRepository;
    private final GutendexService gutendexService;

    public LibroService(LibroRepository libroRepository, AutorRepository autorRepository, GutendexService gutendexService) {
        this.libroRepository = libroRepository;
        this.autorRepository = autorRepository;
        this.gutendexService = gutendexService;
    }

    // Registrar un libro
    public void registrarLibro(String titulo, String idioma, int ano, String nombreAutor) {
        // Verifica si el autor ya existe
        Autor autor = autorRepository.findByNombre(nombreAutor)
                .orElseGet(() -> {
                    // Si no existe, crea y guarda uno nuevo
                    Autor nuevoAutor = new Autor();
                    nuevoAutor.setNombre(nombreAutor);
                    return autorRepository.save(nuevoAutor);
                });

        // Crea un nuevo libro
        Libro libro = new Libro();
        libro.setTitulo(titulo);
        libro.setIdioma(idioma);
        libro.setAnoPublicacion(ano);
        libro.setAutor(autor);

        // Guarda el libro en la base de datos
        libroRepository.save(libro);
    }

    // Consultar libros desde la base de datos
    public List<Libro> consultarLibros() {
        return libroRepository.findAll();
    }

    // Consultar libros desde Gutendex
    public List<Libro> consultarLibrosDesdeGutendex(String busqueda) {
        return gutendexService.buscarLibros(busqueda);
    }

    // Listar libros por idioma desde la base de datos
    public List<Libro> listarLibrosPorIdioma(String idioma) {
        return libroRepository.findByIdioma(idioma);
    }
}
