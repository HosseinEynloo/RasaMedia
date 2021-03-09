package com.rasa.computerman.FragmentDetailChannel;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.app.Fragment;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rasa.computerman.FragmentDetailChannel.Adapter.AdapterRecyclerViewDetailChannels;
import com.rasa.computerman.FragmentVideoPlayer.Fragment_videoPlayer;
import com.rasa.computerman.R;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FragmentDetailChannel.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FragmentDetailChannel#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragmentDetailChannel extends Fragment implements iV_detailChannel, Fragment_videoPlayer.OnFragmentInteractionListener {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "id";

    RecyclerView recyclerview_vertical_detailChannel;
    View view;
    PDetailChannel pDetailChannel;
    RelativeLayout relativeLayout;
    ProgressBar progressBar;
    NestedScrollView nestedScrollView;
    Snackbar snackbar;



    // TODO: Rename and change types of parameters
    private int id;


    private OnFragmentInteractionListener mListener;

    public FragmentDetailChannel() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param id Parameter 1.
     * @return A new instance of fragment FragmentDetailChannel.
     */
    // TODO: Rename and change types and number of parameters
    public static FragmentDetailChannel newInstance(int id) {
        FragmentDetailChannel fragment = new FragmentDetailChannel();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            id = getArguments().getInt(ARG_PARAM1);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_detail_channel, container, false);
        init();

        Log.d("frgch", "onCreateView: ");
        pDetailChannel.sendRequest_getBannerGroup(id);
        return view;
    }

    private void init() {
        recyclerview_vertical_detailChannel = view.findViewById(R.id.recyclerview_vertical_detailChannel);
        relativeLayout = view.findViewById(R.id.relativeLayout_progressBarDetailChannel);
        progressBar = view.findViewById(R.id.progressBar_fragmentDetailChannel);
        nestedScrollView=view.findViewById(R.id.nestedScrool);

        pDetailChannel = new PDetailChannel(this);


    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
         //   mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else if (getParentFragment() instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) getParentFragment();
        }

    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessGetList() {


        if (mListener!=null) {
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            AdapterRecyclerViewDetailChannels adapterRecyclerViewDetailChannels = new AdapterRecyclerViewDetailChannels(pDetailChannel);
            recyclerview_vertical_detailChannel.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerview_vertical_detailChannel.setAdapter(adapterRecyclerViewDetailChannels);
        }


    }

    @Override
    public void onFailedGetList(int errorId, String ErrorMessage) {


        if (mListener!=null) {

            Toast.makeText(getContext(), "لطفا به اینترنت متصل شوید", Toast.LENGTH_SHORT).show();
            relativeLayout.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            // Toast.makeText(getContext(), "" + ErrorMessage, Toast.LENGTH_SHORT).show();
            snackbar=Snackbar.make(nestedScrollView, "" + ErrorMessage, Snackbar.LENGTH_INDEFINITE);
            snackbar.setAction("retry", new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    pDetailChannel.sendRequest_getBannerGroup(id);
                    relativeLayout.setVisibility(View.VISIBLE);
                    progressBar.setVisibility(View.VISIBLE);

                }
            }).show();

        }

    }

    @Override
    public void onBackPressed() {
        if (mListener != null) {
            mListener.onBackPressed();
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

        void onBackPressed();

        // TODO: Update argument type and name

    }
}
