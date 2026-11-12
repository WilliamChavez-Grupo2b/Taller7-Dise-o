package com.taller7.dise_o.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.taller7.dise_o.model.Estudiante;

public interface EstudianteRepository extends JpaRepository<Estudiante, Long> {

    List<Estudiante> findByCodigo(String codigo);

    List<Estudiante> findByNombreContainingIgnoreCase(String nombre);
}
