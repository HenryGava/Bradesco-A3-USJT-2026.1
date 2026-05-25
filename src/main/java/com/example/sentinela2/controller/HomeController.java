package com.example.sentinela2.controller;

import com.example.sentinela2.model.Denuncia;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;

@Controller
public class HomeController {

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("totalDenuncias", 1284);
        model.addAttribute("totalSuspeitos", 342);
        model.addAttribute("percentualFalsaCentral", "89%");
        return "index";
    }

    @GetMapping("/consultar")
    public String consultar(Model model) {
        return "consultar";
    }

    @GetMapping("/denunciar")
    public String denunciar(Model model) {
        model.addAttribute("denuncia", new Denuncia());
        return "denunciar";
    }

    @PostMapping("/denunciar")
    public String salvarDenuncia(@ModelAttribute Denuncia denuncia) {
        return "redirect:/denunciar?sucesso";
    }
}