package com.example.lu.mine_osc;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;

import com.example.lu.mine_osc.api.remote.OSChinaApi;
import com.example.lu.mine_osc.util.StringUtil;
import com.loopj.android.http.AsyncHttpResponseHandler;

import org.apache.http.Header;
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
        final File log = FileUtils.getSaveFile("OSChina","OSCLog");
        String data = null;
        try {
            FileInputStream stream = new FileInputStream(log);
            data = StringUtil.toStringConvert(stream);
//            String data = stream
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        if (!StringUtil.isEmpty(data)){
            OSChinaApi.uploadLog(data, new AsyncHttpResponseHandler() {
                @Override
                public void onSuccess(int i, Header[] headers, byte[] bytes) {
                    log.delete();
                    LogUploadService.this.stopSelf();
                }

                @Override
                public void onFailure(int i, Header[] headers, byte[] bytes, Throwable throwable) {
                    LogUploadService.this.stopSelf();
                }
            });
        }
        return super.onStartCommand(intent, flags, startId);
    }
}
