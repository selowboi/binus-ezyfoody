package com.example.binusezyfoody.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.models.Drink;

public class MainActivity extends AppCompatActivity {

    Intent intent;
    Button btnDrinks, btnSnacks, btnFoods, btnTopUp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        onClickButtonDrinks();
        onClickButtonFoods();
        onClickButtonSnacks();
        onClickButtonTopUp();
    }

    private void initView() {
        btnDrinks = (Button) findViewById(R.id.main_btn_drinks);
        btnSnacks = (Button) findViewById(R.id.main_btn_snacks);
        btnFoods = (Button) findViewById(R.id.main_btn_foods);
        btnTopUp = (Button) findViewById(R.id.main_btn_topup);
    }

    private void onClickButtonDrinks() {
        btnDrinks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MainActivity.this, DrinksActivity.class);
                startActivity(intent);
            }
        });
    }

    private void onClickButtonSnacks() {
        btnSnacks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, this menu is unavailable yet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onClickButtonFoods() {
        btnFoods.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, this menu is unavailable yet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void onClickButtonTopUp() {
        btnTopUp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(), "Sorry, this menu is unavailable yet!", Toast.LENGTH_SHORT).show();
            }
        });
    }

}