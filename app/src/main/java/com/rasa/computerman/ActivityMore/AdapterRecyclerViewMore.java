package com.rasa.computerman.ActivityMore;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.ActivityVideoPlayer;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.GetMediaSubGroupByMainGroupId.Model.Media;
import com.squareup.picasso.Picasso;

import java.util.List;

public class AdapterRecyclerViewMore extends RecyclerView.Adapter<AdapterRecyclerViewMore.viewsMore> {


    private Context context;
    private List<Media> mediaList;
    View view;

    public AdapterRecyclerViewMore(Context context, List<Media> mediaList) {
        this.context = context;
        this.mediaList = mediaList;
    }

    @NonNull
    @Override
    public viewsMore onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(context).inflate(R.layout.views_more,parent,false);
        return new viewsMore(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewsMore holder, final int position) {

        Picasso.with(context).load(mediaList.get(position).getImageUrl()).into(holder.imageViewMoreList);
        holder.textViewTitleMoreList.setText(mediaList.get(position).getTitle());
        holder.textViewDiscriptionMoreList.setText(mediaList.get(position).getDescription());
        holder.textViewRegisterDateMoreList.setText(mediaList.get(position).getRegisterDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(context, ActivityVideoPlayer.class);
                intent.putExtra("id",mediaList.get(position).getId());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return mediaList.size();
    }

    public class viewsMore extends RecyclerView.ViewHolder{

        ImageView imageViewMoreList;
        TextView textViewTitleMoreList;
        TextView textViewDiscriptionMoreList;
        TextView textViewRegisterDateMoreList;

        public viewsMore(View itemView) {
            super(itemView);
            imageViewMoreList=itemView.findViewById(R.id.imageViewMoreList);
            textViewTitleMoreList=itemView.findViewById(R.id.textViewTitleMoreList);
            textViewRegisterDateMoreList=itemView.findViewById(R.id.textViewRegisterDateMoreList);
            textViewDiscriptionMoreList=itemView.findViewById(R.id.textViewDiscriptionMoreList);

        }
    }
}
