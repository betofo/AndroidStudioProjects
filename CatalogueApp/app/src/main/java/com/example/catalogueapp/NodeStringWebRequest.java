package com.example.catalogueapp;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

public class NodeStringWebRequest implements Response.Listener<String> {

    @Override
    public void onResponse(String response) {
        // Display the first 500 characters of the response string.
        Log.d("RESPINSE ", ""+response );
    }

}