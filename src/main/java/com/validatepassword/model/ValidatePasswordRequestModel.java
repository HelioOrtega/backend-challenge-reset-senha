package com.validatepassword.model;

import lombok.*;

import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
public class ValidatePasswordRequestModel {

    @NotNull
    private String password;
}
