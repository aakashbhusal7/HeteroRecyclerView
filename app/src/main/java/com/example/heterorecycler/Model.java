package com.example.heterorecycler;

public class Model {

    public static final int TEXT_TYPE=0;
    public static final int AUDIO_TYPE=1;
    public static final int IMAGE_TYPE=2;


    public int type;
    public int data;
    public String text;

    public Model(int type,String text,int data){
        this.type=type;
        this.text=text;
        this.data=data;
    }
}
