package com.example.mymap.Entity;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity
public class Entity {

    @PrimaryKey
    public int id;

    @ColumnInfo(name = "place")
    public String place;

    @ColumnInfo(name = "longitude")
    public double longitude;

    @ColumnInfo(name = "latitude")
    public double latitude;

    public Entity(String place,double longitude,double latitude){
        this.place = place;
        this.longitude = longitude;
        this.latitude = latitude;
    }

}
