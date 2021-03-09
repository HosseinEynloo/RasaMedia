package com.rasa.computerman.FragmentDetailChannel.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.FragmentDetailChannel.PDetailChannel;
import com.rasa.computerman.R;

public class AdapterRecyclerViewDetailItemDefault extends RecyclerView.Adapter<AdapterRecyclerViewDetailItemDefault.viewsItemDefault> {

    private PDetailChannel pDetailChannel;
    private int parentposition;
    View view;

    public AdapterRecyclerViewDetailItemDefault(PDetailChannel pDetailChannel,int position) {
        this.pDetailChannel = pDetailChannel;
        this.parentposition=position;

    }

    @NonNull
    @Override
    public viewsItemDefault onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(pDetailChannel.getContext()).inflate(R.layout.views_item_default,parent,false);
        return new viewsItemDefault(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewsItemDefault holder, int position) {

        pDetailChannel.onBindViewHolder_viewItemDefault(holder,parentposition,position);

    }

    @Override
    public int getItemCount() {
        return pDetailChannel.getArrCount_detailItemDefault(parentposition);
    }

    public class viewsItemDefault extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView title_textView;
        public TextView description_textView;
        public TextView defaultVisite;



        public viewsItemDefault(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageView_detailChannel_itemDefault);
            title_textView=itemView.findViewById(R.id.textView_title);
            description_textView=itemView.findViewById(R.id.textview_discription);
            defaultVisite=itemView.findViewById(R.id.DefaultVisit);
        }
    }
}
