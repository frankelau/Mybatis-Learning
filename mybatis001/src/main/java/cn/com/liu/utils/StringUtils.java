package cn.com.liu.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by liuzh on 2017/1/1.
 */
public class StringUtils {


    /**
     * 数据库字段或表名驼峰化，首字母大写
     *
     * @param filedName
     * @return
     */
    public static String getCamelFormat1(String filedName) {
        String str = filedName.replace("tbl_", "");
        String[] strs = str.split("_");
        String resultStr = "";
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            temp = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();
            resultStr = resultStr + temp;
        }
        return resultStr;
    }

    /**
     * 数据库字段或表名驼峰化，首字母小写
     *
     * @param filedName
     * @return
     */
    public static String getCamelFormat2(String filedName) {
        String str = filedName.replace("tbl_", "");
        String[] strs = str.split("_");
        String resultStr = "";
        for (int i = 0; i < strs.length; i++) {
            String temp = strs[i];
            if (i == 0)
                temp = temp.toLowerCase();
            else {
                temp = temp.substring(0, 1).toUpperCase() + temp.substring(1, temp.length()).toLowerCase();
            }
            resultStr = resultStr + temp;
        }
        return resultStr;
    }

    public static boolean isEmpty(String str) {
        if (null == str)
            return true;
        if ("".equals(str) || str.length() == 0)
            return true;
        return false;
    }

    public static String getCurrentTime() {
        SimpleDateFormat sdf = new SimpleDateFormat(DateFormats.YYYYMMDDHHMMSS);
        Date now = new Date();
        return sdf.format(now);
    }
    public static String getCurrentTime(String dateFormat) {
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date now = new Date();
        return sdf.format(now);
    }

    public static void main(String[] args) {
        String tableName = "tbl_user_info";
        System.out.println(getCamelFormat1(tableName));
        System.out.println(getCamelFormat2(tableName));
        System.out.println(getCurrentTime(DateFormats.YYYY_MM_DD_HH_MM_SS));
    }

}
