package com.example.heterorecycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ArrayList<Model>models=new ArrayList<>();
        models.add(new Model(Model.TEXT_TYPE,"TextView only",0));
        models.add(new Model(Model.IMAGE_TYPE,"ImageView",R.drawable.snow));
        models.add(new Model(Model.AUDIO_TYPE,"AudioView",R.raw.sound));
        models.add(new Model(Model.IMAGE_TYPE,"ImageView",R.drawable.wtc));

        HeteroRecyclerAdapter heteroRecyclerAdapter=new HeteroRecyclerAdapter(models,this);

        LinearLayoutManager linearLayoutManager=new LinearLayoutManager(this, RecyclerView.VERTICAL,false);
        RecyclerView recyclerView=findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(heteroRecyclerAdapter);


    }
}
