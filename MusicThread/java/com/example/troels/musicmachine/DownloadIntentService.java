package com.example.troels.musicmachine;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Troels on 17-01-2018.
 */

public class DownloadIntentService extends IntentService {

    private static final String TAG = DownloadIntentService.class.getSimpleName();

    public DownloadIntentService(){
        super("DownloadIntentService");
        setIntentRedelivery(true);
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);
        downloadSong(song);
    }
    private void downloadSong(String song){
        long endTime = System.currentTimeMillis() + 10*1000; // 10 * 1000 milisekunder = 10 sek.
        while (System.currentTimeMillis() > endTime){

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        Log.d(TAG, song + "Song downloaded!");
    }
}
