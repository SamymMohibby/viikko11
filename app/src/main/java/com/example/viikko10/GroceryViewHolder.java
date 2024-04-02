package com.example.viikko10;

import androidx.annotation.NonNull;

import android.media.Image;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.recyclerview.widget.RecyclerView;

public class GroceryViewHolder extends RecyclerView.ViewHolder {
    TextView groceryName, groceryNote;
    private final GroceryListAdapter adapter;
    public GroceryViewHolder(View itemView, final GroceryListAdapter adapter) {
        super(itemView);
        groceryName = itemView.findViewById(R.id.textGroceryName);
        groceryNote = itemView.findViewById(R.id.textGroceryNote);
        ImageView deleteButton = itemView.findViewById(R.id.imageDelete);
        ImageView editButton = itemView.findViewById(R.id.imageEdit);
        this.adapter = adapter;
        ImageView editBtn = itemView.findViewById(R.id.imageEdit);
        deleteButton = itemView.findViewById(R.id.imageDelete);
        editButton = itemView.findViewById(R.id.imageEdit);
        deleteButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    adapter.onItemDelete(position);
                }
            }
        });

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    adapter.onItemEdit(position);
                }
            }
        });
    }
}