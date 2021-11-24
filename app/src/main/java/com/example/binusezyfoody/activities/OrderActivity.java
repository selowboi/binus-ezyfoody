package com.example.binusezyfoody.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.binusezyfoody.R;

public class OrderActivity extends AppCompatActivity {

    Intent intent;
    TextView tvName, tvPrice, tvTotal;
    EditText etQuantity;
    Button btnMyOrder, btnOrderMore;
    String drinkName, drinkPrice;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);
        intent = getIntent();
        drinkName = intent.getStringExtra("DRINK_NAME");
        drinkPrice = intent.getStringExtra("DRINK_PRICE");
        initView();
        tvName.setText(drinkName);
        tvPrice.setText("Rp. " + drinkPrice);
        onClickButtonMyOrder();
        onClickButtonOrderMore();
    }

    private void initView() {
        tvName = (TextView) findViewById(R.id.order_tv_name);
        tvPrice = (TextView) findViewById(R.id.order_tv_price);
        tvTotal = (TextView) findViewById(R.id.order_tv_total);
        etQuantity = (EditText) findViewById(R.id.order_et_quantity);
        btnMyOrder = (Button) findViewById(R.id.order_btn_my_order);
        btnOrderMore = (Button) findViewById(R.id.order_btn_order);
    }

    private void onClickButtonMyOrder() {
        btnMyOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderActivity.this, MyOrderActivity.class);
                startActivity(intent);
            }
        });
    }

    private void onClickButtonOrderMore() {
        btnOrderMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intent = new Intent(OrderActivity.this, DrinksActivity.class);
                startActivity(intent);
            }
        });
    }
}