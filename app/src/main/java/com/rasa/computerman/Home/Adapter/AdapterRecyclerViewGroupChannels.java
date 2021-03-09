package com.rasa.computerman.Home.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.Home.PHomePage;
import com.rasa.computerman.R;

public class AdapterRecyclerViewGroupChannels extends RecyclerView.Adapter<AdapterRecyclerViewGroupChannels.ViewsChannel> {

    View view;
    private PHomePage pHomePage;


    public AdapterRecyclerViewGroupChannels(PHomePage pHomePage) {

        this.pHomePage = pHomePage;
    }

    @NonNull
    @Override
    public ViewsChannel onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(pHomePage.getContext()).inflate(R.layout.channels,parent,false);
        return new ViewsChannel(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewsChannel holder, int position) {

        pHomePage.onBindViewHolder_GroupChannel(holder, position);

    }

    @Override
    public int getItemCount() {
        return pHomePage.getArrCount_GroupChannel();
    }

    public class ViewsChannel extends RecyclerView.ViewHolder{

        public ImageView imageView;
        public TextView textView;

        public ViewsChannel(View itemView) {
            super(itemView);
            imageView=itemView.findViewById(R.id.imageview_channel);
            textView=itemView.findViewById(R.id.textview_channel);
        }
    }
}
