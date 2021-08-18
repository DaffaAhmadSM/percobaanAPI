package com.example.belajarfan;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class MainAdapter extends RecyclerView.Adapter<MainAdapter.ViewHolder> {
    ArrayList<MainModel> mainModels;
    Context context;

    public MainAdapter(ArrayList<MainModel> mainModels, Context context) {
        this.mainModels = mainModels;
        this.context = context;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.list_item_main, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        MainModel mm = mainModels.get(position);

        holder.tvProvinsi.setText(mm.getProvinsi());
        holder.tvPositif.setText("Positif : " +  mm.getKasus_posi());
        holder.tvSembuh.setText("Sembuh : " + mm.getKasus_semb());
        holder.tvMeninggal.setText("Meninggal : "+mm.getKasus_semb());



    }

    @Override
    public int getItemCount() {
        return (mainModels != null) ? mainModels.size() : 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        TextView tvProvinsi, tvPositif, tvSembuh, tvMeninggal;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            tvProvinsi = itemView.findViewById(R.id.tv_provinsi);
            tvPositif = itemView.findViewById(R.id.tv_positif);
            tvSembuh = itemView.findViewById(R.id.tv_sembuh);
            tvMeninggal = itemView.findViewById(R.id.tv_meninggal);
        }
    }
}
