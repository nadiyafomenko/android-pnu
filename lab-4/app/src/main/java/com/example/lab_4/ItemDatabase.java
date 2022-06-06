package com.example.lab_4;

import android.content.Context;
import android.os.AsyncTask;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

@Database(entities = {Item.class}, version = 1)
public abstract class ItemDatabase extends RoomDatabase {

    private static ItemDatabase instance;

    public abstract ItemDao itemDao();

    public static synchronized ItemDatabase getInstance(Context context) {
        if (instance == null) {
            instance = Room.databaseBuilder(context.getApplicationContext(),
                    ItemDatabase.class, "item_database")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }

        return instance;
    }

    private static final RoomDatabase.Callback roomCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };

    private static class PopulateDbAsyncTask extends AsyncTask<Void, Void, Void> {
        private final ItemDao itemDao;

        private PopulateDbAsyncTask(ItemDatabase db) {
            itemDao = db.itemDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemDao.insert(new Item("Title 1", "Description 1", 1));
            itemDao.insert(new Item("Title 2", "Description 2", 2));
            itemDao.insert(new Item("Title 3", "Description 3", 3));
            itemDao.insert(new Item("Title 4", "Description 4", 4));
            itemDao.insert(new Item("Title 5", "Description 5", 5));
            itemDao.insert(new Item("Title 6", "Description 6", 6));
            itemDao.insert(new Item("Title 7", "Description 7", 7));
            itemDao.insert(new Item("Title 8", "Description 8", 8));
            itemDao.insert(new Item("Title 9", "Description 9", 9));
            itemDao.insert(new Item("Title 10", "Description 10", 10));
            itemDao.insert(new Item("Title 11", "Description 11", 11));
            itemDao.insert(new Item("Title 12", "Description 12", 12));
            itemDao.insert(new Item("Title 12", "Description 13", 13));
            itemDao.insert(new Item("Title 14", "Description 14", 14));
            itemDao.insert(new Item("Title 15", "Description 15", 15));
            itemDao.insert(new Item("Title 16", "Description 16", 16));
            return null;
        }
    }
}