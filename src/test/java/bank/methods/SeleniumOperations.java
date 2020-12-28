package bank.methods;

import java.util.Hashtable;
import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumOperations {
	
	public static WebDriver driver=null;//--to perform web UI operations
	public static WebDriverWait wait=null;//---to achieve explicit wait
	public static WebDriver Assert=null;
	public static Hashtable<String,Object> outputParameters=new Hashtable<String,Object>();//---to return output
	/**
	 * Purpose: Used to Launch the Application for the given Browser
	 * @param : object[] 
	 * Accepts 3 Parameters : String strBrowserName, String WebDriverExePath,String strURL
	 * @return
	 * @throws Exception
	 */
	
	//To Launch Browser
	public static Hashtable<String,Object> LaunchApplication(Object[] inputParameters) throws Exception { 
		
		try
		{
			outputParameters.clear();
			String strBrowserName=(String)inputParameters[0];
			String WebDriverExePath=(String)inputParameters[1];
		//	String strURL=(String)inputParameters[2];
			if (strBrowserName.equalsIgnoreCase("FF"))
			{
				System.setProperty("webdriver.gecko.driver",WebDriverExePath);
				driver = new FirefoxDriver();
				driver.manage().window().maximize();
				//driver.navigate().to(strURL);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
				
			}
			else if(strBrowserName.equalsIgnoreCase("chrome"))
			{
				System.setProperty("webdriver.chrome.driver",WebDriverExePath);
				driver = new ChromeDriver();
				driver.manage().window().maximize();
			//	driver.navigate().to(strURL);
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
				
			
			}
			
			else if(strBrowserName.equalsIgnoreCase("IE"))
			{
				System.setProperty("webdriver.ie.driver",WebDriverExePath);
				driver = new InternetExplorerDriver();
				driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
			}	
			//----used for explicit wait
			wait=new WebDriverWait(driver, 60);
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("Message", "Action:LaunchApplication,Input Given:"+inputParameters[0].toString());
			
			
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[0].toString());
			//throw e;
		}
		return outputParameters;
	}
	
	

	//URL method
public static Hashtable<String,Object> Url(Object[] inputParameters) throws Exception { 
		
		try
		{
			
			String strURL=(String)inputParameters[0]; 
			driver.navigate().to(strURL);
			wait=new WebDriverWait(driver, 60);
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("Message", "Action:LaunchApplication,Input Given:"+inputParameters[0].toString());
			
			
		}
		catch(Exception e)
		{
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[0].toString());
			
			//throw e;
		}
		return outputParameters;
	}
	
	//For runtime object
 private static WebElement GetRunTimeObject(String xpath)
	 
	 {
		return wait.until(ExpectedConditions.presenceOfElementLocated(By.xpath(xpath)));
	 }
	 
 
//Usrname and Password sendkeys
	public static Hashtable<String,Object> SetText(Object[] inputParameters) throws Exception 
	{
		String xPathLocator=(String)inputParameters[0];
		
		String ValueToEnter=(String)inputParameters[1];
		try 
		{
			WebElement obj=GetRunTimeObject(xPathLocator);
			obj.clear();
			obj.sendKeys(ValueToEnter);
			
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("Message", "Action: SetText,Input Given:"+inputParameters[1].toString());
			
			
		}
		catch (Exception e)
		{
			
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[1].toString());
			
			//throw e;
		}
			return outputParameters;
		}
	
	//click operation
	 
	public static Hashtable<String,Object> Click(Object[] inputParameters) throws Exception 
	{
		String xPathLocator=(String)inputParameters[0];
		
		
		try 
		{
			WebElement obj1=GetRunTimeObject(xPathLocator);
			
			obj1.click();
			outputParameters.put("STATUS", "PASS");
			outputParameters.put("Message", "Action: Click,Input Given:"+inputParameters[0].toString());
			
			
		}
		catch (Exception e)
		{
			//throw e;
			//added
			outputParameters.put("STATUS", "FAIL");
			outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[0].toString());
		}
			return outputParameters;
			
		}
	
	
	
	
	//For DropDown
	
	public static Hashtable<String,Object> DropDown(Object[] inputParameters) throws Exception 
		{
			String WebElement=(String)inputParameters[0];
			String ByText=(String)inputParameters[1];
		//	int i=Integer.parseInt(ByText);
			
			try 
			{
				WebElement obj5=GetRunTimeObject(WebElement);
				Select sel=new Select(obj5);
			     //	sel.selectByIndex(i);
				sel.selectByVisibleText(ByText);
				
				
				outputParameters.put("STATUS", "PASS");
				outputParameters.put("Message", "Action: DropDown,Input Given:"+inputParameters[1].toString());
				 
				
			}
			catch (Exception e)
			{
				outputParameters.put("STATUS", "FAIL");
				outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[1].toString());	
				
				
				//throw e
			}
				return outputParameters;
			}
	
	//For Validation of login page both url must same

	public static Hashtable<String,Object> Validationloginpage(Object[] inputParameters) throws Exception 
		{
			
	   
		String String1=(String)inputParameters[0]; // we r giving  current url
		System.out.println("Givenip"+String1);
		wait=new WebDriverWait(driver, 60);
		 String String2=driver.getCurrentUrl();      // selenium get url 
		 wait=new WebDriverWait(driver, 60);
		 System.out.println("runtime"+String2);
			try 
			{
	         
			     	
			     if(String1.equalsIgnoreCase(String2))
				 
				{
					System.out.println("Pass");
					outputParameters.put("STATUS", "PASS");
					outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[0].toString());
					outputParameters.put("OP", true);
				} else 
				{
					System.out.println("fail");
					outputParameters.put("STATUS", "FAIL");
					outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[0].toString());
					outputParameters.put("OP", false);
				}
				
			  
			}
			catch (Exception e)
			{
				throw e;
			}
				return outputParameters;
				}

	//For Validation by getText method for Admin successful login 

	public static Hashtable<String,Object> Validation1(Object[] inputParameters) throws Exception 
		{

		String WebElement=(String)inputParameters[0];// we are giving xpath of Admin text on UI
		String String1=(String)inputParameters[1]; // we r giving  Admin as String
		System.out.println("Givennameonui"+String1);
		
		wait=new WebDriverWait(driver, 60);
		 WebElement web=driver.findElement(By.xpath(WebElement));
		 wait=new WebDriverWait(driver, 120);
		String String2= web.getText();
		System.out.println("byxpath"+ String2);
			try 
			{
	       
			     	
			     if(String1.equalsIgnoreCase(String2))
				 
				{
					System.out.println("Pass");
					outputParameters.put("STATUS", "PASS");
					outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[1].toString());
					outputParameters.put("OP", true);
				} else 
				{
				System.out.println("fail");
				outputParameters.put("STATUS", "FAIL");
				outputParameters.put("Message", "Action: Validation,Input Given:"+inputParameters[0].toString());
				outputParameters.put("OP", false);
				}
				
			  
			}
			catch (Exception e)
			{
				throw e;
			}
				return outputParameters;
				}



	
	
}
	