package com.ms.credit;

import com.ms.credit.utils.LocalFileUtils;
import org.junit.Test;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * @author Dean
 * @version 1.0
 * @date 2019/11/18 9:31
 */
public class GetTime {
    @Test
    public void getTiem(){
        SimpleDateFormat format = new SimpleDateFormat("HH:mm");
        String format1 = format.format(new Date());
        System.out.println(format1);

        Calendar ca = Calendar.getInstance();
        int hour = ca.get(Calendar.HOUR_OF_DAY);
        int minute = ca.get(Calendar.MINUTE);
        if(minute<10){
            System.out.println(hour+":0"+minute);
            return;
        }
        System.out.println(hour+":"+minute);
    }

    @Test
    public void getFileName(){
        String fileName = "nihao.txt";
        String extensionName = LocalFileUtils.getExtensionName(fileName);
        System.out.println(extensionName);

        System.out.println(LocalFileUtils.getPreFileNameNoEx(fileName));
    }

    @Test
    public void toUper(){
        System.out.println("Multimedia file parsing failed".toUpperCase());
    }
}
