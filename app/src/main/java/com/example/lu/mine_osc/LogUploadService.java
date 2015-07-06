package com.example.lu.mine_osc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import java.io.File;
import java.io.FileInputStream;

public class LogUploadService extends Service {
    public LogUploadService() {
    }

    @Override
    public IBinder onBind(Intent intent) {
//        throw new UnsupportedOperationException("Not yet implemented");
        return null;
    }

    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
//        File log = FileUtils.
//        FileInputStream file = new FileInputStream();
        return super.onStartCommand(intent, flags, startId);
    }
}
