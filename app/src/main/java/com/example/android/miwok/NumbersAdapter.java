package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Prashant on 5/5/2017.
 */

public class NumbersAdapter extends ArrayAdapter<Word> {
    private int colourid;
    public NumbersAdapter(Activity context, ArrayList<Word> wordadapter,int color) {
        super(context,0, wordadapter);
        colourid=color;
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currwor=getItem(position);
        TextView tv1=(TextView)listItemView.findViewById(R.id.miwoktextview);
        TextView tv2=(TextView)listItemView.findViewById(R.id.defaulttextview);
        ImageView img=(ImageView)listItemView.findViewById(R.id.number_image);
        //ImageView img2=(ImageView)listItemView.findViewById(R.id.icon_miwok);
        tv1.setText(currwor.getMiwokTrans());
        tv2.setText(currwor.getLocalTrans());
        int colour= ContextCompat.getColor(getContext(),colourid);
        if(!currwor.hasImage())
        img.setImageResource(currwor.getResid());
        else
        {
            img.setVisibility(View.GONE);
        }
        //img2.setImageResource(R.drawable.ic_play_arrow_white_24dp);
        RelativeLayout ll=(RelativeLayout) listItemView.findViewById(R.id.linear_2);
        ll.setBackgroundColor(colour);
        return listItemView;
    }

}
