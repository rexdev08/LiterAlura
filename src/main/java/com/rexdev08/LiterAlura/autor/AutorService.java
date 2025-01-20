package com.rexdev08.LiterAlura.autor;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.rexdev08.LiterAlura.gutendex.GutendexService;

@Service
public class AutorService {

    private final AutorRepository autorRepository;
    private final GutendexService gutendexService;

    public AutorService(AutorRepository autorRepository, GutendexService gutendexService) {
        this.autorRepository = autorRepository;
        this.gutendexService = gutendexService;
    }

    // Consultar autores desde la base de datos
    public List<Autor> consultarAutores() {
        return autorRepository.findAll();
    }

    // Consultar autores desde Gutendex
    public List<String> consultarAutoresDesdeGutendex(String busqueda) {
        return gutendexService.buscarAutores(busqueda);
    }

    // Listar autores por año
    public List<Autor> listarAutoresPorAno(int ano) {
        return autorRepository.findByAnoNacimiento(ano);
    }

    public Autor obtenerORegistrarAutor(String nombreAutor) {
        // Buscar si el autor ya existe en la base de datos
        Optional<Autor> autorExistente = autorRepository.findByNombre(nombreAutor);

        if (autorExistente.isPresent()) {
            // Si el autor existe, devolverlo
            return autorExistente.get();
        } else {
            // Si el autor no existe, registrarlo
            Autor nuevoAutor = new Autor();
            nuevoAutor.setNombre(nombreAutor);
            return autorRepository.save(nuevoAutor);
        }
    }
}
