package com.day5.pah;
import java.io.File;
import java.io.IOException;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.util.FileCopyUtils;

@SpringBootApplication
public class PahApplication {

	private static final File WebElement = null;

	public static void main(String[] args) throws InterruptedException, IOException {
		WebDriver chromedriver=new ChromeDriver();
		chromedriver.get("https://magento.softwaretestingboard.com/");
		chromedriver.findElement(By.id("search")).click();
		chromedriver.findElement(By.id("search")).sendKeys("Shoes");
		chromedriver.findElement(By.xpath("//*[@id='search_mini_form']/div[2]/button")).click();
		if(chromedriver.findElement(By.xpath("//*[@id='maincontent']/div[1]/h1/span")).getText().contains("Shoes"))
		{
			System.out.print("Confirms the presence of text:Shoes");
		}
		else
		System.out.print("Not available:Shoes");
		 TakesScreenshot ts=(TakesScreenshot)chromedriver;
		 File file=ts.getScreenshotAs(OutputType.FILE);
		 FileUtils.copyFile(file,new File("./screenshot/shoe.png"));
		 Thread.sleep(1000);
		 WebElement web=chromedriver.findElement(By.xpath("//*[@id='ui-id-5']/span[1]"));
		Actions as=new Actions(chromedriver);
		as.moveToElement(web).perform();
		 Thread.sleep(1000);
		 WebElement man=chromedriver.findElement(By.xpath("//*[@id='ui-id-17']/span[1]"));
		 as.moveToElement(man).perform();
		 chromedriver.findElement(By.xpath("//*[@id='ui-id-20']/span")).click();
		 chromedriver.navigate().back();
		 
		SpringApplication.run(PahApplication.class, args);
	}

}
