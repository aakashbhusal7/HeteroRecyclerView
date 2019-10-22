package com.example.heterorecycler;

import android.content.Context;
import android.media.MediaPlayer;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import java.util.ArrayList;

public class HeteroRecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Model> modelArrayList;
    private Context context;
    int total;
    MediaPlayer mediaPlayer;
    private boolean volume = false;

    public HeteroRecyclerAdapter(ArrayList<Model> modelArrayList, Context context) {
        this.modelArrayList = modelArrayList;
        this.context = context;
        total = modelArrayList.size();
    }

    public static class TextTypeViewHolder extends RecyclerView.ViewHolder {
        private TextView textView;
        private CardView cardView;

        public TextTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            this.textView = itemView.findViewById(R.id.type);
            this.cardView = itemView.findViewById(R.id.card_view);
        }
    }

    public static class ImageTypeViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private ImageView imageView;

        public ImageTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.type);
            imageView = itemView.findViewById(R.id.background);
        }
    }

    public static class AudioTypeViewHolder extends RecyclerView.ViewHolder {

        private TextView textView;
        private FloatingActionButton floatingActionButton;

        public AudioTypeViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.type);
            floatingActionButton = itemView.findViewById(R.id.fab);
        }
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view;
        switch (viewType) {
            case Model.TEXT_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.text_type, parent, false);
                return new TextTypeViewHolder(view);
            case Model.IMAGE_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.image_type, parent, false);
                return new ImageTypeViewHolder(view);
            case Model.AUDIO_TYPE:
                view = LayoutInflater.from(parent.getContext()).inflate(R.layout.audio_type, parent, false);
                return new AudioTypeViewHolder(view);
        }
        return null;
    }

    @Override
    public int getItemViewType(int position) {

        switch (modelArrayList.get(position).type) {
            case 0:
                return Model.TEXT_TYPE;
            case 1:
                return Model.AUDIO_TYPE;
            case 2:
                return Model.IMAGE_TYPE;
            default:
                return -1;

        }
    }

    @Override
    public void onBindViewHolder(@NonNull final RecyclerView.ViewHolder holder, int position) {
        Model model=modelArrayList.get(position);
        if(model!=null){
            switch (model.type){
                case Model.TEXT_TYPE:
                    ((TextTypeViewHolder)holder).textView.setText(model.text);
                    ((TextTypeViewHolder) holder).cardView.setBackgroundResource(R.color.colorAccent);
                    break;
                case Model.IMAGE_TYPE:
                    ((ImageTypeViewHolder)holder).textView.setText(model.text);
                    ((ImageTypeViewHolder)holder).imageView.setImageResource(model.data);
                    break;
                    case Model.AUDIO_TYPE:
                        ((AudioTypeViewHolder)holder).textView.setText(model.text);
                        ((AudioTypeViewHolder)holder).floatingActionButton
                                .setOnClickListener(new View.OnClickListener() {
                                    @Override
                                    public void onClick(View v) {
                                        if(volume){
                                            if(mediaPlayer.isPlaying()){
                                                mediaPlayer.stop();
                                            }
                                            ((AudioTypeViewHolder)holder).
                                                    floatingActionButton
                                                    .setImageResource(R.drawable.volume);
                                        }
                                        else{
                                            mediaPlayer=MediaPlayer.create(context,
                                                    R.raw.sound);
                                            mediaPlayer.setLooping(true);
                                            mediaPlayer.start();
                                            ((AudioTypeViewHolder)holder)
                                                    .floatingActionButton
                                                    .setImageResource(R.drawable.mute);
                                            volume=true;
                                        }
                                    }
                                });
            }
        }
    }

    @Override
    public int getItemCount() {
        return modelArrayList.size();
    }
}
