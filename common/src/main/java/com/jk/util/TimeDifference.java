package com.jk.util;

import java.util.Date;

public class TimeDifference {
    /**
     * 于洋 时间差
     * @param endDate 晚
     * @param nowDate 早
     * @return
     */
    public static String getDatePoor(Date endDate, Date nowDate) {
        long nd = 1000 * 24 * 60 * 60;
        long nh = 1000 * 60 * 60;
        long nm = 1000 * 60;
        long ns = 1000;
        // 获得两个时间的毫秒时间差异
        long diff = endDate.getTime() - nowDate.getTime();
        // 计算差多少天
        long day = diff / nd;
        // 计算差多少小时
        long hour = diff % nd / nh;
        // 计算差多少分钟
        long min = diff % nd % nh / nm;
        // 计算差多少秒//输出结果
        long sec = diff % nd % nh % nm / ns;

        String dateTime = "";

        if(day>0)
        {
            dateTime+=day + "天";
        }
        if(hour>0)
        {
            dateTime+=hour + "小时";
        }
        if(min>0)
        {
            dateTime+=min + "分钟";
        }
        if(sec>0)
        {
            dateTime+=sec + "秒";
        }
        return dateTime;
    }

}
