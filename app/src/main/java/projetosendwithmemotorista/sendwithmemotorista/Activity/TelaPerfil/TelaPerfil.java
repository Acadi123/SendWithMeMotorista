package projetosendwithmemotorista.sendwithmemotorista.Activity.TelaPerfil;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import projetosendwithmemotorista.sendwithmemotorista.Entidades.Usuarios;
import projetosendwithmemotorista.sendwithmemotorista.R;

public class TelaPerfil extends AppCompatActivity {

    private Button btnExcluirConta;
    private TextView nomePerfil;
    private TextView emailPerfil;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tela_perfil);
        setView();
        setarDadosPerfil();

        btnExcluirConta = (Button) findViewById(R.id.EditarPerfil);
        btnExcluirConta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentAbrirTelaPrincipal = new Intent(TelaPerfil.this, EditarPerfil.class);
                startActivity(intentAbrirTelaPrincipal);
            }
        });
    }

    private void setarDadosPerfil() {
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("Usuarios").child(user.getUid());
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                Usuarios usuarios = dataSnapshot.getValue(Usuarios.class);
                nomePerfil.setText(usuarios.getNome());
                emailPerfil.setText(usuarios.getEmail());
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });
    }

    private void setView() {
        nomePerfil = findViewById(R.id.nomePerfilId);
        emailPerfil = findViewById(R.id.emailPerfilId);
    }
}
