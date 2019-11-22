package com.example.catalogueapp;

import android.content.Context;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.room.Room;

import java.util.List;

import com.example.catalogueapp.database.CatalogueDatabase;
import com.example.catalogueapp.database.Product;

public class ProductViewModel extends ViewModel {

    private LiveData<List<Product>> products;

    public ProductViewModel(){
        super();
    }

    public LiveData<List<Product>> getProducts(Context ctx)
    {
        if(products == null){
            CatalogueDatabase db = Room.databaseBuilder(ctx, CatalogueDatabase.class, "catalogue-database").build();
            products = db.productDAO().getAll();
        }
        return products;
    }

    public LiveData<List<Product>> searchProducts(Context ctx, String searchString)
    {
        CatalogueDatabase db = Room.databaseBuilder(ctx, CatalogueDatabase.class, "catalogue-database").build();


        products = db.productDAO().search(searchString);

        return products;
    }
}
