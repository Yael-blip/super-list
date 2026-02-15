package com.example.superlist;

import android.os.Bundle;
import android.widget.Adapter;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class setSuper extends AppCompatActivity {

    private ArrayList<supermarket> supermarketList;
    private RecyclerView recyclerView;
    private supermarketAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        // Declare the list at the class level

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_set_super);


        supermarketList = new ArrayList<>();

        supermarketList.add(new supermarket("Shufersal", "Main St 10", "2", true, String.valueOf(R.drawable.list_icon)));
        supermarketList.add(new supermarket("Rami Levy", "Industrial Zone", "3", false, String.valueOf(R.drawable.list_icon)));
        supermarketList.add(new supermarket("Tiv Taam", "Down Town", "4", true, String.valueOf(R.drawable.list_icon)));

//                // Example: logic for your slider
//                slider.addOnChangeListener((slider1, value, fromUser) -> {
//                    // value will be 1 to 15 based on your XML
//                    int selectedRadius = (int) value;
//                    // You could filter your array here based on distance later
//                });

        recyclerView = findViewById(R.id.supermarket_recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // 3. Initialize and set Adapter
        adapter = new supermarketAdapter((supermarketList));
        recyclerView.setAdapter(adapter);

//                // 4. Slider Logic (Filtering the list)
//                Slider slider = findViewById(R.id.slider);
//                slider.addOnChangeListener((slider1, value, fromUser) -> {
//                    int selectedRadius = (int) value;
//                    filter(selectedRadius);
//                });
//            }
//
//            private void filter(int radius) {
//                ArrayList<supermarket> filteredList = new ArrayList<>();
//                for (supermarket item : supermarketList) {
//                    if (Integer.parseInt(item.getDistance()) <= radius) {
//                        filteredList.add(item);
//                    }
//                }
//                adapter.updateList(filteredList);
//            }
//
//        });
    }
}