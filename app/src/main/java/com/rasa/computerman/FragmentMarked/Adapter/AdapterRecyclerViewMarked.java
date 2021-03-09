package com.rasa.computerman.FragmentMarked.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.FragmentMarked.PMarked;
import com.rasa.computerman.R;

public class AdapterRecyclerViewMarked extends RecyclerView.Adapter<AdapterRecyclerViewMarked.viewsMarked> {


    private PMarked pMarked;
    View view;

    public AdapterRecyclerViewMarked(PMarked pMarked) {
        this.pMarked = pMarked;
    }

    @NonNull
    @Override
    public viewsMarked onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(pMarked.getContext()).inflate(R.layout.views_marked,parent,false);
        return new viewsMarked(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewsMarked holder, int position) {

        pMarked.onBindViewHolderMarked(holder, position);

    }

    @Override
    public int getItemCount() {
        return pMarked.getArrCountGetMarked();
    }

    public class viewsMarked extends RecyclerView.ViewHolder{

        public ImageView imageView_marked;
        public TextView textView_title_marked;
        public TextView textView_titleGroup_marked;
        public TextView textView_registerDate_marked;


        public viewsMarked(View itemView) {
            super(itemView);
            imageView_marked=itemView.findViewById(R.id.imageView_marked);
            textView_title_marked=itemView.findViewById(R.id.title_marked);
            textView_titleGroup_marked=itemView.findViewById(R.id.titleGroup_marked);
            textView_registerDate_marked=itemView.findViewById(R.id.registerDate_marked);
        }
    }
}
