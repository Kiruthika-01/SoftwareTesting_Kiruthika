package com.day8;
import java.io.FileInputStream;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

/**
 * Unit test for simple App.
 */
public class AppTest 
{
    /**
     * Rigorous Test :-)
     */
    WebDriver driver;
   ExtentReports report;
   ExtentSparkReporter spark;
   ExtentTest test;
public Workbook workbook;
    @BeforeTest
    public void before_test()throws Exception
    {
       driver=new ChromeDriver();
       FileInputStream fs=new FileInputStream("C:\\Users\\Kiruthika U\\Downloads\\stday8cex2\\cex2\\src\\ExcelSheet\\laptop.xlsx");
       workbook=new XSSFWorkbook(fs);
       driver.get("https://demoblaze.com/");
    }
    @Test(priority = 1)
    public void shouldAnswerWithTrue() throws InterruptedException
    {
       driver.findElement(By.xpath("/html/body/div[5]/div/div[1]/div/a[3]")).click();  
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\'tbodyid\']/div[3]/div/div/h4/a")).click(); 
       Thread.sleep(3000);
       driver.findElement(By.xpath("//*[@id=\'tbodyid\']/div[2]/div/a")).click();
       Thread.sleep(3000);
       Alert al=driver.switchTo().alert();
		al.accept();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id=\'navbarExample\']/ul/li[4]/a")).click();
        Thread.sleep(3000);
        String book="MacBook air";
        String verify=driver.findElement(By.xpath("//*[@id='tbodyid']/tr/td[2]")).getText();
        if(book.equals(verify))
        {
            System.out.println("Verified");
        }
        else
        System.out.print("Error");
    }
    @Test(priority = 2)
    public void testcase2() throws InterruptedException
    {
        String username=workbook.getSheetAt(0).getRow(1).getCell(0).getStringCellValue();
        String password=workbook.getSheetAt(0).getRow(1).getCell(1).getStringCellValue();
        
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='login2']")).click();
        Thread.sleep(1000);
        driver.findElement(By.xpath("//*[@id='loginusername']")).sendKeys(username);
        Thread.sleep(1000);
           driver.findElement(By.xpath("//*[@id='loginpassword']")).sendKeys(password);
           Thread.sleep(1000);
           driver.findElement(By.xpath("//*[@id=\'logInModal\']/div/div/div[3]/button[2]")).click();
    }
    @AfterTest
    public void aftertest()
    {
        driver.quit();
    }
}

