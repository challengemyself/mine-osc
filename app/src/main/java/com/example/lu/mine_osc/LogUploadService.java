package com.example.lu.mine_osc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.lu.mine_osc.util.StringUtil;

import org.kymjs.kjframe.utils.FileUtils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

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
        File log = FileUtils.getSaveFile("OSChina","OSCLog");
        try {
            FileInputStream stream = new FileInputStream(log);
            String data = StringUtil.toStringConvert(stream);
//            String data = stream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
