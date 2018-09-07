package com.example.douglas.eventosmblabs.Activity;

import android.content.Context;
import android.content.Intent;
import com.example.douglas.eventosmblabs.R;
import com.squareup.picasso.Picasso;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.support.v7.widget.Toolbar;
import android.widget.ImageView;
import android.widget.TextView;

public class EventosDetalhes extends AppCompatActivity {

    private TextView nome_campo, local_campo, data_campo, descricao_campo, valor_campo;
    private Toolbar toolbar;
    private ImageView imagem_evento;
    private CardView card_detalhes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eventos_detalhes);

        toolbar = findViewById(R.id.tb_detalhe);
        imagem_evento = findViewById(R.id.imagem_detalhe);
        nome_campo = findViewById(R.id.nome_detalhe);
        local_campo = findViewById(R.id.local);
        data_campo = findViewById(R.id.data);
        descricao_campo = findViewById(R.id.descricao);
        valor_campo = findViewById(R.id.preco);


        toolbar.setTitle("Detalhes");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        Intent i = getIntent();
        String nome = i.getExtras().getString("nome");
        String data = i.getExtras().getString("data");
        String descricao = i.getExtras().getString("descricao");
        String local = i.getExtras().getString("local");
        String valor = i.getExtras().getString("valor");
        String Uri = i.getExtras().getString("URI");

        Picasso.with(this).load(Uri).into(imagem_evento);

        nome_campo.setText(nome);
        local_campo.setText(local);
        descricao_campo.setText(descricao);
        data_campo.setText(data);
        valor_campo.setText(valor);
    }
}
