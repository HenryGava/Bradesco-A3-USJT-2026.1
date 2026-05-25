package com.example.sentinela2.service;

import com.example.sentinela2.dto.DenunciaRequestDTO;
import com.example.sentinela2.dto.DenunciaResponseDTO;
import com.example.sentinela2.model.Denuncia;
import com.example.sentinela2.model.DenunciaStatus;
import com.example.sentinela2.model.TipoAmeaca;
import com.example.sentinela2.repository.DenunciaRepository;
import com.example.sentinela2.specification.DenunciaSpecification;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
public class DenunciaService {

    private final DenunciaRepository denunciaRepository;

    public DenunciaService(DenunciaRepository denunciaRepository) {
        this.denunciaRepository = denunciaRepository;
    }

    public DenunciaResponseDTO criarDenuncia(String usuarioId, DenunciaRequestDTO request) {
        Denuncia denuncia = new Denuncia();
        denuncia.setTitulo(request.getTitulo().trim());
        denuncia.setDescricao(request.getDescricao().trim());
        denuncia.setTipoAmeaca(request.getTipoAmeaca());
        denuncia.setStatus(DenunciaStatus.PENDENTE);
        denuncia.setData(LocalDateTime.now());
        denuncia.setUsuarioId(usuarioId.trim());

        Denuncia salvo = denunciaRepository.save(denuncia);
        return mapParaResponse(salvo);
    }

    public Page<DenunciaResponseDTO> listarDenuncias(Pageable pageable) {
        return denunciaRepository.findAll(pageable).map(this::mapParaResponse);
    }

    public Page<DenunciaResponseDTO> buscarDenuncias(String termo, TipoAmeaca tipoAmeaca, DenunciaStatus status, Pageable pageable) {
        Specification<Denuncia> spec = Specification.where((Specification<Denuncia>) null);
        if (termo != null && !termo.isBlank()) {
            spec = spec.and(DenunciaSpecification.tituloOuDescricaoContem(termo));
        }
        if (tipoAmeaca != null) {
            spec = spec.and(DenunciaSpecification.tipoAmeacaIgual(tipoAmeaca));
        }
        if (status != null) {
            spec = spec.and(DenunciaSpecification.statusIgual(status));
        }

        return denunciaRepository.findAll(spec, pageable).map(this::mapParaResponse);
    }

    private DenunciaResponseDTO mapParaResponse(Denuncia denuncia) {
        DenunciaResponseDTO response = new DenunciaResponseDTO();
        response.setId(denuncia.getId());
        response.setTitulo(denuncia.getTitulo());
        response.setDescricao(denuncia.getDescricao());
        response.setTipoAmeaca(denuncia.getTipoAmeaca());
        response.setStatus(denuncia.getStatus());
        response.setData(denuncia.getData());
        response.setUsuarioId(denuncia.getUsuarioId());
        return response;
    }
}
