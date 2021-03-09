package com.rasa.computerman.FragmentNews;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.rasa.computerman.ActivityVideoPlayer;
import com.rasa.computerman.WebService.Medias.New.Model.Extra_new;
import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;
import com.squareup.picasso.Picasso;

public class PNew implements iP_new{

    MNew mNew;
    private com.rasa.computerman.FragmentNews.iV_new iV_new;

    public PNew(iV_new iV_new) {
        this.iV_new = iV_new;
        mNew=new MNew(this);
    }

    @Override
    public void sendRequestForGetNew() {

        mNew.sendRequestForGetNew();
    }

    @Override
    public void onSuccessGetNew(ResponseNew responseNew) {

        iV_new.onSuccessGetNew(responseNew);
    }

    @Override
    public void onFailedGetNew(int errorId, String ErrorMessage) {

        iV_new.onFailedGetNew(errorId, ErrorMessage);
    }

    @Override
    public Context getContext() {
        return iV_new.getContext();
    }

    @Override
    public void onBindViewHolder_new(final AdapterRecyclerView_New.viewsNewItem holder, final int position) {
        holder.title_newItem.setText(getChildGetNew(position).getTitle());
        holder.visibility_newItem.setText(getChildGetNew(position).getDefaultVisit()+"");
        holder.discriptionItemNew.setText(getChildGetNew(position).getDescription()+"");
        Picasso.with(getContext()).load(getChildGetNew(position).getImageUrl()).into(holder.imageView_newItem);


        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getContext(), ActivityVideoPlayer.class);
                intent.putExtra("id",getChildGetNew(position).getId());
                getContext().startActivity(intent);




            }
        });
    }

    @Override
    public int getArrCount_NewItem() {
        return mNew.getArrCount_NewItem();
    }

    @Override
    public Extra_new getChildGetNew(int position) {
        return mNew.getChildGetNew(position);
    }
}
