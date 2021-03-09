package com.rasa.computerman.FragmentNews;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.design.widget.CoordinatorLayout;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rasa.customfontviews.CustomFontTextView;
import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.New.Model.ResponseNew;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentNews.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentNews#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentNews extends Fragment implements iV_new{
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    RecyclerView recyclerView;
    View view;
    PNew pNew;
    RelativeLayout relativeLayout;
    ProgressBar progressBar;
    Snackbar snackbar;
    Button btnRetryForNew;
    CustomFontTextView textPlaseWait;


    SwipeRefreshLayout swipeRefreshLayoutNew;

    CoordinatorLayout coordinatorLayout;



    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public FragmentNews() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FragmentNews.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentNews newInstance(String param1, String param2) {
        FragmentNews fragment = new FragmentNews();
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
        view=inflater.inflate(R.layout.fragment_news, container, false);
        init();


        pNew.sendRequestForGetNew();
        return view;
    }

    private void init() {
        pNew=new PNew(this);
        recyclerView=view.findViewById(R.id.recyclerView_New);
        relativeLayout=view.findViewById(R.id.relativeLayout_progressBar_new);
        progressBar=view.findViewById(R.id.progressBar_fragmentNew);
        swipeRefreshLayoutNew=view.findViewById(R.id.swipeRefreshLayoutNew);
        coordinatorLayout=view.findViewById(R.id.coordinatorNew);
        btnRetryForNew=view.findViewById(R.id.btnRetryForNew);
        textPlaseWait=view.findViewById(R.id.textViewBtnPlaseWait);

        swipeRefreshLayoutNew.setColorSchemeColors(Color.BLUE,Color.GREEN);


        swipeRefreshLayoutNew.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                swipeRefreshLayoutNew.setRefreshing(true);
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        recyclerView.setVisibility(View.GONE);
                        relativeLayout.setVisibility(View.GONE);
                        progressBar.setVisibility(View.GONE);
                        textPlaseWait.setVisibility(View.GONE);
                        pNew.sendRequestForGetNew();
                        swipeRefreshLayoutNew.setRefreshing(false);
                        if (snackbar!=null){
                            snackbar.dismiss();
                        }


                    }
                },2500);

            }
        });

        btnRetryForNew.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                pNew.sendRequestForGetNew();
                btnRetryForNew.setVisibility(View.GONE);
                relativeLayout.setVisibility(View.VISIBLE);
                progressBar.setVisibility(View.VISIBLE);
                textPlaseWait.setVisibility(View.VISIBLE);
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
    public void onSuccessGetNew(ResponseNew responseNew) {

        if (mListener!=null) {
            btnRetryForNew.setVisibility(View.GONE);
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            textPlaseWait.setVisibility(View.GONE);
            recyclerView.setVisibility(View.VISIBLE);
            AdapterRecyclerView_New adapterRecyclerView_new = new AdapterRecyclerView_New(pNew);
            recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
            recyclerView.setAdapter(adapterRecyclerView_new);
        }

    }

    @Override
    public void onFailedGetNew(int errorId, String ErrorMessage) {

        if (mListener!=null) {

            Toast.makeText(getContext(), ""+ErrorMessage, Toast.LENGTH_SHORT).show();
            btnRetryForNew.setVisibility(View.VISIBLE);
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
//            snackbar=Snackbar.make(coordinatorLayout,""+ErrorMessage,Snackbar.LENGTH_INDEFINITE);
//            snackbar.setAction("retry", new View.OnClickListener() {
//                @Override
//                public void onClick(View v) {
//                    pNew.sendRequestForGetNew();
//                    relativeLayout.setVisibility(View.VISIBLE);
//                    progressBar.setVisibility(View.VISIBLE);
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
        //void onFragmentInteraction(Uri uri);
    }
}
