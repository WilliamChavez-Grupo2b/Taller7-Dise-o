package com.taller7.dise_o.service;

import java.time.LocalDate;
import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import com.taller7.dise_o.dto.Estudiantedto;
import com.taller7.dise_o.dto.Librodto;
import com.taller7.dise_o.dto.Prestamodto;
import com.taller7.dise_o.model.Estudiante;
import com.taller7.dise_o.model.Libro;
import com.taller7.dise_o.model.Prestamo;
import com.taller7.dise_o.repository.EstudianteRepository;
import com.taller7.dise_o.repository.LibroRepository;
import com.taller7.dise_o.repository.PrestamoRepository;

@Service
public class PrestamoService {

    private final EstudianteRepository estudianteRepository;
    private final LibroRepository libroRepository;
    private final PrestamoRepository prestamoRepository;

    public PrestamoService(
            EstudianteRepository estudianteRepository,
            LibroRepository libroRepository,
            PrestamoRepository prestamoRepository) {
        this.estudianteRepository = estudianteRepository;
        this.libroRepository = libroRepository;
        this.prestamoRepository = prestamoRepository;
    }

    @Transactional
    public Prestamodto registrar(Long estudianteId, Long libroId) {
        Estudiante estudiante = estudianteRepository.findById(estudianteId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Estudiante no encontrado"));
        Libro libro = libroRepository.findById(libroId)
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND, "Libro no encontrado"));

        Prestamo prestamo = new Prestamo();
        prestamo.setEstudiante(estudiante);
        prestamo.setLibro(libro);
        prestamo.setFechaPrestamo(LocalDate.now());

        return toDto(prestamoRepository.save(prestamo));
    }

    @Transactional(readOnly = true)
    public List<Prestamodto> listar() {
        return prestamoRepository.findAll().stream()
                .map(this::toDto)
                .toList();
    }

    private Prestamodto toDto(Prestamo prestamo) {
        Estudiantedto estudianteDto = new Estudiantedto();
        estudianteDto.setId(prestamo.getEstudiante().getId());
        estudianteDto.setNombre(prestamo.getEstudiante().getNombre());
        estudianteDto.setCodigo(prestamo.getEstudiante().getCodigo());

        Librodto libroDto = new Librodto();
        libroDto.setId(prestamo.getLibro().getId());
        libroDto.setTitulo(prestamo.getLibro().getTitulo());
        libroDto.setIsbn(prestamo.getLibro().getIsbn());
        libroDto.setDisponible(prestamo.getLibro().isDisponible());

        Prestamodto prestamoDto = new Prestamodto();
        prestamoDto.setId(prestamo.getId());
        prestamoDto.setFechaPrestamo(prestamo.getFechaPrestamo());
        prestamoDto.setEstudiante(estudianteDto);
        prestamoDto.setLibro(libroDto);
        return prestamoDto;
    }
}
