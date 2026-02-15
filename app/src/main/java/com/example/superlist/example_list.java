package com.example.superlist;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

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

        ArrayList<Product> productArray = new ArrayList<>();
        ProductAdapter productAdapter = new ProductAdapter(productArray);

        RecyclerView productRecyclerView = findViewById(R.id.product_recyclerview);
        productRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        productRecyclerView.setAdapter(productAdapter);

        // 2. Reference the "items" node in Firebase
        String listId = getIntent().getStringExtra("LIST_ID");
        DatabaseReference itemsRef = FirebaseDatabase.getInstance().getReference("items").child(listId);

        // 3. Fetch existing data and listen for updates
        itemsRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                // Clear the array to prevent duplicates when data updates
                productArray.clear();

                // Loop through all existing items in the "items" node
                for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                    Product product = snapshot.getValue(Product.class);

                    // Create the Product object using the extracted data
                    if (product != null) {
                        productArray.add(product);
                    }
                }

                // Refresh the UI with the data pulled from Firebase
                productAdapter.notifyDataSetChanged();
            }

            @Override
            public void onCancelled(com.google.firebase.database.DatabaseError error) {
                android.util.Log.e("Firebase", "Failed to load items: " + error.getMessage());
            }
        });

//        ArrayList<Product> ProductArray = new ArrayList<>();
//
//        for (int i = 0; i < 15; i++) {
//            ProductArray.add(new Product("Product " + i, false));
//        }
//
//        RecyclerView productRecyclerView = findViewById(R.id.product_recyclerview);
//        RecyclerView.LayoutManager layoutManager = (new LinearLayoutManager(this));
//
//        productRecyclerView.setLayoutManager(layoutManager);
//
//        ProductAdapter productAdapter = new ProductAdapter(ProductArray);
//        productRecyclerView.setAdapter(productAdapter);
    }
}