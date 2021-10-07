package com.validasenha.controller;

import com.validasenha.model.ValidatePasswordResponseModel;
import com.validasenha.service.ValidePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/v1/password")
public class ValidatePasswordController {

    @Autowired
    private ValidePasswordService service;

    @PostMapping("/validate")
    public ValidatePasswordResponseModel validatePassword(@RequestBody String senha) {
        return service.validatePassword(senha);
    }
}
