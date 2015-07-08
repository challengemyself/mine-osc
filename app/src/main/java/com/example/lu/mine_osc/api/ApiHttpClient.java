package com.example.lu.mine_osc.api;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.AsyncHttpResponseHandler;
import com.loopj.android.http.RequestParams;

/**
 * Created by lu on 2015/7/8.
 */
public class ApiHttpClient {
    private static final String API_URL = "http://www.oschina.net/%s";
    private static AsyncHttpClient client;
    public static void post(String partUrl,RequestParams params,AsyncHttpResponseHandler handler){
        client.post(getAbsoluteApiUrl(partUrl),params,handler);
    }

    /**
     * 获取接口的完整地址
     * @param partUrl
     * @return
     */
    private static String getAbsoluteApiUrl(String partUrl) {
        String url = String.format(API_URL,partUrl);
        return url;
    }
}
