package marioargandona.com.petagram6;

import android.Manifest;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

import marioargandona.com.petagram6.restApi.ConstantesRestApi;
import marioargandona.com.petagram6.restApi.EndpointsApi;
import marioargandona.com.petagram6.restApi.adapter.RestApiAdapter;
import marioargandona.com.petagram6.restApi.model.MascotaResponse;
import marioargandona.com.petagram6.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetalleMascota extends AppCompatActivity {

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
    private static final String KEY_EXTRA_MEDIA_LINK = "mediaLink";
    private static final String KEY_EXTRA_MEDIA_ID = "mediaId";
    private String id_usuario_instagram = "";
    private String id_dispositivo = "";
    private String url_foto = "";
    private String media_link = "";
    private String media_id = "";
    /*private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;*/
    private ImageView imgFotoDetalle;
    private ImageView imgBone;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota_foto);

        Bundle extras       = getIntent().getExtras();
        String url          = extras.getString(KEY_EXTRA_URL);
        url_foto = url;
        int likes           = extras.getInt(KEY_EXTRA_LIKES);
        media_id            = extras.getString(KEY_EXTRA_MEDIA_ID);
        media_link          = extras.getString(KEY_EXTRA_MEDIA_LINK);

        tvLikesDetalle = (TextView)findViewById(R.id.tvLikesDetalle);
        imgBone  = (ImageView)findViewById(R.id.imgBone);

        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView)findViewById(R.id.imgFotoDetalle);
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.fondocard2)
                .into(imgFotoDetalle);

        buscarInformacion();

        imgBone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaLikeInstagram();
            }
        });

        imgFotoDetalle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                lanzaLikeInstagram();
            }
        });
    }


    private void buscarInformacion()
    {
        SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
        id_usuario_instagram = prefe.getString("usuario","");
        id_dispositivo = prefe.getString("idDispositivo" , "");

        if(id_usuario_instagram.equals(""))
        {
            id_usuario_instagram = ConstantesRestApi.usuario;
        }

        if(id_dispositivo.equals(""))
        {
            id_dispositivo = ConstantesRestApi.idDispositivo;
        }

        if(id_usuario_instagram.equals(""))
        {
            Toast.makeText(DetalleMascota.this, "Es necesario registrarse como usuario. Selecciona el menú Recibir Notificaciones en la parte superior derecha para continuar.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(id_dispositivo.equals(""))
        {
            Toast.makeText(DetalleMascota.this, "El token del dispositivo se encuentra vacío. Selecciona el menú Recibir Notificaciones en la parte superior derecha para continuar.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(url_foto.equals(""))
        {
            Toast.makeText(DetalleMascota.this, "Ocurrió un error al registrar la url de la fotografía.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(media_id.equals(""))
        {
            Toast.makeText(DetalleMascota.this, "Ocurrió un error al registrar la url de la fotografía.", Toast.LENGTH_SHORT).show();
            return;
        }

        if(media_link.equals(""))
        {
            Toast.makeText(DetalleMascota.this, "Ocurrió un error al registrar la url de la fotografía.", Toast.LENGTH_SHORT).show();
            return;
        }
    }




    private void lanzaLikeInstagram()
    {
        Log.d("ID_DISPOSITIVO" , id_dispositivo);
        Log.d("ID_USUARIO_INSTAGRAM" , id_usuario_instagram);
        Log.d("URL_FOTOGRAFIA" , media_id);
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.registrarUsuario();
        Call<UsuarioResponse> usuarioResponseCall = endpointsApi.registrarUsuarioFoto(id_dispositivo, id_usuario_instagram , media_id);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();

                pruebaUsuario();
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }


    public void pruebaUsuario()
    {
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApi();

        if(ConstantesRestApi.usuario == null)
        {
            SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
            String verifica = prefe.getString("usuario","");

            if(!verifica.equals(""))
            {
                ConstantesRestApi.usuario = verifica;
            }
        }

        Call<UsuarioResponse> usuarioResponseCall = endpointsApi.getUsuario(ConstantesRestApi.usuario);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();
                //Log.d("ID_FIREBASE" , usuarioResponse1.getId());
                //Log.d("TOKEN_FIREBASE" , usuarioResponse1.getToken());
                //Log.d("ID_FOTO" , usuarioResponse1.getId_foto());

                if(usuarioResponse1.getId_valor() != null)
                {
                    SharedPreferences preferencias= getApplicationContext().getSharedPreferences("datos",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString("idFireBase", usuarioResponse1.getId_valor());
                    editor.commit();

                    ConstantesRestApi.idTokenDestinatario = usuarioResponse1.getId_valor();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No fue posible encontrar el usuario destino. ", Toast.LENGTH_SHORT).show();
                    return;
                }

                if(usuarioResponse1.getId_dispositivo() != null)
                {
                    SharedPreferences preferencias= getApplicationContext().getSharedPreferences("datos",Context.MODE_PRIVATE);
                    SharedPreferences.Editor editor=preferencias.edit();
                    editor.putString("idDispositivoDestinatario", usuarioResponse1.getId_dispositivo());
                    editor.commit();

                    ConstantesRestApi.idDispositivoDestinatario = usuarioResponse1.getId_dispositivo();
                }
                else
                {
                    Toast.makeText(getApplicationContext(), "No fue posible encontrar el usuario destino. ", Toast.LENGTH_SHORT).show();
                    return;
                }

                mandarLike(media_id , ConstantesRestApi.idTokenDestinatario , ConstantesRestApi.idDispositivoDestinatario);
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), t.getMessage(), Toast.LENGTH_LONG).show();
                Log.d("ERROR" , t.getMessage());
            }
        });
    }


    public void mandarLike(String media_id , String tokenDestinatario , final String dispositivoDestinatario) {
        //EJECUTAMOS LA CONEXION AL SERVIDOR
        RestApiAdapter restApiAdapter = new RestApiAdapter();
        Gson gsonMediaRecent = restApiAdapter.construyeGsonDeserializadorMediaRecent();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApiInstagram(gsonMediaRecent);
        String token_access = "3676501702.bcbc17b.d9d6b26457dd41bba4335f1418a30570";
        //Call<UsuarioResponse> usuarioResponseCall = endpointsApi.registrarLikeMedia(media_id);
        Call<UsuarioResponse> usuarioResponseCall = endpointsApi.registrarLikeMedia(token_access , media_id);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse = response.body();
                toque(ConstantesRestApi.idTokenDestinatario , dispositivoDestinatario);
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {
                Toast.makeText(getApplicationContext(), "Falló la conexión con Instagram. Intenta de nuevo.", Toast.LENGTH_LONG).show();
                Log.e("FALLO EN LA CONEXION" , t.toString());
            }
        });
    }




    private void toque(String idTokenDestinatario , String dispositivoDestinatario)
    {
        String idFireBase = ConstantesRestApi.idTokenDestinatario;

        if(idFireBase == null)
        {
            SharedPreferences prefe=getSharedPreferences("datos", Context.MODE_PRIVATE);
            String verifica = prefe.getString("idFireBase","");

            if(!verifica.equals(""))
            {
                ConstantesRestApi.idFireBase = verifica;
                idFireBase = verifica;
            }
        }

        RestApiAdapter restApiAdapter = new RestApiAdapter();
        EndpointsApi endpointsApi = restApiAdapter.establecerConexionRestApi();
        Call<UsuarioResponse> usuarioResponseCall = endpointsApi.toque(idFireBase ,dispositivoDestinatario , id_usuario_instagram , ConstantesRestApi.usuarioPropio);

        usuarioResponseCall.enqueue(new Callback<UsuarioResponse>() {
            @Override
            public void onResponse(Call<UsuarioResponse> call, Response<UsuarioResponse> response) {
                UsuarioResponse usuarioResponse1 = response.body();;
            }

            @Override
            public void onFailure(Call<UsuarioResponse> call, Throwable t) {

            }
        });
    }


}