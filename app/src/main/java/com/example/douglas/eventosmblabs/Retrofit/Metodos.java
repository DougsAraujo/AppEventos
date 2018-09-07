package com.example.douglas.eventosmblabs.Retrofit;

import com.example.douglas.eventosmblabs.Model.Evento;
import com.example.douglas.eventosmblabs.Model.Usuario;

import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;

public interface Metodos {

    @POST("usuarios/cadastroUsuarios")
    @FormUrlEncoded
    Call<ResponseBody> cadastroUsuarios(
            @Field("nome") String nome,
            @Field("sobrenome") String sobrenome,
            @Field("datanasc") String datanasc,
            @Field("email") String email,
            @Field("celular") String celular,
            @Field("senha") String senha);

    @POST("eventos/cadastroEventos")
    @FormUrlEncoded
    Call<ResponseBody> cadastroEventos(
            @Field("nome") String nome,
            @Field("local") String local,
            @Field("data") String data,
            @Field("duracao") String duracao,
            @Field("preco") Double preco,
            @Field("descricao") String descricao,
            @Field("imagem") String imagem);

    @POST("inscricao/UsuarioEvento")
    @FormUrlEncoded
    Call<ResponseBody> cadastroUsarioEvento(
            @Field("nome") int id_usuario,
            @Field("local") int id_evento);

    @GET("/eventos")
    Call<List<Evento>> BuscaEventos();

    @GET("eventos/{id}")
    Call<Evento> BuscaEventoID(@Path("id_evento") int id);

    @GET("usuarios/{email}")
    Call<Usuario> BuscaUsuario(@Path("email") String email);

    @GET("inscricao/{id}")
    Call<Evento> EventosUsuario(@Path("id_evento") int id);

}
