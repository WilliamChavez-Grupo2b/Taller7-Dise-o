package com.taller7.dise_o.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller7.dise_o.model.Prestamo;

public interface PrestamoRepository extends JpaRepository<Prestamo, Long> {

    List<Prestamo> findByEstudianteId(Long estudianteId);

    List<Prestamo> findByLibroId(Long libroId);
}
