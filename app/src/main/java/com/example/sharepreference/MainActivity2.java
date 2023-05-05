package com.example.sharepreference;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class MainActivity2 extends AppCompatActivity {
TextView id,name,classes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        id=findViewById(R.id.id);
        name=findViewById(R.id.name);
        classes=findViewById(R.id.classes);
    }
}