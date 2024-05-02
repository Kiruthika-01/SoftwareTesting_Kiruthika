package com.model;
// import static org.junit.Assert.assertTrue;

// import java.io.File;
// import java.io.FileInputStream;
// import java.io.IOException;

// import org.apache.commons.io.FileUtils;
// import org.apache.poi.ss.usermodel.Row;
// import org.apache.poi.ss.usermodel.Sheet;
// import org.apache.poi.ss.usermodel.Workbook;
// import org.apache.poi.xssf.usermodel.XSSFRow;
// import org.apache.poi.xssf.usermodel.XSSFSheet;
// import org.apache.poi.xssf.usermodel.XSSFWorkbook;
// import org.openqa.selenium.By;
// import org.openqa.selenium.OutputType;
// import org.openqa.selenium.TakesScreenshot;
// import org.openqa.selenium.WebDriver;
// import org.openqa.selenium.WebElement;
// import org.openqa.selenium.chrome.ChromeDriver;
// import org.testng.annotations.AfterMethod;
// import org.testng.annotations.AfterTest;
// import org.testng.annotations.BeforeMethod;
// import org.testng.annotations.BeforeTest;
// import org.testng.annotations.Test;
// /**
//  * Unit test for simple App.
//  */

// import com.aventstack.extentreports.ExtentReports;
// import com.aventstack.extentreports.ExtentTest;
// import com.aventstack.extentreports.Status;
// import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// public class AppTest 
// {
//     // private static final OutputType<Object> FILE = null;
//     // private static final OutputType<File> File = null;
//     /**
//      * Rigorous Test :-)
//      */
//     WebDriver driver;
//     ExtentReports reports;
//     ExtentSparkReporter spark;
//     ExtentTest test;
//     Workbook workbook;
//     String lamt,ri,yr;
//     @BeforeTest
//     public void btest()
//     {
//         driver=new ChromeDriver();
//         reports=new ExtentReports();
//         String rpath="C:\\Users\\Kiruthika U\\Downloads\\stmodelexam\\grow\\Reports\\reports.html";
//         spark=new ExtentSparkReporter(rpath);
//         reports.attachReporter(spark);
//         test=reports.createTest("Testcase");
//         // test.log(Status.PASS("YES"));
//     }
//     @BeforeMethod
//     public void bmehtod() throws IOException, InterruptedException
//     {
//         FileInputStream fs=new FileInputStream("C:\\Users\\Kiruthika U\\Downloads\\stmodelexam\\grow\\src\\ExcelSheet\\loan.xlsx");
//         workbook=new XSSFWorkbook(fs);
//         // lamt=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
//         // ri=workbook.getSheetAt(0).getRow(1).getCell(1).toString();
//         // yr=workbook.getSheetAt(0).getRow(1).getCell(2).toString();
//         Sheet sheet = workbook.getSheet("sheet1");
//         WebElement loanAmount = driver.findElement(By.xpath("//*[@id=\'LOAN_AMOUNT\']"));
//         Thread.sleep(2000);
//         loanAmount.clear();
//         Thread.sleep(2000);
//         Row row = sheet.getRow(4);
//         String amt = row.getCell(0).toString();
//         loanAmount.sendKeys(amt);
//         Thread.sleep(2000);
//         WebElement interest = driver.findElement(By.xpath("//*[@id=\'RATE_OF_INTEREST\']"));
//         interest.clear();
//         Thread.sleep(2000);
//         String in = row.getCell(1).toString();
//         interest.sendKeys(in);
//         Thread.sleep(2000);
//         WebElement loanTenure = driver.findElement(By.xpath("//*[@id=\'LOAN_TENURE\']"));
//         loanTenure.clear();
//         Thread.sleep(2000);
//         String ten = row.getCell(2).toString();
//         interest.sendKeys(ten);
//         Thread.sleep(2000);
//         driver.get("https://groww.in/");
//     }
//     @Test
//     public void shouldAnswerWithTrue() throws IOException
//     {
//          driver.findElement(By.xpath("//*[@id=\'footer\']/div/div[1]/div/div[1]/div[2]/div[3]/a[2]")).click();
//          String r=driver.getCurrentUrl();
//          if(r.contains("Calculators"))
//          System.out.print("yes");
//          File screen=((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
//          String spath="C:\\Users\\Kiruthika U\\Downloads\\stmodelexam\\grow\\src\\test\\java\\com\\model\\Screenshot\\shot.png";
//          FileUtils.copyFile(screen, new File(spath));
//         //  FileUtils.copyFile(s,new File(spath));
//         // FileUtils.copyFile(s,new File(spath));
//         driver.findElement(By.xpath("//*[@id='root']/div[2]/div[2]/a[15]/div/p[1]")).click();
//         WebElement e=driver.findElement(By.xpath("//*[@id='LOAN_AMOUNT']"));
//         e.clear();
//         e.sendKeys(lamt);
//         WebElement rc=driver.findElement(By.xpath("//*[@id='RATE_OF_INTEREST']"));
//         rc.clear();
//         rc.sendKeys(ri);
//         WebElement en=driver.findElement(By.xpath("//*[@id='root']/div[2]/div[1]/div[2]/div[1]/div[1]/div[1]/div[1]/div[3]/div[1]/div[2]/div/span[2]/span/span"));
//         en.sendKeys(yr);
//        String g=driver.getCurrentUrl();
//        if(g.contains("Your Amortization Details(Yearly/Monthly)"))
//         System.out.print("Present");
//     }
// @AfterMethod
// public void amethod()
// {
//     reports.flush();
//     driver.quit();
// }
// @AfterTest
// public void atest()
// {
//     reports.flush();
//     driver.quit();
// }
// }





import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.github.bonigarcia.wdm.WebDriverManager;

/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    ExtentReports reports;
    ExtentTest test;

    @BeforeTest
    public void setup() {
        reports = new ExtentReports();
        ExtentSparkReporter spark = new ExtentSparkReporter("C:\\Users\\Kiruthika U\\Downloads\\stmodelexam\\grow\\Reports\\reports.html");
        reports.attachReporter(spark);
        test = reports.createTest("Demo Result");
        WebDriverManager.chromedriver().setup();
        driver = new ChromeDriver();
        driver.get("https://groww.in/");
    }

    @Test(priority = 1)
    public void test() throws IOException, InterruptedException {
        driver.findElement(By.linkText("Calculators")).click();
        Thread.sleep(2000);
        File screen = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path = "C:\\Users\\Kiruthika U\\Downloads\\stmodelexam\\grow\\src\\test\\java\\com\\model\\Screenshot\\shot.png";
        FileUtils.copyFile(screen, new File(path));
        test.addScreenCaptureFromPath(path);
        reports.flush();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[2]/a[15]")).click();
        Thread.sleep(2000);
        WebElement loanAmount = driver.findElement(By.xpath("//*[@id=\"LOAN_AMOUNT\"]"));
        Thread.sleep(2000);
        loanAmount.clear();
        Thread.sleep(2000);
        FileInputStream fs = new FileInputStream("C:\\Users\\Kiruthika U\\Downloads\\stmodelexam\\grow\\src\\ExcelSheet\\loan.xlsx");
        Thread.sleep(2000);
        XSSFWorkbook workBook = new XSSFWorkbook(fs);
        XSSFSheet sheet = workBook.getSheet("sheet1");
        XSSFRow row = sheet.getRow(1);
        String amt = row.getCell(0).toString();
        loanAmount.sendKeys(amt);
        Thread.sleep(2000);
        WebElement interest = driver.findElement(By.xpath("//*[@id=\"RATE_OF_INTEREST\"]"));
        interest.clear();
        Thread.sleep(2000);
        String in = row.getCell(1).toString();
        interest.sendKeys(in);
        Thread.sleep(2000);
        WebElement loanTenure = driver.findElement(By.xpath("//*[@id=\"LOAN_TENURE\"]"));
        loanTenure.clear();
        Thread.sleep(2000);
        String ten = row.getCell(2).toString();
        interest.sendKeys(ten);
        Thread.sleep(2000);
        String ver = driver.findElement(By.xpath("//*[@id=\"root\"]/div[2]/div[1]/div[2]/div[1]/div[1]/div[2]/div/p")).getText();
        if (ver.equals("Your Amortization Details (Yearly/Monthly)")) {
            System.out.println("Successful");
        } else {
            System.out.println("Unsuccessful");
        }
    }

    @AfterTest
    public void quitDriver() {
        reports.flush();
        driver.quit();
    }
}



