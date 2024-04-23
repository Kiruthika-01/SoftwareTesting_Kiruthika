package com.day5.q1;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class Q1Application {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driverchrome=new ChromeDriver();
		 driverchrome.get("https://www.demoblaze.com");
		 driverchrome.manage().window().fullscreen();
		driverchrome.findElement(By.linkText("Laptops")).click();
		Thread.sleep(10000);
		driverchrome.findElement(By.linkText("MacBook air")).click();
		Thread.sleep(10000);
		driverchrome.findElement(By.linkText("Add to cart")).click();
		Thread.sleep(1000);
		driverchrome.switchTo().alert().accept();
		 driverchrome.findElement(By.linkText("Cart")).click();
		SpringApplication.run(Q1Application.class, args);
	}

}
