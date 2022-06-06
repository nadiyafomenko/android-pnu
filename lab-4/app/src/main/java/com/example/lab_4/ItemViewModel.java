package com.example.lab_4;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.paging.LivePagedListBuilder;
import androidx.paging.PagedList;

import java.util.List;

public class ItemViewModel extends AndroidViewModel {
    private final ItemRepository repository;
    private final LiveData<PagedList<Item>> allItems;

    public ItemViewModel(@NonNull Application application) {
        super(application);
        repository = new ItemRepository(application);
        allItems = repository.getAllItems();
    }

    public void insert(Item item) {
        repository.insert(item);
    }

    public void update(Item item) {
        repository.update(item);
    }

    public void delete(Item item) {
        repository.delete(item);
    }

    public void deleteAllItems() {
        repository.deleteAllItems();
    }

    public LiveData<PagedList<Item>> getAllItems() { return allItems; }
}
