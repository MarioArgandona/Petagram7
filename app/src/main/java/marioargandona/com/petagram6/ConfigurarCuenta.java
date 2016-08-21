package marioargandona.com.petagram6;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TextInputEditText;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import marioargandona.com.petagram6.db.ConstructorMascotas;

public class ConfigurarCuenta extends AppCompatActivity {

    private Context context;
    private ConstructorMascotas constructorMascotas;
    private TextInputEditText txtUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configurar_cuenta);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar3);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        inicializarComponentes();
    }



    private void inicializarComponentes()
    {
        txtUsuario = (TextInputEditText)findViewById(R.id.txtNombreUsuario);
        Button btnGuardarCuenta = (Button)findViewById(R.id.btnGuardarCuenta);
        context = getApplicationContext();

        txtUsuario.setText("");

        SharedPreferences prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
        txtUsuario.setText(prefe.getString("usuario",""));
    }


    public void guardarCuenta(View v)
    {
        try
        {
            SharedPreferences preferencias=getSharedPreferences("datos",Context.MODE_PRIVATE);
            SharedPreferences.Editor editor=preferencias.edit();
            editor.putString("usuario", txtUsuario.getText().toString());
            editor.commit();
            finish();
            Toast.makeText(this, "Guardado exitoso.", Toast.LENGTH_SHORT).show();

            SharedPreferences prefe=getSharedPreferences("datos",Context.MODE_PRIVATE);
            String verifica = prefe.getString("usuario","");

            Intent intentRegreso = new Intent(getApplicationContext() , MainActivity.class);
            intentRegreso.putExtra("usuario" , verifica);
            startActivity(intentRegreso);
        }
        catch(Exception exc)
        {
            Toast.makeText(this, "Error al almacenar el usuario.", Toast.LENGTH_SHORT).show();
            return;
        }
    }


    public void eliminarUsuarioBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        constructorMascotas.eliminarUsuarioInstagram();
    }


    public void insertarUsuario(String usuario)
    {
        constructorMascotas = new ConstructorMascotas(context);
        constructorMascotas.insertarUsuarioInstagram(usuario);
    }

}
