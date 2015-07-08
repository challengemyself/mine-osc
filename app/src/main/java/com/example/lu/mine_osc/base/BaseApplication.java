package com.example.lu.mine_osc.base;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;
import android.content.res.Resources;
import android.os.Build;

import com.example.lu.mine_osc.util.StringUtil;

/**
 * Created by lu on 2015/7/8.
 */
public class BaseApplication extends Application{
    private static final String LAST_REFRESH_TIME = "last_refresh_time.pref";
    static boolean sIsAtLeastGB;
    static Context applicationContext;
    static Resources resources;
    static{
        if(Build.VERSION.SDK_INT>Build.VERSION_CODES.GINGERBREAD){
            sIsAtLeastGB = true;
        }
    }

    @Override
    public void onCreate() {
        super.onCreate();
        applicationContext = getApplicationContext();
        resources = applicationContext.getResources();
    }

    public static synchronized BaseApplication context(){
        return (BaseApplication) applicationContext;
    }

    public static Resources resource(){
        return resources;
    }

    /**
     * 保存已经阅读列表
     * @param prefFile
     * @param key
     * @param value
     */
    public static void putReadedPostList(String prefFile,String key,String value){
        SharedPreferences preferences = getPreferences(prefFile);
        int size = preferences.getAll().size();
        SharedPreferences.Editor editor = preferences.edit();
        if(size > 20){
            editor.clear();
        }
        editor.putString(key,value);
        apply(editor);
    }

    /**
     * 判断是否在在已阅读列表中
     * @param prefFileName
     * @param key
     * @return
     */
    public static boolean isOnReadedPostList(String prefFileName,String key){
        return getPreferences(prefFileName).getAll().containsKey(key);
    }

    /**
     * 保存上次刷新时间
     * @param key
     * @param value
     */
    public static void putToLastRefreshTime(String key,String value){
        SharedPreferences sharedPreferences = getPreferences(LAST_REFRESH_TIME);
        SharedPreferences.Editor edit = sharedPreferences.edit();
        edit.putString(key,value);
        apply(edit);
    }


    public static String getLastRefreshTime(String key){
        return getPreferences(LAST_REFRESH_TIME).getString(key, StringUtil.getCurrentTime());
    }

    private static void apply(SharedPreferences.Editor editor) {
        if (sIsAtLeastGB){
            editor.apply();
        }else{
            editor.commit();
        }
    }

    private static SharedPreferences getPreferences(String prefFile) {
        return context().getSharedPreferences(prefFile,Context.MODE_MULTI_PROCESS);
    }
}
