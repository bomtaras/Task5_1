package com.example.task5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.TextView;

public class FullRecipeDescription extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        TextView textView_title2 = findViewById(R.id.textView_title2);
       // textView_title2.setMovementMethod(new ScrollingMovementMethod());

        TextView textView_description2 = findViewById(R.id.textView_description2);
        textView_description2.setMovementMethod(new ScrollingMovementMethod());

       String title = getIntent().getExtras().getString("title");
       String description = getIntent().getExtras().getString("description");

        textView_title2.setText(title);
        textView_description2.setText(description);


    }
}