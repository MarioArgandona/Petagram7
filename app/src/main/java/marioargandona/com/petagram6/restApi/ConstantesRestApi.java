package marioargandona.com.petagram6.restApi;

/**
 * Created by Robert on 8/19/2016.
 */
public final class ConstantesRestApi {

    //public static final String usuarioBuffer = usuario;
    public static String usuario;
    public static String idUsuario;
    public static String urlPerfil;
    public static final String VERSION =                    "/v1/";
    public static final String ROOT_URL =                   "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN =               "3676501702.bcbc17b.d9d6b26457dd41bba4335f1418a30570";
    public static final String KEY_ACCESS_TOKEN =           "?access_token=";
    public static final String KEY_ACCESS_TOKEN_SEARCH =    "&access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER =  "users/self/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA =       "/media/recent/?access_token=" + ACCESS_TOKEN;
    public static final String KEY_USERS =                  "users/";
    public static final String KEY_GET_USER =               "users/search?q=";
    public static final String URL_GET_RECENT_MEDIA_USER =  KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_USER =               KEY_GET_USER + "mario_argandona" + KEY_ACCESS_TOKEN_SEARCH + ACCESS_TOKEN;

}
