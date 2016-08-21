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
 * Created by Robert on 7/30/2016.
 */
public class MiMascotaAdapter extends RecyclerView.Adapter<MiMascotaAdapter.MiMascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    Activity activity;

    public MiMascotaAdapter(ArrayList<Mascota> mascotas , Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MiMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mi_mascota , parent , false);
        return new MiMascotaViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final MiMascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        //holder.imgFotoDummy.setImageResource(mascota.getFoto());


        if(mascota.getLikes() != null)
        {
            holder.tvLikesDummy.setText(mascota.getLikes() + "");
        }
        else
        {
            holder.tvLikesDummy.setText(0 + "");
        }
    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MiMascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFotoDummy;
        private TextView tvLikesDummy;
        private ImageButton btnLikesDummy;


        public MiMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoDummy = (ImageView) itemView.findViewById(R.id.imgFotoMiMascota);
            tvLikesDummy = (TextView) itemView.findViewById(R.id.tvLikesMiMascota);
            btnLikesDummy = (ImageButton)itemView.findViewById(R.id.btnLikesMiMascota);
        }
    }

}
