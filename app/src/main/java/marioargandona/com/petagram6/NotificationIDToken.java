package marioargandona.com.petagram6;

import android.util.Log;

import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.FirebaseInstanceIdService;

/**
 * Created by Robert on 9/21/2016.
 */
public class NotificationIDToken extends FirebaseInstanceIdService {

    private static final String TAG = "FIREBASE TOKEN";

    @Override
    public void onTokenRefresh() {
        //super.onTokenRefresh();
        Log.d(TAG , "Solicitando token");
        String token = FirebaseInstanceId.getInstance().getToken();
        enviarTokenRegistro(token);
    }


    private void enviarTokenRegistro(String token)
    {
        Log.d(TAG , token);
    }
}
