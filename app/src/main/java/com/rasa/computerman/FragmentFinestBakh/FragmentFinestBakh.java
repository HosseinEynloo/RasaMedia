package com.rasa.computerman.FragmentFinestBakh;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
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

import com.rasa.computerman.FragmentFinestBakh.Adapter.AdapterRecyclerView_FinestBakh;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.FinestBakh.Model.ResponseFinestBakh;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentFinestBakh.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentFinestBakh#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentFinestBakh extends Fragment implements iV_finestBakh{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    PFinestBakh pFinestBakh;
    View view;
    RecyclerView recyclerView;

    RelativeLayout relativeLayout;
    ProgressBar progressBar;
    SwipeRefreshLayout swipeRefreshLayoutFinest;
    CoordinatorLayout coordinatorLayout;
    Snackbar snackbar;
    Button btnRetryForFinest;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentFinestBakh() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentFinestBakh.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentFinestBakh newInstance(String param1, String param2) {
        FragmentFinestBakh fragment = new FragmentFinestBakh();
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
        view=inflater.inflate(R.layout.fragment_finest_bakh, container, false);
        init();
        pFinestBakh.sendRequestForGetFinestBakh();
        return view;
    }

    private void init() {
        pFinestBakh=new PFinestBakh(this);
        recyclerView=view.findViewById(R.id.recyclerView_finestBakh);
        relativeLayout=view.findViewById(R.id.relativeLayout_progressBar_finest);
        progressBar=view.findViewById(R.id.progressBar_fragmentFinest);
        swipeRefreshLayoutFinest=view.findViewById(R.id.swipeRefreshLayoutFinest);
        coordinatorLayout=view.findViewById(R.id.coordinatorLayoutFinest);
        btnRetryForFinest=view.findViewById(R.id.btnRetryForFinest);

        swipeRefreshLayoutFinest.setColorSchemeColors(Color.GREEN,Color.RED);
        swipeRefreshLayoutFinest.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayoutFinest.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        pFinestBakh.sendRequestForGetFinestBakh();
                        swipeRefreshLayoutFinest.setRefreshing(false);
                        if (snackbar!=null){
                            snackbar.dismiss();
                        }
                    }
                },2500);

            }
        });

        btnRetryForFinest.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pFinestBakh.sendRequestForGetFinestBakh();
                btnRetryForFinest.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);


            }
        });
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
          //  mListener.onFragmentInteraction(uri);
        }
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
    public void onSuccessGetFinestBakh(ResponseFinestBakh finestBakh) {

        if (mListener!=null) {
            btnRetryForFinest.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            AdapterRecyclerView_FinestBakh adapterRecyclerView_finestBakh = new AdapterRecyclerView_FinestBakh(pFinestBakh);
            recyclerView.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView.setAdapter(adapterRecyclerView_finestBakh);
        }

    }

    @Override
    public void onFailedGetFinestBakh(int errorId, String ErrorMessage) {

        if (mListener!=null) {
            btnRetryForFinest.setVisibility(View.VISIBLE);
            Toast.makeText(getContext(), ""+ErrorMessage, Toast.LENGTH_SHORT).show();
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);

//            snackbar=Snackbar.make(coordinatorLayout,""+ErrorMessage,Snackbar.LENGTH_INDEFINITE);
//            snackbar.setAction("retry", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pFinestBakh.sendRequestForGetFinestBakh();
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
       // void onFragmentInteraction(Uri uri);
    }
}
