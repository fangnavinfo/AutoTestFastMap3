package com.fang.testAdapter;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.PrintStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.NoSuchElementException;
import java.util.concurrent.TimeUnit;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import net.sourceforge.htmlunit.cyberneko.parsers.SAXParser;

import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
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
			try
			{
				driver.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '" + text + "'")).click();
			}
			catch (Exception e1)
			{
				driver.findElement(MobileBy.iOSNsPredicateString("label CONTAINS '" + text + "'")).click();
			}
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
			int count = 0;
			//try
			{
				WebElement elem = driver.findElement(By.xpath(xpath));
				if (!elem.isEnabled())
				{
					continue;
				}
				elem.click();
				break;
			}
//			catch(org.openqa.selenium.NoSuchElementException e)
//			{
//				if(count > 6)
//				{
//					throw e;
//				}
//				else
//				{
//					count++;
//					Thread.sleep(500);
//					continue;
//				}
//			}
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
		capabilities.setCapability("bundleId", "com.navinfo.fastmap.autumn");
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

    public static void Click(FindResource annotation) throws InterruptedException
    {
    	if (annotation.ios_x() != -1 && annotation.ios_y() != -1)
    	{
    		Click(annotation.ios_x(), annotation.ios_y());
    		Thread.sleep(1000);
	      	return;
	    }
    	
    	int count = 0;
    	
		while(true)
		{
			try
			{
				WebElement elem = GetElement(annotation);
				if (!elem.isEnabled())
				{
					continue;
				}
				elem.click();
				break;
			}
			catch(org.openqa.selenium.NoSuchElementException e)
			{
				if(count > 6)
				{
					throw e;
				}
				else
				{
					count++;
					Thread.sleep(500);
					continue;
				}
			}
		}
    }

    public static void SetValue(String xpath, String value)
    {
    	MobileElement elem = (MobileElement)driver.findElement(By.xpath(xpath));
    	elem.clear();
    	elem.sendKeys(value);
    	driver.hideKeyboard();
    }

    public static void SetValueByPredicate(String Predicate, String value)
    {
    	MobileElement elem = (MobileElement)driver.findElement(MobileBy.iOSNsPredicateString(Predicate));
    	elem.clear();
    	elem.setValue(value);
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
    
    public static void ScrollClick(FindResource scrl_annotation, FindResource target_annotation)
    {	
    	TouchAction action1 = new TouchAction(driver); 
    	
    	for(int i=0; i<5; i++)
    	{	 
	    	action1.press(scrl_annotation.ios_x(), scrl_annotation.ios_y()).moveTo(scrl_annotation.ios_x(), -200).release().perform() ;
	    	if(isExistByName(target_annotation.Text()))
	    	{
	    		return;
	    	}
    	}
    	
    	throw new NoSuchElementException();
    	
//    	WebElement  element = driver.findElementByXPath("//XCUIElementTypeStaticText[@name=\"同一关系\"]");  
//
//  
//    	HashMap<String, String> scrollObject = new HashMap<String, String>();  
//    	scrollObject.put("element", ((RemoteWebElement) element).getId());
//
//    	scrollObject.put("direction", "up"); 
//    	
//    	while(true)
//    	{
//	    	
//	    	driver.executeScript("mobile: scroll", scrollObject);
//	    	
////	    	WebElement elem = driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '退出登录'"));
////	    	elem.click();
////	    	break;
//    	}
    }
    
    public static boolean isChecked(FindResource annotation)
    {
    	WebElement elem = GetElement(annotation);

    	try
    	{
    		return elem.isSelected();
    	}
    	catch(Exception e)
    	{
    		try
    		{
	    		String value = elem.getAttribute("value");
	    		if (value.equals("1"))
	    		{
	    			return true;
	    		}
	    		return false;
    		}
    		catch(Exception e2)
    		{
    			return false;
    		}
    	}	
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

    
	public static void Initialize(String username, boolean isHmworking) throws Exception 
	{
		userName = username;
		isHmWorking = isHmworking; 
		
        Process prm = Runtime.getRuntime().exec("rm -rf ./temp");
		prm.waitFor();
		
        Process pmk = Runtime.getRuntime().exec("mkdir temp");
        pmk.waitFor();
		
        DownLoadFileFromFastMap(getUserId() + "_layout.plist", "layout.plist");
 
//		String mnpath = "./test";
//		Process p = Runtime.getRuntime().exec("pwd");
//		p.waitFor();
//		readProcessOutput(p);
//		
//		p = Runtime.getRuntime().exec("mkdir " + mnpath);
//		p.waitFor();
//		
//		p = Runtime.getRuntime().exec("umount " + mnpath);
//		p.waitFor();
//		
//		p = Runtime.getRuntime().exec("ifuse --container com.navinfo.fastmap.summer " + mnpath);													
//		p.waitFor();
//		readProcessOutput(p);
//        
//		userPath = mnpath + "/Library/FastMap3/data/collect/" + getUserId() + "/";
//		
//		Sqlitetools.initialize(userPath);
	}
	
	public static void DownLoadFileFromFastMap(String urlPath, String name) throws Exception 
	{
		HttpURLConnection conn = null;
		try
		{	
	        URL mURL = new URL(FASTMAP_URL+"download?path=/data/collect/"+getUserId() +"/"+ urlPath);  
	        conn = (HttpURLConnection) mURL.openConnection();  
	        
	        conn.setRequestMethod("GET");  
	        conn.setReadTimeout(5000);  
	        conn.setConnectTimeout(10000);
	        
	        int responseCode = conn.getResponseCode();  
	        if (responseCode != 200) 
	        {
	        	throw new RuntimeException("http download failed! rscode=" + Integer.toString(responseCode) +" url=" + mURL.toString());
	        }
	        
	        InputStream is = conn.getInputStream();  
	        
	        File file = new File("./temp/" + name);
	        file.createNewFile();
	        
	        OutputStream of = new FileOutputStream(file);
	      
	        byte[] b=new byte[1024];
            int len=0;
            while((len=is.read(b))!=-1)
            {  //先读到内存  
            	of.write(b, 0, len);
            }
            of.flush();
		}
		catch (Exception e)
		{
			throw e;
		}
		finally
		{
            if (conn != null) 
            {  
                conn.disconnect();  
            }  
		} 
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
		
		String url = "/data/collect/"+getUserId() +"/" + "coremap.";
		String urls[] = {url+"sqlite", url+"wal", url+"shm"};
		
		for(String s : urls)
		{
			try
			{	
				String json = "path=" + s;
		        HttpEntity entity = new StringEntity(json);
		        
		        HttpClient httpClient = new DefaultHttpClient();
		        
		        HttpDeleteWithBody httpDeleteWithBody = new HttpDeleteWithBody(FASTMAP_URL+"/delete");
		        httpDeleteWithBody.setHeader("Content-Type", "application/x-www-form-urlencoded");
		        httpDeleteWithBody.setEntity(entity);

		        HttpResponse response = httpClient.execute(httpDeleteWithBody);
			}			
			catch (Exception e)
			{
				continue;
			}
			finally
			{

			}
		}
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
		
		int count = 0;
		while(true)
		{
			try
			{
				count++;
				driver.findElement(By.xpath(elem.first)).click();
				break;
			}
			catch(Exception e)
			{
				if(count == 3)
				{
					throw e;
				}
				
				Thread.sleep(500);
			}
		}


		if(!elem.second.isEmpty())
		{
			Thread.sleep(2000);
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
		new TouchAction(driver).press(startX, startY).moveTo(endX-startX, endY-startY).release().perform();
    }
	
	private static WebElement GetElement(FindResource annotation)
	{
    	if(!annotation.ios_xpath().isEmpty())
    	{
    		return driver.findElement(By.xpath(annotation.ios_xpath()));
    	}
    	else if(!annotation.ios_name().isEmpty())
    	{
    		return driver.findElement(MobileBy.iOSNsPredicateString("name == '" + annotation.ios_name() + "'"));
    	}
    	else if(!annotation.Text().isEmpty())
    	{
    		try
    		{
    			return driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '" + annotation.Text() + "'"));
    		}
    		catch (Exception e)
    		{
    			return driver.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '" + annotation.Text() + "'"));
    		}
    	}
    	
		return null;
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
    	saxparser.parse("./temp/layout.plist", plistHandler);  
    	

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
	private static final String FASTMAP_URL = "http://172.19.43.40/";
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
	
	public static void StopApp() 
	{
		// TODO Auto-generated method stub
		driver.close();
	}

	public static void ClearWal()
	{
		// TODO Auto-generated method stub
		
	}
}

class HttpDeleteWithBody extends HttpEntityEnclosingRequestBase {
    public static final String METHOD_NAME = "POST";
    public String getMethod() { return METHOD_NAME; }

    public HttpDeleteWithBody(final String uri) {
        super();
        setURI(URI.create(uri));
    }
    public HttpDeleteWithBody(final URI uri) {
        super();
        setURI(uri);
    }
    public HttpDeleteWithBody() { super(); }
}

