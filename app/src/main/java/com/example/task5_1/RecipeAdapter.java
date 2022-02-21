package com.example.task5_1;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.text.Layout;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class RecipeAdapter extends RecyclerView.Adapter {

    private Context context;
    private ArrayList<Recipe> recipes;

    public RecipeAdapter(Context context,ArrayList<Recipe>recipes){
        this.context = context;
        this.recipes = recipes;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
     LayoutInflater inflater = LayoutInflater.from(context);
     View row = inflater.inflate(R.layout.recipe_item,parent,false);
     MyViewHolder item =new MyViewHolder(row);
        return item;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, @SuppressLint("RecyclerView") int position) {
       // ((MyViewHolder)holder).imageView.setImageDrawable(recipes.get(position);
        ((MyViewHolder)holder).textView_title.setText(recipes.get(position).getTitle());
        ((MyViewHolder)holder).textView_description.setText(recipes.get(position).getDescription().substring(0,100));

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(context, FullRecipeDescription.class);

              // Log.d("RECIPE",recipes.get(position).getTitle());

               // Log.d("CLICK","click item"+textView_description.getText());

               //  Log.d("RECIPE",recipes.get(position).getDescription());

               intent.putExtra("title",recipes.get(position).getTitle());
               intent.putExtra("description",recipes.get(position).getDescription());

                context.startActivity(intent);

            }
        });
    }

    @Override
    public int getItemCount() {
        return this.recipes.size();
    }
    public class MyViewHolder extends RecyclerView.ViewHolder {

       // ImageView imageView;
        TextView textView_title;
        TextView textView_description;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
           // imageView = itemView.findViewById(R.id.imageView);
            textView_title = itemView.findViewById(R.id.textView_title);
            textView_description = itemView.findViewById(R.id.textView_description);
        }
    }
}
