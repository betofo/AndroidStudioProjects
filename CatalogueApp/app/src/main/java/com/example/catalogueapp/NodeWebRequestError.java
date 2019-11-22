package com.example.catalogueapp;

import android.util.Log;

import com.android.volley.Response;
import com.android.volley.VolleyError;

public class NodeWebRequestError implements Response.ErrorListener {

    @Override
    public void onErrorResponse(VolleyError error) {
        Log.e("ERROR!", "ERRROR!!!!! " + error);
    }
}