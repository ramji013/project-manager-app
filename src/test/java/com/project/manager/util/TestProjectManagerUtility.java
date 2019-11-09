package com.project.manager.util;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Date;

public class TestProjectManagerUtility {

    @Test
    public void testStr2DateValidDate(){
        String date = "2019-11-02";
        Assert.assertEquals(getDate(date),
                    ProjectManagerUtility.str2Date(date));
    }

    @Test
    public void testStr2DateInValidDate(){
        Assert.assertNotNull(ProjectManagerUtility.str2Date("abcd"));
    }

    @Test
    public void testStr2DateDateIsNullUseCurrentDate(){
        String date = null;
        Assert.assertEquals(new Date(),
                ProjectManagerUtility.str2Date(date));
    }

   @Test
   public void testDate2String(){
        String dateStr= "2019-11-02";
        Date date = getDate(dateStr);
        Assert.assertEquals(dateStr,
                ProjectManagerUtility.date2String(date));
   }

    @Test
    public void testDate2StringIsNull(){
        String dateStr= "2019-11-02";
        Assert.assertEquals("",
                ProjectManagerUtility.date2String(null));
    }

   public Date getDate(String date){
       try {
           return new SimpleDateFormat("yyyy-MM-dd").parse(date);
       }catch(Exception exp){
           exp.printStackTrace();
           Assert.fail();
       }
       return null;
   }
}
