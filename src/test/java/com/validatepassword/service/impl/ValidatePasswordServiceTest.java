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


//    @Test
//    public void shouldValidateFalseWhenPasswordSizeNotValid() {
//        Boolean isSizeValid = service.validateSize("123456");
//        assertFalse(isSizeValid);
//    }
//
//    @Test
//    public void shouldValidateTrueWhenPasswordSizeIsValid() {
//        Boolean isSizeValid = service.validateSize("123456789");
//        assertTrue(isSizeValid);
//    }
//
//    @Test
//    public void shouldValidateFalseWhenPasswordHasNoDigits() {
//        Boolean isDigitValid = service.validateDigit("abcdef");
//        assertFalse(isDigitValid);
//    }
//
//    @Test
//    public void shouldValidateTrueWhenPasswordHasDigits() {
//        Boolean isDigitValid = service.validateDigit("abc123");
//        assertTrue(isDigitValid);
//    }
//
//    @Test
//    public void shouldValidateFalseWhenPasswordHasNoUpperCase() {
//        Boolean isUpperCase = service.validateUpperCase("abc");
//        assertFalse(isUpperCase);
//    }
//
//    @Test
//    public void shouldValidateTrueWhenPasswordHasUpperCase() {
//        Boolean isUpperCase = service.validateUpperCase("Abc");
//        assertTrue(isUpperCase);
//    }
//
//    @Test
//    public void shouldValidateFalseWhenPasswordHasNoLowerCase() {
//        Boolean isLowerCase = service.validateLowerCase("ABC");
//        assertFalse(isLowerCase);
//    }
//
//    @Test
//    public void shouldValidateTrueWhenPasswordHasLowerCaseCase() {
//        Boolean isLowerCase = service.validateLowerCase("ABc");
//        assertTrue(isLowerCase);
//    }
//
//    @Test
//    public void shouldValidateFalseWhenPasswordHasNoSpecialCharacters() {
//        Boolean isSpecialCharacter = service.validateSpecialChar("abc123");
//        assertFalse(isSpecialCharacter);
//    }
//
//    @Test
//    public void shouldValidateTrueWhenPasswordHasSpecialCharacters() {
//        Boolean isSpecialCharacter = service.validateSpecialChar("abc!@#$123");
//        assertTrue(isSpecialCharacter);
//    }
//
//    @Test
//    public void shouldValidateFalseWhenPasswordHasRepeatingCharacters() {
//        Boolean isRepeatedCharacter = service.validateNotRepeated("AAbcde");
//        assertFalse(isRepeatedCharacter);
//    }
//
//    @Test
//    public void shouldValidateTrueWhenPasswordHasNoRepeatingCharacters() {
//        Boolean isRepeatedCharacter = service.validateNotRepeated("abcde");
//        assertTrue(isRepeatedCharacter);
//    }
}
