package com.tubes.wisata.database;

import androidx.room.Database;
import androidx.room.RoomDatabase;

import com.tubes.wisata.database.dao.WisataDao;
import com.tubes.wisata.model.ModelWisata;


@Database(entities = {ModelWisata.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {
    public abstract WisataDao wisataDao();
}
