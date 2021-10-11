package com.validatepassword.service.impl;

import com.validatepassword.model.ValidatePasswordResponseModel;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static com.validatepassword.utils.PasswordUtils.*;
import static org.junit.Assert.*;
import static org.mockito.Mockito.spy;

/**
 * @author helio.ortega
 * @since 10/2021
 */
public class ValidatePasswordServiceImplTest {

    private ValidePasswordServiceImpl service;

    @BeforeEach
    private void init() {
        service = spy(ValidePasswordServiceImpl.class);
    }


    @Test
    public void testShouldValidateFalseWhenPasswordHasEmptyPassword() {
        ValidatePasswordResponseModel response = service.validatePassword("");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(PASSWORD_EMPTY));
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasOnlyLowerCaseAndRepeated() {
        ValidatePasswordResponseModel response = service.validatePassword("aa");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(NOT_REPEATED_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasOnlyLowerCase() {
        ValidatePasswordResponseModel response = service.validatePassword("ab");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(UPPERCASE_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasUpperAndLowerCaseRepeated() {
        ValidatePasswordResponseModel response = service.validatePassword("AAAbbbCc");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(SIZE_REQUIRED));
        assertTrue(response.getErrorList().contains(SPECIAL_CHAR_REQUIRED));
        assertTrue(response.getErrorList().contains(NOT_REPEATED_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasConsecutiveRepeatedChars() {
        ValidatePasswordResponseModel response = service.validatePassword("AbTp9!foo");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(NOT_REPEATED_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasRepeatedChars() {
        ValidatePasswordResponseModel response = service.validatePassword("AbTp9!foA");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(NOT_REPEATED_REQUIRED));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasBlankSpace() {
        ValidatePasswordResponseModel response = service.validatePassword("AbTp9 fok");
        assertFalse(response.isValid());
        assertTrue(response.getErrorList().contains(PASSWORD_HAS_BLANK_SPACES));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordIsValid() {
        ValidatePasswordResponseModel response = service.validatePassword("AbTp9!fok");
        assertTrue(response.isValid());
        assertTrue(response.getErrorList().isEmpty());
    }

    @Test
    public void testShouldValidateOnlyReturnFalseWhenPasswordInvalid() {
        assertFalse(service.validatePasswordOnly("AbTp9 fok"));
    }

    @Test
    public void testShouldValidateOnlyReturnTrueWhenPasswordValid() {
        assertTrue(service.validatePasswordOnly("AbTp9!fok"));
    }
}
