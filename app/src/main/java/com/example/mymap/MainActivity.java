package com.example.mymap;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<Model> models;
    Adapter adapter;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



    }

    @Override
    public boolean onCreateOptionsMenu(@NonNull Menu menu) {
        MenuInflater menuInflater = getMenuInflater();
        menuInflater.inflate(R.menu.map_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.menu){
            Intent intent = new Intent(MainActivity.this,MapsActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

    public void getData(){
        try{
            SQLiteDatabase data = this.openOrCreateDatabase("map",MODE_PRIVATE,null);

            Cursor cursor = data.rawQuery("SELECT*FROM maps",null);
            int idIx = cursor.getColumnIndex("id");
            int placeIx = cursor.getColumnIndex("place");
            int longitudeIx = cursor.getColumnIndex("longitude");
            int latitudeIx = cursor.getColumnIndex("latitude");


            while(cursor.moveToNext()){
                int id = cursor.getInt(idIx);
                String place = cursor.getString(placeIx);
                double latitude = cursor.getDouble(latitudeIx);
                double longitude = cursor.getDouble(longitudeIx);
                Model model = new Model(id,place,latitude,longitude);
                models.add(model);
                adapter = new Adapter(models);
                recyclerView = findViewById(R.id.recyclerView);
                recyclerView.setAdapter(adapter);
            }
            cursor.close();
        }catch(Exception e){

        }


    }
}