package marioargandona.com.petagram6.restApi;

import marioargandona.com.petagram6.restApi.model.MascotaResponse;
import marioargandona.com.petagram6.restApi.model.UsuarioPropioResponse;
import marioargandona.com.petagram6.restApi.model.UsuarioResponse;
import retrofit2.Call;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;
import retrofit2.http.Path;
import retrofit2.http.Query;
import retrofit2.http.Url;

/**
 * Created by Robert on 8/19/2016.
 */
public interface EndpointsApi {

    @GET(ConstantesRestApi.URL_GET_RECENT_MEDIA_USER)
    Call<MascotaResponse> getRecentMedia();

    @GET("users/search?access_token=3676501702.bcbc17b.d9d6b26457dd41bba4335f1418a30570")
    Call<MascotaResponse> getUser(@Query("q") String username2);

    @GET("https://api.instagram.com/v1/users/self/?access_token=3676501702.bcbc17b.d9d6b26457dd41bba4335f1418a30570")
    Call<UsuarioPropioResponse> getUserPropio();

    @GET(ConstantesRestApi.KEY_USERS + "{idUsuario}" +  ConstantesRestApi.KEY_GET_RECENT_MEDIA)
    Call<MascotaResponse> getMediaUser(@Path("idUsuario") String idUsuario2);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_ID_TOKEN)
    Call<UsuarioResponse> registrarTokenID(@Field("token")String token);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_MEDIA_LIKE)
    //Call<UsuarioResponse> registrarLikeMedia(@Field("id_media")String idMedia);
    Call<UsuarioResponse> registrarLikeMedia(@Field("access_token")String token_access , @Path("id_media")String id_media);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRO_USUARIO)
    Call<UsuarioResponse> registrarUsuario(@Field("id_dispositivo")String id_dispositivo , @Field("id_usuario_instagram")String id_usuario_instagram , @Field("id")String id);

    @FormUrlEncoded
    @POST(ConstantesRestApi.KEY_POST_REGISTRO_USUARIO_FOTO)
    Call<UsuarioResponse> registrarUsuarioFoto(@Field("id_dispositivo")String id_dispositivo , @Field("id_usuario_instagram")String id_usuario_instagram , @Field("id_foto")String id_foto);

    @GET(ConstantesRestApi.KEY_TOQUE)
    Call<UsuarioResponse> toque(@Path("id_firebase")String id_firebase  , @Path("id_destinatario")String id_destinatario , @Path("id_usuario_instagram")String id_usuario , @Path("id_usuario_propio")String id_usuario_propio);

    @GET(ConstantesRestApi.KEY_USUARIO)
    Call<UsuarioResponse> getUsuario(@Path("id_usuario_destinatario")String id_usuario_destinatario);



}
