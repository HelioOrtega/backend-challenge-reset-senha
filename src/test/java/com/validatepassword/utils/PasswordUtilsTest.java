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
    public void testShouldValidateFalseWhenPasswordSizeNotValid() {
        assertFalse(utils.validatePasswordRegex("123", PasswordUtils.REGEX_SIZE));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordSizeIsValid() {
        assertTrue(utils.validatePasswordRegex("123456789", PasswordUtils.REGEX_SIZE));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasNoDigits() {
        assertFalse(utils.validatePasswordRegex("abcdef", PasswordUtils.REGEX_DIGIT));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordHasDigits() {
        assertTrue(utils.validatePasswordRegex("abc123", PasswordUtils.REGEX_DIGIT));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasNoUpperCase() {
        assertFalse(utils.validatePasswordRegex("abc", PasswordUtils.REGEX_UPPERCASE_CHAR));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordHasUpperCase() {
        assertTrue(utils.validatePasswordRegex("Abc", PasswordUtils.REGEX_UPPERCASE_CHAR));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasNoLowerCase() {
        assertFalse(utils.validatePasswordRegex("ABC", PasswordUtils.REGEX_LOWERCASE_CHAR));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordHasLowerCaseCase() {
        assertTrue(utils.validatePasswordRegex("ABc", PasswordUtils.REGEX_LOWERCASE_CHAR));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasNoSpecialCharacters() {
        assertFalse(utils.validatePasswordRegex("abc123", PasswordUtils.REGEX_SPECIAL_CHAR));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordHasSpecialCharacters() {
        assertTrue(utils.validatePasswordRegex("abc!@#$123", PasswordUtils.REGEX_SPECIAL_CHAR));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasRepeatingCharacters() {
        assertFalse(utils.validatePasswordRegex("AAbcde", PasswordUtils.REGEX_REPEATED_CHAR));
    }

    @Test
    public void testShouldValidateTrueWhenPasswordHasNoRepeatingCharacters() {
        assertTrue(utils.validatePasswordRegex("abcde", PasswordUtils.REGEX_REPEATED_CHAR));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordisEmpty() {
        assertFalse(utils.validatePasswordRegex("", PasswordUtils.REGEX_NOT_EMPTY));
    }

    @Test
    public void testShouldValidateFalseWhenPasswordHasEmptySpaces() {
        assertFalse(utils.validatePasswordRegex(" ", PasswordUtils.REGEX_BLANK_SPACE));
    }
}
