package marioargandona.com.petagram6.restApi;

import marioargandona.com.petagram6.restApi.model.MascotaResponse;
import retrofit2.Call;
import retrofit2.http.GET;
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

    @GET(ConstantesRestApi.KEY_USERS + "{idUsuario}" +  ConstantesRestApi.KEY_GET_RECENT_MEDIA)
    Call<MascotaResponse> getMediaUser(@Path("idUsuario") String idUsuario2);

}
