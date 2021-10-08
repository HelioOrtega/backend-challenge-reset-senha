package com.validatepassword.utils;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PasswordUtilsTest {

    private PasswordUtils utils;

    @BeforeEach
    private void setUp() {
        utils = new PasswordUtils();
    }

    @Test
    public void shouldValidateFalseRegex() {
        assertFalse(utils.validatePasswordRegex("123", PasswordUtils.REGEX_SIZE));
    }

    @Test
    public void shouldValidateTrueRegex() {
        assertTrue(utils.validatePasswordRegex("123456789", PasswordUtils.REGEX_SIZE));
    }
}
