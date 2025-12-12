
package com.example.superlist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;


public class home_screen extends AppCompatActivity {
    Button viewList1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        BottomNavigationView bottomNav = findViewById(R.id.bottom_tabs);
        bottomNav.setOnItemSelectedListener(item->{
            if (item.getItemId() == R.id.my_lists) {
                Intent intent = new Intent(home_screen.this, home_screen.class);
                startActivity(intent);
                return true;
            }

            if (item.getItemId() == R.id.settings) {
                Intent intent = new Intent(home_screen.this, activity_settings.class);
                startActivity(intent);
                return true;
            }

            return false;
            });

        ArrayList<ShopList> shopListArray = new ArrayList<>();
        for (int i = 0; i < 15; i++) {
            shopListArray.add(new ShopList("List " + i, 15, "400₪", 3, "shop_list_icon"));
        }

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        RecyclerView.LayoutManager layoutManager = (new LinearLayoutManager(this));
        recyclerView.setLayoutManager(layoutManager);

        ShopListAdapter listAdapter = new ShopListAdapter(shopListArray);
        recyclerView.setAdapter(listAdapter);
    }
}
