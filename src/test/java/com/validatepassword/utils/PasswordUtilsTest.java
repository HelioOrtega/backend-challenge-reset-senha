package com.validatepassword.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

/**
 * @author helio.ortega
 * @since 10/2021
 */
public class PasswordUtilsTest {

    private PasswordUtils utils;

    @BeforeEach
    private void setUp() {
        utils = new PasswordUtils();
    }

    @Test
    public void shouldValidateFalseWhenPasswordSizeNotValid() {
        assertFalse(utils.validatePasswordRegex("123", PasswordUtils.REGEX_SIZE));
    }

    @Test
    public void shouldValidateTrueWhenPasswordSizeIsValid() {
        assertTrue(utils.validatePasswordRegex("123456789", PasswordUtils.REGEX_SIZE));
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoDigits() {
        assertFalse(utils.validatePasswordRegex("abcdef", PasswordUtils.REGEX_DIGIT));
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasDigits() {
        assertTrue(utils.validatePasswordRegex("abc123", PasswordUtils.REGEX_DIGIT));
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoUpperCase() {
        assertFalse(utils.validatePasswordRegex("abc", PasswordUtils.REGEX_UPPERCASE_CHAR));
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasUpperCase() {
        assertTrue(utils.validatePasswordRegex("Abc", PasswordUtils.REGEX_UPPERCASE_CHAR));
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoLowerCase() {
        assertFalse(utils.validatePasswordRegex("ABC", PasswordUtils.REGEX_LOWERCASE_CHAR));
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasLowerCaseCase() {
        assertTrue(utils.validatePasswordRegex("ABc", PasswordUtils.REGEX_LOWERCASE_CHAR));
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasNoSpecialCharacters() {
        assertFalse(utils.validatePasswordRegex("abc123", PasswordUtils.REGEX_SPECIAL_CHAR));
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasSpecialCharacters() {
        assertTrue(utils.validatePasswordRegex("abc!@#$123", PasswordUtils.REGEX_SPECIAL_CHAR));
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasRepeatingCharacters() {
        assertFalse(utils.validatePasswordRegex("AAbcde", PasswordUtils.REGEX_REPEATED_CHAR));
    }

    @Test
    public void shouldValidateTrueWhenPasswordHasNoRepeatingCharacters() {
        assertTrue(utils.validatePasswordRegex("abcde", PasswordUtils.REGEX_REPEATED_CHAR));
    }

    @Test
    public void shouldValidateFalseWhenPasswordisEmpty() {
        assertFalse(utils.validatePasswordRegex("", PasswordUtils.REGEX_NOT_EMPTY));
    }

    @Test
    public void shouldValidateFalseWhenPasswordHasEmptySpaces() {
        assertFalse(utils.validatePasswordRegex(" ", PasswordUtils.REGEX_BLANK_SPACE));
    }
}
