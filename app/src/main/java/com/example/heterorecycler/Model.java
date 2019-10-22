package com.example.heterorecycler;

public class Model {

    public static final int TEXT_TYPE=0;
    public static final int AUDIO_TYPE=1;
    public static final int IMAGE_TYPE=2;


    protected int type;
    protected int data;
    protected String text;

    public Model(int type,String text,int data){
        this.type=type;
        this.text=text;
        this.data=data;
    }
}
