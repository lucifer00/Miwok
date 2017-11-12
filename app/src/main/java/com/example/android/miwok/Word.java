package com.example.android.miwok;

/**
 * Created by Prashant on 5/1/2017.
 */

public class Word {
    private String miwokTrans;
    private String localTrans;
    private int resid=NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED=-1;
    private int audio=NO_AUDIO_PROVIDED;
    private static final int NO_AUDIO_PROVIDED=-1;
    public Word(String mwk,String lcl,int audioid)
    {
        miwokTrans=mwk;
        localTrans=lcl;
        audio=audioid;
    }
    public Word(String mwk,String lcl,int res,int audioid)
    {
        miwokTrans=mwk;
        localTrans=lcl;
        resid=res;
        audio=audioid;
    }
    public String getMiwokTrans()
    {
        return miwokTrans;
    }
    public String getLocalTrans()
    {
        return  localTrans;
    }
    public int getResid(){return resid;}
    public  int getAudioId(){return audio;}
    public boolean hasImage()
    {
        if(resid==NO_IMAGE_PROVIDED)
            return true;
        return  false;
    }
    public boolean hasAudio()
    {
        if(audio==NO_AUDIO_PROVIDED)
            return true;
        return  false;
    }

}
