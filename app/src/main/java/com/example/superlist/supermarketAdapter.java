package com.example.superlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class supermarketAdapter extends RecyclerView.Adapter<supermarketAdapter.supermarketListViewHolder> {

    ArrayList<supermarket> supermarketList;

    public supermarketAdapter(ArrayList<supermarket> supermarketList) {
        this.supermarketList = supermarketList;
    }

    @NonNull
    public supermarketListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View supermarketView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_supermarket_view, parent, false);
        return new supermarketListViewHolder(supermarketView, supermarketList);
    }


    public void onBindViewHolder(@NonNull supermarketAdapter.supermarketListViewHolder holder, int position) {
        supermarket supermarketObject = supermarketList.get(position);
        holder.super_name.setText(supermarketObject.getName());
        holder.super_address.setText(String.valueOf(supermarketObject.getAddress()));
        holder.super_distance.setText((supermarketObject.getDistance()) + "km");
        holder.super_is_favourite.setChecked(supermarketObject.getIs_favourite());
    }


    public int getItemCount() {
        return supermarketList.size();
    }

    public static class supermarketListViewHolder extends RecyclerView.ViewHolder {
        public TextView super_name;
        public ImageView super_icon;
        public TextView super_address;
        public TextView super_distance;
        public CheckBox super_is_favourite;
        public Button super_button;


        public supermarketListViewHolder(@NonNull View itemView, ArrayList<supermarket> supermarketList) {
            super(itemView);
            super_name = itemView.findViewById(R.id.super_name);
            super_icon = itemView.findViewById(R.id.super_icon);
            super_address = itemView.findViewById(R.id.super_address);
            super_distance = itemView.findViewById(R.id.super_distance);
            super_is_favourite = itemView.findViewById(R.id.super_is_favourite);
            super_button = itemView.findViewById(R.id.super_button);
        }
    }
}



