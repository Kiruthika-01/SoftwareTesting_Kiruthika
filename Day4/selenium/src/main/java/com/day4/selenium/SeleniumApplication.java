package com.day4.selenium;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
@SpringBootApplication
public class SeleniumApplication {

	public static void main(String[] args) {
		 WebDriver driverchrome=new ChromeDriver();
		WebDriver driveredge=new EdgeDriver();
		 WebDriver driverfirefox=new FirefoxDriver();
		driverchrome.get("https://www.google.com");
		 driverchrome.close();
		driveredge.get("https://subway-surfers.org");
		driveredge.manage().window().fullscreen();
		driverfirefox.get("https://www.google.com");
		driverfirefox.close();
		 driverchrome.get("https://www.shoppersstop.com/");
		 driverchrome.get("https://www.google.com");
		 System.out.println();
		 System.out.println(driverchrome.getTitle());
		  System.out.println(driverchrome.getCurrentUrl());
		  System.out.println(driverchrome.getPageSource());
		 driverchrome.findElement(By.className("user-icon")).click();
		SpringApplication.run(SeleniumApplication.class, args);
	}

}







