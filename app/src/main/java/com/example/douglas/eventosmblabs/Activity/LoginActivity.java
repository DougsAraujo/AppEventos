package com.example.douglas.eventosmblabs.Activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.douglas.eventosmblabs.R;

public class LoginActivity extends AppCompatActivity {

    private Button btn_cadastro;
    private Button btn_logar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btn_cadastro = findViewById(R.id.bt_cadastro);
        btn_logar = findViewById(R.id.bt_login);

        btn_cadastro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent cadastro = new Intent(LoginActivity.this, CadastroActivity.class);
                startActivity(cadastro);
            }
        });

        btn_logar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent main_eventos = new Intent(LoginActivity.this, MainActivity.class);
                startActivity(main_eventos);
            }
        });
    }
}
