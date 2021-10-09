package com.validatepassword.controller;

import com.validatepassword.model.ValidatePasswordRequestModel;
import com.validatepassword.model.ValidatePasswordResponseModel;
import com.validatepassword.service.ValidePasswordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

/**
 * @author helio.ortega
 * @since 10/2021
 */
@RestController
@RequestMapping("/v1/password")
public class ValidatePasswordController {

    @Autowired
    private ValidePasswordService service;

    @PostMapping("/validate")
    public ValidatePasswordResponseModel validatePassword(@Valid @RequestBody ValidatePasswordRequestModel request) {
        return service.validatePassword(request.getPassword());
    }

    @PostMapping("/validate-only")
    public boolean validatePasswordOnly(@Valid @RequestBody ValidatePasswordRequestModel request) {
        return service.validatePasswordOnly(request.getPassword());
    }
}
