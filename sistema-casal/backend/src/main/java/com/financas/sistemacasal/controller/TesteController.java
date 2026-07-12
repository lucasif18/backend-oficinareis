package com.financas.sistemacasal.controller;

import org.springframework.web.bind.annotation.CrossOrigin; // 👈 Importa a anotação
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin(origins = "*") // 👈 Dá passe livre para o seu Vue.js entrar!
public class TesteController {

    @PostMapping("/api/teste")
    public String teste() {
        return "Backend funcionando!";
    }
}