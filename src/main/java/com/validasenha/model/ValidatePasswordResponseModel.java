package com.validasenha.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

@Getter
@Setter
@ToString
@Builder
public class ValidatePasswordResponseModel {

    private boolean valid;
    private List<ValidatePasswordMessage> messageList;
}
