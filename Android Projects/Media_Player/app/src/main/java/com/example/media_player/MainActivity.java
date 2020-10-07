package com.example.media_player;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.media.AudioAttributes;
import android.media.AudioFocusRequest;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.os.Build;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.SeekBar;

public class MainActivity extends AppCompatActivity {

    private MediaPlayer mediaPlayer;
    private AudioAttributes playbackAttributes;
    private AudioManager audioManager;
    SeekBar duration;
    int second=0;
    public boolean running;

    private AudioFocusRequest focusRequest;



    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        mediaPlayer = MediaPlayer.create(this, R.raw.song);


        audioManager = (AudioManager) this.getSystemService(this.AUDIO_SERVICE);













        AudioManager.OnAudioFocusChangeListener afChangeListener =
                new AudioManager.OnAudioFocusChangeListener() {
                    public void onAudioFocusChange(int focusChange) {
                        if (focusChange == AudioManager.AUDIOFOCUS_LOSS) {
                            mediaPlayer.pause();

                        }
                        else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT) {
                            // Pause playback
                            mediaPlayer.pause();
                            running=false;
                        } else if (focusChange == AudioManager.AUDIOFOCUS_LOSS_TRANSIENT_CAN_DUCK) {
                            // Lower the volume, keep playing
                            audioManager.adjustVolume(AudioManager.ADJUST_LOWER, AudioManager.FLAG_PLAY_SOUND);
                        } else if (focusChange == AudioManager.AUDIOFOCUS_GAIN) {
                            // Your app has been granted audio focus again
                            // Raise volume to normal, restart playback if necessary
                            audioManager.adjustVolume(AudioManager.ADJUST_RAISE, AudioManager.FLAG_PLAY_SOUND);
                            running=true;
                        }
                        }
                    };














        playbackAttributes = new AudioAttributes.Builder()
                .setUsage(AudioAttributes.USAGE_GAME)
                .setContentType(AudioAttributes.CONTENT_TYPE_MUSIC)
                .build();

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            focusRequest = new AudioFocusRequest.Builder(AudioManager.AUDIOFOCUS_GAIN)
                    .setAudioAttributes(playbackAttributes)
                    .setAcceptsDelayedFocusGain(true)
                    .setOnAudioFocusChangeListener(afChangeListener)
                    .build();
        }


        int res = 0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            res = audioManager.requestAudioFocus(focusRequest);
        }









        Button play=(Button)findViewById(R.id.play);
        Button pause=(Button)findViewById(R.id.pause);

        Button stop=(Button)findViewById(R.id.stop);


        final int finalRes1 = res;
        play.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {



                if (finalRes1 == AudioManager.AUDIOFOCUS_REQUEST_FAILED) {
                    mediaPlayer.stop();

                    running=false;
                } else if (finalRes1 == AudioManager.AUDIOFOCUS_REQUEST_GRANTED) {
                    mediaPlayer.start();
                    running=true;

                } else if (finalRes1 == AudioManager.AUDIOFOCUS_REQUEST_DELAYED) {
                    mediaPlayer.pause();
                    running=false;

                }
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                mediaPlayer.pause();
                running=false;
            }
        });
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mediaPlayer.pause();
                running=false;
            }
        });

        SeekBar volume_Seekbar=(SeekBar)findViewById(R.id.volumeSeekbar);
        int max=audioManager.getStreamMaxVolume(audioManager.STREAM_MUSIC);
        int min=0;
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
            min=audioManager.getStreamMinVolume(audioManager.STREAM_MUSIC);
        }

        Log.d("max", String.valueOf(max));
        Log.d("min", String.valueOf(min));
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            volume_Seekbar.setMin(min);
        }
        volume_Seekbar.setMax(max);
        volume_Seekbar.setProgress(audioManager.getStreamVolume(audioManager.STREAM_MUSIC));
        volume_Seekbar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {

                Log.d("seekbar_Situation", String.valueOf(i));
                audioManager.setStreamVolume(audioManager.STREAM_MUSIC,i,0);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        final int h=mediaPlayer.getDuration();


       duration=(SeekBar)findViewById(R.id.duration);
       duration.setMax(h);
        final boolean[] touch = {false};
       duration.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
           @Override
           public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
               if(touch[0])
               mediaPlayer.seekTo(i);


               Log.d("position", String.valueOf(i));
           }

           @Override
           public void onStartTrackingTouch(SeekBar seekBar) {

               touch[0] =true;
           }

           @Override
           public void onStopTrackingTouch(SeekBar seekBar) {

               touch[0]=false;
           }
       });
       seekbar_changer();
    }
    public void seekbar_changer(){
        final Handler handler=new Handler();
        handler.post(new Runnable() {
            @Override
            public void run() {
                duration.setProgress(mediaPlayer.getCurrentPosition());

                handler.post(this);
            }
        });

    }

}