package com.rasa.computerman.FragmentVideoPlayer;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.R;

public class AdapterRecyclerview_videoPlayer extends RecyclerView.Adapter<AdapterRecyclerview_videoPlayer.itemDefaultVideo> {



    View itemDefaultView;
    private PVideoPlayer pVideoPlayer;


    public AdapterRecyclerview_videoPlayer(PVideoPlayer pVideoPlayer ) {

        this.pVideoPlayer = pVideoPlayer;
    }

    @NonNull
    @Override
    public itemDefaultVideo onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {


                itemDefaultView=LayoutInflater.from(pVideoPlayer.getContext()).inflate(R.layout.video_list,parent,false);

                return new itemDefaultVideo(itemDefaultView);


    }

    @Override
    public void onBindViewHolder(@NonNull itemDefaultVideo holder, int position) {

            pVideoPlayer.onBindViewHolder_getMedia_itemDefault(holder,position);

    }

    @Override
    public int getItemCount() {
        return pVideoPlayer.getArrCount_group();
    }





    public class itemDefaultVideo extends RecyclerView.ViewHolder{

        ImageView imageView_list;
        TextView textview_title_list;
        TextView textview_description_list;
        TextView textView_visite_list;
        TextView textview_visite_count;
        ImageView imageview_more_videoPlayer;



        public itemDefaultVideo(View itemView) {
            super(itemView);

            imageView_list=itemView.findViewById(R.id.imageView_list);
            textview_title_list=itemView.findViewById(R.id.textview_title_list);
            textview_description_list=itemView.findViewById(R.id.textview_description_list);
            textView_visite_list=itemView.findViewById(R.id.textView_visite_list);
            textview_visite_count=itemView.findViewById(R.id.textview_visite_count);
            imageview_more_videoPlayer=itemView.findViewById(R.id.imageview_more_videoPlayer);


        }
    }
}
