package how_to_access_prop_dataprov_excel_xml;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;
import java.util.Set;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.junit.AfterClass;
import org.openqa.selenium.By;
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
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
public class implementation_of_pf_dp_excel_xml
{
	public WebDriver d;

	Properties p=new Properties();
	
	
	@BeforeSuite
	public void launchbrowser()
	{
	try
	{
	FileInputStream file=new FileInputStream("E:\\Mobile_automation\\Selenium_Practise_Self\\src\\Property_File\\vtiger.propeties");
	p.load(file);
	}
		
	catch (Exception e)
	{
		e.printStackTrace();
	}
	
	WebDriverManager.chromedriver().setup();
	d=new ChromeDriver();
	}

	@BeforeTest
	public void launchurl()
	{
	d.get(p.getProperty("link"));	
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
@Test(priority = 1)
public void property_file() throws AWTException
{
	Robot r=new Robot();
	
	d.findElement(By.name("user_name")).sendKeys(p.getProperty("username"));
	d.findElement(By.name("user_password")).sendKeys(p.getProperty("pass"));
    d.findElement(By.xpath("//option[text()='nature']")).click();
    d.findElement(By.name("Login")).click();
}

@Test(priority=2,dataProvider = "lead_data")
public void lead_data_dataprovider(String ln,String comp,String design,String lead) throws InterruptedException
{
	d.findElement(By.linkText("New Lead")).click();
	d.findElement(By.xpath("//option[text()='Mr.']")).click();
	d.findElement(By.name("lastname")).sendKeys(ln);
	d.findElement(By.name("company")).sendKeys(comp);
	d.findElement(By.name("designation")).sendKeys(design);
    d.findElement(By.xpath("//select[@name='leadsource']")).sendKeys(lead);
    
   Thread.sleep(3000);
   d.findElement(By.xpath("//option[text()='Mr.']")).click();
	d.findElement(By.name("lastname")).clear();
}

public void xml_file()
{
	
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
		//d.close();
		
	}

@DataProvider
public Object[][] lead_data()
{
	return new Object[][]
			{
		new Object[] {"subodh","criotosoft","automation enginer","Employee"},
		new Object[] {"Rahul","criotosoft","automation engineer","Employee"}
			};
			
}

}
