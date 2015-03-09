package br.com.m4u.commons.brazilian.library.components.editext;

import android.content.Context;
import android.util.AttributeSet;

import br.com.m4u.commons.brazilian.library.Constants;
import br.com.m4u.commons.brazilian.library.watchers.DocumentTextWatcher;
import br.com.m4u.commons.brazilian.library.watchers.PhoneTextWatcher;
import br.com.m4u.commons.brazilian.library.watchers.TypeWatcher;

/**
 * Created by Alexandre on 05/03/15.
 */
public class BrazilianEditText extends android.widget.EditText {

    /**
     * XML Attribute
     */
    private static final String EDITTEXT_ATTRIBUTE_TEXT_WATCHER = "textWatcher";

    public BrazilianEditText(Context context) {
        super(context);
    }

    public BrazilianEditText(Context context, AttributeSet attrs) {
        super(context, attrs);

        setTextWatcher(context, attrs);
    }

    public BrazilianEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);

        setTextWatcher(context, attrs);
    }

    /**
     * XML methods
     *
     * @param ctx
     * @param attrs
     */
    private void setTextWatcher(Context ctx, AttributeSet attrs) {
        String stringTextWatcher = attrs.getAttributeValue(Constants.URL_SCHEMA,
                EDITTEXT_ATTRIBUTE_TEXT_WATCHER);

        if (stringTextWatcher.equalsIgnoreCase("cpf")) {
            addTextChangedListener(new DocumentTextWatcher(this, TypeWatcher.CPF));
        }

        if (stringTextWatcher.equalsIgnoreCase("phone")) {
            addTextChangedListener(new PhoneTextWatcher(this));
        }
    }

    public String getTextValueNumber() {
        String stringWithoutMask = this.getText().toString();
        stringWithoutMask = stringWithoutMask.replaceAll("[^0-9]", "");
        return stringWithoutMask;
    }
}
