package TestCases;

import Pages.LeafColourPage;
import Pages.NewCropPage;
import Pages.WelcomeScreenPage;
import framework.BasePage;
import framework.Driver;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import java.lang.reflect.Method;
import java.util.Properties;
import java.util.concurrent.TimeUnit;

public class SanityTestSuite extends Driver {

    Logger logger = LoggerFactory.getLogger(SanityTestSuite.class);
   // Properties prop = BasePage.readInputData("PropertyFiles/InputData.properties");





    @BeforeMethod
    public void beforeMethod(Method m) {
        logger.info("\n" + "****** starting of test:" + m.getName() + "******" + "\n");

    }


@Test(priority = 1)
 public void validate_Welcome_Screen(){

        SoftAssert sa = new SoftAssert();
        WelcomeScreenPage welcomeScreenPage = new WelcomeScreenPage(aDriver);
        sa.assertTrue(welcomeScreenPage.perform_Language_Selection());
        sa.assertTrue(welcomeScreenPage.clickOnAgreeAndContinue());
        sa.assertAll();

 }

    @Test(priority = 2)
    public void validate_AddCrop_Functionality() throws InterruptedException {


        SoftAssert sa = new SoftAssert();
        NewCropPage newCropPage = new NewCropPage(aDriver);
        sa.assertTrue(newCropPage.clickOnAddCropBtn());
        sa.assertTrue(newCropPage.clickOnShowDate());
        sa.assertTrue(newCropPage.enter_FarmName());
        sa.assertTrue(newCropPage.clickOnSaveBtn());
        sa.assertAll();

    }
    @Test(priority = 3)
    public void validateLeafColour() throws InterruptedException {

        TimeUnit.SECONDS.sleep(2);
        SoftAssert sa = new SoftAssert();
        LeafColourPage leafColourPage = new LeafColourPage(aDriver);
        sa.assertTrue(leafColourPage.naviate_AllLeaf_Pages());
        sa.assertTrue(leafColourPage.validate_thanksPage());
       sa.assertAll();

  }




}
