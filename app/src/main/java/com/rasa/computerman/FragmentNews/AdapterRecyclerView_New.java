package com.rasa.computerman.FragmentNews;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.rasa.computerman.R;

public class AdapterRecyclerView_New extends RecyclerView.Adapter<AdapterRecyclerView_New.viewsNewItem> {

    private PNew pNew;
    View view;

    public AdapterRecyclerView_New(PNew pNew) {
        this.pNew = pNew;
    }

    @NonNull
    @Override
    public viewsNewItem onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        view= LayoutInflater.from(pNew.getContext()).inflate(R.layout.view_new,parent,false);
        return new viewsNewItem(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewsNewItem holder, int position) {

        pNew.onBindViewHolder_new(holder,position);

    }

    @Override
    public int getItemCount() {
        return pNew.getArrCount_NewItem();
    }

    public class viewsNewItem extends RecyclerView.ViewHolder{

        public TextView title_newItem;
        public TextView discriptionItemNew;
        public TextView visibility_newItem;
        public ImageView imageView_newItem;


        public viewsNewItem(View itemView) {
            super(itemView);

            title_newItem=itemView.findViewById(R.id.title_newItem);
            discriptionItemNew=itemView.findViewById(R.id.TextView_discription_newItem);
            visibility_newItem=itemView.findViewById(R.id.defaultVisit_newItem);
            imageView_newItem=itemView.findViewById(R.id.imageView_newItem);

        }
    }
}
