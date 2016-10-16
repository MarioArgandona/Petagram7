package marioargandona.com.petagram6.restApi.model;

/**
 * Created by Robert on 10/14/2016.
 */
public class UsuarioPropioResponse {

    private String username;
    private String full_name;
    private String id;

    public UsuarioPropioResponse()
    {

    }

    public UsuarioPropioResponse(String username , String full_name)
    {
        this.username = username;
        this.full_name = full_name;
    }

    /*public UsuarioResponse(String id , String token , String idUsuario)
    {
        this.id = id;
        this.token = token;
        this.idUsuario = idUsuario;
    }*/

    public UsuarioPropioResponse(String username , String full_name , String id)
    {
        this.id = id;
        this.username = username;
        this.full_name = full_name;
    }

    public UsuarioPropioResponse(String username)
    {
        this.username = username;
    }


    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getFull_Name() {
        return full_name;
    }

    public void setFull_Name(String full_name) {
        this.full_name = full_name;
    }


}
