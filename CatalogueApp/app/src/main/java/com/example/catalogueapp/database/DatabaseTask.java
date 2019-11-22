package com.example.catalogueapp.database;

import android.content.Context;
import android.os.AsyncTask;

import androidx.room.Room;

import java.util.List;

public class DatabaseTask extends AsyncTask<Product, Void, Void> {

    CatalogueDatabase db;
    public DatabaseTask(Context ctx){
        db = Room.databaseBuilder(ctx, CatalogueDatabase.class, "catalogue-database").build();
    }

    @Override
    public void onPreExecute(){

    }

    @Override
    protected Void doInBackground(Product... params) {
        db.productDAO().insertProduct(params);
        db.close();
        return null;
    }

}
