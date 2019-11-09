package com.project.manager.util;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

public class ProjectManagerUtility {

    private static final Logger logger = LoggerFactory.getLogger(ProjectManagerUtility.class);

    public static Date str2Date(String date){
        if(date!=null){
            try {
                return new SimpleDateFormat("yyyy-MM-dd").parse(date);
            }catch(Exception exp){
                logger.error("Exception occured while parsing the inputted date: {} ", date);
            }
        }
        return new Date();
    }

    public static String date2String(Date date){
        if(date!=null) {
            String pattern = "yyyy-MM-dd";
            DateFormat df = new SimpleDateFormat(pattern);
            return df.format(date);
        }
        return "";
    }
}
