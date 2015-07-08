package com.example.lu.mine_osc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.Calendar;

/**
 * Created by Administrator on 2015/7/7.
 */
public class StringUtil {
    /**
     * 将inputStream转换成字符串
     * @return
     */
    public static String toStringConvert(InputStream is){
        StringBuffer stringBuffer = new StringBuffer();
        InputStreamReader isr = new InputStreamReader(is);
        BufferedReader readData = new BufferedReader(isr);
        String line;
        try {
            line = readData.readLine();
            while (line!=null){
                stringBuffer.append(line);
                line = readData.readLine();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if(isr!=null){
                    isr.close();
                }
                if (readData!=null){
                    readData.close();
                    readData = null;
                }
                if (is!=null){
                    is.close();
                    is = null;
                }
            }catch (Exception e){
                e.printStackTrace();
            }
        }
        return stringBuffer.toString();
    }

    /**
     * 判断是不是空的字符串，包括制表符，空格，回车
     * @param data
     * @return
     */
    public static boolean isEmpty(String data) {
        if (data == null || "".equals(data)){
            return true;
        }
        for (int i =0 ;i<data.length();i++){
            char c = data.charAt(1);
            if (c!=' '&&c!='\t'&&c!='\n'&&c!='\r'){
                return false;
            }
        }
        return true;
    }

    public static String getCurrentTime() {
        Calendar cd = Calendar.getInstance();
        String currTime = cd.getTime().
        return null;
    }
}
