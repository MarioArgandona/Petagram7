package marioargandona.com.petagram6.restApi.adapter;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import marioargandona.com.petagram6.restApi.ConstantesRestApi;
import marioargandona.com.petagram6.restApi.EndpointsApi;
import marioargandona.com.petagram6.restApi.deserializador.MascotaDeserializador;
import marioargandona.com.petagram6.restApi.deserializador.MascotaDeserializadorUser;
import marioargandona.com.petagram6.restApi.model.MascotaResponse;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Robert on 8/20/2016.
 */
public class RestApiAdapter {

    public EndpointsApi establecerConexionRestApiInstagram(Gson gson)
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL)
                .addConverterFactory(GsonConverterFactory.create(gson))
                .build();

        return retrofit.create(EndpointsApi.class);
    }

    public EndpointsApi establecerConexionRestApi()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_PETAGRAM)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }



    public EndpointsApi registrarUsuario()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(ConstantesRestApi.ROOT_URL_PETAGRAM)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        return retrofit.create(EndpointsApi.class);
    }




    public Gson construyeGsonDeserializadorMediaRecent()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class , new MascotaDeserializador());
        return gsonBuilder.create();
    }

    public Gson construyeGsonDeserializadorUser()
    {
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(MascotaResponse.class , new MascotaDeserializadorUser());
        return gsonBuilder.create();
    }

}
