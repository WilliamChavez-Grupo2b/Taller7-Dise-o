package com.taller7.dise_o.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller7.dise_o.model.Libro;

public interface LibroRepository extends JpaRepository<Libro, Long> {

    List<Libro> findByIsbn(String isbn);

    List<Libro> findByTituloContainingIgnoreCase(String titulo);

    List<Libro> findByDisponible(boolean disponible);
}
