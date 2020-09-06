## LCC(Leaf Colour Chart) Automation

This project has been developed to automate LCC QA application testing on Android platform using Java, Appium, TestNG and Maven.

## Steps to run the application:

1. Install Appium Server (CLI). Follow instructions on [Appium Installation Help](http://appium.io/docs/en/about-appium/getting-started/). Appium Server need not be started externally, it is handled in the code itself.

2. Install Android SDK (Command line tools). Follow instructions on [Android Installation Help](https://developer.android.com/studio/?gclid=CjwKCAjwwYP2BRBGEiwAkoBpAohuHRSwpwUk11WkmX7U1dBifIror9wPrmD_xfqMJVCdfkNqB-nSbhoCFyMQAvD_BwE&gclsrc=aw.ds)

3. Connect your android device and verify connectivity using "adb devices" command in command prompt

4. Update testng.xml with android device details (Device Name, UDID and Platform version).

5. Run the below command on Command Prompt.

```sh
mvn clean install
```
6. On completion of execution, test report will be generated in [LLC_QA.html file](https://github.com/krrishnavenireddy/LLCQA/tree/master/src/main/resources/ExtentReports/LLC_QA.html)

 ![image](https://github.com/meghanashashi/EbayAppiumAutomation/blob/master/images/Report.png)

7. Log files will be generated in the file location specified in [log4j.properties](https://github.com/krrishnavenireddy/LLCQA/tree/master/src/test/resources/log4j.properties)

## App Design

1. Testcases can be [found here](https://github.com/krrishnavenireddy/LLCQA/blob/master/src/test/java/TestCases/SanityTestSuite.java)

2. Code for application framework can be [found here](https://github.com/krrishnavenireddy/LLCQA/tree/master/src/main/java/framework)

3. [BasePage](https://github.com/krrishnavenireddy/LLCQA/tree/master/src/main/java/framework/BasePage.java) contains all common/util functions used across this project.

4. Test data is read from [external source file](https://github.com/krrishnavenireddy/LLCQA/tree/master/src/main/resources/PropertyFiles/InputData.properties)

5. Extent Reports is used for reporting functionality.


## Scenarios covered

  - ### Validate Welcome Screen
      This testcase is used for language selection and click on agreement and validate
      
  - ### Validate add crop functionality
      1. Validate the features of add crop functonality .
      2. Like entering the farm name ,selecting Rice varieties,selecting date and validate .
      3. clicking on save button . 
      
  - ### Validate leaf color 
    1. This cases will select all the pages from the leaf page .
    2. Lastly validating the Thank you page 
