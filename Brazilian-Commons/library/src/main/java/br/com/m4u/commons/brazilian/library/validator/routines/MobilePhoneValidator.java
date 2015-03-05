package br.com.m4u.commons.brazilian.library.validator.routines;

import java.util.regex.Pattern;

/**
 * Created by rodrigo.henriques on 04/03/15.
 */
public class MobilePhoneValidator {

    final String REG_EXP_MOBILE_PHONE = "\\(?((10)|([1-9][1-9]))\\)?\\s?9?[1-9]\\d{3}\\-?\\d{4}";

    Pattern pattern;

    public MobilePhoneValidator() {
        pattern = Pattern.compile(REG_EXP_MOBILE_PHONE);
    }

    public boolean validate(String value) {

        value = value.replaceAll("\\D+","");

        return pattern.matcher(value).matches();
    }
}
