package br.com.m4u.commons.brazilian.library.validator.saripaar.rules;

import com.mobsandgeeks.saripaar.AnnotationRule;

import br.com.m4u.commons.brazilian.library.validator.routines.MobilePhoneValidator;
import br.com.m4u.commons.brazilian.library.validator.saripaar.annotations.MobilePhone;

/**
 * Created by rodrigo.henriques on 04/03/15.
 */
public class MobilePhoneRule extends AnnotationRule<MobilePhone, String> {

    protected MobilePhoneRule(MobilePhone cpf) {
        super(cpf);
    }

    @Override
    public boolean isValid(String data) {
        return new MobilePhoneValidator().validate(data);
    }

}
