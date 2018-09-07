package com.example.douglas.eventosmblabs.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.douglas.eventosmblabs.R;
import com.example.douglas.eventosmblabs.Retrofit.Metodos;
import com.example.douglas.eventosmblabs.Retrofit.RetrofitInitiator;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class CadastroActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private TextInputEditText nome, sobrenome, email, senha, data, celular;
    private Button cadastrar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro);

        nome = findViewById(R.id.nome);
        sobrenome = findViewById(R.id.sobrenome);
        email = findViewById(R.id.email);
        senha = findViewById(R.id.senha);
        data = findViewById(R.id.datanasc);
        celular = findViewById(R.id.celular);
        cadastrar = findViewById(R.id.confirmar);

        toolbar = findViewById(R.id.tb_cadastro);
        toolbar.setTitle("Cadastro");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        cadastrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                enviandoForm(nome.getText().toString(),
                        sobrenome.getText().toString(),
                        email.getText().toString(),
                        senha.getText().toString(),
                        data.getText().toString(),
                        celular.getText().toString());
            }
        });


    }

    private void enviandoForm(String nome, String sobrenome, String email, String senha, String data, String celular){

        Retrofit retrofit = new RetrofitInitiator().RetrofitInitiator();

        Metodos metodos = retrofit.create(Metodos.class);

       Call<ResponseBody> call = metodos.cadastroUsuarios(nome,sobrenome,data,email,celular,senha);

       call.enqueue(new Callback<ResponseBody>() {
           @Override
           public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
               //Toast.makeText(CadastroActivity.this, "Cadastrado", Toast.LENGTH_LONG).show();

               Toast toast = Toast.makeText(CadastroActivity.this, "Cadastrado", Toast.LENGTH_LONG);
               toast.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL, 0, 0);
               toast.show();

               Intent i = new Intent(CadastroActivity.this, LoginActivity.class);
               startActivity(i);
           }

           @Override
           public void onFailure(Call<ResponseBody> call, Throwable t) {

               Toast.makeText(CadastroActivity.this, "ERROR", Toast.LENGTH_LONG).show();
           }
       });


    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                startActivity(new Intent(this, LoginActivity.class));
                finishAffinity();
                break;
            default:break;
        }
        return true;
    }

}
