package com.cc;
import java.io.File;
import java.io.FileInputStream;
import org.apache.commons.io.FileUtils;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
// import io.github.bonigarcia.wdm.WebDriverManager;
/**
 * Unit test for simple App.
 */
public class AppTest {
    WebDriver driver;
    XSSFWorkbook workbook;
    Actions action;
    ExtentReports report;
    ExtentSparkReporter spark;
    ExtentTest test;
    Logger logger=Logger.getLogger(AppTest.class);
    @BeforeTest
    public void beforeTest() throws Exception {
        driver = new ChromeDriver();
        // driver.manage().window().maximize();
        driver.get("https://www.barnesandnoble.com/");
        String path="C:\\Users\\Kiruthika U\\Downloads\\cc-2softwaretesting\\softwaretestingcc2\\src\\ExcelSheet\\books.xlsx";
        spark=new ExtentSparkReporter(path);
        report = new ExtentReports();
         test=report.createTest("Bookdemo");   
        PropertyConfigurator.configure("C:\\Users\\Kiruthika U\\Downloads\\cc-2softwaretesting\\softwaretestingcc2\\src\\test\\java\\com\\cc\\PropertyConfigurator.java");  
    }
    @Test(priority = 1)
    public void tc1() throws Exception {
        FileInputStream fs = new FileInputStream("books.xlsx");
         workbook = new XSSFWorkbook(fs);
        XSSFSheet sheet1 = workbook.getSheet("books");
        XSSFRow r1 = sheet1.getRow(1);
        String bks = r1.getCell(0).getStringCellValue();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/a")).click();
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys(bks);
        Thread.sleep(3000);
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/span/button")).click();
        String verify = driver.findElement(By.xpath("//*[@id='searchGrid']/div/section[1]/section[1]/div/div[1]/div[1]/h1/span")).getText();
        Thread.sleep(3000);
        if (verify.equals(bks)) {
            logger.info(" Chetan Bhagat is available");
        } else {
            logger.error("Error!");
        }
    }
    @Test(priority = 2)
    public void tc2() throws Exception {
        driver.navigate().to("https://www.barnesandnoble.com/");
        action = new Actions(driver);
        action.moveToElement(driver.findElement(By.xpath("//*[@id='rhfCategoryFlyout_Audiobooks']"))).perform();
        Thread.sleep(4000);
        driver.findElement(By.xpath("//*[@id='navbarSupportedContent']/div/ul/li[5]/div/div/div[1]/div/div[2]/div[1]/dd/a[1]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\'addToBagForm_2940159543998\']/input[11]")).submit();
    }
    @Test(priority = 3)
    public void tc3() throws Exception {
        driver.navigate().to("https://www.barnesandnoble.com/");
        driver.findElement(By.xpath("//*[@id=\'footer\']/div/dd/div/div/div[1]/div/a[5]")).click();
        Thread.sleep(2000);
        driver.findElement(By.xpath("//*[@id=\"rewards-modal-link\"]")).click();
        Thread.sleep(2000);
        File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
        String path2 = "C:\\Users\\Kiruthika U\\Downloads\\cc-2softwaretesting\\softwaretestingcc2\\src\\FileScreen\\ss.png";
        FileUtils.copyFile(screenshot, new File(path2));
    }
    @AfterTest
    public void Testquit() {
        driver.quit();
        report.flush();
    }
}
