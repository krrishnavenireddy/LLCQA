package framework;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class ScreenshotUtils {

    public static ThreadLocal<String> screenshotName = new ThreadLocal<String>();


    public static void captureScreenshot() throws IOException {

        System.out.println("ffffffffffffffffffffffffffffffffffffff");

        Calendar cal = new GregorianCalendar();
        int month = cal.get(Calendar.MONTH);
        int year = cal.get(Calendar.YEAR);
        int sec = cal.get(Calendar.SECOND);
        int min = cal.get(Calendar.MINUTE);
        int date = cal.get(Calendar.DATE);
        int day = cal.get(Calendar.HOUR_OF_DAY);


        File screenshotFile = ((TakesScreenshot) Driver.aDriver).getScreenshotAs(OutputType.FILE);
        System.out.println(screenshotFile);
      screenshotName.set(System.getProperty("user.dir") + "\\src\\test\\resources\\screenshots\\"+"_" + year + "_" + date + "_" + (month + 1) + "_" + day + "_" + min + "_" + sec + ".jpg");


        if (screenshotFile != null) {
            Date d = new Date();
           // screenshotName.set(d.toString().replace(":", "_").replace(" ", "_") + ".jpg");
            FileUtils.copyFile(new File(String.valueOf(screenshotFile)),
                    new File(screenshotName.get()));
        } else {
            throw new IOException();
        }


    }
}





