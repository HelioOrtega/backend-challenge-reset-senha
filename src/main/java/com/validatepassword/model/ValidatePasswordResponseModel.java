package com.validatepassword.model;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;

/**
 * @author helio.ortega
 * @since 10/2021
 */
@Getter
@Setter
@ToString
@Builder
public class ValidatePasswordResponseModel {

    private boolean isValid;
    private List<String> errorList;
}
