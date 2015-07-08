package com.example.lu.mine_osc.api.remote;

import com.example.lu.mine_osc.api.ApiHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by lu on 2015/7/8.
 */
public class OSChinaApi {

    public static void uploadLog(String data,AsyncHttpResponseHandler handler){
        uploadLog(data,"1",handler);
    }

    /**
     * bug上传
     * @param data
     * @param s
     * @param handler
     */
    private static void uploadLog(String data, String s, AsyncHttpResponseHandler handler) {
        RequestParams params = new RequestParams();
        params.add("app","1");
        params.add("report",s);
        params.add("msg",data);
        ApiHttpClient.post("action/api/user_report_to_admin", params, handler);
    }

}
