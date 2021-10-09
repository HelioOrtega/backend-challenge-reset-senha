package com.validatepassword.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.validatepassword.utils.PasswordUtils.*;

/**
 * @author helio.ortega
 * @since 10/2021
 */
@Getter
@AllArgsConstructor
public enum ValidationEnum {

    SIZE(REGEX_SIZE, SIZE_REQUIRED),
    DIGIT(REGEX_DIGIT, DIGIT_REQUIRED),
    UPPERCASE_CHAR(REGEX_UPPERCASE_CHAR, UPPERCASE_CHAR_REQUIRED),
    LOWERCASE_CHAR(REGEX_LOWERCASE_CHAR, LOWERCASE_CHAR_REQUIRED),
    SPECIAL_CHAR(REGEX_SPECIAL_CHAR, SPECIAL_CHAR_REQUIRED),
    NOT_REPEATED(REGEX_REPEATED_CHAR, NOT_REPEATED_REQUIRED),
    NO_BLANK_SPACES(REGEX_BLANK_SPACE, PASSWORD_HAS_EMPTY_SPACES),
    NOT_EMPTY(REGEX_NOT_EMPTY, PASSWORD_EMPTY);

    private final String regex;
    private final String message;

}
