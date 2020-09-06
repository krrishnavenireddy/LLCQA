package Pages;

import TestCases.SanityTestSuite;
import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.concurrent.TimeUnit;

public class NewCropPage extends BasePage {




    Logger logger = LoggerFactory.getLogger(SanityTestSuite.class);

    public NewCropPage(AndroidDriver<AndroidElement> driver) {

        super(driver);
    }


    /*
     * All Uielements Locators
     *
     */
    String add_CropBtn = "btnText_add_crop";
    String farm_xpath = "//android.widget.TextView[contains(text(),'Name of your farm')]";
    String basmatic_xpath = "(//android.view.ViewGroup[@content-desc='roundedButton_rblRiceVarieties'])[2]";
    String date_acce = "//android.widget.ImageView[@content-desc='img_dtSowingdate']";
    String text_date = "22";
    String text_save_date = "Save";
    String content_desc_Save = "roundedButtonText_nbNavBar";



    public boolean clickOnAddCropBtn() {
        boolean validate =false;
        try {
            clickUsingAccessibilityID(add_CropBtn);
            logger.info("Clicked on add_CropBtn button");
            validate =true;
        }catch(Exception e) {
            logger.error("Error in Clciking add_CropBtn button");
        }

        return validate;
    }


    public boolean enter_FarmName() {
        boolean validate =false;

        try {

          //  sendTextTo(farm_xpath,"sadasdsadsadasdas");
            Runtime.getRuntime().exec("adb shell input tap 706 481");
            TimeUnit.SECONDS.sleep(2);
            Runtime.getRuntime().exec("adb shell input text MyFarm");
            TimeUnit.SECONDS.sleep(2);
            hideKeyBoard();
            TimeUnit.SECONDS.sleep(1);
            validate =true;

        }catch(Exception e) {
            logger.error("Error in Clciking add_CropBtn button");
        }

        return validate;
    }

    public boolean select_Rice_Variety() {
        boolean validate =false;
        try {
            Thread.sleep(1000);
           clickUsingXpath(basmatic_xpath);
            validate =true;
        }catch(Exception e) {
            logger.error("Error in Clciking add_CropBtn button");
        }

        return validate;
    }

    public boolean clickOnShowDate() {
        boolean validate =false;
        try {
            TimeUnit.SECONDS.sleep(2);
            clickUsingXpath(date_acce);
           TimeUnit.SECONDS.sleep(2);
           clickUsingTextContains(text_date);
            TimeUnit.SECONDS.sleep(2);
           clickUsingTextContains(text_save_date);
            validate =true;
        }catch(Exception e) {
            logger.error("Error in Clciking add_CropBtn button");
        }

        return validate;
    }

    public boolean clickOnSaveBtn() {
        boolean validate =false;
        try {
          clickUsingAccessibilityID(content_desc_Save);
            validate =true;
        }catch(Exception e) {
            logger.error("Error in Clciking add_CropBtn button");
        }

        return validate;
    }












}
