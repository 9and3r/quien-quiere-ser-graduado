package com.aorbegozo005.quienquieresergraduado;

import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends ActionBarActivity {
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Reminder r = new Reminder(5);

    }

    @Override
    protected void onResume() {
        mediaPlayer = MediaPlayer.create(this, R.raw.graduadoinicio);
        mediaPlayer.setLooping(false);
        mediaPlayer.setVolume(100,100);
        mediaPlayer.start();
        super.onResume();
    }

    public void instrucciones(View v){
        Instrucciones inst = new Instrucciones();
        inst.show(getSupportFragmentManager(), "instrucciones");
    }

    public void infoJuego(View v){
        Intent i = new Intent(this, UserInfoActivity.class);
        startActivity(i);
    }

    @Override
    protected void onPause() {
        mediaPlayer.stop();
        super.onPause();
    }

    public class Reminder {

        Timer timer;

        public Reminder(int seconds) {
            timer = new Timer();
            timer.schedule(new RemindTask(), seconds*1);
        }

        class RemindTask extends TimerTask {
            public void run() {
                runOnUiThread(new Runnable() {
                    @Override
                    public void run() {
                        setContentView(R.layout.menu_principal);
                    }
                });

            }
        }
    }

}
