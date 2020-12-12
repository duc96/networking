package com.example.gojobs.adapter;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.gojobs.R;
import com.example.gojobs.modal.Product;

import java.util.ArrayList;

import static com.example.gojobs.view.fragment.ProductFragment.listTam;

public class CardAdapter extends RecyclerView.Adapter<CardAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Product> list;

    public CardAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.row_item_card, parent, false);
        final ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Product product = list.get(position);

        holder.tvNameProduct.setText(product.getName());
        holder.tvPriceProduct.setText(product.getPrice());

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView tvNameProduct;
        private TextView tvPriceProduct;
        private ImageView imgDelete;


        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvNameProduct = itemView.findViewById(R.id.tv_name_product);
            tvPriceProduct = itemView.findViewById(R.id.tv_price_product);
            imgDelete = itemView.findViewById(R.id.img_delete_card);
        }
    }
}
