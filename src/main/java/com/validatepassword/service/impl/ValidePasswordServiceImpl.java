package com.validatepassword.service.impl;

import com.validatepassword.enums.ValidationEnum;
import com.validatepassword.model.ValidatePasswordResponseModel;
import com.validatepassword.service.ValidePasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.MutablePropertyValues;
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

        boolean isValid=false;

        List<String> errorList = validatePasswordCritereas(password);

        if(errorList.isEmpty()){
            isValid=true;
        }

        return ValidatePasswordResponseModel.builder().isValid(isValid).errorList(errorList).build();
    }

    @Override
    public boolean validatePasswordOnly(String password) {
        if(validatePasswordCritereas(password).isEmpty()) {
            return true;
        } else {
            return false;
        }
    }

    private  ArrayList<String>  validatePasswordCritereas(String password) {

        log.info("Validando a senha...");

        boolean isPasswordValid;
        ArrayList<String> errorList = new ArrayList<>();

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

        log.info("Senha validiada com sucesso!");

        return errorList;
    }

}
