package com.fang.testAdapter;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.TouchAction;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import net.sourceforge.htmlunit.cyberneko.parsers.SAXParser;

import org.apache.commons.lang3.tuple.Pair;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

public class testadapter 
{
	private static AppiumDriver driver;
			
	public static void ClickByText(String text) throws InterruptedException
	{
		try
		{
			driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '" + text + "'")).click();
		}
		catch (Exception e)
		{
			driver.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '" + text + "'")).click();
		}
	}
	
	public static void ClickById(String Id) throws InterruptedException
	{
		driver.findElement(By.id(Id)).click();
	}
	
	public static void ClickByXPath(String xpath) throws InterruptedException
	{
		while(true)
		{
			WebElement elem = driver.findElement(By.xpath(xpath));
			if (!elem.isEnabled())
			{
				continue;
			}
			elem.click();
			break;
		}
	}
	
	public static void ClickByPredicate(String text) throws InterruptedException
	{
		driver.findElement(MobileBy.iOSNsPredicateString(text)).click();
	}
	
	
	private static void InitAppiumDriver() throws MalformedURLException
	{
		//设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
			
		capabilities.setCapability("appium-version", "1.1.0");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("bundleId", "com.navinfo.fastmap.spring");
		capabilities.setCapability("udid", "0641ba799efd8dda03e5da5705c98f1d8075a82b");
			
		System.out.println("设置自动化相关参数");
			
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities );

		//设置等待秒数
		driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
		System.out.println("初始化 AppiumDriver");
	}
	
    public static void Click(int x, int y)
    {
    	TouchAction action = new TouchAction(driver);
    	action.tap(x, y).perform();
    }

    public static void Click(String Id)
    {

    }

    public static void SetValue(String xpath, String value)
    {
    	WebElement elem = driver.findElement(By.xpath(xpath));
    	elem.clear();
    	elem.sendKeys(value);
    	driver.hideKeyboard();
    }

    public static void SetValueByPredicate(String Predicate, String value)
    {
    	WebElement elem = driver.findElement(MobileBy.iOSNsPredicateString(Predicate));
    	elem.clear();
    	elem.sendKeys(value);
    	driver.hideKeyboard();
    }
    
    public static void SetValueByText(String text, String value)
    {
    	WebElement elem = null;
    	try
    	{
    		elem = driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '" + text + "'"));
    	}
		catch (Exception e)
		{
			elem = driver.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '" + text + "'"));
		}
    	elem.clear();
    	elem.sendKeys(value);
    	driver.hideKeyboard();
    }
    
    public static String GetValue(String xpath)
    {
    	return driver.findElement(By.xpath(xpath)).getText();
    }

    public static String GetValueByPredicate(String Predicate)
    {
    	return driver.findElement(MobileBy.iOSNsPredicateString(Predicate)).getText();
    }
    
    public static void ScrollClick(String clazz, String clazz1, String text)
    {

    }
    
    public static boolean isChecked(String xpath)
    {
    	return driver.findElement(By.xpath(xpath)).isSelected();
    }
    
    public static boolean isExist(String xpath, int time)
    {
    	try
    	{
        	WebElement elem = driver.findElement(By.xpath(xpath));
        	if (elem == null)
        	{
        		return false;
        	}
        	
        	return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }

    public static boolean isExistByPredicate(String text)
    {
    	try
    	{
	    	WebElement elem = driver.findElement(MobileBy.iOSNsPredicateString(text));
	    	if (elem == null)
	    	{
	    		return false;
	    	}
	    	
	    	return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }
    
    public static boolean isExistByName(String name)
    {
    	try
    	{
	    	WebElement elem = driver.findElement(By.name(name));
	    	if (elem == null)
	    	{
	    		return false;
	    	}
	    	
	    	return true;
    	}
    	catch(Exception e)
    	{
    		return false;
    	}
    }

    
	public static void Initialize(String username, boolean isHmworking) throws IOException, InterruptedException 
	{
		// TODO Auto-generated method stub
		
		userName = username;
		isHmWorking = isHmworking;
		
		String mnpath = "./test";
		Process p = Runtime.getRuntime().exec("pwd");
		p.waitFor();
		readProcessOutput(p);
		
		p = Runtime.getRuntime().exec("mkdir " + mnpath);
		p.waitFor();
		
		p = Runtime.getRuntime().exec("umount " + mnpath);
		p.waitFor();
		
		p = Runtime.getRuntime().exec("ifuse --container com.navinfo.fastmap.spring " + mnpath);													
		p.waitFor();
		readProcessOutput(p);
        
		userPath = mnpath + "/Library/FastMap3/data/collect/" + getUserId() + "/";
		
		Sqlitetools.initialize(userPath);
	}
	
	public static void CreateMainBoard() throws IOException
	{
        try 
        {
			InitializeKeyboard();
		} 
        catch (ParserConfigurationException | SAXException e) 
        {
			e.printStackTrace();
		}
	}
	public static void ReStartApp() 
	{
		// TODO Auto-generated method stub
		try {
			InitAppiumDriver();
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	public static void ClearCollect() throws IOException, InterruptedException 
	{

		Process p = Runtime.getRuntime().exec("rm -r " + userPath + "coremap.sqlite");  
		p.waitFor();
		readProcessOutput(p);
		
		p = Runtime.getRuntime().exec("rm -r " + userPath + "coremap.wal");  
		p.waitFor();
		readProcessOutput(p);
		
		p = Runtime.getRuntime().exec("rm -r " + userPath + "coremap.shm");  
		p.waitFor();
		readProcessOutput(p);	
	}

	public static void TriggeInMainBoard(String tips) throws InterruptedException
	{
		HashMap<String, Pairs> mapKeyboardCurr = null;
		
		try
		{
			driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement elem = driver.findElement(By.xpath("//XCUIElementTypeButton[@name=\"quality control\"]"));
			mapKeyboardCurr = mapKeyboardQc;
		}
		catch(Exception e)
		{
			mapKeyboardCurr = mapKeyboard;
		}

		Pairs elem = mapKeyboardCurr.get(tips);
		
		for(int i=0; i<5; i++)
		{
			try
			{
				driver.findElement(By.xpath(elem.first)).click();
				break;
			}
			catch(Exception e)
			{
				Thread.sleep(500);
			}
		}


		if(!elem.second.isEmpty())
		{
			Thread.sleep(1000);
			driver.findElement(By.xpath(elem.second)).click();
		}
		
		// TODO Auto-generated method stub
//		switch(tips)
//		{
//		case "9001":
//			{
//				 driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[1]")).click();
//				 driver.findElement(By.xpath("//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeImage[2]/XCUIElementTypeButton[1]")).click();
//			}
//			break;
//			
//		default:
//			break;
//		}
	} 
	
	public static void Drag(int startX, int startY, int endX, int endY, int steps)
    {
		new TouchAction(driver).press(startX, startY).moveTo(endX, endY).release().perform();
    }
	
	private static void readProcessOutput(final Process process) {
        // 将进程的正常输出在 System.out 中打印，进程的错误输出在 System.err 中打印
        read(process.getInputStream(), System.out);
        read(process.getErrorStream(), System.err);
    }

    // 读取输入流
    private static void read(InputStream inputStream, PrintStream out) {
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

            String line;
            while ((line = reader.readLine()) != null) {
                out.println(line);
            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                inputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
    
    private static void InitializeKeyboard() throws ParserConfigurationException, SAXException, IOException
    {
    	SAXParserFactory factorys = SAXParserFactory.newInstance();  
    	javax.xml.parsers.SAXParser saxparser = factorys.newSAXParser();  
    	PlistHandler plistHandler = new PlistHandler();  
    	saxparser.parse(userPath+ getUserId() + "_layout.plist", plistHandler);  
    	

    	HashMap<String, Object> hash = plistHandler.getMapResult();  
    	
    	InitMapKeyboard(mapKeyboard, hash, "integrated");
    	InitMapKeyboard(mapKeyboardQc, hash, "road");
    }
    

	private static void InitMapKeyboard(HashMap<String, Pairs> mapKeyboard,
			HashMap<String, Object> hash, String string) 
	{
    	ArrayList<Object> leftList = new ArrayList<Object>();
    	ArrayList<Object> bottomList = new ArrayList<Object>();
    	ArrayList<Object> RightList = new ArrayList<Object>();
    	
    	ArrayList<Object> list = (ArrayList<Object>)hash.get(string);
    	for(int i=0; i<list.size(); i++)
    	{
    		if(i<5)
    		{
    			leftList.add(list.get(i));
    			continue;
    		}
    		if(i<17)
    		{
    			bottomList.add(list.get(i));
    			continue;
    		}
    		
    		RightList.add(list.get(i));
    	}
    	
    	Collections.reverse(RightList);
    	
    	String value1="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther/XCUIElementTypeOther[2]/XCUIElementTypeOther/XCUIElementTypeButton[%d]";
    	String value2="//XCUIElementTypeApplication[@name=\"FastMap-18秋\"]/XCUIElementTypeWindow[1]/XCUIElementTypeOther[3]/XCUIElementTypeImage[%d]/XCUIElementTypeButton[%d]";
    	
    	int index = 1;
    	for(int i=0; i<5; i++)
    	{
    		if(leftList.get(i) != null)
    		{
              	ArrayList<Object> listmp = (ArrayList<Object>)leftList.get(i);
            	if(!listmp.isEmpty())
            	{
	            	String first = String.format(value1, index++);
	            	if(listmp.size() == 1)
	            	{
	            		mapKeyboard.put((String)listmp.get(0), new Pairs(first, ""));
	            	}
	            	else
	            	{
	                	for(int m=0; m<listmp.size(); m++)
	                	{
	                		mapKeyboard.put((String)listmp.get(m), new Pairs(first, String.format(value2, 2, m+1)));
	                	}
	            	}	
            	}
    		}
    		if(RightList.get(i) != null)
    		{       	
              	ArrayList<Object> listmp = (ArrayList<Object>)RightList.get(i);
            	if(!listmp.isEmpty())
            	{
	            	String first = String.format(value1, index++);
	            	if(listmp.size() == 1)
	            	{
	            		mapKeyboard.put((String)listmp.get(0), new Pairs(first, ""));
	            		continue;
	            	}
	            	else
	            	{
		            	for(int m=0; m<listmp.size(); m++)
		            	{
		            		mapKeyboard.put((String)listmp.get(m), new Pairs(first, String.format(value2, 2, m+1)));
		            	}
	            	}
            	}
    		}
    	}
    	
    	for(int i=0; i<bottomList.size(); i++)
    	{
          	ArrayList<Object> listmp = (ArrayList<Object>)bottomList.get(i);
        	if(listmp.isEmpty())
        	{
        		continue;
        	}
        	
        	String first = String.format(value1, index++);
        	if(listmp.size() == 1)
        	{
        		mapKeyboard.put((String)listmp.get(0), new Pairs(first, ""));
        		continue;
        	}
        	for(int m=0; m<listmp.size(); m++)
        	{
        		mapKeyboard.put((String)listmp.get(m), new Pairs(first, String.format(value2, 1, m+1)));
        	}
    	}
    	

    	mapKeyboard.put("StartEndPoint", mapKeyboard.get("1500"));
    	
    	
	}

	 static int getDisplayWidth() 
	{
		return driver.manage().window().getSize().width;
	};
	
	 static int getDisplayHeight() 
	{
		return driver.manage().window().getSize().height;
	};

	private static String getUserId()
	{
        switch (userName)
        {
            case "collector":
                return "21";

            case "collector1":
            	return "23";

            case "collector2":
            	return "24";

            case "zhanglingling03655":
            	return "3655";

            default:
                throw new RuntimeException("can not find userid of " + userName);
        }
	}
	
	private static String userPath;
	private static HashMap<String, Pairs> mapKeyboard = new HashMap<String, Pairs>();
	private static HashMap<String, Pairs> mapKeyboardQc = new HashMap<String, Pairs>();
	private static boolean isHmWorking;
	private static String  userName;
	static class Pairs
	{
		Pairs(String v1, String v2)
		{
			first = v1;
			second = v2;
		}
		
		String first;
		String second;
	}
}

