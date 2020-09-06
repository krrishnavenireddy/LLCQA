package Pages;

import TestCases.SanityTestSuite;
import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class WelcomeScreenPage  extends BasePage {


    Logger logger = LoggerFactory.getLogger(SanityTestSuite.class);

    public WelcomeScreenPage(AndroidDriver<AndroidElement> driver) {

        super(driver);
    }


    /*
     * All Uielements Locators
     *
     */


    String english_lang_Btn = "btnText_Select_select_language_en";
    String Agree_Continue = "btnText_welcome_screen_continue";



    public boolean perform_Language_Selection() {
        boolean validate =false;
        try {
            clickUsingAccessibilityID(english_lang_Btn);
            logger.info("Clicked on Language button");
            validate =true;
        }catch(Exception e) {
            logger.error("Error in Clciking Language button");
        }

        return validate;
    }


    public boolean clickOnAgreeAndContinue() {
        boolean validate =false;
        try {
            clickUsingAccessibilityID(Agree_Continue);
            logger.info("Clicked on Agree_Contine button");
            validate =true;
        }catch(Exception e) {
            logger.error("Error in Clciking Agree_Contine button");
        }

        return validate;
    }














}
