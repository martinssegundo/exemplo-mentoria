package br.com.mentoria.servicos.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class EmailUtil {

    public static boolean verificaEmamilValido(String email){
        Pattern VALID_EMAIL_ADDRESS_REGEX =
                Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
        Matcher matcher = VALID_EMAIL_ADDRESS_REGEX.matcher(email);
        return matcher.find();
    }
}
