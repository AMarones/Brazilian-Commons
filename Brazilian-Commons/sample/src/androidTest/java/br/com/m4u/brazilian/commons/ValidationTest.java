package br.com.m4u.brazilian.commons;

import junit.framework.TestCase;

import br.com.m4u.commons.brazilian.library.validator.routines.CpfValidator;

/**
 * Created by rodrigo.henriques on 03/03/15.
 */
public class ValidationTest extends TestCase {

    CpfValidator cpfValidator;

    @Override
    protected void setUp() throws Exception {
        super.setUp();

        cpfValidator = new CpfValidator();
    }

    public void testCpfValidatorWithValidCpf() {

        String cpf = "14164471727";

        boolean isValid = cpfValidator.validate(cpf);

        assertTrue(isValid);
    }

    public void testCpfValidatorWithInvalidCpf() {

        String cpf = "1234";

        boolean isValid = cpfValidator.validate(cpf);

        assertTrue(!isValid);
    }

    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }
}
