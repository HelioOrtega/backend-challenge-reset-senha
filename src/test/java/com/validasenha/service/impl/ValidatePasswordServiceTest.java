package com.validasenha.service.impl;

import com.validasenha.model.ValidatePasswordResponseModel;
import com.validasenha.service.ValidePasswordService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

import static org.mockito.Mockito.spy;

public class ValidatePasswordServiceTest {

    private ValidePasswordServiceImpl service;

    @Mock
    private ValidatePasswordResponseModel validatePasswordResponseModel;

    @BeforeEach
    private void init() {
        service = spy(ValidePasswordServiceImpl.class);
    }

    @Test
    public void shouldValidateFalseWhenPasswordSizeNotValid() {
        Boolean isSizeValid = service.validateSize("123456");
        assertFalse(isSizeValid);
    }

    @Test
    public void shouldValidateTrueWhenPasswordSizeIsValid() {
        Boolean isSizeValid = service.validateSize("123456789");
        assertTrue(isSizeValid);
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoDigits() {
        Boolean isDigitValid = service.validateDigit("abcdef");
        assertFalse(isDigitValid);
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasDigits() {
        Boolean isDigitValid = service.validateDigit("abc123");
        assertTrue(isDigitValid);
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoUpperCase() {
        Boolean isUpperCase = service.validateUpperCase("abc");
        assertFalse(isUpperCase);
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasUpperCase() {
        Boolean isUpperCase = service.validateUpperCase("Abc");
        assertTrue(isUpperCase);
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoLowerCase() {
        Boolean isLowerCase = service.validateLowerCase("ABC");
        assertFalse(isLowerCase);
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasLowerCaseCase() {
        Boolean isLowerCase = service.validateLowerCase("ABc");
        assertTrue(isLowerCase);
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoSpecialCharacters() {
        Boolean isSpecialCharacter = service.validateSpecialChar("abc123");
        assertFalse(isSpecialCharacter);
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasSpecialCharacters() {
        Boolean isSpecialCharacter = service.validateSpecialChar("ABc");
        assertTrue(isSpecialCharacter);
    }
}
