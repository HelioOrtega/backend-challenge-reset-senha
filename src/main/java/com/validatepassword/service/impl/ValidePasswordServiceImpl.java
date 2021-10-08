package com.validatepassword.service.impl;

import com.validatepassword.enums.ValidationEnum;
import com.validatepassword.model.ValidatePasswordResponseModel;
import com.validatepassword.service.ValidePasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static com.validatepassword.utils.PasswordUtils.*;

@Service
@Slf4j
public class ValidePasswordServiceImpl implements ValidePasswordService {


    @Override
    public ValidatePasswordResponseModel validatePassword(String password) {

        boolean isValid = false;
        List<String> errorList = new ArrayList<>();

        log.info("Validando a senha...");

        for (ValidationEnum validation : ValidationEnum.values()) {
            boolean isPasswordValid = validatePasswordRegex(password, validation.getRegex());
            if (!isPasswordValid) {
                log.info("Validando o critério de senha - "+validation.getMessage());
                errorList.add(validation.getMessage());
            }
        }

        if(errorList.isEmpty()) {
            isValid = true;
        }

        log.info("Senha validiada com sucesso!");

        return ValidatePasswordResponseModel.builder().isValid(isValid).errorList(errorList).build();
    }

}
