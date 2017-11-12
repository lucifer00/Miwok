package com.example.android.miwok;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;

/**
 * Created by Prashant on 5/6/2017.
 */

public class ColorsAdapter extends ArrayAdapter<Word> {

    public ColorsAdapter(Activity context, ArrayList<Word> colorsadapter) {
        super(context,0, colorsadapter);
    }

    @NonNull
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View listItemView = convertView;
        if (listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }
        Word currcolor=getItem(position);
        TextView tv1=(TextView)listItemView.findViewById(R.id.miwoktextview);
        TextView tv2=(TextView)listItemView.findViewById(R.id.defaulttextview);
        ImageView img=(ImageView)listItemView.findViewById(R.id.number_image);
        img.setImageResource(currcolor.getResid());
        tv1.setText(currcolor.getMiwokTrans());
        tv2.setText(currcolor.getLocalTrans());
        return listItemView;
    }
}
