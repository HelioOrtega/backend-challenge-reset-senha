package com.validatepassword.service.impl;

import com.validatepassword.enums.ValidationEnum;
import com.validatepassword.model.ValidatePasswordResponseModel;
import com.validatepassword.service.ValidePasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.validatepassword.utils.PasswordUtils.*;

/**
 * @author helio.ortega
 * @since 10/2021
 */
@Service
@Slf4j
public class ValidePasswordServiceImpl implements ValidePasswordService {


    @Override
    public ValidatePasswordResponseModel validatePassword(String password) {

        boolean isValid = false;
        boolean isPasswordValid;
        List<String> errorList = new ArrayList<>();

        log.info("Validando a senha...");

        for (ValidationEnum validation : ValidationEnum.values()) {
            isPasswordValid = validatePasswordRegex(password, validation.getRegex());
            log.info("Validando o critério de senha - "+validation.getMessage());
            if (!isPasswordValid) {
                log.info("Critério inválido");
                errorList.add(validation.getMessage());
            } else {
                log.info("Critério válido");
            }
        }

        if(errorList.isEmpty()) {
            isValid = true;
        }

        log.info("Senha validiada com sucesso!");

        return ValidatePasswordResponseModel.builder().isValid(isValid).errorList(errorList).build();
    }

}
