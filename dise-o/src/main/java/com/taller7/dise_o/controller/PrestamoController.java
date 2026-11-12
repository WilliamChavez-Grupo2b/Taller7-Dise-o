package com.taller7.dise_o.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.taller7.dise_o.dto.Prestamodto;
import com.taller7.dise_o.service.PrestamoService;

@RestController
@RequestMapping("/prestamos")
public class PrestamoController {

    private final PrestamoService prestamoService;

    public PrestamoController(PrestamoService prestamoService) {
        this.prestamoService = prestamoService;
    }

    @PostMapping
    public Prestamodto registrar(
            @RequestParam Long estudianteId,
            @RequestParam Long libroId) {
        return prestamoService.registrar(estudianteId, libroId);
    }

    @GetMapping
    public List<Prestamodto> listar() {
        return prestamoService.listar();
    }
}
