package com.rasa.computerman.Home;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rasa.customfontviews.CustomFontTextView;
import com.rasa.computerman.FragmentDetailChannel.FragmentDetailChannel;
import com.rasa.computerman.FragmentVideoPlayer.Fragment_videoPlayer;
import com.rasa.computerman.Home.Adapter.AdapterRecyclerViewGroupChannels;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Groups.Model.ResponseGroups;

public class fragment_homePage extends Fragment implements iVHomePage, Fragment_videoPlayer.OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER

    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerViewGroupChannel;
    FrameLayout frameLayout_detailChannel;
    View view;
    PHomePage pHomePage;
    RelativeLayout relativeLayout;
    ProgressBar progressBar;
    SwipeRefreshLayout swipRefreshLayuoytHome;
    CoordinatorLayout coordinatorLayout;
    Snackbar snackbar;
    Button btnRetry;
    CustomFontTextView textPlaseWait;




    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public fragment_homePage() {
        // Required empty public constructor
    }

    public static fragment_homePage newInstance(String param1, String param2) {
        fragment_homePage fragment = new fragment_homePage();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.home_page, container, false);
        init();

            pHomePage.sendRequest_getGroup();




        Log.d("frgis", "onCreateView: ");
        return view;
    }

    private void init() {

        pHomePage = new PHomePage(this);
        recyclerViewGroupChannel = view.findViewById(R.id.recyclerView_GroupChannel);
        frameLayout_detailChannel = view.findViewById(R.id.frameLayout_detailChannel);
        relativeLayout = view.findViewById(R.id.relativeLayout_progressBarHome);
        progressBar = view.findViewById(R.id.progressBar_fragmentHome);
        swipRefreshLayuoytHome=view.findViewById(R.id.swipRefreshLayuoytHome);
        coordinatorLayout=view.findViewById(R.id.coordinatorLayoutHome);
        btnRetry=view.findViewById(R.id.btnRetry);
        textPlaseWait=view.findViewById(R.id.textPlaseWait);



        swipRefreshLayuoytHome.setColorSchemeColors(ResourcesCompat.getColor(getResources(),R.color.colorPrimary,null),ResourcesCompat.getColor(getResources(),R.color.colorAccent,null));

        swipRefreshLayuoytHome.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipRefreshLayuoytHome.setRefreshing(true);

                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        pHomePage.sendRequest_getGroup();
                        swipRefreshLayuoytHome.setRefreshing(false);
                        if (snackbar!=null){
                            snackbar.dismiss();
                        }
                    }
                },2500);



            }
        });

        btnRetry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                relativeLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                textPlaseWait.setVisibility(View.VISIBLE);
                pHomePage.sendRequest_getGroup();
            }
        });
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessGetGroup(ResponseGroups groups) {

        if (mListener!=null) {
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            textPlaseWait.setVisibility(View.GONE);
            btnRetry.setVisibility(View.GONE);
            recyclerViewGroupChannel.setVisibility(View.VISIBLE);


            AdapterRecyclerViewGroupChannels adapterRecyclerViewGroupChannels = new AdapterRecyclerViewGroupChannels(pHomePage);
            recyclerViewGroupChannel.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.HORIZONTAL, false));
            recyclerViewGroupChannel.setAdapter(adapterRecyclerViewGroupChannels);
        }

    }

    @Override
    public void onFailedGetGroup(int errorId, String ErrorMessage) {
        if (mListener != null) {
            Toast.makeText(getContext(), ""+ErrorMessage, Toast.LENGTH_SHORT).show();
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            textPlaseWait.setVisibility(View.GONE);

            btnRetry.setVisibility(View.VISIBLE);



//            snackbar=Snackbar.make(coordinatorLayout,""+ErrorMessage,Snackbar.LENGTH_INDEFINITE);
//            snackbar.setAction("retry", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pHomePage.sendRequest_getGroup();
//                    relativeLayout.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.VISIBLE);
//                }
//            }).show();



        }

    }

    @Override
    public void onSelectId(int id) {

        getChildFragmentManager().beginTransaction().replace(R.id.frameLayout_detailChannel,
                new FragmentDetailChannel().newInstance(id), "fragmentDetailChannel").commit();

    }

    @Override
    public void onBackPressed() {
        if (mListener != null) {
            onBackPressed();
        }
    }


    public interface OnFragmentInteractionListener {

        void onBackPressed();
        // TODO: Update argument type and name
//        void onFragmentInteraction(Uri uri);
    }


}
