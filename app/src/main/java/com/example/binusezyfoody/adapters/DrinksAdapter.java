package com.example.binusezyfoody.adapters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.binusezyfoody.R;
import com.example.binusezyfoody.activities.OrderActivity;
import com.example.binusezyfoody.models.Drink;

import java.util.Vector;

public class DrinksAdapter extends RecyclerView.Adapter<DrinksAdapter.ViewHolder> {

    Vector<Drink> drinks;

    private OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public DrinksAdapter(Vector<Drink> drinks) {
        this.drinks = drinks;
    }

    public void setOnItemClickListener(OnItemClickListener listener){
        mListener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(
                R.layout.activity_drinks_item,
                parent,
                false
        );
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        Drink drink = drinks.get(position);

        TextView tvName = holder.tvName;
        TextView tvPrice = holder.tvPrice;
        Button btnBuy = holder.btnBuy;

        tvName.setText(drink.getDrinkName());
        tvPrice.setText("Rp. " + String.valueOf(drink.getDrinkPrice()));
        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Intent intent = new Intent(mContext, OrderActivity.class);
                intent.putExtra("DRINK_NAME", drink.getDrinkName());
                intent.putExtra("DRINK_PRICE", String.valueOf(drink.getDrinkPrice()));
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName, tvPrice;
        public Button btnBuy;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.drinks_item_tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.drinks_item_tv_price);
            btnBuy = (Button) itemView.findViewById(R.id.drinks_item_btn_buy);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if(mListener != null){
                        int position = getAdapterPosition();
                        if(position != RecyclerView.NO_POSITION){
                            mListener.onItemClick(position);
                        }
                    }
                }
            });
        }
    }
}
