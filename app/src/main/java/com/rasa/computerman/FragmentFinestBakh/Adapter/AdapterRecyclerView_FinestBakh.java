package com.rasa.computerman.FragmentFinestBakh.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.FragmentFinestBakh.PFinestBakh;
import com.rasa.computerman.R;

public class AdapterRecyclerView_FinestBakh extends RecyclerView.Adapter<AdapterRecyclerView_FinestBakh.ViewsFinestBakh> {


    private PFinestBakh pFinestBakh;
    View view;

    public AdapterRecyclerView_FinestBakh(PFinestBakh pFinestBakh) {
        this.pFinestBakh = pFinestBakh;
    }

    @NonNull
    @Override
    public ViewsFinestBakh onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(pFinestBakh.getContext()).inflate(R.layout.views_finest_bakh,parent,false);
        return new ViewsFinestBakh(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewsFinestBakh holder, int position) {

        pFinestBakh.onBindViewHolderFinestBakh(holder, position);
    }

    @Override
    public int getItemCount() {

            return pFinestBakh.getArrCount_extraFinestBakh();

    }

    public class ViewsFinestBakh extends RecyclerView.ViewHolder{

        public ImageView imageView_finestBakh;
        public TextView textView_title_finestBakh;
        public TextView textView_titleGroup_finestBakh;
        public TextView textView_registerDate;


        public ViewsFinestBakh(View itemView) {
            super(itemView);
            imageView_finestBakh=itemView.findViewById(R.id.imageView_finestBakh);
            textView_title_finestBakh=itemView.findViewById(R.id.title_finestBakh);
            textView_titleGroup_finestBakh=itemView.findViewById(R.id.titleGroup_finestBakh);
            textView_registerDate=itemView.findViewById(R.id.registerDate);
        }
    }
}
