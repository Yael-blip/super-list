package com.example.superlist;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;

public class example_list extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example_list);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_tabs);
        bottomNav.setOnItemSelectedListener(item->{
            if (item.getItemId() == R.id.my_lists) {
                Intent intent = new Intent(example_list.this, home_screen.class);
                startActivity(intent);
                return true;
            }

            if (item.getItemId() == R.id.settings) {
                Intent intent = new Intent(example_list.this, activity_settings.class);
                startActivity(intent);
                return true;
            }

            return false;
        });


        ArrayList<Product> ProductArray = new ArrayList<>();

        for (int i = 0; i < 15; i++) {
            ProductArray.add(new Product("Product " + i, false));
        }

        RecyclerView productRecyclerView = findViewById(R.id.product_recyclerview);
        RecyclerView.LayoutManager layoutManager = (new LinearLayoutManager(this));

        productRecyclerView.setLayoutManager(layoutManager);

        ProductAdapter productAdapter = new ProductAdapter(ProductArray);
        productRecyclerView.setAdapter(productAdapter);
    }
}