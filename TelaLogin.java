package com.wordpress.vamosconversar2018.vamosconversar;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

import Activity.Entidades.Usuarios;
import Activity.MainActivity;
import DAO.ConfiguracaoFirebase;

public class TelaLogin extends AppCompatActivity {

    private EditText edtMatricula;
    private EditText edtSenha;
    private Button btnLogar;
    private FirebaseAuth autenticacao;
    private Usuarios usuarios;
    private Object Intent_abrirTelaPrincipal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.content_tela_login);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        edtMatricula=(EditText) findViewById(R.id.edtMatricula);
        edtSenha=(EditText) findViewById(R.id.edtSenha);
        btnLogar=(Button) findViewById(R.id.btnLogar);

        btnLogar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!edtMatricula.getText().toString().equals("") && !edtSenha.getText().toString().equals("")){
                    usuarios = new Usuarios();
                    usuarios.setSenha(edtMatricula.getText().toString());
                    usuarios.setSenha(edtSenha.getText().toString());

                    validarLogin();


                }else{
                    Toast.makeText(TelaLogin.this,"Preencha os campos de matrícula e senha", Toast.LENGTH_SHORT).show();



                }
            }
        });



    }
    private void validarLogin(){
        autenticacao = ConfiguracaoFirebase.getFirebaseAutenticacao();
        autenticacao.signInWithEmailAndPassword(usuarios.getCpf(),usuarios.getSenha()).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful()){
                    abrirTelaPrincipal();
                    Toast.makeText(TelaLogin.this,"Login efetuado com sucesso!", Toast.LENGTH_SHORT).show();
                }
            }
        });

    }


    public void abrirTelaPrincipal() {
        Intent abrirTelaPrincipal = new Intent(TelaLogin.this, MainActivity.class );
        startActivity(abrirTelaPrincipal);
        finish();


    }

}