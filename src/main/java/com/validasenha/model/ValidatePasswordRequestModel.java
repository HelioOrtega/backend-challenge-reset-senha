package com.validasenha.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Builder
public class ValidatePasswordRequestModel {

    private String senha;
}
