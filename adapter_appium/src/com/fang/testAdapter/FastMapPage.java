package com.fang.testAdapter;

import java.lang.reflect.Field;


/**
 * Created by fang on 18/1/19.
 */

public class FastMapPage
{
    public FastMapPage()
    {
        try
        {
            Field[] fields = this.getClass().getDeclaredFields();

            for (Field field : fields)
            {
                if (!field.isAnnotationPresent(FindResource.class))
                {
                    continue;
                }

                field.set(null, field.getName());
            }
        }
        catch (IllegalAccessException e)
        {
            e.printStackTrace();
        }
    }

    public void Click(int x, int y) throws InterruptedException
    {
        testadapter.Click(x, y);
        //mDevice.click(point.x, point.y);
        Thread.sleep(1000);
    }

    public void Click(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException 
    {

        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (annotation.ios_ignore())
        {
            return;
        }
        
        if (!annotation.ios_xpath().isEmpty())
        {
            testadapter.ClickByXPath(annotation.ios_xpath());
            //Thread.sleep(1000);
            return;
        }

        if (annotation.ios_x() != -1 && annotation.ios_y() != -1)
        {
        	testadapter.Click(annotation.ios_x(), annotation.ios_y());
        	Thread.sleep(1000);
        	return;
        }
        
        if (!annotation.Text().isEmpty())
        {
            testadapter.ClickByText(annotation.Text());
            Thread.sleep(1000);
            return;
        }
        
        if (!annotation.ios_predicate().isEmpty())
        {
        	testadapter.ClickByPredicate(annotation.ios_predicate());
        	return;
        }
        
        if (!annotation.ios_name().isEmpty())
        {
        	testadapter.ClickByPredicate("name == '" + annotation.ios_name() + "'");
        	return;
        }

        throw new RuntimeException("can not find id of " + findRes);
    }
    
    public void Click(Point p) throws InterruptedException
    {
        testadapter.Click(p.x/2, p.y/2);
        //mDevice.click(point.x, point.y);
        Thread.sleep(1000);
    }
    
    public void ClickCenter() throws InterruptedException
    {
        testadapter.Click(testadapter.getDisplayWidth()/2, testadapter.getDisplayHeight()/2);
        //mDevice.click(point.x, point.y);
        Thread.sleep(1000);
    }
    
    public void ClickbyText(String text) throws InterruptedException
    {
    	testadapter.ClickByText(text);
    }

    public void ClickbyText(String text, String ios_text) throws InterruptedException
    {
    	if(ios_text != null)
    	{
    		ClickByText(ios_text);
    	}
    	else
    	{
    		ClickByText(text);
    	}
    }
    
    public void SetValue(String findRes, String value) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.ios_xpath().isEmpty())
        {
            testadapter.SetValue(annotation.ios_xpath(), value);       
            return;
        }
        
        if (!annotation.ios_predicate().isEmpty())
        {
        	testadapter.SetValueByPredicate(annotation.ios_predicate(), value);
        	return;
        }
        
        if (!annotation.Text().isEmpty())
        {
        	testadapter.SetValueByText(annotation.Text(), value);
        	return;
        }
        
        throw new RuntimeException("can not find id of " + findRes);
    }

    public String GetValue(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.ios_xpath().isEmpty())
        {
        	return testadapter.GetValue(annotation.ios_xpath());
        }
        else if (!annotation.ios_predicate().isEmpty())
        {
        	return testadapter.GetValueByPredicate(annotation.ios_predicate());
        }
        
        throw new RuntimeException("can not find id of " + findRes);
    }

    public void ScrollClick(String findRes) throws NoSuchFieldException
    {
    	try
    	{
    		Click(findRes);
    	}
    	catch(Exception e)
    	{
            Field field = this.getClass().getDeclaredField("SCROLL");
            FindResource scrl_annotation = field.getAnnotation(FindResource.class);

            field = this.getClass().getDeclaredField(findRes);
            FindResource res_annotation = field.getAnnotation(FindResource.class);

            testadapter.ScrollClick(scrl_annotation.clazz(), res_annotation.clazz(), res_annotation.Text());
    	}

//        FindResource annotation = field.getAnnotation(FindResource.class);
//
//        UiScrollable objscoll = new UiScrollable(new UiSelector().className(annotation.clazz()));
//
//        field = this.getClass().getDeclaredField(findRes);
//        annotation = field.getAnnotation(FindResource.class);
//
//        //UiObject Object = objscoll.getChild(new UiSelector().text(annotation.Text()));
//        UiObject Object = objscoll.getChildByText(new UiSelector().className(annotation.clazz()), annotation.Text());
//        Object.click();
    }

//    public static void InitDevice(UiDevice device, String name)
//    {
//        mDevice = device;
//        packageName = name;
//    }

    public boolean isChecked(String findRes) throws NoSuchFieldException
    {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.ios_xpath().isEmpty())
        {
            return testadapter.isChecked(annotation.ios_xpath());
        }

        throw new RuntimeException("can not find id of " + findRes);
    }

    public boolean isExist(String findRes, int time) throws NoSuchFieldException
    {
        Field field = this.getClass().getDeclaredField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.ios_xpath().isEmpty())
        {
            return testadapter.isExist(annotation.ios_xpath(), time);
        }

        throw new RuntimeException("can not find id of " + findRes);
    }
    
    public boolean isExistByName(String name)
    {
    	return isExistByName(name, null);
    }
    
    public boolean isExistByName(String name, String ios_name) 
    {
		if(ios_name != null)
		{
			return testadapter.isExistByName(ios_name);
		}
    	return testadapter.isExistByName(name);
	}

    public void ClickByText(String value) throws InterruptedException
    {
    	ClickByText(value, null);
    }
    
    public void ClickByText(String value, String ios_name) throws InterruptedException
    {
    	if(ios_name != null)
    	{
    		testadapter.ClickByText(ios_name);
    		return;
    	}
		
		testadapter.ClickByText(value);
		return;
    }
    
    public void Drag(int startX, int startY, int endX, int endY, int steps)
    {
    	testadapter.Drag(startX/2, startY/2, endX/2, endY/2, steps/2);
    }
    
//    protected void CheckResource(UiObject2 object, ArrayList<UiObject2> listResult)
//    {
//        List<UiObject2> lst = object.getChildren();
//        for (UiObject2 obj : lst)
//        {
//            if (obj.getClassName().equals("android.widget.TextView"))
//            {
//                listResult.add(obj);
//            }
//
//            CheckResource(obj, listResult);
//        }
//
//    }
//    protected static UiDevice mDevice;
//    protected static String  packageName;
}