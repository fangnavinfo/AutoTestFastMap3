package com.fang.testAdapter;


import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileBy;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.File;
import java.io.FileInputStream;
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

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;

import net.sourceforge.htmlunit.cyberneko.parsers.SAXParser;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.tuple.Pair;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpDelete;
import org.apache.http.client.methods.HttpEntityEnclosingRequestBase;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.DefaultHttpClient;
import org.openqa.selenium.By;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.touch.TouchActions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebElement;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.xml.sax.SAXException;
import org.w3c.dom.Document;

public class testadapter 
{
	private static AppiumDriver driver;

	private static void InitAppiumDriver() throws MalformedURLException
	{
		//设置自动化相关参数
		DesiredCapabilities capabilities = new DesiredCapabilities();
			
		//capabilities.setCapability("appium-version", "1.1.0");
		capabilities.setCapability("platformVersion", "10.3");
		capabilities.setCapability("platformName", "ios");
		capabilities.setCapability("deviceName", "iPhone 6");
		capabilities.setCapability("automationName", "XCUITest");
		capabilities.setCapability("bundleId", "com.navinfo.fastmap.autumn");
		capabilities.setCapability("udid", "0641ba799efd8dda03e5da5705c98f1d8075a82b");
		capabilities.setCapability("preventWDAAttachments", false);
		
		System.out.println("设置自动化相关参数");
			
		driver = new AppiumDriver(new URL("http://127.0.0.1:4723/wd/hub"),capabilities );

		center_x = driver.manage().window().getSize().width/2;
		center_y = driver.manage().window().getSize().height/2;
		
		//设置等待秒数
		//driver.manage().timeouts().implicitlyWait(3, TimeUnit.SECONDS);
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
    	
		while(true)
		{
			WebElement elem = GetElement(annotation);
			if (!elem.isEnabled())
			{
				continue;
			}
			elem.click();
			break;
		}
    }
    
	public static void ClickByText(String text) throws InterruptedException
	{	 
		WebElement elem = GetElement(text);
		elem.click();
	}
	
	public static void ClickCenter()
	{
		Click(center_x, center_y);
	}
	
    public static void SetValue(FindResource annotation, String value) throws InterruptedException
    {
    	MobileElement elem = (MobileElement)GetElement(annotation);
    	elem.clear();
    	elem.setValue(value);

    	Click(driver.manage().window().getSize().width-50,driver.manage().window().getSize().height-50);

    }
    
    public static String GetValue(FindResource annotation) throws InterruptedException
    {
    	WebElement elem = GetElement(annotation);
    	String value = elem.getText();
    	if(value == null)
    	{
    		elem = elem.findElement(By.className("XCUIElementTypeStaticText"));
    		if(elem != null)
    		{
    			value = elem.getText();
    		}
    	}
    	
    	return value;
    }
    
    public static Boolean isExist(FindResource annotation) throws InterruptedException
    {
    	try
    	{
	    	WebElement elem = GetElement(annotation);
	    	if(elem != null)
	    	{
	    		return true;
	    	}
	    	
	    	return false;
    	}
       	catch(TimeoutException e)
    	{
    		return false;
    	}
    }
    
    public static boolean isExist(String name)
    {
    	try
    	{
	    	final String Text = name;
			WebDriverWait wait = new WebDriverWait(driver, 3);
			WebElement e = wait.until(new ExpectedCondition<WebElement>(){ 
				@Override 
				public WebElement apply(WebDriver d) { 
			    			return driver.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '" + Text + "'" + "OR label CONTAINS '" + Text + "'"));
			    	}
			});
			
			if(e != null)
			{
				return true;
			}
			
			return false;
    	}
    	catch(TimeoutException e)
    	{
    		return false;
    	}
    }
    
    public static void ScrollClick(FindResource scrl_annotation, FindResource target_annotation)
    {	
    	TouchAction action1 = new TouchAction(driver); 
    	
    	for(int i=0; i<5; i++)
    	{	 
	    	action1.press(scrl_annotation.ios_x(), scrl_annotation.ios_y()).moveTo(scrl_annotation.ios_x(), -200).release().perform() ;
	    	if(isExist(target_annotation.Text()))
	    	{
	    		return;
	    	}
    	}
    	
    	throw new NoSuchElementException();
    }
    
    public static boolean isChecked(FindResource annotation) throws InterruptedException
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
    
	public static void Initialize(String username, boolean isHmworking) throws Exception 
	{
		userName = username;
		isHmWorking = isHmworking; 
		
        Process prm = Runtime.getRuntime().exec("rm -rf ./temp");
		prm.waitFor();
		
        Process pmk = Runtime.getRuntime().exec("mkdir temp");
        pmk.waitFor();
        
        Process pmr = Runtime.getRuntime().exec("mkdir result");
        pmr.waitFor();
		
        FASTMAP_URL = "http://" + driver.findElement(By.name("login_ipLabel")).getText().trim() + "/";
        
        DownLoadFileFromFastMap(getUserId() + "_layout.plist", "layout.plist");
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
	
	public static void UpLoadFileToFastMap(String fileName) throws Exception 
	{  
        try 
        {  
            // 换行符  
            final String newLine = "\r\n";  
            final String boundaryPrefix = "--";  
            // 定义数据分隔线  
            String BOUNDARY = "----7d4a6d158c9";  
            // 服务器的域名  
            URL url = new URL(FASTMAP_URL + "/upload");  
            HttpURLConnection conn = (HttpURLConnection) url.openConnection();  
            // 设置为POST情  
            conn.setRequestMethod("POST");  
            // 发送POST请求必须设置如下两行  
            conn.setDoOutput(true);  
            conn.setDoInput(true);  
            conn.setUseCaches(false);  
            // 设置请求头参数  
            conn.setRequestProperty("connection", "Keep-Alive");  
            conn.setRequestProperty("Charsert", "UTF-8");  
            conn.setRequestProperty("Content-Type", "multipart/form-data; boundary=" + BOUNDARY);  
  
            OutputStream out = new DataOutputStream(conn.getOutputStream());  
  
            // 上传文件  
            File file = new File("./temp/" + fileName);  
            StringBuilder sb = new StringBuilder();  
            sb.append(boundaryPrefix);  
            sb.append(BOUNDARY);  
            sb.append(newLine);  
            // 文件参数,photo参数名可以随意修改  
            sb.append("Content-Disposition: form-data;name=\"files[]\";filename=\"" + fileName  
                    + "\"" + newLine);  
            sb.append("Content-Type:application/octet-stream");  
            // 参数头设置完以后需要两个换行，然后才是参数内容  
            sb.append(newLine);  
            sb.append(newLine);  
  
            // 将参数头的数据写入到输出流中  
            out.write(sb.toString().getBytes());  
  
            // 数据输入流,用于读取文件数据  
            DataInputStream in = new DataInputStream(new FileInputStream(file));  
            byte[] bufferOut = new byte[1024];  
            int bytes = 0;  
            // 每次读1KB数据,并且将文件数据写入到输出流中  
            while ((bytes = in.read(bufferOut)) != -1) {  
                out.write(bufferOut, 0, bytes);  
            }  
            // 最后添加换行  
            out.write(newLine.getBytes());  
            in.close();  
  
            // 定义最后数据分隔线，即--加上BOUNDARY再加上--。  
            byte[] end_data = (newLine + boundaryPrefix + BOUNDARY + boundaryPrefix + newLine)  
                    .getBytes();  
            // 写上结尾标识  
            out.write(end_data);  
            out.flush();  
            
            // 读取服务器返回结果  
            InputStream is = conn.getInputStream();  
            InputStreamReader isr = new InputStreamReader(is, "utf-8");  
            BufferedReader br = new BufferedReader(isr);  
            String result = br.readLine();  
            is.close();    
            //out.close();  
  
        } catch (Exception e) {  
        	throw e;
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
		
		try 
		{
			if(driver == null)
			{
				InitAppiumDriver();
			}
			else
			{
				driver.resetApp();
			}
		}
		catch (MalformedURLException e) 
		{
			
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
			//driver.manage().timeouts().implicitlyWait(0, TimeUnit.SECONDS);
			WebElement elem = driver.findElement(By.name("quality control"));
			mapKeyboardCurr = mapKeyboardQc;
		}
		catch(Exception e)
		{
			mapKeyboardCurr = mapKeyboard;
		}

		Pairs elem = mapKeyboardCurr.get(tips);
		
		final String FirstRes = elem.first;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement e = wait.until(new ExpectedCondition<WebElement>(){ 
			@Override 
			public WebElement apply(WebDriver d) { 
				return driver.findElement(By.xpath(FirstRes));
			}
		});
		e.click();

		final String SecondRes = elem.second;
		if(SecondRes.isEmpty())
		{
			return;
		}
		
		e = wait.until(new ExpectedCondition<WebElement>(){ 
			@Override 
			public WebElement apply(WebDriver d) { 
				return driver.findElement(By.xpath(SecondRes));
			}
		});
		e.click();
		
	} 
	
	public static void Drag(int startX, int startY, int endX, int endY, int steps)
    {
		new TouchAction(driver).press(startX, startY).moveTo(endX-startX, endY-startY).release().perform();
    }
	
	private static WebElement GetElement(FindResource annotation) throws InterruptedException
	{
		final FindResource testRes = annotation;
		
		WebDriverWait wait = new WebDriverWait(driver, 10);
		WebElement e = wait.until(new ExpectedCondition<WebElement>(){ 
			@Override 
			public WebElement apply(WebDriver d) { 
		    	if(!testRes.ios_xpath().isEmpty())
		    	{
		    		return driver.findElement(By.xpath(testRes.ios_xpath()));
		    	}
		    	else if(!testRes.ios_name().isEmpty())
		    	{
		    		return driver.findElement(By.name(testRes.ios_name()));
		    	}
		    	else if(!testRes.Text().isEmpty())
		    	{
		    		return driver.findElement(MobileBy.iOSNsPredicateString("name CONTAINS '" + testRes.Text() + "'" + " OR value CONTAINS '" + testRes.Text() + "'"));
		    	}
		    	else if(!testRes.ios_predicate().isEmpty())
		    	{
		    		return driver.findElement(MobileBy.iOSNsPredicateString(testRes.ios_predicate()));
		    	}
		    	
		    	return null;
			}
		});
		
		return e;
	}
	
	private static WebElement GetElement(String Text) throws InterruptedException
	{
		final String testRes = Text;
		WebElement e = null;
		
		try
		{
			WebDriverWait wait = new WebDriverWait(driver, 10);
			e = wait.until(new ExpectedCondition<WebElement>(){ 
				@Override 
				public WebElement apply(WebDriver d) { 
					return driver.findElement(MobileBy.iOSNsPredicateString("name == '" + testRes + "'"));
				}
			});
		}
		catch(Exception ex)
		{
			e = driver.findElement(MobileBy.iOSNsPredicateString("value CONTAINS '" + testRes + "'" + "OR label CONTAINS '" + testRes + "'"));
		}
		
		return e;
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
    	
    	String value1="//XCUIElementTypeButton[@name=\"menu_button%d\"]";
    	String value2="//XCUIElementTypeImage[@name=\"menu_sub_Container\"]/XCUIElementTypeButton[%d]";
    	
    	for(int i=0; i<leftList.size(); i++)
    	{
    		ArrayList<Object> listmp = (ArrayList<Object>)leftList.get(i);
    		if(listmp == null || listmp.isEmpty())
    		{
    			continue;
    		}
    		
        	String first = String.format(value1, i);
        	if(listmp.size() == 1)
        	{
        		mapKeyboard.put((String)listmp.get(0), new Pairs(first, ""));
        	}
        	else
        	{
            	for(int m=0; m<listmp.size(); m++)
            	{
            		mapKeyboard.put((String)listmp.get(m), new Pairs(first, String.format(value2, m+1)));
            	}
        	}
    	}
    	
    	for(int i=0; i<bottomList.size(); i++)
    	{
    		ArrayList<Object> listmp = (ArrayList<Object>)bottomList.get(i);
    		if(listmp == null || listmp.isEmpty())
    		{
    			continue;
    		}
    		
        	String first = String.format(value1, i+5);
        	if(listmp.size() == 1)
        	{
        		mapKeyboard.put((String)listmp.get(0), new Pairs(first, ""));
        	}
        	else
        	{
            	for(int m=0; m<listmp.size(); m++)
            	{
            		mapKeyboard.put((String)listmp.get(m), new Pairs(first, String.format(value2, m+1)));
            	}
        	}
    	}
    	
    	Collections.reverse(RightList);
    	for(int i=0; i<RightList.size(); i++)
    	{
    		ArrayList<Object> listmp = (ArrayList<Object>)RightList.get(i);
    		if(listmp == null || listmp.isEmpty())
    		{
    			continue;
    		}
    		
        	String first = String.format(value1, i+17);
        	if(listmp.size() == 1)
        	{
        		mapKeyboard.put((String)listmp.get(0), new Pairs(first, ""));
        	}
        	else
        	{
            	for(int m=0; m<listmp.size(); m++)
            	{
            		mapKeyboard.put((String)listmp.get(m), new Pairs(first, String.format(value2, m+1)));
            	}
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
	private static String FASTMAP_URL;
	
	private static int center_x;
	private static int center_y;
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
		driver.resetApp();
	}

	public static void ClearWal()
	{
		// TODO Auto-generated method stub
		
	}

	public static void CapScreen(String methodName) 
	{
		File screen = driver.getScreenshotAs(OutputType.FILE);
		File screenFile = new File("./result/" + methodName + ".png");
		try 
		{
		    FileUtils.copyFile(screen, screenFile); //commons-io-2.0.1.jar中的api
		} 
		catch (IOException e) 
		{
		    e.printStackTrace();
		}	
	}

	public static void ClearCap() 
	{
        
		try 
		{
			Process pmk;
			pmk = Runtime.getRuntime().exec("rm -rf result");
			pmk.waitFor();
		} 
		catch (Exception e) 
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        
		
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

