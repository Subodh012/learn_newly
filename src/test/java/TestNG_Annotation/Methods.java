package TestNG_Annotation;

import java.io.File;
import java.io.IOException;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;

public class Methods 
{
	
public WebDriver d;

@BeforeSuite
public void launchbrowser()
{
WebDriverManager.chromedriver().setup();
d=new ChromeDriver();
}

@BeforeTest
public void launchurl()
{
d.get("http://www.tutorialsninja.com/demo/");	
d.manage().timeouts().pageLoadTimeout(5,TimeUnit.SECONDS);
}

@BeforeClass
public void maxmized()
{
d.manage().window().maximize();
}

@BeforeMethod
public void getcookies()
{
Set<org.openqa.selenium.Cookie> c=d.manage().getCookies();
for (org.openqa.selenium.Cookie cookie : c)
{
System.out.println(cookie.getName()+" "+cookie.getClass()+" "+cookie.getValue()+" "+cookie.getPath()+" "+cookie.getDomain()+" "+cookie.getExpiry());
System.out.println(cookie.isHttpOnly()+" "+cookie.isSecure());
}
}


@AfterMethod
public void get_screenshot(ITestResult result)
{
if(result.getStatus()==ITestResult.FAILURE)
{
File f=((TakesScreenshot)d).getScreenshotAs(OutputType.FILE);
try 
{
	FileUtils.copyFileToDirectory(f,new File("C:\\Users\\HP\\Documents\\Screenshots\\selenium_practise screenshot of TC"));
} 
catch (IOException e)
{
	
	e.printStackTrace();
}
}
}
@AfterClass
public void delete_cookies()
{
d.manage().deleteAllCookies();

}
@AfterTest
public void db_closed()
{
System.out.println("databas closed");	
}
@AfterSuite
public void closed_browser()
{
	d.close();
	
}


}
