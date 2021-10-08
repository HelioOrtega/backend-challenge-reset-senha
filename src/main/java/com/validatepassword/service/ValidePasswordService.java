package com.validatepassword.service;

import com.validatepassword.model.ValidatePasswordResponseModel;

public interface ValidePasswordService {

    ValidatePasswordResponseModel validatePassword(String senha);
}
