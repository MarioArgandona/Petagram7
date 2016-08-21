package marioargandona.com.petagram6.restApi.deserializador;

import com.google.gson.Gson;
import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import java.lang.reflect.Type;
import java.util.ArrayList;

import marioargandona.com.petagram6.entidades.Mascota;
import marioargandona.com.petagram6.restApi.JsonKeys;
import marioargandona.com.petagram6.restApi.model.MascotaResponse;

/**
 * Created by Robert on 8/21/2016.
 */
public class MascotaDeserializadorUser implements JsonDeserializer<MascotaResponse> {

    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        MascotaResponse mascotaResponse = gson.fromJson(json , MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarUsuarioDeJson(mascotaResponseData));

        return mascotaResponse;
    }


    private ArrayList<Mascota> deserializarUsuarioDeJson(JsonArray jsonArray)
    {
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        JsonObject userJson = jsonArray.get(0).getAsJsonObject();

        String id                       = userJson.get(JsonKeys.USER_ID).getAsString();
        String nombreCompleto           = userJson.get(JsonKeys.FULL_NAME).getAsString();
        String urlFoto                  = userJson.get(JsonKeys.MEDIA_PROFILE_PICTURE).getAsString();

        Mascota mascotaActual = new Mascota();
        mascotaActual.setIdInstagram(id);
        mascotaActual.setNombreComleto(nombreCompleto);
        mascotaActual.setUrlFoto(urlFoto);
        mascotaActual.setLikes(0);

        mascotas.add(mascotaActual);

        return mascotas;
    }

}
