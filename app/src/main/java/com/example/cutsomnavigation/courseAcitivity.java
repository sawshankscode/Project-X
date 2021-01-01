package com.example.cutsomnavigation;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.provider.SyncStateContract;
import android.util.Log;
import android.view.View;

import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerSupportFragmentX;

import java.util.ArrayList;
import java.util.Collections;

public class courseAcitivity extends AppCompatActivity {
    private static final String TAG = courseAcitivity.class.getSimpleName();
    private RecyclerView recyclerView;
    private YouTubePlayerSupportFragmentX youTubePlayerFragment;
    private ArrayList<String> youtubeVideoArrayList;
    private YouTubePlayer youTubePlayer;
    ArrayList<DataModel> dataHolder;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_acitivity);
        generateDummyVideoList();
        initializeYoutubePlayer();
        setUpRecyclerView();
        populateRecyclerView();
    }
    private void initializeYoutubePlayer() {

        youTubePlayerFragment = (YouTubePlayerSupportFragmentX) getSupportFragmentManager()
                .findFragmentById(R.id.youtube_player_fragment);

        if (youTubePlayerFragment == null)
            return;

        youTubePlayerFragment.initialize(SyncStateContract.Constants._ID, new YouTubePlayer.OnInitializedListener() {

            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer player,
                                                boolean wasRestored) {
                if (!wasRestored) {
                    youTubePlayer = player;

                    //set the player style default
                    youTubePlayer.setPlayerStyle(YouTubePlayer.PlayerStyle.DEFAULT);

                    //cue the 1st video by default
                    youTubePlayer.cueVideo(youtubeVideoArrayList.get(0));
                }
            }

            @Override
            public void onInitializationFailure(YouTubePlayer.Provider arg0, YouTubeInitializationResult arg1) {

                //print or show error if initialization failed
                Log.e(TAG, "Youtube Player View initialization failed");
            }
        });
    }

    /**
     * setup the recycler view here
     */
    private void setUpRecyclerView() {
        recyclerView = findViewById(R.id.recycler_view);
        dataHolder=new ArrayList<>();
        DataModel ob1=new DataModel("Video sample 1");
        dataHolder.add(ob1);
        DataModel ob2=new DataModel("Video sample 2");
        dataHolder.add(ob2);
        DataModel ob3=new DataModel("Video sample 3");
        dataHolder.add(ob3);
        DataModel ob4=new DataModel("Video sample 4");
        dataHolder.add(ob4);
        DataModel ob5=new DataModel("Video sample 5");
        dataHolder.add(ob5);
        DataModel ob6=new DataModel("Video sample 6");
        dataHolder.add(ob6);
        DataModel ob7=new DataModel("Video sample 7");
        dataHolder.add(ob7);
        DataModel ob8=new DataModel("Video sample 8");
        dataHolder.add(ob8);
        DataModel ob9=new DataModel("Video sample 9");
        dataHolder.add(ob9);
        DataModel ob10=new DataModel("Video sample 10");
        dataHolder.add(ob10);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(linearLayoutManager);
    }

    /**
     * populate the recycler view and implement the click event here
     */
    private void populateRecyclerView() {
        final YoutubeVideoAdapter adapter = new YoutubeVideoAdapter(this, dataHolder);
        recyclerView.setAdapter(adapter);

        //set click event
//        recyclerView.addOnItemTouchListener(new RecyclerViewOnClickListener(this, new RecyclerViewOnClickListener.OnItemClickListener() {
//            @Override
//            public void onItemClick(View view, int position) {
//
//                if (youTubePlayerFragment != null && youTubePlayer != null) {
//                    //update selected position
//                    adapter.setSelectedPosition(position);
//
//                    //load selected video
//                    youTubePlayer.cueVideo(youtubeVideoArrayList.get(position));
//                }
//
//            }
//        }));
    }


    /**
     * method to generate dummy array list of videos
     */
    private void generateDummyVideoList() {
        youtubeVideoArrayList = new ArrayList<>();

        //get the video id array from strings.xml
        String[] videoIDArray = getResources().getStringArray(R.array.video_id_array);

        //add all videos to array list
        Collections.addAll(youtubeVideoArrayList, videoIDArray);

    }
}
