package br.com.m4u.commons.brazilian.library.validator.saripaar.rules;

import com.mobsandgeeks.saripaar.AnnotationRule;

import br.com.m4u.commons.brazilian.library.validator.routines.CpfValidator;
import br.com.m4u.commons.brazilian.library.validator.saripaar.annotations.Cpf;

/**
 * Created by rodrigo.henriques on 04/03/15.
 */
public class CpfRule extends AnnotationRule<Cpf, String> {

    protected CpfRule(Cpf cpf) {
        super(cpf);
    }

    @Override
    public boolean isValid(String data) {
        return new CpfValidator().validate(data);
    }

}
