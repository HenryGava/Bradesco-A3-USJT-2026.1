package com.example.sentinela2.controller;

import com.example.sentinela2.dto.DenunciaRequestDTO;
import com.example.sentinela2.dto.DenunciaResponseDTO;
import com.example.sentinela2.model.DenunciaStatus;
import com.example.sentinela2.model.TipoAmeaca;
import com.example.sentinela2.service.DenunciaService;
import jakarta.validation.Valid;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/denuncias")
public class DenunciaController {

    private final DenunciaService denunciaService;

    public DenunciaController(DenunciaService denunciaService) {
        this.denunciaService = denunciaService;
    }

    @PostMapping
    public ResponseEntity<DenunciaResponseDTO> criarDenuncia(
            @RequestHeader("X-Usuario-Id") String usuarioId,
            @Valid @RequestBody DenunciaRequestDTO request
    ) {
        DenunciaResponseDTO response = denunciaService.criarDenuncia(usuarioId, request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @GetMapping
    public ResponseEntity<Page<DenunciaResponseDTO>> listarDenuncias(
            @PageableDefault(page = 0, size = 10) Pageable pageable
    ) {
        Page<DenunciaResponseDTO> page = denunciaService.listarDenuncias(pageable);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/busca")
    public ResponseEntity<Page<DenunciaResponseDTO>> buscarDenuncias(
            @RequestParam(required = false) String termo,
            @RequestParam(required = false) TipoAmeaca tipoAmeaca,
            @RequestParam(required = false) DenunciaStatus status,
            @PageableDefault(page = 0, size = 10)
            Pageable pageable
    ) {
        Page<DenunciaResponseDTO> page = denunciaService.buscarDenuncias(termo, tipoAmeaca, status, pageable);
        return ResponseEntity.ok(page);
    }
}