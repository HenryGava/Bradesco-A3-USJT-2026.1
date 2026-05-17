package com.example.sentinela2;

import org.springframework.web.bind.annotation.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/denuncias")
public class DenunciaController {

    // Nossa lista que simula o banco de dados na memória RAM
    private List<Denuncia> listaMemoria = new ArrayList<>();

    // Rota para LISTAR todas as denúncias (GET)
    @GetMapping
    public List<Denuncia> listar() {
        return listaMemoria;
    }


    @PostMapping
    public String salvar(@RequestBody Denuncia denuncia) {
        listaMemoria.add(denuncia);
        return "Denúncia salva com sucesso na memória!";
    }
}