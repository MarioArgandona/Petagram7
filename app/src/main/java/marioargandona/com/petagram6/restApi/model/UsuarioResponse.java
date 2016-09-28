package marioargandona.com.petagram6.restApi.model;

/**
 * Created by Robert on 9/27/2016.
 */
public class UsuarioResponse {

    private String id;
    private String token;
    private String idUsuario;
    private String id_dispositivo;
    private String id_usuario_instagram;

    public UsuarioResponse(String id , String token)
    {
        this.id = id;
        this.token = token;
    }

    /*public UsuarioResponse(String id , String token , String idUsuario)
    {
        this.id = id;
        this.token = token;
        this.idUsuario = idUsuario;
    }*/

    public UsuarioResponse(String id , String id_dispositivo , String id_usuario_instagram)
    {
        this.id = id;
        this.id_dispositivo = id_dispositivo;
        this.id_usuario_instagram = id_usuario_instagram;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public String getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(String idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getId_dispositivo() {
        return id_dispositivo;
    }

    public void setId_dispositivo(String id_dispositivo) {
        this.id_dispositivo = id_dispositivo;
    }

    public String getId_usuario_instagram() {
        return id_usuario_instagram;
    }

    public void setId_usuario_instagram(String id_usuario_instagram) {
        this.id_usuario_instagram = id_usuario_instagram;
    }
}
