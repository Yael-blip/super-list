
package com.example.superlist;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.HashMap;


public class home_screen extends AppCompatActivity {
    Button viewList1;
    FB_control fbControl;
    Button logOutButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_screen);

        FirebaseUser currentUser = FirebaseAuth.getInstance().getCurrentUser();
        if (currentUser != null) {
            String uid = currentUser.getUid();
            User user = new User(uid);
        }

        fbControl = new FB_control();
        BottomNavigationView bottomNav = findViewById(R.id.bottom_tabs);
        bottomNav.setOnItemSelectedListener(item->{
            int id = item.getItemId();

            if (id == R.id.my_lists) {
                // DO NOTHING or just close the drawer if you have one.
                // You are already on home_screen, so don't start it again.
                return true;
            }

//            if (id == R.id.my_lists) {
//                Intent intent = new Intent(home_screen.this, home_screen.class);
//                startActivity(intent);
//                return true;
//            }

            if (item.getItemId() == R.id.settings) {
                Intent intent = new Intent(home_screen.this, activity_settings.class);
                startActivity(intent);
                return true;
            }


            if (logOutButton.getId() == R.id.logOutButton) {
                fbControl.logOut(this);
                return true;
            }


            return false;
            });

        // 1. Setup the UI components and empty list
        ArrayList<ShopList> shopListArray = new ArrayList<>();
        ShopListAdapter listAdapter = new ShopListAdapter(shopListArray);
        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(listAdapter);

        // 2. Reference the user's specific "lists" node
        if (currentUser != null) {
            String uid = currentUser.getUid();

            // 2. Reference the user's specific index of lists
            DatabaseReference userListsRef = FirebaseDatabase.getInstance().getReference("user_lists").child(uid);

            userListsRef.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    shopListArray.clear();
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        String listId = snapshot.getKey(); // Get the ID from the index

                        // Now fetch the actual list data from the "lists" node
                        FirebaseDatabase.getInstance().getReference("lists").child(listId)
                                .addListenerForSingleValueEvent(new ValueEventListener() {
                                    @Override
                                    public void onDataChange(DataSnapshot listSnapshot) {
                                        ShopList list = listSnapshot.getValue(ShopList.class);
                                        if (list != null) {
                                            list.setList_id(listSnapshot.getKey());
                                            shopListArray.add(list);
                                            listAdapter.notifyDataSetChanged();
                                        }
                                    }
                                    @Override
                                    public void onCancelled(DatabaseError error) {}
                                });
                    }
                }
                @Override
                public void onCancelled(DatabaseError error) {}
            });

//            DatabaseReference listsRef = FirebaseDatabase.getInstance().getReference("lists").child(uid);
//
//            // 3. Query the data
//            listsRef.addValueEventListener(new com.google.firebase.database.ValueEventListener() {
//                @Override
//                public void onDataChange(com.google.firebase.database.DataSnapshot dataSnapshot) {
//                    // Clear the old hardcoded/previous data
//                    shopListArray.clear();
//
//                    // Iterate through each child in the "lists/UID" node
//                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
//                        // Map the Firebase data to your ShopList class
//                        ShopList list = snapshot.getValue(ShopList.class);
//
//                        if (list != null) {
//                            list.setList_id(snapshot.getKey());
//                            shopListArray.add(list);
//                        }
//                    }
//                    // Refresh the RecyclerView with the new data from Firebase
//                    listAdapter.notifyDataSetChanged();
//                }
//
//                @Override
//                public void onCancelled(com.google.firebase.database.DatabaseError error) {
//                    // Handle database errors (e.g., permission denied)
//                    android.util.Log.w("Firebase", "Failed to read value.", error.toException());
//                }
//            });
        }

//        ArrayList<ShopList> shopListArray = new ArrayList<>();
//        for (int i = 0; i < 15; i++) {
//            shopListArray.add(new ShopList("List " + i, 15, "400₪", 3, "shop_list_icon"));
//        }
//
//        RecyclerView recyclerView = findViewById(R.id.recyclerview);
//        RecyclerView.LayoutManager layoutManager = (new LinearLayoutManager(this));
//        recyclerView.setLayoutManager(layoutManager);
//
//        ShopListAdapter listAdapter = new ShopListAdapter(shopListArray);
//        recyclerView.setAdapter(listAdapter);
    }
}
