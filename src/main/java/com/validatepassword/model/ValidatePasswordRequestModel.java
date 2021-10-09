package com.validatepassword.model;

import lombok.*;

import javax.validation.constraints.NotNull;

/**
 * @author helio.ortega
 * @since 10/2021
 */
@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class ValidatePasswordRequestModel {

    @NotNull
    private String password;
}
