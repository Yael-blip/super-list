package com.example.superlist;
import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
public class ShopListAdapter extends RecyclerView.Adapter<ShopListAdapter.list_objectViewHolder> {
    ArrayList<ShopList> listObject;

    public ShopListAdapter(ArrayList<ShopList> listObject) {
        this.listObject = listObject;
    }

    @NonNull
    @Override
    public list_objectViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View list_objectview = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_view, parent, false);
        return new list_objectViewHolder(list_objectview);
    }

    @Override
    public void onBindViewHolder(@NonNull list_objectViewHolder holder, int position) {
        ShopList shopList = listObject.get(position);
        holder.list_nameTextView.setText(shopList.getList_name());
        holder.list_lenTextView.setText(""+shopList.getList_len());
        holder.total_priceTextView.setText(shopList.getTotal_price());
    }

    @Override
    public int getItemCount() {
        return listObject.size();
    }

    public static class list_objectViewHolder extends RecyclerView.ViewHolder{

        public TextView list_nameTextView;
        public TextView list_lenTextView;
        public TextView total_priceTextView;
        public ImageView iconImageView;
        public Button shopListButton;
        public list_objectViewHolder(@NonNull View itemView) {
            super(itemView);
            list_nameTextView = itemView.findViewById(R.id.list_name);
            list_lenTextView = itemView.findViewById(R.id.prodocts_num);
            total_priceTextView = itemView.findViewById(R.id.price);
            iconImageView = itemView.findViewById(R.id.shop_list_icon);
            shopListButton = itemView.findViewById(R.id.shop_list_button);

            shopListButton.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int id = v.getId();
                    Context ctx =v.getContext();
                    Intent intent = new Intent(ctx, example_list.class);
                    ctx.startActivity(intent);
                }
            });
        }
    }
}
