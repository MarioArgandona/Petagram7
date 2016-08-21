package marioargandona.com.petagram6.fragment;

import android.app.Activity;
import android.content.Context;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.graphics.drawable.RoundedBitmapDrawable;
import android.support.v4.graphics.drawable.RoundedBitmapDrawableFactory;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import marioargandona.com.petagram6.R;
import marioargandona.com.petagram6.adapter.MascotaAdapter;
import marioargandona.com.petagram6.adapter.MiMascotaAdapter;
import marioargandona.com.petagram6.entidades.Mascota;
import marioargandona.com.petagram6.presentador.IPrincipalFragmentPresenter;
import marioargandona.com.petagram6.presentador.PrincipalFragmentPresenter;
import marioargandona.com.petagram6.restApi.ConstantesRestApi;


public class PrincipalFragment extends Fragment implements IPrincipalFragment {

    public ArrayList<Mascota> mascotas;
    public RecyclerView listaMascotas;
    public RecyclerView listaMascotas2;
    public ImageView imvMiMascota;
    public MascotaAdapter adapter;
    private ImageView imageView;
    private TextView tvMiMascota;
    private IPrincipalFragmentPresenter presenter;
    private IPrincipalFragmentPresenter presenter2;

    public PrincipalFragment() {
        // Required empty public constructor
    }


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.fragment_principal , container , false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMiMascota);
        imageView = (ImageView)v.findViewById(R.id.imvPrincipal);
        tvMiMascota = (TextView)v.findViewById(R.id.tvNombreMiMascota);

        presenter = new PrincipalFragmentPresenter(this , getContext());


        //extraemos el drawable en un bitmap
        Drawable originalDrawable = getResources().getDrawable(R.drawable.perroprincipal);
        Bitmap originalBitmap = ((BitmapDrawable) originalDrawable).getBitmap();

        //creamos el drawable redondeado
        RoundedBitmapDrawable roundedDrawable =
                RoundedBitmapDrawableFactory.create(getResources(), originalBitmap);

        //asignamos el CornerRadius
        roundedDrawable.setCornerRadius(originalBitmap.getHeight());


        imageView.setImageDrawable(roundedDrawable);

        return v;
    }


    @Override
    public void generarGridLayout() {
        GridLayoutManager gridLayoutManager = new GridLayoutManager(getContext() , 2);
        listaMascotas.setLayoutManager(gridLayoutManager);
    }


    @Override
    public MascotaAdapter crearAdaptadorListas(ArrayList<Mascota> mascotas) {

        Picasso.with(getActivity())
                .load(mascotas.get(0).getUrlFoto())
                .placeholder(R.drawable.fondocard2)
                .into(imageView);

        tvMiMascota.setText(mascotas.get(0).getNombreCompleto());

        adapter = new MascotaAdapter(mascotas,getActivity());
        return adapter;

    }

    @Override
    public void actualizaPerfil()
    {
        Picasso.with(getActivity())
                .load(ConstantesRestApi.urlPerfil)
                .placeholder(R.drawable.fondocard2)
                .into(imageView);
    }


    @Override
    public void crearAdaptador(ArrayList<Mascota> mascotas) {

        Picasso.with(getActivity())
                .load(mascotas.get(0).getUrlFoto())
                .placeholder(R.drawable.perroprincipal)
                .into(imageView);

        tvMiMascota.setText(mascotas.get(0).getNombreCompleto());

        adapter = new MascotaAdapter(mascotas,getActivity());


        //DESDE AQUI, LANZAMOS EL SHARED PREFERENCE DE ID DEL USUARIO PARA BUSCAR LAS FOTOGRAFIAS
        SharedPreferences preferencias=getActivity().getSharedPreferences("datos",Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("id", mascotas.get(0).getIdInstagram());
        editor.putString("urlPerfil" , mascotas.get(0).getUrlFoto());
        editor.commit();

        ConstantesRestApi.idUsuario = mascotas.get(0).getIdInstagram();
        ConstantesRestApi.urlPerfil = mascotas.get(0).getUrlFoto();
        presenter2 = new PrincipalFragmentPresenter(this , getContext() , true);
    }

    @Override
    public void inicializarAdaptadorRV(MascotaAdapter adaptador) {
        listaMascotas.setAdapter(adapter);
    }


    private void iniciaListaMascotas()
    {
        mascotas = new ArrayList<Mascota>();
    }



    private void iniciaAdapterMascotas()
    {
        adapter = new MascotaAdapter(mascotas,getActivity());
        listaMascotas.setAdapter(adapter);
    }
}
