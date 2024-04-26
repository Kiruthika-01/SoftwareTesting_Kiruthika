package com.cc;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
        WebDriver driver=new ChromeDriver();
        driver.get("https://www.barnesandnoble.com/");
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/a/span")).click();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[1]/div/a[2]")).click();
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/div[2]/div/input[1]")).sendKeys("Chetan Bhagat");
        driver.findElement(By.xpath("//*[@id='rhf_header_element']/nav/div/div[3]/form/div/span")).click();
    }
}
