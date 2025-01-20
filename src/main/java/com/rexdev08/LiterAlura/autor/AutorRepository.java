package com.rexdev08.LiterAlura.autor;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AutorRepository extends JpaRepository<Autor, Long> {

    // Busca una lista de autores por su año de nacimiento
    List<Autor> findByAnoNacimiento(Integer ano);  // Aquí confirmamos que 'anoNacimiento' es de tipo Integer

    // Busca un autor por su nombre
    Optional<Autor> findByNombre(String nombre);  // 'nombre' ya está correctamente en la entidad 'Autor'
}
