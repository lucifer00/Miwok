package com.example.android.miwok;

import android.content.Context;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import java.util.ArrayList;

public class FamilyActivity extends AppCompatActivity {
    private MediaPlayer mp;
    private AudioManager audman;
    private AudioManager.OnAudioFocusChangeListener audioFocusChangeListener=new AudioManager.OnAudioFocusChangeListener() {
        @Override
        public void onAudioFocusChange(int i) {
            if(i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT||i==AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK)
            {
                mp.pause();
                mp.seekTo(0);
            }
            if(i==AudioManager.AUDIOFOCUS_GAIN)
                mp.start();
            if(i==AudioManager.AUDIOFOCUS_LOSS)
                releaseMediaPlayer();
        }
    };
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_family);
        final ArrayList<Word> family=new ArrayList<Word>();
        family.add(new Word("Father","әpә",R.drawable.family_father,R.raw.family_father));
        family.add(new Word("Mother","әṭa",R.drawable.family_mother,R.raw.family_mother));
        family.add(new Word("Son","angsi",R.drawable.family_son,R.raw.family_son));
        family.add(new Word("Daughter","tune",R.drawable.family_daughter,R.raw.family_daughter));
        family.add(new Word("Older brother","taachi",R.drawable.family_older_brother,R.raw.family_older_brother));
        family.add(new Word("Younger brother","chalitti",R.drawable.family_younger_brother,R.raw.family_younger_brother));
        family.add(new Word("Older sister","teṭe",R.drawable.family_older_sister,R.raw.family_older_sister));
        family.add(new Word("Younger sister ","kolliti",R.drawable.family_younger_sister,R.raw.family_younger_sister));
        family.add(new Word("Grandmother","ama",R.drawable.family_grandmother,R.raw.family_grandmother));
        family.add(new Word("Grandfather","paapa",R.drawable.family_grandfather,R.raw.family_grandfather));
        final NumbersAdapter fa=new NumbersAdapter(this,family,R.color.category_family);
        ListView lv=(ListView)findViewById(R.id.list);
        lv.setAdapter(fa);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                int audio=family.get(i).getAudioId();
                releaseMediaPlayer();
                mp=MediaPlayer.create(FamilyActivity.this,audio);
                audman=(AudioManager)getSystemService(Context.AUDIO_SERVICE);
                int result=audman.requestAudioFocus(audioFocusChangeListener,AudioManager.STREAM_MUSIC,AudioManager.AUDIOFOCUS_GAIN_TRANSIENT);
                if(result==AudioManager.AUDIOFOCUS_REQUEST_GRANTED)
                {

                    mp.start();

                    mp.setOnCompletionListener(new MediaPlayer.OnCompletionListener() {
                        @Override
                        public void onCompletion(MediaPlayer mediaPlayer) {
                            releaseMediaPlayer();
                        }
                    });

                }
            }
        });
    }
    private void releaseMediaPlayer() {
        // If the media player is not null, then it may be currently playing a sound.
        if (mp != null) {
            // Regardless of the current state of the media player, release its resources
            // because we no longer need it.
            mp.release();

            // Set the media player back to null. For our code, we've decided that
            // setting the media player to null is an easy way to tell that the media player
            // is not configured to play an audio file at the moment.
            mp = null;
            audman.abandonAudioFocus(audioFocusChangeListener);
        }
    }

    @Override
    protected void onStop() {
        super.onStop();
        releaseMediaPlayer();
    }
}
