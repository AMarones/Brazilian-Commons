package br.com.m4u.brazilian.commons;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.EditText;
import android.widget.TextView;

import com.mobsandgeeks.saripaar.ValidationError;
import com.mobsandgeeks.saripaar.Validator;

import java.util.List;

import br.com.m4u.commons.brazilian.library.components.editext.BrazilianEditText;
import br.com.m4u.commons.brazilian.library.validator.BrazilianValidator;
import br.com.m4u.commons.brazilian.library.validator.saripaar.annotations.Cpf;
import br.com.m4u.commons.brazilian.library.validator.saripaar.annotations.MobilePhone;
import butterknife.ButterKnife;
import butterknife.InjectView;
import butterknife.OnClick;


public class SampleActivity extends ActionBarActivity implements Validator.ValidationListener {

    @InjectView(R.id.edittext_cpf)
    @Cpf
    BrazilianEditText editTextCpf;

    @InjectView(R.id.edittext_mobile_phone)
    @MobilePhone
    BrazilianEditText editTextMobilePhone;

    @InjectView(R.id.textview_message)
    TextView textViewMessage;

    BrazilianValidator validator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sample);

        validator = new BrazilianValidator(this);
        validator.setValidationListener(this);

        ButterKnife.inject(this);
    }

    @OnClick(R.id.button_validate)
    public void validate() {
        validator.validate();
    }

    @Override
    public void onValidationSucceeded() {

        textViewMessage.setText("SUCESSO");
    }

    public void onValidationFailed(List<ValidationError> errors) {

        for (ValidationError error : errors) {

            if (error.getView() instanceof EditText) {
                EditText edit = (EditText) error.getView();

                edit.setError(error.getCollatedErrorMessage(this));
            }

        }

        textViewMessage.setText("...");
    }
}
