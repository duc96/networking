package com.example.gojobs.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.gojobs.R;
import com.example.gojobs.adapter.ProductAdapter;
import com.example.gojobs.modal.Product;

import java.util.ArrayList;

public class ProductFragment extends Fragment {

    private RecyclerView rcvProduct;
    public static ArrayList<Product> list;
    private ProductAdapter productAdapter;
    public static ArrayList<Product> listTam = new ArrayList<>();
    public static ProductFragment newInstance() {

        ProductFragment fragment = new ProductFragment();
        list = new ArrayList<>();
        String name = "H2R";
        String category = "kawasaki 1000cc";
        String price = "1000$";
        int yearManufacture = 2010;

        Product product = new Product(name,category,price,yearManufacture);
        for (int i = 0; i < 10; i ++){
            list.add(product);
        }
        return fragment;

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_product, container, false);

        ProductFragment.newInstance();

        rcvProduct = view.findViewById(R.id.rcv_product);

        productAdapter = new ProductAdapter(getContext(),list);

        rcvProduct.setAdapter(productAdapter);

        rcvProduct.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}