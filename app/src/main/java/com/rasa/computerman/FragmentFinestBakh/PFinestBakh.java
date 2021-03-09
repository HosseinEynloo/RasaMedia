package com.rasa.computerman.FragmentFinestBakh;

import android.content.Context;
import android.content.Intent;
import android.view.View;

import com.rasa.computerman.ActivityVideoPlayer;
import com.rasa.computerman.FragmentFinestBakh.Adapter.AdapterRecyclerView_FinestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.Extra_finestBakh;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;
import com.squareup.picasso.Picasso;

public class PFinestBakh implements iP_finestBakh {


    private com.rasa.computerman.FragmentFinestBakh.iV_finestBakh iV_finestBakh;
    MFinestBakh mFinestBakh;

    public PFinestBakh(iV_finestBakh iV_finestBakh) {
        this.iV_finestBakh = iV_finestBakh;
        mFinestBakh = new MFinestBakh(this);
    }

    @Override
    public Context getContext() {
        return iV_finestBakh.getContext();
    }

    @Override
    public void sendRequestForGetFinestBakh() {

        mFinestBakh.sendRequestForGetFinestBakh();
    }

    @Override
    public void onBindViewHolderFinestBakh(AdapterRecyclerView_FinestBakh.ViewsFinestBakh holder, final int position) {
        Picasso.with(getContext()).load(getChild_extraFinestBakh(position).getImageUrl()).into(holder.imageView_finestBakh);
        holder.textView_title_finestBakh.setText(getChild_extraFinestBakh(position).getTitle());
        holder.textView_titleGroup_finestBakh.setText(getChild_extraFinestBakh(position).getGroups().get(0).getTitle());
        holder.textView_registerDate.setText(getChild_extraFinestBakh(position).getRegisterDate());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getContext(), ActivityVideoPlayer.class);
                intent.putExtra("id", getChild_extraFinestBakh(position).getId());
                getContext().startActivity(intent);
            }
        });


    }

    @Override
    public int getArrCount_extraFinestBakh() {
        return mFinestBakh.getArrCount_extraFinestBakh();
    }

    @Override
    public Extra_finestBakh getChild_extraFinestBakh(int position) {
        return mFinestBakh.getChild_extraFinestBakh(position);
    }

    @Override
    public void onSuccessGetFinestBakh(ResponseFinestBakh finestBakh) {

        iV_finestBakh.onSuccessGetFinestBakh(finestBakh);
    }

    @Override
    public void onFailedGetFinestBakh(int errorId, String ErrorMessage) {

        iV_finestBakh.onFailedGetFinestBakh(errorId, ErrorMessage);
    }


}
