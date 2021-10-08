package com.validatepassword.enums;

import lombok.AllArgsConstructor;
import lombok.Getter;

import static com.validatepassword.utils.PasswordUtils.*;

@Getter
@AllArgsConstructor
public enum ValidationEnum {

    SIZE(REGEX_SIZE, SIZE_REQUIRED),
    DIGIT(REGEX_DIGIT, DIGIT_REQUIRED),
    UPPERCASE_CHAR(REGEX_UPPERCASE_CHAR, UPPERCASE_CHAR_REQUIRED),
    LOWERCASE_CHAR(REGEX_LOWERCASE_CHAR, LOWERCASE_CHAR_REQUIRED),
    SPECIAL_CHAR(REGEX_SPECIAL_CHAR, SPECIAL_CHAR_REQUIRED);
    //NOT_REPEATED(REGEX_NOT_REPEATED, NOT_REPEATED_REQUIRED);

    private final String regex;
    private final String message;

}
