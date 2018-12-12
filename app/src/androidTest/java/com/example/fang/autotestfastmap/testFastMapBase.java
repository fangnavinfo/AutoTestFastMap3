package com.example.fang.autotestfastmap;

import com.fang.testAdapter.Point;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_Confirm;
import com.fastmap.ui.Page_DistanceMeasure;
import com.fastmap.ui.Page_ElecEye;
import com.fastmap.ui.Page_ErrorList;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_IndoorMyData;
import com.fastmap.ui.Page_IndoorTools;
import com.fastmap.ui.Page_Login;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_RoadNameSign;
import com.fastmap.ui.Page_RoundAbout;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_Set;
import com.fastmap.ui.Page_StartEndPoint;
import com.fastmap.ui.Page_SurveyLine;

import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Rule;
import org.junit.rules.TestName;
import org.junit.rules.TestRule;
import org.junit.rules.TestWatcher;
import org.junit.runner.Description;

import java.lang.reflect.Method;

import static org.junit.Assert.assertEquals;

/**
 * Created by fang on 17/11/21.
 */

public class testFastMapBase
{
    @Rule
    public TestRule testWatcher = new TestWatcher(){
        @Override
        protected void failed(Throwable e, Description description)
        {
            try
            {
                testadapter.CapScreen(description.getMethodName());
            }
            catch (Exception e1)
            {
                e1.printStackTrace();
            }
        }

        @Override
        protected void succeeded(Description description)
        {

        }

    };

    @BeforeClass
    public static void setClassUp() throws Exception
    {
        setClassUp(false);
        testadapter.ClearCap();
    }

    @AfterClass
    public static void setClassDown() throws Exception
    {

    }

    protected  static void setClassUpByLicenceCheck(String licence) throws Exception
    {
        testFastMapBase.licence = licence;
        setClassUp(false);
        testFastMapBase.licence = "";
    }
    protected  static void ClearData() throws Exception {
        testadapter.ClearCollect();
        testadapter.ReStartApp();
        Class clazz = Class.forName("com.example.fang.autotestfastmap.testFastMapBase");

        Method method = clazz.getMethod("loginProcess");
        method.invoke(null);
    }

    protected  static void setClassUp(boolean isHmWorking) throws Exception
    {
        if(testadapter.GetPackageName().contains("mbl")) {
            testFastMapBase.userName = "1";
            testFastMapBase.passWord = "1";
        }else{
            testFastMapBase.userName = "collector2";
            testFastMapBase.passWord = "123456";
        }

        testFastMapBase.isHmWorking = isHmWorking;

        testadapter.ReStartApp();
        
        testadapter.Initialize(userName, isHmWorking);

        testadapter.ClearCollect();

        loginProcess();

        testadapter.CreateMainBoard();



//        SqliteTools.initialize(userPath);
//
//        FastMapUI.initialize(mDevice, packageName);
        //FastMapPage.InitDevice(mDevice, packageName);
    }

//    protected  void setAfter() throws IOException, InterruptedException, NoSuchFieldException, ClassNotFoundException
//    {
//        try {
//            switch (eCurrLayer) {
//                case Layer_MyData:
//                    ExitMyData();
//                    break;
//                case Layer_IndoorTools:
//                    ExitIndoorTools();
//                    break;
//                case Layer_GridManager:
//                    //ExitGridManager();
//                    break;
//                default:
//                    break;
//            }
//        }
//        catch (RuntimeException e)
//        {
//            testadpater.ReStartApp();
//            loginProcess();
//        }
//    }

//    protected static String getPackageName() throws Exception
//    {
//        String rslt = mDevice.executeShellCommand("pm list packages");
//        String[] array  = rslt.split("\n");
//
//        for (int i=0; i<array.length; i++)
//        {
//            if (array[i].contains("package:com.fastmap.hd"))
//            {
//                String name = array[i].substring("package:".length());
//                return name;
//            }
//        }
//
//        throw new Exception("fastmap not install!");
//    }
//
//    protected static void clearCollect() throws IOException
//    {
//        mDevice.executeShellCommand("rm -rf " + userPath + "coremap.sqlite");
//        mDevice.executeShellCommand("rm -rf " + userPath + "oremap.shm");
//        mDevice.executeShellCommand("rm -rf " + userPath + "coremap.wal");
//    }
//
//    public static void  ReStartApp() throws InterruptedException, IOException
//    {
//        mDevice.executeShellCommand("am force-stop " + packageName);
//
//        Context context = InstrumentationRegistry.getInstrumentation().getContext();
//        Intent intent = context.getPackageManager().getLaunchIntentForPackage(packageName);
//        intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK);
//        context.startActivity(intent);
//
//        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "login_btn")), 10*1000);
//        if (object == null)
//        {
//            fail("fast map not start!");
//        }
//    }

    public static void loginProcess() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        if(isHmWorking)
        {
            Page_Login.SelectHKM();
        }
        else
        {
            Page_Login.NoSelectHKM();
        }

        Page_Login.Inst.SetValue(Page_Login.USER_NAME, userName);
        Page_Login.Inst.SetValue(Page_Login.USER_PASSWD, passWord);
        if(!"".equals(licence)) {
            if(!Page_Login.Inst.isChecked(Page_Login.CAR_MODE_RADIO))
            {
                Page_Login.Inst.Click(Page_Login.CAR_MODE_RADIO);
            }
            Page_Login.Inst.SetValue(Page_Login.CAR_NUM, licence);
        }
        
        Page_Login.Inst.Click(Page_Login.LOGIN_BTN);

        Page_MainBoard.Inst.WaitEnter(30*1000);
    }
    
    public static void logoutProcess() throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
    	Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
    	Page_MainMenu.Inst.ClickByText("退出登录");
    	Page_Confirm.Inst.Click(Page_Confirm.OK);
    	
    }

//    // 选择非港澳服务
//    public static void chooseServer() throws InterruptedException {
//        UiObject2 hm = mDevice.findObject(By.res(packageName, "chk_work_area_type"));
//        if(hm.isChecked()) {
//            hm.click();
//            Thread.sleep(1000);
//        }
//        Click("login_tv_service_address");
//        UiObject2 Object = mDevice.wait(Until.findObject(By.text("开发->http://fs-road.navinfo.com/dev/trunk")), 500);
//        Object.click();
//
//        Click("btn_fm_confirm");
//    }
//    // 选择港澳服务
//    public static void chooseHmServer() throws InterruptedException {
//        UiObject2 hm = mDevice.findObject(By.res(packageName, "chk_work_area_type"));
//        if(!hm.isChecked()) {
//            hm.click();
//            Thread.sleep(1000);
//        }
//        Click("login_tv_service_address");
//        UiObject2 Object = mDevice.wait(Until.findObject(By.text("港澳->http://192.168.4.130:9700")), 500);
//        Object.click();
//
//        Click("btn_fm_confirm");
//    }
//
//    //非港澳作业登录
//    public static void loginProcess() throws InterruptedException {
//        chooseServer();
//
//        //登录
//        PutinEditor("login_account_et", userName);
//        PutinEditor("login_pswd_et", passWord);
//
//        Click("login_btn");
//
//        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "head_icon")), 30*1000);
//        if (object == null)
//        {
//            fail("user login failed!");
//        }
//    }
//
//    //港澳作业登录
//    public static void loginHmProcess() throws InterruptedException {
//        chooseHmServer();
//
//        //登录
//        PutinEditor("login_account_et", userName);
//        PutinEditor("login_pswd_et", passWord);
//
//        Click("login_btn");
//
//        UiObject2 object = mDevice.wait(Until.findObject(By.res(packageName, "head_icon")), 30*1000);
//        if (object == null)
//        {
//            fail("user login failed!");
//        }
//    }
//
//    protected static void waitDownLoadMetal() throws Exception {
//        //元数据下载
//        int waitCount = 0;
//        while (true)
//        {
//            if (waitCount == 30)
//            {
//                break;
//            }
//
//            if (mDevice.findObject(By.res(packageName, "update_image")) != null)
//            {
//                Click(GetCenter());
//            }
//
//            if (metaDataDownSuccess())
//            {
//                break;
//            }
//
//            Thread.sleep(1000);
//            waitCount++;
//            continue;
//        }
//    }
//
//    protected static void waitDownLoadMap() throws Exception
//    {
//        Click("head_icon");
//        Click("fmcard_tv_user_bg_map",2000);
//
//        Click("rb_manager");
//
//        UiObject2 check = mDevice.findObject(By.res(packageName, "download_title"));
//        if (check != null && check.getText().equals("下载完成"))
//        {
//            Click("btn_back");
//            Click("fmcard_ibtn_back");
//
//            return;
//        }
//
//        Click("rb_city_list");
//        Click(beijingMap);
//
//        int waitCount = 0;
//
//        while (true)
//        {
//            if (waitCount == 180)
//            {
//                throw new Exception("下载离线地图超时");
//            }
//
//            UiObject2 downSucess = mDevice.findObject(By.res(packageName, "download_title"));
//            if (downSucess != null && downSucess.getText().equals("下载完成"))
//            {
//                break;
//            }
//
//            Thread.sleep(1000);
//            waitCount++;
//        }
//
//        Click("btn_back");
//        Click("fmcard_ibtn_back");
//    }
//
    
    protected void GotoMyData(String strType) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

        //进入我的数据后，默认是Tips信息
        if (strType == Page_MyData.TIPS_TYPE)
        {
            return;
        }

        Page_MyData.Inst.Click(Page_MyData.SELECT_DATA_TYPE);
        Page_MyData.Inst.Click(strType);
        Page_MyData.Inst.Click(Page_MyData.SELECT_CONFIRM);
    }

    protected  void ExitMyData() throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
    	Page_MyData.Inst.Click(Page_MyData.BACK);
    	Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    protected void GotoIndoorTools() throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
    }

    protected  void ExitIndoorTools() throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        try
        {
            Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_RESULT_BACK);

        }
        catch (Exception e)
        {

        }

        try
        {
        	Page_IndoorMyData.Inst.Click(Page_IndoorMyData.BACK);

        }
        catch (Exception e)
        {

        }
        
        
    	Page_IndoorTools.Inst.Click(Page_IndoorTools.BACK);
    	
    	Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }
    
    protected  void ExitIndoorToolsWithCheckResult() throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
    	Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_RESULT_BACK);
    	
    	ExitIndoorTools();
    }
    
    
//
//    protected void GotoGridManager()
//    {
//        Click("head_icon");
//        Click("fmcard_tv_grid_manager");
//
//        eCurrLayer = EnumLayer.Layer_GridManager;
//    }
//
//    protected void ExitGridManager()
//    {
//        Click("back");
//        Click("fmcard_ibtn_back");
//        eCurrLayer = EnumLayer.Layer_Main;
//    }
//
//
//    protected  static void Click(String strViewId)
//    {
//        Click(strViewId, 1000);
//
//    }
//
//    protected  static void Click(String strViewId, int time)
//    {
//        try
//        {
//            int waitCount =0;
//            UiObject2 btnBack2 =  mDevice.findObject(By.res(packageName, strViewId));
//            while (btnBack2 == null || !btnBack2.isEnabled())
//            {
//                btnBack2 = mDevice.findObject(By.res(packageName, strViewId));
//                if (waitCount == 5)
//                {
//                    break;
//                }
//
//                waitCount++;
//                Thread.sleep(1000);
//            }
//
//            if (btnBack2 == null)
//            {
//                throw new RuntimeException("can not find ctrl:" + strViewId);
//            }
//
//            btnBack2.click();
//            Thread.sleep(time);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    protected  static void Click(Point point)
//    {
//        Click(point, 1000);
//
//    }
//
//    protected  static void Click(Point point, int time)
//    {
//        mDevice.click(point.x, point.y);
//
//        try
//        {
//            Thread.sleep(time);
//        }
//        catch (InterruptedException e)
//        {
//            e.printStackTrace();
//        }
//    }
//
//    protected static Point GetCenter()
//    {
//        Point p =  new Point(testadapter.getDisplayWidth()/2, testadapter.getDisplayHeight()/2);
//        return p;
//    }
//
//    protected static void PutinEditor(String editorCtrl, String inPut)
//    {
//        UiObject2 editName = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);
//
//        editName.setText(inPut);
//    }
//
//    protected void assertEditorEqual(String editorCtrl, String textExcept)
//    {
//        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);
//
//        assertEquals(textExcept, txtAddCount.getText());
//    }
//
//    protected void assertEditorEqual(String editorCtrl, List<String> textExceptList)
//    {
//        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, editorCtrl)), 500);
//
//        String str="";
//        String strReal = txtAddCount.getText();
//
//        if (strReal == null)
//        {
//            return;
//        }
//
//        for (String textExcept : textExceptList)
//        {
//            if (textExcept == null)
//            {
//                return;
//            }
//
//            if (strReal.equals(textExcept))
//            {
//                return;
//            }
//
//            str += textExcept+" or ";
//        }
//
//
//        fail(editorCtrl + "expect:" + str + "but real:" + strReal);
//    }
//
//    protected void CheckAllData() throws InterruptedException, UiObjectNotFoundException
//    {
//        GotoIndoorTools();
//
//        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
//
//        try
//        {
//            while (true)
//            {
//                UiObject Object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), "否");
//                Object.click();
//            }
//
//        }
//        catch (UiObjectNotFoundException e)
//        {
//
//        }
//
//        ExitIndoorTools();
//    }
//
//    protected static boolean metaDataDownSuccess() throws InterruptedException
//    {
//        UiObject2 object = mDevice.findObject(By.res(packageName, "tv_title"));
//        if (object != null && object.getText().equals("元数据更新"))
//        {
//            Click("btn_fm_confirm", 2000);
//
//            int count = 0;
//            while (true)
//            {
//                try
//                {
//                    UiCollection videos = new UiCollection(new UiSelector().className("android.widget.FrameLayout"));
//
//                    UiObject confirmObj = videos.getChild(new UiSelector().className("android.widget.Button"));
//                    if (confirmObj.isEnabled())
//                    {
//                        confirmObj.click();
//                        return true;
//                    }
//                }
//                catch (android.support.test.uiautomator.UiObjectNotFoundException e)
//                {
//                    continue;
//                }
//                finally
//                {
//                    if (count == 180)
//                    {
//                        fail("download metal data timeout");
//                        break;
//                    }
//
//                    Thread.sleep(1000);
//                    count++;
//                }
//            }
//        }
//
//        return false;
//    }
//
//    protected void CheckSyncResult() throws UiObjectNotFoundException, InterruptedException
//    {
//
//        int count = 0;
//        while (true)
//        {
//            try
//            {
//                UiCollection videos = new UiCollection(new UiSelector().className("android.widget.FrameLayout"));
//
//                UiObject confirmObj = videos.getChild(new UiSelector().className("android.widget.Button"));
//                if (confirmObj.isEnabled())
//                {
//                    Thread.sleep(5000);
//                    break;
//                }
//            }
//            catch (android.support.test.uiautomator.UiObjectNotFoundException e)
//            {
//                continue;
//            }
//            finally
//            {
//                if (count == 150)
//                {
//                    break;
//                }
//
//                Thread.sleep(1000);
//                count++;
//            }
//        }
//
//
//        UiCollection videos = new UiCollection(new UiSelector().className("android.widget.ScrollView"));
//
//        int i=0;
//        while (true)
//        {
//            UiObject txtResult = videos.getChild(new UiSelector().className("android.widget.TextView").instance(i));
//            switch (i)
//            {
//                case 1:
//                    if (poiNum == 0) {
//                        Assert.assertEquals("没有需要上传的数据", txtResult.getText());
//                    } else {
//                        Assert.assertEquals("Poi上传成功(成功" + Integer.toString(poiNum) + "条,失败0条)", txtResult.getText());
//                    }
//                    break;
//
//                case 4:
//                    Assert.assertEquals("Poi数据安装成功", txtResult.getText());
//                    break;
//
//                case 7:
//                    if (tipsNum == 0)
//                    {
//                        Assert.assertEquals("没有需要上传的数据", txtResult.getText());
//                    }
//                    else {
//                        Assert.assertEquals("Tips上传成功(成功" + Integer.toString(tipsNum) + "条,失败0条)", txtResult.getText());
//                    }
//                    break;
//
//                case 10:
//                    Assert.assertEquals( "tips实景数据安装成功", txtResult.getText());
//                    break;
//
//                case 13:
//                    if (infoPOINum == 0)
//                    {
//                        Assert.assertEquals("没有需要上传的数据", txtResult.getText());
//                    } else
//                    {
//                        Assert.assertEquals("情报上传成功(成功" + Integer.toString(infoPOINum+infoRoadNum) + "条,失败0条)", txtResult.getText());
//                    }
//                    break;
//
//                case 16:
//                    Assert.assertEquals("info数据安装成功", txtResult.getText());
//                    return;
//
//                default:
//                    break;
//            }
//
//            i++;
//
//        }
//
//    }
//
//    protected void CheckSyncInfoResult() throws UiObjectNotFoundException
//    {
//        UiObject2 btnObject = mDevice.wait(Until.findObject(By.clazz("android.widget.Button").enabled(true)), 120*1000);
//
//        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ScrollView"));
//        UiObject Object = objscoll.getChildByInstance(new UiSelector().className("android.widget.TextView"), 1);
//
//        if (infoPOINum+infoRoadNum == 0)
//        {
//            Assert.assertEquals("没有需要上传的数据", Object.getText());
//        } else
//        {
//            Assert.assertEquals("情报上传成功(成功" + Integer.toString(infoPOINum+infoRoadNum) + "条,失败0条)", Object.getText());
//        }
//
//        btnObject.click();
//    }
//
//        protected enum EnumLayer
//    {
//        Layer_Main,
//        Layer_MyData,
//        Layer_IndoorTools,
//        Layer_GridManager,
//    }
//
//    private static void Init()
//    {
//        eCurrLayer = EnumLayer.Layer_Main;
//        tipsNum = 0;
//        poiNum = 0;
//        infoPOINum = 0;
//        infoRoadNum = 0;
//        infoGateType = 0;
//    }
    protected void AssertIndoorCheck(String type, String level, String rule, String error, String severity) throws NoSuchFieldException, ClassNotFoundException, InterruptedException 
    {
		GotoIndoorTools();
		Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
		Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
		
		Page_IndoorMyData.Inst.CheckResultExit(type, level, rule, error, severity);
		
		//ExitIndoorToolsWithCheckResult();
    }
    
//    protected void AssertIndoorCheck(String type, String level, String rule, String error, String severity) throws UiObjectNotFoundException
//    {
//        GotoIndoorTools();
//        Click("btn_check");
//        Click("progress_btn_positive");
//
//        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
//        Assert.assertNotNull(objscoll);
//
//        objscoll.setMaxSearchSwipes(3);
//
//        UiObject object = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), rule);
//
//        Assert.assertEquals(object.getText(), rule);
//
////        List<UiObject2> resultList = mDevice.wait(Until.findObject(By.clazz("android.widget.ListView")), 500).getChildren();
////        int i = resultList.size();
////        for (UiObject2 obj : resultList)
////        {
////            if (!obj.getClassName().equals("android.widget.LinearLayout"))
////            {
////                continue;
////            }
////
////            if (obj.findObject(By.text(rule)) == null)
////            {
////                continue;
////            }
////
////            UiObject2 objType = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_type"));
////            Assert.assertEquals(type, objType.getText());
////
////            UiObject2 objlevel = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_error_level"));
////            Assert.assertEquals(level, objlevel.getText());
////
////            UiObject2 objError = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_error_info"));
////            Assert.assertEquals(error, objError.getText());
////
////
//////            UiObject2 ObjSerious = obj.findObject(By.res(packageName, "tv_indoor_check_snap_item_serious"));
//////            if (severity.isEmpty() && ObjSerious.getText() == null)
//////            {
//////            }
//////            else
//////            {
//////                Assert.assertEquals(severity, ObjSerious.getText());
//////            }
////        }
//
//        Click("iv_indoor_check_back");
//        ExitIndoorTools();
//    }
//
    protected void AssertIndoorCheckNull(String rule) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
		GotoIndoorTools();
		Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
		Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
		
		Page_IndoorMyData.Inst.CheckResultNotExit(rule);
		
		//ExitIndoorToolsWithCheckResult();
    }
    
//    protected void AssertIndoorCheckNull(String rule)
//    {
//        GotoIndoorTools();
//        Click("btn_check");
//
//        try
//        {
//            Click("progress_btn_positive");
//        }
//        catch (RuntimeException e)
//        {
//            ExitIndoorTools();
//            return;
//        }
//
//        UiScrollable objscoll = new UiScrollable(new UiSelector().className("android.widget.ListView"));
//        Assert.assertNotNull(objscoll);
//
//        objscoll.setMaxSearchSwipes(3);
//
//        try
//        {
//            UiObject subOject = objscoll.getChildByText(new UiSelector().className("android.widget.TextView"), rule);
//            if (subOject != null)
//            {
//                Click("iv_indoor_check_back");
//
//                Assert.fail(rule + " exit!");
//            }
//        }
//        catch (UiObjectNotFoundException e)
//        {
//            UiObject2 btnObject = mDevice.wait(Until.findObject(By.res(packageName, "iv_indoor_check_back")), 500);
//            if (btnObject != null)
//            {
//                Click("iv_indoor_check_back");
//            }
//        }
//
//
//        ExitIndoorTools();
//
//    }
//
    protected String AddPOI(String[][] attribs, String Lng, String Lat, String addKind) throws Exception
    {
        SearchLocation(Lng, Lat);
        return AddPOI(attribs,addKind);
    }

    protected String AddPOI(String[][] attribs, String addKind) throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        try
        {
        	Thread.sleep(1000);
        	Page_MainBoard.Inst.ClickbyText(addKind);
        }
        catch (Exception e)
        {

        }

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        for (String[] attrib : attribs)
        {
            try {
                Thread.sleep(1000);
                Page_POI.Inst.SetValue(attrib[0], attrib[1]);
            }
            catch(Exception e)
            {

            }

            Thread.sleep(1000);
        }

        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        return infoFid;
    }

    //按照坐标绘制测线
    protected void DrawRoad(Point[] pointArray) throws Exception
    {
        DrawRoad(pointArray, Page_SurveyLine.CITY_HIGH_SPEED);
    }

    //按照坐标绘制测线
    protected void DrawRoad(Point[] pointArray, String type) throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        for(Point p : pointArray)
        {
        	Page_MainBoard.Inst.Click(p);
        	Thread.sleep(1500);
        }
        
        Page_SurveyLine.Inst.Click(type);
        
        if(Page_SurveyLine.Inst.isExist(Page_SurveyLine.LANE_NUM_1, 500))
        {
        	Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        }
        
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
    }

    //设置起终点类型
    protected void SetStartEndPoint(Point start, Point end, String type) throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(start);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(end);
        
        Page_StartEndPoint.Inst.Click(type);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);
    }
    
//
//    //在我的数据中删除对应名字的tip
//    protected void DeleteTipInMyData(String... names)
//    {
//        GotoMyData(Page_MyData.TIPS_TYPE);
//
//        for (String name : names)
//        {
//            UiObject2 object = mDevice.wait(Until.findObject(By.text(name)), 3000);
//            object.click();
//
//            Click("delete_button");
//            Click("btn_fm_confirm");
//            tipsNum--;
//        }
//
//        ExitMyData();
//    }
    
//
    //获取10个点位的真实距离。
    protected double GetDistance100Pixel() throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
    	Page_MainBoard.Inst.Click(Page_MainBoard.DISTANCE_MEASURE);
    	Page_MainBoard.Inst.Click(new Point(1000, 1000));
    	Page_MainBoard.Inst.Click(new Point(1000, 1000+100));

    	String value = Page_DistanceMeasure.Inst.GetValue(Page_DistanceMeasure.MEASURE_VALUE);
    	Page_DistanceMeasure.Inst.Click(Page_DistanceMeasure.CLOSE);
    	
    	value = value.replace("米", "");
    	return Double.parseDouble(value);
    }

    //增加电子眼
    protected void AddElecEye(Point point) throws Exception 
    {
    	Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
    	Page_MainBoard.Inst.Click(point);

        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_OVERSPEED);
        Page_ElecEye.Inst.SetSpeed("40");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
    }

    protected  void AddRoadNameSign(String name, String Lng, String Lat) throws Exception
    {
        SearchLocation(Lng, Lat);
        AddRoadNameSign(name);
    }

    protected  void AddRoadNameSign(String name) throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, name);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
    }

    //增加区域属性
    protected void AddRegional(Point point, String type) throws Exception
    {
    	Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
    	Page_MainBoard.Inst.Click(point);
        Page_RoundAbout.Inst.Click(type);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
    }

    void CheckMyData(String type, String name) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
    	CheckMyData(type, name, null);
    }
    
    void CheckMyData(String type, String name, String name_ios) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);

        Page_MainMenu.Inst.Click(Page_MainMenu.MY_DATA);

        Page_MyData.Inst.CheckVaild(type, name, name_ios);

//        Page_MyData.Inst.Click(Page_MyData.BACK);
//
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    void IndoorCheckConfirm(String... names) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        GotoIndoorTools();

        for (String name : names)
        {
            Page_IndoorMyData.Inst.ClickbyText(name);
        }

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);

        ExitIndoorTools();
    }


    void synchronize(String syncType) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Thread.sleep(1000);
        Page_GridManager.Inst.Click(syncType); //情报数据
        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.SYNCHRONOUS_BUTTON); //同步
        Thread.sleep(1000);
        Page_GridManager.Inst.SetValue(Page_GridManager.INFO_ID, "123456");//工单号
        Page_GridManager.Inst.Click(Page_GridManager.OK);
        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.STATIS_CONFIRM);
//        Page_GridManager.Inst.Click(Page_GridManager.SYNC_RESULT_CONFIRM);
//        int count = 0;
//        while (true)
//        {
//            try
//            {
//                UiObject2 confirmObj = findObjectByResourceId("grid_sync_btn_positive");
//                if (confirmObj.isEnabled())
//                {
//                    Thread.sleep(5000);
//                    break;
//                }
//            }
//            catch (Exception e)
//            {
//                continue;
//            }
//            finally
//            {
//                if (count == 500)
//                {
//                    break;
//                }
//
//                Thread.sleep(1000);
//                count++;
//            }
//        }
        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);

        Thread.sleep(1000);

        try
        {
            Page_GridManager.Inst.Click(Page_GridManager.UPDATA_RSLT_CONFIRM);
        }
        catch (Exception e)
        {

        }

        try
        {
            Page_GridManager.Inst.ClickByText("确定"); //入库结果
        }
        catch (Exception e)
        {

        }

        Page_GridManager.Inst.Click(Page_GridManager.BACK);

//        UiObject2 object = findObjectByResourceId("btn_fm_confirm");
//        if(null != object) {
//            object.click();
//            Thread.sleep(1000);
//        }
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        //Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
    }

    void synchronize_zhou(String syncType) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Thread.sleep(1000);
        Page_GridManager.Inst.Click(syncType); //情报数据
        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.SYNCHRONOUS_BUTTON); //同步
        Thread.sleep(1000);
        Page_GridManager.Inst.SetValue(Page_GridManager.INFO_ID, "123456");//工单号
        Page_GridManager.Inst.Click(Page_GridManager.OK);
        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.STATIS_CONFIRM);

        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);

        Thread.sleep(1000);

        try
        {
            Page_GridManager.Inst.Click(Page_GridManager.UPDATA_RSLT_CONFIRM);
        }
        catch (Exception e)
        {

        }

        try
        {
            Page_GridManager.Inst.ClickByText("确定"); //入库结果
        }
        catch (Exception e)
        {

        }

        Page_GridManager.Inst.Click(Page_GridManager.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    void downloaddata(String syncType) throws NoSuchFieldException, ClassNotFoundException, InterruptedException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Thread.sleep(1000);
        Page_GridManager.Inst.Click(syncType); //情报数据
        Thread.sleep(1000);
        Page_GridManager.Inst.ClickByText("下载数据"); //同步
        Thread.sleep(10000);
        Page_GridManager.Inst.ClickbyText("确认");
        Page_GridManager.Inst.Click(Page_GridManager.BACK);

        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }
//    void synchronize(String syncType) throws NoSuchFieldException, ClassNotFoundException, InterruptedException 
//    {
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
//        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
//        Thread.sleep(1000);
// 
//        
//        Thread.sleep(1000);
//        Page_GridManager.Inst.ClickByText(syncType); 
//        Page_GridManager.Inst.Click(Page_GridManager.SYNCHRONOUS_BUTTON); //同步
//        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
//        Page_GridManager.Inst.Click(Page_GridManager.STATIS_CONFIRM);
//        
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);
//
//        Thread.sleep(1000);
//
//        try
//        {
//            Page_GridManager.Inst.Click(Page_GridManager.UPDATA_RSLT_CONFIRM);
//        }
//        catch (Exception e)
//        {
//
//        }
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.BACK);
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//    }
//    
    protected void SearchLocation(String[] loc) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        SearchLocation(loc[0], loc[1]);
    }

    protected void SearchLocation(String Lng, String Lat) throws InterruptedException, NoSuchFieldException, ClassNotFoundException //按照经纬度定位
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("经纬度");
        Page_Search.Inst.SetValue(Page_Search.LNG, Lng);
        Page_Search.Inst.SetValue(Page_Search.LAT, Lat);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_LOCATION);

        Thread.sleep(1000);

//        if (!FastMapPage.IS_OS_TEST)
//        {
//            Page_MainBoard.Inst.ClickCenter();
//        }
    }

    protected void SearchTips(String rowkey) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("Tips");
        Page_Search.Inst.SetValue(Page_Search.TIPS_ROWKEY, rowkey);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_TIPS);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);
    }

    protected void SearchInfos(String globalId) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");

        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.ClickByText("搜索", "搜 索");
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);
    }

    protected void SearchRoadFromLink(String  strRoad) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);

        Page_Search.Inst.ClickByText("Link");
        Page_Search.Inst.Click(Page_Search.EXACT_FIND_LINK);
        Page_Search.Inst.SetValue(Page_Search.EDITLINK, strRoad);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_LINK);

        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
    }

    protected void GotoTIpsLocation(String rowkey) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        SearchTips(rowkey);
        Page_MainBoard.Inst.ClickbyText("取消");
        Page_MainBoard.Inst.ClickbyText("舍弃");
        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
    }

    protected void CheckErrorList(String type, String error) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        //检查错误列表
    	CheckErrorList(type, error, null);
    }
    
    protected void CheckErrorList(String type, String error, String ios_type) throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText(type, ios_type);
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertEquals(txtErrMessage, error);
    }

    protected void SetConfFullView() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        //产品全貌开关设置
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ScrollClick(Page_MainMenu.SET);

        if (!Page_Set.Inst.isChecked(Page_Set.FULLVIEW))
        {
            Page_Set.Inst.Click(Page_Set.FULLVIEW);
        }
        Page_Set.Inst.Click(Page_Set.BACK);

        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
    }

    protected final static  String[] LOC_K1 = {"116.45508", "39.95851"};
    protected final static  String[] LOC_K2 = {"116.45823", "39.97868"};
    protected final static  String[] LOC_K3 = {"116.45386", "39.95894"};
    protected final static  String[] LOC_K4 = {"116.45481", "39.95657"};
    protected final static  String[] LOC_K7 = {"116.41893", "39.96207"};
    protected final static  String[] LOC_K8 = {"116.41946", "39.96162"};
    protected final static  String[] LOC_K10 = {"116.39964", "39.91966"};

    private static String userName = "";
    private static String passWord = "";
    private static String licence = "";

    private static boolean isHmWorking;

    @Rule
    public TestName currTestName = new TestName();
}
