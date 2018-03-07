package com.example.troels.musicmachine;

import android.os.Looper;
import android.util.Log;

/**
 * Created by Troels on 11-01-2018.
 */

public class DownloadThread extends Thread {
    private static final String TAG = DownloadThread.class.getSimpleName();
    DownloadHandler mHandler;


    @Override
    public void run() {
        Looper.prepare();
        mHandler = new DownloadHandler();
        Looper.loop();
    }

}
