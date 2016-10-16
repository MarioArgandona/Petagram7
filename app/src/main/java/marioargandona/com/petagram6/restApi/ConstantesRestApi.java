package marioargandona.com.petagram6.restApi;

/**
 * Created by Robert on 8/19/2016.
 */
public final class ConstantesRestApi {

    //public static final String usuarioBuffer = usuario;
    public static String usuario;
    public static String usuarioPropio;
    public static String idDispositivo;
    public static String idUsuario;
    public static String urlPerfil;
    public static String urlMediaLike;
    public static String mediaLink;
    public static String mediaId;
    public static String idFireBase;
    public static String idTokenDestinatario;
    public static String idDispositivoDestinatario;
    public static final String prueba = "https://api.instagram.com/v1/media/" + mediaId + "/likes";
    public static final String VERSION =                    "/v1/";
    public static final String ROOT_URL =                   "https://api.instagram.com" + VERSION;
    public static final String ACCESS_TOKEN =               "3676501702.bcbc17b.d9d6b26457dd41bba4335f1418a30570";
    public static final String KEY_ACCESS_TOKEN =           "?access_token=";
    public static final String KEY_ACCESS_TOKEN_SEARCH =    "&access_token=";
    public static final String KEY_GET_RECENT_MEDIA_USER =  "users/self/media/recent/";
    public static final String KEY_GET_RECENT_MEDIA =       "/media/recent/?access_token=" + ACCESS_TOKEN;

    //CONSTANTES PARA LIKES
    public static final String KEY_POST_MEDIA =             "media/";
    public static final String KEY_POST_LIKES =             "/likes";
    public static final String URL_POST_MEDIA_LIKES =       KEY_POST_MEDIA + urlMediaLike + KEY_POST_LIKES;
    public static final String ROOT_URL_MEDIA_LIKE =        ROOT_URL + URL_POST_MEDIA_LIKES;
    //CONSTANTES PARA LIKES

    public static final String KEY_USERS =                  "users/";
    public static final String KEY_GET_USER =               "users/search?q=";
    public static final String URL_GET_RECENT_MEDIA_USER =  KEY_GET_RECENT_MEDIA_USER + KEY_ACCESS_TOKEN + ACCESS_TOKEN;
    public static final String URL_GET_USER =               KEY_GET_USER + "mario_argandona" + KEY_ACCESS_TOKEN_SEARCH + ACCESS_TOKEN;
    public static final String ROOT_URL_PETAGRAM =          "https://polar-caverns-82169.herokuapp.com/";
    public static final String KEY_POST_ID_TOKEN =          "token-device/";
    public static final String KEY_TOQUE =                  "toque/{id_firebase}/{id_destinatario}/{id_usuario_instagram}/{id_usuario_propio}";
    public static final String KEY_USUARIO =                "usuario/{id_usuario_destinatario}";
    public static final String KEY_POST_REGISTRO_USUARIO =  "registro-usuario/";
    public static final String KEY_POST_REGISTRO_USUARIO_FOTO =  "registro-usuario-foto/";
    //public static final String KEY_POST_MEDIA_LIKE =        "curl -F 'access_token=" + ACCESS_TOKEN + "' https://api.instagram.com/v1/media/388534915362355839_305100157/likes";
    //public static final String KEY_POST_MEDIA_LIKE =        "https://api.instagram.com/v1/media/{id_media}/likes";
    public static final String KEY_POST_MEDIA_LIKE =        "https://api.instagram.com/v1/media/{id_media}/likes";




}
