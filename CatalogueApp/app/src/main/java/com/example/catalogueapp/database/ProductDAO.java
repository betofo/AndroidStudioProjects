package com.example.catalogueapp.database;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Update;
import androidx.room.Query;

import java.util.List;

@Dao
public interface ProductDAO {

    @Insert
    public void insertProduct(Product... products);

    @Update
    public void updateProduct(Product... products);

    @Delete
    public void deleteProduct(Product... products);

    @Query("SELECT * FROM product")
    public LiveData<List<Product>> getAll();

    @Query("SELECT * FROM product WHERE name LIKE :searchName")
    public LiveData<List<Product>> search(String searchName);
}
