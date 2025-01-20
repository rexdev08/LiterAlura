package com.rexdev08.LiterAlura.gutendex;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.rexdev08.LiterAlura.libro.Libro;

@Service
public class GutendexService {

    private static final String BASE_URL = "https://gutendex.com/books";

    public List<Libro> buscarLibros(String busqueda) {
        // Usa RestTemplate para realizar la petición
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "?search=" + busqueda;

        // Realiza la petición y mapea el resultado
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        // Convierte la respuesta en una lista de objetos Libro
        return response.getResults().stream().map(this::convertirAGutendexLibro).collect(Collectors.toList());
    }

    public List<String> buscarAutores(String busqueda) {
        // Similar al método buscarLibros, pero devuelve una lista de nombres de autores
        RestTemplate restTemplate = new RestTemplate();
        String url = BASE_URL + "?search=" + busqueda;

        // Realiza la petición y mapea el resultado
        GutendexResponse response = restTemplate.getForObject(url, GutendexResponse.class);

        // Devuelve los nombres de los autores
        return response.getResults().stream()
                .flatMap(book -> book.getAuthors().stream())
                .map(AutorGutendex::getName)
                .distinct()
                .collect(Collectors.toList());
    }

    private Libro convertirAGutendexLibro(GutendexBook gutendexBook) {
        Libro libro = new Libro();
        libro.setTitulo(gutendexBook.getTitle());
        libro.setIdioma(gutendexBook.getLanguage());
        libro.setAnoPublicacion(gutendexBook.getYear());
    
        // Convertir autores a una lista de Strings
        List<String> autores = gutendexBook.getAuthors().stream()
                                           .map(AutorGutendex::getName)  // Asumiendo que AutorGutendex tiene el método getName()
                                           .collect(Collectors.toList());
    
        libro.setAutores(autores);  // Establecer los autores como una lista de Strings
    
        return libro;
    }
    
}
