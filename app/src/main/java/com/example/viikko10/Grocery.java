package com.example.viikko10;

import java.io.Serializable;
import androidx.annotation.NonNull;

public class Grocery implements Serializable {
    private String grocery;
    private String note;

    public Grocery(@NonNull String grocery, @NonNull String note) {
        this.grocery = grocery;
        this.note = note;
    }
    public String getGrocery() {
        return grocery;
    }
    @NonNull
    public String getName() {
        return grocery;
    }

    public void setName(@NonNull String grocery) {
        this.grocery = grocery;
    }

    @NonNull
    public String getNote() {
        return note;
    }

    public void setNote(@NonNull String note) {
        this.note = note;
    }

    @Override
    public String toString() {
        return "Grocery{" +
                "name='" + grocery + '\'' +
                ", note='" + note + '\'' +
                '}';
    }

}
