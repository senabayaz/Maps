package com.example.mymap;

import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.adapterHolder> {
    ArrayList<Model> models;

    public Adapter(ArrayList<Model> models) {
        this.models = models;
    }

    @NonNull
    @Override
    public adapterHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = View.inflate(parent.getContext(), R.layout.activity_maps,parent);
        return new adapterHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull adapterHolder holder, int position) {
        holder.txt.setText(models.get(position).place);
    }

    @Override
    public int getItemCount() {
        return models.size();
    }

    public class adapterHolder extends RecyclerView.ViewHolder{
        TextView txt;
        public adapterHolder(@NonNull View itemView) {
            super(itemView);
            txt = itemView.findViewById(R.id.editTextTextPersonName);
        }
    }
}
