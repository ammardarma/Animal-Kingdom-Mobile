package com.ammar.animalkingdom;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CenterInside;
import com.bumptech.glide.load.resource.bitmap.GranularRoundedCorners;
import com.bumptech.glide.request.RequestOptions;

import java.util.List;
import java.util.Random;
import maes.tech.intentanim.CustomIntent;

public class ImageAdapter extends RecyclerView.Adapter<ImageAdapter.ViewHolder> {
private Context context;
private List<ModelHewan> items;

private OnContactClickListener listener;

public interface OnContactClickListener {
    public void onClick(View view, int position);
}

public void setListener(OnContactClickListener listener){
    this.listener = listener;
}


public ImageAdapter(Context context, List<ModelHewan> items){
    this.context = context;
    this.items = items;
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView gambar;
        TextView namaHewan;
        TextView namaLatin;
        CardView card;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            gambar = itemView.findViewById(R.id.gambar);
            namaHewan = itemView.findViewById(R.id.namaHewan);
            namaLatin = itemView.findViewById(R.id.namaLatin);
            card = itemView.findViewById(R.id.card);

            itemView.setOnClickListener(v -> {
                listener.onClick(v, getAdapterPosition());

            });
        }
    }

    @NonNull
    @Override
    public ImageAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.value_sub_home, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ImageAdapter.ViewHolder holder, int position) {

        ModelHewan item = items.get(position);
        holder.namaHewan.setText(item.getNamaHewan());
        holder.namaLatin.setText(item.getNamaLatin());
        Glide.with(context)
                .load(item.getGambar())
                .centerCrop()
                .placeholder(R.drawable.ic_launcher_background)
                .apply(RequestOptions.circleCropTransform())
                .into(holder.gambar);

        RandomColor randomColor = new RandomColor();
        holder.card.setCardBackgroundColor(randomColor.getRandomColorCode());

        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(context, activity_fullView.class);
            intent.putExtra("gambar", item.getGambar());
            intent.putExtra("namaHewan", item.getNamaHewan());
            intent.putExtra("namaLatin", item.getNamaLatin());
            intent.putExtra("status", item.getStatus());
            intent.putExtra("jenisMakanan", item.getJenisMakanan());
            intent.putExtra("jenisSpesies", item.getJenisSpesies());
            intent.putExtra("pesebaran", item.getPesebaran());
            intent.putExtra("makananKesukaan", item.getMakananKesukaan());
            intent.putExtra("deskripsi", item.getDeskripsi());
            context.startActivity(intent);
            CustomIntent.customType(context, "up-to-bottom");

        });
    }


    @Override
    public int getItemCount() { return (items != null) ? items.size() : 0;}
}

