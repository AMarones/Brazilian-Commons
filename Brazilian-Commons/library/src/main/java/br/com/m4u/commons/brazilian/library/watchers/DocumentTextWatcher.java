package br.com.m4u.commons.brazilian.library.watchers;

import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;

/**
 * Created by Alexandre on 04/03/15.
 */
public class DocumentTextWatcher implements TextWatcher {

    TypeWatcher typeWatcher;
    private boolean isUpdating = false;
    private EditText editTextDocument;

    public DocumentTextWatcher(EditText _edtValorTotal, TypeWatcher _tipoDocumento) {
        super();
        this.editTextDocument = _edtValorTotal;
        this.typeWatcher = _tipoDocumento;
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
        boolean hasMask = str.indexOf(".") > -1 || str.indexOf("-") > -1 || str.indexOf("/") > -1;
        // Verificamos se existe máscara
        if (hasMask) {
            // Retiramos a máscara.
            str = str.replaceAll("[^0-9]", "");
        }

        try {
            editTextDocument.setText(typeWatcher == TypeWatcher.CPF ? formatCPF(str) : formatCNPJ(str));
            editTextDocument.setSelection(editTextDocument.getText().length());
        } catch (NumberFormatException e) {
            s = "";
        }
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
                                  int after) {
        // Não utilizamos
    }

    @Override
    public void afterTextChanged(Editable s) {
        // Não utilizamos
    }

    public String formatCPF(String str) {
        String[] chars = str.split("");

        str = "";

        for (int i = 0; i < chars.length; i++) {
            if (i == 4 || i == 7)
                str += ".";

            if (i == 10)
                str += "-";

            str += chars[i];
        }

        return str;
    }

    public String formatCNPJ(String str) {
        String[] chars = str.split("");

        str = "";

        for (int i = 0; i < chars.length; i++) {
            if (i == 3 || i == 6)
                str += ".";

            if (i == 9)
                str += "/";

            if (i == 13)
                str += "-";

            str += chars[i];
        }

        return str;
    }
}
