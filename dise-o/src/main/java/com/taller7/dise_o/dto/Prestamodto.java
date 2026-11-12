package com.taller7.dise_o.dto;

import java.time.LocalDate;

public class Prestamodto {

    private long id;
    private LocalDate fechaPrestamo;
    private Estudiantedto estudiante;
    private Librodto libro;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public LocalDate getFechaPrestamo() {
        return fechaPrestamo;
    }

    public void setFechaPrestamo(LocalDate fechaPrestamo) {
        this.fechaPrestamo = fechaPrestamo;
    }

    public Estudiantedto getEstudiante() {
        return estudiante;
    }

    public void setEstudiante(Estudiantedto estudiante) {
        this.estudiante = estudiante;
    }

    public Librodto getLibro() {
        return libro;
    }

    public void setLibro(Librodto libro) {
        this.libro = libro;
    }
}