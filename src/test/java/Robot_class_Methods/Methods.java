package Robot_class_Methods;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;


public class Methods 
{

 
public static  WebDriver d;

public static void main(String[] args) throws AWTException
{
{
System.setProperty("webdriver.chrome.driver", "C:\\Users\\HP\\Desktop\\New folder\\latest_chrome_path\\chromedriver.exe");
d=new ChromeDriver();
d.manage().window().maximize();
d.get("http://www.tutorialsninja.com/demo/");
Robot r=new Robot();




}	

}
}
