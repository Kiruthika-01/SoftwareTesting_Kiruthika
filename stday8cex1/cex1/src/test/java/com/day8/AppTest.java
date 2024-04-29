package com.day8;
import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;
public class AppTest 
{
   WebDriverWait wait;
   WebDriver driver;
   String username,password,username1,password1;
   XSSFWorkbook workbook;
   ExtentTest test;
   ExtentReports reports;
   @BeforeTest
   public void beforeTest(){
      String path="C:\\Users\\Kiruthika U\\Downloads\\stday8cex1\\cex1\\src\\Report\\report.html";
      reports=new ExtentReports();
      ExtentSparkReporter spark=new ExtentSparkReporter(path);
      reports.attachReporter(spark);
      spark.config().setDocumentTitle("Groww");
      spark.config().setTheme(Theme.DARK);
      test = reports.createTest("Testcases");
      test.log(Status.PASS,"Well Done");
   }
      
   @BeforeMethod
   public void beforeMethod() throws IOException{
      FileInputStream fs=new FileInputStream("C:\\Users\\Kiruthika U\\Downloads\\stday8cex1\\cex1\\src\\ExcelSheet\\books.xlsx");
      workbook=new XSSFWorkbook(fs);
      int sheets=workbook.getNumberOfSheets();
      System.out.println(sheets);
      username=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
      System.out.println(username);
      password=workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
      System.out.println(password);
      username1=workbook.getSheetAt(0).getRow(2).getCell(0).getStringCellValue();
      password1=workbook.getSheetAt(0).getRow(2).getCell(1).getStringCellValue();

      wait=new WebDriverWait(driver, Duration.ofSeconds(30));
      driver=new ChromeDriver();
      driver.get("http://dbankdemo.com/bank/login");
   }
   @Test(priority = 1)
   public void test1() throws IOException{
      driver.findElement(By.xpath("//*[@id='username']")).sendKeys(username);
      driver.findElement(By.xpath("//*[@id='password']")).sendKeys(password);
      driver.findElement(By.xpath("//*[@id='submit']")).click();
   }
   @Test(priority = 2)
   public void test2(){
      if(driver.getCurrentUrl().contains("home")){
         test.log(Status.PASS, "Success");
      }
      else{
         test.log(Status.FAIL, "Failed");
      }
   }

   @Test(priority = 3)
   public void testWithdraw() throws InterruptedException{
      Thread.sleep(5000);
      driver.findElement(By.xpath("//*[@id=\'username\']")).sendKeys(username1);
      driver.findElement(By.xpath("//*[@id='password\']")).sendKeys(password1);
      driver.findElement(By.xpath("//*[@id=\'submit\']")).click();
      driver.findElement(By.xpath("//*[@id='withdraw-menu-item']")).click();
      Select s=new Select(driver.findElement(By.xpath("//*[@id='selectedAccount']")));
      s.selectByValue("434969");
      driver.findElement(By.xpath("/html/body/div[1]/div[2]/div/div/div/div/form/div[1]/div[3]/div/input")).sendKeys("3000");
      driver.findElement(By.xpath("//*[@id='right-panel']/div[2]/div/div/div/div/form/div[2]/button[1]")).click();
   }
   @AfterMethod
   public void afterMethod() throws InterruptedException{
      Thread.sleep(4000);
      driver.quit();
   }
   @AfterTest
   public void afterTest() throws InterruptedException{
       Thread.sleep(4000);
       reports.flush();
   }
}