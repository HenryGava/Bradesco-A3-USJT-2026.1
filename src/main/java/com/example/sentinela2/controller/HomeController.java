package com.example.sentinela2.controller;

import com.example.sentinela2.model.Denuncia;
import com.example.sentinela2.model.DenunciaStatus;
import com.example.sentinela2.model.TipoAmeaca;
import com.example.sentinela2.model.TelefoneSuspeito;
import com.example.sentinela2.repository.DenunciaRepository;
import com.example.sentinela2.repository.TelefoneSuspeitoRepository;
import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Controller
public class HomeController {

    private final DenunciaRepository denunciaRepository;
    private final TelefoneSuspeitoRepository telefoneRepository;

    public HomeController(DenunciaRepository denunciaRepository,
                          TelefoneSuspeitoRepository telefoneRepository) {
        this.denunciaRepository = denunciaRepository;
        this.telefoneRepository = telefoneRepository;
    }

    @GetMapping("/")
    public String index(Model model) {
        long totalDenuncias = denunciaRepository.count();
        long totalSuspeitos = telefoneRepository.count();

        String percentualFalsaCentral;
        if (totalDenuncias == 0) {
            percentualFalsaCentral = "0%";
        } else {
            long totalVirtual = denunciaRepository.countByTipoAmeaca(TipoAmeaca.VIRTUAL);
            long percentual = Math.round((totalVirtual * 100.0) / totalDenuncias);
            percentualFalsaCentral = percentual + "%";
        }

        model.addAttribute("totalDenuncias", totalDenuncias);
        model.addAttribute("totalSuspeitos", totalSuspeitos);
        model.addAttribute("percentualFalsaCentral", percentualFalsaCentral);
        return "index";
    }

    @GetMapping("/consultar")
    public String consultar(@RequestParam(required = false) String numero, Model model) {

        List<TelefoneSuspeito> recentes = telefoneRepository.findTop5ByOrderByTotalDenunciasDesc();
        model.addAttribute("recentes", recentes);

        if (numero == null || numero.isBlank()) {
            return "consultar";
        }

        Optional<TelefoneSuspeito> encontrado = telefoneRepository.findByNumero(numero.trim());

        if (encontrado.isPresent()) {
            TelefoneSuspeito tel = encontrado.get();
            model.addAttribute("resultado", tel);

            String nivelRisco;
            if (tel.getTotalDenuncias() >= 5) {
                nivelRisco = "ALTO";
            } else if (tel.getTotalDenuncias() >= 2) {
                nivelRisco = "MEDIO";
            } else if (tel.getTotalDenuncias() == 1) {
                nivelRisco = "BAIXO";
            } else {
                nivelRisco = "SEM";
            }
            model.addAttribute("nivelRisco", nivelRisco);
        }

        return "consultar";
    }

    @GetMapping("/denunciar")
    public String denunciar(Model model) {
        model.addAttribute("denuncia", new Denuncia());
        return "denunciar";
    }

    @PostMapping("/denunciar")
    public String salvarDenuncia(@Valid @ModelAttribute Denuncia denuncia,
                                 BindingResult resultado) {

        // se houver erros de validação, volta pro form mostrando os erros
        if (resultado.hasErrors()) {
            return "denunciar";
        }

        denuncia.setStatus(DenunciaStatus.PENDENTE);
        denuncia.setData(LocalDateTime.now());
        denuncia.setUsuarioId("anonimo");

        denunciaRepository.save(denuncia);

        if (denuncia.getNumero() != null && !denuncia.getNumero().isBlank()) {
            String num = denuncia.getNumero().trim();
            TelefoneSuspeito tel = telefoneRepository.findByNumero(num)
                    .orElse(new TelefoneSuspeito(num));
            tel.incrementarDenuncias();
            telefoneRepository.save(tel);
        }

        return "redirect:/denunciar?sucesso";
    }
}