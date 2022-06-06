package com.example.lab_4;

import androidx.paging.DataSource;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

@Dao
public interface ItemDao {

    @Insert
    void insert(Item item);

    @Update
    void update(Item item);

    @Delete
    void delete(Item item);

    @Query("DELETE FROM item_table")
    void deleteAllItems();

    @Query("SELECT * FROM item_table ORDER by number Desc")
    DataSource.Factory<Integer, Item> getAllItems();
}