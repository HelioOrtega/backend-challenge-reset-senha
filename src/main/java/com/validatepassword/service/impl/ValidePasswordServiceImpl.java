package com.validatepassword.service.impl;

import com.validatepassword.enums.ValidationEnum;
import com.validatepassword.model.ValidatePasswordResponseModel;
import com.validatepassword.service.ValidePasswordService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;
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

        log.info("Validando a senha");

        if(StringUtils.containsWhitespace(password)) {
            errorList.add(PASSWORD_CONTAINS_SPACES);
        }

        if(validatePasswordRegex(password, REGEX_REPEATED_CHAR)) {
            errorList.add(NOT_REPEATED_REQUIRED);
        }

        for (ValidationEnum validationEnum : ValidationEnum.values()) {
            boolean isPasswordValid = validatePasswordRegex(password, validationEnum.getRegex());
            if (!isPasswordValid) {
                errorList.add(validationEnum.getMessage());
            }
        }

        if(errorList.isEmpty()) {
            isValid = true;
        }

        log.info("Senha valdiada com sucesso");

        return ValidatePasswordResponseModel.builder().valid(isValid).errorList(errorList).build();
    }

}
