package com.fang.testAdapter;

import android.content.Context;
import android.content.Intent;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import java.io.IOException;

import static junit.framework.Assert.fail;

/**
 * Created by fang on 18/1/26.
 */
public class testadapter
{
    public static void Click(int x, int y)
    {
        mDevice.click(x, y);
    }

    public static void Click(String Id) throws InterruptedException
    {
        while(true)
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, Id)), 50000);
            try{
                if (!obj.isEnabled())
                {
                    Thread.sleep(500);
                    continue;
                }

                obj.click();
                break;
            }catch(StaleObjectException e){
                Thread.sleep(10000);
                continue;
            }
        }
    }

    public static void ClickByText(String text)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.text(text)), 5000);
        obj.click();
    }

    public static void SetValue(String id, String value)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, id)), 500);
        obj.setText(value);
    }

    public static String GetValue(String id)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, id)), 500);
        return obj.getText();
    }

    public static int getDisplayWidth()
    {
        return mDevice.getDisplayWidth();
    }

    public static int getDisplayHeight()
    {
        return  mDevice.getDisplayHeight();
    }

    public static void ScrollClick(String clazz, String clazz1, String text)
    {
        try
        {
            UiScrollable objscoll = new UiScrollable(new UiSelector().className(clazz));

            UiObject Object = objscoll.getChildByText(new UiSelector().className(clazz1), text);
            Object.click();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }

    }

    public static boolean isChecked(String id)
    {
        try
        {
            UiObject2 hm = mDevice.findObject(By.res(packageName, id));
            return hm.isChecked();
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void TriggeInMainBoard(String id) throws Exception
    {
        MainBoardUI.pressBtnMainBoard(id);
    }

    public static boolean isExist(String id)
    {
        return isExist(id, 500);
    }

    public static boolean isExist(String id, int time)
    {
        try
        {
            UiObject2 hm = mDevice.wait(Until.findObject(By.res(packageName, id)), time);
            if (hm != null)
            {
                return true;
            }

            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static boolean isExistByName(String name)
    {
        try
        {
            UiObject2 hm = mDevice.wait(Until.findObject(By.text(name)), 500);
            if (hm != null)
            {
                return true;
            }

            return false;
        }
        catch (Exception e)
        {
            return false;
        }
    }

    public static void ReStartApp()
    {
        try
        {
            mDevice.executeShellCommand("am force-stop " + packageName);

            Context context = InstrumentationRegistry.getInstrumentation().getContext();
            Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
            intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
            context.startActivity(intent);

            UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "login_btn")), 10*1000);
            if (object == null)
            {
                fail("fast map not start!");
            }
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void ClearCollect()
    {
        try
        {
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.sqlite");
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.shm");
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.wal");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void Initialize(String userName, boolean isHK) throws Exception
    {
        InitUserPath(userName, isHK);
        Sqlitetools.initialize(userPath);

    }

    public static void CreateMainBoard() throws Exception
    {
        MainBoardUI.initialize(mDevice, packageName);
    }

    public static void Drag(int startX, int startY, int endX, int endY, int steps) throws InterruptedException
    {
        Thread.sleep(500);
        mDevice.drag(startX, startY, endX, endY, steps);
        Thread.sleep(500);
    }

    private static void InitUserPath(String userName, boolean isHK) throws IOException
    {
        String rslt = mDevice.executeShellCommand("ls /sdcard/");
        String[] array  = rslt.split("\n");

        String dirName = "";
        for (int i=0; i<array.length; i++)
        {
            if (array[i].contains("FastMap"))
            {
                dirName = array[i];
            }
        }

        if (dirName.isEmpty())
        {
            return;
        }

        switch (userName)
        {
            case "collector":
                userPath = "/sdcard/" + dirName + "/Data/Collect/21";
                break;
            case "collector1":
                userPath = "/sdcard/" + dirName + "/Data/Collect/23";
                break;
            case "collector2":
                userPath = "/sdcard/" + dirName + "/Data/Collect/24";
                break;
            case "zhanglingling03655":
                userPath = "/sdcard/" + dirName + "/Data/Collect/3655";
                break;
            default:
                return;
        }

        if (isHK)
        {
            userPath += "_HM/";
        }
        else
        {
            userPath += "/";
        }
    }

    protected static UiDevice mDevice;
    protected static String packageName;
    protected static String userPath;

    static
    {
        try
        {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

            String rslt = mDevice.executeShellCommand("pm list packages");
            String[] array  = rslt.split("\n");

            for (int i=0; i<array.length; i++)
            {
                if (array[i].contains("package:com.fastmap.hd"))
                {
                    packageName = array[i].substring("package:".length());
                }
            }

            //throw new RuntimeException("fastmap not install!");
        }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }


}
