package com.validatepassword.service;

import com.validatepassword.model.ValidatePasswordResponseModel;

/**
 * @author helio.ortega
 * @since 10/2021
 */
public interface ValidePasswordService {

    /**
     *
     * @param senha
     * @return ValidatePasswordResponseModel
     * Valida senha recebida em String e retorna um objeto com um booleano true se a senha é valida, false se a senha é
     * inválida, e uma lista de erros de validação da senha
     */
    ValidatePasswordResponseModel validatePassword(String senha);

    /**
     *
     * @param senha
     * @return boolean
     * Valida a senha recebida em String e retorna um boolean false se a senha for inválida e true se for válida
     */
    boolean validatePasswordOnly(String senha);
}
