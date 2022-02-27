package com.example.task5_1;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class Recipe {

    private int id;
    private String title;
    private String image;
    private String description;

    public Recipe() {

    }

    public Recipe(int id,Context context){
        String strId = String.valueOf(id);
        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();
        Cursor cursor = database.query(SQLiteHelper.TABLE_RECIPES ,new String[]{"id","title",SQLiteHelper.COLUMN_IMAGE,"description"},"id=?",new String[]{strId},null,null,null,null);
        cursor.moveToFirst();

        this.id = id;
        this.title = cursor.getString(1);
        this.image = cursor.getString(2);
        this.description = cursor.getString(3);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public void save(Context context) {

        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        ContentValues values = new ContentValues();
        values.put(SQLiteHelper.COLUMN_TITLE,this.title);
        values.put(SQLiteHelper.COLUMN_IMAGE,this.image);
        values.put(SQLiteHelper.COLUMN_DESCRIPTION,this.description);

        database.insert(SQLiteHelper.TABLE_RECIPES, null, values);
    }

    public static ArrayList<Recipe> getALL(Context context) {
        ArrayList<Recipe> recipes = new ArrayList<>();

        SQLiteHelper helper = new SQLiteHelper(context);
        SQLiteDatabase database = helper.getWritableDatabase();

        Cursor cursor = database.query("recipes",new String[]{"id","title","image","description"},null,null,null,null,null,null);
        cursor.moveToFirst();

        while (!cursor.isAfterLast()) {
            Recipe recipe = new Recipe();
            recipe.setId(cursor.getInt(0));
            recipe.setTitle(cursor.getString(1));
            recipe.setImage(cursor.getString(2));
            recipe.setDescription(cursor.getString(3));
            recipes.add(recipe);
            cursor.moveToNext();
        }

        return recipes;

    }

}
