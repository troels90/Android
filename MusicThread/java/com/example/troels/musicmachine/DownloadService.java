package com.example.troels.musicmachine;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.os.Message;
import android.support.annotation.Nullable;
import android.util.Log;

/**
 * Created by Troels on 16-01-2018.
 */

public class DownloadService extends Service {

    private static final String TAG = DownloadService.class.getSimpleName() ;
    private DownloadHandler mHandler;

    @Override
    public void onCreate() {
        final DownloadThread thread = new DownloadThread();
        thread.setName("DownloadThread");
        thread.start();

        while(thread == null) {

            mHandler = thread.mHandler;
            mHandler.setService(this);
        }
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        String song = intent.getStringExtra(MainActivity.KEY_SONG);

        Message message = Message.obtain();
        message.obj = song;
        message.arg1 = startId;

        mHandler.sendMessage(message);

        return Service.START_REDELIVER_INTENT;
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
            return null;
    }
}
