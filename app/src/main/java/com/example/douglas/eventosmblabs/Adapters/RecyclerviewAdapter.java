package com.example.douglas.eventosmblabs.Adapters;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.douglas.eventosmblabs.Activity.EventosDetalhes;
import com.example.douglas.eventosmblabs.Activity.MainActivity;
import com.example.douglas.eventosmblabs.Model.Evento;
import com.example.douglas.eventosmblabs.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class RecyclerviewAdapter extends RecyclerView.Adapter<RecyclerviewAdapter.MyViewHolder> {


    private Context context;
    private List<Evento> eventos;

    public RecyclerviewAdapter(Context context, List<Evento> eventos) {
        this.context = context;
        this.eventos = eventos;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view;
        LayoutInflater layoutInflater =  LayoutInflater.from(context);
        view = layoutInflater.inflate(R.layout.cardview_itemeventos, parent, false);

        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, final int position) {

        holder.nome_evento.setText(eventos.get(position).getNome());
        Uri uri = Uri.parse(eventos.get(position).getCaminhofoto());
        Context context_imagem = holder.imagem_evento.getContext();
        Picasso.with(context_imagem).load(uri).into(holder.imagem_evento);

        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String cifrao = "R$ ";
                String valor_real;
                //passando valores para os detalhes, iniciando intent através do contexto da página.
                Intent detalhes = new Intent(context, EventosDetalhes.class);
                detalhes.putExtra("nome",eventos.get(position).getNome());
                detalhes.putExtra("URI",eventos.get(position).getCaminhofoto());
                detalhes.putExtra("local", eventos.get(position).getLocal());
                detalhes.putExtra("data",eventos.get(position).getData());
                detalhes.putExtra("descricao",eventos.get(position).getDescricao());

                valor_real = Double.toString(eventos.get(position).getPreco());

                if(valor_real.length() < 2){

                    valor_real.concat(",00");
                }
                detalhes.putExtra("valor",cifrao.concat(Double.toString(eventos.get(position).getPreco())));

                context.startActivity(detalhes);
            }
        });

    }

    @Override
    public int getItemCount() {

        return eventos.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder{

        CardView cardView;
        TextView nome_evento ;
        ImageView imagem_evento;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            cardView = itemView.findViewById(R.id.cardview_id);
            nome_evento = itemView.findViewById(R.id.nome_evento);
            imagem_evento = itemView.findViewById(R.id.imagem_evento);
        }
    }
}
