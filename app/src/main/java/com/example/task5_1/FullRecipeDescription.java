package com.example.task5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

public class FullRecipeDescription extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_full_recipe);

        TextView textView_title = findViewById(R.id.textView_title);
        // textView_title.setMovementMethod(new ScrollingMovementMethod());

       ImageView imageView = findViewById(R.id.imageView);

        TextView textView_description = findViewById(R.id.textView_description);
        textView_description.setMovementMethod(new ScrollingMovementMethod());

        int id = getIntent().getExtras().getInt("id");

        Recipe recipe = new Recipe(id,FullRecipeDescription.this);

        textView_title.setText(recipe.getTitle());
        Picasso.get().load(recipe.getImage()).into(imageView);
        textView_description.setText(recipe.getDescription());


    }
}