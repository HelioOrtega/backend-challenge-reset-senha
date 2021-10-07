package com.validasenha.controller;

import com.validasenha.model.ValidaSenhaModel;
import com.validasenha.service.ValidaSenhaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/senha")
public class ValidaSenhaController {

    @Autowired
    private ValidaSenhaService service;

    @GetMapping("/valida/{senha}")
    public ValidaSenhaModel validaSenha(@PathVariable String senha) {
        return service.validaSenha(senha);
    }
}
