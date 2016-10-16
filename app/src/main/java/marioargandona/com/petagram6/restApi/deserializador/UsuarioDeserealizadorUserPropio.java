package marioargandona.com.petagram6.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;

import marioargandona.com.petagram6.entidades.Mascota;
import marioargandona.com.petagram6.restApi.JsonKeys;
import marioargandona.com.petagram6.restApi.model.MascotaResponse;
import marioargandona.com.petagram6.restApi.model.UsuarioPropioResponse;
import marioargandona.com.petagram6.restApi.model.UsuarioResponse;

/**
 * Created by Robert on 10/14/2016.
 */
public class UsuarioDeserealizadorUserPropio implements JsonDeserializer<UsuarioPropioResponse> {
    @Override
    public UsuarioPropioResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();
        JsonObject usuarioResponseData = json.getAsJsonObject().getAsJsonObject(JsonKeys.MEDIA_RESPONSE_ARRAY);

        String username                       = usuarioResponseData.get(JsonKeys.USERNAME).getAsString();
        String nombreCompleto           = usuarioResponseData.get(JsonKeys.FULL_NAME).getAsString();
        String id                  = usuarioResponseData.get(JsonKeys.USER_ID).getAsString();

        UsuarioPropioResponse usuarioPropioResponse = new UsuarioPropioResponse();
        usuarioPropioResponse.setFull_Name(nombreCompleto);
        usuarioPropioResponse.setId(id);
        usuarioPropioResponse.setUsername(username);

        return usuarioPropioResponse;
    }
}
