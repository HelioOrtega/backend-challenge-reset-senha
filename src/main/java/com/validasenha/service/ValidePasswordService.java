package com.validasenha.service;

import com.validasenha.model.ValidatePasswordResponseModel;

public interface ValidePasswordService {

    ValidatePasswordResponseModel validatePassword(String senha);
}
