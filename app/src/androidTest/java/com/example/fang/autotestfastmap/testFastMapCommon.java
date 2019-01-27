package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.UiObject2;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.Point;
import com.fang.testAdapter.Sqlitetools;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_AddPoint;
import com.fastmap.ui.Page_BuildingArea;
import com.fastmap.ui.Page_BusLane;
import com.fastmap.ui.Page_BusPriorityLane;
import com.fastmap.ui.Page_ChangeLaneNotice;
import com.fastmap.ui.Page_ConditionSpeedLimit;
import com.fastmap.ui.Page_Confirm;
import com.fastmap.ui.Page_Dangerous;
import com.fastmap.ui.Page_Default_Pas_Set;
import com.fastmap.ui.Page_DeleteList;
import com.fastmap.ui.Page_DirectionBoard;
import com.fastmap.ui.Page_ElecEye;
import com.fastmap.ui.Page_ErrorList;
import com.fastmap.ui.Page_FerryTime;
import com.fastmap.ui.Page_FunctionalArea;
import com.fastmap.ui.Page_Gate;
import com.fastmap.ui.Page_Gradient;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_HighSpeedDivider;
import com.fastmap.ui.Page_HighSpeedEntryPic;
import com.fastmap.ui.Page_HighWayGoThrough;
import com.fastmap.ui.Page_HovLine;
import com.fastmap.ui.Page_IndoorMyData;
import com.fastmap.ui.Page_IndoorTools;
import com.fastmap.ui.Page_InfoAccept;
import com.fastmap.ui.Page_InfoDelete;
import com.fastmap.ui.Page_InfoFrame;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_InfoPoint;
import com.fastmap.ui.Page_Info_Camera;
import com.fastmap.ui.Page_Kind;
import com.fastmap.ui.Page_LaneChangePoint;
import com.fastmap.ui.Page_LaneInfo;
import com.fastmap.ui.Page_LaneNumber;
import com.fastmap.ui.Page_Light;
import com.fastmap.ui.Page_LightControl;
import com.fastmap.ui.Page_Login;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MilePost;
import com.fastmap.ui.Page_MultiList;
import com.fastmap.ui.Page_MultiVirtualConnect;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_NoParking;
import com.fastmap.ui.Page_NoParkingTruck;
import com.fastmap.ui.Page_NoPassing;
import com.fastmap.ui.Page_NormalCrossPic;
import com.fastmap.ui.Page_Note;
import com.fastmap.ui.Page_OrdinaryRoadNoCrossing;
import com.fastmap.ui.Page_PAS;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_ParkLink;
import com.fastmap.ui.Page_QCProblem;
import com.fastmap.ui.Page_Ramp;
import com.fastmap.ui.Page_RealSign;
import com.fastmap.ui.Page_ReverseLine;
import com.fastmap.ui.Page_RoadDirection;
import com.fastmap.ui.Page_RoadName;
import com.fastmap.ui.Page_RoadNameSign;
import com.fastmap.ui.Page_RoundAbout;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_Set;
import com.fastmap.ui.Page_SingleLineVirtualConnect;
import com.fastmap.ui.Page_Sketch;
import com.fastmap.ui.Page_SpeedLimit;
import com.fastmap.ui.Page_SpeedLimitLane;
import com.fastmap.ui.Page_StartEndPoint;
import com.fastmap.ui.Page_SurveyLine;
import com.fastmap.ui.Page_TimeCtl;
import com.fastmap.ui.Page_TollGate;
import com.fastmap.ui.Page_TrafficForbidden;
import com.fastmap.ui.Page_TruckCondition;
import com.fastmap.ui.Page_TruckForbidden;
import com.fastmap.ui.Page_TruckLimit;
import com.fastmap.ui.Page_TruckLimitLane;
import com.fastmap.ui.Page_TrueSence;
import com.fastmap.ui.Page_TurnLeftLane;
import com.fastmap.ui.Page_UndergroundOverpass;
import com.fastmap.ui.Page_UndergroundPedestrian;
import com.fastmap.ui.Page_VariableSpeedLimit;
import com.fastmap.ui.Page_VehicleLane;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertSame;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapCommon extends testFastMapBase {
    @BeforeClass
    public static void setClassUp() throws Exception {
        CPUMonitor.Start();

        //testFastMapBase.setClassUp("zhanglingling03655","036550");
    }

    @AfterClass
    public static void setClassDown() throws Exception {
        CPUMonitor.End();
    }


    @Before
    public void setUp() throws Exception {

        if (currTestName.getMethodName().equals("test00101_licence_plate_check")) {
            setClassUpByLicenceCheck("鄂A12345");
        }if (currTestName.getMethodName().equals("test00101_poi_hm_brand_check")
                ||currTestName.getMethodName().equals("test00106_hm_poi_same_error_check")
                ||currTestName.getMethodName().equals("test013_hm_traffic_light_control_check")
                ||currTestName.getMethodName().equals("test00117_hm_pas_update_check")
                ||currTestName.getMethodName().equals("test00103_1_hm_poi_report_check")
                ||currTestName.getMethodName().equals("test00129_hm_indoor_data_check")){
            testFastMapBase.setClassUp(true);
        }else{
            testFastMapBase.setClassUp();
        }
    }

    @After
    public void setAfter() //throws IOException, InterruptedException {
    {

        //super.setAfter();
        CPUMonitor.Assert();
    }


    // 车牌录入校验
    @Test
    @IMPORTANT
    public void test00101_licence_plate_check() throws Exception {

        String carNum;
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.EXIT);

        Page_Confirm.Inst.Click(Page_Confirm.OK);
        Page_Login.Inst.Click(Page_Login.CAR_MODE_RADIO);
        carNum = Page_Login.Inst.GetValue(Page_Login.CAR_NUM);

        assertEquals("鄂A12345", carNum);
    }

    // POI 分类品牌表增加港澳标识
    @Test
    public void test00101_poi_hm_brand_check() throws Exception {

        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        String[][] attrib = {
                {Page_POI.NAME, "测试ＰＯＩ"},
                {Page_POI.SELECT_TYPE, "厂家一览表内汽车修理"},
                {Page_POI.SELECT_BRAND, "丰田维修"},
        };

        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE);
        Assert.assertTrue(Page_MyData.Inst.isExistByName("测试ＰＯＩ"));
    }


    // POI 联系方式去除手机号不能以19开头的限制
    @Test
    public void test00102_1_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("19012345678"));
    }

    // POI 联系方式去除手机号不能以146开头的限制
    @Test
    public void test00102_2_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "14612345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("14612345678"));
    }

    // POI 联系方式去除手机号不能以148开头的限制
    @Test
    public void test00102_3_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "14812345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("14812345678"));
    }

    // POI 联系方式去除手机号不能以166开头的限制
    @Test
    public void test00102_4_poi_telnum_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "16612345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("16612345678"));
    }

    // POI 电话号码输入后自动隐藏输入法
    @Test
    public void test00102_5_poi_telnum_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.Click(Page_POI.TEL);

        Thread.sleep(1000);
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(1350, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));
        Page_POI.Inst.Click(new Point(685, 975));

        Page_POI.Inst.Click(new Point(1945, 1480));

        assertTrue(Page_POI.Inst.isExistByName("返回"));

    }

    //采纳情报fid保存
    @Test
    @IMPORTANT
    public void test00103_1_poi_report_check() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        // 上报情报
        addReport(Page_InfoPoint.POI_TYPE);
        // 同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);
        // 采纳情报
        accept();
        // 检查情报fid
        checkFid();

    }

    @Test
    public void test00103_1_hm_poi_report_check() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        // 上报情报
        addReport(Page_InfoPoint.POI_TYPE);
        // 同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);
        // 采纳情报
        accept();
        // 检查情报fid
        checkFid();

    }

    // 情报采纳新增POI原则
    @Test
    @IMPORTANT
    public void test00103_2_poi_report_check() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {
        // 上报情报
        addReport(Page_InfoPoint.POI_TYPE);
        // 同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);
        // 采纳情报
        accept();

    }

    // 删除标记
    @Test
    @IMPORTANT
    public void test00104_tips_delete_check() throws Exception {
        String[] LIGHT_LOC = {"116.40631", "39.91562"};

        String infoRowkey = "";

        //添加红绿灯
        for (int i = 0; i < 2; i++) {
            SearchLocation(LIGHT_LOC);
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
            Page_MainBoard.Inst.ClickCenter();

            GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
            Page_MyData.Inst.SelectData("红绿灯");
            infoRowkey = Page_Light.Inst.GetValue(Page_Light.ROWKEY);
            Page_Light.Inst.Click(Page_Light.CANCEL);
            ExitMyData();

            IndoorCheckConfirm("红绿灯");

            //同步数据
            synchronize_zhou(Page_GridManager.TIPS_UPDATE);
        }


        //删除前定位红绿灯tips位置
        SearchLocation(LIGHT_LOC);

        //增加删除标记
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DELETE_ROAD_MARKER);
        Page_MainBoard.Inst.ClickCenter();
        Page_DeleteList.Inst.Click(Page_DeleteList.DELETE);

        IndoorCheckConfirm("红绿灯");

        //同步数据
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        //确认
        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("红绿灯");
        String rowkey = Page_Light.Inst.GetValue(Page_Light.ROWKEY);
        Page_Light.Inst.Click(Page_Light.CANCEL);
        ExitMyData();

        assertEquals(infoRowkey, rowkey);

    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00105_1_poi_father_error_check() throws Exception {
        String[] FATHER_LOC = {"116.40631", "39.91562"};
        String[] SON_LOC = {"116.40631", "39.91562"};

        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};

        AddPOI(attrib1, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        String infoFid = AddPOI(attrib2, "116.40667", "39.96115", "忽略捕捉新增");

        SearchLocation("116.40557", "39.96121");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("子(fid:" + infoFid + ")不存在") || txtErrMessage.equals("子(" + infoFid + ")不存在"));
    }

    @Test
    public void test00105_2_poi_father_error_check() throws Exception {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid = AddPOI(attrib1, "116.40557", "39.96121", "忽略捕捉新增");


        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        AddPOI(attrib2, "116.40557", "39.96121", "忽略捕捉新增");

        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MultiList.Inst.ClickbyText("中餐馆ＴＥＳＴ１");

        Page_POI.Inst.DeleteFather("大厦ＴＥＳＴ１");

        Thread.sleep(3000);

        //移动父POI
        Page_MultiList.Inst.Click(Page_MultiList.CHECK_LIST_ITEM);
        //Page_MultiList.Inst.Click(Page_MultiList.MOVE);
        Page_MultiList.Inst.Click(Page_MultiList.MOVE_POINT_AND_LINE);

        Page_MainBoard.Inst.Drag(1024, 816, 1024, 1160, 10);

        Page_MultiList.Inst.Click(Page_MultiList.MOVE_POINT_AND_LINE);
        Thread.sleep(3000);
        Page_MultiList.Inst.Click(Page_MultiList.CANCEL_POI);

        Sqlitetools.RefreshData();

        String child = new String((byte[]) Sqlitetools.GePoiDataByFid(infoFid, "relateChildren"));
        assertEquals(child, "[]");

    }

    //采集端父冠子名时加“-”
    @Test
    public void test00105_3_poi_father_name_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};

        AddPOI(attrib1, "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        AddPOI(attrib2, "忽略捕捉新增");


        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("中餐馆ＴＥＳＴ１");

        try {
            Page_POI.Inst.Click(Page_POI.HIDE_POI_NAME);
        } catch (Exception e) {

        }

        Page_POI.Inst.Click(Page_POI.NAME_ICON);

        assertEquals("大厦ＴＥＳＴ１-中餐馆ＴＥＳＴ１", Page_POI.Inst.GetValue(Page_POI.NAME));

        Page_POI.Inst.Click(Page_POI.NAME_ICON);

        assertEquals("中餐馆ＴＥＳＴ１", Page_POI.Inst.GetValue(Page_POI.NAME));
    }

    // POI 错误列表增加父子关系、同一关系错误类型
    @Test
    public void test00106_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "政府机关TEST"},
                {Page_POI.SELECT_TYPE, "区级政府机关(广州市）"}};

        AddPOI(attrib1, "116.40624", "39.96918", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "银行TEST"},
                {Page_POI.SELECT_TYPE, "银行"},
                {Page_POI.POI_SAME, "政府机关ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.96918", "忽略捕捉新增");

        SearchLocation("116.40624", "39.96918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    // POI 错误列表增加父子关系、同一关系错误类型--港澳
    @Test
    public void test00106_hm_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "政府机关TEST"},
                {Page_POI.SELECT_TYPE, "区级政府机关"}};

        AddPOI(attrib1, "113.99998", "22.36356", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "银行TEST"},
                {Page_POI.SELECT_TYPE, "银行"},
                {Page_POI.POI_SAME, "政府机关ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "114.00002", "22.36356", "忽略捕捉新增");

        SearchLocation("113.99998", "22.36356");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    // 高速实景图手动录入编号(需求取消)
    /*
    @Test @IMPORTANT
    public void test00107_tips_true_sence_check() throws Exception
    {
        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700,268));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "6bCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        //获取rowkey
        GotoMyData(Page_MyData.TIPS_TYPE);

        Page_MyData.Inst.ClickbyText("实景图");
        String rowkey = Page_TrueSence.Inst.GetRowKey();
        Page_TrueSence.Inst.Click(Page_TrueSence.CANCEL);
        ExitMyData();

        //确认数据
        IndoorCheckConfirm("实景图");

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        //根据rowkey查找该实景图
        SearchTips(rowkey);

        assertTrue(Page_TrueSence.Inst.isExistByName("6bCD1234"));
    }
    */
    // 功能面验证
    @Test
    @IMPORTANT
    public void test00108_1_functionalarea_check() throws Exception {
        //绘制功能面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(800, 500));
        Page_MainBoard.Inst.Click(new Point(500, 800));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);

        //选择大学类型功能面
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.UNIVERSITY);

        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME, "name1");

        //保存
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("功能面");

        Page_FunctionalArea.Inst.ScrollClick(Page_FunctionalArea.NAME_STATIC);

        assertTrue(Page_FunctionalArea.Inst.isExistByName("name1"));

    }

    // 功能面名称空格验证
    @Test
    @IMPORTANT
    public void test00108_2_functionalarea_check() throws Exception {
        //绘制功能面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(800, 500));
        Page_MainBoard.Inst.Click(new Point(500, 800));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);

        //选择大学类型功能面
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.UNIVERSITY);

        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME, "    ");

        //保存
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        assertTrue(Page_FunctionalArea.Inst.isExistByName("保存"));

    }

    // POI照片优化
    @Test
    public void test00109_poi_picture_check() throws Exception {
        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        try {
            Page_POI.Inst.Click(Page_POI.HIDE_POI_NAME);
        } catch (Exception e) {

        }

        Page_POI.Inst.ScrollClick(Page_POI.MULIT_MEDIA);

        Page_POI.Inst.Click(Page_POI.PICTURE);

        assertTrue(Page_TrueSence.Inst.isExistByName("保存"));

    }

    // 第三方数据验证
    @Test
    @IMPORTANT
    public void test00110_1_3rdParty_Data_check() throws Exception {
        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报TEST"); //输入情报名称
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.ClickbyText("测试上报情报TEST");
        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        Page_InfoPoint.Inst.ClickByText("取消");
        ExitMyData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.update3rdPartyInfo(globalId);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.THIRD_TYPE);
        Page_MyData.Inst.ClickbyText("测试上报情报TEST");
        String globalId2 = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        assertTrue(globalId.equals(globalId2));

    }

    // 第三方数据验证 补充需求
    @Test
    @IMPORTANT
    public void test00110_2_3rdParty_Data_check() throws Exception {
        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter(); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报TEST1"); //输入情报名称
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存


        // 创建情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter(); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报TEST2"); //输入情报名称
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存

        Sqlitetools.RefreshData();

//        GotoMyData(Page_MyData.INFO_TYPE);
//        Page_MyData.Inst.ClickbyText("自采集情报(POI)(点)");
//        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
//        Page_InfoPoint.Inst.ClickByText("取消");
//        ExitMyData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.update3rdPartyInfo("");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        Page_MainBoard.Inst.ClickCenter();

    }

    // 精细化作业要素渲染
    @Test
    public void test00111_hide_feature_check() throws Exception {
        // 创建点门牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        //隐藏要素
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);

        Page_MainBoard.Inst.ClickCenter();

        //点击要素
        assertTrue(!Page_TrueSence.Inst.isExistByName("保存"));

        //还原渲染开关
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);


    }

    // 入库结果对话框去掉大区内/跨大区的提示信息
    @Test
    public void test00112_sync_over_grid_check() throws Exception {
        String[] FATHER_LOC = {"116.40631", "39.91562"};
        String[] SON_LOC = {"116.40631", "39.91562"};

        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};

        AddPOI(attrib1, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        String infoFid = AddPOI(attrib2, "116.40667", "39.96115", "忽略捕捉新增");

        SearchLocation("116.40557", "39.96121");

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();

        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.POI_UPDATE); //情报数据
        Thread.sleep(1000);
        Page_GridManager.Inst.ClickByText("同步数据"); //同步
        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
        Thread.sleep(1000);
        Page_GridManager.Inst.Click(Page_GridManager.STATIS_CONFIRM);

        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);

        Thread.sleep(1000);

        boolean rst = Page_GridManager.Inst.isExistByName("大区");

        assertEquals(rst, false);
    }

    // POI 卡车标识验证
    @Test
    public void test00113_1_poi_truck_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("非卡车"));
    }

    // POI 卡车标识验证
    /*
    @Test
    public void test00113_2_poi_truck_check() throws Exception
    {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_TRUCK, "仅卡车"}};
        AddPOI(attrib);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("仅卡车"));
    }
    */
    // POI 卡车标识验证
    @Test
    public void test00113_3_poi_truck_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_TRUCK, "卡车+小汽车"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("卡车+小汽车"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_1_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "名称"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("名称"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_2_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "电话"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("电话"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_3_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "分类"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("分类"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_4_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "品牌"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("品牌"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_5_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "地址"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("地址"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_6_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "邮编"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("邮编"));
    }

    // POI 标记字段验证
    @Test
    public void test00114_7_poi_remark_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"},
                {Page_POI.POI_REMARK, "深度信息"}};
        AddPOI(attrib, "忽略捕捉新增");

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ２");

        assertTrue(Page_POI.Inst.isExistByName("深度信息"));
    }

    //危险信息Tips修改实时控制条件
    @Test
    public void test00115_1_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54238", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //左侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_LEFT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    @Test
    public void test00115_2_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54246", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //左侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_LEFT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    @Test
    public void test00115_3_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54238", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //右侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_RIGHT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    @Test
    public void test00115_4_tips_dangerous_info_check() throws Exception {

        String[] LOC = {"116.54246", "39.93779"};
        SearchLocation(LOC);

        //创建危险信息tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        //右侧合流
        Page_Dangerous.Inst.Click(Page_Dangerous.CONFLUENCE_RIGHT);

        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据

        assertTrue(Page_POI.Inst.isExistByName("危险信息"));

    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_1_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918", "忽略捕捉新增");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation("116.40624", "39.95918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_2_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"}};

        AddPOI(attrib1, "116.40624", "39.95918", "忽略捕捉新增");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "风景名胜ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918", "忽略捕捉新增");
        } catch (Exception e) {

        }

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("风景名胜售票点ＴＥＳＴ");

        assertTrue(Page_TrueSence.Inst.isExistByName("同一关系"));
    }

    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_3_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918", "忽略捕捉新增");

        SearchLocation("116.40624", "39.95918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        //检查错误列表
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ClickByText("错误列表");
        Page_ErrorList.Inst.ClickbyText("Poi");
        Page_ErrorList.Inst.ClickbyText("查看详情");

        String txtErrMessage = Page_ErrorList.Inst.GetValue(Page_ErrorList.ERROR_CONTENT);
        assertTrue(txtErrMessage.equals("同一poi(" + "fid:" + infoFid + ")在库中不存在") || txtErrMessage.equals("同一poi(" + infoFid + ")在库中不存在"));
    }

    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test00116_4_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"}};

        AddPOI(attrib1, "116.40624", "39.95918", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918", "忽略捕捉新增");
        } catch (Exception e) {

        }

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("风景名胜售票点ＴＥＳＴ");

        assertTrue(Page_TrueSence.Inst.isExistByName("同一关系"));
    }

    //补充同一关系原则
    //风景名胜（180400）与旅游观光（180403）不能建立同一关系
    @Test
    public void test00116_5_poi_same_error_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "旅游观光TEST"},
                {Page_POI.SELECT_TYPE, "旅游观光"}};

        AddPOI(attrib1, "116.40624", "39.95918", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918", "忽略捕捉新增");
        } catch (Exception e) {

        }

        assertTrue(Page_TrueSence.Inst.isExistByName("保存") || Page_MainBoard.Inst.isExistByName("气泡"));
    }

    //点门牌：属性栏布局优化
    @Test
    public void test00117_1_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Thread.sleep(2000);

        String name = Page_PAS.Inst.GetValue(Page_PAS.NAME);
        String address = Page_PAS.Inst.GetValue(Page_PAS.ADDRESS);
        assertEquals("请输入小区名称", name);
        assertEquals("请输入楼栋号", address);
    }

    @Test
    public void test00117_2_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        String name = Page_PAS.Inst.GetValue(Page_PAS.NAME);
        String address = Page_PAS.Inst.GetValue(Page_PAS.ADDRESS);
        assertEquals("请输入小区名称", name);
        assertEquals("请输入楼栋号与楼门号", address);
    }

    @Test
    public void test00117_3_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        String name = Page_PAS.Inst.GetValue(Page_PAS.NAME);
        String address = Page_PAS.Inst.GetValue(Page_PAS.ADDRESS);

        assertEquals("请输入道路名称", name);
        assertEquals("请输入门牌号", address);
    }

    // 港澳点门牌上传下载联调
    @Test
    public void test00117_hm_pas_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "道路名1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "门牌号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        synchronize_zhou(Page_GridManager.PAS_UPDATE);

        Sqlitetools.CleanDataAndRestart();

        synchronize_zhou(Page_GridManager.PAS_UPDATE);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("点门牌");
        Page_Search.Inst.SetValue(Page_Search.EDITPAS,"道路名１");

        Page_Search.Inst.Click(Page_Search.SEARCH_PAS);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        Page_LightControl.Inst.isExistByName("道路名１");
    }

    // 室内整理工具增加量测工具
    @Test
    public void test00118_measure_tool_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.Click(Page_MainBoard.DISTANCE_MEASURE_LEFT_TOP);
        assertTrue(Page_MainBoard.Inst.isExistByName("重绘"));
    }

    // 点门牌框选
    @Test
    public void test00119_pas_select_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.ADDRESS_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "道路名1");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "门牌号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_SELECT);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 500));
        Page_PAS.Inst.Click(Page_PAS.COMPLETE);
        Page_PAS.Inst.Click(Page_PAS.MOVE_POINTS);
        Page_MainBoard.Inst.Drag(500, 500, 1300, 500, 5);
        Page_PAS.Inst.Click(Page_PAS.MOVE_POINTS);
        Page_PAS.Inst.Click(Page_PAS.AUTO_LINK);
        Page_MainBoard.Inst.ClickByText("确定");
    }

    // 建筑物tips复制
    @Test
    public void test00120_tips_copy_building_check() throws Exception {
        //创建建筑面
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUILDING_AREA);
        Page_MainBoard.Inst.Click(new Point(200, 300));
        Page_MainBoard.Inst.Click(new Point(200, 500));
        Page_MainBoard.Inst.Click(new Point(300, 500));
        Page_MainBoard.Inst.Click(new Point(300, 300));

        Page_BuildingArea.Inst.Click(Page_BuildingArea.COMPLETE);
        Page_BuildingArea.Inst.SetValue(Page_BuildingArea.FLOOR_NUMBER, "26");

        Page_BuildingArea.Inst.Click(Page_BuildingArea.SHAPE_CHANGE);
        Page_BuildingArea.Inst.Click(Page_BuildingArea.HEIGHT_ADD);
        Page_BuildingArea.Inst.Click(Page_BuildingArea.ASSOCIATE_DELETE);

        Page_BuildingArea.Inst.Click(Page_BuildingArea.SAVE);

        //复制tips
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Page_MainBoard.Inst.Click(new Point(250, 400));

        Page_MainBoard.Inst.Drag(100, 200, 500, 200, 10);
        Page_MainBoard.Inst.Drag(100, 200, 100, 600, 10);

        Page_MainBoard.Inst.ClickByText("确定");
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();

        String height = Page_BuildingArea.Inst.GetValue(Page_BuildingArea.FLOOR_NUMBER);

        assertTrue("26".equals(height));

    }

    // POI：同点位多点增加按楼层筛选功能
    @Test
    public void test00121_1_poi_same_floor_check() throws Exception {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "百货商场零售"}};

        AddPOI(attrib1, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid1 = AddPOI(attrib2, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib3 = {{Page_POI.NAME, "异国风味TEST1"},
                {Page_POI.SELECT_TYPE, "异国风味"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid2 = AddPOI(attrib3, "116.40557", "39.96121", "忽略捕捉新增");

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updatePoiFloorInfo(fid1, fid2);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        SearchLocation("116.40557", "39.96121");
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(Page_MainBoard.Inst.isExistByName("１层"));
        assertTrue(Page_MainBoard.Inst.isExistByName("２层"));

    }

    // POI：同点位多点POI按楼层筛选优化
    @Test
    public void test00121_2_poi_same_floor_check() throws Exception {
        String[][] attrib1 = {{Page_POI.NAME, "大厦TEST1"},
                {Page_POI.SELECT_TYPE, "百货商场零售"}};

        AddPOI(attrib1, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib2 = {{Page_POI.NAME, "中餐馆TEST1"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid1 = AddPOI(attrib2, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib3 = {{Page_POI.NAME, "异国风味TEST1"},
                {Page_POI.SELECT_TYPE, "异国风味"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid2 = AddPOI(attrib3, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib4 = {{Page_POI.NAME, "酒吧TEST1"},
                {Page_POI.SELECT_TYPE, "酒吧"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid3 = AddPOI(attrib4, "116.40557", "39.96121", "忽略捕捉新增");

        String[][] attrib5 = {{Page_POI.NAME, "冷饮店TEST1"},
                {Page_POI.SELECT_TYPE, "冷饮店"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};
        String fid4 = AddPOI(attrib5, "116.40557", "39.96121", "忽略捕捉新增");

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updatePoiFloorInfo(fid1, fid2);
        Sqlitetools.updatePoiFloorInfo2(fid3, fid4);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        SearchLocation("116.40557", "39.96121");
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(Page_MainBoard.Inst.isExistByName("１层"));
        assertTrue(Page_MainBoard.Inst.isExistByName("２层"));

    }

    // t_fieldDate字段赋值原则（非室内整理界面，当天）
    @Test
    public void test00122_1_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals(fieldDateBefore, fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（非室内整理界面，非当天）
    @Test
    public void test00122_2_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateFieldDate("20180619121212");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertNotEquals("20180619121212", fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（室内整理界面，当天）
    @Test
    public void test00122_3_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals(fieldDateBefore, fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（室内整理界面，非当天）
    @Test
    public void test00122_4_tips_t_filedDate_check() throws Exception {
        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);
        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateFieldDate("20180619121212");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_MainBoard.Inst.ClickByText("匝道");
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals("20180619121212", fieldDateAfter);

    }

    // t_fieldDate字段赋值原则（非室内整理，测线）
    @Test
    public void test00122_5_tips_t_filedDate_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 500));
        Page_MainBoard.Inst.Click(new Point(1250, 800));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateFieldDate("20180619121212");

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //打断测线
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1250, 650));
        Page_MainBoard.Inst.Drag(1800, 1000, 1800, 200, 10);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.EDIT_BREAK);
        Page_MainBoard.Inst.Click(new Point(1250, 700));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Sqlitetools.RefreshData();
        int count = Sqlitetools.GetDataCount("20180619121212", "20180619121212");

        assertEquals(0, count);

    }

    // t_fieldDate字段赋值原则（室内整理，测线）
    @Test
    public void test00122_6_tips_t_filedDate_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 500));
        Page_MainBoard.Inst.Click(new Point(1250, 800));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateBefore = Sqlitetools.GetFieldDate().toString();

        //修改
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.ClickByText("测线");
        Page_MainBoard.Inst.ClickByText("测线");
        Page_MainBoard.Inst.Drag(1800, 1000, 1800, 200, 10);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.EDIT_BREAK);
        Page_MainBoard.Inst.Click(new Point(704, 970));
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        Sqlitetools.RefreshData();
        String fieldDateAfter = Sqlitetools.GetFieldDate().toString();

        assertEquals(fieldDateBefore, fieldDateAfter);

    }

    // POI：充电桩采集变更
    @Test
    public void test00123_1_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.isExistByName("1234567890abcdefghijklmnopqrstuvwxyz");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_GUN));

    }

    // POI：充电桩采集变更
    @Test
    public void test00123_2_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.NO_CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.isExistByName("1234567890abcdefghijklmnopqrstuvwxyz");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.NO_CHARGE_GUN));

    }

    // POI：充电站采集变更
    @Test
    public void test00123_3_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_PARKING_NO));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_SIGNBOARD_NO));

    }

    // POI：充电站采集变更
    @Test
    public void test00123_4_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGE_PARKING_YES);
        Page_POI.Inst.Click(Page_POI.CHARGE_SIGNBOARD_YES);


        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);


        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_PARKING_YES));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_SIGNBOARD_YES));

    }

    // POI：采集端充电站开放时间默认值设定
    @Test
    public void test00123_5_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGINGSTATION_OPEN_HOUR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_InfoPoint.Inst.isExistByName("00:00-23:59"));

    }

    // POI：采集端充电桩插孔类型改善
    @Test
    public void test00123_6_poi_charge_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.NO_CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_POI.Inst.Click(Page_POI.SAVE);

        assertTrue(Page_InfoPoint.Inst.isExistByName("保存"));

    }

    // POI：充电站添加框选子功能
    @Test
    public void test00123_7_poi_charge_father_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_PARKING_NO));
        assertTrue(Page_POI.Inst.isChecked(Page_POI.CHARGE_SIGNBOARD_NO));

    }

    // MS数据验证
    @Test
    public void test00124_1_MS_Data_check() throws Exception {
        // 上报情报
        addReport(Page_InfoPoint.ROAD_TYPE);


        Sqlitetools.RefreshData();
        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateMSdata(globalId);
        Sqlitetools.updateInfoData(1);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoPoint.Inst.ClickbyText("舍弃"); //点击采纳

        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果不一致"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果一致但不满足采集标准"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("其它"));

    }

    // MS数据验证
    /*
    @Test
    public void test00124_2_MS_Data_check() throws Exception
    {
        SearchLocation("116.43615", "39.97134");

        //同步情报
        synchronize_zhou(Page_GridManager.INFO_UPDATE);


        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, "5a7d96391ac947ddbaec3cf8063ca446");
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoPoint.Inst.ClickbyText("舍弃"); //点击采纳

        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果不一致"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("现场与挖掘结果一致但不满足采集标准"));
        assertTrue(Page_InfoPoint.Inst.isExistByName("其它"));

    }
    */

    // 卡车交限卡片验证
    @Test
    public void test00125_1_truck_limit_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片一"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片二"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片三"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

    }

    @Test
    public void test00125_2_truck_limit_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.NO_PULL_INTO);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片一"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片二"));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片三"));

        Page_TruckForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

    }

    //公交车道、可逆车道支持起点移动
    @Test
    public void test00126_bus_line_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUS_LINE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_BusLane.Inst.Click(Page_BusLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 180, 450, 10);
        Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_BusLane.Inst.Click(Page_BusLane.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(705, 745));
        Page_BusLane.Inst.Click(Page_BusLane.MOVE);
        Page_MainBoard.Inst.Drag(100, 450, 150, 450, 10);
        Page_BusLane.Inst.Click(Page_BusLane.MOVE);
        Page_BusLane.Inst.Click(Page_BusLane.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(618, 785));
        Page_BusLane.Inst.Click(Page_BusLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1100, 750));
        Page_BusLane.Inst.Click(Page_BusLane.SAVE);
    }

    //公交车道、可逆车道支持起点移动
    @Test
    public void test00127_reverse_line_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REVERSE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 180, 450, 10);
        Page_ReverseLine.Inst.Click(Page_ReverseLine.ADD_TIME);
        Page_MainBoard.Inst.ClickByText("确定");
        Page_ReverseLine.Inst.Click(Page_ReverseLine.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(705, 745));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.MOVE);
        Page_MainBoard.Inst.Drag(100, 450, 150, 450, 10);
        Page_BusLane.Inst.Click(Page_BusLane.MOVE);
        Page_ReverseLine.Inst.Click(Page_ReverseLine.SAVE);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(618, 785));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1100, 750));
        Page_ReverseLine.Inst.Click(Page_ReverseLine.SAVE);
    }
/*
    // POI：增加Tag子表
    @Test
    public void test00128_1_poi_category_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "医疗机构");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.ClickByText("医院内部设施");
        Page_POI.Inst.ClickByText("专科医院");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        List<UiObject2> lst = testadapter.findAllObjectsByClass("fm_ll_poi_tag_layout", "android.widget.CheckBox");

        UiObject2 obj;

        for (int i = 0; i < 5; i++) {
            obj = lst.get(i);
            if (i == 0 || i == 4) {
                assertTrue(obj.isChecked());
            } else {
                assertTrue(!obj.isChecked());
            }
        }

    }

    @Test
    public void test00128_2_poi_category_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "医疗机构");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        List<UiObject2> lst = testadapter.findAllObjectsByClass("fm_ll_poi_tag_layout", "android.widget.CheckBox");

        UiObject2 obj;
        for (int i = 0; i < 5; i++) {
            obj = lst.get(i);
            assertTrue(!obj.isChecked());
        }
        Page_POI.Inst.Click(Page_POI.CANCEL);
        ExitMyData();

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickByText("医院内部设施");
        Page_POI.Inst.ClickByText("专科医院");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ");

        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        lst = testadapter.findAllObjectsByClass("fm_ll_poi_tag_layout", "android.widget.CheckBox");

        for (int i = 0; i < 5; i++) {
            obj = lst.get(i);
            if (i == 0 || i == 4) {
                assertTrue(obj.isChecked());
            } else {
                assertTrue(!obj.isChecked());
            }
        }

    }
*/
    //图形专项作业
    @Test
    public void test00129_1_indoor_data_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.Click(new Point(850, 750));
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);
        Page_MainBoard.Inst.Click(new Point(850, 760));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.GRAPHIC_WORK);

        assertTrue(Page_InfoPoint.Inst.isExistByName("方向看板"));

    }

    @Test
    public void test00129_2_indoor_data_check() throws Exception {
        SearchLocation(LOC_K7);

        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(850, 750));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        Page_TrueSence.Inst.Click(Page_TrueSence.REQUEST);

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);
        Page_MainBoard.Inst.Click(new Point(850, 760));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.GRAPHIC_WORK);

        assertTrue(Page_InfoPoint.Inst.isExistByName("实景图"));

    }

    @Test
    public void test00129_hm_indoor_data_check() throws Exception {
        SearchLocation(LOC_K7);

        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(850, 750));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        Page_TrueSence.Inst.Click(Page_TrueSence.REQUEST);

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);
        Page_MainBoard.Inst.Click(new Point(850, 760));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_SELECT_LINE_10001);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.GRAPHIC_WORK);

        assertTrue(Page_InfoPoint.Inst.isExistByName("实景图"));

    }

    // POI：停车场深度信息增加界面提示
    @Test
    public void test00130_parking_deep_info_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "停车场");
        Page_POI.Inst.Click(Page_POI.SAVE);

        assertTrue(Page_InfoPoint.Inst.isExistByName("保存"));
    }

    // 框选POI-跨道路批量关联功能
    @Test
    public void test00131_poi_select_check() throws Exception {

        String[][] attrib = {{Page_POI.NAME, "测试ＰＯＩ２"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.TEL, "19012345678"}};
        AddPOI(attrib, "忽略捕捉新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MARQUEE_POI_9002);
        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 500));

        Page_POI.Inst.Click(Page_POI.COMPLETE);

        Page_POI.Inst.Click(Page_POI.SELECT_LINK);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1000, 640));
        Thread.sleep(1000);
        Page_POI.Inst.Click(Page_POI.SELECT_LINK);

        Page_POI.Inst.ClickByText("是");

        assertTrue(Page_InfoPoint.Inst.isExistByName("框选POI"));
    }


    //ASCII   @:64 A:65    Z:90 [:91
    //        ':96 a:97    z:122 {:123
    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_1_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号０"));
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号-１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号２"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_2_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号a");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_3_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号A");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_4_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号Z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｙ"));

    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_5_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｙ"));

    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_6_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号E");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｅ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｄ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｆ"));

    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00132_7_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号e");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｅ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｄ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｆ"));
    }

    @Test
    public void test00133_1_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号1");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号０"));
        assertTrue(!Page_PAS.Inst.isExistByName("楼栋号-１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号１"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号２"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_2_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号a");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_3_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号A");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ａ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｂ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_4_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号Z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｙ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_5_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号z");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｚ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｙ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_6_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号E");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｅ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｄ"));

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号Ｆ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00133_7_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);
        Page_PAS.Inst.SetValue(Page_PAS.NAME, "小区名称TEST");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "楼栋号e");
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Page_PAS.Inst.Click(Page_PAS.DOOR_PAS);

        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 425));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｅ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 500));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｄ"));


        Page_PAS.Inst.Click(Page_PAS.ADDRESS);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(1725, 595));
        Thread.sleep(1000);
        assertTrue(Page_PAS.Inst.isExistByName("楼栋号ｆ"));
    }

    // 点门牌：门牌录入方式优化
    @Test
    public void test00134_pas_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isExistByName("别墅"));
    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_1_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(0);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //采纳
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT); //点击采纳
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("采纳"));
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT); //点击采纳
        assertTrue(Page_InfoLine.Inst.isExistByName("测试上报情报"));

    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_2_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(0);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //部分采纳
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //部分采纳情报
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT); //点击采纳
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("部分采纳"));
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT); //点击采纳
        assertTrue(Page_MainBoard.Inst.isExistByName("点情报"));
        assertTrue(Page_MainBoard.Inst.isExistByName("线情报"));
        assertTrue(Page_MainBoard.Inst.isExistByName("面情报"));

    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_3_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(1);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //舍弃-现场未发生变化
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //舍弃
        Page_InfoAccept.Inst.Click(Page_InfoAccept.DELETE); //舍弃
        Page_InfoDelete.Inst.Click(Page_InfoDelete.NO_CHANGE);
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("保存"));
        Page_InfoDelete.Inst.Click(Page_InfoDelete.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);

        assertTrue(Page_InfoLine.Inst.isExistByName("测试上报情报"));

    }

    // 一级情报增加反馈照片功能
    @Test
    public void test00135_4_info_feedback_picture_update_check() throws Exception {
        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData(); //退出我的数据

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();
        Sqlitetools.updateInfoData(1);

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        //舍弃-未开通
        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //舍弃
        Page_InfoAccept.Inst.Click(Page_InfoAccept.DELETE); //舍弃
        Page_InfoDelete.Inst.Click(Page_InfoDelete.NOT_OPEN);
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);
        Thread.sleep(3000);
        assertTrue(Page_InfoLine.Inst.isExistByName("保存"));
        Page_InfoDelete.Inst.Click(Page_InfoDelete.CAMERA);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_InfoDelete.Inst.Click(Page_InfoDelete.SAVE);

        assertTrue(Page_InfoLine.Inst.isExistByName("测试上报情报"));

    }

    // 室内整理工具（pad）：快速切出切回功能
    @Test
    public void test00136_indoor_tool_switch_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.INDOOR_TOOL);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.MYDATA);
        Page_MainBoard.Inst.Click(Page_MainBoard.INDOOR_CHANGE_WORK);
        Page_MainBoard.Inst.Click(Page_MainBoard.POI_MARQUESS);
        assertTrue(Page_MainBoard.Inst.isExistByName("框选POI"));

    }


    // 点门牌默认类型设置
    @Test
    public void test00139_1_default_pas_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);

        //点门牌默认类型设置
        Page_Set.Inst.Click(Page_Set.PAS_DEFAULT_SET);
        //楼栋门牌
        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BUILDING);

        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BACK);
        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isChecked(Page_PAS.BUILDING_PAS));
    }

    @Test
    public void test00139_2_default_pas_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);

        //点门牌默认类型设置
        Page_Set.Inst.Click(Page_Set.PAS_DEFAULT_SET);
        //楼门门牌
        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.DOOR);

        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BACK);
        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isChecked(Page_PAS.DOOR_PAS));
    }

    @Test
    public void test00139_3_default_pas_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.Drag(100, 600, 100, 200, 10);
        Thread.sleep(1000);
        Page_MainMenu.Inst.Click(Page_MainMenu.SET);

        //点门牌默认类型设置
        Page_Set.Inst.Click(Page_Set.PAS_DEFAULT_SET);
        //地址门牌
        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.ADDRESS);

        Page_Default_Pas_Set.Inst.Click(Page_Default_Pas_Set.BACK);
        Page_Set.Inst.Click(Page_Set.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
        assertTrue(Page_PAS.Inst.isChecked(Page_PAS.ADDRESS_PAS));
    }

    @Test
    public void test00140_1_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);

        assertEquals("设施情报", Page_InfoPoint.Inst.GetValue(Page_InfoPoint.NAME));
    }

    @Test
    public void test00140_2_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.Click(Page_InfoPoint.ROAD_TYPE);

        assertEquals("道路情报", Page_InfoPoint.Inst.GetValue(Page_InfoPoint.NAME));
    }

    @Test
    public void test00140_3_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.Click(Page_InfoLine.POI_TYPE);

        assertEquals("设施情报", Page_InfoLine.Inst.GetValue(Page_InfoLine.NAME));
    }

    @Test
    public void test00140_4_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);

        assertEquals("道路情报", Page_InfoLine.Inst.GetValue(Page_InfoLine.NAME));
    }

    @Test
    public void test00140_5_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 600));

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.POI_TYPE);

        assertEquals("设施情报", Page_InfoFrame.Inst.GetValue(Page_InfoFrame.NAME));
    }


    @Test
    public void test00140_6_default_info_name_check() throws Exception {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 600));

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);

        assertEquals("道路情报", Page_InfoFrame.Inst.GetValue(Page_InfoFrame.NAME));
    }

    //地下通道/过街天桥
    @Test
    public void test00141_undergound_overpass_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.UNDERGROUND_GALLERY_OVERPASS);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        UiObject2 obj;

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.CheckBox");

        //斜坡
        obj = lst.get(1);
        obj.click();

        //其他
        obj = lst.get(10);
        obj.click();

        Page_UndergroundOverpass.Inst.Click(Page_UndergroundOverpass.OVERPASS);
        Page_UndergroundOverpass.Inst.Click(Page_UndergroundOverpass.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("过街天桥/地下通道");

        assertTrue(Page_UndergroundOverpass.Inst.isChecked(Page_UndergroundOverpass.OVERPASS));
    }

    //人行过道
    @Test
    public void test00142_undergound_pedestrian_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.UNDERGROUND_PEDESTRIAN_CORRIDOR);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));


        Page_UndergroundPedestrian.Inst.Click(Page_UndergroundPedestrian.FINISH);
        Page_UndergroundPedestrian.Inst.Click(Page_UndergroundPedestrian.NO_CROSSING);
        Page_UndergroundPedestrian.Inst.Click(Page_UndergroundPedestrian.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("人行过道");

        assertTrue(Page_UndergroundPedestrian.Inst.isChecked(Page_UndergroundPedestrian.NO_CROSSING));
        assertTrue(Page_UndergroundPedestrian.Inst.isChecked(Page_UndergroundPedestrian.NO_TRICICYCLE));
        assertTrue(Page_UndergroundPedestrian.Inst.isChecked(Page_UndergroundPedestrian.NO_BIKE));
    }

    //单线虚拟连接
    @Test
    public void test00143_SingleLineVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SINGLE_LINE_VIRTUAL_CONNECT);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));



        Page_SingleLineVirtualConnect.Inst.Click(Page_SingleLineVirtualConnect.LADDER);
        Page_SingleLineVirtualConnect.Inst.Click(Page_SingleLineVirtualConnect.SLOPE);


        UiObject2 obj;

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.RadioButton");

        //上坡
        obj = lst.get(0);
        obj.click();

        //下坡
        obj = lst.get(3);
        obj.click();

        Page_SingleLineVirtualConnect.Inst.Click(Page_SingleLineVirtualConnect.STRAIGHT_LADDER);
        Page_SingleLineVirtualConnect.Inst.Click(Page_SingleLineVirtualConnect.ESCALATER);

        Page_SingleLineVirtualConnect.Inst.Click(Page_SingleLineVirtualConnect.RETROGTADE_MOTION);

        Page_SingleLineVirtualConnect.Inst.Click(Page_SingleLineVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("单线虚拟连接");

        assertTrue(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.STRAIGHT_LADDER));
        assertTrue(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.ESCALATER));
        assertTrue(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.LADDER));
        assertTrue(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.SLOPE));

        assertFalse(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.EITHER_DIRECTION));
        assertFalse(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.DIRECT_MOTION));
        assertTrue(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.RETROGTADE_MOTION));
        assertFalse(Page_SingleLineVirtualConnect.Inst.isChecked(Page_SingleLineVirtualConnect.IMPASSABLE));

        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.RadioButton");

        //上坡
        obj = lst.get(4);
        obj.click();

        //下坡
        obj = lst.get(7);
        obj.click();

        assertTrue(lst.get(4).isChecked());
        assertFalse(lst.get(5).isChecked());
        assertFalse(lst.get(6).isChecked());
        assertTrue(lst.get(7).isChecked());
    }

    //复合虚拟连接
    @Test
    public void test00144_1_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.CABLEWAY);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.LR);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.CABLEWAY));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.LR));
    }

    //复合虚拟连接
    @Test
    public void test00144_2_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.BUILDING);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.NOBS_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ASC);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.BUILDING));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.NOBS_YES));
        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.ASC));
    }

    //复合虚拟连接
    @Test
    public void test00144_3_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.PARK);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.NOBS_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.DESC);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.PARK));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.NOBS_YES));
        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));


        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.DESC));
    }

    //复合虚拟连接
    @Test
    public void test00144_4_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SQUARE);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.NOBS_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.NLR);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.SQUARE));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.NOBS_YES));
        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.NLR));
    }


    //复合虚拟连接
    @Test
    public void test00144_5_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.STREET);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.LR);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.STREET));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.LR));
    }

    //复合虚拟连接
    @Test
    public void test00144_6_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.UNDERGROUND_PASS);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.NOBS_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ASC);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.UNDERGROUND_PASS));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.NOBS_YES));
        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));



        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.ASC));
    }

    //复合虚拟连接
    @Test
    public void test00144_7_MultiVirtualConnect_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.MULTI_VIRTUAL);

        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 800));

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FINISH);



        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.OTHER);
        Page_MultiVirtualConnect.Inst.SetValue(Page_MultiVirtualConnect.NAME,"测试");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.ADD_TIME);
        Page_MultiVirtualConnect.Inst.ClickByText("确定");
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.NOBS_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.FEE_YES);
        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.DESC);

        Page_MultiVirtualConnect.Inst.Click(Page_MultiVirtualConnect.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("复合虚拟连接");

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.OTHER));
        assertTrue("测试".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.NAME)));
        assertTrue("06:00~20:00;".equals(Page_MultiVirtualConnect.Inst.GetValue(Page_MultiVirtualConnect.TIME)));

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.NOBS_YES));
        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.FEE_YES));



        assertTrue(Page_MultiVirtualConnect.Inst.isChecked(Page_MultiVirtualConnect.DESC));
    }

    //高速路行人非机动车通行
    @Test
    public void test00145_HighWayGoThrough_check() throws Exception {
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGHWAY_GO_THROUGH);
        Page_MainBoard.Inst.ClickCenter();


        Page_HighWayGoThrough.Inst.Click(Page_HighWayGoThrough.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_HighWayGoThrough.Inst.Click(Page_HighWayGoThrough.NO_PED_CROSSING);
        Page_HighWayGoThrough.Inst.Click(Page_HighWayGoThrough.NO_BICYCLE_CROSSING);


        Page_HighWayGoThrough.Inst.Click(Page_HighWayGoThrough.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("高速路行人非机动车通行");


        assertFalse(Page_HighWayGoThrough.Inst.isChecked(Page_HighWayGoThrough.NO_PED_CROSSING));
        assertFalse(Page_HighWayGoThrough.Inst.isChecked(Page_HighWayGoThrough.NO_BICYCLE_CROSSING));
        assertTrue(Page_HighWayGoThrough.Inst.isChecked(Page_HighWayGoThrough.NO_TRICYCLE_CROSSING));
        assertTrue(Page_HighWayGoThrough.Inst.isChecked(Page_HighWayGoThrough.NO_ELEC_BICYCLE_CROSSING));
    }

    //普通路行人非机动车禁行
    @Test
    public void test00146_HighWayGoThrough_check() throws Exception {
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ORDINARY_ROAD_NO_CROSSING);
        Page_MainBoard.Inst.ClickCenter();


        Page_OrdinaryRoadNoCrossing.Inst.Click(Page_OrdinaryRoadNoCrossing.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_OrdinaryRoadNoCrossing.Inst.Click(Page_OrdinaryRoadNoCrossing.NO_TRICYCLE_CROSSING);
        Page_OrdinaryRoadNoCrossing.Inst.Click(Page_OrdinaryRoadNoCrossing.NO_ELEC_BICYCLE_CROSSING);


        Page_OrdinaryRoadNoCrossing.Inst.Click(Page_OrdinaryRoadNoCrossing.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("普通路行人非机动车禁行");


        assertTrue(Page_OrdinaryRoadNoCrossing.Inst.isChecked(Page_OrdinaryRoadNoCrossing.NO_PED_CROSSING));
        assertTrue(Page_OrdinaryRoadNoCrossing.Inst.isChecked(Page_OrdinaryRoadNoCrossing.NO_BICYCLE_CROSSING));
        assertFalse(Page_OrdinaryRoadNoCrossing.Inst.isChecked(Page_OrdinaryRoadNoCrossing.NO_TRICYCLE_CROSSING));
        assertFalse(Page_OrdinaryRoadNoCrossing.Inst.isChecked(Page_OrdinaryRoadNoCrossing.NO_ELEC_BICYCLE_CROSSING));
    }



    @Test
    public void test998_00202_poi_add() throws Exception
    {
        //产品全貌开关关（默认），新增POI点查看相机设置
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.NAME_TYPE);//名称
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_LOW);//分辨率低
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ１");
    }

    @Test
    public void test998_00203_poi_add() throws Exception
    {
        //产品全貌开关关闭,新增POI点查看相机设置
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.SHUIPAI_TYPE);//水牌
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_MID);//分辨率中
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.CAMERA);//看是否保存了上次置的属性(水牌，中)
        Thread.sleep(1000);
        assertTrue(Page_POI_Camera.Inst.isChecked(Page_POI_Camera.SHUIPAI_TYPE));//水牌
        assertTrue(Page_POI_Camera.Inst.isChecked(Page_POI_Camera.RADIO_MID));//分辨率中
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //我的数据
        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ２");
    }

    @Test
    public void test998_00205_poi_add() throws Exception
    {
        SetConfFullView();//产品全貌开关开，产品全貌，分辨率高

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.FULL_VIEW);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"测试ＰＯＩ３");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Thread.sleep(2000);
        Page_POI.Inst.Click(Page_POI.CAMERA);//名称，分辨率中
        Thread.sleep(2000);
        assertTrue(Page_POI_Camera.Inst.isChecked(Page_POI_Camera.NAME_TYPE));
        assertTrue(Page_POI_Camera.Inst.isChecked(Page_POI_Camera.RADIO_MID));
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);

        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ３");
    }

    @Test
    public void test998_00206_poi_add() throws Exception
    {
        SetConfFullView();//产品全貌开关开
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_LOW);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//现在的低分辨率(但是这个直不计入本地文件)，产品全貌图
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME,"测试ＰＯＩ４");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.CAMERA);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.SHUIPAI_TYPE);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_HIG);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.Click(Page_POI.CAMERA); //看是否保存设置(水牌，高)
        Thread.sleep(2000);
        assertTrue(Page_POI_Camera.Inst.isChecked(Page_POI_Camera.SHUIPAI_TYPE));
        assertTrue(Page_POI_Camera.Inst.isChecked(Page_POI_Camera.RADIO_HIG));
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);

        //查看我的数据
        CheckMyData(Page_MyData.POI_TYPE,"测试ＰＯＩ４");
    }

    @Test
    public void test998_00208_poi_add() throws Exception
    {

        String[][] attrib= {
                {Page_POI.NAME, "紧急停车带"},
                {Page_POI.SELECT_TYPE, "紧急停车带"}
        };
        AddPOI(attrib,"捕捉点位新增");

        CheckMyData(Page_MyData.POI_TYPE, "紧急停车带");
    }

    @Test
    public void test998_00209_poi_add() throws Exception
    {
        //POI 彩票投注站
        String[][] attrib= {
                {Page_POI.NAME, "彩票投注站"},
                {Page_POI.SELECT_TYPE, "彩票投注站"}
        };
        AddPOI(attrib,"捕捉点位新增");

        //我的数据
        CheckMyData(Page_MyData.POI_TYPE, "彩票投注站");
    }



    @Test
    public void test998_00215_poi_add() throws Exception
    {
        //只选分类中餐  只选分类厂家一览表外汽车零售及修理  值域只有两（0.2）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ４");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "厂家一览表外汽车零售及修理");
        String strTruck = Page_POI.Inst.GetValue(Page_POI.POI_TRUCK);
        assertEquals("非卡车",strTruck);
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        int truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
        assertSame(0,truck);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_TRUCK);
        Page_POI.Inst.ClickbyText("非卡车");
        Page_POI.Inst.ClickbyText("非卡车");
        Page_POI.Inst.ClickbyText("确定");
        strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
        assertSame(0,truck);
    }

    @Test
    public void test998_00216_poi_add() throws Exception
    {
        //新增数据库中commitHisStatus为0时允许跨大分类
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "厂家一览表外汽车零售及修理");
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        int commitHisStatus = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"commitHisStatus");
        assertSame(0,commitHisStatus);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test998_00217_poi_add() throws Exception
    {
        //上传到数据库中commitHisStatus为0时允许跨大分类
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "厂家一览表外汽车零售及修理");
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        Sqlitetools.RefreshData();
        int commitHisStatus = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"commitHisStatus");
        assertSame(0,commitHisStatus);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test998_00218_poi_add() throws Exception
    {
        //充电桩 充电站不允许跨大分类
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "充电桩");
//        Page_POI.Inst.Drag(1737,1183,1800,750,5);
//        Thread.sleep(2000);

        //Page_POI.Inst.ScrollClick(Page_POI.NO_CHARGE_GUN);
        //Page_POI.Inst.Click(Page_POI.NO_CHARGE_GUN);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickbyText("无");
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);
        Page_POI.Inst.Click(Page_POI.SAVE);

        synchronize_zhou(Page_GridManager.POI_UPDATE);
        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        assertFalse(Page_POI.Inst.isExistByName(Page_POI.SELECT_TYPE));
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test998_00219_poi_add() throws Exception
    {
        //充电桩 充电站不允许跨大分类
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "充电站");
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.ClickbyText("无");

        Page_POI.Inst.Click(Page_POI.SAVE);

        synchronize_zhou(Page_GridManager.POI_UPDATE);
        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        assertFalse(Page_POI.Inst.isExistByName(Page_POI.SELECT_TYPE));
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test998_00221_poi_add() throws Exception
    {
        //充电桩 充电站不允许跨大分类
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "充电站");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        assertFalse(Page_POI.Inst.isExistByName(Page_POI.SELECT_TYPE));
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test998_00222_poi_relationship_Tag() throws Exception
    {
        //查看默认值
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        Thread.sleep(1000);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_00224_poi_relationship_Tag() throws Exception
    {
        //编辑时切换tag页
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK7);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        //Page_POI.Inst.Click(Page_POI.TAG1);
        //Page_POI.Inst.Click(Page_POI.FEEDBACK4);
        Page_POI.Inst.Click(Page_POI.TAG2);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.FEEDBACK0);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.FEEDBACK1);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK1));
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK4);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK4));
        Page_POI.Inst.Click(Page_POI.TAG2);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_00225_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("住宅楼");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_00226_poi_relationship_Tag() throws Exception
    {
        //有子无父
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        String[][] attribs = {{Page_POI.NAME, "中餐馆"},
                {Page_POI.SELECT_TYPE, "110101"},
                {Page_POI.POI_FATHER, "小区"}};
        AddPOI(attribs,"捕捉点位新增");

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(2,fineFeedback);
    }

    @Test
    public void test998_00227_poi_relationship_Tag() throws Exception
    {
        //有子有父
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("住宅楼");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        //Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区(多点)");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);
    }

    @Test
    public void test998_00228_poi_relationship_Tag() throws Exception
    {
        //有子有父删除子
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1,"捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("住宅楼");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        //Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区(多点)");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);


        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        assertFalse(Page_POI.Inst.isExistByName("未采集"));
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

    }

    @Test
    public void test998_00229_poi_relationship_Tag() throws Exception
    {
        //复制poi
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("复制信息新增");
            Page_MainBoard.Inst.ClickbyText("确定");
        }
        catch (Exception e)
        {

        }

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String Fid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK8);
        Fid = Fid.replace("fid:", "");
        Fid = Fid.replace("fid : ", "");

        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFlag");
        assertSame(1,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFeedback");
        assertSame(8,fineFeedback);
    }

//    @Test
//    public void test998_00230_poi_relationship_Tag() throws Exception
//    {
//        //框选子
//        String[][] attrib1 = {{Page_POI.NAME, "中餐馆"},
//                {Page_POI.SELECT_TYPE, "110101"}};
//        AddPOI(attrib1,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
//        String Fid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("框选子POI");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
//        Page_POI.Inst.ClickbyText("已采集");
//        Fid = Fid.replace("fid:", "");
//        Fid = Fid.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFlag");
//        assertSame(2,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFeedback");
//        assertSame(0,fineFeedback);
//    }

    @Test
    public void test998_00231_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("住宅楼");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_00232_poi_relationship_Tag() throws Exception
    {
        //有子无父
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        String[][] attribs = {{Page_POI.NAME, "中餐馆"},
                {Page_POI.SELECT_TYPE, "110101"},
                {Page_POI.POI_FATHER, "小区"}};
        AddPOI(attribs,"捕捉点位新增");

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        //Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.ClickbyText("未采集");
        Page_POI.Inst.Click(Page_POI.FEEDBACK2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(2,fineFeedback);
    }

    @Test
    public void test998_00233_poi_relationship_Tag() throws Exception
    {
        //有子有父
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1,"捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("住宅楼");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        //Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区(多点)");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);

    }

    @Test
    public void test998_00234_poi_relationship_Tag() throws Exception
    {
        //有子有父删除子
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"高等");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "160105");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("住宅楼");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        //Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("高等(多点)");
        Page_POI.Inst.ClickbyText("高等");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("高等");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(2000);
        Page_MyData.Inst.ClickbyText("高等");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG0);
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("高等");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        assertFalse(Page_POI.Inst.isExistByName("未采集"));
        Page_POI.Inst.Click(Page_POI.SAVE);

        //首先判断是否无精细化卡片，没有保存之后的操作都是0,0
        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_00235_poi_relationship_Tag() throws Exception
    {
        //复制poi
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("复制信息新增");
            Page_MainBoard.Inst.ClickbyText("确定");
        }
        catch (Exception e)
        {

        }

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String Fid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK8);
        Fid = Fid.replace("fid:", "");
        Fid = Fid.replace("fid : ", "");

        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFlag");
        assertSame(1,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFeedback");
        assertSame(8,fineFeedback);
    }

    //    @Test
    //    public void test998_00236_poi_relationship_Tag() throws Exception
    //    {
    //        //框选子
    //        String[][] attrib1 = {{Page_POI.NAME, "中餐馆"},
    //                {Page_POI.SELECT_TYPE, "110101"}};
    //        AddPOI(attrib1,"捕捉点位新增");
    //
    //        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
    //        try
    //        {
    //            Thread.sleep(1000);
    //            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
    //        }
    //        catch (Exception e)
    //        {
    //
    //        }
    //        //拍照并返回
    //        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
    //        Thread.sleep(3000);
    //        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
    //        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
    //        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
    //        String Fid = Page_POI.Inst.GetValue(Page_POI.FID);
    //        Page_POI.Inst.Click(Page_POI.POI_FATHER);
    //        Page_POI.Inst.ClickbyText("框选子POI");
    //        Page_POI.Inst.Drag(1759,1259,1759,600,5);
    //        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
    //        Page_POI.Inst.ClickbyText("已采集");
    //        Fid = Fid.replace("fid:", "");
    //        Fid = Fid.replace("fid : ", "");
    //        Page_POI.Inst.Click(Page_POI.SAVE);
    //
    //        Sqlitetools.RefreshData();
    //        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFlag");
    //        assertSame(2,fineFlag);
    //        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFeedback");
    //        assertSame(0,fineFeedback);
    //    }

    @Test
    public void test998_00237_poi_relationship_Tag() throws Exception
    {
        //查看默认值
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"高等");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "160105");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_00238_poi_relationship_Tag() throws Exception
    {
        //查看默认值
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }



    @Test
    public void test998_00239_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.Click(Page_POI.TAG0);
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.ClickbyText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("工业园区");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("工业园区");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

//    @Test
//    public void test998_00240_poi_relationship_Tag() throws Exception
//    {
//        //有子无父
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG2);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
//        //Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_POI.Inst.Click(Page_POI.DOOR);
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("工业园区");//一定会报错，手动测试一下
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("工业园区");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK2);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Thread.sleep(1000);
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(1,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(2,fineFeedback);
//    }
//
//    @Test
//    public void test998_00241_poi_relationship_Tag() throws Exception
//    {
//        //有子有父
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        Page_POI.Inst.ClickbyText("已采集");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG2);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
//        Page_POI.Inst.Click(Page_POI.DOOR);
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.Click(Page_POI.POPCLOSE);
//        Page_POI.Inst.ClickbyText("工业园区");//一定会报错，手动测试一下
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("工业园区");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_POI.Inst.ClickbyText("小区");
//        Page_POI.Inst.Click(Page_POI.SAVE);//之前有过精细化状态  已采集  无
//        Thread.sleep(1000);
//
//        Page_MyData.Inst.ClickbyText("工业园区");
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(1,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(5,fineFeedback);
//    }
//
//    @Test
//    public void test998_00242_poi_relationship_Tag() throws Exception
//    {
//        //有子有父删除子
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        Page_POI.Inst.ClickbyText("已采集");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG2);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
//        Page_POI.Inst.Click(Page_POI.DOOR);
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.Click(Page_POI.POPCLOSE);
//        Page_POI.Inst.ClickbyText("工业园区");//一定会报错，手动测试一下
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("工业园区");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_POI.Inst.ClickbyText("小区");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Thread.sleep(1000);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("中餐馆");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("删除父子关系");
//        Page_POI.Inst.ClickbyText("是");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MyData.Inst.ClickbyText("工业园区");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
//        assertFalse(Page_POI.Inst.isExistByName("未采集"));
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(0,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(0,fineFeedback);
//    }

    @Test
    public void test998_00243_poi_relationship_Tag() throws Exception
    {
        //复制poi
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        Thread.sleep(2000);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(2,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("复制信息新增");
            Page_MainBoard.Inst.ClickbyText("确定");
        }
        catch (Exception e)
        {

        }

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK8);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(8,fineFeedback);
    }

//    @Test
//    public void test998_00244_poi_relationship_Tag() throws Exception
//    {
//        //框选子
//        String[][] attrib1 = {{Page_POI.NAME, "中餐馆"},
//                {Page_POI.SELECT_TYPE, "110101"}};
//        AddPOI(attrib1,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("框选子POI");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
//        Page_POI.Inst.ClickbyText("已采集");
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(2,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(0,fineFeedback);
//    }

    @Test
    public void test998_00245_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1,"捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"综合医院");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "170101");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("医疗机构");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
    @Test
    public void test998_00246_poi_relationship_Tag() throws Exception
    {
        //综合医院 有父有子删除子
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"综合医院");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "170101");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        Thread.sleep(1000);
        boolean b  = Page_POI.Inst.isChecked(Page_POI.FEEDBACK0);
        assertTrue(b);
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("医疗机构(多点)");
        Page_POI.Inst.Click(Page_POI.FAILNAME);
        assertEquals("综合医院",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
        //Page_POI.Inst.ClickbyText("综合医院");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("综合医院");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("医疗机构");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("综合医院");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("框选子");
        Thread.sleep(1000);
        Page_POI.Inst.Click(new Point(920,670));
        Thread.sleep(1000);
        Page_POI.Inst.Click(new Point(920,899));
        Thread.sleep(1000);
        Page_POI.Inst.Click(new Point(1259,899));
        Thread.sleep(1000);
        Page_POI.Inst.Click(new Point(1259,670));
        Page_POI.Inst.Click(Page_POI.FRAME_COMPLETE);
        Page_POI.Inst.Click(Page_POI.LIST_ITEM);
        Page_POI.Inst.ClickByText("保存");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

    }

    @Test
    public void test998_00247_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1,"捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"专科医院");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "170102");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("医疗机构");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
    @Test
    public void test998_00248_poi_relationship_Tag() throws Exception
    {
        //综合医院 有父有子删除子
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"专科医院");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "170102");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        boolean b= Page_POI.Inst.isChecked(Page_POI.FEEDBACK0);
        assertTrue(b);
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");



        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("医疗机构(多点)");
        Page_POI.Inst.Click(Page_POI.FAILNAME);
        assertEquals("专科医院",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("专科医院");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("医疗机构");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("专科医院");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        assertFalse(Page_POI.Inst.isExistByName("未采集"));
        Page_POI.Inst.Click(Page_POI.SAVE);
        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
    @Test
    public void test998_00249_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "教学楼１"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1,"捕捉点位新增");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"高等教育");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "160105");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("教学楼１");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

//    @Test
//    public void test998_00250_poi_relationship_Tag() throws Exception
//    {
//        //综合医院 有父有子删除子
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"高等教育");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "160105");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.ClickbyText("已采集");
//        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//
//        String[][] attrib1 = {{Page_POI.NAME, "教学楼１"},
//                {Page_POI.SELECT_TYPE, "160106"}};
//        AddPOI(attrib1,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"教学楼２");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("高等教育");
//        assertEquals("高等教育",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("高等教育");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_POI.Inst.ClickbyText("教学楼１");
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Thread.sleep(1000);
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(1,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(5,fineFeedback);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("教学楼２");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("删除父子关系");
//        Page_POI.Inst.ClickbyText("是");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MyData.Inst.ClickbyText("高等教育");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
//        assertFalse(Page_POI.Inst.isExistByName("未采集"));
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Sqlitetools.RefreshData();
//        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(0,fineFlag);
//        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(0,fineFeedback);
//    }

    //    @Test
//    public void test998_00251_poi_relationship_Tag() throws Exception
//    {
//        //小区有父无子 不展示精细化卡片
//        String[][] attrib1 = {{Page_POI.NAME, "度假村"},
//                {Page_POI.SELECT_TYPE, "180302"}};
//        AddPOI(attrib1,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"公园");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "180304");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_POI.Inst.ClickbyText("度假村");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(0,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(0,fineFeedback);
//    }
    @Test
    public void test998_00252_poi_relationship_Tag() throws Exception
    {
        //综合医院 有父有子删除子
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"公园");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "180304");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        Thread.sleep(2000);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        String[][] attrib1 = {{Page_POI.NAME, "度假村"},
                {Page_POI.SELECT_TYPE, "180302"}};
        AddPOI(attrib1,"捕捉点位新增");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"医疗机构");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "170100");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("度假村(多点)");
        Page_POI.Inst.Click(Page_POI.FAILNAME);
        assertEquals("公园",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("公园");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("医疗机构(多点)");
        Page_POI.Inst.Click(Page_POI.FAILNAME);
        assertEquals("度假村",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("医疗机构");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("公园");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        assertFalse(Page_POI.Inst.isExistByName("未采集"));
        Page_POI.Inst.Click(Page_POI.SAVE);
        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
    @Test
    public void test998_00253_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"风景名胜");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "180400");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.ClickbyText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"植物园");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "180309");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("风景名胜");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
    @Test
    public void test998_00254_poi_relationship_Tag() throws Exception
    {
        //综合医院 有父有子删除子
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"风景名胜");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "180400");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        Thread.sleep(2000);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"植物园１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "180309");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        Thread.sleep(2000);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"植物园２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "170100");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("植物园１(多点)");
        Page_POI.Inst.Click(Page_POI.FAILNAME);
        assertEquals("风景名胜",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("风景名胜");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("植物园２(多点)");
        Page_POI.Inst.Click(Page_POI.FAILNAME);
        assertEquals("植物园１",Page_POI.Inst.GetValue(Page_POI.POI_FATHER));
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(5,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("植物园２");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("风景名胜");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        assertFalse(Page_POI.Inst.isExistByName("未采集"));
        Page_POI.Inst.Click(Page_POI.SAVE);
        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
    @Test
    public void test998_00255_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.ClickbyText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"会展中心");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "200101");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }
//    @Test
//    public void test998_00256_poi_relationship_Tag() throws Exception
//    {
//        //综合医院 有父有子删除子
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"会展中心");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "200101");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.ClickbyText("已采集");
//        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG2);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "110101");
//        Page_POI.Inst.Click(Page_POI.DOOR);
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.Click(Page_POI.POPCLOSE);
//        Page_POI.Inst.Click(Page_POI.FAILNAME);//报错，手动测试
//        assertEquals("会展中心",Page_POI.POI_FATHER);
//        //Page_POI.Inst.ClickbyText("会展中心");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("会展中心");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_POI.Inst.ClickbyText("小区");
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Thread.sleep(1000);
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(1,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(5,fineFeedback);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickbyText("中餐馆");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_POI.Inst.ClickbyText("删除父子关系");
//        Page_POI.Inst.ClickbyText("是");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MyData.Inst.ClickbyText("会展中心");
//        Page_POI.Inst.Drag(1759,1259,1759,600,5);
//        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
//        assertFalse(Page_POI.Inst.isExistByName("未采集"));
//        Page_POI.Inst.Click(Page_POI.SAVE);
//        Sqlitetools.RefreshData();
//        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(0,fineFlag);
//        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(0,fineFeedback);
//    }

    @Test @IMPORTANT
    public void test998_00702_info_Point_testPath() throws Exception
    {
        //添加点情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();

        Page_InfoPoint.Inst.Click(Page_InfoPoint.NAME);
        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME,"测试点ＩＮＦＯ");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.ROAD_TYPE);
        Page_InfoPoint.Inst.ClickbyText("一级");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);

        //查看我的数据
        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试点ＩＮＦＯ", "测试点ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);

        globalId = globalId.replace("globalId:", "");
        ExitMyData();

        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        //部分采纳
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT);
//        Page_InfoAccept.Inst.Click(Page_InfoAccept.CONFRIM);
//        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);
//        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
    }

    @Test @IMPORTANT
    public void test998_00802_info_Line_testPath() throws Exception
    {
        //添加线情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME,"测试线ＩＮＦＯ");
        Thread.sleep(1000);
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Thread.sleep(1000);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        //查看我的数据
        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试线ＩＮＦＯ", "测试线ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //同步数据
        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        //搜索获取同步后自采集情报信息
        //部分采纳
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT);
//        Page_InfoAccept.Inst.Click(Page_InfoAccept.CONFRIM);
//        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);
//        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
    }

    @Test @IMPORTANT
    public void test998_00902_info_Frame_testPath() throws Exception
    {
        //添加面情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);
        Thread.sleep(2000);
        //Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.SetValue(Page_InfoFrame.NAME,"测试面ＩＮＦＯ");
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.LEVEL_1);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME_CONFIRM);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试面ＩＮＦＯ", "测试面ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT);
//        Page_InfoAccept.Inst.Click(Page_InfoAccept.CONFRIM);
//        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);
//        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
    }

    @Test @IMPORTANT
    public void test998_00712_info_Point_testPath() throws Exception
    {
        //添加点情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();

        Page_InfoPoint.Inst.Click(Page_InfoPoint.NAME);
        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME,"测试点ＩＮＦＯ");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.ClickbyText("一级");
        Page_InfoPoint.Inst.ClickbyText("新增");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);

        //查看我的数据
        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试点ＩＮＦＯ", "测试点ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);

        globalId = globalId.replace("globalId:", "");
        ExitMyData();

        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);
        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        String str = Page_InfoAccept.Inst.GetValue(Page_InfoAccept.PROPOSAL);
        assertEquals(str,"新增");
    }

    @Test @IMPORTANT
    public void test998_00812_info_Line_testPath() throws Exception
    {
        //添加线情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME,"测试线ＩＮＦＯ");
        Page_InfoLine.Inst.Click(Page_InfoLine.POI_TYPE);
        Page_InfoPoint.Inst.ClickbyText("一级");
        Page_InfoPoint.Inst.ClickbyText("修改");
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Thread.sleep(1000);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        //查看我的数据
        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试线ＩＮＦＯ", "测试线ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //同步数据
        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        String str = Page_InfoAccept.Inst.GetValue(Page_InfoAccept.PROPOSAL);
        assertEquals(str,"更新");
    }

    @Test @IMPORTANT
    public void test998_00912_info_Frame_testPath() throws Exception
    {
        //添加面情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);
        Thread.sleep(2000);
        //Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.SetValue(Page_InfoFrame.NAME,"测试面ＩＮＦＯ");
        Page_InfoFrame.Inst.Click(Page_InfoFrame.POI_TYPE);
        Page_InfoPoint.Inst.ClickbyText("一级");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.DELETE);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME_CONFIRM);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试面ＩＮＦＯ", "测试面ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);
        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        String str = Page_InfoAccept.Inst.GetValue(Page_InfoAccept.PROPOSAL);
        assertEquals(str,"删除");
    }

    @Test @IMPORTANT
    public void test998_01003_info_roadnamesign_add() throws Exception
    {
        //新增有端点道路名标牌，我的数据中属性编辑移点，室内整理工具查看
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME,"新道路标牌名");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.IS_POINT);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("道路名标牌");

        //属性编辑中移动点位
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.MOVEPOINT);
        Page_MainBoard.Inst.Drag(700, 823, 1024, 823, 10);//问题

        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.MOVEPOINT);
        Thread.sleep(1000);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        ExitMyData();

        GotoIndoorTools();
        assertTrue(Page_IndoorMyData.Inst.isExistByName("道路名标牌"));
    }

    @Test
    public void test998_01004_info_roadnamesign_add() throws Exception
    {
        //新增有端点道路名标牌，我的数据中属性编辑移点，室内整理工具查看
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME,"新道路标牌名");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.IS_POINT);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("道路名标牌");

        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.NO_POINT);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        ExitMyData();

        GotoIndoorTools();
        assertTrue(Page_IndoorMyData.Inst.isExistByName("道路名标牌"));
    }

    @Test
    public void test998_01007_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 多个字
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME,"新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test998_01008_info_roadnamesign_add() throws Exception
    {
        //搜索经纬度创建道路名标牌，复制道路名标牌
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍摄按键ID
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //返回键ID
        Thread.sleep(1000);

        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME,"新道路标牌名");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.IS_POINT);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1400,900));
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME,"新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名新道路标牌名");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

    }

    @Test
    public void test998_01010_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 新增名称为空 拍照
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍摄按键ID
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //返回键ID
        Thread.sleep(1000);

        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME,"");

        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE); //保存按键ID

        CheckMyData(Page_MyData.TIPS_TYPE,"道路名标牌");
    }

    @Test
    public void test998_01012_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 多个字
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        assertTrue(Page_MyData.Inst.isExistByName("道路名标牌"));
    }

    @Test
    public void test998_01013_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌 室内整理工具编辑
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("道路名标牌");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("道路名标牌");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
    }

    @Test
    public void test998_01014_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌关联手绘测线
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.HIGH_SPEED);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("道路名标牌");

        String rowkey = Page_RoadNameSign.Inst.GetRowKey();

        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));

        JSONObject jsonObject = new JSONObject(str);
        int type = jsonObject.getJSONObject("f").getInt("type");

        assertSame(type,2);
    }

    @Test
    public void test998_01015_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌关联手绘link
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("道路名标牌");

        String rowkey = Page_RoadNameSign.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(str);
        int type = jsonObject.getJSONObject("f").getInt("type");

        assertSame(type,1);
    }

    @Test
    public void test998_01016_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌关联不上node(不关联node(link交接处))
        String[] LOC = {"116.41701", "39.98345"};
        SearchLocation(LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();

        //Page_MainBoard.Inst.Click(new Point(461,481));//关联node
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("道路名标牌");
        String rowkey = Page_RoadNameSign.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(str);
        int type = jsonObject.getJSONObject("f").getInt("type");
        assertFalse((type==3));
    }

    @Test
    public void test998_01017_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌关联不上node(不关联node(link交接处))
        String[] LOC = {"116.41701", "39.98345"};
        SearchLocation(LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();

        //Page_MainBoard.Inst.Click(new Point(461,481));//关联node
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("道路名标牌");
        String rowkey = Page_RoadNameSign.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(str);
        int type = jsonObject.getJSONObject("f").getInt("type");
        assertFalse((type==3));
    }
//    @Test
//    public void test998_01041_data_check() throws Exception
//    {
//        //左侧车道必须大于或等于右侧车道的限速值域（数组从小到大顺序）
//        //Page_MainBoard.Inst.Drag();
//
//        //创建限速车道从左到右分别为90,110，110
//        Page_MainBoard.Inst.Trigger(Tips)
//        Thread.sleep(1000);
//        Page_MainBoard.Inst.Click(new Point(mDevice.getDisplayWidth()/2-250, mDevice.getDisplayHeight()/2-250));
//        //Click("card_speed_limit_type_driveway",100);//选择车道限速
//        //Page_Limit_Speed.Inst.Click(Page_Limit_Speed.ROAD_LIMIT_SPEED);
//        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.ROADLIMIT);
//        mDevice.drag(77, 632, 225, 643, 10);
//        mDevice.drag(77, 632, 225, 643, 10);
//        Page_MainBoard.Inst.Click(new Point(79,552));
//        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM90);
//        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM110);
//        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.NUM110);
//        Page_MainBoard.Inst.Click(new Point(75,475));//点限速必选一个
//        Thread.sleep(1000);
//        Page_Speed_Limit_Lane.Inst.Click(Page_Speed_Limit_Lane.SAVE);
//        Thread.sleep(3000);
//        tipsNum++;
//
//        //室内整理工具检查，车道限速
//        AssertIndoorCheck("车道限速","中","FM-1113-2-2","左侧车道限速小于右侧车道限速","");//问题
//    }
//
// 此需求是web端修改，此版本web端还未改动
//    @Test
//    public void test998_010400_data_check() throws Exception
//    {
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//
//        AddPOI(attrib,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.CtrlFling(new Point(1912,270),Page_GridManager.GRID_PRO_NAME);
//        Thread.sleep(2000);
//        String temp = "关\n" +
//                "闭\n" +
//                "任\n" +
//                "务";
//        Page_GridManager.Inst.ClickbyText(temp);
//        boolean rst = Page_GridManager.Inst.isExistByName("粗编作业未完成，不能关闭");
//        assertEquals(rst,true);
//    }
//
//    @Test
//    public void test998_010401_data_check() throws Exception
//    {
//        //需要有精细化任务
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
//        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
//        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
//        Page_PAS.Inst.Click(Page_PAS.ODD);
//        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
//        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
//        Page_PAS.Inst.Click(Page_PAS.SAVE);
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.CtrlFling(new Point(1912,270),Page_GridManager.GRID_PRO_NAME);
//        Thread.sleep(2000);
//        String temp = "关\n" +
//                "闭\n" +
//                "任\n" +
//                "务";
//        Page_GridManager.Inst.ClickbyText(temp);
//        boolean rst = Page_GridManager.Inst.isExistByName("粗编作业未完成，不能关闭");
//        assertEquals(rst,true);
//    }
//
//    @Test
//    public void test998_010402_data_check() throws Exception
//    {
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//        AddPOI(attrib,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
//        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
//        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
//        Page_PAS.Inst.Click(Page_PAS.ODD);
//        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
//        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
//        Page_PAS.Inst.Click(Page_PAS.SAVE);
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.CtrlFling(new Point(1912,270),Page_GridManager.GRID_PRO_NAME);
//        Thread.sleep(2000);
//        String temp = "关\n" +
//                "闭\n" +
//                "任\n" +
//                "务";
//        Page_GridManager.Inst.ClickbyText(temp);
//        boolean rst = Page_GridManager.Inst.isExistByName("粗编作业未完成，不能关闭");
//        assertEquals(rst,true);
//    }
//
//    @Test
//    public void test998_010403_data_check() throws Exception
//    {
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//        AddPOI(attrib,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_SYNC);
//        Page_GridManager.Inst.ClickByText("同步"); //同步
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);
//        Thread.sleep(1000);
//        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
//        Page_GridManager.Inst.CtrlFling(new Point(1912,270),Page_GridManager.GRID_PRO_NAME);
//        Thread.sleep(2000);
//        String temp = "关\n" +
//                "闭\n" +
//                "任\n" +
//                "务";
//        Page_GridManager.Inst.ClickbyText(temp);
//        boolean rst = Page_GridManager.Inst.isExistByName("粗编作业未完成，不能关闭");
//        assertEquals(rst,true);
//    }
//
//    @Test
//    public void test998_010404_data_check() throws Exception
//    {
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
//        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
//        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
//        Page_PAS.Inst.Click(Page_PAS.ODD);
//        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
//        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
//        Page_PAS.Inst.Click(Page_PAS.SAVE);
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_SYNC);
//        Page_GridManager.Inst.ClickByText("同步"); //同步
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);
//        Thread.sleep(3000);
//        Page_GridManager.Inst.CtrlFling(new Point(1912,270),Page_GridManager.GRID_PRO_NAME);
//        Thread.sleep(2000);
//        String temp = "关\n" +
//                "闭\n" +
//                "任\n" +
//                "务";
//        Page_GridManager.Inst.ClickbyText(temp);
//        boolean rst = Page_GridManager.Inst.isExistByName("粗编作业未完成，不能关闭");
//        assertEquals(rst,true);
//    }
//
//    @Test
//    public void test998_010405_data_check() throws Exception
//    {
//        //需要有精细化任务
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//        AddPOI(attrib,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);
//        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试点门牌");
//        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
//        Page_PAS.Inst.Click(Page_PAS.ODD);
//        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
//        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
//        Page_PAS.Inst.Click(Page_PAS.SAVE);
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_SYNC);
//        Page_GridManager.Inst.ClickByText("同步"); //同步
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_SYNC_BTN_POSITIVE);
//        Thread.sleep(1000);
//        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
//        Page_GridManager.Inst.CtrlFling(new Point(1912,270),Page_GridManager.GRID_PRO_NAME);
//        Thread.sleep(2000);
//        String temp = "关\n" +
//                "闭\n" +
//                "任\n" +
//                "务";
//        Page_GridManager.Inst.ClickbyText(temp);
//        boolean rst = Page_GridManager.Inst.isExistByName("粗编作业未完成，不能关闭");
//        assertEquals(rst,true);
//    }

    @Test
    public void test998_01042_data_check() throws Exception
    {
//    	Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
//        for(Point p : LinePoints)
//        {
//            Page_MainBoard.Inst.Click(p);
//        }
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.FERRY_RD);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.FERRY_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        //Click("gate_type_eg");//EG大门
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-3","航线上不能采集大门",""); //问题
    }

    @Test
    public void test998_01043_data_check() throws Exception
    {
//        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
//        for(Point p : LinePoints)
//        {
//            Page_MainBoard.Inst.Click(p);
//        }
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEOPLE_CROSS_RD);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEOPLE_CROSS_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        //Click("gate_type_eg");//EG大门
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-3","航线上不能采集大门",""); //问题
    }

    @Test
    public void test998_01044_data_check() throws Exception
    {
        //EG门与障碍物不能同时出现
        SearchLocation(LOC_K4);

        //大门关联到这个link上
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);//选择大门
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        SearchLocation(LOC_K4);

        //障碍物关联到这个测线上
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
        Page_AddPoint.Inst.Click(Page_AddPoint.OBST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();
        Page_AddPoint.Inst.Click(Page_AddPoint.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-4","EG门与障碍物不能同时出现","不能忽视");
    }

    @Test
    public void test998_01045_data_check() throws Exception
    {
        //门的方向应与道路通行方向一致,双向门在单车道上
        SearchLocation(LOC_K4);

        //创建双向门
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-5","门的方向应与道路通行方向一致","不能忽视");
    }

    @Test
    public void test998_01046_data_check() throws Exception
    {
        //门的方向应与道路通行方向一致,单向门在双向车道上
        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-5","门的方向应与道路通行方向一致","不能忽视");
    }

//    新增门的方向可能和道路一致也可能不一致，没有办法查看，所以测试不了
//    @Test
//    public void test998_01047_data_check() throws Exception
//    {
//        //门的方向应与道路通行方向一致,单向门在单向车道上，但是门道方向相反
//    	SearchLocation(LOC_K4);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_Gate.Inst.Click(Page_Gate.KG);
//        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);
//        Page_Gate.Inst.Click(Page_Gate.SAVE);
//
////        SearchLocation(LOC_K4);
////        Page_Gate.Inst.ClickCenter();
////        Page_Gate.Inst.Click(Page_Gate.CHANGEDIR);
////        Page_Gate.Inst.Click(Page_Gate.SAVE);
//
//        AssertIndoorCheck("大门","中","FM-11046-1","门的方向应与道路通行方向一致","不能忽视");
//    }

    @Test
    public void test998_01048_data_check() throws Exception
    {
        //10级路上不能有EG
        SearchLocation(LOC_K10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.EG);//EG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-6","10级路上不能有车行门","不能忽视");
    }

    @Test
    public void test998_01049_data_check() throws Exception
    {
        //10级路上不能有PG
        SearchLocation(LOC_K10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.PG);//EG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-6","10级路上不能有车行门","不能忽视");
    }

    @Test
    public void test998_01050_data_check() throws Exception
    {
        //10级路上不能有KG
        SearchLocation(LOC_K10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.KG);//EG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-6","10级路上不能有车行门","不能忽视");
    }

    @Test
    public void test998_01052_data_check() throws Exception
    {
        //车道信息与车道数不一致，可能车道变化点采集遗漏
        SearchLocation(LOC_K4);

        //创建四车道车信
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.D);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.B);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.A);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.C);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        AssertIndoorCheck("车信","中","FM-1301-6-3","车道信息与车道数不一致，可能车道变化点采集遗漏","不能忽视");
    }

    @Test
    public void test998_01053_data_check() throws Exception
    {
        //PG关联的link上有勾选了人行门的POI
        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.PG);//PG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ９");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.PERSION_GATE);
        Page_POI.Inst.Click(Page_POI.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-7","","");
    }

    @Test
    public void test998_01054_data_check() throws Exception
    {
        //KG关联的link上有勾选了人行门的POI
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gate.Inst.Click(Page_Gate.KG);//KG大门
        Page_Gate.Inst.Click(Page_Gate.SINGLEGATE);//单方向大门
        Page_Gate.Inst.Click(Page_Gate.SAVE);

        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ９");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.PERSION_GATE);
        Page_POI.Inst.Click(Page_POI.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-7","","不能忽视");
    }

    @Test
    public void test998_01055_data_check() throws Exception
    {
        //测线与隧道tips相交时，需要制作立交
        SearchLocation(LOC_K7);

        //在此link上创建隧道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.TUNNEL_BT);//隧道位置（起终点的）
        //Page_MainBoard.Inst.Click(new Point(1280, 560));
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2+200, testadapter.getDisplayHeight()/2));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);//起终点

        Thread.sleep(1000);
        SearchLocation(LOC_K7);

        //绘制测线与含有隧道的link相交
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2+100, testadapter.getDisplayHeight()/2+300));
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2+100, testadapter.getDisplayHeight()/2-100));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        AssertIndoorCheck("测线","中","FM-2001-5-9","新测线与隧道属性道路相交，需要制作立交","不能忽视");
    }

    @Test
    public void test998_01056_data_check() throws Exception
    {
        //Rdlink具有内部道路属性时，如果新增区域内Tips（增属性）包含此条link，则报LOG。
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.ADD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);

        AssertIndoorCheck("区域内道路","低","FM-1604-1-3","新增区域内道路（pid：***，多个pid时，用逗号分割）上，已经具有区域内道路属性。不能重复增加属性。","可以忽略");
    }

    @Test
    public void test998_01059_data_check() throws Exception
    {
        //跨越桥长度大于800米，不需要采集！
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_StartEndPoint.Inst.ClickbyText("Overpass");
        Page_MainBoard.Inst.Drag(1340,740,110,740,5);
        Page_MainBoard.Inst.ClickCenter();
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("道路形状及相关检查","低","FM-1504-5-1","跨越桥长度大于800米，不需要采集！","可以忽略");
    }

    @Test
    public void test998_01060_data_check() throws Exception
    {
        //跨越桥长度大于800米，不需要采集！
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_StartEndPoint.Inst.ClickbyText("UnderPass");
        Page_MainBoard.Inst.Drag(1340,740,110,740,5);
        Page_MainBoard.Inst.ClickCenter();
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("道路形状及相关检查","低","FM-1505-5-1","穿越地道长度大于800米，不需要采集！","可以忽略");
    }

    @Test
    public void test998_01061_data_check() throws Exception
    {
        //左侧车道限速小于右侧车道限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(130,442,250,442,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 5);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 6);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        //Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 10);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1113-2-2","左侧车道限速小于右侧车道限速","不能忽略");
    }

    @Test
    public void test998_01062_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign(",,", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01063_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("..", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01064_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("??", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01065_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("$$", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01066_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("、、", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01067_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("，，", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01068_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("．．", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01069_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("？？", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01070_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("＄＄", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01071_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("、、", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }
    @Test
    public void test998_01072_data_check() throws Exception
    {
        //左侧车道限速小于右侧车道限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(130,442,250,442,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 5);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 6);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        //Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 10);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1113-2-2","左侧车道限速小于右侧车道限速","不能忽略");
    }

    @Test
    public void test998_01073_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"$$");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01074_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,",,");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01075_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"..");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01076_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"、、");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01077_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"??");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01078_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"＄＄");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01079_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"，，");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01080_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"．．");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01081_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"、、");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01082_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(1140,730));
        Page_RoadName.Inst.SetValue(Page_RoadName.NAME,"？？");
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        AssertIndoorCheck("Tips内容值域检查","高","FM-1901-2-5","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test998_01083_data_check() throws Exception
    {
        //检查区间测速电子眼如果没有存在配对关系，则报LOG
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("电子眼");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(str);
        int pair = jsonObject.getInt("pair");
        assertSame(0,pair);

        AssertIndoorCheck("共存关系检查","中","FM-1109-6-8","区间测速应该存在配对关系","不能忽略");
    }

    @Test
    public void test998_01084_data_check() throws Exception
    {
        //时间段禁止左转处应该采集时间段理论禁止调头
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A2);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_B4);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01085_data_check() throws Exception
    {
        //link只关联时间段禁止左转
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A2);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01086_data_check() throws Exception
    {
        //时间段禁止左转处应该采集时间段理论禁止调头
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A5);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_B4);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01087_data_check() throws Exception
    {
        //时间段禁止左转处应该采集时间段理论禁止调头
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A5);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01088_data_check() throws Exception
    {
        //link只关联时间段禁止左转
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A6);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_B4);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01089_data_check() throws Exception
    {
        //时间段禁止左转处应该采集时间段理论禁止调头
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A6);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01090_data_check() throws Exception
    {
        //link只关联时间段禁止左转
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A6);
        Thread.sleep(1000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.TIME_BUTTON);
        Page_TrafficForbidden.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.ICON_A2);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","低","FM-1302-6-3","时间段禁止左转处应该采集时间段禁止调头","可以忽略");
    }

    @Test
    public void test998_01091_data_check() throws Exception
    {
        //卡车交限 种别8
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Kind.Inst.Click(Page_Kind.OTHER_RD);
        Thread.sleep(1000);

        Thread.sleep(1000);
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1303-2-1","卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01092_data_check() throws Exception
    {
        //卡车交限 测线9
//        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
//        for(Point p : LinePoints)
//        {
//            Page_MainBoard.Inst.Click(p);
//        }
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.NINE_RD);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.NINE_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1303-2-1","卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01093_data_check() throws Exception
    {
        //卡车交限 测11 种别6
        SearchLocation(LOC_K1);
//        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
//        //DrawRoad(LinePoints, Page_SurveyLine.PEOPLE_CROSS_RD);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
//        Page_MainBoard.Inst.Click(LinePoints[0]);
//        Page_MainBoard.Inst.Click(LinePoints[1]);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEOPLE_CROSS_RD);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEOPLE_CROSS_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(2000);
        Page_Kind.Inst.Click(Page_Kind.COUNTY_RD);
        Thread.sleep(1000);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1303-2-1","卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01094_data_check() throws Exception
    {
        //禁止卡车驶入 种别13
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Kind.Inst.Click(Page_Kind.FERRY_RD);
        Thread.sleep(1000);

        Thread.sleep(1000);
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.NO_PULL_INTO);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1308-2-1","卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01095_data_check() throws Exception
    {
        //卡车交限 测线10
//        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
//        Page_MainBoard.Inst.Click(LinePoints[0]);
//        Page_MainBoard.Inst.Click(LinePoints[1]);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.NO_PULL_INTO);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1308-2-1","卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01096_data_check() throws Exception
    {
        //Tips创建的时候界面会被拖拽一段距离
        //卡车交限 测10 种别4
        SearchLocation(LOC_K1);
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        for(Point p : LinePoints)
        {
            Page_MainBoard.Inst.Click(p);
        }
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(2000);
        Page_Kind.Inst.Click(Page_Kind.PROVINCIAL_RD);
        Thread.sleep(1000);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(2000);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.NO_PULL_INTO);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips内容值域检查","中","FM-1308-2-1","卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01097_data_check() throws Exception
    {
        //实景图原库数据不可以更改类别 请求编号正常
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(3000);
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        for (int i=0;i<6;i++)
        {
            Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
            Thread.sleep(2000);
        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("Tips关联照片检查","中","FM-1406-7-2","高速出口、入口实景图必须添加路口截屏照片，其他等级道路不采集卡车地图内容。","不能忽视");
    }

    @Test
    public void test998_01098_data_check() throws Exception
    {
        //区域内道路等级应该为8级或10级
        SearchRoadFromLink("28203254");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","中","FM-1604-6-1","区域内道路等级应该为8级或10级","忽视");
    }

    @Test
    public void test998_01099_data_check() throws Exception
    {
        //区域内道路等级应该为8级或10级
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints,Page_SurveyLine.COUNTY_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);
        Thread.sleep(1000);

        AssertIndoorCheck("共存关系检查","中","FM-1604-6-1","区域内道路等级应该为8级或10级","忽视");
    }

    @Test
    public void test998_01058_data_check() throws Exception
    {
        //Rdlink不具有内部道路属性时，如果新增区域内Tips（删属性）包含此条link，则报LOG。
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROUNDABOUT_1600);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoundAbout.Inst.Click(Page_RoundAbout.REGION_ROAD);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.DELETE);
        Page_RoundAbout.Inst.Click(Page_RoundAbout.SAVE);

        AssertIndoorCheck("区域内道路","低","FM-1604-1-4","新增区域内道路（pid：***，多个pid时，用逗号分割）上，已经具有区域内道路属性。不能重复增加属性。","可以忽略");
    }

    @Test
    public void test998_01101_tips_CarInfo_add() throws Exception
    {
        //点击更多,收起，显示隐藏全部单箭头选项
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.A);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.R);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);


        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }


    @Test
    public void test998_01104_tips_CarInfo_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.A);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.R);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);


        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
        ExitMyData();

        //新增单箭头 s 斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.S);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01105_tips_CarInfo_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.T);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01106_tips_CarInfo_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.X);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01107_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.U);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01108_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 u 左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.Z);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01109_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 w 调斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.W);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01110_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 0 调斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.ZERO);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01111_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 y 左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.Y);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01112_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 v 右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.V);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01113_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 2 直左斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.TWO);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");

    }

    @Test
    public void test998_01114_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 5 直右斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.FIVE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01115_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 3 直左斜右、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.THREE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01116_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 4 直右斜左、
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.FOUR);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01117_tips_CarInfo_add() throws Exception
    {
        //新增单箭头 1 斜左斜右
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test @IMPORTANT
    public void test998_01118_tips_CarInfo_add() throws Exception
    {
        //增加单车道箭头
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.A);//单车道任一控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.DRI);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.R);//斜左
        Page_LaneInfo.Inst.Click(Page_LaneInfo.S);//斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.T);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.X); //直斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.U);//直斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.Z);//左斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.W);//右斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.ZERO);//调斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.Y);//调斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.V);//左斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.TWO);//右斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.FIVE);//直左斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.THREE);//直右斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.FOUR);//直左斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE);//直右斜左控件ID

        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test @IMPORTANT
    public void test998_01119_tips_CarInfo_add() throws Exception
    {
        //增加单车道箭头
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.A);//单车道任一控件ID
        //Page_LaneInfo.Inst.Click(Page_LaneInfo.DRI);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.R);//斜左
        Page_LaneInfo.Inst.Click(Page_LaneInfo.S);//斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.T);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.X); //直斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.U);//直斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.Z);//左斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.W);//右斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.ZERO);//调斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.Y);//调斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.V);//左斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.TWO);//右斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.FIVE);//直左斜左控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.THREE);//直右斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.FOUR);//直左斜右控件ID
        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE);//直右斜左控件ID

        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test998_01148_tips_CarInfo_close() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.R);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.DELETE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.CANCEL);

        GotoMyData(Page_MyData.TIPS_TYPE);
        assertFalse(Page_MyData.Inst.isExistByName("车信"));
    }

    @Test @IMPORTANT
    public void test998_01201_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.POINT_LIMIT);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.MAX_SPEED);
        Page_SpeedLimit.Inst.ClickByText("40");
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.MIN_SPEED);
        Page_SpeedLimit.Inst.ClickByText("30");

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"点限速");
    }

    @Test
    public void test998_01203_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"危险信息");
    }

    @Test @IMPORTANT
    public void test998_01204_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();

        Page_TollGate.Inst.ClickByText("领卡");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"收费站");
    }

    @Test @IMPORTANT
    public void test998_01208_tips_add_Click() throws Exception
    {
        //单击手动设置点位信息，新增普通路口模式图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NORMAL_CROSSROAD_PICTURE);
        Page_MainBoard.Inst.ClickCenter();

        Page_NormalCrossPic.Inst.ClickByText("73100000");
        Page_NormalCrossPic.Inst.Click(Page_NormalCrossPic.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"普通路口模式图");
    }


    @Test @IMPORTANT
    public void test998_01209_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_ENTRY_MODE_PICTURE);
        Page_MainBoard.Inst.ClickCenter();

        Page_HighSpeedEntryPic.Inst.Click(Page_HighSpeedEntryPic.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"高速入口模式图");
    }

    @Test @IMPORTANT
    public void test998_01401_diagram_add() throws Exception
    {
        //挂接1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.HOOK1);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Sketch.Inst.Click(Page_Sketch.G1_R1_C2);
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"挂接");
    }

    @Test @IMPORTANT
    public void test998_01402_diagram_add() throws Exception
    {
        //挂接2
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.HOOK2);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Sketch.Inst.Click(Page_Sketch.G2_R1_C1);
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"挂接");
    }

    @Test @IMPORTANT
    public void test998_01403_diagram_add() throws Exception
    {
        //草图 直线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.STRAIGHT);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(794,444));
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01404_diagram_add() throws Exception
    {
        //草图 曲线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.CURVE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Drag(477,698,794,344,10);
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01405_diagram_add() throws Exception
    {
        //草图 折线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.POLY);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(794,444));
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01406_diagram_add() throws Exception
    {
        //草图 矩形
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.RECT);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(400,500,500,400,10);
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01407_diagram_add() throws Exception
    {
        //草图 圆形
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.ELLIPSE);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(400,500,500,400,10);
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01408_diagram_add() throws Exception
    {
        //草图 圆点
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.POINT);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01409_diagram_add() throws Exception
    {
        //草图 草地
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.GREEN_LAND);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01410_diagram_add() throws Exception
    {
        //草图 水系
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.WATER);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test
    public void test998_01411_diagram_add() throws Exception
    {
        //草图 铁路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_18_SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.SKETCH);
        Page_Sketch.Inst.Click(Page_Sketch.RAILWAY);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_Sketch.Inst.Click(Page_Sketch.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"草图");
    }

    @Test @IMPORTANT
    public void test998_01601_tips_copy() throws Exception
    {
        //复制电子眼
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(300,360));
        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
    }

//    @Test
//    public void test998_01602_tips_copy() throws Exception
//    {
//        //复制原库tips 查看inConfirm字段是否为1
//        SearchLocation("116.42218", "38.96087");
//
//        synchronize(Page_GridManager.TIPS_UPDATE);
//
//        SearchLocation("116.42218", "38.96087");
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_COPY_TIPS);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Click(new Point(300,360));
//        //查数据库字段
//        GotoMyData(Page_MyData.TIPS_TYPE);
//        Page_MyData.Inst.ClickbyText("红绿灯");
//        String rowkey = Page_Light.Inst.GetRowKey();
//
//
//        Sqlitetools.RefreshData();
//        int inConfirm = (Integer)Sqlitetools.GetTipsDataByRowKey(rowkey, "inConfirm");
//        assertSame(inConfirm,1);
//    }

    @Test @IMPORTANT
    public void test998_01701_MilePost_add() throws Exception
    {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "E30");
        Page_MilePost.Inst.Click(Page_MilePost.ZERO);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MilePost.Inst.ClickCenter();
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MainBoard.Inst.ClickCenter();
        String str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
        Thread.sleep(1000);
        assertEquals(str,"0");
        Page_MilePost.Inst.Click(Page_MilePost.INC);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MilePost.Inst.ClickCenter();
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MainBoard.Inst.ClickCenter();
        str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
        Thread.sleep(1000);
        assertEquals(str,"1");
        Page_MilePost.Inst.Click(Page_MilePost.DEC);
        str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
        Thread.sleep(1000);
        assertEquals(str,"0");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

//    @Test @IMPORTANT
//    public void test998_01703_MilePost_add() throws Exception
//    {
//        if(FastMapPage.IS_OS_TEST)
//        {
//            return;
//        }
//
//        String[] LOC_K8 = {"116.41222", "39.96192"};
//        SearchLocation(LOC_K8);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
//        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
//        Thread.sleep(1000);
//        Page_MainBoard.Inst.ClickCenter();
//        Thread.sleep(1000);
//        Page_MilePost.Inst.Click(Page_MilePost.ROADNAME);
//        Thread.sleep(1000);
//        Page_MilePost.Inst.Click(Page_MilePost.MILE_EDIT);
//        Thread.sleep(1000);
//        Page_MilePost.Inst.Click(Page_MilePost.FIVE);
//        Thread.sleep(1000);
//        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
//        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
//
//        SearchLocation(LOC_K8);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
//        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
//        Page_MilePost.Inst.Drag(400,200,300,200,5);
//        Thread.sleep(2000);
//
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MilePost.Inst.Click(Page_MilePost.INC);
//        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
//        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
//
//        SearchLocation(LOC_K8);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
//        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
//        Page_MilePost.Inst.Drag(400,200,100,200,5);
//        Thread.sleep(2000);
//        Page_MainBoard.Inst.ClickCenter();
//        String str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
//        assertTrue(str.equals("7"));
//        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
//        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
//
//        SearchLocation(LOC_K8);
//        Page_MilePost.Inst.ClickCenter();
//        //Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
//        Thread.sleep(2000);
//        //Page_MilePost.Inst.ScrollClick(Page_MilePost.MILE_NO);
//        Page_MilePost.Inst.Drag(1743,846,1743,300,5);
//        Page_MilePost.Inst.Click(Page_MilePost.MILE_EDIT);
//        Page_MilePost.Inst.Click(Page_MilePost.ZERO);
//        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
//
//        SearchLocation(LOC_K8);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
//        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
//        Page_MilePost.Inst.Drag(400,200,10,200,5);
//        Thread.sleep(2000);
//        Page_MainBoard.Inst.ClickCenter();
//        str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
//
//        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
//
//        assertTrue((str.equals("8")));
//
//        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
//    }


    @Test
    public void test998_01702_MilePost_add() throws Exception
    {
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.HIGH_SPEED);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

    @Test
    public void test998_01704_MilePost_add() throws Exception
    {
        //SearchRoadFromLink("342330");//南五环 S50
        SearchLocation("116.36099", "39.77775");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();
        //新规则，比对道路名编号S50，名称编号都继承

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);//保存

        CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

    @Test
    public void test998_01705_MilePost_add() throws Exception
    {
        //复制反方向里程桩 默认不选中
        SearchLocation("116.36099", "39.77775");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        //
        assertFalse(Page_MilePost.Inst.isChecked(Page_MilePost.COPY));
        Page_MilePost.Inst.Click(Page_MilePost.COPY);
        //复制字段（道路名  编号 里程数 备注）
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"D45");
        Page_MilePost.Inst.ClickbyText("3");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"南五环");
        Page_MilePost.Inst.Drag(1810,1237,1810,600,5);
        Page_MilePost.Inst.SetValue(Page_MilePost.REMARK,"测试备注");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);//保存

        String[] EYE_LOC = {"116.36098", "39.77759"};
        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        String str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);
        assertEquals(str,"Ｄ４５");
        str = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);
        assertEquals(str,"南五环");
        Page_MilePost.Inst.Drag(1810,1237,1810,600,5);
        str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
        assertEquals(str,"3");
        str = Page_MilePost.Inst.GetValue(Page_MilePost.REMARK);
        assertEquals(str,"测试备注");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
    }

    @Test @IMPORTANT
    public void test998_01705_gate_add() throws Exception
    {
        //大门 PG默认值车辆和行人
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        boolean isChecked = Page_Gate.Inst.isChecked("PG");
        assertTrue(isChecked);
        isChecked = Page_Gate.Inst.isChecked(Page_Gate.SINGLEGATE);
        assertFalse(isChecked);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01706_gate_add() throws Exception
    {
        //大门 KG默认值车辆和行人
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01707_gate_add() throws Exception
    {
        //大门 EG默认值车辆和行人
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01708_gate_add() throws Exception
    {
        //大门 PG默认值车辆和行人 勾选自行车
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }


    @Test
    public void test998_01715_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 勾选时间
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01716_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 勾选时间
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01717_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 勾选时间
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01718_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01719_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01720_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.CAR);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01721_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMEPERSON);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.PERSON);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01722_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMEPERSON);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.PERSON);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01724_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 勾选自行车切换至KG
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.KG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.PG);
        person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01725_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 切换保存
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.EG);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.KG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01726_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 切换保存
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.PG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.EG);
        car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01727_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 勾选自行车切换至KG
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.KG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.PG);
        person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01728_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 切换保存
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.EG);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.KG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01729_gate_add() throws Exception
    {
        //大门 EG默认值车辆和行人 切换保存
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.PG);
        boolean person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        boolean car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.KG);
        person = Page_Gate.Inst.isChecked(Page_Gate.PERSON);
        car = Page_Gate.Inst.isChecked(Page_Gate.CAR);
        assertTrue(person);
        assertTrue(car);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test998_01730_gate_add() throws Exception
    {
        //大门 默认PG
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        boolean Checked = Page_Gate.Inst.isChecked("PG");
        assertTrue(Checked);
    }

    @Test
    public void test998_01802_tips_add() throws Exception
    {
        //道路名连线
        AddRoadNameSign("测试道路", "116.42297", "39.96604");

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainBoard.Inst.ClickByText("道路名连线");
        Page_MainBoard.Inst.ClickByText("连线");
        Page_RoadName.Inst.Click(Page_RoadName.CANCEL);
        Page_MainMenu.Inst.Click(Page_MainMenu.ROADNAME_BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("道路名标牌");
        Thread.sleep(2000);
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.DELETE);
        Thread.sleep(3000);
        assertFalse(Page_MyData.Inst.isExistByName("道路名"));
    }

    @Test
    public void test998_01803_tips_add() throws Exception
    {
        AddRoadNameSign("和平里东街", "116.42461", "39.96350");
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);//点击道路标牌连线
        Page_MainMenu.Inst.ClickByText("道路名连线");
        Page_MainMenu.Inst.ClickByText("连线");
        Thread.sleep(5000);

        Page_RoadName.Inst.Click(Page_RoadName.COPYTYPE);//复制形状
        Page_RoadName.Inst.Click(Page_RoadName.MOVE);
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        Page_MainMenu.Inst.Click(Page_MainMenu.ROADNAME_BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        CheckMyData(Page_MyData.TIPS_TYPE, "道路名");
    }

    @Test @IMPORTANT
    public void test998_01804_tips_add() throws Exception
    {
        //道路名连线
        AddRoadNameSign("测试道路", "116.42297", "39.96604");
        AddRoadNameSign("测试道路", "116.42218", "39.96454");
        AddRoadNameSign("测试道路", "116.42397", "39.96528");

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);//点击道路标牌连线
        Page_MainBoard.Inst.ClickByText("道路名连线");
        Page_MainBoard.Inst.ClickByText("连线");
        Thread.sleep(2000);

        Page_RoadName.Inst.Click(Page_RoadName.COPYTYPE);//复制形状
        Page_RoadName.Inst.Click(Page_RoadName.MOVE);
        Page_RoadName.Inst.Click(Page_RoadName.SAVE);

        Page_MainMenu.Inst.Click(Page_MainMenu.ROADNAME_BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        Thread.sleep(2000);
        CheckMyData(Page_MyData.TIPS_TYPE, "道路名");
    }

    @Test
    public void test998_02101_note() throws Exception {
        //在便签属性页--绘制--点击上一步
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.BACK);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.BACK);
        Page_Note.Inst.Click(Page_Note.SAVE);
    }

    @Test
    public void test998_02102_note() throws Exception {
        //在便签属性页--绘制--点击下一步
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.BACK);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.FORWARD);
        Page_Note.Inst.Click(Page_Note.BACK);
        Page_Note.Inst.Click(Page_Note.BACK);
        Page_Note.Inst.Click(Page_Note.FORWARD);
        Page_Note.Inst.Click(Page_Note.FORWARD);
        Page_Note.Inst.Click(Page_Note.SAVE);
    }

    @Test
    public void test998_02103_note() throws Exception {
        //在便签属性页--绘制--点击重绘
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.CLEAR);
        Page_Note.Inst.Click(Page_Note.CANCEL);
    }

    @Test
    public void test998_02104_note() throws Exception {
        //在便签属性页--绘制--橡皮擦
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.ERASER);
        Page_MainBoard.Inst.Click(new Point(404,1068));
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.SAVE);
    }

    @Test
    public void test998_02105_note() throws Exception {
        //在便签属性页--绘制--修改新增
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("便签");
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(600,400,967,756,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.SAVE);
    }

    @Test
    public void test998_02106_note() throws Exception {
        //在便签属性页--绘制--室内整理工具--加载便签
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Page_Note.Inst.Click(Page_Note.SAVE);

        GotoIndoorTools();
        Thread.sleep(2000);
        assertTrue(Page_IndoorMyData.Inst.isExistByName("便签"));
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.BACK);
    }

    @Test
    public void test998_02107_note() throws Exception {
        //在便签属性页--绘制--室内整理工具--筛选便签
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Page_Note.Inst.Click(Page_Note.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);//筛选
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"便签");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER_EDTOR);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Thread.sleep(2000);

        assertTrue(Page_IndoorMyData.Inst.isExistByName("便签"));
    }

    @Test @IMPORTANT
    public void test998_02109_note() throws Exception {
        //在便签属性页--绘制--橡皮擦--我的数据重绘
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.ERASER);
        Page_MainBoard.Inst.Click(new Point(404,1068));
        Page_Note.Inst.Click(Page_Note.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("便签");
        Page_MainBoard.Inst.Drag(888,596,1130,226,5);
        Page_Note.Inst.Click(Page_Note.SAVE);
    }

    @Test
    public void test998_02110_note() throws Exception {
        //在便签属性页--绘制--清空重绘
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(332,675,751,478,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Thread.sleep(2000);
        Page_Note.Inst.Click(Page_Note.CLEAR);
        Page_MainBoard.Inst.Drag(355,377,653,879,5);
        Page_Note.Inst.Click(Page_Note.SAVE);
    }

    @Test
    public void test998_02202_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 限速标志 0 限速开始； 1 限速解除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);

        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int flag = jsonObject.getInt("flag");
        int sign = jsonObject.getInt("se");

        assertSame(flag,0);
        assertSame(sign,0);
    }

    @Test
    public void test998_02203_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 限速标志 0 限速开始； 1 限速解除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.ClickbyText("解除限速");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int flag = jsonObject.getInt("flag");
        int sign = jsonObject.getInt("se");
        assertSame(sign,1);
        assertSame(flag,0);
    }

    @Test
    public void test998_02204_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 采集标志 0 现场采集（默认）； 1 理论判断 是否收费站前0 否（默认），1 是
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.ClickbyText("理论判断");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int flag = jsonObject.getInt("flag");
        assertSame(flag,1);
    }

    @Test
    public void test998_02205_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 限速标志 文字显示
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.ClickbyText("匝道");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String str = jsonObject.getString("desc");
        assertEquals(str,"R");
    }

    @Test
    public void test998_02206_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 限速标志 文字显示
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.SetValue(Page_SpeedLimitLane.EDIT,"测试路段");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String str = jsonObject.getString("desc");
        assertEquals(str,"测试路段");
    }

    @Test
    public void test998_02207_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 限速标志 文字显示
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.SetValue(Page_SpeedLimitLane.EDIT,"测试路段");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String str = jsonObject.getString("desc");
        assertEquals(str,"测试路段");
    }

    @Test
    public void test998_02209_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 关联 2测线还是 1link
        String[] LOC = {"116.41701", "39.98345"};
        SearchLocation(LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");

        assertSame(type, 1);
    }

//    @Test
//    public void test998_02210_speedlimitlane() throws Exception
//    {
//        if (FastMapPage.IS_OS_TEST)
//        {
//            return;
//        }
//
//        //点限速 关联 2测线还是 1link
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Click(new Point(1038,200));
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
//        //Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
//        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
//        Thread.sleep(2000);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
//        Page_MainBoard.Inst.ClickCenter();
//        Thread.sleep(2000);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
//        GotoMyData(Page_MyData.TIPS_TYPE);
//        Page_MyData.Inst.ClickbyText("点限速");
//        Thread.sleep(2000);
//        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
//        Sqlitetools.RefreshData();
//        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
//        JSONObject jsonObject = new JSONObject(temp);
//        int type = jsonObject.getJSONObject("f").getInt("type");
//        assertSame(type, 2);
//    }

    @Test
    public void test998_02211_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //室内整理工具搜索点限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"点");
        Page_IndoorMyData.Inst.ClickbyText("点限速");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("点限速");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("点限速");
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.MINNUM);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickbyText("解除限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickbyText("收费站前");
        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1778,1260,1778,1100,5);
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.ClickbyText("匝道");
        Thread.sleep(2000);
        if (!Page_SpeedLimitLane.Inst.isExist(Page_SpeedLimitLane.NUM30,100))
        {
            Page_MainBoard.Inst.Drag(1778,1260,1778,1100,5);
        }
        Page_SpeedLimitLane.Inst.ClickbyText("30");
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        assertSame(type, 1);
        int value = jsonObject.getInt("value");
        assertSame(value, 40);
        int minV = jsonObject.getInt("minV");
        assertSame(minV, 30);
        int toll = jsonObject.getInt("toll");
        assertSame(toll, 1);
        int se = jsonObject.getInt("se");
        assertSame(se, 1);
        String desc = jsonObject.getString("desc");
        assertEquals(desc, "R");
    }

    @Test
    public void test998_02212_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //我的数据 点限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickbyText("解除限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.MINNUM);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickbyText("收费站前");
        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1778,1260,1778,1100,5);
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.ClickbyText("匝道");
        Thread.sleep(2000);
        if (!Page_SpeedLimitLane.Inst.isExist(Page_SpeedLimitLane.NUM30,100))
        {
            Page_MainBoard.Inst.Drag(1778,1260,1778,1100,5);
        }
        Page_SpeedLimitLane.Inst.ClickbyText("30");
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        assertSame(type, 1);
        int value = jsonObject.getInt("value");
        assertSame(value, 40);
        int minV = jsonObject.getInt("minV");
        assertSame(minV, 30);
        int toll = jsonObject.getInt("toll");
        assertSame(toll, 1);
        int se = jsonObject.getInt("se");
        assertSame(se, 1);
        String desc = jsonObject.getString("desc");
        assertEquals(desc, "R");
    }

    @Test
    public void test998_02213_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //我的数据 取消
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.CANCEL);
    }

    @Test
    public void test998_02214_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //我的数据 点限速删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("点限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.DELETE);
        Thread.sleep(1000);
        assertFalse(Page_MyData.Inst.isExistByName("点限速"));
    }

    @Test
    public void test998_02215_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 其他车道最低限速小于最高限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);
        CheckMyData(Page_MyData.TIPS_TYPE,"车道限速");
    }

    @Test
    public void test998_02216_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 四车道以上
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,452,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);
        CheckMyData(Page_MyData.TIPS_TYPE,"车道限速");
    }

    @Test
    public void test998_02217_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 其他车道最低限速大于最高限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,352,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);
        CheckMyData(Page_MyData.TIPS_TYPE,"车道限速");
    }

    @Test
    public void test998_02218_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 我的数据再次编辑
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 5);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限速");
        Page_SpeedLimitLane.Inst.ClickbyText("调整箭头方向");
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 5);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 6);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02219_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 我的数据
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限速");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_02220_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 我的数据
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限速");
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_02221_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 室内整理工具
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"车道");
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Page_IndoorMyData.Inst.ClickbyText("删除");
        ExitIndoorTools();
    }

    @Test
    public void test998_02222_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 室内整理工具
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickbyText("调整箭头方向");
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 5);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 6);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_02223_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 室内整理工具
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("车道限速");
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.CANCEL);
        ExitIndoorTools();
    }

    @Test
    public void test998_02224_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(82,460,452,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(82,460,352,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByText("高:40/0/0");
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 7);

        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

//        //查看历史记录
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
//        Page_MainBoard.Inst.ClickCenter();
//        Thread.sleep(2000);
//        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
//        Thread.sleep(1000);
//
//        Page_MainBoard.Inst.Drag(82,460,252,460,10);
//        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
//        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
//        Thread.sleep(1000);
//        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
//        Thread.sleep(1000);
//        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
//        Thread.sleep(1000);
//
//        Page_MainBoard.Inst.Drag(1822,951,1822,444,10);
//        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
//        Thread.sleep(1000);
//        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
//        Thread.sleep(1000);
//        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
//        Thread.sleep(1000);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
//        Thread.sleep(1000);
//
//        GotoIndoorTools();
//        Page_IndoorMyData.Inst.ClickbyText("车道限速");
//        Thread.sleep(2000);
//        Page_IndoorMyData.Inst.ClickbyText("车道限速");
//        Thread.sleep(1000);
//        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.CANCEL);
//        ExitIndoorTools();
    }

    @Test
    public void test998_02224_variablelimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //可变限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.VARIABLELIMIT);
        Thread.sleep(1000);

        Page_VariableSpeedLimit.Inst.SetValue(Page_VariableSpeedLimit.REMARK,"测试专用");
        Page_VariableSpeedLimit.Inst.ClickbyText("左");

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        String desc = Page_VariableSpeedLimit.Inst.GetValue(Page_VariableSpeedLimit.REMARK);
        assertEquals(desc,"测试专用");
        Page_VariableSpeedLimit.Inst.Click(Page_VariableSpeedLimit.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int loc = jsonObject.getInt("loc");
        assertSame(loc,1);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        Page_VariableSpeedLimit.Inst.SetValue(Page_VariableSpeedLimit.REMARK,"测试");
        desc = Page_VariableSpeedLimit.Inst.GetValue(Page_VariableSpeedLimit.REMARK);
        assertEquals(desc,"测试");
        Page_VariableSpeedLimit.Inst.ClickbyText("上");

        Sqlitetools.RefreshData();
        temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject1 = new JSONObject(temp);
        loc = jsonObject1.getInt("loc");
        assertSame(loc,4);
    }

    @Test
    public void test998_02225_variablelimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //可变限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.VARIABLELIMIT);
        Thread.sleep(1000);

        Page_VariableSpeedLimit.Inst.ClickbyText("左");

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        Page_MyData.Inst.ClickbyText("可变限速");
        Thread.sleep(1000);
        Page_VariableSpeedLimit.Inst.Click(Page_VariableSpeedLimit.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_02226_variablelimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //可变限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.VARIABLELIMIT);
        Thread.sleep(1000);

        Page_VariableSpeedLimit.Inst.ClickbyText("左");

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        Page_MyData.Inst.ClickbyText("可变限速");
        Thread.sleep(1000);
        Page_VariableSpeedLimit.Inst.Click(Page_VariableSpeedLimit.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_02227_variablelimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //可变限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.VARIABLELIMIT);
        Thread.sleep(1000);

        Page_VariableSpeedLimit.Inst.ClickbyText("左");

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Thread.sleep(1000);
        Page_VariableSpeedLimit.Inst.Click(Page_VariableSpeedLimit.CANCEL);
        ExitIndoorTools();
    }

    @Test
    public void test998_02228_variablelimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //可变限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.VARIABLELIMIT);
        Thread.sleep(1000);

        Page_VariableSpeedLimit.Inst.SetValue(Page_VariableSpeedLimit.REMARK,"测试专用");
        Page_VariableSpeedLimit.Inst.ClickbyText("左");

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Thread.sleep(1000);
        Page_VariableSpeedLimit.Inst.Click(Page_VariableSpeedLimit.DELETE);
        ExitIndoorTools();
    }

    @Test
    public void test998_02229_variablelimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }
        //可变限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.VARIABLELIMIT);
        Thread.sleep(1000);

        Page_VariableSpeedLimit.Inst.SetValue(Page_VariableSpeedLimit.REMARK,"测试专用");
        Page_VariableSpeedLimit.Inst.ClickbyText("左");

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"可变");
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("可变限速");
        Thread.sleep(1000);
        String rowkey = Page_SpeedLimitLane.Inst.GetRowKey();
        Page_VariableSpeedLimit.Inst.ClickbyText("右");
        ExitIndoorTools();

        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int loc = jsonObject.getInt("loc");
        assertSame(loc,2);
    }

    @Test
    public void test998_02301_dangerusinfo() throws Exception
    {
        //危险信息  历史记录
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        Page_MainBoard.Inst.Drag(1350,700,1200,700,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.HISTORY1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
    }

    @Test
    public void test998_02302_dangerusinfo() throws Exception
    {
        //危险信息  选中当前icon
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        Page_Dangerous.Inst.Click(Page_Dangerous.ICONSTOP);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_2);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
    }

    @Test
    public void test998_02303_dangerusinfo() throws Exception
    {
        //危险信息  当前icon删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        Page_Dangerous.Inst.Click(Page_Dangerous.ICONDEL);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_2);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
    }

    @Test
    public void test998_02304_dangerusinfo() throws Exception
    {
        //危险信息  附属信息是否展开显示
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SHOWINFO);
        Page_Dangerous.Inst.SetValue(Page_Dangerous.EFFECTIVEDIS,"20");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.WARNINGDIS,"20");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.DESC,"测试信息");
        //Page_Dangerous.Inst.Click(Page_Dangerous.SHOWINFO);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        Thread.sleep(2000);
        assertTrue(Page_Dangerous.Inst.isExist(Page_Dangerous.EFFECTIVEDIS,100));
        assertTrue(Page_Dangerous.Inst.isExist(Page_Dangerous.WARNINGDIS,100));
        assertTrue(Page_Dangerous.Inst.isExist(Page_Dangerous.DESC,100));
    }

    @Test
    public void test998_02305_dangerusinfo() throws Exception
    {
        //危险信息  附属信息中的数据是否准确赋值
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SHOWINFO);
        Page_Dangerous.Inst.SetValue(Page_Dangerous.EFFECTIVEDIS,"20");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.WARNINGDIS,"20");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.DESC,"测试信息");
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONArray jsontemp = new JSONObject(temp).getJSONArray("w_array");
        JSONObject jsonObject = jsontemp.getJSONObject(0);
        int vDis = jsonObject.getInt("vDis");
        assertSame(vDis, 20);
        int wDis = jsonObject.getInt("wDis");
        assertSame(wDis, 20);
        String desc = jsonObject.getString("desc");
        assertEquals(desc, "测试信息");
    }

    @Test
    public void test998_02306_dangerusinfo() throws Exception
    {
        //危险信息  关联 2 测线还是link 1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1038,200));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.Click(new Point(1038,200));
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("in").getInt("type");
        assertSame(type, 2);
    }

    @Test
    public void test998_02307_dangerusinfo() throws Exception
    {
        //危险信息  关联 2 测线还是link 1
        String[] LOC = {"116.41701", "39.98345"};
        SearchLocation(LOC);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("in").getInt("type");
        assertSame(type, 1);
    }

    @Test
    public void test998_02308_dangerusinfo() throws Exception
    {
        //室内整理工具 危险信息
        String[] LOC = {"116.41701", "39.98345"};
        SearchLocation(LOC);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"危");
        Page_IndoorMyData.Inst.ClickbyText("危险信息");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("危险信息");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("危险信息");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Page_Dangerous.Inst.Click(Page_Dangerous.SHOWINFO);
        Page_Dangerous.Inst.SetValue(Page_Dangerous.EFFECTIVEDIS,"30");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.WARNINGDIS,"40");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.DESC,"测试信息1");
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("in").getInt("type");
        assertSame(type, 1);
        JSONArray jsontemp = new JSONObject(temp).getJSONArray("w_array");
        JSONObject jsonObject1 = jsontemp.getJSONObject(0);
        int vDis = jsonObject1.getInt("vDis");
        assertSame(vDis, 30);
        int wDis = jsonObject1.getInt("wDis");
        assertSame(wDis, 40);
        String desc = jsonObject1.getString("desc");
        assertEquals(desc, "测试信息1");
    }

    @Test
    public void test998_02309_dangerusinfo() throws Exception
    {
        //我的数据 危险信息
        String[] LOC = {"116.41701", "39.98345"};
        SearchLocation(LOC);
        Thread.sleep(2000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Page_Dangerous.Inst.Click(Page_Dangerous.SHOWINFO);
        Page_Dangerous.Inst.SetValue(Page_Dangerous.EFFECTIVEDIS,"40");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.WARNINGDIS,"30");
        Page_Dangerous.Inst.SetValue(Page_Dangerous.DESC,"测试信息2");
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("in").getInt("type");
        assertSame(type, 1);
        JSONArray jsontemp = new JSONObject(temp).getJSONArray("w_array");
        JSONObject jsonObject1 = jsontemp.getJSONObject(0);
        int vDis = jsonObject1.getInt("vDis");
        assertSame(vDis, 40);
        int wDis = jsonObject1.getInt("wDis");
        assertSame(wDis, 30);
        String desc = jsonObject1.getString("desc");
        assertEquals(desc, "测试信息2");
    }

    @Test
    public void test998_02310_dangerusinfo() throws Exception
    {
        //我的数据 危险信息取消
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        Page_Dangerous.Inst.Click(Page_Dangerous.CANCEL);
    }

    @Test
    public void test998_02311_dangerusinfo() throws Exception
    {
        //我的数据 危险信息删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("危险信息");
        Page_Dangerous.Inst.Click(Page_Dangerous.DELETE);
        Thread.sleep(1000);
        assertFalse(Page_MyData.Inst.isExistByName("危险信息"));
    }

    @Test
    public void test998_02401_tollgate() throws Exception
    {
        //收费站 名称 跨界收费
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("跨界收费");
        Page_TollGate.Inst.ClickbyText("领卡");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("收费站");
        String rowkey = Page_TollGate.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String name = jsonObject.getString("name");
        int loc = jsonObject.getInt("loc");
        int tp = jsonObject.getInt("tp");
        int photo = jsonObject.getInt("photo");
        assertSame(loc,2);
        assertSame(tp,1);
        assertSame(photo,1);
        assertEquals(name,"测试名称");
    }

    @Test
    public void test998_02402_tollgate() throws Exception
    {
        //收费站 收费类型
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("收费站");
        String rowkey = Page_TollGate.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String name = jsonObject.getString("name");
        int loc = jsonObject.getInt("loc");
        int tp = jsonObject.getInt("tp");
        int photo = jsonObject.getInt("photo");
        assertSame(loc,1);
        assertSame(tp,4);
        assertSame(photo,1);
        assertEquals(name,"测试名称");
    }

    @Test
    public void test998_02403_tollgate() throws Exception
    {
        //收费站 标牌照片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Page_TollGate.Inst.ClickbyText("无标牌");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("收费站");
        String rowkey = Page_TollGate.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String name = jsonObject.getString("name");
        int loc = jsonObject.getInt("loc");
        int tp = jsonObject.getInt("tp");
        int photo = jsonObject.getInt("photo");
        assertSame(loc,1);
        assertSame(tp,4);
        assertSame(photo,2);
        assertEquals(name,"测试名称");
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("收费站");
        Thread.sleep(2000);
        if (!Page_TollGate.Inst.isExistByName("已采集"))
        {
            Page_MainBoard.Inst.Drag(1778,1260,1778,1100,5);
        }
        Page_TollGate.Inst.ClickbyText("已采集");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        Sqlitetools.RefreshData();
        String temp1 = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject1 = new JSONObject(temp1);
        int photo1 = jsonObject1.getInt("photo");
        assertSame(photo1,3);
    }

    @Test
    public void test998_02404_tollgate() throws Exception
    {
        if(FastMapPage.IS_OS_TEST)
        {
            //拖动长度和android不同
            return;
        }

        //收费站 通道数
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Page_MainBoard.Inst.Drag(138,470,318,470,5);
        Thread.sleep(2000);
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("收费站");
        String rowkey = Page_TollGate.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String name = jsonObject.getString("name");
        int loc = jsonObject.getInt("loc");
        int tp = jsonObject.getInt("tp");
        int photo = jsonObject.getInt("photo");
        int pNum = jsonObject.getInt("pNum");
        assertSame(pNum,4);
        assertSame(loc,1);
        assertSame(tp,4);
        assertSame(photo,1);
        assertEquals(name,"测试名称");
    }

    @Test
    public void test998_02405_tollgate() throws Exception
    {
        if(FastMapPage.IS_OS_TEST)
        {
            //拖动长度和android不同
            return;
        }

        //室内整理工具 收费站
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Page_MainBoard.Inst.Drag(138,470,318,470,5);
        Thread.sleep(2000);
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"收");
        Page_IndoorMyData.Inst.ClickbyText("收费站");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("收费站");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("收费站");
        Thread.sleep(2000);

        String rowkey = Page_TollGate.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String name = jsonObject.getString("name");
        int loc = jsonObject.getInt("loc");
        int tp = jsonObject.getInt("tp");
        int photo = jsonObject.getInt("photo");
        int pNum = jsonObject.getInt("pNum");
        assertSame(pNum,4);
        assertSame(loc,1);
        assertSame(tp,4);
        assertSame(photo,1);
        assertEquals(name,"测试名称");
    }

    @Test
    public void test998_02406_tollgate() throws Exception
    {
        if(FastMapPage.IS_OS_TEST)
        {
            //拖动长度和android不同
            return;
        }

        //我的数据 收费站
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Page_MainBoard.Inst.Drag(138,470,318,470,5);
        Thread.sleep(2000);
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("收费站");
        Thread.sleep(1000);

        String rowkey = Page_TollGate.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String name = jsonObject.getString("name");
        int loc = jsonObject.getInt("loc");
        int tp = jsonObject.getInt("tp");
        int photo = jsonObject.getInt("photo");
        int pNum = jsonObject.getInt("pNum");
        assertSame(pNum,4);
        assertSame(loc,1);
        assertSame(tp,4);
        assertSame(photo,1);
        assertEquals(name,"测试名称");
    }

    @Test
    public void test998_02407_tollgate() throws Exception
    {
        //收费站取消
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        Thread.sleep(2000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("收费站");
        Thread.sleep(1000);
        Page_TollGate.Inst.Click(Page_TollGate.CANCEL);
    }

    @Test
    public void test998_02408_tollgate() throws Exception
    {
        //收费站删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_TollGate.Inst.SetValue(Page_TollGate.EDIT,"测试名称");
        Page_TollGate.Inst.ClickbyText("交卡付费后再领卡");
        Thread.sleep(2000);
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("收费站");
        Thread.sleep(1000);
        Page_TollGate.Inst.Click(Page_TollGate.DELETE);
        Thread.sleep(1000);
        assertFalse(Page_MyData.Inst.isExistByName("收费站"));
    }

    @Test
    public void test998_02501_electroniceye() throws Exception
    {
        //电子眼  超高速限速值 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.ClickbyText("60");
        Thread.sleep(1000);
        String speednum = Page_ElecEye.Inst.GetValue(Page_ElecEye.SPEEDEDIT).trim();
        assertEquals(speednum,"60");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        assertTrue(Page_MyData.Inst.isExistByName("电子眼"));
        Page_MyData.Inst.ClickbyText("电子眼");
    }

    @Test
    public void test998_02502_electroniceye() throws Exception
    {
        //电子眼  公交车道显示时间 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_BUS_LANE);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_ElecEye.Inst.ClickbyText("增加时间");
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        String speednum = Page_ElecEye.Inst.GetValue(Page_ElecEye.TIMEEDIT);
        assertEquals(speednum,"06:00~20:00;");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.ClickbyText("电子眼");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int thrd = jsonObject.getInt("thrd");
        int tp = jsonObject.getInt("tp");
        String time = jsonObject.getString("time");
        assertEquals(time,"06:00~20:00;");
        assertSame(type,1);
        assertSame(thrd,0);
        assertSame(tp,15);
    }

    @Test
    public void test998_02503_electroniceye() throws Exception
    {
        //电子眼  环保限行 显示车辆类型 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_ENV_PROT);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("客车");
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("运输卡车");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        //assertFalse(Page_MyData.Inst.isExistByName("电子眼"));
        Page_MyData.Inst.ClickbyText("电子眼");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int thrd = jsonObject.getInt("thrd");
        int tp = jsonObject.getInt("tp");
        JSONArray vt = jsonObject.getJSONArray ("vt");

        assertSame(vt.getInt(0),1);
        assertSame(vt.getInt(1),3);
        assertSame(type,1);
        assertSame(thrd,0);
        assertSame(tp,24);
    }

    @Test
    public void test998_02504_electroniceye() throws Exception
    {
        //电子眼  建立配对关系 文字提示 10km内
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);


        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("建立配对关系");
        Thread.sleep(20000);
        Page_ElecEye.Inst.ClickbyText("1 测速结束(10km内)", "区间结束(10公里内)");
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
        Page_MyData.Inst.SelectData("电子眼");
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("删除配对关系");
        Thread.sleep(2000);
        Page_ElecEye.Inst.ClickbyText("确定");
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_02505_electroniceye() throws Exception
    {
        //电子眼  建立配对关系 文字提示 10km内
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("电子眼");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(str);
        String pair = jsonObject.getString("pair");
        assertEquals("0",pair);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("建立配对关系");
        Thread.sleep(20000);
        Page_ElecEye.Inst.ClickbyText("1 测速结束(10km内)", "区间结束(10公里内)");
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.ClickCenter();
        String rowkey1 = Page_ElecEye.Inst.GetRowKey();
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        Sqlitetools.RefreshData();
        str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject1 = new JSONObject(str);
        pair = jsonObject1.getString("pair");
        assertEquals(pair,rowkey1);


        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
        Page_MyData.Inst.ClickByText("电子眼");
        Thread.sleep(2000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,210,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("删除配对关系");
        Page_ElecEye.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.ClickbyText("保存");

        ExitMyData();

        Sqlitetools.RefreshData();
        str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject2 = new JSONObject(str);
        pair = jsonObject2.getString("pair");
        assertEquals("0",pair);

        AssertIndoorCheck("共存关系检查","中","FM-1109-6-8","区间测速应该存在配对关系","不能忽略");
    }

    @Test
    public void test998_02506_electroniceye() throws Exception
    {
        //电子眼  建立配对关系 文字提示勾选框 推荐默认勾选
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("电子眼");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        Sqlitetools.RefreshData();
        String str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(str);
        String pair = jsonObject.getString("pair");
        assertEquals("0",pair);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,800,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(2000);
        Page_ElecEye.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,800,800,5);
        Page_MainBoard.Inst.ClickCenter();
        String rowkey1 = Page_ElecEye.Inst.GetRowKey();
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

        Sqlitetools.RefreshData();
        str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey1,"deep"));
        JSONObject jsonObject1 = new JSONObject(str);
        pair = jsonObject1.getString("pair");
        assertEquals(pair,rowkey);

        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
        Page_MyData.Inst.ClickByText("电子眼");
        Thread.sleep(2000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,210,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("删除配对关系");
        Page_ElecEye.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey1,"deep"));
        JSONObject jsonObject2 = new JSONObject(str);
        pair = jsonObject2.getString("pair");
        assertEquals("0",pair);

        AssertIndoorCheck("共存关系检查","中","FM-1109-6-8","区间测速应该存在配对关系","不能忽略");
    }

    @Test
    public void test998_02507_electroniceye() throws Exception
    {
        //电子眼  建立配对关系 文字提示勾选框
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_ADAPTER_CHECKBOX);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
        Page_MyData.Inst.SelectData("电子眼");
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("删除配对关系");
        Thread.sleep(2000);
        Page_ElecEye.Inst.ClickbyText("确定");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02508_electroniceye() throws Exception
    {
        //电子眼  建立配对关系多选项列表
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1300,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);
        CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");
        Page_MyData.Inst.SelectData("电子眼");
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);
        Page_ElecEye.Inst.ClickbyText("2 测速开始(10km内)", "区间开始(10公里内)");
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Page_MyData.Inst.SelectData("电子眼");
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("删除配对关系");
        Page_ElecEye.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        boolean result = true;
        result = Page_ElecEye.Inst.isChecked(Page_ElecEye.DELETE_PAIR);
        assertFalse(result);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02509_electroniceye() throws Exception
    {
        //电子眼  室内整理工具
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("电子眼");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("电子眼");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_02510_electroniceye() throws Exception
    {
        //电子眼  建立配对关系多选项列表
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_END);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_INTERVAL_START);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Page_ElecEye.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_ADAPTER_CHECKBOX);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
        Page_ElecEye.Inst.ClickbyText("确定");

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("电子眼");
        Page_ElecEye.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        boolean result = true;
        result = Page_ElecEye.Inst.isChecked(Page_ElecEye.DELETE_PAIR);

        assertFalse(result);
        Thread.sleep(1000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02511_electroniceye() throws Exception
    {
        //电子眼  复制反方向电子眼
        SearchLocation("116.36099", "39.77775");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.ClickbyText("复制反方向电子眼");
        Thread.sleep(1000);
        Page_ElecEye.Inst.ClickbyText("50");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        Thread.sleep(1000);

        String[] EYE_LOC = {"116.36098", "39.77759"};
        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Drag(1800,1200,1800,800,5);
        String str = Page_ElecEye.Inst.GetValue(Page_ElecEye.SPEEDEDIT);
        assertEquals(str,"50");
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
    }

    @Test
    public void test998_02601_trucklimit() throws Exception
    {
        SearchLocation(LOC_K3);
        //卡车限制 限高
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.ClickbyText("现场预估");
        Page_TruckLimit.Inst.ClickbyText("复制反方向卡车限制");
        Page_TruckLimit.Inst.ClickbyText("2.5");
        Page_TruckLimit.Inst.SetValue(Page_TruckLimit.REMARK,"测试");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);
        Thread.sleep(2000);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车限制");
        Page_MyData.Inst.ClickbyText("卡车限制");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        double ht = jsonObject.getDouble("ht");
        int htFlag = jsonObject.getInt("htFlag");
        assertEquals(ht,2.5,0.0);
        assertSame(htFlag,2);
    }

    @Test
    public void test998_02602_trucklimit() throws Exception
    {
        //卡车限制 限重
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckLimit.Inst.Click(Page_TruckLimit.WEIGHT);
        Page_TruckLimit.Inst.ClickbyText("20");
        Page_TruckLimit.Inst.SetValue(Page_TruckLimit.REMARK,"测试");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车限制");
        Page_MyData.Inst.ClickbyText("卡车限制");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        double wt = jsonObject.getDouble("wt");
        assertEquals(wt,20.0,0.0);
    }

    @Test
    public void test998_02603_trucklimit() throws Exception
    {
        //卡车限制 限轴重
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.AXLE);
        Page_TruckLimit.Inst.ClickbyText("10");
        Page_TruckLimit.Inst.SetValue(Page_TruckLimit.REMARK,"测试");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车限制");
        Page_MyData.Inst.ClickbyText("卡车限制");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        double ax = jsonObject.getDouble("ax");
        assertEquals(ax,10.0,0.0);
    }

    @Test
    public void test998_02604_trucklimit() throws Exception
    {
        //卡车限制 限宽
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.WIDTH);
        Page_TruckLimit.Inst.ClickbyText("3.5");
        Page_TruckLimit.Inst.SetValue(Page_TruckLimit.REMARK,"测试");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车限制");
        Page_MyData.Inst.ClickbyText("卡车限制");
        String rowkey = Page_ElecEye.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        double wd = jsonObject.getDouble("wd");
        int wdFlag = jsonObject.getInt("wdFlag");
        assertEquals(wd,3.5,0.0);
        assertSame(wdFlag,0);
    }

    @Test
    public void test998_02605_trucklimit() throws Exception
    {
        //卡车限制 拍照
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车限制");
    }

    @Test
    public void test998_02606_trucklimit() throws Exception
    {
        //室内整理工具 卡车限制
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"卡");
        Page_IndoorMyData.Inst.ClickbyText("卡车限制");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("卡车限制");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("卡车限制");
        Thread.sleep(2000);
        Page_TruckLimit.Inst.ClickbyText("限高");
        Page_TruckLimit.Inst.ClickbyText("3.5");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);
    }

    @Test
    public void test998_02607_trucklimit() throws Exception
    {
        //我的数据 收费站
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车限制");
        Page_MyData.Inst.SelectData("卡车限制");
        Page_TruckLimit.Inst.ClickbyText("限高");
        Page_TruckLimit.Inst.ClickbyText("3.5");
        Page_TruckLimit.Inst.ClickbyText("限宽");
        Page_TruckLimit.Inst.ClickbyText("3");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);
    }

    @Test
    public void test998_02608_trucklimit() throws Exception
    {
        //卡车限制取消
        //我的数据
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车限制");
        Page_MyData.Inst.SelectData("卡车限制");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_02609_trucklimit() throws Exception
    {
        //卡车限制删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckLimit.Inst.Click(Page_TruckLimit.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"卡车限制");
        Page_MyData.Inst.ClickbyText("卡车限制");
        Thread.sleep(2000);
        Page_TruckLimit.Inst.Click(Page_TruckLimit.DELETE);
        Thread.sleep(1000);
        assertFalse(Page_MyData.Inst.isExistByName("卡车限制"));
    }

    @Test
    public void test998_02701_gradient() throws Exception
    {
        //坡度
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);// GRADIENT
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.SetValue(Page_Gradient.REMARK,"测试");
        Page_Gradient.Inst.ClickbyText("水平");

        CheckMyData(Page_MyData.TIPS_TYPE,"坡度");
        ExitMyData();
    }

    @Test
    public void test998_02702_gradient() throws Exception
    {
        //坡度
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.SetValue(Page_Gradient.REMARK,"测试");
        Page_Gradient.Inst.ClickbyText("上坡");

        CheckMyData(Page_MyData.TIPS_TYPE,"坡度");
        ExitMyData();
    }

    @Test
    public void test998_02703_gradient() throws Exception
    {
        //坡度
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.SetValue(Page_Gradient.REMARK,"测试");
        Page_Gradient.Inst.ClickbyText("下坡");

        CheckMyData(Page_MyData.TIPS_TYPE,"坡度");
        ExitMyData();
    }

    @Test
    public void test998_02704_gradient() throws Exception
    {
        //坡度 我的数据
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.SetValue(Page_Gradient.REMARK,"测试");
        Page_Gradient.Inst.ClickbyText("下坡");

        CheckMyData(Page_MyData.TIPS_TYPE,"坡度");
        Page_MyData.Inst.SelectData("坡度");
        Page_Gradient.Inst.ClickbyText("水平");

        ExitMyData();
    }

    @Test
    public void test998_02705_gradient() throws Exception
    {
        //坡度 室内整理
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.SetValue(Page_Gradient.REMARK,"测试");
        Page_Gradient.Inst.ClickbyText("下坡");

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"坡度");
        Page_IndoorMyData.Inst.ClickbyText("坡度");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("坡度");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("坡度");
        Page_Gradient.Inst.ClickbyText("水平");
        ExitIndoorTools();
    }

    @Test
    public void test998_02706_gradient() throws Exception
    {
        //坡度 删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.ClickbyText("下坡");

        CheckMyData(Page_MyData.TIPS_TYPE,"坡度");
        Page_MyData.Inst.SelectData("坡度");
        Thread.sleep(2000);
        Page_Gradient.Inst.Click(Page_Gradient.DELETE);
        Thread.sleep(1000);
        assertFalse(Page_MyData.Inst.isExistByName("坡度"));
    }

    @Test
    public void test998_02707_gradient() throws Exception
    {
        //坡度 删除
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GRADIENT);
        Page_MainBoard.Inst.ClickCenter();
        Page_Gradient.Inst.ClickbyText("下坡");

        CheckMyData(Page_MyData.TIPS_TYPE,"坡度");
        Page_MyData.Inst.SelectData("坡度");
        Thread.sleep(2000);
        Page_Gradient.Inst.Click(Page_Gradient.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_02801_conditionlimit() throws Exception
    {
        //条件限速
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("开始限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("40");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雨");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("解除限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("40");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雨");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"条件限速");
        ExitMyData();
    }

    @Test
    public void test998_02802_conditionlimit() throws Exception
    {
        //条件限速
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("开始限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("40");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雨");
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SCHOOL);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.TIME);
        Page_ConditionSpeedLimit.Inst.ClickbyText("确定");
        Page_ConditionSpeedLimit.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.SetValue(Page_ConditionSpeedLimit.REMARK,"测试");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"条件限速");
        ExitMyData();
    }

    @Test
    public void test998_02803_conditionlimit() throws Exception
    {
        //条件限速 我的数据
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("开始限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("40");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雨");
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"条件限速");
        Page_MyData.Inst.ClickbyText("条件限速");
        Thread.sleep(2000);
        Page_ConditionSpeedLimit.Inst.ClickbyText("调整箭头方向");
        Page_ConditionSpeedLimit.Inst.ClickbyText("解除限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雪");
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SCHOOL);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.TIME);
        Page_ConditionSpeedLimit.Inst.ClickbyText("确定");
        Page_ConditionSpeedLimit.Inst.Drag(1824,1290,1824,1027,5);
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.ClickbyText("50");
        Page_ConditionSpeedLimit.Inst.Drag(1824,1290,1824,527,5);
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.SetValue(Page_ConditionSpeedLimit.REMARK,"测试");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02804_conditionlimit() throws Exception
    {
        //条件限速 室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("开始限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("40");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雨");
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"条件限速");
        Page_IndoorMyData.Inst.ClickbyText("条件限速");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("条件限速");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("条件限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("移动点位");
        Page_ConditionSpeedLimit.Inst.ClickbyText("调整箭头方向");
        Page_ConditionSpeedLimit.Inst.ClickbyText("解除限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雪");
        Thread.sleep(1000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SCHOOL);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.TIME);
        Page_ConditionSpeedLimit.Inst.ClickbyText("确定");

        Page_ConditionSpeedLimit.Inst.Drag(1824,1290,1824,527,5);
        Page_ConditionSpeedLimit.Inst.SetValue(Page_ConditionSpeedLimit.REMARK,"测试");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_02805_conditionlimit() throws Exception
    {
        //条件限速
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("开始限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("60");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雪");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雾");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("条件限速");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Page_ConditionSpeedLimit.Inst.isChecked(Page_ConditionSpeedLimit.SNOW);
        Page_ConditionSpeedLimit.Inst.isChecked(Page_ConditionSpeedLimit.FOG);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int value = jsonObject.getInt("value");
        assertSame(type, 1);
        assertSame(se, 0);
        assertSame(value, 60);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("条件限速");
        Thread.sleep(2000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_02806_conditionlimit() throws Exception
    {
        //条件限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1310, 1410));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.CONDITIONLIMIT);
        Page_ConditionSpeedLimit.Inst.ClickbyText("开始限速");
        Page_ConditionSpeedLimit.Inst.ClickbyText("60");
        Page_ConditionSpeedLimit.Inst.ClickbyText("雪");
        Page_ConditionSpeedLimit.Inst.Drag(1795,1200,1795,700,5);
        Page_ConditionSpeedLimit.Inst.SetValue(Page_ConditionSpeedLimit.REMARK,"测试条件限速");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("条件限速");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Page_ConditionSpeedLimit.Inst.ClickbyText("雾");
        Page_ConditionSpeedLimit.Inst.isChecked(Page_ConditionSpeedLimit.FOG);
        Page_ConditionSpeedLimit.Inst.Drag(1795,1200,1795,700,5);
        Page_ConditionSpeedLimit.Inst.ClickbyText("80");
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int value = jsonObject.getInt("value");
        assertSame(type, 2);
        assertSame(se, 0);
        assertSame(value, 80);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("条件限速");
        Thread.sleep(2000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_02901_noparking() throws Exception
    {
        //禁停  道路 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC,"描述信息");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.REMARK,"备注信息");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("通用禁停");
        String rowkey = Page_NoParking.Inst.GetRowKey();
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int virt = jsonObject.getInt("virt");
        String desc = jsonObject.getString("desc");
        assertSame(type,1);
        assertSame(se,0);
        assertSame(virt,0);
        assertEquals(desc,"描述信息");
    }

    @Test
    public void test998_02902_noparking() throws Exception
    {
        //禁停  测线 数据库赋值
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PROVINCIAL_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.IS_VIRTUAL);
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC," 描述");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.REMARK,"备注");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("通用禁停");
        String rowkey = Page_NoParking.Inst.GetRowKey();
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int virt = jsonObject.getInt("virt");
        String desc = jsonObject.getString("desc").trim();
        assertSame(type,2);
        assertSame(se,1);
        assertSame(virt,1);
        assertEquals(desc,"描述");
    }

    @Test
    public void test998_02903_noparking() throws Exception
    {
        //通用禁停  建立配对关系 1 禁停开始(推荐)默认勾选
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);
        Page_NoParking.Inst.Click(Page_ElecEye.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "通用禁停");
        Page_MyData.Inst.SelectData("通用禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("删除配对关系");
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(2000);

        Page_NoParking.Inst.Click(Page_NoParking.DELETE);

        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.Click(Page_NoParking.DELETE_CONFIRM);
        }
    }

    @Test
    public void test998_02904_noparking() throws Exception
    {
        //禁停  建立配对关系 文字提示 2km内
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(20000);
        Page_NoParking.Inst.ClickbyText("1 禁停结束(2km内)","禁停结束(2公里内)");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "通用禁停");
        Page_MyData.Inst.SelectData("通用禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");

        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.ClickbyText("确定");
        }

        //Thread.sleep(3000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02905_noparking() throws Exception
    {
        //禁停  建立配对关系 文字提示勾选框
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(20000);
        Page_NoParking.Inst.Click(Page_NoParking.CHECKBOX);
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "通用禁停");
        Page_MyData.Inst.SelectData("通用禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.ClickbyText("确定");
        }

        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02906_noparking() throws Exception
    {
        //禁停  建立配对关系多选项列表 我的数据
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1300,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1500,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);

        Page_NoParking.Inst.ClickbyText("3 禁停开始(2km内)", "禁停开始(2公里内)");
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_ElecEye.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"通用禁停");
        Page_MyData.Inst.SelectData("通用禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("删除配对关系");
        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.ClickbyText("确定");
        }

        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_02907_noparking() throws Exception
    {
        //禁停  室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("通用禁停");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("通用禁停");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_02908_noparking() throws Exception
    {
        //禁停  室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("通用禁停");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("通用禁停");
        Page_NoParking.Inst.Click(Page_NoParking.CANCEL);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("舍弃");
        }
        catch (Exception e)
        {

        }
        ExitIndoorTools();
    }

    @Test
    public void test998_02909_noparking() throws Exception
    {
        //禁停  室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("通用禁停");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("通用禁停");
        Page_NoParking.Inst.Click(Page_NoParking.DELETE);
        Thread.sleep(2000);
        assertFalse(Page_MyData.Inst.isExistByName("通用禁停"));
        ExitIndoorTools();
    }

    @Test
    public void test998_02910_noparking() throws Exception
    {
        //禁停  全路段
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        //Page_NoParking.Inst.ClickbyText("全路段");
        Page_NoParking.Inst.Click(Page_NoParking.ALL_SECTION);
        String strTemp = Page_NoParking.Inst.GetValue(Page_NoParking.DESC);
        assertEquals(strTemp,"全路段");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.ALL_SECTION);
        Thread.sleep(500);
        Page_NoParking.Inst.Click(Page_NoParking.ALL_SECTION);
        Thread.sleep(500);
        //Page_NoParking.Inst.Click(Page_NoParking.ALL_SECTION);
        strTemp = Page_NoParking.Inst.GetValue(Page_NoParking.DESC);
        assertEquals(strTemp,"全路段,全路段,全路段");
        Page_NoParking.Inst.SetValue(Page_NoParking.REMARK,"备注信息");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("通用禁停");
        String rowkey = Page_NoParking.Inst.GetRowKey();
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String desc = jsonObject.getString("desc");
        assertEquals(desc,"全路段,全路段,全路段");

        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("通用禁停");
        Thread.sleep(500);
        Page_NoParking.Inst.Click(Page_NoParking.ALL_SECTION);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
        Sqlitetools.RefreshData();
        temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject1 = new JSONObject(temp);
        desc = jsonObject1.getString("desc");
        assertEquals(desc,"全路段,全路段,全路段,全路段");
    }

    @Test
    public void test998_02911_noparking() throws Exception
    {
        //禁停  全路段历史记录
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC,"测全路段");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC,"历史记录");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC,"全路段测试");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC,"全路段测试");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.DESC);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("全路段测试");
        Thread.sleep(500);
        Page_NoParking.Inst.Click(Page_NoParking.DESC);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("测全路段");
        Thread.sleep(500);
        Page_NoParking.Inst.Click(Page_NoParking.DESC);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("历史记录");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        SearchLocation(EYE_LOC);
        Page_NoParking.Inst.ClickCenter();
        String rowkey = Page_NoParking.Inst.GetRowKey();
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String desc = jsonObject.getString("desc").trim();
        assertEquals(desc,"历史记录");
    }

    @Test
    public void test998_03001_noparkingtruck() throws Exception
    {
        //卡车禁停  道路 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC,"描述信息");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.REMARK,"备注信息");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("卡车禁停");
        String rowkey = Page_NoParking.Inst.GetRowKey();
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int virt = jsonObject.getInt("virt");
        String desc = jsonObject.getString("desc");
        assertSame(type,1);
        assertSame(se,0);
        assertSame(virt,0);
        assertEquals(desc,"描述信息");
    }

    @Test
    public void test998_03002_noparkingtruck() throws Exception
    {
        //卡车禁停   测线 数据库赋值
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.IS_VIRTUAL);
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.DESC," 描述");
        Thread.sleep(1000);
        Page_NoParking.Inst.SetValue(Page_NoParking.REMARK,"备注");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("卡车禁停");
        String rowkey = Page_NoParking.Inst.GetRowKey();
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int virt = jsonObject.getInt("virt");
        String desc = jsonObject.getString("desc").trim();
        assertSame(type,2);
        assertSame(se,1);
        assertSame(virt,1);
        assertEquals(desc,"描述");
    }

    @Test
    public void test998_03003_noparkingtruck() throws Exception
    {
        //卡车禁停  建立配对关系 1 禁停开始(推荐)默认勾选
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);
        Page_NoParking.Inst.Click(Page_ElecEye.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "卡车禁停");
        Page_MyData.Inst.SelectData("卡车禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("删除配对关系");
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.DELETE);
        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.Click(Page_NoParking.DELETE_CONFIRM);
        }

        ExitMyData();
    }

    @Test
    public void test998_03004_noparkingtruck() throws Exception
    {
        //卡车禁停  建立配对关系 文字提示 2km内
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(20000);
        Page_NoParking.Inst.ClickbyText("1 禁停结束(2km内)","卡车禁停结束(2公里内)");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "卡车禁停");
        Page_MyData.Inst.SelectData("卡车禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.ClickbyText("确定");
        }

        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_03005_noparkingtruck() throws Exception
    {
        //卡车禁停  建立配对关系 文字提示勾选框
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(20000);
        Page_NoParking.Inst.Click(Page_NoParking.CHECKBOX);
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE, "卡车禁停");
        Page_MyData.Inst.SelectData("卡车禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.ClickbyText("确定");
        }

        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_03006_noparkingtruck() throws Exception
    {
        //卡车禁停  建立配对关系多选项列表 我的数据
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停结束");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Drag(900,800,1100,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1300,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Drag(900,800,1500,800,5);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.ClickbyText("禁停开始");
        Thread.sleep(1000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoParking.Inst.ClickbyText("建立配对关系");
        Thread.sleep(15000);

        Page_NoParking.Inst.ClickbyText("3 禁停开始(2km内)", "卡车禁停开始(2公里内)");
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_ElecEye.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"卡车禁停");
        Page_MyData.Inst.SelectData("卡车禁停");
        Page_NoParking.Inst.Drag(1824,1290,1824,727,5);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("删除配对关系");
        if(!FastMapPage.IS_OS_TEST)
        {
            Page_NoParking.Inst.ClickbyText("确定");
        }
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_03007_noparkingtruck() throws Exception
    {
        //卡车禁停  室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("卡车禁停");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("卡车禁停");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_03008_noparkingtruck() throws Exception
    {
        //卡车禁停  室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("卡车禁停");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("卡车禁停");
        Page_NoParking.Inst.Click(Page_NoParking.CANCEL);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("舍弃");
        }
        catch (Exception e)
        {

        }
        ExitIndoorTools();
    }

    @Test
    public void test998_03009_noparkingtruck() throws Exception
    {
        //卡车禁停  室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        Thread.sleep(1000);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("卡车禁停");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("卡车禁停");
        Page_NoParking.Inst.Click(Page_NoParking.DELETE);
        assertFalse(Page_MyData.Inst.isExistByName("通用禁停"));
        ExitIndoorTools();
    }

    @Test
    public void test998_03010_noparkingtruck() throws Exception
    {
        //禁停  全路段
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.TIME);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.ALL_SECTION);
        //Page_NoParking.Inst.Click(Page_NoParking.ALL_SECTION);
        String strTemp = Page_NoParkingTruck.Inst.GetValue(Page_NoParkingTruck.DESC);
        assertEquals(strTemp,"全路段");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.ALL_SECTION);
        Thread.sleep(500);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.ALL_SECTION);
        Thread.sleep(500);
        //Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.ALL_SECTION);
        strTemp = Page_NoParkingTruck.Inst.GetValue(Page_NoParkingTruck.DESC);
        assertEquals(strTemp,"全路段,全路段,全路段");
        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.REMARK,"备注信息");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        String rowkey = Page_NoParkingTruck.Inst.GetRowKey();
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String desc = jsonObject.getString("desc");
        assertEquals(desc,"全路段,全路段,全路段");

        GotoMyData(Page_MyData.TIPS_TYPE);
        Thread.sleep(1000);
        Page_MyData.Inst.SelectData("卡车禁停");
        Thread.sleep(500);
        Page_NoParking.Inst.ClickbyText("全路段");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);
        ExitMyData();
        Sqlitetools.RefreshData();
        temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject1 = new JSONObject(temp);
        desc = jsonObject1.getString("desc");
        assertEquals(desc,"全路段,全路段,全路段,全路段");
    }

    @Test
    public void test998_03011_noparkingtruck() throws Exception
    {
        //禁停  全路段历史记录
        String[] EYE_LOC = {"116.40653", "39.91529"};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.TIME);
        Thread.sleep(1000);
        Page_NoParking.Inst.ClickbyText("确定");
        Thread.sleep( 1000);
        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.DESC,"测全路段");
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.TIME);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.DESC,"历史记录");
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.TIME);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.DESC,"测全路段");
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.TIME);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.DESC,"全路段测试");
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.TIME);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("确定");
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.DESC);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("全路段测试");
        Thread.sleep(500);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.DESC);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("测全路段");
        Thread.sleep(500);
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.DESC);
        Thread.sleep(1000);
        Page_NoParkingTruck.Inst.ClickbyText("历史记录");
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        String rowkey = Page_NoParkingTruck.Inst.GetRowKey();
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);
        Sqlitetools.RefreshData();
        String temp = new String((byte [])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        String desc = jsonObject.getString("desc").trim();
        assertEquals(desc,"历史记录");
    }

    @Test
    public void test998_04001_PoiAddressHistory() throws Exception
    {
        //新增多个poi 查看邮编历史记录
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "001837");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "星级酒店");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "100983");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ３");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "日杂店");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "786700");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ４");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.Click(Page_POI.POST_CODE);
        //Page_POI.Inst.Click(Page_POI.POST_CODE);
        Page_POI.Inst.ClickbyText("786700","786700");
        Thread.sleep(2000);
        Page_POI.Inst.Drag(1764,790,1764,375,5);
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ４");
        //Page_POI.Inst.ScrollClick(Page_POI.POST_CODE);
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.isExistByName("786700");
        Page_POI.Inst.Click(Page_POI.SAVE);

        ExitMyData();
    }

    @Test
    public void test998_04002_PoiAddressHistory() throws Exception
    {
        //邮编icon赋值 查看邮编历史记录
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "001837");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "星级酒店");
        Page_POI.Inst.Drag(1790,1095,1790,900,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "100983");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ３");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "日杂店");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "786700");
        Page_POI.Inst.Click(Page_POI.IMA_POST_CODE);//点击邮编icon赋值
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ１");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.isExistByName("100983");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_04003_PoiAddressHistory() throws Exception
    {
        //poi点击邮编icon 我的数据选择历史邮编
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        //Page_POI.Inst.Click(Page_POI.POST_CODE);//复制默认邮编
        Page_POI.Inst.SetValue(Page_POI.POST_CODE,"790621");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ３");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "日杂店");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "686700");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ３");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "日杂店");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE, "586700");
        Page_POI.Inst.Click(Page_POI.IMA_POST_CODE);//点击邮编icon赋值
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("测试ＰＯＩ１");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.isExistByName("686700");
        Page_POI.Inst.Click(Page_POI.POST_CODE);
        Page_POI.Inst.ClickbyText("790621","790621");
        Page_POI.Inst.isExistByName("790621");
//            Page_POI.Inst.Drag(1764,790,1764,375,5);
//            Page_POI.Inst.Click(Page_POI.SAVE);
//            ExitMyData();
    }

    @Test
    public void test998_04004_PoiAddressHistory() throws Exception
    {
        //poi点击邮编icon 我的数据编辑复制邮编
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE,"353332");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ１");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.isExistByName("353332");
        Page_POI.Inst.SetValue(Page_POI.POST_CODE,"034489");
        Page_POI.Inst.isExistByName("034489");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_04005_PoiAddressHistory() throws Exception
    {
        //poi点击邮编icon 我的数据点击邮编
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.SetValue(Page_POI.POST_CODE,"353332");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.SelectData("测试ＰＯＩ１");
        Page_POI.Inst.Drag(1790,1095,1790,800,5);
        Page_POI.Inst.isExistByName("353332");
        Page_POI.Inst.SetValue(Page_POI.POST_CODE,"134489");//013445
        Page_POI.Inst.Click(Page_POI.IMA_POST_CODE);
        Page_POI.Inst.isExistByName("353332");
        Page_POI.Inst.Click(Page_POI.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_05001_FunctionalArea() throws Exception
    {
        //新增功能面 关闭精细化开关 我的数据查看功能面
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);

        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.AIRPORT);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME, "测试");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        ExitMyData();

        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);//进入场景
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);//关闭精细化开关
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.ClickCenter();
        assertFalse(Page_FunctionalArea.Inst.isExist(Page_FunctionalArea.SAVE,1000));

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        ExitMyData();
    }

    @Test
    public void test998_05002_FunctionalArea() throws Exception
    {
        //新增建筑面 关闭精细化开关 我的数据查看建筑面
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUILDING_AREA);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_BuildingArea.Inst.Click(Page_BuildingArea.COMPLETE);

        Page_BuildingArea.Inst.Click(Page_BuildingArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("建筑物");
        ExitMyData();

        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);//进入场景
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);//关闭精细化开关
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);

        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.ClickCenter();
        assertFalse(Page_BuildingArea.Inst.isExist(Page_BuildingArea.SAVE,1000));

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("建筑物");
        ExitMyData();
    }

    @Test
    public void test998_05003_FunctionalArea() throws Exception
    {
        //新增酒店
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));

        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.HOTEL);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        Page_MyData.Inst.ClickbyText("功能面");
        Thread.sleep(2000);
        String rowkey = Page_FunctionalArea.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int tp = jsonObject.getInt("tp");
        assertSame(tp,51);
    }

    @Test
    public void test998_05004_FunctionalArea() throws Exception
    {
        //新增酒店
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.HOTEL);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        Page_MyData.Inst.ClickbyText("功能面");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.ClickbyText("修改形状");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.MODIFY_SAVE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_05005_FunctionalArea() throws Exception
    {
        //新增物流园
        SearchLocation(LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(500,500));
        Page_MainBoard.Inst.Click(new Point(800,500));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.PARK);
        Page_FunctionalArea.Inst.Drag(1634,1164,1634,600,5);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME,"测试");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.isExistByName("功能面");
        Page_MyData.Inst.ClickbyText("功能面");
        Thread.sleep(2000);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_05101_trucklimitlane() throws Exception
    {
        //卡车限速 默认1 开始限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.NUM40);

        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车限速");
        Thread.sleep(2000);
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int sign = jsonObject.getInt("se");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(type,1);
        assertSame(sign,0);
    }

    @Test
    public void test998_05102_trucklimitlane() throws Exception
    {
        //卡车限速 手绘测线
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        for(Point p : LinePoints)
        {
            Page_MainBoard.Inst.Click(p);
        }
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.NUM40);

        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车限速");
        Thread.sleep(2000);
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int sign = jsonObject.getInt("se");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(type,2);
        assertSame(sign,0);
    }

    @Test
    public void test998_05103_trucklimitlane() throws Exception
    {
        //卡车限速 默认1 开始限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.NUM40);
        Page_TruckLimitLane.Inst.ClickbyText("解除限速");
        Page_TruckLimitLane.Inst.SetValue(Page_TruckLimitLane.EDIT,"测试卡车限速");
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车限速");
        Thread.sleep(2000);
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int se = jsonObject.getInt("se");
        String desc = jsonObject.getString("desc");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(type,1);
        assertSame(se,1);
        assertEquals(desc,"测试卡车限速");
    }

    @Test
    public void test998_05104_trucklimitlane() throws Exception
    {
        //我的数据
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.NUM40);
        Page_TruckLimitLane.Inst.ClickbyText("解除限速");
        Page_TruckLimitLane.Inst.SetValue(Page_TruckLimitLane.EDIT,"测试卡车限速");
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车限速");
        Thread.sleep(2000);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_05105_trucklimitlane() throws Exception
    {
        //我的数据
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.NUM40);
        Page_TruckLimitLane.Inst.ClickbyText("解除限速");
        Page_TruckLimitLane.Inst.SetValue(Page_TruckLimitLane.EDIT,"测试卡车限速");
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车限速");
        Thread.sleep(2000);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_05106_trucklimitlane() throws Exception
    {
        //室内整理
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.NUM40);
        Page_TruckLimitLane.Inst.ClickbyText("解除限速");
        Page_TruckLimitLane.Inst.SetValue(Page_TruckLimitLane.EDIT,"测试卡车限速");
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"卡车限速");
        Page_IndoorMyData.Inst.ClickbyText("卡车限速");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("卡车限速");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("卡车限速");
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_05201_laneChangePoint() throws Exception
    {
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //6,6
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM6);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM6);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("0",temp2);
        //1,5
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM5);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("0",temp2);
        //2,5
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("0",temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.LEFTCHANGE);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("2",temp1);
        assertEquals("1",temp2);
        //4,2
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM4);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("2",temp1);
        assertEquals("1",temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.RIGHTHANGE);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("2",temp2);

        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.RIGHTHANGE);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("1",temp1);
        assertEquals("1",temp2);

        Page_LaneChangePoint.Inst.SetValue(Page_LaneChangePoint.REMARK,"测试");
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int inNum = jsonObject.getInt("inNum");
        int outNum = jsonObject.getInt("outNum");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(inNum,4);
        assertSame(outNum,2);
        assertSame(type,1);
    }

    @Test
    public void test998_05202_laneChangePoint() throws Exception
    {
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        for(Point p : LinePoints)
        {
            Page_MainBoard.Inst.Click(p);
        }
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(2000);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM6);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM7);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("1",temp2);

        Page_LaneChangePoint.Inst.SetValue(Page_LaneChangePoint.REMARK,"测试2");
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int inNum = jsonObject.getInt("inNum");
        int outNum = jsonObject.getInt("outNum");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(inNum,6);
        assertSame(outNum,7);
        assertSame(type,2);
    }

    @Test
    public void test998_05203_laneChangePoint() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM7);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM4);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("3",temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.CANCEL);

        if(Page_MainBoard.Inst.isExistByName("舍弃")){
            Page_MyData.Inst.ClickbyText("舍弃");
        }
        ExitMyData();

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int inNum = jsonObject.getInt("inNum");
        int outNum = jsonObject.getInt("outNum");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(inNum,7);
        assertSame(outNum,4);
        assertSame(type,1);
    }

    @Test
    public void test998_05204_laneChangePoint() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM6);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM7);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int inNum = jsonObject.getInt("inNum");
        int outNum = jsonObject.getInt("outNum");
        JSONObject f = jsonObject.getJSONObject("f");
        int type = f.getInt("type");
        assertSame(inNum,6);
        assertSame(outNum,7);
        assertSame(type,1);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_05205_laneChangePoint() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM6);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM7);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"车道变化点");
        Page_IndoorMyData.Inst.ClickbyText("车道变化点");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("车道变化点");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("车道变化点");
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_05206_laneChangePoint() throws Exception
    {
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //2,2 4,2
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("0",temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM4);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.LEFTCHANGE);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int[] array = new int[4];
        int i = 0;
        for(;i<4;i++)
        {
            array[i] =  jsonObject.getJSONArray("form").getInt(i);
        }
        assertSame(array[0],1);
        assertSame(array[1],1);
        assertSame(array[2],0);
        assertSame(array[3],0);
    }

    @Test
    public void test998_05207_laneChangePoint() throws Exception
    {
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //1,3
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM3);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0",temp1);
        assertEquals("2",temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int[] array = new int[3];
        int i = 0;
        for(;i<3;i++)
        {
            array[i] =  jsonObject.getJSONArray("form").getInt(i);
        }
        assertSame(array[0],0);
        assertSame(array[1],1);
        assertSame(array[2],1);

    }

    @Test
    public void test998_05208_laneChangePoint() throws Exception {
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //3,1
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM3);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0", temp1);
        assertEquals("2", temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int[] array = new int[3];
        int i = 0;
        for (; i < 3; i++) {
            array[i] = jsonObject.getJSONArray("form").getInt(i);
        }
        assertSame(array[0], 0);
        assertSame(array[1], 1);
        assertSame(array[2], 1);
    }

    @Test
    public void test998_05209_laneChangePoint() throws Exception {
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //3,1
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM3);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0", temp1);
        assertEquals("2", temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.LEFTCHANGE);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("1", temp1);
        assertEquals("1", temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int[] array = new int[3];
        int i = 0;
        for (; i < 3; i++) {
            array[i] = jsonObject.getJSONArray("form").getInt(i);
        }
        assertSame(array[0], 1);
        assertSame(array[1], 0);
        assertSame(array[2], 1);
    }

    @Test
    public void test998_05210_laneChangePoint() throws Exception {
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_CHANGE_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //2,5
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.ENTRYNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.BACKNUM);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM5);
        String temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        String temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("0", temp1);
        assertEquals("3", temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.RIGHTHANGE);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.NUM1);
        temp1 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.LEFTCHANGE);
        temp2 = Page_LaneChangePoint.Inst.GetValue(Page_LaneChangePoint.RIGHTHANGE);
        assertEquals("2", temp1);
        assertEquals("1", temp2);
        Page_LaneChangePoint.Inst.Click(Page_LaneChangePoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道变化点");
        String rowkey = Page_LaneChangePoint.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int[] array = new int[5];
        int i = 0;
        for (; i < 5; i++) {
            array[i] = jsonObject.getJSONArray("form").getInt(i);
        }
        assertSame(array[0], 1);
        assertSame(array[1], 1);
        assertSame(array[2], 0);
        assertSame(array[3], 0);
        assertSame(array[4], 1);
    }

    @Test
    public void test998_05301_vehiclelane() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.VEHICLE_LANE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //Page_MainBoard.Inst.Drag(82,437,252,437,10);
        Page_MainBoard.Inst.Drag(137,382,252,382,10);

        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM6);
        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 2);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM7);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 7);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM7);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限高限宽");
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_05302_vehiclelane() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.VEHICLE_LANE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //Page_MainBoard.Inst.Drag(82,437,252,437,10);
        Page_MainBoard.Inst.Drag(137,382,252,382,10);

        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 2);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM7);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限高限宽");
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_05303_vehiclelane() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.VEHICLE_LANE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //Page_MainBoard.Inst.Drag(82,437,252,437,10);
        Page_MainBoard.Inst.Drag(137,382,252,382,10);

        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 2);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM7);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限高限宽");
        Page_VehicleLane.Inst.Click(Page_VehicleLane.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_05304_vehiclelane() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.VEHICLE_LANE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //Page_MainBoard.Inst.Drag(82,437,252,437,10);
        Page_MainBoard.Inst.Drag(137,382,252,382,10);
        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 2);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM7);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车道限高限宽");
        Page_VehicleLane.Inst.Click(Page_VehicleLane.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_05305_vehiclelane() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.VEHICLE_LANE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        //Page_MainBoard.Inst.Drag(82,437,252,437,10);
        Page_MainBoard.Inst.Drag(137,382,252,382,10);
        Page_VehicleLane.Inst.ClickByIndex(Page_VehicleLane.LIMIT_EDIT, 2);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.NUM7);
        Thread.sleep(1000);
        Page_VehicleLane.Inst.Click(Page_VehicleLane.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"车道限高限宽");
        Page_IndoorMyData.Inst.ClickbyText("车道限高限宽");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("车道限高限宽");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("车道限高限宽");
        Page_TruckLimitLane.Inst.Click(Page_TruckLimitLane.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_05401_conditionlimit() throws Exception
    {
        //卡车条件限速
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKCONDITION);
        Page_TruckCondition.Inst.ClickbyText("开始限速");
        Page_TruckCondition.Inst.ClickbyText("40");
        Page_TruckCondition.Inst.ClickbyText("总轴数");
        Page_TruckCondition.Inst.Drag(1824,1290,1824,527,5);
        Thread.sleep(1000);
        Page_TruckCondition.Inst.SetValue(Page_TruckCondition.REMARK,"测试");
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);

        SearchLocation(EYE_LOC);
        Page_MainBoard.Inst.ClickCenter();
        Page_TruckCondition.Inst.ClickbyText("解除限速");
        Page_TruckCondition.Inst.ClickbyText("雪");
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"卡车条件限速");
        ExitMyData();
    }

    @Test
    public void test998_05402_conditionlimit() throws Exception
    {
        //卡车条件限速 我的数据
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKCONDITION);
        Page_TruckCondition.Inst.ClickbyText("开始限速");
        Page_TruckCondition.Inst.ClickbyText("40");
        Page_TruckCondition.Inst.ClickbyText("雨");
        Thread.sleep(1000);
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"卡车条件限速");
        Page_MyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(2000);
        Page_TruckCondition.Inst.ClickbyText("调整箭头方向");
        Page_TruckCondition.Inst.ClickbyText("解除限速");
        Page_TruckCondition.Inst.ClickbyText("雪");
        Thread.sleep(1000);
        Page_TruckCondition.Inst.Drag(1824,1290,1824,1027,5);
        Thread.sleep(1000);
        Page_TruckCondition.Inst.ClickbyText("50");
        Page_TruckCondition.Inst.Drag(1824,1290,1824,527,5);
        Thread.sleep(1000);
        Page_TruckCondition.Inst.SetValue(Page_TruckCondition.REMARK,"测试");
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        ExitMyData();
    }

    @Test
    public void test998_05403_conditionlimit() throws Exception
    {
        //卡车条件限速 室内整理工具
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKCONDITION);
        Page_TruckCondition.Inst.ClickbyText("开始限速");
        Page_TruckCondition.Inst.ClickbyText("40");
        Page_TruckCondition.Inst.ClickbyText("雨");
        Thread.sleep(1000);
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"卡车条件");
        Page_IndoorMyData.Inst.ClickbyText("卡车条件限速");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Page_IndoorMyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(2000);
        Page_IndoorMyData.Inst.ClickbyText("移动点位");
        Page_TruckCondition.Inst.ClickbyText("调整箭头方向");
        Page_TruckCondition.Inst.ClickbyText("解除限速");
        Page_TruckCondition.Inst.ClickbyText("雪");
        Thread.sleep(1000);
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        ExitIndoorTools();
    }

    @Test
    public void test998_05404_conditionlimit() throws Exception
    {
        //卡车条件限速
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        for(Point p : LinePoints)
        {
            Page_MainBoard.Inst.Click(p);
        }
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.Click(LinePoints[0]);

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKCONDITION);
        Page_TruckCondition.Inst.ClickbyText("时间限制");
        Page_TruckCondition.Inst.ClickbyText("总重量");
        Page_TruckCondition.Inst.ClickbyText("110");
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Page_TruckCondition.Inst.Drag(1824,1290,1824,1127,5);
        Thread.sleep(1000);
        Page_TruckCondition.Inst.isChecked(Page_TruckCondition.TOTALWEIGHT);
        Page_TruckCondition.Inst.isChecked(Page_TruckCondition.TIMELIMIT);
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int value = jsonObject.getInt("value");
        assertSame(type, 2);
        assertSame(se, 0);
        assertSame(value, 110);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(2000);
        Page_ConditionSpeedLimit.Inst.Click(Page_ConditionSpeedLimit.DELETE);
        ExitMyData();
    }

    @Test
    public void test998_05405_conditionlimit() throws Exception
    {
        //卡车条件限速
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKCONDITION);
        Page_TruckCondition.Inst.ClickbyText("开始限速");
        Page_TruckCondition.Inst.ClickbyText("60");
        Page_TruckCondition.Inst.ClickbyText("雪");
        Page_TruckCondition.Inst.Drag(1795,1200,1795,700,5);
        Page_TruckCondition.Inst.SetValue(Page_ConditionSpeedLimit.REMARK,"测试卡车条件限速");
        Page_TruckCondition.Inst.Click(Page_ConditionSpeedLimit.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Page_TruckCondition.Inst.ClickbyText("雾");
        Page_TruckCondition.Inst.isChecked(Page_TruckCondition.FOG);
        Page_TruckCondition.Inst.Drag(1795,1200,1795,700,5);
        Page_TruckCondition.Inst.ClickbyText("80");
        Page_TruckCondition.Inst.Click(Page_TruckCondition.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getJSONObject("f").getInt("type");
        int se = jsonObject.getInt("se");
        int value = jsonObject.getInt("value");
        assertSame(type, 1);
        assertSame(se, 0);
        assertSame(value, 80);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车条件限速");
        Thread.sleep(2000);
        Page_TruckCondition.Inst.Click(Page_TruckCondition.CANCEL);
        ExitMyData();
    }

    @Test
    public void test998_05501_startendpoint() throws Exception
    {
        //起终点
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(1000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);

        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CAR_TEST_BT);
        Page_MainBoard.Inst.Click(new Point(374,808));
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车辆测试路段");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Thread.sleep(2000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Drag(1787,1285,1787,870,5);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        jsonObject = (JSONObject) jsonObject.getJSONArray("f_array").get(0);
        int type = jsonObject.getInt("type");
        assertSame(type, 1);
    }

    @Test
    public void test998_05502_startendpoint() throws Exception
    {
        //起终点
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        for(Point p : LinePoints)
        {
            Page_MainBoard.Inst.Click(p);
        }
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);

        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CAR_TEST_BT);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("车辆测试路段");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Thread.sleep(2000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Drag(1787,1285,1787,870,5);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        jsonObject = (JSONObject) jsonObject.getJSONArray("f_array").get(0);
        int type = jsonObject.getInt("type");
        assertSame(type, 2);
    }

    @Test
    public void test998_05503_startendpoint() throws Exception
    {
        //起终点
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(1000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);

        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.DRIVING_TEST_BT);
        Page_StartEndPoint.Inst.SetValue(Page_StartEndPoint.REMARK,"测试测试车道");
        Page_MainBoard.Inst.Click(new Point(374,808));
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("驾照考试路段");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Thread.sleep(2000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Drag(1787,1285,1787,870,5);
        String temp = Page_StartEndPoint.Inst.GetValue(Page_StartEndPoint.REMARK);
        assertEquals("测试测试车道",temp);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        jsonObject = (JSONObject) jsonObject.getJSONArray("f_array").get(0);
        int type = jsonObject.getInt("type");
        assertSame(type, 1);
    }

    @Test
    public void test998_05504_startendpoint() throws Exception
    {
        //起终点
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Thread.sleep(1000);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);

        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.DRIVING_TEST_BT);
        Page_StartEndPoint.Inst.SetValue(Page_StartEndPoint.REMARK,"测试测试车道");
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("驾照考试路段");
        Thread.sleep(2000);
        String rowkey = Page_Dangerous.Inst.GetRowKey();
        Thread.sleep(2000);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CHANGE_START_END);
        Thread.sleep(1000);
        Page_StartEndPoint.Inst.Drag(1787,1285,1787,870,5);
        String temp = Page_StartEndPoint.Inst.GetValue(Page_StartEndPoint.REMARK);
        assertEquals("测试测试车道",temp);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        jsonObject = (JSONObject) jsonObject.getJSONArray("f_array").get(0);
        int type = jsonObject.getInt("type");
        assertSame(type, 2);
    }

//    @Test
//    public void test998_05601_searchlink() throws Exception
//    {
//        //搜索,前提已经下载了北京 天津 河北省地图数据
//        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
//        Page_Search.Inst.ClickbyText("Link");
//        //此时默认下载省市的全范围搜索，列表默认值北京市
//        Page_Search.Inst.SetValue(Page_Search.EDITLINK,"590483");//天津6899091//北京590484
//        Page_Search.Inst.ClickbyText("精确匹配");
//        Page_Search.Inst.Click(Page_Search.SEARCH_START_LINK);
//        for (int i=0;i<5;i++)
//        {
//            if (Page_SearchResultList.Inst.isExist(Page_SearchResultList.BACK,6000))
//            {
//                break;
//            }
//            i++;
//        }
//        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
//
//    }
//
//    @Test
//    public void test998_05602_searchlink() throws Exception
//    {
//        //搜索,前提已经下载了北京 天津 河北省地图数据
//        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
//        Page_Search.Inst.ClickbyText("Link");
//        //此时默认下载省市的全范围搜索，列表默认值北京市
//        Page_Search.Inst.SetValue(Page_Search.EDITLINK,"6744114");//天津6744114//北京590484
//        Page_Search.Inst.ClickbyText("模糊匹配");
//        Page_Search.Inst.Click(Page_Search.SEARCH_RANGE);
//        Page_Search.Inst.ClickbyText("天津市");
//        Page_Search.Inst.ClickbyText("确定");
//        Page_Search.Inst.Click(Page_Search.SEARCH_START_LINK);
//        for (int i=0;i<5;i++)
//        {
//            if (Page_SearchResultList.Inst.isExist(Page_SearchResultList.BACK,6000))
//            {
//                break;
//            }
//            i++;
//        }
//        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
//        //搜索天津市此link，历史记录为天津市
//        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
//        Page_Search.Inst.ClickbyText("Link");
//        Page_Search.Inst.isChecked(Page_Search.BLURRY_FIND_LINK);
//        String temp = Page_Search.Inst.GetValue(Page_Search.SEARCH_RANGE);
//        assertEquals(temp,"天津市");
//
//    }
//
//    @Test
//    public void test998_05603_searchlink() throws Exception
//    {
//        //搜索,前提已经下载了北京 天津 河北省地图数据
//        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
//        Page_Search.Inst.ClickbyText("Link");
//        //此时默认下载省市的全范围搜索，列表默认值天津市
//        Page_Search.Inst.SetValue(Page_Search.EDITLINK,"590484");//天津6744114//北京590484
//        Page_Search.Inst.ClickbyText("精确匹配");
//        Page_Search.Inst.Click(Page_Search.SEARCH_RANGE);
//        Page_Search.Inst.ClickbyText("北京市");
//        Page_Search.Inst.ClickbyText("确定");
//        Page_Search.Inst.Click(Page_Search.SEARCH_START_LINK);
//        for (int i=0;i<5;i++)
//        {
//            if (Page_SearchResultList.Inst.isExist(Page_SearchResultList.BACK,6000))
//            {
//                break;
//            }
//            i++;
//        }
//        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
//        //删除北京市，点击搜索历史记录为天津市
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.OFFLINE_MAP);
//        Page_OfflineMap.Inst.Click(Page_OfflineMap.MANAGER);
//        Page_OfflineMap.Inst.Click(Page_OfflineMap.GDB_SIZE);
//        Page_OfflineMap.Inst.CtrlFling(new Point(361,426),Page_OfflineMap.GDB_SIZE);
//        String temp = "删\n" + "除";
//        Page_OfflineMap.Inst.ClickbyText(temp);
//        Page_OfflineMap.Inst.ClickbyText("确认");
//        Page_OfflineMap.Inst.Click(Page_OfflineMap.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
//        Page_Search.Inst.ClickbyText("Link");
//        Page_Search.Inst.isChecked(Page_Search.EXACT_FIND_LINK);
//        temp = Page_Search.Inst.GetValue(Page_Search.SEARCH_RANGE);
//        assertEquals(temp,"天津市");
//    }

    @Test
    public void test998_05601_truescene() throws Exception
    {
        //实景图默认高速出口2 请求编号可选 切换成1按键不可用
        SearchLocation(LOC_K8);//北京的经纬度信息
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.isChecked(Page_TrueSence.HIGHWAY_LOAD_OUT);
        Thread.sleep(2000);
        assertTrue(Page_TrueSence.Inst.GetIsEnableByName("请求编号"));
        Page_TrueSence.Inst.Click(Page_TrueSence.COMMON_LOAD);
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("请求编号"));
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(3000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("请求编号"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("高速入口"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("高速出口"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("普通路口"));
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickbyText("保存");
        //我的数据中查看是否置灰，是否可点击
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("实景图");
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("请求编号"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("高速入口"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("高速出口"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("普通路口"));
    }

    @Test
    public void test998_05602_truescene() throws Exception
    {
        //实景图默认 点击请求编号返回八位编码
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(3000);
        String strtemp = Page_TrueSence.Inst.GetValue(Page_TrueSence.ET_IMG_NUMBER);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        int length = strtemp.length();
        assertSame(8,length);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("实景图");

        strtemp = Page_TrueSence.Inst.GetValue(Page_TrueSence.ET_IMG_NUMBER);
        length = strtemp.length();
        assertSame(8,length);
    }

    @Test
    public void test998_05603_truescene() throws Exception
    {
        //实景图原库数据不可以更改类别 请求编号正常
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(3000);
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        for (int i=0;i<6;i++)
        {
            Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
            Thread.sleep(2000);
        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_TrueSence.Inst.Click(Page_TrueSence.SCREENSHOT);
        Thread.sleep(5000);
        Page_MainBoard.Inst.ClickCenter();//新增检查项，必须标记退出线
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("实景图");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
        ExitIndoorTools();

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("实景图");
        Thread.sleep(2000);
        boolean result = Page_TrueSence.Inst.isChecked(Page_TrueSence.HIGHWAY_LOAD_IN);
        assertTrue(result);
        Thread.sleep(2000);
        result = Page_TrueSence.Inst.GetIsEnableByName("粘贴编号");
        assertFalse(result);
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("请求编号"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("高速入口"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("高速出口"));
        Thread.sleep(2000);
        assertFalse(Page_TrueSence.Inst.GetIsEnableByName("普通路口"));
        Thread.sleep(2000);
    }

    @Test
    public void test998_05604_truescene() throws Exception
    {
        //保证原始普通路口流程正常 请求编号置灰
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.Click(Page_TrueSence.COMMON_LOAD);
        Thread.sleep(2000);
        Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER,"023456789");
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        for (int i=0;i<6;i++)
        {
            Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
            Thread.sleep(2000);
        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("实景图");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
        ExitIndoorTools();

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("实景图");
        boolean temp = Page_TrueSence.Inst.GetIsEnable(Page_TrueSence.HIGHWAY_LOAD_OUT);
        assertFalse(temp);
    }

    @Test
    public void test998_05701_roadlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 历史记录
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM90);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM70);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 5);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,460,252,460,10);
        //Page_MainBoard.Inst.Click(new Point(65,481));//点限速必选一个
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 1);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM40);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.ClickByIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);
        Page_SpeedLimitLane.Inst.Drag(1789,1066,1789,566,5);

        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.HEIGHT);
        String strHeight = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        String strHeight1 = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 6);
        String strLow = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        //boolean bTemp = Page_SpeedLimitLane.Inst.isCheckedbyIndex(Page_SpeedLimitLane.LIMIT_EDIT,1);

        assertEquals("40",strHeight);
        assertEquals("40",strHeight1);
        assertEquals("30",strLow);
        //assertTrue(bTemp);

        Page_SpeedLimitLane.Inst.ClickbyText("高:90/0/0");
        strHeight = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        strLow = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        //boolean bTemp = Page_SpeedLimitLane.Inst.isCheckedbyIndex(Page_SpeedLimitLane.LIMIT_EDIT,1);

        assertEquals("90",strHeight);
        assertEquals("70",strLow);
        //assertTrue(bTemp);

        Page_SpeedLimitLane.Inst.ClickbyText("高:70/0/0");
        strHeight = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 2);
        strLow = Page_SpeedLimitLane.Inst.GetValuebyIndex(Page_SpeedLimitLane.LIMIT_EDIT, 3);
        //boolean bTemp = Page_SpeedLimitLane.Inst.isCheckedbyIndex(Page_SpeedLimitLane.LIMIT_EDIT,1);

        assertEquals("70",strHeight);
        assertEquals("30",strLow);
        //assertTrue(bTemp);
    }

//    @Test
//    public void test998_05801_truescene() throws Exception
//    {
//        //高速分歧
//        SearchLocation(LOC_K8);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);
//        Page_MainBoard.Inst.ClickCenter();
//        String strClass = "android.widget.RadioButton";
//        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,6);
//        Page_TrueSence.Inst.ClickbyText("其他模式图");
//        Thread.sleep(2000);
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.EXTRLANE_L,"3");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.EXTRALANE_R,"0");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.CROSSLANE_L,"2");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.CROSSLANE_M,"1");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.CROSSLANE_R,"2");
//        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.GERNERATECODE);
//        String strResult = Page_HighSpeedDivider.Inst.GetValue(Page_HighSpeedDivider.IMAG_NUM);
//        assertEquals("8036NaNcb2",strResult);
//        Page_HighSpeedDivider.Inst.ClickbyText("无编号");
//        strResult = Page_HighSpeedDivider.Inst.GetValue(Page_HighSpeedDivider.IMAG_NUM);
//        assertEquals("无",strResult);
//        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.SAVE);
//
//    }

    @Test
    public void test998_05801_highspeeddivider() throws Exception {
        //高速分歧
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);
        Page_MainBoard.Inst.ClickCenter();
        String strClass = "android.widget.RadioButton";
        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass, 6);
        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.SAVE);
    }

    @Test
    public void test998_05802_realsign() throws Exception {
        //Real Sign
        //SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REAL_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_RealSign.Inst.Click(Page_RealSign.SAVE);
    }

    @Test
    public void test998_05803_directionboard() throws Exception {
        //Real Sign
        //SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.ClickCenter();
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);
    }

//    @Test
//    public void test998_05805_truescene() throws Exception
//    {
//        //高速分歧 其他模式图为html页
//        SearchLocation(LOC_K8);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);
//        Page_MainBoard.Inst.ClickCenter();
//        String strClass = "android.widget.RadioButton";
//        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,6);
//        Page_TrueSence.Inst.ClickbyText("其他模式图");
//        Thread.sleep(2000);
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.EXTRLANE_L,"3");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.EXTRALANE_R,"0");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.CROSSLANE_L,"2");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.CROSSLANE_M,"1");
//        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.CROSSLANE_R,"2");
//        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.GERNERATECODE);
//        String strResult = Page_HighSpeedDivider.Inst.GetValue(Page_HighSpeedDivider.IMAG_NUM);
//        assertEquals("8036NaNcb2",strResult);
//        Page_HighSpeedDivider.Inst.ClickbyText("无编号");
//        strResult = Page_HighSpeedDivider.Inst.GetValue(Page_HighSpeedDivider.IMAG_NUM);
//        assertEquals("无",strResult);
//        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.SAVE);
//
//    }

    @Test
    public void test998_05806_truescene() throws Exception
    {
        //高速分歧
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);
        Page_MainBoard.Inst.ClickCenter();
        String strClass = "android.widget.RadioButton";
        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,6);
        //Page_TrueSence.Inst.ClickbyText("其他模式图");
        Thread.sleep(2000);
        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,3);
        String strResult = Page_HighSpeedDivider.Inst.GetValue(Page_HighSpeedDivider.IMAG_NUM);
        assertEquals("80222011",strResult);
        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,0);
        Page_TrueSence.Inst.ClickbyText("其他模式图");
        Thread.sleep(2000);
        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,2);
        Page_HighSpeedDivider.Inst.ClickbyText("无编号");
        strResult = Page_HighSpeedDivider.Inst.GetValue(Page_HighSpeedDivider.IMAG_NUM);
        assertEquals("无",strResult);
        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.SAVE);
    }

    @Test
    public void test998_05807_truescene() throws Exception
    {
        //高速分歧
        SearchLocation(LOC_K4);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);
        Page_MainBoard.Inst.ClickCenter();
        String strClass = "android.widget.RadioButton";
        Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass,6);

        Thread.sleep(2000);
        Page_MainBoard.Inst.Click(new Point(453,623));
        Page_MainBoard.Inst.Click(new Point(626,256));
        Page_MainBoard.Inst.Click(new Point(383,739));
        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.DELETE_CARD);
        //Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.DELETE_CARD);
        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.ROAD_NAME,"路名");
        Page_HighSpeedDivider.Inst.SetValue(Page_HighSpeedDivider.ROAD_NUM,"编号");
        Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.SAVE);
    }

//    @Test
//    public void test998_05808_mode() throws Exception {
//        //资三  必须有任务
//        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);//进入场景
//        assertTrue(Page_MainBoard.Inst.isExist(Page_MainBoard.MODE_ONE,500));
//        Page_MainBoard.Inst.ClickCenter();
//
//        GotoIndoorTools();
//        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.INDOOR_MODE);
//        assertTrue(Page_IndoorMyData.Inst.isExist(Page_IndoorMyData.INDOOR_MODE_ONE,500));
//        Page_MainBoard.Inst.ClickCenter();
//        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.BACK);
//        Page_IndoorTools.Inst.Click(Page_IndoorTools.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
//        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_SATELLITE);
//        Thread.sleep(3000);
//        Page_GridManager.Inst.ClickbyText("资三影像");
//        Thread.sleep(3000);
//        Page_GridManager.Inst.ClickByText("取消");
//    }

    //同一关系
    @Test
    public void test998_05901_poi_same_add() throws Exception
    {
        //同一关系 300内有一个POI 5米内
        SearchLocation(LOC_K1);
        String[] TEST_LOC_K1 = {"116.45507", "39.95851"};

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation(TEST_LOC_K1);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "风景名胜");
        Page_POI.Inst.Click(Page_POI.POI_SAME);
        Thread.sleep(1000);
        Page_POI.Inst.ClickCenter();
        String strResult = Page_POI.Inst.GetValue(Page_POI.POI_SAME);
        assertEquals(strResult,"测试ＰＯＩ１");
        Thread.sleep(1000);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

//    @Test
//    public void test998_05902_poi_same_add() throws Exception
//    {
//        //同一关系 300内有一个POI 5米外
//        SearchLocation(LOC_K1);
//        String[] TEST_LOC_K1 = {"116.45502", "39.95851"};
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        SearchLocation(TEST_LOC_K1);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "风景名胜");
//        Page_POI.Inst.Click(Page_POI.POI_SAME);
//        Thread.sleep(1000);
//        Page_POI.Inst.ClickCenter();//Toast提示 要求移至5米内
//        String strResult = Page_POI.Inst.GetValue(Page_POI.POI_SAME);
//        assertEquals(strResult,"测试ＰＯＩ１");
//        Thread.sleep(1000);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//    }
//
//    @Test
//    public void test998_05903_poi_same_add() throws Exception
//    {
//        //同一关系 300外有一个POI  1KM以内 Toast提示
//        SearchLocation(LOC_K1);
//        String[] TEST_LOC_K1 = {"116.45100", "39.95851"};
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        SearchLocation(TEST_LOC_K1);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "风景名胜");
//        Page_POI.Inst.Click(Page_POI.POI_SAME);
//        Thread.sleep(1000);
//        Page_POI.Inst.ClickCenter();//附近没有同一关系的POI点
//        String strResult = Page_POI.Inst.GetValue(Page_POI.POI_SAME);
//        assertEquals(strResult,"测试ＰＯＩ１");
//        Thread.sleep(1000);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//    }

//    @Test
//    public void test998_05904_poi_same_add() throws Exception
//    {
//        //月基线功能
//        //同一关系  1KM以内300米以外
//        SearchLocation(LOC_K1);
//        String[] TEST_LOC_K1 = {"116.45100", "39.95851"};
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230206");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        SearchLocation(TEST_LOC_K1);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230206");
//        Page_POI.Inst.Click(Page_POI.POI_SAME);
//        Thread.sleep(1000);
//        Page_POI.Inst.ClickCenter();
//        String strResult = Page_POI.Inst.GetValue(Page_POI.POI_SAME);
//        assertEquals(strResult,"测试ＰＯＩ１");
//        Thread.sleep(1000);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        String temp = new String((byte[])Sqlitetools.GetPoisDataByRowKey(infoFid,"samePoi"));
//        JSONObject jsonObject = new JSONObject(temp);
//
//        int  type = jsonObject.getInt("type");
//        assertSame(3,type);
//    }

//    @Test
//    public void test998_05905_poi_same_add() throws Exception
//    {
//        //同一关系  1KM以内300米以外 无 Toast提示
//        SearchLocation(LOC_K1);
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230206");
//        Page_POI.Inst.Click(Page_POI.POI_SAME);
//        Thread.sleep(1000);
//        Page_POI.Inst.ClickCenter();//Toast提示
//
//        Page_POI.Inst.Click(Page_POI.SAVE);
//    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test998_05906_poi_same_add() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40624", "39.95918","捕捉点位新增");

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"},
                {Page_POI.POI_SAME, "中餐馆ＴＥＳＴ"}};

        String infoFid = AddPOI(attrib2, "116.40628", "39.95918","忽略捕捉新增");

        Page_MainBoard.Inst.Drag(1800,1400,1800,250,100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        SearchLocation("116.40624", "39.95918");
        synchronize_zhou(Page_GridManager.POI_UPDATE);

        CheckErrorList("Poi", "同一poi(" + "fid:"+infoFid + ")在库中不存在", "POI");
    }

    //补充同一关系原则
    //风景名胜（180400）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test998_05907_poi_same_add() throws Exception
    {

        String[][] attrib1 = {{Page_POI.NAME, "风景名胜TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜"}};

        AddPOI(attrib1, "116.40624", "39.95918","捕捉点位新增");

        Page_MainBoard.Inst.Drag(1800,1400,1800,250,100);
        Page_POI.Inst.ClickByText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);

        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "风景名胜ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918","捕捉点位新增");
        }catch (Exception e) {

        }

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("风景名胜售票点ＴＥＳＴ");

        assertTrue(Page_TrueSence.Inst.isExistByName("同一关系"));
    }


    //补充同一关系原则
    //旅游观光（180403）可以和任意类型（除自身以及210304风景名胜售票点）做同一关系
    @Test
    public void test998_05908_poi_same_add() throws Exception
    {
        String[] LOC_K1 = {"116.40624", "39.95918"};
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"旅游观光TEST");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE,"风景名胜");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK5);
        Page_POI.Inst.Click(Page_POI.SAVE);


        String[][] attrib2 = {{Page_POI.NAME, "风景名胜售票点TEST"},
                {Page_POI.SELECT_TYPE, "风景名胜售票点"},
                {Page_POI.POI_SAME, "旅游观光ＴＥＳＴ"}};

        try {
            AddPOI(attrib2, "116.40628", "39.95918","捕捉点位新增");
        }catch (Exception e) {

        }

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("风景名胜售票点ＴＥＳＴ");

        assertTrue(Page_TrueSence.Inst.isExistByName("同一关系"));
    }

    @Test
    public void test998_06001_poi_relationship_father() throws Exception
    {
        //查看默认值
        String[][] attrib1 = {{Page_POI.NAME, "驾校"},
                {Page_POI.SELECT_TYPE, "驾校"}};
        AddPOI(attrib1, "116.40624", "39.95918","捕捉点位新增");

        String[][] attrib2 = {{Page_POI.NAME, "百货"},
                {Page_POI.SELECT_TYPE, "百货商场零售"}};
        AddPOI(attrib2, "116.40624", "39.95918","捕捉点位新增");

        String[][] attrib4 = {{Page_POI.NAME, "公司"},
                {Page_POI.SELECT_TYPE, "公司"}};
        AddPOI(attrib4, "116.40624", "39.95918","捕捉点位新增");

        String[][] attrib5 = {{Page_POI.NAME, ""},
                {Page_POI.SELECT_TYPE, "公司"}};
        AddPOI(attrib5, "116.40624", "39.95918","捕捉点位新增");

        String[][] attrib7 = {{Page_POI.NAME, "大厦/写字楼"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        AddPOI(attrib7, "116.40624", "39.95918","捕捉点位新增");
        SearchLocation("116.40624", "39.95918");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"中餐馆");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE,"中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("大厦／写字楼(多点)");
        Thread.sleep(1000);
        String str = Page_POI.Inst.GetValuebyIndex(Page_POI.TEXTVIEW,1);
        assertEquals("百货",str);
        str = Page_POI.Inst.GetValuebyIndex(Page_POI.TEXTVIEW,3);
        assertEquals("大厦／写字楼",str);
        str = Page_POI.Inst.GetValuebyIndex(Page_POI.TEXTVIEW,5);
        assertEquals("公司",str);
        str = Page_POI.Inst.GetValuebyIndex(Page_POI.TEXTVIEW,7);
        assertTrue("".equals(str) || "<无名称>".equals(str));
//        str = Page_POI.Inst.GetItemValue(Page_POI.LISTCLASS,1,Page_POI.FAILNAME);
//        assertEquals("公司",str);

    }
    @Test
    public void test998_06101_poi_Tag() throws Exception
    {
        //编辑时切换tag页 新增未采集
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK7);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(7,fineFeedback);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("小区");
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.TAG1);
        assertFalse(Page_POI.Inst.isChecked(Page_POI.FEEDBACK7));
        Thread.sleep(2000);
        Page_POI.Inst.Click(Page_POI.TAG0);
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(7,fineFeedback);
    }

    @Test
    public void test998_06102_poi_Tag() throws Exception
    {
        //复制poi
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        Thread.sleep(1000);
        Page_POI.Inst.Click(Page_POI.TAG0);
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("复制信息新增");
            Page_MainBoard.Inst.ClickbyText("确定");
        }
        catch (Exception e)
        {

        }

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
        String Fid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK8);
        Fid = Fid.replace("fid:", "");
        Fid = Fid.replace("fid : ", "");

        Page_POI.Inst.Click(Page_POI.SAVE);


        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFlag");
        assertSame(1,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(Fid,"fineFeedback");
        assertSame(8,fineFeedback);
    }

    @Test
    public void test998_06103_poi_Tag() throws Exception
    {
        //查看默认值
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"高等");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "160105");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("未作业");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.TAG0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test998_06104_poi_Tag() throws Exception
    {
        //查看默认值
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("未作业");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.TAG0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

//    @Test
//    public void test998_00256_poi_relationship_Tag() throws Exception
//    {
//        SearchLocation(LOC_K1);
//        //轻轨/地铁出入口
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.SetValue(Page_POI.NAME,"地铁");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230111");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"加油站");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230215");
//        String infoFid1 = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid1 = infoFid1.replace("fid:", "");
//        infoFid1 = infoFid1.replace("fid : ", "");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        //Page_POI.Inst.ClickbyText("     建立父POI     ");//     框选子POI
//        //Page_POI.Inst.ClickbyText("          框选子POI          ");
//        Page_POI.Inst.Click(Page_POI.SELECTSON);
//        Thread.sleep(2000);
//        Page_MainBoard.Inst.Click(new Point(563,583));
//        Page_MainBoard.Inst.Click(new Point(600,1000));
//        Page_MainBoard.Inst.Click(new Point(1100,800));
//        Thread.sleep(2000);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.FRAME_COMPLETE);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.LIST_ITEM);
//        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.LIST_SAVE);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        String parentFid = (String) Sqlitetools.GetPoisDataByRowKey(infoFid,"parentFid");
//        assertEquals(parentFid,infoFid1);
//    }

//    @Test
//    public void test998_00257_poi_relationship_Tag() throws Exception
//    {
//        SearchLocation(LOC_K1);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        String infoFid1 = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid1 = infoFid1.replace("fid:", "");
//        infoFid1 = infoFid1.replace("fid : ", "");
//        Page_POI.Inst.SetValue(Page_POI.NAME,"加油站");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230215");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        //轻轨/地铁出入口
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.SetValue(Page_POI.NAME,"地铁");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230111");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        Page_FunctionalArea.Inst.ClickbyText("加油站");
//        String str = Page_FunctionalArea.Inst.GetValue(Page_POI.POI_FATHER);
//        assertEquals("加油站",str);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        String parentFid = (String) Sqlitetools.GetPoisDataByRowKey(infoFid,"parentFid");
//        assertEquals(parentFid,infoFid1);
//    }
//
//    @Test
//    public void test998_00258_poi_relationship_Tag() throws Exception
//    {
//        SearchLocation(LOC_K1);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        String infoFid1 = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid1 = infoFid1.replace("fid:", "");
//        infoFid1 = infoFid1.replace("fid : ", "");
//        Page_POI.Inst.SetValue(Page_POI.NAME,"加油站");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230215");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        //轻轨/地铁出入口
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("捕捉点位新增");
//        }
//        catch (Exception e)
//        {
//
//        }
//        //拍照并返回
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Thread.sleep(2000);
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//        Page_POI.Inst.SetValue(Page_POI.NAME,"地铁");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "230111");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        GotoMyData(Page_MyData.POI_TYPE);
//        Page_MyData.Inst.ClickByText("地铁");
//        Page_POI.Inst.Click(Page_POI.POI_FATHER);
//        //Page_POI.Inst.ClickbyText("     建立父POI     ");
//        Page_FunctionalArea.Inst.ClickbyText("加油站");
//        String str = Page_FunctionalArea.Inst.GetValue(Page_FunctionalArea.POI_FATHER);
//        assertEquals("加油站",str);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        String parentFid = (String) Sqlitetools.GetPoisDataByRowKey(infoFid,"parentFid");
//        assertEquals(parentFid,infoFid1);
//    }

    @Test
    public void test998_06201_MilePost_add() throws Exception
    {
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PROVINCIAL_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("里程桩");
        String value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("请选取道路编号",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("请选取道路名",value);
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        Page_MyData.Inst.ClickByText("里程桩");
        value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("Ｓ４７９",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("手绘道路",value);
        Page_MilePost.Inst.Click(Page_MilePost.CANCEL);
    }

    @Test
    public void test998_06202_MilePost_add() throws Exception
    {
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PROVINCIAL_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        String value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("S479",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("手绘道路",value);
        Page_MilePost.Inst.Click(Page_MilePost.NUM_CLEAR);
        Thread.sleep(1000);
        Page_MilePost.Inst.Click(Page_MilePost.NAME_CLEAR);
        Thread.sleep(1000);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("请选取道路编号",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("请选取道路名",value);
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("里程桩");
        value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("Ｓ４７９",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("手绘道路",value);
        Page_MilePost.Inst.Click(Page_MilePost.NUM_CLEAR);
        Thread.sleep(1000);
        Page_MilePost.Inst.Click(Page_MilePost.NAME_CLEAR);
        Thread.sleep(1000);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("请选取道路编号",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("请选取道路名",value);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
    }

    @Test
    public void test998_06203_MilePost_add() throws Exception
    {
        SearchLocation(LOC_K3);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("里程桩");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
        Thread.sleep(1000);
        String str = "里程桩的道路名称或道路编号在所关联link的道路名称中不存在，请确认！";
        Page_IndoorMyData.Inst.ClickbyText(str);
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("忽略");
        ExitIndoorTools();

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("里程桩");
        String value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("Ｓ４７９",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("手绘道路",value);
        Page_MilePost.Inst.Click(Page_MilePost.NUM_CLEAR);
        Thread.sleep(1000);
        Page_MilePost.Inst.Click(Page_MilePost.NAME_CLEAR);
        Thread.sleep(1000);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_NO);//此时道路名编号应为空
        assertEquals("请选取道路编号",value);
        value = Page_MilePost.Inst.GetValue(Page_MilePost.NAME);//此时道路名称号应为空
        assertEquals("请选取道路名",value);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
    }

    @Test
    public void test998_06204_MilePost_add() throws Exception
    {
        SearchLocation(LOC_K3);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO,"S479");//此时道路名编号应为空
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME,"手绘道路");//此时道路名称号应为空
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("里程桩");
        String rowkey = Page_MilePost.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        JSONObject jsonObject = new JSONObject(temp);
        int type = jsonObject.getInt("src");
        assertSame(type, 1);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("里程桩");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
        Thread.sleep(1000);
        String str = "里程桩的道路名称或道路编号在所关联link的道路名称中不存在，请确认！";
        Page_IndoorMyData.Inst.ClickbyText(str);
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.ClickbyText("忽略");
        ExitIndoorTools();

        synchronize_zhou(Page_GridManager.TIPS_UPDATE);
        Sqlitetools.RefreshData();
        temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        jsonObject = new JSONObject(temp);
        type = jsonObject.getInt("src");
        assertSame(type, 1);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickByText("里程桩");
        Page_MilePost.Inst.ClickbyText("内插里程桩");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        Sqlitetools.RefreshData();
        temp = new String((byte[]) Sqlitetools.GetTipsDataByRowKey(rowkey, "deep"));
        jsonObject = new JSONObject(temp);
        type = jsonObject.getInt("src");
        assertSame(type, 2);
    }

//    @Test
//    public void test998_06301_poi_sync() throws Exception
//    {
//        //开启数据同步
////        Page_MainBoard.Inst.Click(Page_MainBoard.SETTING);
////        Page_MainBoard.Inst.Drag(1837,1150,1837,420,5);
////        Page_MainBoard.Inst.Click(Page_MainBoard.DATA_SYNC);
////        Thread.sleep(5000);
////        Page_MainBoard.Inst.ClickCenter();
//        //有POI Tips数据的时候
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);//打点
//        Page_MainBoard.Inst.ClickCenter();
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);//打点
//        Page_MainBoard.Inst.ClickCenter();
//        String[][] attrib1 = {{Page_POI.NAME, "中餐馆TEST"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}};
//        AddPOI(attrib1,"捕捉点位新增");
//
//        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
//        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
//        Page_GridManager.Inst.Click(Page_GridManager.PROJECT_BUTTON);
//        Thread.sleep(1000);
//        Page_MainBoard.Inst.ClickCenter();
//        Thread.sleep(1000);
//        Page_GridManager.Inst.ClickByText("下载数据"); //同步
//        String str = Page_MainBoard.Inst.GetValue(Page_MainBoard.DATA_COUNT);
//        String temp = "未上传数量：\n" + "Tips：2 POI：1 情报：0";
//        assertEquals(temp,str);
//        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
//
//        Page_GridManager.Inst.Click(Page_GridManager.POI_UPDATE); //情报数据
//        Thread.sleep(1000);
//        Page_GridManager.Inst.ClickByText("下载数据"); //同步
//        Thread.sleep(1000);
//        str = Page_MainBoard.Inst.GetValue(Page_MainBoard.DATA_COUNT);
//        temp = "未上传数量：\n" + " POI：1 情报：0";
//        assertEquals(temp,str);
//        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
//
//        Page_GridManager.Inst.Click(Page_GridManager.TIPS_UPDATE); //情报数据
//        Thread.sleep(1000);
//        Page_GridManager.Inst.ClickByText("下载数据"); //同步
//        Thread.sleep(1000);
//        str = Page_MainBoard.Inst.GetValue(Page_MainBoard.DATA_COUNT);
//        temp = "未上传数量：\n" + "Tips：2 情报：0";
//        assertEquals(temp,str);
//        Page_GridManager.Inst.Click(Page_GridManager.NO_TASK_CONFIRM);
//        Page_GridManager.Inst.Click(Page_GridManager.BACK);
//        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
//
//        downloaddata(Page_GridManager.INFO_UPDATE);
//    }
//
//    @Test
//    public void test998_06302_poi_sync() throws Exception
//    {
//        //无数据的时候
//        downloaddata(Page_GridManager.INFO_UPDATE);
//        downloaddata(Page_GridManager.INFO_UPDATE);
//        downloaddata(Page_GridManager.TIPS_UPDATE);
//        downloaddata(Page_GridManager.POI_UPDATE);
//        downloaddata(Page_GridManager.INTEGRATE_UPDATE);
//        //开启数据同步
////        Page_MainBoard.Inst.Click(Page_MainBoard.SETTING);
////        Page_MainBoard.Inst.Drag(1837,1150,1837,420,5);
////        Page_MainBoard.Inst.Click(Page_MainBoard.DATA_SYNC);
////        Thread.sleep(5000);
////        Page_MainBoard.Inst.ClickCenter();
//
//    }

    @Test @IMPORTANT
    public void test998_06401_info_Point_test() throws Exception
    {
        //添加点情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();

        Page_InfoPoint.Inst.Click(Page_InfoPoint.NAME);
        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME,"测试点ＩＮＦＯ");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.ROAD_TYPE);
        Page_InfoPoint.Inst.ClickbyText("一级");
        Page_InfoPoint.Inst.ClickbyText("新增");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);

        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.ClickbyText("测试点ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Thread.sleep(2000);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        synchronize_zhou(Page_GridManager.INFO_UPDATE);


        SearchInfos(globalId);
        String str = Page_InfoAccept.Inst.GetValuebyIndex(Page_InfoAccept.REMARKTXT,1);
        assertEquals(str,"请输入备注...");
        Page_InfoAccept.Inst.SetValuebyIndex(Page_InfoAccept.REMARKTXT,1,"备注");
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT);
        Page_InfoAccept.Inst.Click(Page_InfoAccept.BACK);

        Page_MultiList.Inst.ClickbyText("测试点ＩＮＦＯ");
        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        str = Page_InfoAccept.Inst.GetValuebyIndex(Page_InfoAccept.REMARKTXT,1);
        assertEquals(str,"备注");
    }

    @Test @IMPORTANT
    public void test998_06402_info_Line_test() throws Exception
    {
        //添加线情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME,"测试线");
        Page_InfoLine.Inst.Click(Page_InfoLine.POI_TYPE);
        Page_InfoPoint.Inst.ClickbyText("一级");
        Page_InfoPoint.Inst.ClickbyText("修改");
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Thread.sleep(1000);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        //查看我的数据
        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.ClickbyText("测试线");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Thread.sleep(2000);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        //同步数据
        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);
        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        Thread.sleep(2000);
        String str = Page_InfoAccept.Inst.GetValuebyIndex(Page_InfoAccept.REMARKTXT,1);
        assertEquals(str,"请输入备注...");
        Page_InfoAccept.Inst.SetValuebyIndex(Page_InfoAccept.REMARKTXT,1,"备注");
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT);

//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        SearchInfos(globalId);
        Page_MultiList.Inst.ClickbyText("测试线");
        Thread.sleep(2000);
        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        str = Page_InfoAccept.Inst.GetValuebyIndex(Page_InfoAccept.REMARKTXT,1);
        assertEquals(str,"备注");
    }

    @Test @IMPORTANT
    public void test998_06403_info_Frame_test() throws Exception
    {
        //添加面情报
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);
        Thread.sleep(2000);
        //Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);
        Page_InfoFrame.Inst.SetValue(Page_InfoFrame.NAME,"测试面ＩＮＦＯ");
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);
        Page_InfoPoint.Inst.ClickbyText("三级");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.DELETE);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME_CONFIRM);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("测试面ＩＮＦＯ", "测试面ＩＮＦＯ");

        String globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).replace("globalId:", "");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        Page_MyData.Inst.Click(Page_MyData.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        synchronize_zhou(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);
        Page_InfoAccept.Inst.Drag(1800,1200,1800,700,5);
        String str = Page_InfoAccept.Inst.GetValuebyIndex(Page_InfoAccept.REMARKTXT,1);
        assertEquals(str,"请输入备注...");
        Page_InfoAccept.Inst.SetValuebyIndex(Page_InfoAccept.REMARKTXT,1,"备注");
        Page_InfoAccept.Inst.Click(Page_InfoAccept.ACCEPT);
        Page_InfoAccept.Inst.Click(Page_InfoAccept.BACK);

        SearchInfos(globalId);
        Thread.sleep(2000);
        str = Page_InfoAccept.Inst.GetValuebyIndex(Page_InfoAccept.REMARKTXT,1);
        assertEquals(str,"备注");
    }

    @Test   @IMPORTANT
    public void test999_0101_poi_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);

        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ");
    }

    @Test @IMPORTANT
    public void test999_0201_tips_point_TrafficLight_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.ClickCenter();

        CheckMyData(Page_MyData.TIPS_TYPE, "红绿灯");
    }

    @Test @IMPORTANT
    public void test999_0301_tips_line_DrawRoad_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "测线");

//        String strType = "rb_condition_tips";
//        GotoMyData(strType);
//
//        UiObject2 txtAddCount  = mDevice.wait(Until.findObject(By.res(packageName, "tv_my_data_count_2")), 500);
//        assertEquals(Integer.toString(tipsNum), txtAddCount.getText());
//
//        UiObject2 obj = mDevice.wait(Until.findObject(By.textContains("测线")),500);
//        assertNotNull(obj);
//
//        obj.click();
//
//        String rowkey = mDevice.wait(Until.findObject(By.res(packageName, "et_title")), 500).getText();
//        rowkey = rowkey.substring("rowkey：".length());
//
//        Click("cancel_button");
//
//        ExitMyData();

//        m_Sqlit.RefreshData();
//        assertEquals(m_Sqlit.GetTipsDisplayText(rowkey), " 1 车道 | K1");
    }

    @Test
    public void test999_0301_tips_line_DrawRoad_Edit() throws Exception
    {

        String[] LOC = {"116.41891", "39.96298"};
        SearchLocation(LOC);
        Page_MainBoard.Inst.ClickCenter();

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1000, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        for (int i=0; i<1; i++)
        {
            SearchLocation(LOC);
            Page_MainBoard.Inst.ClickCenter();
            Page_SurveyLine.Inst.ScrollClick(Page_SurveyLine.EDIT_SHAPE);

            Thread.sleep(3000);
            Page_MainBoard.Inst.Click(new Point(1920, 877));
            Page_MainBoard.Inst.Click(new Point(1710, 495));

//            Page_SurveyLineEdit.Inst.Click(Page_SurveyLineEdit.SAVE);
//            Page_SurveyLine.Inst.ClickByText("取消");
//            Page_SurveyLine.Inst.ClickByText("舍弃");
        }

    }


    @Test @IMPORTANT
    public void test999_0401_tips_releation_TrackLimit_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000, 1000));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.FORB_LEFT);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "卡车交限");
    }


    @Test @IMPORTANT
    public void test999_0501_QCTask_add() throws Exception
    {
        GotoIndoorTools();

        Page_MainBoard.Inst.Click(Page_MainBoard.QC_TASK);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT);
        Page_MainBoard.Inst.ClickCenter();

        Page_QCProblem.Inst.Click(Page_QCProblem.PROB_ERROR);
        Page_QCProblem.Inst.SelectError("不受灯控LINK选择错误");
        Page_QCProblem.Inst.Click(Page_QCProblem.SAVE);

        Page_IndoorMyData.Inst.CheckQcDataExist("红绿灯");
    }

    @Test @IMPORTANT
    public void test999_0601_Precise_Pas_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);

        Page_PAS.Inst.Click(Page_PAS.SAVE);

        CheckMyData(Page_MyData.PAS_TYPE, "测试ＰＡＳ１０１");
    }

    @Test @IMPORTANT
    public void test999_0701_info_Point_add() throws Exception
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试点ＩＮＦＯ");
        Page_InfoPoint.Inst.Click(Page_InfoPoint.POI_TYPE);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);

        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);

        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE);

        CheckMyData(Page_MyData.INFO_TYPE, "测试点ＩＮＦＯ", "测试点ＩＮＦＯ");
    }

    @Test @IMPORTANT
    public void test999_0801_info_Line_add() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {

        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);

        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoLine.Inst.Click(Page_InfoLine.DRAW_FINISH);
        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试线ＩＮＦＯ");
        Page_InfoLine.Inst.Click(Page_InfoLine.POI_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);

        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Thread.sleep(1000);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);

        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        CheckMyData(Page_MyData.INFO_TYPE, "测试线ＩＮＦＯ", "测试线ＩＮＦＯ");
    }

    @Test @IMPORTANT
    public void test999_0901_info_Frame_add() throws InterruptedException, NoSuchFieldException, ClassNotFoundException
    {
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT);
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);

        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1000, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));

        Page_InfoFrame.Inst.Click(Page_InfoFrame.DRAW_FINISH);

        Page_InfoFrame.Inst.SetValue(Page_InfoFrame.NAME, "测试面ＩＮＦＯ");
        Page_InfoFrame.Inst.Click(Page_InfoFrame.ROAD_TYPE);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.LEVEL_1);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.TIME_CONFIRM);
        Page_InfoFrame.Inst.Click(Page_InfoFrame.CAMERA);

        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);

        Page_InfoFrame.Inst.Click(Page_InfoFrame.SAVE);

        CheckMyData(Page_MyData.INFO_TYPE, "测试面ＩＮＦＯ", "测试面ＩＮＦＯ");
    }

    @Test @IMPORTANT
    public  void test999_1201_tips_Eyes_SpeedType_Add_Modify_Del() throws Exception
    {
        String SpeedEyes[] = {
                Page_ElecEye.EYE_INTERVAL_END,
                Page_ElecEye.EYE_OVERSPEED,
                Page_ElecEye.EYE_LOWSPEED,
                Page_ElecEye.EYE_MOVE,
                Page_ElecEye.EYE_VAR,
                Page_ElecEye.EYE_LANE_SPEED,
                Page_ElecEye.EYE_VEHICLE
        };


        for (String type : SpeedEyes)
        {
            Thread.sleep(2000);

            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.ClickCenter();

            Page_ElecEye.Inst.SetSpeed("40");
            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");

            Page_MyData.Inst.SelectData("电子眼");
            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            //Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Thread.sleep(2000);
            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");

            Page_MyData.Inst.Click(Page_MyData.BACK);
            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test999_1202_tips_Eyes_TimeType_Add_Modify_Del() throws Exception
    {
        String TimeEyes[]  = {
                Page_ElecEye.EYE_BUS_LANE,
                Page_ElecEye.EYE_ONE_WAY,
        };

        for (String type : TimeEyes)
        {
            Thread.sleep(2000);

            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.ClickCenter();

            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.Click(Page_ElecEye.TIME);
            Page_ElecEye.Inst.Click(Page_ElecEye.TIME_CONFIRM);

            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");

            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            //Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test999_1203_tips_Eyes_CarType_Add_Modify_Del() throws Exception
    {

        String CarTypeEyes[] = {
                Page_ElecEye.EYE_NUM_CTRL,
                Page_ElecEye.EYE_ENV_PROT};

        for (String type : CarTypeEyes)
        {
            Thread.sleep(2000);

            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.ClickCenter();

            Page_ElecEye.Inst.Click(type);
//            Page_ElecEye.Inst.Click(Page_ElecEye.TIME);
//            Page_ElecEye.Inst.Click(Page_ElecEye.TIME_CONFIRM);
            Page_ElecEye.Inst.Click(Page_ElecEye.TRUCK);
            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");

            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            //Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Thread.sleep(2000);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test
    public void test999_1204_tips_Eyes_CommonType_Add_Modify_Del() throws Exception
    {
        String CommonEyes[] = {
                Page_ElecEye.EYE_NO_VECHICLE,
                Page_ElecEye.EYE_NO_TURN,
                Page_ElecEye.EYE_ILLEGAL_PARKING,
                Page_ElecEye.EYE_EMERG_LANE,
                Page_ElecEye.EYE_TRAFFIC_LIGHT,
                Page_ElecEye.EYE_TRAFFIC_MARK,
                Page_ElecEye.EYE_EXIT_ENTER,
                Page_ElecEye.EYE_PEDESTRIAN,
                Page_ElecEye.EYE_AUD_WAIN,
                Page_ElecEye.EYE_NO_TURNOFF,
                Page_ElecEye.EYE_VIOLAT_LANE,
                Page_ElecEye.EYE_ILLEGAL_CROSS,
                Page_ElecEye.EYE_VIOLAT_SIGN,
                Page_ElecEye.EYE_ILLEGAL_LIGHT,
                Page_ElecEye.EYE_NO_BELT,
                Page_ElecEye.EYE_DRIVE_PHONE,
                Page_ElecEye.EYE_ROAD_MONITOR,
                Page_ElecEye.EYE_NO_INSPECTION,
                Page_ElecEye.EYE_TAIL_GAS,
        };

        for(String type : CommonEyes)
        {
            Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
            Page_MainBoard.Inst.ClickCenter();

            Page_ElecEye.Inst.Click(type);
            Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);

            CheckMyData(Page_MyData.TIPS_TYPE, "电子眼");

            Page_MyData.Inst.SelectData("电子眼");

            Page_ElecEye.Inst.Click(Page_ElecEye.DELETE);
            //Page_ElecEye.Inst.Click(Page_ElecEye.DELETE_CONFIRM);

            Page_MyData.Inst.CheckNotExist(Page_MyData.TIPS_TYPE, "电子眼");
            Page_MyData.Inst.Click(Page_MyData.BACK);

            Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
        }
    }

    @Test @IMPORTANT
    public void test999_1301_IndoorCheck_FM_1401_7_1() throws Exception
    {
        //方向看板Tips，必须至少添加一张照片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.Click(new Point(1000, 500));

        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);

        Page_IndoorMyData.Inst.CheckResultExit("方向看板", "高", "FM-1401-7-1", "方向看板，必须添加现场照片", "");

        Page_IndoorMyData.Inst.SelectResult("FM-1401-7-1");

        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.CAMERA);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.TAKE_PIC);
        Thread.sleep(2000);
        Page_Info_Camera.Inst.Click(Page_Info_Camera.BACK);
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        try
        {
            //如果FM-1401-7-1不是最后一个检查项，则app会自动触发下一个检查项，此时需要点击取消
            Thread.sleep(2000);
            Page_DirectionBoard.Inst.Click(Page_DirectionBoard.CANCEL);
        }
        catch(NoSuchFieldException e)
        {

        }

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_RESULT_BACK);


        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);

        Page_IndoorMyData.Inst.CheckResultNotExit("FM-1401-7-1");
    }

    @Test
    public void test999_1302_IndoorCheck_FM_1401_6_1_1() throws Exception
    {
        //方向看板关联在前道路级别为K1、K2、K8~K13
        test_IndoorCheck_FM_1401_6_1(Page_SurveyLine.NINE_RD);
    }

    @Test
    public void test999_1302_IndoorCheck_FM_1401_6_1_2() throws Exception
    {
        //方向看板关联在前道路级别为K1、K2、K8~K13
        test_IndoorCheck_FM_1401_6_1(Page_SurveyLine.PEDESTRIAN_RD);
    }

    @Test
    public void test999_1302_IndoorCheck_FM_1401_6_1_3() throws Exception
    {
        //方向看板关联在前道路级别为K1、K2、K8~K13
        test_IndoorCheck_FM_1401_6_1(Page_SurveyLine.PEOPLE_CROSS_RD);
    }

    @Test
    public void test999_1302_IndoorCheck_FM_1401_6_1_4() throws Exception
    {
        //方向看板关联在前道路级别为K1、K2、K8~K13
        test_IndoorCheck_FM_1401_6_1(Page_SurveyLine.FERRY_RD);
    }

    @Test
    public void test999_1306_IndoorCheck_FM_2001_6_1() throws Exception
    {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_NUMBER);
        Page_MainBoard.Inst.Click(arrayPoint[1]);

        Page_LaneNumber.Inst.Click(Page_LaneNumber.NUM1);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);

        Page_IndoorMyData.Inst.CheckResultExit("测线", "中", "FM-2001-6-1", "测线车道数记录在属性中，请删除关联测线的车道数Tips", "");
    }

    @Test
    public void test999_1307_IndoorCheck_FM_1504_5_1() throws Exception
    {
        //跨越桥的几何长度要小于800m时，报log
        int MAX_LEN = 700;

        double Distance = GetDistance100Pixel();

        Point[] arrayPoint = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), 1300)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[3], Page_StartEndPoint.OVERPASS_BT);

        AssertIndoorCheck("OverPass", "低", "FM-1504-5-1", "跨越桥长度小于800米，不需要采集！", "可以忽略");

    }

    @Test
    public void test999_1307_IndoorCheck_FM_1504_5_2() throws Exception
    {
        //跨越桥的几何长度大于800m时，不报log
        int MAX_LEN = 810;

        double Distance = GetDistance100Pixel();

        Point[] arrayPoint2 = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), 1300)};
        DrawRoad(arrayPoint2);

        SetStartEndPoint(arrayPoint2[0], arrayPoint2[3], Page_StartEndPoint.OVERPASS_BT);

        AssertIndoorCheckNull("FM-1504-5-1");
    }

    @Test
    public void test999_1308_IndoorCheck_FM_1505_5_1() throws Exception
    {
        //穿越地道的几何长度要小于800m时, 报log
        int MAX_LEN = 700;

        double Distance = GetDistance100Pixel();

        Point[] arrayPoint = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), 1300)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[3], Page_StartEndPoint.UNDER_PASS_BT);

        AssertIndoorCheck("Underpass", "低", "FM-1505-5-1", "穿越地道长度小于800米，不需要采集！", "可以忽略");
    }

    @Test
    public void test999_1308_IndoorCheck_FM_1505_5_2() throws Exception
    {
        //跨越桥的几何长度大于800m时，不报log
        int MAX_LEN = 810;

        double Distance = GetDistance100Pixel();

        Point[] arrayPoint2 = {new Point(1300, 1300),
                new Point(1300, (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), (int)(1300-(MAX_LEN/Distance)*100/2)),
                new Point((int)(1300-(MAX_LEN/Distance)*100/2), 1300)};
        DrawRoad(arrayPoint2);

        SetStartEndPoint(arrayPoint2[0], arrayPoint2[3], Page_StartEndPoint.UNDER_PASS_BT);

        AssertIndoorCheckNull("FM-1505-5-2");
    }

    @Test
    public void test999_1309_IndoorCheck_FM_1509_6_1() throws Exception
    {
        //跨线立交桥与匝道互斥
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[2], Page_StartEndPoint.CROSS_LINE_OVERPASS_BT);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);

        Page_MainBoard.Inst.Click(arrayPoint[1]);
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");
    }

    @Test
    public void test999_1310_IndoorCheck_FM_1509_6_1() throws Exception
    {
        //跨线立交桥与桥互斥
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.CROSS_LINE_OVERPASS_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.BRIDGE_BT);

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");

    }

    @Test
    public void test999_1311_IndoorCheck_FM_1509_6_1() throws Exception
    {
        //跨线立交桥与隧道互斥
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.CROSS_LINE_OVERPASS_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.TUNNEL_BT);

        AssertIndoorCheck("中", "跨线立交桥", "FM-1509-6-1", "跨线立交桥与桥、匝道、隧道属性不能共存", "不能忽略");
    }

    @Test
    public void test999_1314_IndoorCheck_FM_1109_6_7_1() throws Exception
    {
        test_IndoorCheck_FM_1109_6_7(Page_SurveyLine.PEDESTRIAN_RD);
    }

    @Test
    public void test999_1314_IndoorCheck_FM_1109_6_7_2() throws Exception
    {
        test_IndoorCheck_FM_1109_6_7(Page_SurveyLine.PEOPLE_CROSS_RD);
    }

    @Test
    public void test999_1314_IndoorCheck_FM_1109_6_7_3() throws Exception
    {
        test_IndoorCheck_FM_1109_6_7(Page_SurveyLine.FERRY_RD);
    }

    @Test
    public void test999_1315_IndoorCheck_FM_1109_6_7() throws Exception
    {
        //8级区域内测线采集摄像头
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};

        DrawRoad(arrayPoint, Page_SurveyLine.OTHER_RD);

        AddRegional(arrayPoint[0], Page_RoundAbout.REGION_ROAD);
        AddElecEye(arrayPoint[0]);

        AssertIndoorCheck("中", "电子眼", "FM-1109-6-7", "10级、人渡、轮渡、具有区域内道路属性的8级路不采集摄像头", "不能忽略");

    }

    @Test
    public void test999_1316_IndoorCheck_FM_1119_2_1() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING);
        Page_MainBoard.Inst.ClickCenter();

        Page_NoParking.Inst.SetValue(Page_NoParking.REMARK, "TEST");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        AssertIndoorCheck("低", "通用禁停", "FM-1119-2-1", "禁停区域描述需要填在“描述信息”中", "忽略");

        Page_IndoorMyData.Inst.SelectResult("FM-1119-2-1");

        Page_NoParking.Inst.SetValue(Page_NoParking.DESC, "TEST");
        Page_NoParking.Inst.Click(Page_NoParking.SAVE);

        ExitIndoorToolsWithCheckResult();

        AssertIndoorCheckNull("FM-1119-2-1");

    }

    @Test
    public void test999_1316_IndoorCheck_FM_1120_2_1() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.ClickCenter();

        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.REMARK, "TEST");
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        AssertIndoorCheck("低", "通用禁停", "FM-1120-2-1", "卡车禁停区域描述需要填在“描述信息”中", "忽略");

        Page_IndoorMyData.Inst.SelectResult("FM-1120-2-1");

        Page_NoParkingTruck.Inst.SetValue(Page_NoParkingTruck.DESC, "TEST");

        Thread.sleep(1000);

        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);

        Thread.sleep(1000);

        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.CANCEL);

        ExitIndoorToolsWithCheckResult();

        AssertIndoorCheckNull("FM-1120-2-1");
    }


    private void test_IndoorCheck_FM_1109_6_7(String type) throws Exception
    {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 500)};
        DrawRoad(arrayPoint, type);

        AddElecEye(arrayPoint[0]);

        AssertIndoorCheck("中", "电子眼", "FM-1109-6-7", "10级、人渡、轮渡、具有区域内道路属性的8级路不采集摄像头", "不能忽略");
    }

    private void test_IndoorCheck_FM_1401_6_1(String type) throws Exception
    {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500), new Point(500, 1000)};
        DrawRoad(arrayPoint, type);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.Click(arrayPoint[1]);

        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);

        Page_IndoorMyData.Inst.CheckResultExit("方向看板", "中", "FM-1401-6-1", "采集方向看板应该采集在7级上下分离或6级及以上的普通道路（3、4、6）上", "");

        Page_IndoorMyData.Inst.SelectResult("FM-1401-6-1");
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.DELETE);
        //Page_DirectionBoard.Inst.Click(Page_DirectionBoard.CONFIRM);

        try
        {
            //如果FM-1401-7-1不是最后一个检查项，则app会自动触发下一个检查项，此时需要点击取消
            Thread.sleep(2000);
            Page_DirectionBoard.Inst.Click(Page_DirectionBoard.CANCEL);
        }
        catch (Exception e)
        {

        }

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_RESULT_BACK);

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);

        Page_IndoorMyData.Inst.CheckResultNotExit("FM-1401-6-1");
    }



    //卡车限制
    @Test
    public void test_FM_1110_2_3_check() throws Exception {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_LIMIT);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_TruckLimit.Inst.Click(Page_TruckLimit.WEIGHT);
        Page_TruckLimit.Inst.ClickByText("10");
        Page_TruckLimit.Inst.Click(Page_TruckLimit.SAVE);


        AssertIndoorCheck("卡车限制", "中", "FM-1110-2-3", "卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。", "");
    }

    // FM_1113_2_1 车道限速
    @Test
    public void test_FM_1113_2_1_check() throws Exception {
        if (FastMapPage.IS_OS_TEST) {
            return;
        }

        // 创建车道限速
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.ClickCenter();
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Page_MainBoard.Inst.Drag(85, 445, 155, 445, 5);
        Page_SpeedLimit.Inst.Click(new Point(105, 283));
        Page_SpeedLimit.Inst.Click(new Point(105, 362));
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        //Page_SpeedLimit.Inst.Click(new Point(195,362));
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.NUM30);
        Page_SpeedLimitLane.Inst.Click(Page_SpeedLimitLane.SAVE);
        AssertIndoorCheck("车道限速", "高", "FM-1113-2-1", "车道限速各车道的限速值一样时，不需采集", "忽略");
    }

    //卡车限速
    @Test
    public void test_FM_1114_2_1_check() throws Exception {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.TRUCKLIMIT);
        Page_SpeedLimit.Inst.ClickByText("30");
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SAVE);


        AssertIndoorCheck("卡车限制", "中", "FM-1114-2-1", "卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。", "");
    }

    //卡车禁停
    @Test
    public void test_FM_1120_2_2_check() throws Exception {
        SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PARKING_TRUCK);
        Page_MainBoard.Inst.Click(new Point(1500, 800));
        Page_NoParkingTruck.Inst.Click(Page_NoParkingTruck.SAVE);


        AssertIndoorCheck("卡车限制", "中", "FM-1120-2-2", "卡车地图采集7级及以上等级道路上的卡车地图内容，其他等级道路不采集卡车地图内容。", "");
    }


    // FM-1207-6-2
    @Test
    public void test_FM_1207_6_2_check() throws Exception {

        String[][] attrib1 = {{Page_POI.NAME, "测试ＰＯＩ001"},
                {Page_POI.SELECT_TYPE, "中餐馆"}};

        AddPOI(attrib1, "116.40572", "39.96958", "忽略捕捉新增");

        //增加匝道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.RAMP);

        Page_MainBoard.Inst.ClickCenter();
        Page_Ramp.Inst.Click(Page_Ramp.RAMP);
        Page_Ramp.Inst.Click(Page_Ramp.SAVE);

        AssertIndoorCheck("匝道", "低", "FM-1207-6-2", "匝道属性道路连接了POI", "忽略");
    }

    // FM-1208-2-1
    @Test
    public void test_FM_1208_2_1_check() throws Exception {
        SearchLocation(LOC_K8);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);

        //增加停车场出入口link
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PARK_ENTRANCE_LINK);
        Page_MainBoard.Inst.ClickCenter();
        Page_ParkLink.Inst.Click(Page_ParkLink.SAVE);

        AssertIndoorCheckNull("FM-1208-2-1");
    }

    // FM-1301-6-4
    @Test
    public void test_FM_1301_6_4_1_check() throws Exception {

        SearchLocation(LOC_K8);

        //增加车信
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE_G_A_F);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.APPEND);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        AssertIndoorCheck("车信", "低", "FM-1301-6-4", "有附加车信，是否车道变化点采集遗漏", "忽略");

    }

    // FM-1301-6-4
    @Test
    public void test_FM_1301_6_4_2_check() throws Exception {

        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);

        //测线中点
        Page_MainBoard.Inst.Click(new Point(1250, 600));
        //保存
        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);

        //增加车信
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.Click(new Point(720, 800));

        Page_LaneInfo.Inst.Click(Page_LaneInfo.ONE_G_A_F);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.APPEND);

        //保存
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        AssertIndoorCheck("车信", "低", "FM-1301-6-4", "有附加车信，是否车道变化点采集遗漏", "忽略");

    }


    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_1_check() throws Exception {
        SearchLocation(LOC_K1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_2_check() throws Exception {
        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_3_check() throws Exception {
        SearchLocation(LOC_K3);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1304_6_2_4_check() throws Exception {
        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_5_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.ClickCenter();
        Page_Kind.Inst.Click(Page_Kind.CITY_HIGH_SPEED);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_6_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.ClickCenter();
        Page_Kind.Inst.Click(Page_Kind.HIGH_SPEED);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.ClickCenter();
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");

    }

    @Test
    public void test_FM_1304_6_2_7_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1304_6_2_8_check() throws Exception {

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止穿行3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NO_PASS_THROUGH);
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_NoPassing.Inst.Click(Page_NoPassing.SAVE);

        AssertIndoorCheck("禁止穿行", "低", "FM-1304-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止穿行属性，请确认是否正确。", "忽略");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_1_check() throws Exception {
        SearchLocation(LOC_K8);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);
        Page_MainBoard.Inst.ClickCenter();
        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);


        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "中", "FM-1305-6-1", "禁止驶入与单行线重复", "");
    }

    // FM-1305-6-1
    @Test
    public void test_FM_1305_6_1_2_check() throws Exception {
        String[] StartLoc = {"116.41757", "39.96337"};
        SearchLocation(StartLoc);

        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        SearchLocation(StartLoc);

        //增加道路方向：单向
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_DIRECTION);
        Page_MainBoard.Inst.ClickCenter();

        Page_RoadDirection.Inst.Click(Page_RoadDirection.SAVE);

        SearchLocation(StartLoc);

        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "中", "FM-1305-6-1", "禁止驶入与单行线重复", "");
    }


    // FM-1305-6-2
    @Test
    public void test_FM_1305_6_2_1_check() throws Exception {

        SearchLocation(LOC_K1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_2_check() throws Exception {

        SearchLocation(LOC_K2);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_3_check() throws Exception {

        SearchLocation(LOC_K3);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    // FM-1304-6-2
    @Test
    public void test_FM_1305_6_2_4_check() throws Exception {

        SearchLocation(LOC_K4);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_5_check() throws Exception {

        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.ClickCenter();
        Page_Kind.Inst.Click(Page_Kind.HIGH_SPEED);

        //禁止驶入1级道路（测线且t_sync=1）

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_6_check() throws Exception {

        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.ClickCenter();
        Page_Kind.Inst.Click(Page_Kind.HIGH_SPEED);

        //禁止驶入2级道路（测线且t_sync=1）

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);


        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_7_check() throws Exception {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_MainBoard.Inst.Click(new Point(1300, 790));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.NATIONAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入3级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000, 790));
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1305_6_2_8_check() throws Exception {
        //绘制测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_MainBoard.Inst.Click(new Point(1300, 1000));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_2);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        //禁止驶入4级道路（测线且t_sync=0）
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.Click(new Point(1000, 1000));
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.NO_PULL_INTO);
        Page_TrafficForbidden.Inst.Click(Page_TrafficForbidden.SAVE);

        AssertIndoorCheck("禁止驶入", "低", "FM-1305-6-2", "高等级道路上（1级、2级、3级、4级）采集了禁止驶入属性，请确认是否正确。", "忽略");
    }

    @Test
    public void test_FM_1406_4_3_1_check() throws Exception {
        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700, 268));

        //高速出口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        //输入编号
        //Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "7bCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        AssertIndoorCheck("实景图", "中", "FM-1406-4-3", "高速路口实景图的编号不能为空，且必须为8位，首位必须是6或9！", "");
    }

    @Test
    public void test_FM_1406_4_3_2_check() throws Exception {
        //点击新增实景图POI
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.Click(new Point(700, 268));

        //高速入口
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        //输入编号
        //Page_TrueSence.Inst.SetValue(Page_TrueSence.ET_IMG_NUMBER, "7bCD1234");

        //拍照5张并返回
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(1000);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        //点击保存
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        AssertIndoorCheck("实景图", "中", "FM-1406-4-3", "高速路口实景图的编号不能为空，且必须为8位，首位必须是6或9！", "");
    }

    //FM-1503-6-1
    @Test
    public void test_FM_1503_6_1_1_check() throws Exception {

        SearchLocation(LOC_K7);

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        SearchLocation(LOC_K7);

        //绘制跨越桥
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERPASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    @Test
    public void test_FM_1503_6_1_2_check() throws Exception {

        SearchLocation(LOC_K7);

        //绘制高架路
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.OVERHEAD_ROAD_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        SearchLocation(LOC_K7);

        //绘制穿越地道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1280, 785));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.UNDER_PASS_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    @Test
    public void test_FM_1503_6_1_3_check() throws Exception {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERHEAD_ROAD_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERPASS_BT);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    @Test
    public void test_FM_1503_6_1_4_check() throws Exception {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.OVERHEAD_ROAD_BT);
        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.UNDER_PASS_BT);

        AssertIndoorCheck("高架路", "中", "FM-1503-6-1", "高架路与跨越桥（或穿越地道）不能共存", "");
    }

    //FM-1521-1-2
    @Test
    public void test_FM_1521_1_2_check() throws Exception {
        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        SetStartEndPoint(arrayPoint[0], arrayPoint[1], Page_StartEndPoint.TRAVELING_BRIDGE_BT);

        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_SurveyLine.Inst.ClickbyText("仅删除测线");
        ExitMyData();

        AssertIndoorCheck("移动式桥", "中", "FM-1521-1-2", "Tips没有关联道路或测线或Node", "");
    }

    @Test
    public void test_FM_1524_1_2_check() throws Exception {
        // 测线
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 530));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 700));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.CAR_TEST_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_MyData.Inst.ClickbyText("仅删除测线");
        ExitMyData(); //退出我的数据


        AssertIndoorCheck("车辆测试路段", "中", "FM-1524-1-2", "Tips没有关联道路或测线或Node", "");
    }

    //FM-1521-1-2
    @Test
    public void test_FM_1525_1_2_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);

        Page_MainBoard.Inst.Click(new Point(1250, 530));
        Page_MainBoard.Inst.Click(new Point(1250, 700));

        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 530));
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.Click(new Point(1260, 700));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.DRIVING_TEST_BT);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_MyData.Inst.ClickbyText("仅删除测线");
        ExitMyData(); //退出我的数据

        AssertIndoorCheck("驾照考试路段", "中", "FM-1525-1-2", "Tips没有关联道路或测线或Node", "");
    }

    //（不查gdb数据）点限速
    @Test
    public void test_FM_1101_1_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);

        Page_MainBoard.Inst.ClickCenter();

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.MAX_SPEED);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SPEED_120);

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.MIN_SPEED);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SPEED_60);

        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.SAVE);

        Sqlitetools.RefreshData();

        testadapter.StopApp();

        testadapter.ClearWal();

        Sqlitetools.updateLinkId();

        testadapter.ClearWal();

        Sqlitetools.RefreshData();

        AssertIndoorCheck("驾照考试路段", "中", null, "Tips没有关联道路或测线或Node", "");
    }

    //里程桩tips的道路名称，全部都是字母和阿拉伯数字，则报错
    @Test
    public void test_FM_1707_2_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "Road001");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "里程桩道路名称不能只存在字母和阿拉伯数字", "");
    }

    //检查里程桩tips的道路名称是否含有英文字母（含大写和小写），存在则报错误
    @Test
    public void test_FM_1707_2_3_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "ROAD");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "里程桩道路名称不能只存在字母和阿拉伯数字", "忽略");
    }

    //里程桩tips的道路名称，全部都是字母和阿拉伯数字，则报错
    @Test
    public void test_FM_1707_2_2_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "1234");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "里程桩道路名称不能只存在字母和阿拉伯数字", "忽略");
    }

    //里程桩tips的道路名称，全部都是字母和阿拉伯数字，则报错
    @Test
    public void test_FM_1707_2_2_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "road1234");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-2", "名称中含有字母，请确认是否正确", "忽略");
    }

    //检查里程桩tips的道路名称是否含有英文字母（含大写和小写），存在则报错误
    @Test
    public void test_FM_1707_2_3_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "road");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-3", "名称中含有字母，请确认是否正确", "忽略");
    }

    //里程桩tips的道路名称，不能含有“/”或“|”（不区分全半角），否则报log1
    @Test
    public void test_FM_1707_2_4_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路/");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路名称不能含有“/”或“|”", "");
    }

    //里程桩tips的道路名称，不能含有“/”或“|”（不区分全半角），否则报log1
    @Test
    public void test_FM_1707_2_4_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路|");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路名称不能含有“/”或“|”", "");
    }

    //.里程桩tips的道路编号，不能含有“/”或“|”（不区分全半角），否则报log2
    @Test
    public void test_FM_1707_2_4_3_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001/");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路编号不能含有“/”或“|”", "");
    }

    //.里程桩tips的道路编号，不能含有“/”或“|”（不区分全半角），否则报log2
    @Test
    public void test_FM_1707_2_4_4_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001|");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-4", "里程桩道路编号不能含有“/”或“|”", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路$");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路,");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_3_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路，");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_4_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路.");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_5_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路。");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_6_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路?");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_7_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路？");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路名称含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log1
    @Test
    public void test_FM_1707_2_5_8_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路、");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路名称不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_9_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001$");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_10_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001,");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_11_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001，");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_12_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001.");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_13_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001。");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_14_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001?");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_15_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001？");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //.里程桩tips的道路编号含‘$’，‘，’，‘。’，‘？’，‘、’字符（包含全半角）的，报log2
    @Test
    public void test_FM_1707_2_5_16_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001、");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "高", "FM-1707-2-5", "里程桩道路编号不能含有$，。？、字符（包含全半角）", "");
    }

    //里程桩tips的道路名称字段前后和中间，含有空格（不区分全半角），报log1
    @Test
    public void test_FM_1707_2_6_1_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, " 测 试 路 ");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路名称含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路名称字段前后和中间，含有空格（不区分全半角），报log1
    @Test
    public void test_FM_1707_2_6_2_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "　测　试　路　");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路名称含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路编号字段前后和中间，含有空格（不区分全半角），报log2
    @Test
    public void test_FM_1707_2_6_3_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S 0 0 1 ");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路编号含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路编号字段前后和中间，含有空格（不区分全半角），报log2
    @Test
    public void test_FM_1707_2_6_4_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S　0　0　1　");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-6", "里程桩道路编号含有空格信息，请确认是否正确", "忽略");
    }

    //里程桩tips的道路名称和道路编号不能完全一致，忽略全半角差异。（忽略道路名和道路编号都为空的情况）
    @Test
    public void test_FM_1707_2_7_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "S001");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "Ｓ00１");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-7", "里程桩道路名称和道路编号一致，请删除其中之一", "");
    }

    //里程桩tips的道路编号，如果不为空，则必须同时存在字母和阿拉伯数字。
    @Test
    public void test_FM_1707_2_8_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "SsABCD");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "测试路");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "中", "FM-1707-2-8", "里程桩tips的道路编号，只能存在且必须同时存在字母和阿拉伯数字", "");
    }

    //里程桩tips的道路名称和道路编号都为空，需要报错
    @Test
    public void test_FM_1707_2_9_check() throws Exception {
        SearchLocation("116.41939", "39.96208");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);

        Page_MainBoard.Inst.ClickCenter();

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "");
        Page_MilePost.Inst.SetValue(Page_MilePost.NAME, "");

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        AssertIndoorCheck("Tips内容值域检查", "低", "FM-1707-2-9", "请确认里程桩道路名称和道路编号是否都为空", "");
    }

    @Test
    public void test_FM_1216_1_2_check() throws Exception {
        SearchLocation("116.42160","39.95967");

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HOV_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_HovLine.Inst.Click(Page_HovLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(750, 800));
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_HovLine.Inst.Click(Page_HovLine.SAVE);


        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_SurveyLine.Inst.ClickbyText("仅删除测线");
        ExitMyData();

        AssertIndoorCheck("HOV车道", "高", "FM-1216-1-2", "Tips没有关联道路或测线或Node", "");
    }

    @Test
    public void test_FM_1216_2_1_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HOV_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_HovLine.Inst.Click(Page_HovLine.SAVE);


        AssertIndoorCheck("HOV车道", "高", "FM-1216-2-1", "HOV车道Tips没有终点、请添加终点", "");
    }

    @Test
    public void test_FM_1216_6_1_check() throws Exception {
        SearchLocation(LOC_K10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HOV_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_HovLine.Inst.Click(Page_HovLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(750, 800));
        Page_HovLine.Inst.Click(Page_HovLine.SAVE);


        AssertIndoorCheck("HOV车道", "高", "FM-1216-6-1", "HOV车道不能关联在8级别（含以下）道路上", "");
    }


    @Test
    public void test_FM_1217_1_2_check() throws Exception {
        SearchLocation("116.42160","39.95967");

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TURN_LEFT_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(750, 800));
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);


        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_SurveyLine.Inst.ClickbyText("仅删除测线");
        ExitMyData();

        AssertIndoorCheck("借道左转车道", "高", "FM-1217-1-2", "Tips没有关联道路或测线或Node", "");
    }

    @Test
    public void test_FM_1217_2_1_check() throws Exception {
        SearchLocation(LOC_K7);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TURN_LEFT_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);


        AssertIndoorCheck("借道左转车道", "高", "FM-1217-2-1", "借道左转车道Tips没有终点、请添加终点", "");
    }

    @Test
    public void test_FM_1217_6_1_check() throws Exception {
        SearchLocation(LOC_K10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TURN_LEFT_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(750, 800));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);


        AssertIndoorCheck("借道左转车道", "高", "FM-1217-6-1", "借道左转车道不能关联在8级别（含以下）道路上", "");
    }

    @Test
    public void test_FM_1218_1_2_check() throws Exception {
        SearchLocation("116.42160","39.95967");

        Point[] arrayPoint = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(arrayPoint);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FERRY_TIME);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_FerryTime.Inst.Click(Page_FerryTime.SAVE);


        //删除测线
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("测线");
        Page_SurveyLine.Inst.Click(Page_SurveyLine.DELETE);
        Page_SurveyLine.Inst.ClickbyText("仅删除测线");
        ExitMyData();


        AssertIndoorCheck("人渡轮渡时间限制", "高", "FM-1218-1-2", "Tips没有关联道路或测线或Node", "");
    }



    // POI：充电站添加框选子功能
    @Test
    public void test001_7_poi_charge_father_check() throws Exception {

        //创建充电站
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试充电站ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Drag(100, 600, 100, 550, 10);

        //创建充电桩1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试充电桩ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);

        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Drag(100, 600, 100, 550, 10);
        //创建充电桩2
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试充电桩ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电桩");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);

        Page_POI.Inst.Click(Page_POI.CHARGE_GUN);

        Page_POI.Inst.SetValue(Page_POI.CHARGING_CONNECTOR_ID, "1234567890abcdefghijklmnopqrstuvwxyz");

        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_POI.Inst.Click(Page_POI.AC_3);

        Page_POI.Inst.Click(Page_POI.SAVE);


        //进入我的数据
        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.SelectData("测试充电站ＰＯＩ");

        Page_POI.Inst.Click(Page_POI.POI_FATHER);

        Page_MainBoard.Inst.ClickbyText("     框选子POI     ");


        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 500));

        Page_POI.Inst.Click(Page_POI.COMPLETE);

        Page_POI.Inst.ClickbyText("全选");
        Page_POI.Inst.ClickbyText("保存");

        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.SelectData("测试充电桩ＰＯＩ１");
        assertTrue(Page_POI.Inst.isExistByName("测试充电站ＰＯＩ"));
        Page_POI.Inst.Click(Page_POI.CANCEL);

        Page_MyData.Inst.SelectData("测试充电桩ＰＯＩ２");
        assertTrue(Page_POI.Inst.isExistByName("测试充电站ＰＯＩ"));
        Page_POI.Inst.Click(Page_POI.CANCEL);
    }

    // POI：充电站添加框选子功能
    @Test
    public void test001_8_poi_charge_father_check() throws Exception {

        //创建充电站
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试充电站ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "电动汽车充电站");

        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Drag(100, 600, 100, 550, 10);

        //创建中餐馆1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试中餐馆ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");

        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Drag(100, 600, 100, 550, 10);

        //创建星级酒店2
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试星级酒店ＰＯＩ２");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "星级酒店");

        Page_POI.Inst.Click(Page_POI.SAVE);


        //进入我的数据
        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.SelectData("测试充电站ＰＯＩ");

        Page_POI.Inst.Click(Page_POI.POI_FATHER);

        Page_MainBoard.Inst.ClickbyText("     框选子POI     ");

        Thread.sleep(1000);

        Page_MainBoard.Inst.Click(new Point(500, 500));
        Page_MainBoard.Inst.Click(new Point(500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 1000));
        Page_MainBoard.Inst.Click(new Point(1500, 500));

        Page_POI.Inst.Click(Page_POI.COMPLETE);


        assertTrue(!Page_POI.Inst.isExistByName("全选"));
        assertTrue(!Page_POI.Inst.isExistByName("保存"));

    }

    //搜索模块中增加情报搜索功能
    @Test
    public void test002_1_info_search_check() throws Exception {

        // 上报情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoLine.Inst.SetValue(Page_InfoLine.NAME, "测试上报情报"); //输入情报名称
        Page_InfoLine.Inst.Click(Page_InfoLine.ROAD_TYPE);
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME); //点击选择时间
        Page_InfoLine.Inst.Click(Page_InfoLine.TIME_CONFIRM);

        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报", "测试上报情报");
        String globalId = Page_InfoLine.Inst.GetValue(Page_InfoLine.GLOBAL_ID).substring(10);
        Page_InfoLine.Inst.Click(Page_InfoLine.CANCEL);
        ExitMyData();

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);

        assertTrue(Page_POI.Inst.isExistByName("测试上报情报"));


        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK);
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, "测试上报情报");
        Page_Search.Inst.Click(Page_Search.NAME_INFO);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        assertTrue(Page_POI.Inst.isExistByName("测试上报情报"));

    }

    // POI地址录入方式优化
    @Test
    public void test003_1_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址1");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);

        assertTrue(!Page_POI.Inst.isExistByName("地址０"));
        assertTrue(!Page_POI.Inst.isExistByName("地址-１"));
        assertTrue(Page_POI.Inst.isExistByName("地址１"));
        assertTrue(Page_POI.Inst.isExistByName("地址２"));
    }

    // POI地址录入方式优化
    @Test
    public void test003_2_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址a");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);


        assertTrue(Page_POI.Inst.isExistByName("地址ａ"));
        assertTrue(Page_POI.Inst.isExistByName("地址ｂ"));
    }

    // POI地址录入方式优化
    @Test
    public void test003_3_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址A");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);

        assertTrue(Page_POI.Inst.isExistByName("地址Ａ"));
        assertTrue(Page_POI.Inst.isExistByName("地址Ｂ"));
    }

    // POI地址录入方式优化
    @Test
    public void test003_4_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址Z");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);

        assertTrue(Page_POI.Inst.isExistByName("地址Ｚ"));
        assertTrue(Page_POI.Inst.isExistByName("地址Ｙ"));

    }

    // POI地址录入方式优化
    @Test
    public void test003_5_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址z");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);


        assertTrue(Page_POI.Inst.isExistByName("地址ｚ"));
        assertTrue(Page_POI.Inst.isExistByName("地址ｙ"));

    }

    // POI地址录入方式优化
    @Test
    public void test003_6_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址E");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);

        assertTrue(Page_POI.Inst.isExistByName("地址Ｅ"));
        assertTrue(Page_POI.Inst.isExistByName("地址Ｄ"));
        assertTrue(Page_POI.Inst.isExistByName("地址Ｆ"));

    }

    // POI地址录入方式优化
    @Test
    public void test003_7_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址e");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);

        assertTrue(Page_POI.Inst.isExistByName("地址ｅ"));
        assertTrue(Page_POI.Inst.isExistByName("地址ｄ"));
        assertTrue(Page_POI.Inst.isExistByName("地址ｆ"));
    }

    @Test
    public void test003_8_poi_input_update_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.SetValue(Page_POI.ADDRESS, "地址10");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);


        Page_POI.Inst.Click(Page_POI.ADDRESS);

        assertTrue(Page_POI.Inst.isExistByName("地址９"));
        assertTrue(Page_POI.Inst.isExistByName("地址１０"));
        assertTrue(Page_POI.Inst.isExistByName("地址１１"));
    }

    //产品全貌照片设置项默认开启
    @Test
    public void test006_picture_switch_check() throws Exception {
        //产品全貌开关设置
        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.ScrollClick(Page_MainMenu.SET);

        assertTrue(Page_Set.Inst.isChecked(Page_Set.FULLVIEW));

        Page_Set.Inst.Click(Page_Set.BACK);

        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        assertTrue(Page_POI.Inst.isExistByName("产品全貌"));

    }

    //道路名专题图
    @Test
    public void test007_road_name_check() throws Exception {
        //产品全貌开关设置
        Page_MainBoard.Inst.Click(Page_MainBoard.ADAS_MODE);

        assertTrue(Page_MainBoard.Inst.isExistByName("道路名")||
                Page_MainBoard.Inst.isExistById("rb_fc_mode_five"));

    }

    //卡车交限，卡车类型验证
    @Test
    public void test005_1_truck_forbidden_kind_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片一"));


        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_SAMLL));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_MIDDLE));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_BIG));

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ADD_VIEW);


        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片二"));

        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_SAMLL));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_MIDDLE));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_BIG));


        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 250, 100);
        assertTrue(Page_TruckForbidden.Inst.isExistByName("属性卡片三"));

        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_SAMLL));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_MIDDLE));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_BIG));
    }

    //卡车交限，卡车类型验证
    @Test
    public void test005_2_truck_forbidden_kind_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_1);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.TRUCK_MIDDLE);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.TRUCK_BIG);

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车交限");


        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 800, 100);
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_SAMLL));
        assertTrue(!Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_MIDDLE));
        assertTrue(!Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_BIG));

    }

    //卡车交限，卡车类型验证
    @Test
    public void test005_3_truck_forbidden_kind_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.ICON_5);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.TRUCK_SAMLL);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.TRUCK_BIG);

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("卡车交限");


        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 800, 100);
        assertTrue(!Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_SAMLL));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_MIDDLE));
        assertTrue(!Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_BIG));

    }

    //卡车交限，卡车类型验证
    @Test
    public void test005_4_truck_forbidden_kind_check() throws Exception {
        //交限
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUCK_TRAFFIC_FORBIDDEN);
        Page_MainBoard.Inst.ClickCenter();

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.NO_PULL_INTO);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.TRUCK_SAMLL);
        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.TRUCK_MIDDLE);

        Page_TruckForbidden.Inst.Click(Page_TruckForbidden.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("禁止卡车驶入");


        Page_MainBoard.Inst.Drag(1800, 1400, 1800, 800, 100);
        assertTrue(!Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_SAMLL));
        assertTrue(!Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_MIDDLE));
        assertTrue(Page_TruckForbidden.Inst.isChecked(Page_TruckForbidden.TRUCK_BIG));

    }

    //底图号码来源验证
    @Test
    public void test008_1_road_name_check() throws Exception {
        //方向看板
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.ClickCenter();

        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.COPY);
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        Page_MainBoard.Inst.Drag(100, 400, 100, 200, 10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.ClickCenter();

        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.PASTE);
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.TIPS_TYPE);
        UiObject2 obj;

        List<UiObject2> lst = testadapter.findAllObjectsByClass("plrlv_mydata_item", "android.widget.TextView");
        //第一个方向看板
        obj = lst.get(1);
        obj.click();
        String rowkey1 = Page_DirectionBoard.Inst.GetRowKey();
        byte[] blob1 = Sqlitetools.GetDeepDataByRowkey(rowkey1);
        //第二个方向看板
        obj = lst.get(3);
        obj.click();
        String rowkey2 = Page_DirectionBoard.Inst.GetRowKey();
        byte[] blob2 = Sqlitetools.GetDeepDataByRowkey(rowkey2);

        String blobString1 = new String(blob1,"GBK");
        String blobString2 = new String(blob2,"GBK");

        assertTrue(blobString1.contains("\"ptnSrc\":0"));
        assertTrue(blobString2.contains("\"ptnSrc\":1"));

    }

    //底图号码来源验证
    @Test
    public void test008_2_road_name_check() throws Exception {
        //Real Sign
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REAL_SIGN);
        Page_MainBoard.Inst.ClickCenter();

        Page_RealSign.Inst.Click(Page_RealSign.COPY);
        Page_RealSign.Inst.Click(Page_RealSign.SAVE);

        Page_MainBoard.Inst.Drag(100, 400, 100, 200, 10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REAL_SIGN);
        Page_MainBoard.Inst.ClickCenter();

        Page_RealSign.Inst.Click(Page_RealSign.PASTE);
        Page_RealSign.Inst.Click(Page_RealSign.SAVE);

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.TIPS_TYPE);
        UiObject2 obj;

        List<UiObject2> lst = testadapter.findAllObjectsByClass("plrlv_mydata_item", "android.widget.TextView");
        //第一个方向看板
        obj = lst.get(1);
        obj.click();
        String rowkey1 = Page_RealSign.Inst.GetRowKey();
        byte[] blob1 = Sqlitetools.GetDeepDataByRowkey(rowkey1);
        //第二个方向看板
        obj = lst.get(3);
        obj.click();
        String rowkey2 = Page_RealSign.Inst.GetRowKey();
        byte[] blob2 = Sqlitetools.GetDeepDataByRowkey(rowkey2);

        String blobString1 = new String(blob1,"GBK");
        String blobString2 = new String(blob2,"GBK");

        assertTrue(blobString1.contains("\"ptnSrc\":0"));
        assertTrue(blobString2.contains("\"ptnSrc\":1"));

    }

    //底图号码来源验证
    @Test
    public void test008_3_road_name_check() throws Exception {
        //路口实景图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();

        Page_TrueSence.Inst.Click(Page_TrueSence.COPY);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        Page_MainBoard.Inst.Drag(100, 400, 100, 200, 10);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();

        Page_TrueSence.Inst.Click(Page_TrueSence.PASTE);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        Sqlitetools.RefreshData();

        GotoMyData(Page_MyData.TIPS_TYPE);
        UiObject2 obj;

        List<UiObject2> lst = testadapter.findAllObjectsByClass("plrlv_mydata_item", "android.widget.TextView");
        //第一个方向看板
        obj = lst.get(1);
        obj.click();
        String rowkey1 = Page_TrueSence.Inst.GetRowKey();
        byte[] blob1 = Sqlitetools.GetDeepDataByRowkey(rowkey1);
        //第二个方向看板
        obj = lst.get(3);
        obj.click();
        String rowkey2 = Page_TrueSence.Inst.GetRowKey();
        byte[] blob2 = Sqlitetools.GetDeepDataByRowkey(rowkey2);

        String blobString1 = new String(blob1,"GBK");
        String blobString2 = new String(blob2,"GBK");

        assertTrue(blobString1.contains("\"ptnSrc\":0"));
        assertTrue(blobString2.contains("\"ptnSrc\":1"));

    }

    //变道提示
    @Test
    public void test009_change_lane_check() throws Exception {
        SearchLocation("116.42180","39.95967");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.CHANGE_LANE_NOTICE);
        Page_MainBoard.Inst.ClickCenter();

        Page_ChangeLaneNotice.Inst.Click(Page_ChangeLaneNotice.LANE_LEFT);
        Page_ChangeLaneNotice.Inst.Click(Page_ChangeLaneNotice.LANE_CENTER);
        Page_ChangeLaneNotice.Inst.Click(Page_ChangeLaneNotice.LANE_RIGHT);

        UiObject2 obj;
        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.ImageView");
        //左
        obj = lst.get(0);
        obj.click();
        Page_MainBoard.Inst.Click(new Point(400,350));
        //中
        obj = lst.get(2);
        obj.click();
        Page_MainBoard.Inst.Click(new Point(700,200));
        //右
        obj = lst.get(4);
        obj.click();
        Page_MainBoard.Inst.Click(new Point(1000,350));

        Page_ChangeLaneNotice.Inst.Click(Page_ChangeLaneNotice.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("变道提示");

        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.RelativeLayout");
        assertTrue(lst.size() == 3);
    }

    //hov车道
    @Test
    public void test010_1_hov_lane_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HOV_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_HovLine.Inst.Click(Page_HovLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_HovLine.Inst.Click(Page_HovLine.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("HOV车道");

        assertEquals(Page_HovLine.Inst.GetValue(Page_HovLine.TIME),"请输入时间...");
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.KECHE));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.JIJIUCHE));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.GONGJIAOCHE));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.PEISONGKACHE));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.YUNSHUKACHE));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.CHUZUCHE));
        assertEquals(Page_HovLine.Inst.GetValue(Page_HovLine.MIN_TOTAL),"2");
        assertEquals(Page_HovLine.Inst.GetValue(Page_HovLine.MAX_TOTAL),"0");
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.QIYOU));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.DIANDONG));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.YOUDIANHUNDONG));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.KETIDAINENGYUAN));
        assertTrue(!Page_HovLine.Inst.isChecked(Page_HovLine.QITA));
    }

    @Test
    public void test010_2_hov_lane_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HOV_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_HovLine.Inst.Click(Page_HovLine.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);



        Page_HovLine.Inst.Click(Page_HovLine.ADD_TIME);
        Page_MainBoard.Inst.ClickByText("确定");

        //Page_HovLine.Inst.Click(Page_HovLine.KECHE);
        //Page_HovLine.Inst.Click(Page_HovLine.JIJIUCHE);
        Page_HovLine.Inst.Click(Page_HovLine.GONGJIAOCHE);
        Page_HovLine.Inst.Click(Page_HovLine.PEISONGKACHE);
        Page_HovLine.Inst.Click(Page_HovLine.YUNSHUKACHE);
        Page_HovLine.Inst.Click(Page_HovLine.CHUZUCHE);

        Page_HovLine.Inst.Click(Page_HovLine.QIYOU);
        Page_HovLine.Inst.Click(Page_HovLine.DIANDONG);
        Page_HovLine.Inst.Click(Page_HovLine.YOUDIANHUNDONG);
        Page_HovLine.Inst.Click(Page_HovLine.KETIDAINENGYUAN);
        Page_HovLine.Inst.Click(Page_HovLine.QITA);


        Page_HovLine.Inst.SetValue(Page_HovLine.MIN_TOTAL,"1");
        Page_HovLine.Inst.SetValue(Page_HovLine.MAX_TOTAL,"3");

        Page_HovLine.Inst.Click(Page_HovLine.SAVE);

        Page_HovLine.Inst.SetValue(Page_HovLine.MIN_TOTAL,"100");
        Page_HovLine.Inst.SetValue(Page_HovLine.MAX_TOTAL,"201");

        Page_HovLine.Inst.Click(Page_HovLine.SAVE);

        Page_HovLine.Inst.SetValue(Page_HovLine.MIN_TOTAL,"100");
        Page_HovLine.Inst.SetValue(Page_HovLine.MAX_TOTAL,"99");

        Page_HovLine.Inst.Click(Page_HovLine.SAVE);

        Page_HovLine.Inst.SetValue(Page_HovLine.MIN_TOTAL,"100");
        Page_HovLine.Inst.SetValue(Page_HovLine.MAX_TOTAL,"101");

        Page_HovLine.Inst.Click(Page_HovLine.SAVE);


        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("HOV车道");


        assertEquals(Page_HovLine.Inst.GetValue(Page_HovLine.TIME),"06:00~20:00;");
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.KECHE));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.JIJIUCHE));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.GONGJIAOCHE));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.PEISONGKACHE));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.YUNSHUKACHE));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.CHUZUCHE));
        assertEquals(Page_HovLine.Inst.GetValue(Page_HovLine.MIN_TOTAL),"100");
        assertEquals(Page_HovLine.Inst.GetValue(Page_HovLine.MAX_TOTAL),"101");
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.QIYOU));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.DIANDONG));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.YOUDIANHUNDONG));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.KETIDAINENGYUAN));
        assertTrue(Page_HovLine.Inst.isChecked(Page_HovLine.QITA));
    }

    //公交优先车道
    @Test
    public void test011_1_bus_priority_lane_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUS_PRIORITY_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_BusPriorityLane.Inst.Click(Page_BusPriorityLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_BusPriorityLane.Inst.Click(Page_BusPriorityLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("公交优先车道");

        assertEquals(Page_BusPriorityLane.Inst.GetValue(Page_BusPriorityLane.TIME),"请输入时间...");

    }

    @Test
    public void test011_2_bus_priority_lane_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.BUS_PRIORITY_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_BusPriorityLane.Inst.Click(Page_BusPriorityLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_MainBoard.Inst.Click(new Point(105, 320));
        Page_MainBoard.Inst.Click(new Point(260, 320));
        Page_MainBoard.Inst.Click(new Point(1305, 320));

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //第1个增加时间
        obj = lst.get(3);
        obj.click();
        Page_MyData.Inst.ClickbyText("确定");

        Page_BusPriorityLane.Inst.Click(Page_BusPriorityLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("公交优先车道");

        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.EditText");

        //第1个时间
        obj = lst.get(0);
        assertEquals(obj.getText(),"06:00~20:00;");

        //第2个时间
        obj = lst.get(1);
        assertEquals(obj.getText(),"请输入时间...");

    }


    //借道左转
    @Test
    public void test012_1_turn_left_lane_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TURN_LEFT_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("借道左转车道");

        assertEquals(Page_TurnLeftLane.Inst.GetValue(Page_TurnLeftLane.TIME),"请输入时间...");

    }

    @Test
    public void test012_2_turn_left_lane_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TURN_LEFT_LANE);
        Page_MainBoard.Inst.Click(new Point(950, 750));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.CHOOSE_END);
        Page_MainBoard.Inst.Click(new Point(1000, 750));
        Page_MainBoard.Inst.Drag(100, 450, 1340, 450, 50);
        //Page_MainBoard.Inst.Click(new Point(100, 300));
        Page_MainBoard.Inst.Click(new Point(105, 320));
        Page_MainBoard.Inst.Click(new Point(260, 320));
        Page_MainBoard.Inst.Click(new Point(1305, 320));

        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);

        Page_MainBoard.Inst.Click(new Point(105, 320));
        Page_MainBoard.Inst.Click(new Point(260, 320));
        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);

        Page_MainBoard.Inst.Click(new Point(180, 320));
        Page_MainBoard.Inst.Click(new Point(1305, 320));

        List<UiObject2> lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.TextView");

        UiObject2 obj;

        //第1个增加时间
        obj = lst.get(3);
        obj.click();
        Page_MyData.Inst.ClickbyText("确定");

        Page_TurnLeftLane.Inst.Click(Page_TurnLeftLane.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.SelectData("借道左转车道");

        lst = testadapter.findAllObjectsByClass("tips_fragment_content", "android.widget.EditText");

        //第1个时间
        obj = lst.get(0);
        assertEquals(obj.getText(),"06:00~20:00;");

        //第2个时间
        obj = lst.get(1);
        assertEquals(obj.getText(),"请输入时间...");

    }

    //红绿灯受控
    @Test
    public void test013_traffic_light_control_check() throws Exception {
        SearchLocation(LOC_K7);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT_CONTROL);

        Page_MainBoard.Inst.ClickCenter();
        Page_LightControl.Inst.Click(Page_LightControl.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("红绿灯受控退出信息");
        String infoRowkey = Page_LightControl.Inst.GetValue(Page_LightControl.ROWKEY).replace("rowkey:","").replace("rowkey：","");
        Page_LightControl.Inst.Click(Page_LightControl.CANCEL);
        ExitMyData();

        IndoorCheckConfirm("红绿灯受控退出信息");

        //同步数据
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        Sqlitetools.CleanDataAndRestart();

        SearchLocation(LOC_K7);
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("Tips");
        Page_Search.Inst.SetValue(Page_Search.TIPS_ROWKEY, infoRowkey);

        Page_Search.Inst.Click(Page_Search.SEARCH_START_TIPS);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        Page_LightControl.Inst.isExistByName(infoRowkey);

    }

    //红绿灯受控港澳联调
    @Test
    public void test013_hm_traffic_light_control_check() throws Exception {
        SearchLocation("113.99998", "22.36867");
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRAFFIC_LIGHT_CONTROL);

        Page_MainBoard.Inst.ClickCenter();
        Page_LightControl.Inst.Click(Page_LightControl.SAVE);

        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("红绿灯受控退出信息");
        String infoRowkey = Page_LightControl.Inst.GetValue(Page_LightControl.ROWKEY).replace("rowkey:","").replace("rowkey：","");
        Page_LightControl.Inst.Click(Page_LightControl.CANCEL);
        ExitMyData();

        IndoorCheckConfirm("红绿灯受控退出信息");

        //同步数据
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        Sqlitetools.CleanDataAndRestart();

        SearchLocation(LOC_K7);
        synchronize_zhou(Page_GridManager.TIPS_UPDATE);

        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("Tips");
        Page_Search.Inst.SetValue(Page_Search.TIPS_ROWKEY, infoRowkey);

        Page_Search.Inst.Click(Page_Search.SEARCH_START_TIPS);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        Page_LightControl.Inst.isExistByName(infoRowkey);

    }

    //障碍物类型
    @Test
    public void test014_obstruction_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点

        Page_AddPoint.Inst.Click(Page_AddPoint.OBST);
        Page_MainBoard.Inst.ClickCenter();

        Page_AddPoint.Inst.Click(Page_AddPoint.VEHICLE);
        Page_AddPoint.Inst.Click(Page_AddPoint.MANPOWER_BICYCLE);
        Page_AddPoint.Inst.Click(Page_AddPoint.TRICYCLE);
        Page_AddPoint.Inst.Click(Page_AddPoint.ELECTRIC_BICYCLE);
        Page_AddPoint.Inst.Click(Page_AddPoint.PEDESTRIAN);

        Page_AddPoint.Inst.Click(Page_AddPoint.SAVE);


        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("障碍物");
        assertFalse(Page_AddPoint.Inst.isChecked(Page_AddPoint.VEHICLE));
        assertTrue(Page_AddPoint.Inst.isChecked(Page_AddPoint.MANPOWER_BICYCLE));
        assertTrue(Page_AddPoint.Inst.isChecked(Page_AddPoint.TRICYCLE));
        assertTrue(Page_AddPoint.Inst.isChecked(Page_AddPoint.ELECTRIC_BICYCLE));
        assertTrue(Page_AddPoint.Inst.isChecked(Page_AddPoint.PEDESTRIAN));

    }

    //人渡轮渡时间限制
    @Test
    public void test015_ferry_time_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FERRY_TIME);

        Page_MainBoard.Inst.ClickCenter();

        Page_FerryTime.Inst.Click(Page_FerryTime.ADD_TIME);
        Page_MainBoard.Inst.ClickByText("确定");
        Page_FerryTime.Inst.Click(Page_FerryTime.SAVE);


        GotoMyData(Page_MyData.TIPS_TYPE); //进入我的数据
        Page_MyData.Inst.SelectData("人渡轮渡时间限制");

        assertEquals("06:00~20:00;", Page_FerryTime.Inst.GetValue(Page_FerryTime.TIME));

    }


    // 上报情报
    public void addReport(String infoType) throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(Page_MainBoard.REPORT); //点上报
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO); //点击点情报
        Thread.sleep(1000);
        Page_MainBoard.Inst.Click(new Point(900, 500)); //点击情报位置

        Page_InfoPoint.Inst.SetValue(Page_InfoPoint.NAME, "测试上报情报6"); //输入情报名称
        Page_InfoPoint.Inst.Click(infoType);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.LEVEL_1);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME); //点击选择时间
        Page_InfoPoint.Inst.Click(Page_InfoPoint.TIME_CONFIRM);

        Page_InfoPoint.Inst.Click(Page_InfoPoint.CAMERA);//拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//点击拍照
        Thread.sleep(2000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);//点击返回


        Page_InfoPoint.Inst.Click(Page_InfoPoint.SAVE); //点击保存

        //获取globalID
        GotoMyData(Page_MyData.INFO_TYPE); //进入我的数据,自采集情报
        Page_MyData.Inst.ClickbyText("测试上报情报6", "测试上报情报6");
        globalId = Page_InfoPoint.Inst.GetValue(Page_InfoPoint.GLOBAL_ID).substring(10);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
        ExitMyData(); //退出我的数据

    }


    // 采纳情报
    public void accept() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        //检索情报
        Page_MainBoard.Inst.Click(Page_MainBoard.SEARCH);
        Page_Search.Inst.ClickbyText("情报");
        Page_Search.Inst.SetValue(Page_Search.EDITINFO, globalId);
        Page_Search.Inst.Click(Page_Search.SEARCH_START_INFO);
        Page_SearchResultList.Inst.Click(Page_SearchResultList.DATA_LIST);

        //采纳情报
        Page_InfoPoint.Inst.ClickbyText("采纳"); //点击采纳
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC); //点击拍照
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK); //点击返回
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");//点击选择分类

        infoFid = Page_POI.Inst.GetValue(Page_POI.FID);

        Page_POI.Inst.Click(Page_POI.SAVE); //点击保存
        Page_SearchResultList.Inst.Click(Page_SearchResultList.BACK); //点击返回
    }

    // 检查情报fid
    public void checkFid() throws InterruptedException, NoSuchFieldException, ClassNotFoundException {

        GotoMyData(Page_MyData.POI_TYPE); //进入我的数据

        Page_MyData.Inst.ClickbyText("测试上报情报６");

        String strFid = "";
        try {
            strFid = Page_POI.Inst.GetValue(Page_POI.FID);
            Page_POI.Inst.Click(Page_POI.CANCEL);
            ExitMyData();
        } catch (Exception e) {
            e.printStackTrace();
        }

        assertEquals(infoFid, strFid);
    }

    private static String globalId = "";
    private static String infoFid = "";

}