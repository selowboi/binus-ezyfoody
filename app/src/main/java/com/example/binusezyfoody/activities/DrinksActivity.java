package com.example.binusezyfoody.activities;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.adapters.DrinksAdapter;
import com.example.binusezyfoody.models.Drink;

import java.util.Vector;

public class DrinksActivity extends AppCompatActivity implements DrinksAdapter.OnItemClickListener {

    Intent intent;
    Button btnMyOrder;
    RecyclerView rvDrinks;
    Vector<Drink> drinks = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drinks);
        initItems();
        initView();
        initAdapter();
        onClickButtonMyOrder();
    }

    private void initItems() {
        drinks.add(new Drink("Coca Cola", 7000, 10));
        drinks.add(new Drink("Pepsi", 8000, 20));
        drinks.add(new Drink("Sprite", 6000, 30));
    }

    private void initView() {
        rvDrinks = (RecyclerView) findViewById(R.id.drinks_rv_drinks);
        btnMyOrder = (Button) findViewById(R.id.drinks_btn_my_order);
    }

    private void initAdapter() {
        DrinksAdapter adapter = new DrinksAdapter(drinks);
        rvDrinks.setAdapter(adapter);
        rvDrinks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter.setOnItemClickListener(DrinksActivity.this);
    }

    private void onClickButtonMyOrder() {
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(DrinksActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public void onItemClick(int position) {
        Drink drink = drinks.get(position);
        Toast.makeText(getApplicationContext(), drink.getDrinkName(), Toast.LENGTH_SHORT).show();
    }
}