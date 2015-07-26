package com.example.lu.mine_osc.ui;

import android.app.Activity;
import android.os.Looper;
import android.view.KeyEvent;
import android.widget.Toast;

import com.example.lu.mine_osc.R;
import com.example.lu.mine_osc.app.AppManager;

import android.os.Handler;


/**
 * Created by lu on 2015/7/26.
 */
public class DoubleClickExitHelper {

    private final Activity context;
    private Toast toast;
    private boolean isOnkeyBacking;
    private Handler mHandler;

    public DoubleClickExitHelper(Activity context){
        this.context = context;
        mHandler = new Handler(Looper.getMainLooper());
    }

    public boolean onKeyDown(int keyCode,KeyEvent event){
        if (keyCode != KeyEvent.KEYCODE_BACK){
            return false;
        }
        if (isOnkeyBacking){
            if (toast!=null){
                toast.cancel();
            }
            mHandler.removeCallbacks(mPostRunTime);
            AppManager.getInstance().AppExit(context);
            return true;
        }else{
            isOnkeyBacking = true;
            if (toast == null){
                toast = Toast.makeText(context, R.string.tip_double_click_exit,2000);
            }
            toast.show();
            mHandler.postDelayed(mPostRunTime,2000);
            return true;
        }
    }

    private Runnable mPostRunTime = new Runnable() {
        @Override
        public void run() {
            isOnkeyBacking = false;
            if (toast!=null){
                toast.cancel();
            }
        }
    };
}
