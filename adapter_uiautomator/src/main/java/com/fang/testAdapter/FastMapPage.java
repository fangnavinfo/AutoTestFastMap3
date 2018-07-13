package com.fang.testAdapter;

import android.support.test.uiautomator.UiObjectNotFoundException;

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

    public void Click(Point p) throws InterruptedException
    {
        testadapter.Click(p.x, p.y);
        Thread.sleep(1000);
    }

    public void CtrlFling(Point p,String findRes) throws NoSuchFieldException, ClassNotFoundException
    {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty()) {
            //testadapter.Click(annotation.Id());
            testadapter.CtrlFling(p.x, p.y, annotation.Id());
        }
    }
    public void Click(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        try
        {

            Field field = GetField(findRes);

            FindResource annotation = field.getAnnotation(FindResource.class);
            if (!annotation.Id().isEmpty())
            {
                testadapter.Click(annotation.Id());

                return;
            }

            if (!annotation.Text().isEmpty())
            {
                testadapter.ClickByText(annotation.Id());

                return;
            }

            throw new RuntimeException("can not find id of " + findRes);
        }
        catch (NullPointerException e)
        {
            try
            {
                this.getClass().getDeclaredField("SCROLL");
            }
            catch (Exception e1)
            {
                throw e;
            }

            ScrollClick(findRes);
        }


        Thread.sleep(1000);
    }

    public void ClickCenter() throws InterruptedException
    {
        Point p =  new Point(testadapter.getDisplayWidth()/2, testadapter.getDisplayHeight()/2);
        Click(p);
    }

    public void ClickbyText(String text)
    {
        testadapter.ClickByText(text);
    }
    
    public void ClickbyText(String text, String ios_text)
    {
        testadapter.ClickByText(text);
    }

    public void SetValue(String findRes, String value) throws NoSuchFieldException, ClassNotFoundException, InterruptedException {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            testadapter.SetValue(annotation.Id(), value);

//            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, annotation.Id())), 500);
//            obj.setText(value);
        }
    }

    public String GetValue(String findRes) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            return testadapter.GetValue(annotation.Id());
        }
        else
        {
            return "";
        }
    }

    public boolean isExistByName(String name)
    {
        return testadapter.isExistByName(name);
    }

    public boolean isExistByName(String name, String ios_name)
    {
        return testadapter.isExistByName(name);
    }

    public void ScrollClick(String findRes) throws NoSuchFieldException
    {
        Field field = GetField("SCROLL");
        FindResource scrl_annotation = field.getAnnotation(FindResource.class);

        field = this.getClass().getDeclaredField(findRes);
        FindResource res_annotation = field.getAnnotation(FindResource.class);

        testadapter.ScrollClick(scrl_annotation.clazz(), res_annotation.clazz(), res_annotation.Text());
//
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
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            return testadapter.isChecked(annotation.Id());
        }

        throw new RuntimeException("can not find id of " + findRes);
    }

    public boolean isCheckedbyIndex(String findRes,int index) throws NoSuchFieldException, ClassNotFoundException, InterruptedException, UiObjectNotFoundException {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.clazz().isEmpty())
        {
            return testadapter.isCheckedbyIndex(annotation.clazz(), index);
        }
        throw new RuntimeException("can not find id of " + findRes);
    }
    public boolean isExist(String findRes, int time) throws NoSuchFieldException
    {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.Id().isEmpty())
        {
            return testadapter.isExist(annotation.Id(), time);
        }

        throw new RuntimeException("can not find id of " + findRes);
    }

    public void ClickByText(String value, String ios_value)
    {
        testadapter.ClickByText(value);
    }

    public void ClickByText(String value)
    {
        testadapter.ClickByText(value);
    }

    public void Drag(int startX, int startY, int endX, int endY, int steps) throws InterruptedException
    {
        testadapter.Drag(startX, startY, endX, endY, steps);
    }


    public  void ClickByIndex(String findRes, int index) throws Exception
    {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.clazz().isEmpty())
        {
            testadapter.ClickByIndex(annotation.clazz(), index);
        }

    }

    public void ScrollOneStep()
    {
        testadapter.ScrollOneStep();
    }

    public final static boolean IS_OS_TEST = false;

    private Field GetField(String findRes) throws NoSuchFieldException
    {
        try
        {
            return this.getClass().getDeclaredField(findRes);
        }
        catch (NoSuchFieldException e)
        {
            return this.getClass().getSuperclass().getDeclaredField(findRes);
        }
    }


    public String GetValuebyIndex(String findRes,int index) throws NoSuchFieldException, ClassNotFoundException, InterruptedException, UiObjectNotFoundException {
        Field field = GetField(findRes);

        FindResource annotation = field.getAnnotation(FindResource.class);
        if (!annotation.clazz().isEmpty())
        {
            return testadapter.GetValuebyIndex(annotation.clazz(), index);
        }
        else
        {
            return "";
        }
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