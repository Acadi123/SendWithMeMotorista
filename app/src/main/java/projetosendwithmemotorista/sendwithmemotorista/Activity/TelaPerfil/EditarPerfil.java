package projetosendwithmemotorista.sendwithmemotorista.Activity.TelaPerfil;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import projetosendwithmemotorista.sendwithmemotorista.Entidades.Usuarios;
import projetosendwithmemotorista.sendwithmemotorista.Helper.PreferenciasAndroid;
import projetosendwithmemotorista.sendwithmemotorista.R;

public class EditarPerfil extends AppCompatActivity {

    private Button btnExcluirConta;
    private Context cont;
    private Usuarios usuarios;
    private TextView nome;
    private DatabaseReference databaseReference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        btnExcluirConta = (Button) findViewById(R.id.buttonExcluirConta);

        btnExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PreferenciasAndroid preferenciasAndroid = new PreferenciasAndroid(EditarPerfil.this);
                databaseReference = FirebaseDatabase.getInstance().getReference( "usuario").child(preferenciasAndroid.getIdentificador());
                databaseReference.removeValue();
                Toast.makeText(EditarPerfil.this, "Excluido", Toast.LENGTH_LONG).show();
                finish();


            }


        });
    }
}
