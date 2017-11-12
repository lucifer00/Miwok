package com.example.android.miwok;

/**
 * Created by Prashant on 5/6/2017.
 */

public class Colors {
    private String miwokTrans;
    private String localTrans;
    public Colors(String mwk,String lcl)
    {
        miwokTrans=mwk;
        localTrans=lcl;
    }
    public String getMiwokTrans()
    {
        return miwokTrans;
    }
    public String getLocalTrans()
    {
        return  localTrans;
    }
}
