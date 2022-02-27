package com.example.task5_1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class AddNewRecipeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_new_recipe);

        EditText editText_add_recipe_title = findViewById(R.id.editText_add_recipe_title);
        EditText editText_add_recipe_image= findViewById(R.id.editText_add_recipe_imageURL);
        EditText editText_add_recipe_description = findViewById(R.id.editText_add_recipe_description);
        Button button_add_recipe = findViewById(R.id.button_add_recipe);

        button_add_recipe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Recipe recipe = new Recipe();
                recipe.setTitle(editText_add_recipe_title.getText().toString());
                recipe.setImage(editText_add_recipe_image.getText().toString());
                recipe.setDescription(editText_add_recipe_description.getText().toString());

                recipe.save(AddNewRecipeActivity.this);

                AddNewRecipeActivity.this.finish();
            }
        });


    }
}