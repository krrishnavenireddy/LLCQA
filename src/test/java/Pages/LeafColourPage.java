package Pages;

import TestCases.SanityTestSuite;
import framework.BasePage;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.AndroidElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class LeafColourPage extends BasePage {



    Logger logger = LoggerFactory.getLogger(SanityTestSuite.class);

    public LeafColourPage(AndroidDriver<AndroidElement> driver) {

        super(driver);
    }

  // Locators
    String acc_id_skip_btn = "btnText_skipButton";
    String leaf_colors = "circledCheck_mockLeafColorScreen_4";
    String Next_Leaf = "btnText_btnNextLeaf";
    String Thanks_You = "txt_almostdone";
    String Done = "btnText_btnDone";


    public boolean clickOnDone(){

        boolean validate =false;
        try{

            clickUsingAccessibilityID(Done);
            validate = true;

        }catch (Exception e){

        }

        return validate;

    }



    public boolean validate_thanksPage(){
        boolean validate =false;
        try{

            clickUsingAccessibilityID(Thanks_You);
            validate = true;

        }catch (Exception e){

        }

        return validate;

    }


    public boolean naviate_AllLeaf_Pages(){

        boolean validate =false;
        try {

            clickUsingAccessibilityID(acc_id_skip_btn);
            Thread.sleep(2000);
            for(int i=0;i<9;i++){

                clickUsingAccessibilityID(leaf_colors);
                Thread.sleep(2000);
                clickUsingAccessibilityID(Next_Leaf);

            }
            clickUsingAccessibilityID(leaf_colors);
            Thread.sleep(2000);
            clickOnDone();

            validate =true;

        }catch(Exception e) {
            logger.error("Error in Clciking Language button");
        }

        return validate;


    }











}
