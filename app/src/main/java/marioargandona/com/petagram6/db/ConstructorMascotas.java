package marioargandona.com.petagram6.db;

import android.content.ContentValues;
import android.content.Context;

import java.util.ArrayList;

import marioargandona.com.petagram6.R;
import marioargandona.com.petagram6.entidades.Mascota;

/**
 * Created by Robert on 8/4/2016.
 */
public class ConstructorMascotas {

    private static final int LIKE = 1;
    private Context contexto;

    public ConstructorMascotas(Context contexto)
    {
        this.contexto = contexto;
    }


    public ArrayList<Mascota> obtenerDatos()
    {
        /*ArrayList<Mascota> mascotas = new ArrayList<Mascota>();
        mascotas = new ArrayList<Mascota>();
        mascotas.add(new Mascota("Spark"    , 5     , R.drawable.mascota1));
        mascotas.add(new Mascota("Coffee"   , 3     , R.drawable.mascota2));
        mascotas.add(new Mascota("Kaiser"   , 8     , R.drawable.mascota3));
        mascotas.add(new Mascota("Shamuu"   , 9     , R.drawable.mascota4));
        mascotas.add(new Mascota("Bingo"    , 2     , R.drawable.mascota5));
        return mascotas;*/

        BaseDatos db = new BaseDatos(contexto);
        if(!verificaExistenciaTabla())
        {
            insertar5Mascotas(db);
        }
        return db.obtenerTodasLasMascotas();
    }


    public ArrayList<Mascota> obtenerMascotasFavoritas()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.listaFavoritos();
    }


    public boolean verificaExistenciaTabla()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.validaExistenciaTabla();
    }

    public boolean verificaExistenciaTablaCuenta()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.validaExistenciaTablaCuenta();
    }

    public void insertar5Mascotas(BaseDatos db)
    {
        ContentValues contentValuesSpark = new ContentValues();
        contentValuesSpark.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE , "Spark");
        contentValuesSpark.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO , R.drawable.mascota1);
        db.insertarMascotas(contentValuesSpark);

        ContentValues contentValuesCoffee = new ContentValues();
        contentValuesCoffee.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE , "Coffee");
        contentValuesCoffee.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO , R.drawable.mascota2);
        db.insertarMascotas(contentValuesCoffee);

        ContentValues contentValuesKaiser = new ContentValues();
        contentValuesKaiser.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE , "Kaiser");
        contentValuesKaiser.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO , R.drawable.mascota3);
        db.insertarMascotas(contentValuesKaiser);

        ContentValues contentValuesShamu = new ContentValues();
        contentValuesShamu.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE , "Shamu");
        contentValuesShamu.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO , R.drawable.mascota4);
        db.insertarMascotas(contentValuesShamu);

        ContentValues contentValuesBingo = new ContentValues();
        contentValuesBingo.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE , "Bingo");
        contentValuesBingo.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO , R.drawable.mascota5);
        db.insertarMascotas(contentValuesBingo);

        ContentValues contentValuesPogo = new ContentValues();
        contentValuesPogo.put(ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE , "Pogo");
        contentValuesPogo.put(ConstantesBaseDatos.TABLA_MASCOTA_FOTO , R.drawable.mascota1);
        db.insertarMascotas(contentValuesPogo);
    }



    public void darlikeMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(contexto);
        ContentValues contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA , mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLA_LIKES_MASCOTA_NUMERO_LIKES , LIKE);
        db.insertarLikeMascota(contentValues);

        //db.actualizaMascotaLikes(mascota.getId());

        ArrayList<Mascota> list = new ArrayList<Mascota>();
        list = db.obtenerTodasLasMascotas();
    }



    public int obtenerLikesMascota(Mascota mascota)
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.obtenerLikesMascota(mascota);
    }


    public void eliminarUsuarioInstagram()
    {
        BaseDatos db = new BaseDatos(contexto);
        db.eliminaUsuarioInstagram();
    }


    public String obtenerUsuarioInstagram()
    {
        BaseDatos db = new BaseDatos(contexto);
        return db.obtenerUsuarioInstagram();
    }


    public void insertarUsuarioInstagram(String nombreUsuario)
    {
        BaseDatos db = new BaseDatos(contexto);
        ContentValues contentValuesUsuario = new ContentValues();
        contentValuesUsuario.put(ConstantesBaseDatos.TABLA_CUENTA_USUARIO , nombreUsuario);
        db.insertarUsuarioInstagram(contentValuesUsuario);
    }

}
