package com.example.khaireddine.e_market;


import android.content.Context;

import android.support.v7.widget.RecyclerView;

import android.view.LayoutInflater;

import android.view.View;

import android.view.ViewGroup;

import android.widget.ImageView;
import android.widget.TextView;


import java.util.LinkedList;
public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.ItemViewHolder>{

        private final LinkedList<String> mWordList;

        private final LayoutInflater mInflater;


        class ItemViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

            public final TextView nameItemView;
            public final TextView prixItemView;
            public final ImageView img;
            final RecyclerAdapter mAdapter;


            public ItemViewHolder(View itemView, RecyclerAdapter adapter) {

                super(itemView);

               nameItemView = (TextView) itemView.findViewById(R.id.name);
                prixItemView = (TextView) itemView.findViewById(R.id.name);
                img=(ImageView)itemView.findViewById(R.id.img) ;
                this.mAdapter = adapter;

                itemView.setOnClickListener(this);
            }


            @Override

            public void onClick(View v) {
                String name;
                String prix;
                name=nameItemView.getText().toString();
                prix=(prixItemView.getText().toString());
                Panier mapanier=new Panier();
                mapanier.add(name,prix);
            }
        }


        public RecyclerAdapter(Context context, LinkedList<String> wordList) {

            mInflater = LayoutInflater.from(context);

            this.mWordList = wordList;
        }


    @Override
    public ItemViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return null;
    }

    @Override
    public void onBindViewHolder(ItemViewHolder holder, int position) {

    }

    @Override

        public int getItemCount() {

            return mWordList.size();
        }
    }



