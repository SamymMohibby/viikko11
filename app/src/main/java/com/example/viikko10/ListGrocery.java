package com.example.viikko10;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;

public class ListGrocery extends AppCompatActivity {
    private static ListGrocery instance;
    private RecyclerView recyclerView;
    private GroceryListAdapter adapter;
    private ArrayList<Grocery> groceryList;
    public ArrayList<Grocery> getGroceries() {
        return this.groceryList; // Return your current list of groceries
    }
    public static synchronized ListGrocery getInstance() {
        if(instance == null) {
            instance = new ListGrocery();
        }
        return instance;
    }
    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceryList) {
            if (grocery.getName().equals(name)) {
                return grocery;
            }
        }
        return null;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); // Make sure you have a corresponding layout file

        recyclerView = findViewById(R.id.rvGroceries); // Ensure you have a RecyclerView with this id in your layout
        groceryList = new ArrayList<>(); // Initialize your list (potentially from savedInstanceState or a ViewModel/Database)

        // Set up the RecyclerView with a LinearLayoutManager and your adapter
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new GroceryListAdapter(this, groceryList); // Pass the list to your adapter
        recyclerView.setAdapter(adapter);
    }

    // Optionally, if you have methods to add or remove items from the list, update the RecyclerView accordingly:
    public void addGrocery(Grocery grocery) {
        groceryList.add(grocery);
        adapter.notifyItemInserted(groceryList.size() - 1);
    }
    public Grocery getGrocery(String groceryName) {
        for (Grocery grocery : groceryList) {
            if (grocery.getGrocery().equals(groceryName)) {
                return grocery;
            }
        }
        return null; // or throw an exception if the item isn't found, depending on how you want to handle it
    }

    public void removeGrocery(String groceryName) {
        for (int i = 0; i < groceryList.size(); i++) {
            if (groceryList.get(i).getName().equals(groceryName)) {
                groceryList.remove(i);
                adapter.notifyItemRemoved(i);
                return; // Exit once you find the item to remove
            }
        }
    }
}
