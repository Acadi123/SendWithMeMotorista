package projetosendwithmemotorista.sendwithmemotorista.Activity.TelaPerfil;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import projetosendwithmemotorista.sendwithmemotorista.R;

public class TelaPerfil extends AppCompatActivity {

    private Button btnExcluirConta;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);

        btnExcluirConta = (Button) findViewById(R.id.EditarPerfil);
        btnExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrirTelaPrincipal = new Intent(TelaPerfil.this, EditarPerfil.class);
                startActivity(intentAbrirTelaPrincipal);
            }
        });
    }
}
