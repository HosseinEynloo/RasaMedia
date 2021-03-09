package com.rasa.computerman.Home;

import android.content.Context;
import android.view.View;

import com.rasa.computerman.Home.Adapter.AdapterRecyclerViewGroupChannels;
import com.rasa.computerman.WebService.Groups.Model.Extra_groups;
import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;
import com.squareup.picasso.Picasso;

public class PHomePage implements iPHomePage {


    MHomePage mHomePage;

    private iVHomePage iVHomePage;

    public PHomePage(iVHomePage iVHomePage) {
        this.iVHomePage = iVHomePage;

        mHomePage = new MHomePage(this);
    }


    @Override
    public void onSuccessGetGroup(ResponseGroups groups) {
        iVHomePage.onSuccessGetGroup(groups);
    }

    @Override
    public void onFailedGetGroup(int errorId, String ErrorMessage) {

        iVHomePage.onFailedGetGroup(errorId, ErrorMessage);
    }

    @Override
    public Context getContext() {
        return iVHomePage.getContext();
    }

    @Override
    public void sendRequest_getGroup() {
        mHomePage.sendRequest_getGroup();
    }

    @Override
    public int getArrCount_GroupChannel() {
        return mHomePage.getArrCount_GroupChannel();
    }

    @Override
    public Extra_groups getChaildAt_GroupChannel(int position) {
        return mHomePage.getChaildAt_GroupChannel(position);
    }

    @Override
    public void onBindViewHolder_GroupChannel(final AdapterRecyclerViewGroupChannels.ViewsChannel holder, final int position) {

        Picasso.with(getContext()).load(getChaildAt_GroupChannel(position).getImageUrl()).into(holder.imageView);
        holder.textView.setText(getChaildAt_GroupChannel(position).getTitle());

        //در ابتدا جزییات کانال اول را به صورت پیش فرض نمایش بده
        if (position==0){
            iVHomePage.onSelectId(getChaildAt_GroupChannel(0).getId());
        }

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                iVHomePage.onSelectId(getChaildAt_GroupChannel(position).getId());



            }
        });


    }


}
