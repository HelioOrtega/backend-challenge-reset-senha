package com.validatepassword.utils;

/**
 * @author helio.ortega
 * @since 10/2021
 */
public class PasswordUtils {

    public static final String REGEX_SIZE = ".{9,}";
    public static final String REGEX_DIGIT = ".*\\d.*";
    public static final String REGEX_UPPERCASE_CHAR = "(.*[A-Z].*)";
    public static final String REGEX_LOWERCASE_CHAR = "(.*[a-z].*)";
    public static final String REGEX_SPECIAL_CHAR = "(.*[!@#$%^&*()\\-+].*)";
    public static final String REGEX_REPEATED_CHAR = "^(?!.*?(.).*?\\1)[a-zA-Z0-9!@#$%^&*()\\-+\" \"]*$";
    public static final String REGEX_BLANK_SPACE = "^\\S*$";
    public static final String REGEX_NOT_EMPTY = "^(?=\\s*\\S).*$";

    public static final String SIZE_REQUIRED = "A senha precisa ter um tamanho de 9 ou mais caractéress";
    public static final String DIGIT_REQUIRED = "A senha precisa conter um dígito de 0 a 9";
    public static final String UPPERCASE_CHAR_REQUIRED = "A senha precisa conter um caractére maíúsculo";
    public static final String LOWERCASE_CHAR_REQUIRED = "A senha precisa conter um caractére minúsculo";
    public static final String SPECIAL_CHAR_REQUIRED = "A senha precisa conter um caractére especial dentre esses: !@#$%^&*()-+";
    public static final String NOT_REPEATED_REQUIRED = "A senha não pode conter caractéres repetidos";
    public static final String PASSWORD_HAS_EMPTY_SPACES = "A senha não pode conter espaços vazios";
    public static final String PASSWORD_EMPTY = "A senha não ser vazia";


    public static boolean validatePasswordRegex(String password, String regex) {
        return password.matches(regex);
    }

}
