package com.example.viikko10;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;

import android.os.Bundle;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvGroceries;
    private GroceryListAdapter adapter;
    private ArrayList<Grocery> groceries;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        groceries = new ArrayList<>();
        adapter = new GroceryListAdapter(this, groceries);
        rvGroceries = findViewById(R.id.rvGroceries);
        rvGroceries.setLayoutManager(new LinearLayoutManager(this));
        rvGroceries.setAdapter(adapter);
    }

    public void addGrocery(Grocery grocery) {
        groceries.add(grocery);
        adapter.notifyItemInserted(groceries.size() - 1);
    }

    public void removeGrocery(String groceryName) {
        for (int i = 0; i < groceries.size(); i++) {
            if (groceries.get(i).getGrocery().equals(groceryName)) {
                groceries.remove(i);
                adapter.notifyItemRemoved(i);
                break;
            }
        }
    }

    public Grocery getGroceryByName(String name) {
        for (Grocery grocery : groceries) {
            if (grocery.getGrocery().equals(name)) {
                return grocery;
            }
        }
        return null;
    }

    public void sortGroceriesByAlphabet() {
        Collections.sort(groceries, new Comparator<Grocery>() {
            @Override
            public int compare(Grocery o1, Grocery o2) {
                return o1.getGrocery().compareToIgnoreCase(o2.getGrocery());
            }
        });
        adapter.notifyDataSetChanged();
    }

    public void sortGroceriesByTime() {
        // This would sort based on the time they were added if each grocery had a timestamp
        // For now, it sorts based on the natural ordering of the list which is the order of insertion
        Collections.reverse(groceries);
        adapter.notifyDataSetChanged();
    }

    public void onGroceryAdded(Grocery grocery) {
        addGrocery(grocery);
    }

    public void onGroceryRemoved(String groceryName) {
        removeGrocery(groceryName);
    }

    public void onSortAlphabetClicked(View view) {
        sortGroceriesByAlphabet();
    }

    public void onSortTimeClicked(View view) {
        sortGroceriesByTime();
    }

    private static final int ADD_GROCERY_REQUEST = 1;

    public void switchToAddGroceryActivity(View view) {
        Intent intent = new Intent(this, AddGroceryActivity.class);
        startActivityForResult(intent, ADD_GROCERY_REQUEST);

    }
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == ADD_GROCERY_REQUEST) {
            if (resultCode == RESULT_OK) {
                // Get the added grocery
                Grocery newGrocery = (Grocery) data.getSerializableExtra("GROCERY_DATA");

                // Add grocery to your list and update RecyclerView
                // Assuming you have a method in MainActivity to do so
                addGroceryToListAndRefreshRecyclerView(newGrocery);
            }
        }
    }

    private void addGroceryToListAndRefreshRecyclerView(Grocery newGrocery) {
        if (newGrocery != null) {
            groceries.add(newGrocery);
            adapter.notifyItemInserted(groceries.size() - 1);
        }

    }

}
