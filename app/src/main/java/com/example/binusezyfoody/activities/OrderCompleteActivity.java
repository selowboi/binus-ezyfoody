package com.example.binusezyfoody.activities;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.adapters.OrderCompleteAdapter;
import com.example.binusezyfoody.models.Drink;

import java.util.Vector;

public class OrderCompleteActivity extends AppCompatActivity {

    Button btnMainMenu;
    TextView tvTotal, tvQuantity, tvName, tvPrice;
    RecyclerView rvOrderComplete;
    OrderCompleteAdapter adapter;
    Intent intent;
    Vector<Drink> drinks = new Vector<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_complete);
        initItems();
        initView();
        initAdapter();
        onClickButtonMainMenu();
    }

    private void initItems() {
        drinks.add(new Drink("Coca Cola", 7000, 10));
        drinks.add(new Drink("Pepsi", 8000, 20));
        drinks.add(new Drink("Sprite", 6000, 30));
    }

    private void initView() {
        btnMainMenu = (Button) findViewById(R.id.order_complete_btn_main_menu);
        rvOrderComplete = (RecyclerView) findViewById(R.id.order_complete_rv_order);
        tvTotal = (TextView) findViewById(R.id.order_complete_tv_total);
        tvName = (TextView) findViewById(R.id.order_complete_item_tv_name);
        tvPrice = (TextView) findViewById(R.id.order_complete_item_tv_price);
        tvQuantity = (TextView) findViewById(R.id.order_complete_item_tv_quantity);
    }

    private void initAdapter() {
        adapter = new OrderCompleteAdapter(drinks);
        rvOrderComplete.setAdapter(adapter);
        rvOrderComplete.setLayoutManager(new LinearLayoutManager(getApplicationContext()));
    }

    private void onClickButtonMainMenu() {
        btnMainMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderCompleteActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

}