package com.akashyadav.kindredassignment;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }
     public void shp(View view){
         Intent intent = new Intent(MainActivity.this, firstScreen.class);
         startActivity(intent);

   }    public void img(View view){
         Intent intent = new Intent(MainActivity.this, secondScreen.class);
         startActivity(intent);

   }
}
