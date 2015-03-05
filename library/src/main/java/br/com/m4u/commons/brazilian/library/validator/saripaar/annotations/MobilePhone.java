package br.com.m4u.commons.brazilian.library.validator.saripaar.annotations;

import com.mobsandgeeks.saripaar.annotation.ValidateUsing;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import br.com.m4u.commons.brazilian.library.validator.saripaar.rules.MobilePhoneRule;

/**
 * Created by rodrigo.henriques on 04/03/15.
 */
@ValidateUsing(MobilePhoneRule.class)
@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface MobilePhone {
    public int sequence() default -1;

    public int messageResId() default -1;

    public String message() default "Telefone inválido!";
}
