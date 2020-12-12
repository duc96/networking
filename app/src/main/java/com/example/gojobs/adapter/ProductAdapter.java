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

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ViewHolder> {

    private Context context;
    private ArrayList<Product> list;

    public ProductAdapter(Context context, ArrayList<Product> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View productView = inflater.inflate(R.layout.row_item_product, parent, false);
        final ViewHolder viewHolder = new ViewHolder(productView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewHolder holder, int position) {

        Product product = list.get(position);
        holder.tvNameProduct.setText(product.getName());
        holder.tvCategoryProduct.setText(product.getCategory());
        holder.tvPriceProduct.setText(product.getPrice());
        holder.tvYearManufactureProduct.setText(product.getYearManufacture()+"");

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                AlertDialog.Builder builder = new AlertDialog.Builder(context);
                builder.setTitle("Add this to card !")
                        .setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {

                            }
                        })
                        .setPositiveButton("Add to card", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialogInterface, int i) {
                                String name = holder.tvNameProduct.getText().toString();
                                String price = holder.tvPriceProduct.getText().toString();

                                Product pd = new Product(name,price);
                                listTam.add(pd);
                            }
                        })
                        .show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgProduct;
        private TextView tvNameProduct;
        private TextView tvYearManufactureProduct;
        private TextView tvPriceProduct;
        private TextView tvCategoryProduct;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imgProduct = itemView.findViewById(R.id.img_product);
            tvNameProduct = itemView.findViewById(R.id.tv_name_product);
            tvCategoryProduct = itemView.findViewById(R.id.tv_category_product);
            tvPriceProduct = itemView.findViewById(R.id.tv_price_product);
            tvYearManufactureProduct = itemView.findViewById(R.id.tv_year_product);
        }
    }
}
