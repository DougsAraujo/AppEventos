package com.example.douglas.eventosmblabs.Activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.example.douglas.eventosmblabs.Adapters.RecyclerviewAdapter;
import com.example.douglas.eventosmblabs.Model.Evento;
import com.example.douglas.eventosmblabs.R;
import com.example.douglas.eventosmblabs.Retrofit.Metodos;
import com.example.douglas.eventosmblabs.Retrofit.RetrofitInitiator;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;


public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private Toolbar bottomTolbar;
    private List<Evento> eventos;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        toolbar = findViewById(R.id.tb_main);
        toolbar.setTitle("Eventos");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        //eventos_final = new ArrayList<>();
        /*eventos.add(new Evento(1, "Vacas e Bois", "DAG", "23/07/2018", "1 hora", 34.50, "Coffe break"));
        eventos.add(new Evento(1, "TI na vida", "DCC", "26/002/2018", "1 hora", 100, "Coffe break"));*/

        Retrofit retrofit = new RetrofitInitiator().RetrofitInitiator();

        Metodos metodos = retrofit.create(Metodos.class);

        Call<List<Evento>> call = metodos.BuscaEventos();



        call.enqueue(new Callback<List<Evento>>(){

            @Override
            public void onResponse(Call<List<Evento>> call, Response<List<Evento>> response) {


                List<Evento> evento_f = response.body();

                eventos = new ArrayList<>();

                for(int i = 0; i < evento_f.size(); i++){
                    eventos.add(new Evento(evento_f.get(i).getId_evento(),
                                            evento_f.get(i).getNome(),
                                            evento_f.get(i).getLocal(),
                                            evento_f.get(i).getData(),
                                            evento_f.get(i).getDuracao(),
                                            evento_f.get(i).getPreco(),
                                            evento_f.get(i).getDescricao(),
                                            evento_f.get(i).getCaminhofoto()));
                }

                Carregar();

            }

            @Override
            public void onFailure(Call<List<Evento>> call, Throwable t) {
                Toast.makeText(MainActivity.this, "ERROR", Toast.LENGTH_LONG).show();

            }

        });


    }

    public void Carregar(){
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerviewAdapter recyclerviewAdapter = new RecyclerviewAdapter(this, eventos);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(recyclerviewAdapter);
    }
}
