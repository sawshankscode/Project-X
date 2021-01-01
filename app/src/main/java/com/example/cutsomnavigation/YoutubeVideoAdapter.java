package com.example.cutsomnavigation;

import android.content.Context;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.core.content.ContextCompat;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class YoutubeVideoAdapter extends RecyclerView.Adapter<YoutubeVideoAdapter.YoutubeViewHolder> {

    ArrayList<DataModel> dataHolder;

//    public YoutubeVideoAdapter(courseAcitivity courseAcitivity, ArrayList<String> youtubeVideoArrayList) {
//        this.youtubeVideoModelArrayList = youtubeVideoModelArrayList;
//    }

    class YoutubeViewHolder extends RecyclerView.ViewHolder{
        TextView header;

        public YoutubeViewHolder(@NonNull View itemView) {
            super(itemView);
            header=itemView.findViewById(R.id.t1);
        }
    }
//    private static final String TAG = YoutubeVideoAdapter.class.getSimpleName();
    private Context context;
//    private ArrayList<String> youtubeVideoModelArrayList;

    //position to check which position is selected
    private int selectedPosition = 0;


    public YoutubeVideoAdapter(Context context, ArrayList<DataModel> dataHolder) {
        this.dataHolder=dataHolder;
        this.context = context;

    }

    @Override
    public  YoutubeViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View view = layoutInflater.inflate(R.layout.youtube_custom_layout, parent, false);
        return new YoutubeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(YoutubeViewHolder holder, final int position) {
    holder.header.setText(dataHolder.get(position).getHeader());


    }

    @Override
    public int getItemCount() {
        return dataHolder.size();
    }

    /**
     * method the change the selected position when item clicked
     * @param selectedPosition
     */
    public void setSelectedPosition(int selectedPosition) {
        this.selectedPosition = selectedPosition;
        //when item selected notify the adapter
        notifyDataSetChanged();
    }
}