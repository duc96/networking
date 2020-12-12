package com.example.gojobs.view.fragment;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.text.Html;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;

import com.example.gojobs.R;
import com.example.gojobs.adapter.CardAdapter;

import static com.example.gojobs.view.fragment.ProductFragment.listTam;


public class BillFragment extends Fragment {

    RecyclerView lv;
    ImageView imgBuy;
    CardAdapter cardAdapter;

    public static BillFragment newInstance() {
        BillFragment fragment = new BillFragment();
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_bill, container, false);
        lv = view.findViewById(R.id.lv_card_shop);
        imgBuy = view.findViewById(R.id.img_card_shop);

        System.out.println(listTam);

        cardAdapter = new CardAdapter(getContext(),listTam);
        lv.setAdapter(cardAdapter);
        lv.setLayoutManager(new LinearLayoutManager(getContext()));

        return view;
    }
}