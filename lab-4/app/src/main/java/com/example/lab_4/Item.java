package com.example.lab_4;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "item_table")
public class Item {

    @PrimaryKey(autoGenerate = true)
    private int id;

    private final String header;

    private final String description;

    private final int number;

    public Item(String header, String description, int number) {
        this.header = header;
        this.description = description;
        this.number = number;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHeader() {
        return header;
    }

    public int getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public int getNumber() {
        return number;
    }
}
