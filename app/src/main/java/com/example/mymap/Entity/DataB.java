package com.example.mymap.Entity;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entity.class}, version = 1)
public abstract class DataB extends RoomDatabase {
    public abstract Dao dao();
}
