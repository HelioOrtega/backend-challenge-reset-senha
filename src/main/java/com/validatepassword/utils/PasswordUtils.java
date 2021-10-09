package com.validatepassword.utils;

/**
 * @author helio.ortega
 * @since 10/2021
 */
public class PasswordUtils {

    /**
     * Nove ou mais caracteres
     */
    public static final String REGEX_SIZE = ".{9,}";

    /**
     * Ao menos 1 dígito
     */
    public static final String REGEX_DIGIT = ".*\\d.*";

    /**
     * Ao menos 1 letra minúscula
     */
    public static final String REGEX_UPPERCASE_CHAR = "(.*[A-Z].*)";

    /**
     * Ao menos 1 letra minúscula
     */
    public static final String REGEX_LOWERCASE_CHAR = "(.*[a-z].*)";

    /**
     * Ao menos 1 caractere especial. Considere como especial os seguintes caracteres: !@#$%^&*()-+
     */
    public static final String REGEX_SPECIAL_CHAR = "(.*[!@#$%^&*()\\-+].*)";

    /**
     * Não possuir caracteres repetidos dentro do conjunto
     */
    public static final String REGEX_REPEATED_CHAR = "^(?!.*?(.).*?\\1)[a-zA-Z0-9!@#$%^&*()\\-+\" \"]*$";

    /**
     * Não possuir caracteres em branco
     */
    public static final String REGEX_BLANK_SPACE = "^\\S*$";

    /**
     * Nâo deve ser vazia
     */
    public static final String REGEX_NOT_EMPTY = "^(?=\\s*\\S).*$";

    public static final String SIZE_REQUIRED = "A senha precisa ter um tamanho de 9 ou mais caractéress";
    public static final String DIGIT_REQUIRED = "A senha precisa conter um dígito de 0 a 9";
    public static final String UPPERCASE_CHAR_REQUIRED = "A senha precisa conter um caractére maíúsculo";
    public static final String LOWERCASE_CHAR_REQUIRED = "A senha precisa conter um caractére minúsculo";
    public static final String SPECIAL_CHAR_REQUIRED = "A senha precisa conter um caractére especial dentre esses: !@#$%^&*()-+";
    public static final String NOT_REPEATED_REQUIRED = "A senha não pode conter caractéres repetidos";
    public static final String PASSWORD_HAS_BLANK_SPACES = "A senha não pode conter espaços vazios";
    public static final String PASSWORD_EMPTY = "A senha não ser vazia";


    public static boolean validatePasswordRegex(String password, String regex) {
        return password.matches(regex);
    }

}
