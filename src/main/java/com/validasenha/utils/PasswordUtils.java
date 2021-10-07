package com.validasenha.utils;

public class PasswordUtils {

    public static final String REGEX_SIZE = ".{9,}";
    public static final String REGEX_DIGIT = ".*\\d.*";
    public static final String REGEX_UPPERCASE_CHAR = "(.*[A-Z].*)";
    public static final String REGEX_LOWERCASE_CHAR = "(.*[a-z].*)";
    public static final String REGEX_SPECIAL_CHAR = "(.*[!@#$%^&*()-+].*)";
    public static final String REGEX_NOT_REPEATED = "^(?:([A-Za-z])(?!.*\\1))*$";

    public static final String SIZE_INVALID = "A senha precisa ter um tamanho de 9 ou mais";
    public static final String DIGIT_REQUIRED = "A senha precisa ter um dígito de 0 a 9";
    public static final String UPPERCASE_CHAR_REQUIRED = "A senha precisa conter um caractére maíúsculo";
    public static final String LOWERCASE_CHAR_REQUIRED = "A senha precisa conter um caractére minúsculo";
    public static final String SPECIAL_CHAR_REQUIRED = "A senha precisa conter um caractére especial dentre esses: !@#$%^&*()-+";
    public static final String NOT_REPEATED_REQUIRED = "A senha não pode conter caractéres repetidos";

    public static boolean validatePasswordRegex(String password, String regex){
        return password.matches(regex);
    }

}
