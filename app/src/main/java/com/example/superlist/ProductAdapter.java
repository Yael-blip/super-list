package com.example.superlist;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.CheckedTextView;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    ArrayList<Product>  products;

    public ProductAdapter(ArrayList<Product> products) {
        this.products = products;
    }

    @NonNull
    @Override
    public ProductAdapter.ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View productView = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_product_view, parent, false);
        return new ProductAdapter.ProductViewHolder(productView);
    }
    @Override
    public void onBindViewHolder(@NonNull ProductAdapter.ProductViewHolder holder, int position) {
        Product currProduct = products.get(position);
        holder.productNameTextView.setText(currProduct.getName());
        holder.InBasketView.setChecked(currProduct.getIn_basket());
    }

    @Override
    public int getItemCount() {
        return products.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {

        public TextView productNameTextView;
        public CheckBox InBasketView;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            productNameTextView = itemView.findViewById(R.id.product_button);
            InBasketView = itemView.findViewById(R.id.product_checkbox);
       }
    }
}
