package com.validasenha.service.impl;

import com.validasenha.model.ValidatePasswordResponseModel;
import com.validasenha.service.ValidePasswordService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import static com.validasenha.utils.PasswordUtils.*;

@Service
@Slf4j
public class ValidePasswordServiceImpl implements ValidePasswordService {

    boolean isValid = false;

    @Override
    public ValidatePasswordResponseModel validatePassword(String password) {

        log.info("Validando a senha");

        boolean isValid = checkPasword(password);

        log.info("Senha valdiada com sucesso");

        return ValidatePasswordResponseModel.builder().valid(isValid).build();
    }

    public boolean checkPasword(String password) {
        isValid = validateSize(password);
        return isValid;
    }

    public boolean validateSize(String password) {
        if (validatePasswordRegex(password, REGEX_SIZE)) {
            isValid = true;
        }
        return isValid;
    }

    public boolean validateDigit(String password) {
        if (validatePasswordRegex(password, REGEX_DIGIT)) {
            isValid = true;
        }
        return isValid;
    }


    public boolean validateUpperCase(String password) {
        if (validatePasswordRegex(password, REGEX_UPPERCASE_CHAR)) {
            isValid = true;
        }
        return isValid;
    }

    public boolean validateLowerCase(String password) {
        if (validatePasswordRegex(password, REGEX_LOWERCASE_CHAR)) {
            isValid = true;
        }
        return isValid;
    }

    public boolean validateSpecialChar(String password) {
        if (validatePasswordRegex(password, REGEX_SPECIAL_CHAR)) {
            isValid = true;
        }
        return isValid;
    }

    public boolean validateNotRepeated(String password) {
        if (validatePasswordRegex(password, REGEX_NOT_REPEATED)) {
            isValid = true;
        }
        return isValid;
    }
}
