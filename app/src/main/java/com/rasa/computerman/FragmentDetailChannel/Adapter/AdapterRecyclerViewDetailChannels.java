package com.rasa.computerman.FragmentDetailChannel.Adapter;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.FragmentDetailChannel.PDetailChannel;
import com.rasa.computerman.R;

public class AdapterRecyclerViewDetailChannels extends RecyclerView.Adapter<RecyclerView.ViewHolder> {



    private static final int bannerItem=0;
    private static final int defaultItem=1;
    private PDetailChannel pDetailChannel;

    public AdapterRecyclerViewDetailChannels(PDetailChannel pDetailChannel) {

        this.pDetailChannel = pDetailChannel;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        switch (viewType){
           case bannerItem:
                View viewBanner= LayoutInflater.from(pDetailChannel.getContext()).inflate(R.layout.views_holder_recyclerview,parent,false);
                return new viewsHolderBanner(viewBanner);

            case defaultItem:
                View viewItemDefault= LayoutInflater.from(pDetailChannel.getContext()).inflate(R.layout.views_recyclerview_item_channel,parent,false);
                return new viewsHolderItem(viewItemDefault);

                default:
                    return null;
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

       if (holder instanceof viewsHolderBanner){
           viewsHolderBanner viewsHolderBanner= (AdapterRecyclerViewDetailChannels.viewsHolderBanner) holder;
           pDetailChannel.onBindViewHolder_banner(viewsHolderBanner, position);
       }else if (holder instanceof viewsHolderItem){
           viewsHolderItem viewsHolderItem= (AdapterRecyclerViewDetailChannels.viewsHolderItem) holder;
           pDetailChannel.onBindViewHolder_itemDefault(viewsHolderItem, position);
       }


    }

    @Override
    public int getItemCount() {
        Log.i("hhh", "getItemCount: "+pDetailChannel.getArrCount_MainList());
        return pDetailChannel.getArrCount_MainList();

    }

    @Override
    public int getItemViewType(int position) {
        Log.d("TAG", "getItemViewType: "+pDetailChannel.getItemType(position));
        if (pDetailChannel.getItemType(position)==bannerItem){
            return bannerItem;
        }else {
            return defaultItem;
        }

    }

    public class viewsHolderBanner extends RecyclerView.ViewHolder{

        public RecyclerView recyclerView_banner;

        public viewsHolderBanner(View itemView) {
            super(itemView);
            recyclerView_banner =itemView.findViewById(R.id.recyclerview_viewAdapter);
        }
    }

    public class viewsHolderItem extends RecyclerView.ViewHolder{

        public RecyclerView recyclerView_defaultItem;
        public TextView MainTitle;
        public TextView textViewMore;
        public ImageView imageViewMore;


        public viewsHolderItem(View itemView) {
            super(itemView);
            recyclerView_defaultItem =itemView.findViewById(R.id.recyclerview_itemChannel);
            MainTitle=itemView.findViewById(R.id.textViewMainTitle);
            textViewMore=itemView.findViewById(R.id.textView_more);
            imageViewMore=itemView.findViewById(R.id.imageView_more);
        }
    }
}
