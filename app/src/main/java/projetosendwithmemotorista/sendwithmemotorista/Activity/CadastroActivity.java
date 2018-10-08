package projetosendwithmemotorista.sendwithmemotorista.Activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;

import projetosendwithmemotorista.sendwithmemotorista.R;

public class CadastroActivity extends AppCompatActivity {

    private EditText edtCardEmail;
    private EditText edtCardNome;
    private EditText edtCardSobrenome;
    private EditText edtCardSenha;
    private EditText edtCardDataNascimento;
    private RadioButton rbMasculino;
    private RadioButton rbFeminino;
    private Button btnSalvar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        edtCardEmail = (EditText)findViewById(R.id.edtCardEmail);
        edtCardNome = (EditText)findViewById(R.id.edtCardNome);
        edtCardSobrenome = (EditText)findViewById(R.id.edtCardSobrenome);
        edtCardSenha = (EditText)findViewById(R.id.edtCardSenha);
        edtCardDataNascimento = (EditText)findViewById(R.id.edtCardDataNascimento);
        rbFeminino = (RadioButton) findViewById(R.id.rbFeminino);
        rbMasculino = (RadioButton) findViewById(R.id.rbMasculino);

    }
}
