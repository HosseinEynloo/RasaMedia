package com.rasa.computerman.FragmentVideoPlayer;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.Settings;
import android.support.v4.app.Fragment;
import android.support.v4.content.res.ResourcesCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import android.widget.ProgressBar;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.rasa.computerman.R;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.Group;
import com.rasa.computerman.WebService.Medias.GetMedia.Model.ResponseGetMedia;
import com.rasa.computerman.WebService.Medias.Like.Model.ResponseLike;
import com.rasa.computerman.WebService.Medias.Mark.Model.ResponseMark;
import com.squareup.picasso.Picasso;


import java.util.ArrayList;
import java.util.List;

import java.util.Timer;

import cn.jzvd.JZVideoPlayerStandard;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_videoPlayer.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_videoPlayer#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_videoPlayer extends Fragment implements iV_VideoPlayer {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";


    RecyclerView recyclerView_videoPlayer;

    List<Group> groups;


    View view;
    String device_id;
    PVideoPlayer pVideoPlayer;
    Boolean isLike;
    Boolean isMarked;

    int idVisite;


    ResponseGetMedia responseGetMedia;



    JZVideoPlayerStandard videoPlayerStandard;


    ImageView imageView_videoPlayer_back;
    ImageView imageView_videoPlayer_share;



    Timer timer;


    int mediaId;


    TextView textViewTitle_descrption;
    ImageView imageView_ic_showTextView;
    TextView textView_dependence_whith_Imageview;
    TextView textView_visite;
    TextView textView_visiteCount;

    ImageView imageView_like;
    TextView textView_like;

    ImageView imageView_share;
    TextView textView_share;

    ImageView imageViewMark;
    TextView textViewMark;


    ImageView image_back;
    ImageView image_share;
    ProgressBar progressBar;
    RelativeLayout relativeLayout_progressBar;


    // TODO: Rename and change types of parameters


    private OnFragmentInteractionListener mListener;
    private int position;

    public Fragment_videoPlayer() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @return A new instance of fragment Fragment_videoPlayer.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_videoPlayer newInstance(int id) {
        Fragment_videoPlayer fragment = new Fragment_videoPlayer();
        Bundle args = new Bundle();
        args.putInt(ARG_PARAM1, id);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setHasOptionsMenu(true);
        if (getArguments() != null) {
            mediaId = getArguments().getInt(ARG_PARAM1);

        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        view = inflater.inflate(R.layout.fragment_video_player, container, false);
        Log.d("mediaId", "onCreateView: " + mediaId);
        init();
        return view;
    }

    private void init() {


        videoPlayerStandard = view.findViewById(R.id.jzvideoplayerstandard);
        progressBar = view.findViewById(R.id.progressBar_fragmentVideoPlayer);
        relativeLayout_progressBar = view.findViewById(R.id.relativeLayout_progressBar);


        groups = new ArrayList<>();


        pVideoPlayer = new PVideoPlayer(this);


        recyclerView_videoPlayer = view.findViewById(R.id.recyclerView_videoPlayer);
        imageView_videoPlayer_back = view.findViewById(R.id.imageView_videoPlayer_back);
        imageView_videoPlayer_share = view.findViewById(R.id.imageView_videoPlayer_share);


        image_back = view.findViewById(R.id.imageView_videoPlayer_back);
        image_share = view.findViewById(R.id.imageView_share);
        textViewTitle_descrption = view.findViewById(R.id.textViewTitle_descrption);
        imageView_ic_showTextView = view.findViewById(R.id.imageView_ic_showTextView);
        textView_dependence_whith_Imageview = view.findViewById(R.id.textView_dependence_whith_Imageview);
        textView_visite = view.findViewById(R.id.textView_visite);
        textView_visiteCount = view.findViewById(R.id.textView_visiteCount);

        imageView_like = view.findViewById(R.id.imageView_like);
        textView_like = view.findViewById(R.id.textView_like);

        imageView_share = view.findViewById(R.id.imageView_share);
        textView_share = view.findViewById(R.id.textView_share);

        imageViewMark = view.findViewById(R.id.imageViewMark);
        textViewMark = view.findViewById(R.id.textViewMark);


        device_id = Settings.Secure.getString(getContext().getContentResolver(), Settings.Secure.ANDROID_ID);

        pVideoPlayer.sendRequest(mediaId, device_id);


    }

    private void setupViews() {

        imageView_videoPlayer_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"http://2rsa.ir/bakh.html");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"send with :"));

            }
        });


        image_share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT,"http://2rsa.ir/bakh.html");
                intent.setType("text/plain");
                startActivity(Intent.createChooser(intent,"send with :"));

            }
        });


        imageView_videoPlayer_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (mListener != null) {
                    mListener.onBackPressed();
                }

            }
        });


        imageView_like.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pVideoPlayer.requestLikeState(position, mediaId, device_id, isLike);
                Log.i("bakh", "onClick: "+mediaId+":::::::::::::::::");

            }
        });

        imageViewMark.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                pVideoPlayer.requestMarkState(position, mediaId, device_id, isMarked);


            }
        });


    }


    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
//        if (mListener != null) {
//            mListener.onFragmentInteraction(uri);
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
        if (timer != null) {
            timer.purge();
            timer.cancel();
        }
        super.onDetach();
        mListener = null;
    }

    @Override
    public void onSuccessGetInfo(ResponseGetMedia getMedia) {

        if (mListener != null) {
            setupViews();
            relativeLayout_progressBar.setVisibility(View.GONE);
            progressBar.setVisibility(View.GONE);
            responseGetMedia = getMedia;

            groups = getMedia.getExtra().get(0).getGroups();

            AdapterRecyclerview_videoPlayer adapterRecyclerview_videoPlayer = new AdapterRecyclerview_videoPlayer(pVideoPlayer);
            recyclerView_videoPlayer.setLayoutManager(new LinearLayoutManager(getContext(), LinearLayoutManager.VERTICAL, false));
            recyclerView_videoPlayer.setAdapter(adapterRecyclerview_videoPlayer);


            videoPlayerStandard.setUp(getMedia.getExtra().get(0).getUrl(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
            videoPlayerStandard.startVideo();
            videoPlayerStandard.setEnabled(true);


            Picasso.with(getContext()).load(getMedia.getExtra().get(0).getImageUrl()).into(videoPlayerStandard.thumbImageView);


            idVisite=getMedia.getExtra().get(0).getId();
            pVideoPlayer.requestVisite(idVisite);




            if (getMedia.getExtra().get(0).getIsLiked()) {

                imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.like, null));
                isLike = false;
            } else {

                imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dislike, null));
                isLike = true;
            }

            if (getMedia.getExtra().get(0).getIsMarked()) {
                isMarked = false;
                imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_black_24dp, null));
            } else {
                isMarked = true;
                imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_border_24dp, null));

            }


            textViewTitle_descrption.setText(getMedia.getExtra().get(0).getTitle());
            textView_dependence_whith_Imageview.setText(getMedia.getExtra().get(0).getDescription());
            textView_like.setText(String.valueOf(getMedia.getExtra().get(0).getDefaultLike()));
            textView_visiteCount.setText(String.valueOf(getMedia.getExtra().get(0).getDefaultVisit()));


            imageView_ic_showTextView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (textView_dependence_whith_Imageview.getVisibility() == View.VISIBLE) {
                        textView_dependence_whith_Imageview.setVisibility(View.GONE);
                        imageView_ic_showTextView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_arrow_drop_down_24dp, null));

                    } else if (textView_dependence_whith_Imageview.getVisibility() == View.GONE){
                        textView_dependence_whith_Imageview.setVisibility(View.VISIBLE);
                        imageView_ic_showTextView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_arrow_drop_up_24dp, null));

                    }
                }
            });


        }


    }


    @Override
    public void onFailedGetInfo(int errorId, String ErrorMessage) {

        if (mListener != null) {
            Toast.makeText(getActivity(), "" + ErrorMessage, Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onRowSelected(int position) {
        this.position = position;

        textViewTitle_descrption.setText(groups.get(position).getTitle());
        textView_dependence_whith_Imageview.setText(groups.get(position).getDescription());
        textView_like.setText(String.valueOf(groups.get(position).getDefaultLike()));
        mediaId = groups.get(position).getId();

        if (groups.get(position).getIsLiked()) {
            imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.like, null));
            isLike = false;
        } else {
            imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dislike, null));
            isLike = true;
        }

        if (groups.get(position).getIsMarked()) {
            isMarked = false;
            imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_black_24dp, null));
        } else {
            isMarked = true;
            imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_border_24dp, null));

        }


        textView_visiteCount.setText(String.valueOf(groups.get(position).getDefaultVisit()));
        videoPlayerStandard.release();

        videoPlayerStandard.setUp(groups.get(position).getUrl(), JZVideoPlayerStandard.SCREEN_WINDOW_NORMAL, "");
        Picasso.with(getContext()).load(groups.get(position).getImageUrl()).into(videoPlayerStandard.thumbImageView);
        videoPlayerStandard.startVideo();

        idVisite=groups.get(position).getId();
        pVideoPlayer.requestVisite(idVisite);

        imageView_ic_showTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (textView_dependence_whith_Imageview.getVisibility() == View.VISIBLE) {
                    textView_dependence_whith_Imageview.setVisibility(View.GONE);
                    imageView_ic_showTextView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_arrow_drop_up_24dp, null));

                } else {
                    textView_dependence_whith_Imageview.setVisibility(View.VISIBLE);
                    imageView_ic_showTextView.setImageDrawable(ResourcesCompat.getDrawable(getContext().getResources(), R.drawable.ic_arrow_drop_down_24dp, null));
                }
            }
        });


    }

    @Override
    public void onSuccessGetResponseLike(ResponseLike responseLike, int position, int mediaId) {

        if (mediaId == groups.get(position).getId()) {

            if (groups.get(position).getIsLiked() == false) {
                imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.like, null));
                groups.get(position).setDefaultLike(groups.get(position).getDefaultLike() + 1);
                groups.get(position).setIsLiked(true);
                textView_like.setText(groups.get(position).getDefaultLike() + "");

            } else {
                imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dislike, null));
                groups.get(position).setDefaultLike(groups.get(position).getDefaultLike() - 1);
                groups.get(position).setIsLiked(false);
                textView_like.setText(groups.get(position).getDefaultLike() + "");

            }


        } else {


            if (responseGetMedia.getExtra().get(0).getIsLiked() == false) {
                imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.like, null));
                responseGetMedia.getExtra().get(0).setDefaultLike(responseGetMedia.getExtra().get(0).getDefaultLike() + 1);
                responseGetMedia.getExtra().get(0).setIsLiked(true);
                textView_like.setText(responseGetMedia.getExtra().get(0).getDefaultLike() + "");

            } else {
                imageView_like.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.dislike, null));
                responseGetMedia.getExtra().get(0).setDefaultLike(responseGetMedia.getExtra().get(0).getDefaultLike() - 1);
                responseGetMedia.getExtra().get(0).setIsLiked(false);
                textView_like.setText(responseGetMedia.getExtra().get(0).getDefaultLike() + "");

            }


        }

    }

    @Override
    public void onFailedGetResponseLike(int errorId, String ErrorMessage) {
        Toast.makeText(getContext(), "" + ErrorMessage, Toast.LENGTH_SHORT).show();
        Log.d("error", "onSuccessGetResponseLike: " + ErrorMessage);
    }

    @Override
    public void onSuccessGetResponseMark(ResponseMark responseMark, int position, int mediaId) {



            if (mediaId==groups.get(position).getId()){

                if (groups.get(position).getIsMarked()==false) {
                    groups.get(position).setIsMarked(true);
                    imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_black_24dp, null));
                }else {
                    groups.get(position).setIsMarked(false);
                    imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_border_24dp, null));
            }

        } else {
            if (responseGetMedia.getExtra().get(0).getIsMarked() == false) {
                imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_black_24dp, null));
                responseGetMedia.getExtra().get(0).setIsMarked(true);
            } else {
                imageViewMark.setImageDrawable(ResourcesCompat.getDrawable(getResources(), R.drawable.ic_star_border_24dp, null));
                responseGetMedia.getExtra().get(0).setIsMarked(false);
            }

        }
    }

    @Override
    public void onFailedGetResponseMark(int errorId, String ErrorMessage) {

        Toast.makeText(getContext(), "" + ErrorMessage, Toast.LENGTH_SHORT).show();
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

        void onBackPressed();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {
        super.onStop();
    }
}
