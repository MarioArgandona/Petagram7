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
 * Created by Robert on 8/20/2016.
 */
public class MascotaDeserializador implements JsonDeserializer<MascotaResponse>{


    @Override
    public MascotaResponse deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Gson gson = new Gson();

        MascotaResponse mascotaResponse = gson.fromJson(json , MascotaResponse.class);
        JsonArray mascotaResponseData = json.getAsJsonObject().getAsJsonArray(JsonKeys.MEDIA_RESPONSE_ARRAY);

        mascotaResponse.setMascotas(deserializarContactoDeJson(mascotaResponseData));

        return mascotaResponse;
    }


    private ArrayList<Mascota> deserializarContactoDeJson(JsonArray mascotaResponseData)
    {
        ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

        for (int i = 0; i < mascotaResponseData.size(); i++)
        {
            JsonObject mascotaResponseDataObject = mascotaResponseData.get(i).getAsJsonObject();

            JsonObject userJson             = mascotaResponseDataObject.getAsJsonObject(JsonKeys.USER);
            String id                       = userJson.get(JsonKeys.USER_ID).getAsString();
            String nombreCompleto           = userJson.get(JsonKeys.FULL_NAME).getAsString();

            JsonObject imageJson            = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_IMAGES);
            JsonObject stdResolutionJson    = imageJson.getAsJsonObject(JsonKeys.MEDIA_STANDARD_RESOLUTION);
            String urlFoto                  = stdResolutionJson.get(JsonKeys.MEDIA_URL).getAsString();

            JsonObject likesJson            = mascotaResponseDataObject.getAsJsonObject(JsonKeys.MEDIA_LIKES);
            Integer likes                   = likesJson.get(JsonKeys.MEDIA_LIKES_COUNT).getAsInt();

            Mascota mascotaActual = new Mascota();
            mascotaActual.setIdInstagram(id);
            mascotaActual.setNombreComleto(nombreCompleto);
            mascotaActual.setUrlFoto(urlFoto);
            mascotaActual.setLikes(likes);

            mascotas.add(mascotaActual);
        }
        return mascotas;
    }
}
