package com.example.binusezyfoody.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.models.Drink;

import java.util.Vector;

public class OrderCompleteAdapter extends RecyclerView.Adapter<OrderCompleteAdapter.ViewHolder>{

    Vector<Drink> drinks;

    public OrderCompleteAdapter(Vector<Drink> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public OrderCompleteAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(
                R.layout.activity_order_complete_item,
                parent,
                false
        );
        return new OrderCompleteAdapter.ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull OrderCompleteAdapter.ViewHolder holder, int position) {
        Drink drink = drinks.get(position);

        TextView tvName = holder.tvName;
        TextView tvPrice = holder.tvPrice;
        TextView tvQuantity = holder.tvQuantity;

        tvName.setText(drink.getDrinkName());
        tvPrice.setText("Rp. " + String.valueOf(drink.getDrinkPrice()));
        tvQuantity.setText(String.valueOf(drink.getDrinkQuantity()));
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvQuantity, tvName, tvPrice;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.order_complete_item_tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.order_complete_item_tv_price);
            tvQuantity = (TextView) itemView.findViewById(R.id.order_complete_item_tv_quantity);
        }
    }
}
