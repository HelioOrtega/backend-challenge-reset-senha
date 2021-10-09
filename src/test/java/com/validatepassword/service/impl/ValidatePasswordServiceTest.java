package com.validatepassword.service.impl;

import com.validatepassword.model.ValidatePasswordResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import static com.validatepassword.utils.PasswordUtils.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

/**
 * @author helio.ortega
 * @since 10/2021
 */
public class ValidatePasswordServiceTest {

    private ValidePasswordServiceImpl service;

    @Mock
    private ValidatePasswordResponseModel validatePasswordResponseModel;

    @BeforeEach
    private void init() {
        service = spy(ValidePasswordServiceImpl.class);
    }


    @Test
    public void testShouldValidateFalseWhenPasswordIsNotValidEmptyPassword() {
        ValidatePasswordResponseModel response = service.validatePassword("");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(PASSWORD_EMPTY));
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordIsNotValidLowerCaseAndRepeated() {
        ValidatePasswordResponseModel response = service.validatePassword("aa");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(NOT_REPEATED_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordIsNotValidLowerCase() {
        ValidatePasswordResponseModel response = service.validatePassword("ab");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
    }



}
