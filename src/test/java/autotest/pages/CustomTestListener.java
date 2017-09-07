//package autotest.pages;
//
//import io.qameta.allure.Attachment;
//import org.openqa.selenium.OutputType;
//import org.openqa.selenium.TakesScreenshot;
//import org.slf4j.Logger;
//import org.slf4j.LoggerFactory;
//import org.testng.ITestResult;
//import org.testng.TestListenerAdapter;
//
/////**
// * Created by as9l on 06.09.2017.
// */
//
//public class CustomTestListener extends TestListenerAdapter {
//
//    private Logger log = LoggerFactory.getLogger(CustomTestListener.class);
//
//    @Override
//    public void onTestStart(ITestResult result) {
//        log.info("Test class started: " + result.getTestClass().getName());
//        log.info("Test started: " + result.getName());
//    }
//
//    @Override
//    public void onTestSuccess(ITestResult result) {
//        log.info("Test SUCCESS: " + result.getName());
//    }
//
//    @Override
//    public void onTestFailure(ITestResult result) {
////            makeScreenshot();
//        log.info("Test FAILED: " + result.getName());
//        if (result.getThrowable() != null) {
//            result.getThrowable().printStackTrace();
//        }
//    }
//
////        @Attachment(value = "Page screenshot", type = "image/png")
////        private byte[] makeScreenshot() {
////            return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
////        }
//}