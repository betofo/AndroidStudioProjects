package com.example.catalogueapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class WebCallActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web_call);

        callWeb();
    }

    public void callWeb(){
        RequestQueue queue = Volley.newRequestQueue(this);

        StringRequest req = new StringRequest(
                Request.Method.GET,
                "http://10.0.2.2:8000",
                new NodeStringWebRequest(),
                new NodeWebRequestError()
        );

        queue.add(req);
    }
}