package com.example.viikko10;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.WindowDecorActionBar;


public class AddGroceryActivity extends AppCompatActivity {
    private EditText editGroceryName;
    private EditText editGroceryNote;
    private Button buttonAddGrocery;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_grocery);
        editGroceryName = findViewById(R.id.editGroceryName);
        editGroceryNote = findViewById(R.id.editGroceryNote);
        buttonAddGrocery = findViewById(R.id.buttonAddGrocery);


    }
    public void addGrocery(View view) {
        String addGrocery = editGroceryName.getText().toString();
        String addNote = editGroceryNote.getText().toString();
        Grocery grocery = new Grocery(addGrocery, addNote);
        Intent data = new Intent();
        data.putExtra("grocery", grocery); // Use a key like "grocery" to put your grocery object
        setResult(RESULT_OK, data); // Set the result with RESULT_OK and attach the data
        finish();
    }
}