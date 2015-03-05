package br.com.m4u.commons.brazilian.library.validator;

import android.app.Activity;
import android.app.Fragment;

import com.mobsandgeeks.saripaar.Validator;

import br.com.m4u.commons.brazilian.library.validator.saripaar.annotations.Cpf;
import br.com.m4u.commons.brazilian.library.validator.saripaar.annotations.MobilePhone;

/**
 * Created by rodrigo.henriques on 04/03/15.
 */
public class BrazilianValidator {

    Validator validator;

    /**
     * Constructor.
     *
     * @param controller The class containing {@link android.view.View}s to be validated. Usually,
     *                   an {@link android.app.Activity} or a {@link android.app.Fragment}.
     */
    public BrazilianValidator(Activity controller) {
        initValidator(controller);
    }

    public BrazilianValidator(Fragment controller) {
        initValidator(controller);
    }

    private void initValidator(Object controller) {
        validator = new Validator(controller);

        Validator.registerAnnotation(Cpf.class);
        Validator.registerAnnotation(MobilePhone.class);
    }

    public void setValidationListener(Validator.ValidationListener listener) {
        validator.setValidationListener(listener);
    }

    public Validator getValidator() {
        return validator;
    }

    public void validate() {
        validator.validate();
    }
}
