package marioargandona.com.petagram6;

import android.Manifest;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.net.Uri;
import android.support.v4.app.ActivityCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class DetalleMascota extends AppCompatActivity {

    private static final String KEY_EXTRA_URL = "url";
    private static final String KEY_EXTRA_LIKES = "like";
    /*private TextView tvNombre;
    private TextView tvTelefono;
    private TextView tvEmail;*/
    private ImageView imgFotoDetalle;
    private TextView tvLikesDetalle;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detalle_mascota_foto);

        Bundle extras       = getIntent().getExtras();
        String url          = extras.getString(KEY_EXTRA_URL);
        int likes           = extras.getInt(KEY_EXTRA_LIKES);

        tvLikesDetalle = (TextView)findViewById(R.id.tvLikesDetalle);

        tvLikesDetalle.setText(String.valueOf(likes));

        imgFotoDetalle = (ImageView)findViewById(R.id.imgFotoDetalle);
        Picasso.with(this)
                .load(url)
                .placeholder(R.drawable.fondocard2)
                .into(imgFotoDetalle);

    }
}