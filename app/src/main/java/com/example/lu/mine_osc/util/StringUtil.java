package com.example.lu.mine_osc.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Pattern;

/**
 * Created by Administrator on 2015/7/7.
 */
public class StringUtil {

    public static final Pattern emailer = Pattern.compile("\\w+([-+.]\\w)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*");
    public static final Pattern IMG_URL = Pattern.compile(".*?(gif|jpeg|png|jpg|bmp)");

    public static ThreadLocal<SimpleDateFormat> dateFormat = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        }
    };

    public static ThreadLocal<SimpleDateFormat>  dateformat1  = new ThreadLocal<SimpleDateFormat>(){
        @Override
        protected SimpleDateFormat initialValue() {
            return new SimpleDateFormat("yyyy-MM-dd");
        }
    };

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
        String currTime = dateFormat.get().format(cd.getTime());
        return currTime;
    }

    public static long getToday(){
        String todayString = dateformat1.get().format(Calendar.getInstance().getTime());
        String tempToday = todayString.replace("-", "");
        return Long.parseLong(tempToday);
    }

    /**
     * 获取时间差
     * @param date1
     * @param date2
     * @return
     */
    public long calDateDifferent(String date1, String date2) {
        Date d1 = null;
        Date d2 = null;
        long diff = 0;
        try {
            d1 = dateFormat.get().parse(date1);
            d2 = dateFormat.get().parse(date2);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        diff = d2.getTime() - d1.getTime();
        return diff;
    }

    /**
     * 判断是不是一个合法的电子邮件
     * @param email
     * @return
     */
    public static boolean isEmail(String email){
        if(email==null||email.trim().length()==0){
            return false;
        }
        return emailer.matcher(email).matches();
    }

    /**
     * 判断是不是一个合法图片链接
     * @param url
     * @return
     */
    public static boolean isImageUrl(String url){
        if (url==null||url.trim().length()==0){
            return false;
        }
        return IMG_URL.matcher(url).matches();
    }


}
