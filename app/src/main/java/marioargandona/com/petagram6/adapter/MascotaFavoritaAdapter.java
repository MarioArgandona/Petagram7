package marioargandona.com.petagram6.adapter;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

import marioargandona.com.petagram6.R;
import marioargandona.com.petagram6.entidades.Mascota;

/**
 * Created by Robert on 7/23/2016.
 */
public class MascotaFavoritaAdapter extends RecyclerView.Adapter<MascotaFavoritaAdapter.MascotaFavoritaViewHolder>{

    private ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaFavoritaAdapter(ArrayList<Mascota> mascotas , Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaFavoritaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota_favorita , parent , false);
        return new MascotaFavoritaViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final MascotaFavoritaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        //holder.imgFotoDummy.setImageResource(mascota.getFoto());
        //holder.tvNombreMascotaDummy.setText(mascota.getNombreMascota());
        holder.tvLikesDummy.setText(mascota.getLikes().toString());
        //holder.tvLikesDummy.setText(0 + "");


    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaFavoritaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFotoDummy;
        private TextView tvNombreMascotaDummy;
        private TextView tvLikesDummy;
        private ImageButton btnLikesDummy;
        private ImageButton btnFavoritosDummy;


        public MascotaFavoritaViewHolder(View itemView) {
            super(itemView);
            imgFotoDummy = (ImageView) itemView.findViewById(R.id.imgFotoDummy);
            tvNombreMascotaDummy = (TextView) itemView.findViewById(R.id.tvNombreMascotaDummy);
            tvLikesDummy = (TextView) itemView.findViewById(R.id.tvLikesMascotaDummy);
            btnLikesDummy = (ImageButton)itemView.findViewById(R.id.btnLikesDummy);
            btnFavoritosDummy = (ImageButton)itemView.findViewById(R.id.btnFavoritos);
        }
    }


}
