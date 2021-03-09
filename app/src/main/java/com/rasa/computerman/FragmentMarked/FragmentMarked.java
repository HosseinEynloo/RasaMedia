package com.rasa.computerman.FragmentMarked;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.provider.Settings;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;


import com.rasa.computerman.FragmentMarked.Adapter.AdapterRecyclerViewMarked;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.Marked.Model.ResponseMarked;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentMarked.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentMarked#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentMarked extends Fragment implements iV_marked{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    PMarked pMarked;
    View view;
    RecyclerView recyclerViewMarker;
    ProgressBar progressBar;
    RelativeLayout relativeLayout;
    SwipeRefreshLayout swipeRefreshLayout;
    Snackbar snackbar;
    CoordinatorLayout coordinatorLayout;
    Button btnRetryForMarked;



    // TODO: Rename and change types of parameters
    private String deviceId;


    private OnFragmentInteractionListener mListener;

    public FragmentMarked() {
        // Required empty public constructor
    }


    // TODO: Rename and change types and number of parameters
    public static FragmentMarked newInstance(String deviceId) {
        FragmentMarked fragment = new FragmentMarked();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, deviceId);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            deviceId = getArguments().getString(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        view=inflater.inflate(R.layout.fragment_marked, container, false);
        init();
        pMarked=new PMarked(this);

        deviceId = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        pMarked.sendRequest(deviceId);



        return view;
    }

    private void init() {

        swipeRefreshLayout=view.findViewById(R.id.swipeRefreshLayoutMarked);
        recyclerViewMarker=view.findViewById(R.id.recyclerviewMarker);
        relativeLayout=view.findViewById(R.id.relativeLayout_progressBarMarker);
        progressBar=view.findViewById(R.id.progressBar_fragmentMarker);
        coordinatorLayout=view.findViewById(R.id.coordinatorMarker);
        btnRetryForMarked=view.findViewById(R.id.btnRetryForMarked);


        swipeRefreshLayout.setColorSchemeColors(Color.RED,Color.GREEN,Color.BLUE);
        swipeRefreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                swipeRefreshLayout.setRefreshing(true);


                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {


                        //فراخوانی متد ارسال درخواست و گرفتن اطلاعات لیست
                        relativeLayout.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        pMarked.sendRequest(deviceId);
                        swipeRefreshLayout.setRefreshing(false);
                        if (snackbar!=null){
                            snackbar.dismiss();
                        }


                    }
                }, 3000);

            }
        });

        btnRetryForMarked.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pMarked.sendRequest(deviceId);
                btnRetryForMarked.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//         //   mListener.onFragmentInteraction(uri);
//        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        }
//        else {
//            throw new RuntimeException(context.toString()
//                    + " must implement OnFragmentInteractionListener");
//        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessGetMarked(ResponseMarked responseMarked) {

        if (mListener!=null) {
            btnRetryForMarked.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            AdapterRecyclerViewMarked adapterRecyclerViewMarked = new AdapterRecyclerViewMarked(pMarked);
            recyclerViewMarker.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerViewMarker.setAdapter(adapterRecyclerViewMarked);
        }

    }

    @Override
    public void onFailedGetMarked(int errorId, String errorMessage) {

        if (mListener!=null) {
            Toast.makeText(getContext(), ""+errorMessage, Toast.LENGTH_SHORT).show();
            btnRetryForMarked.setVisibility(View.VISIBLE);
            recyclerViewMarker.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
//             snackbar=Snackbar.make(coordinatorLayout,""+errorMessage,Snackbar.LENGTH_INDEFINITE);
//             snackbar.setAction("retry", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pMarked.sendRequest(deviceId);
//                    relativeLayout.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.VISIBLE);
//
//                }
//            }).show();


        }

    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name

    }
}
