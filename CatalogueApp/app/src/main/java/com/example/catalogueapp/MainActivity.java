package com.example.catalogueapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.RecyclerView.Adapter;
import androidx.room.Room;

import android.content.Intent;
import android.os.Bundle;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.example.catalogueapp.database.CatalogueDatabase;
import com.example.catalogueapp.database.DatabaseReceiver;
import com.example.catalogueapp.database.DatabaseTask;
import com.example.catalogueapp.database.Product;
import com.example.catalogueapp.ProductListAdapter;

import java.util.List;

public class MainActivity extends AppCompatActivity implements DatabaseReceiver {

    public static String MESSAGE = "com.example.catalogueApp.MainActivity";
    ProductViewModel products;
    ProductListAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        products = ViewModelProviders.of(this).get(ProductViewModel.class);

        products.getProducts(getApplicationContext()).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                getAll(products);
            }
        });

        RecyclerView recyclerView = findViewById(R.id.recyclerview);
        adapter = new ProductListAdapter(this);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }

    public void actionFromButton(View view) {
        Log.d("CLICKED", "FROM VIEW" + view);
    }


    public void doInsert(View view){


        DatabaseTask insertTask = new DatabaseTask(getApplicationContext());

        Product t = new Product();
        t.name = "Producto 8"; t.price = 10.00f;

        Product t2 = new Product();
        t2.name = "Producto 9"; t2.price = 20.00f;

        Product t3 = new Product();
        t3.name = "Producto 10"; t3.price = 30.00f;


        insertTask.execute(t,t2,t3);

    }

    public void getAll(List<Product> products){
        /*
        LayoutInflater inflater = getLayoutInflater();
        ViewGroup table = findViewById(R.id.catalogueList);
        table.removeAllViews();

        for (Product actual:products){
            Log.d("Hello", "Products name here!" +actual.name);
            View row = inflater.inflate(R.layout.row_layout,table, false);
            TextView vw = row.findViewById(R.id.productName);
            vw.setText(actual.name);
            table.addView(row);
        }
        */
    }

    public void doAction(View view){

        String src = "%"+((EditText)findViewById(R.id.searchText)).getText()+"%";

        products.searchProducts(getApplicationContext(),src).observe(this, new Observer<List<Product>>() {
            @Override
            public void onChanged(List<Product> products) {
                //getAll(products);
                Log.d("PRODUCTS" , ""+products);
                adapter.setProducts(products);

            }
        });
        /*
        DatabaseTask task = new DatabaseTask(getApplicationContext(), this);
        Product p = new Product();
        p.name = ""+((EditText)findViewById(R.id.searchText)).getText()+"%";
        task.execute(p);

         */
        /*
        Product t = new Product();
        t.name = "Producto 1"; t.price = 10.00f;
        db.productDAO().insertProduct(t);
        Product t2 = new Product();
        t2.name = "Producto 1"; t2.price = 20.00f;
        db.productDAO().insertProduct(t);
        Product t3 = new Product();
        t3.name = "Producto 1"; t3.price = 30.00f;
        db.productDAO().insertProduct(t);

         */

        /*
        Log.d("CUSTOM","CLICK ON ME!");
        TextView v = (TextView)findViewById(R.id.editText);
        TextView vt = findViewById(R.id.viewTitleText);
        vt.setText(v.getText());

        Intent intent = new Intent(this, DetailActivity.class);
        intent.putExtra(MESSAGE,"" + v.getText());
        Log.d("Text ", "" + v.getText());
        startActivity(intent);
        //Room dv;

         */
    }

    public void goToWeb(View view){
        Intent intent = new Intent(this, WebCallActivity.class);
        startActivity(intent);
    }

    /*public void goToNextScreen(){

    }*/
}
