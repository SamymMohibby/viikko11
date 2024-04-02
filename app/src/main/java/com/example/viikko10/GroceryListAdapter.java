package com.example.viikko10;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class GroceryListAdapter extends RecyclerView.Adapter<GroceryViewHolder> {
    private final Context context;
    private final ArrayList<Grocery> groceries;

    public GroceryListAdapter(Context context, ArrayList<Grocery> groceries) {
        this.context = context;
        this.groceries = groceries;
    }
    public void onItemEdit(int position) {
        // Get the item at the given position
        Grocery grocery = groceries.get(position);
    }

    @NonNull
    @Override
    public GroceryViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.grocery_view, parent, false);
        return new GroceryViewHolder(itemView, this);
    }
    public void onItemDelete(int position) {
        // Remove the item from your data set
        groceries.remove(position);
        notifyItemRemoved(position);
    }

    @Override
    public void onBindViewHolder(@NonNull GroceryViewHolder holder, int position) {
        Grocery grocery = groceries.get(position);
        holder.groceryName.setText(grocery.getGrocery());
        holder.groceryNote.setText(grocery.getNote());
        // Add click listeners for edit and delete here if necessary
    }

    @Override
    public int getItemCount() {
        return groceries.size();
    }
}
