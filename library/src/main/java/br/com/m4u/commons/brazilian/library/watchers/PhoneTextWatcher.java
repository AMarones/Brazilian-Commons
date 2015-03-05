package br.com.m4u.commons.brazilian.library.watchers;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Alexandre on 04/03/15.
 */
public class PhoneTextWatcher implements TextWatcher {

    private boolean isUpdating = false;
    private EditText editTextPhone;

    public PhoneTextWatcher(EditText editText) {
        super();
        editTextPhone = editText;
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int after) {
        // Evita que o método seja executado varias vezes.
        // Se tirar ele entre em loop
        if (isUpdating) {
            isUpdating = false;
            return;
        }

        isUpdating = true;
        String str = s.toString();

        // Verifica se já existe a máscara no texto.
        boolean hasMask = str.indexOf("(") > -1 || str.indexOf(")") > -1 || str.indexOf(" ") > -1;
        // Verificamos se existe máscara
        if (hasMask) {
            // Retiramos a máscara.
            str = str.replaceAll("[^0-9]", "");
        }

        editTextPhone.setText(formatPhone(str));
        editTextPhone.setSelection(editTextPhone.getText().length());
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
        // Não utilizamos
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Não utilizamos
    }

    public String formatPhone(String str) {
        String[] chars = str.split("");

        str = "";

        for (int i = 0; i < chars.length; i++) {
            if (i == 1) {
                str += "(";
            }

            if (i == 3) {
                str += ") ";
            }

            str += chars[i];
        }

        return str;
    }
}
