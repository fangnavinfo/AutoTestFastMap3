package com.fang.testAdapter;

import android.content.Context;
import android.content.Intent;
import android.graphics.Rect;
import android.support.test.InstrumentationRegistry;
import android.support.test.uiautomator.By;
import android.support.test.uiautomator.Direction;
import android.support.test.uiautomator.StaleObjectException;
import android.support.test.uiautomator.UiDevice;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObject2;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.support.test.uiautomator.Until;

import java.io.IOException;
import java.util.List;

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

    public static void CtrlFling(int x, int y,String Id)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, Id)), 3000);
        obj.longClick();
        obj.fling(Direction.RIGHT);
        //obj.fling(Direction.LEFT,3000);

//        obj.swipe(Direction.RIGHT,0.5f, 3000);
//        obj.setGestureMargin(100);
//        obj.swipe(Direction.LEFT,0.5f, 3000);
    }

    public static void Click(String Id) throws InterruptedException
    {
        while(true)
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, Id)), 5000);
            try
            {
                if (null == obj)
                {
                    obj = mDevice.wait(Until.findObject(By.res(packageName, Id)), 5000);
                }
                if (!obj.isEnabled())
                {
                    Thread.sleep(500);
                    continue;
                }

                obj.click();
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
            }
            catch(StaleObjectException e)
            {
                Thread.sleep(500);
                continue;
            }
            catch(NullPointerException e)
            {
                break;
            }
        }
    }

    public static void Click(String Id, int time) throws InterruptedException
    {
        while(true)
        {
            UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, Id)), 5000);
            try
            {
                if (null == obj)
                {
                    obj = mDevice.wait(Until.findObject(By.res(packageName, Id)), 5000);
                }
                if (!obj.isEnabled())
                {
                    Thread.sleep(500);
                    continue;
                }

                mDevice.swipe(obj.getVisibleBounds().left, obj.getVisibleBounds().centerY(),
                        obj.getVisibleBounds().right, obj.getVisibleBounds().centerY(), time/25);
                break;
            }
            catch(StaleObjectException e)
            {
                Thread.sleep(500);
                continue;
            }
            catch(NullPointerException e)
            {
                break;
            }
        }
    }

    public static void ClickByText(String text)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.text(text)), 5000);
        obj.click();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void ClickByText(String text, int time)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.text(text)), 5000);
        mDevice.swipe(obj.getVisibleBounds().centerX(), obj.getVisibleBounds().centerY(),
                obj.getVisibleBounds().centerX(), obj.getVisibleBounds().centerY(), time/25);
    }

    public static boolean GetIsEnableByName(String text)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.text(text)), 5000);
        return obj.isEnabled();
    }

    public static void SetValue(String id, String value) throws InterruptedException
    {
        while (true)
        {
            try
            {
                UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, id)), 500);
                obj.setText(value);
                return;
            }
            catch (StaleObjectException e)
            {
                Thread.sleep(1000);
                continue;
            }
        }
    }

    public static String GetValue(String id)
    {
        UiObject2 obj = mDevice.wait(Until.findObject(By.res(packageName, id)), 500);
        return obj.getText();
    }


    public static String GetValuebyIndex(String findRes, String id,int index) throws UiObjectNotFoundException
    {
        UiObject obj = new UiObject(new UiSelector().className(findRes).resourceId(id).instance(index));
         return obj.getText();
    }

    public static String GetValuebyIndex(String findRes,int index) throws UiObjectNotFoundException
    {
        UiObject obj = new UiObject(new UiSelector().className(findRes).instance(index));
        return obj.getText();
    }

    public static void SetValuebyIndex(String clazz, int index,String value) throws UiObjectNotFoundException
    {
        UiObject obj = new UiObject(new UiSelector().className(clazz).instance(index));
        obj.setText(value);
    }
    public static int getCtrlWidth()
    {
        //UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, id)), 500);
        UiObject2 object = mDevice.wait(Until.findObject(By.res("com.fastmap.hd.aut18:id/right_fragment_layout")),500);
        Rect r = object.getVisibleBounds();
        return r.width();
    }

    public static int getDisplayWidth()
    {
        return mDevice.getDisplayWidth();
    }

    public static int  getDisplayHeight()
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

    public static boolean GetIsEnable(String id)
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

    public static boolean isCheckedbyIndex(String findRes, int index) throws UiObjectNotFoundException
    {
        try
        {
            UiObject obj = new UiObject(new UiSelector().className(findRes).instance(index));
            return obj.isChecked();
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
            UiObject2 hm = mDevice.wait(Until.findObject(By.textContains(name)), 500);
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

    public static void StopApp()
    {
        try
        {
            mDevice.executeShellCommand("am force-stop " + packageName);
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
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.sqlite-journal");
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.shm");
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.wal");
             }
        catch (Exception e)
        {
            throw new RuntimeException(e);
        }
    }

    public static void ClearWal()
    {
        try
        {
            mDevice.executeShellCommand("rm -rf " + userPath + "coremap.sqlite-journal");
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

        mDevice.executeShellCommand("mkdir  " +  testCapPath);
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

        //月基线版本
        if("FastMapMBL".equals(dirName))
        {
            switch (userName)
            {
                case "collector":
                    userPath = "/sdcard/" + dirName + "/data/collect/21";
                    break;
                case "collector1":
                    userPath = "/sdcard/" + dirName + "/data/collect/23";
                    break;
                case "collector2":
                    userPath = "/sdcard/" + dirName + "/data/collect/552803";
                    break;
                case "zhanglingling03655":
                    userPath = "/sdcard/" + dirName + "/data/collect/3655";
                    break;
                case "yanghaifei01902":
                    userPath = "/sdcard/" + dirName + "/data/collect/1902";
                    break;
                case "duxuejun01540":
                    userPath = "/sdcard/" + dirName + "/data/collect/1664";
                    break;
                case "wukunyu02074":
                    userPath = "/sdcard/" + dirName + "/data/collect/2074";
                    break;
                case "1":
                    userPath = "/sdcard/" + dirName + "/data/collect/1";
                    break;
                default:
                    return;
            }
        }
        else
        {
            switch (userName)
            {
                case "collector":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/21";
                    break;
                case "collector1":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/23";
                    break;
                case "collector2":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/552803";
                    break;
                case "zhanglingling03655":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/3655";
                    break;
                case "yanghaifei01902":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/1902";
                    break;
                case "duxuejun01540":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/1540";
                    break;
                case "wukunyu02074":
                    userPath = "/sdcard/" + dirName + "/Data/Collect/2074";
                    break;
                default:
                    return;
            }
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

    public static void ScrollOneStep()
    {
        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
        try {
            objscoll.flingForward();
        } catch (UiObjectNotFoundException e) {
            e.printStackTrace();
        }
    }

    protected static UiDevice mDevice;
    protected static String packageName;
    protected static String userPath;
    protected static String testCapPath = "/sdcard/testCap/";
    static
    {
        try
        {
            mDevice = UiDevice.getInstance(InstrumentationRegistry.getInstrumentation());

            String rslt = mDevice.executeShellCommand("pm list packages");
            String[] array  = rslt.split("\n");

            for (int i=0; i<array.length; i++)
            {
                //com.fastmap.hd
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

    public static String  GetItemValue(String clazz, int index,String findRes) throws UiObjectNotFoundException
    {
        UiObject obj = new UiObject(new UiSelector().className(clazz));
        return obj.getChild(new UiSelector().instance(index).resourceId(findRes)).getText();
    }

    public static void ClickByIndex(String clazz, int index) throws UiObjectNotFoundException
    {
        UiObject obj = new UiObject(new UiSelector().className(clazz).instance(index));
        obj.click();
    }


    public static void ClearCap() throws IOException
    {
        mDevice.executeShellCommand("rm -rf" + testCapPath);
        mDevice.executeShellCommand("mkdir " + testCapPath);
    }

    public static void CapScreen(String name) throws IOException
    {
        mDevice.executeShellCommand("screencap -p " + testCapPath + name + ".png");
    }


    public static List<UiObject2> findAllObjectsByClass(String upperId, String className)
    {
        UiObject2 obj2 = mDevice.wait(Until.findObject(By.res(packageName, upperId)), 500);
        List<UiObject2> lst = obj2.findObjects(By.clazz(className));
        return  lst;
    }

    public static UiObject2 findObjectById(String resourceId)
    {
        UiObject2 obj2 = mDevice.wait(Until.findObject(By.res(packageName, resourceId)), 3000);
        return  obj2;
    }

    public static String GetPackageName()
    {
        return packageName;
    }
}
