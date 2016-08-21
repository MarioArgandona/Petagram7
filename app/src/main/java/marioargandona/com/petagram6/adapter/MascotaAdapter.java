package marioargandona.com.petagram6.adapter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import marioargandona.com.petagram6.DetalleMascota;
import marioargandona.com.petagram6.MascotaFavorita;
import marioargandona.com.petagram6.R;
import marioargandona.com.petagram6.db.ConstructorMascotas;
import marioargandona.com.petagram6.entidades.Mascota;

/**
 * Created by Robert on 7/23/2016.
 */
public class MascotaAdapter extends RecyclerView.Adapter<MascotaAdapter.MascotaViewHolder>{

    private ArrayList<Mascota> mascotas;
    Activity activity;

    public MascotaAdapter(ArrayList<Mascota> mascotas , Activity activity)
    {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View inflater = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_grid_mascota , parent , false);
        return new MascotaViewHolder(inflater);
    }

    @Override
    public void onBindViewHolder(final MascotaViewHolder holder, int position) {
        final Mascota mascota = mascotas.get(position);
        //holder.imgFoto.setImageResource(mascota.getFoto());
        //holder.tvNombreMascota.setText(mascota.getNombreMascota());

        Picasso.with(activity)
                .load(mascota.getUrlFoto())
                .placeholder(R.drawable.fondocard2)
                .into(holder.imgFoto);

        holder.tvLikes.setText(mascota.getLikes().toString());
        //holder.tvLikes.setText(0 + "");

        /*holder.btnLikes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(activity, "Un huesito a: " + mascota.getNombreMascota() + "  !!!", Toast.LENGTH_SHORT).show();
                //String valor = holder.tvLikes.getText().toString();
                //Integer valorConvertido = Integer.valueOf(valor) + 1;
                //valor = String.valueOf(valorConvertido);
                //holder.tvLikes.setText(valor);

                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darlikeMascota(mascota);

                Integer valor = constructorMascotas.obtenerLikesMascota(mascota);
                String valorConvertido = String.valueOf(valor);

                holder.tvLikes.setText(valorConvertido);
            }
        });*/

        holder.imgFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //Toast.makeText(activity, mascota.getNombreMascota() + "  !!!", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(activity , DetalleMascota.class);
                intent.putExtra("url" , mascota.getUrlFoto());
                intent.putExtra("like" , mascota.getLikes());
                activity.startActivity(intent);

            }
        });

    }

    @Override
    public int getItemCount() {
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder
    {
        private ImageView imgFoto;
        private TextView tvLikes;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFoto = (ImageView) itemView.findViewById(R.id.imgFoto);
            tvLikes = (TextView) itemView.findViewById(R.id.tvLikesMascota);
        }
    }


}
