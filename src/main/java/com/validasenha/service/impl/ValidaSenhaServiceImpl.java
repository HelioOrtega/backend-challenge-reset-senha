package com.validasenha.service.impl;

import com.validasenha.model.ValidaSenhaModel;
import com.validasenha.service.ValidaSenhaService;
import org.springframework.stereotype.Service;

@Service
public class ValidaSenhaServiceImpl implements ValidaSenhaService {

    @Override
    public ValidaSenhaModel validaSenha(String senha) {
        ValidaSenhaModel validaSenhaModel = ValidaSenhaModel.builder()
                .valid(true)
                .timestamp("01-01-2020")
                .build();
        return validaSenhaModel;
    }
}
