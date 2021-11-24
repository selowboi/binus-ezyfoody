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

public class MyOrderAdapter extends RecyclerView.Adapter<MyOrderAdapter.ViewHolder> {

    Vector<Drink> drinks;

    private MyOrderAdapter.OnItemClickListener mListener;

    public interface OnItemClickListener {
        void onItemClick(int position);
    }

    public void setOnItemClickListener(MyOrderAdapter.OnItemClickListener listener){
        mListener = listener;
    }


    public MyOrderAdapter(Vector<Drink> drinks) {
        this.drinks = drinks;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(
                R.layout.activity_my_order_item,
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
        TextView tvQuantity = holder.tvQuantity;
        Button btnDelete = holder.btnDelete;

        tvName.setText(drink.getDrinkName());
        tvPrice.setText("Rp. " + String.valueOf(drink.getDrinkPrice()));
        tvQuantity.setText(String.valueOf(drink.getDrinkQuantity()));
        btnDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Context mContext = v.getContext();
                Toast.makeText(mContext, "Item has been deleted!", Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return drinks.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{

        public TextView tvName, tvPrice, tvQuantity;
        public Button btnDelete;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvName = (TextView) itemView.findViewById(R.id.my_order_item_tv_name);
            tvPrice = (TextView) itemView.findViewById(R.id.my_order_item_tv_price);
            tvQuantity = (TextView) itemView.findViewById(R.id.my_order_item_tv_quantity);
            btnDelete = (Button) itemView.findViewById(R.id.my_order_item_btn_delete);

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
