package com.example.makeup;

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

public class ListMakeUpAdapter extends RecyclerView.Adapter<ListMakeUpAdapter.ListViewHolder> {
    private ArrayList<MakeUp_Data> MakeupList;

    public ListMakeUpAdapter(ArrayList<MakeUp_Data> list) {
        this.MakeupList = list;
    }


    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_makeup, parent, false);
        return new ListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ListViewHolder holder, int position) {
        final MakeUp_Data data_mobil =MakeupList.get(position);
        Glide.with(holder.itemView.getContext()).load(data_mobil.getFoto())
                .apply(new RequestOptions()).override(60, 60)
                .into(holder.fotoMakeUp);

        holder.namaMakeUp.setText(data_mobil.getNama());
        holder.deskMakeUp.setText(data_mobil.getHarga());
    }

    @Override
    public int getItemCount() {
        return MakeupList.size();
    }

    public class ListViewHolder extends RecyclerView.ViewHolder {
        ImageView fotoMakeUp;
        TextView namaMakeUp, deskMakeUp;
        public ListViewHolder(@NonNull View itemView) {
            super(itemView);
            fotoMakeUp = itemView.findViewById(R.id.foto_makeup);
            namaMakeUp = itemView.findViewById(R.id.nama_makeup);
            deskMakeUp = itemView.findViewById(R.id.desk_makeup);

        }
    }
}
