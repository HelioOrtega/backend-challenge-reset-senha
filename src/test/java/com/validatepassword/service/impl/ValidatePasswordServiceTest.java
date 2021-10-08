package com.validatepassword.service.impl;

import com.validatepassword.exception.BadRequestException;
import com.validatepassword.model.ValidatePasswordResponseModel;
import org.junit.Before;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static com.validatepassword.utils.PasswordUtils.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;
import static org.mockito.Mockito.when;

public class ValidatePasswordServiceTest {

    private ValidePasswordServiceImpl service;

    @Mock
    private ValidatePasswordResponseModel validatePasswordResponseModel;

    @BeforeEach
    private void init() {
        service = spy(ValidePasswordServiceImpl.class);
    }

    @Test
    public void shouldValidateFalseWhenPasswordIsEmpty() {
        Assertions.assertThrows(BadRequestException.class, () -> {
            service.validatePassword("");
        });
    }

    @Test
    public void shouldValidateFalseWhenPasswordIsNotValid() {
        ValidatePasswordResponseModel response = service.validatePassword("123");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(LOWERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
    }



}
