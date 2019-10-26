package com.project.manager.util;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectManagerUtility {
    public static Date str2Date(String date){
        if(date!=null){
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }catch(Exception exp){
                exp.printStackTrace();
            }
        }
        return new Date();
    }

    public static String date2String(Date date){
        String pattern = "yyyy-MM-dd";
        DateFormat df = new SimpleDateFormat(pattern);
        return df.format(date);
    }
}
