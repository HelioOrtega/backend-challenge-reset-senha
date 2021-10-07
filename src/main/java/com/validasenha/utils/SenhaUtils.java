package com.validasenha.utils;

public class SenhaUtils {

    public final String REGEX_SIZE = ".{9,}";
    public final String REGEX_DIGIT = "(\\d)";
    public final String REGEX_UPPERCASE_CHAR = "(.*[A-Z].*)";
    public final String REGEX_LOWERCASE_CHAR = "(.*[a-z].*)";
    public final String REGEX_SPECIAL_CHAR = "[!@#$%^&*()-+]";
    public final String REGEX_NOT_REPEATED = "^(?:([A-Za-z])(?!.*\\1))*$";


    public static boolean validaSenha (String string){
        return true;
    }

}
