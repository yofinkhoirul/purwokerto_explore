package com.tubes.wisata.database;

import android.content.Context;

import androidx.room.Room;


public class DatabaseClient {

    private static DatabaseClient mInstance;
    AppDatabase mAppDatabase;

    private DatabaseClient(Context context) {
        mAppDatabase = Room.databaseBuilder(context, AppDatabase.class, "wisata_db")
                .fallbackToDestructiveMigration()
                .build();
    }

    public static synchronized DatabaseClient getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new DatabaseClient(context);
        }
        return mInstance;
    }

    public static DatabaseClient getInstance() {
        if (mInstance != null) {
            return mInstance;
        }
        throw new IllegalArgumentException("Should use getInstance(Context) at least once before using this method.");
    }

    public AppDatabase getAppDatabase() {
        return mAppDatabase;
    }

}
