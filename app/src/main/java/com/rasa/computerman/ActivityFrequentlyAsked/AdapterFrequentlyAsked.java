package com.rasa.computerman.ActivityFrequentlyAsked;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.rasa.computerman.R;

public class AdapterFrequentlyAsked extends RecyclerView.Adapter<AdapterFrequentlyAsked.viewsFrequentlyAsked> {


    private PFrequentlyAsked pFrequentlyAsked;
    View view;

    public AdapterFrequentlyAsked(PFrequentlyAsked pFrequentlyAsked){

        this.pFrequentlyAsked = pFrequentlyAsked;
    }

    @NonNull
    @Override
    public viewsFrequentlyAsked onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(pFrequentlyAsked.getContext()).inflate(R.layout.view_frequently_asked,parent,false);
        return new viewsFrequentlyAsked(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewsFrequentlyAsked holder, int position) {
        pFrequentlyAsked.onBindViewHolderFrequentlyAsked(holder, position);
    }

    @Override
    public int getItemCount() {
        return pFrequentlyAsked.getArrCount();
    }

    public class viewsFrequentlyAsked extends RecyclerView.ViewHolder {

        ImageView imageView;
        TextView textviewTitleAsk;
        TextView textviewAnswer;
        RelativeLayout relativeLayout;


        public viewsFrequentlyAsked(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView_iconShow);
            textviewTitleAsk=itemView.findViewById(R.id.titleAsk);
            textviewAnswer=itemView.findViewById(R.id.textViewAnswer);
            relativeLayout=itemView.findViewById(R.id.relativeLayout_titleAsk);
        }
    }
}
