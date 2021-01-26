package com.latihan.pakaianadat;

import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;

import java.util.ArrayList;

public class PakaianAdapter extends RecyclerView.Adapter<PakaianAdapter.ViewHolder> {
    private ArrayList<Pakaian> datapakaian;
    private OnItemClickCallback onItemClickCallback;

    public void setOnItemClickCallback(OnItemClickCallback onItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback;
    }

    public PakaianAdapter(ArrayList<Pakaian> list){
        this.datapakaian = list;
    }
    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_tampilan, viewGroup, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {
        Pakaian pakaian = datapakaian.get(position);
        Glide.with(holder.itemView.getContext()).load(pakaian.getGambar()).apply(new RequestOptions().override(60, 60)).into(holder.imgPhoto);
        holder.textViewName.setText(pakaian.getNama());
        holder.textViewKeterangan.setText(pakaian.getKeterangan());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onItemClickCallback.onItemClicked(datapakaian.get(holder.getAdapterPosition()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return datapakaian.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        ImageView imgPhoto;
        TextView textViewName, textViewKeterangan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent move = new Intent(view.getContext(), Detail.class);
                    move.putExtra(Detail.nama, datapakaian );
                    move.putExtra(Detail.keterangan, datapakaian);
                    view.getContext().startActivity(move);
                }
            });
            imgPhoto = itemView.findViewById(R.id.img_photo);
            textViewName = itemView.findViewById(R.id.nama);
            textViewKeterangan = itemView.findViewById(R.id.keterangan);
        }
    }

    public interface OnItemClickCallback {
        void onItemClicked(Pakaian pakaian);
    }
}
