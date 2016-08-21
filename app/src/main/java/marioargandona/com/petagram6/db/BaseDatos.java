package marioargandona.com.petagram6.db;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import marioargandona.com.petagram6.entidades.Mascota;

/**
 * Created by Robert on 8/4/2016.
 */
public class BaseDatos extends SQLiteOpenHelper {

    private Context context;

    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATABASE_NAME, null, ConstantesBaseDatos.DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota= "CREATE TABLE " + ConstantesBaseDatos.TABLA_MASCOTA +
                                        "(" +
                                        ConstantesBaseDatos.TABLA_MASCOTA_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                                        ConstantesBaseDatos.TABLA_MASCOTA_NOMBRE    + " TEXT, " +
                                        ConstantesBaseDatos.TABLA_MASCOTA_LIKES     + " INTEGER, " +
                                        ConstantesBaseDatos.TABLA_MASCOTA_FOTO      + " INTEGER" +
                                        ")";

        String queryCrearTablaLikesMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA +
                "(" +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID                  + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA          + " INTEGER, " +
                ConstantesBaseDatos.TABLA_LIKES_MASCOTA_NUMERO_LIKES        + " INTEGER, " +
                "FOREIGN KEY ("+ ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA+")" +
                "REFERENCES " + ConstantesBaseDatos.TABLA_MASCOTA + "(" + ConstantesBaseDatos.TABLA_MASCOTA_ID + ")" +
                ")";

        String queryCrearTablaUsuario= "CREATE TABLE " + ConstantesBaseDatos.TABLA_CUENTA +
                "(" +
                ConstantesBaseDatos.TABLA_CUENTA_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ConstantesBaseDatos.TABLA_CUENTA_USUARIO    + " TEXT, " +
                ")";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaLikesMascota);
        db.execSQL(queryCrearTablaUsuario);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_CUENTA);
        onCreate(db);
    }


    public boolean validaExistenciaTabla()
    {
        boolean existe = false;
        String query = " SELECT * FROM sqlite_master WHERE TYPE = 'table' AND name = 'mascota'";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor cursor = db.rawQuery(query , null);

        if(cursor.moveToNext())
        {
            String queryTotales = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTA;
            Cursor registrosTabla = db.rawQuery(queryTotales , null);

            if(registrosTabla.moveToNext())
            {
                existe = true;
            }
            else
            {
                existe = false;
            }
        }
        else
        {
            existe = false;
        }
        return existe;
    }



    public boolean validaExistenciaTablaCuenta()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        String queryCrearTablaUsuario= "CREATE TABLE " + ConstantesBaseDatos.TABLA_CUENTA +
                "(" +
                ConstantesBaseDatos.TABLA_CUENTA_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                ConstantesBaseDatos.TABLA_CUENTA_USUARIO    + " TEXT, " +
                ")";
        db.execSQL(queryCrearTablaUsuario);


        boolean existe = false;
        String query = " SELECT * FROM sqlite_master WHERE TYPE = 'table' AND name = 'cuenta'";
        Cursor cursor = db.rawQuery(query , null);

        if(cursor.moveToNext())
        {
            existe = true;
        }
        else
        {
            db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLA_CUENTA);

            String queryCrearTablaUsuario2= "CREATE TABLE " + ConstantesBaseDatos.TABLA_CUENTA +
                    "(" +
                    ConstantesBaseDatos.TABLA_CUENTA_ID        + " INTEGER PRIMARY KEY AUTOINCREMENT , " +
                    ConstantesBaseDatos.TABLA_CUENTA_USUARIO    + " TEXT, " +
                    ")";
            db.execSQL(queryCrearTablaUsuario2);


            String queryVerificar = " SELECT * FROM sqlite_master WHERE TYPE = 'table' AND name = 'cuenta'";
            SQLiteDatabase db2 = this.getWritableDatabase();
            Cursor cursor2 = db.rawQuery(query , null);

            if(cursor2.moveToNext())
            {
                existe = true;
            }
            else
            {
                existe = false;
            }
        }
        return existe;
    }


    public ArrayList<Mascota> obtenerTodasLasMascotas()
    {
        ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTA;
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);

        while(registros.moveToNext())
        {
            /*Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));

            String queryLikes = " SELECT COUNT("+ ConstantesBaseDatos.TABLA_LIKES_MASCOTA_NUMERO_LIKES + ") as likes " +
                                " FROM " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA +
                                " WHERE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosLikes = db.rawQuery(queryLikes , null);

            if(registrosLikes.moveToNext())
            {
                mascotaActual.setLikes(registrosLikes.getInt(0));
            }
            else
            {
                mascotaActual.setLikes(0);
            }


            listaMascotas.add(mascotaActual);*/
        }
        db.close();
        return listaMascotas;
    }


    public void insertarMascotas(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_MASCOTA , null , contentValues);
        db.close();
    }

    public void insertarLikeMascota(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_LIKES_MASCOTA , null , contentValues);
        db.close();
    }



    public void insertarUsuarioInstagram(ContentValues contentValues)
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLA_CUENTA, null , contentValues);
        db.close();
    }


    public void eliminaUsuarioInstagram()
    {
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete(ConstantesBaseDatos.TABLA_CUENTA , "" , null);
        db.close();
    }



    public int obtenerLikesMascota(Mascota mascota)
    {
        int numeroLikes = 0;
        String query =  "SELECT COUNT("+ConstantesBaseDatos.TABLA_LIKES_MASCOTA_NUMERO_LIKES+")" +
                        " FROM " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);

        if(registros.moveToNext())
        {
            numeroLikes = registros.getInt(0);
        }
        db.close();
        return numeroLikes;
    }


    public String obtenerUsuarioInstagram()
    {
        String usuario = "";

        String query =  "SELECT " + ConstantesBaseDatos.TABLA_CUENTA_USUARIO +
                " FROM " + ConstantesBaseDatos.TABLA_CUENTA;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);

        if(registros.moveToNext())
        {
            usuario = registros.getString(0);
        }
        db.close();
        return usuario;
    }


    public void actualizaMascotaLikes(int idMascota)
    {
        String query =  "UPDATE " + ConstantesBaseDatos.TABLA_MASCOTA + " SET " + ConstantesBaseDatos.TABLA_MASCOTA_LIKES +
                        " = (SELECT COUNT(" + ConstantesBaseDatos.TABLA_LIKES_MASCOTA_NUMERO_LIKES + ") FROM " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA +
                        " WHERE " + ConstantesBaseDatos.TABLA_LIKES_MASCOTA_ID_MASCOTA + " = " + idMascota + ") WHERE " +
                        ConstantesBaseDatos.TABLA_MASCOTA_ID + " = " + idMascota;

        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);
        Integer valorPrueba = 0;

        while(registros.moveToNext())
        {
            valorPrueba += 1;
        }

        db.close();
    }


    public ArrayList<Mascota> listaFavoritos()
    {
        ArrayList<Mascota> listaMascotas = new ArrayList<Mascota>();
        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLA_MASCOTA + " ORDER BY " + ConstantesBaseDatos.TABLA_MASCOTA_LIKES + " DESC LIMIT 5";
        SQLiteDatabase db = this.getWritableDatabase();
        Cursor registros = db.rawQuery(query , null);

        while(registros.moveToNext())
        {
            /*Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombreMascota(registros.getString(1));
            mascotaActual.setLikes(registros.getInt(2));
            mascotaActual.setFoto(registros.getInt(3));
            listaMascotas.add(mascotaActual);*/
        }
        db.close();
        return listaMascotas;
    }


}
