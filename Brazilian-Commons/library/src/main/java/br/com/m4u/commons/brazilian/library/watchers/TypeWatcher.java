package br.com.m4u.commons.brazilian.library.watchers;

/**
 * Created by Alexandre on 04/03/15.
 */
public enum TypeWatcher {

    CPF, CNPJ;

    @Override
    public String toString() {
        return name();
    }
}
