package com.example.binusezyfoody.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.adapters.MyOrderAdapter;
import com.example.binusezyfoody.models.Drink;

import java.util.Vector;

public class MyOrderActivity extends AppCompatActivity implements MyOrderAdapter.OnItemClickListener{

    Button btnDelete, btnPayNow;
    TextView tvTotal, tvPrice, tvName, tvQuantity;
    RecyclerView rvDrinks;
    Vector<Drink> drinks = new Vector<>();
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_order);
        initItems();
        initView();
        initAdapter();
        onClickButtonPayNow();
    }

    private void initItems() {
        drinks.add(new Drink("Coca Cola", 7000, 10));
        drinks.add(new Drink("Pepsi", 8000, 20));
        drinks.add(new Drink("Sprite", 6000, 30));
    }

    private void initView() {
        rvDrinks = (RecyclerView) findViewById(R.id.my_order_rv_drinks);
        tvTotal = (TextView) findViewById(R.id.my_order_tv_total);
        tvName = (TextView) findViewById(R.id.my_order_item_tv_name);
        tvPrice = (TextView) findViewById(R.id.my_order_item_tv_price);
        tvQuantity = (TextView)  findViewById(R.id.my_order_item_tv_quantity);
        btnDelete = (Button) findViewById(R.id.my_order_item_btn_delete);
        btnPayNow = (Button) findViewById(R.id.my_order_btn_pay_now);;
    }

    private void onClickButtonPayNow() {
        btnPayNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(MyOrderActivity.this, OrderCompleteActivity.class);
                startActivity(intent);
            }
        });
    }

    private void initAdapter() {
        MyOrderAdapter adapter = new MyOrderAdapter(drinks);
        rvDrinks.setAdapter(adapter);
        rvDrinks.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
        adapter.setOnItemClickListener(MyOrderActivity.this);
    }

    @Override
    public void onItemClick(int position) {
        Drink drink = drinks.get(position);
        Toast.makeText(getApplicationContext(), drink.getDrinkName(), Toast.LENGTH_SHORT).show();
    }
}