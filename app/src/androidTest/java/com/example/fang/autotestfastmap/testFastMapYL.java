package com.example.fang.autotestfastmap;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.Point;
import com.fang.testAdapter.Sqlitetools;
import com.fastmap.ui.Page_AddPoint;
import com.fastmap.ui.Page_BuildingArea;
import com.fastmap.ui.Page_ConditionSpeedLimit;
import com.fastmap.ui.Page_Dangerous;
import com.fastmap.ui.Page_DirectionBoard;
import com.fastmap.ui.Page_ElecEye;
import com.fastmap.ui.Page_FunctionalArea;
import com.fastmap.ui.Page_Gate;
import com.fastmap.ui.Page_Gradient;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_HighSpeedDivider;
import com.fastmap.ui.Page_HighSpeedEntryPic;
import com.fastmap.ui.Page_IndoorMyData;
import com.fastmap.ui.Page_IndoorTools;
import com.fastmap.ui.Page_InfoAccept;
import com.fastmap.ui.Page_InfoFrame;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_InfoPoint;
import com.fastmap.ui.Page_Kind;
import com.fastmap.ui.Page_LaneChangePoint;
import com.fastmap.ui.Page_LaneInfo;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MilePost;
import com.fastmap.ui.Page_MultiList;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_NoParking;
import com.fastmap.ui.Page_NoParkingTruck;
import com.fastmap.ui.Page_NormalCrossPic;
import com.fastmap.ui.Page_Note;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_RealSign;
import com.fastmap.ui.Page_RoadName;
import com.fastmap.ui.Page_RoadNameSign;
import com.fastmap.ui.Page_RoundAbout;
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
import com.fastmap.ui.Page_VariableSpeedLimit;
import com.fastmap.ui.Page_VehicleLane;

import org.json.JSONArray;
import org.json.JSONObject;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static junit.framework.Assert.assertEquals;
import static junit.framework.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapYL extends testFastMapBase
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {
        //testFastMapBase.setClassUp("zhanglingling03655","036550");
    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {
    }

    @Before
    public void setUp() throws Exception {
//        testFastMapBase.setClassUp("collector1","123456");
//        Page_MainBoard.Inst.ClickCenter();
        //testFastMapBase.setClassUp("zhanglingling03655","036550");
       testFastMapBase.setClassUp("duxuejun01540","015400");
        //testFastMapBase.setClassUp("wukunyu02074","wy0207402815");
    }

    @After
    public  void setAfter() //throws IOException, InterruptedException
    {
        //super.setAfter();
    }

    @Test
    public void test00202_poi_add() throws Exception
    {
        //产品全貌开关关，新增POI点查看相机设置
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
    public void test00203_poi_add() throws Exception
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
    public void test00205_poi_add() throws Exception
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
    public void test00206_poi_add() throws Exception
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
    public void test00208_poi_add() throws Exception
    {

        String[][] attrib= {
                {Page_POI.NAME, "紧急停车带"},
                {Page_POI.SELECT_TYPE, "紧急停车带"}
        };
        AddPOI(attrib);

        CheckMyData(Page_MyData.POI_TYPE, "紧急停车带");
    }

    @Test
    public void test00209_poi_add() throws Exception
    {
        //POI 彩票投注站
        String[][] attrib= {
                {Page_POI.NAME, "彩票投注站"},
                {Page_POI.SELECT_TYPE, "彩票投注站"}
        };
        AddPOI(attrib);

        //我的数据
        CheckMyData(Page_MyData.POI_TYPE, "彩票投注站");
    }

    @Test
    public void test00210_poi_relationship() throws Exception
    {
        String[][] attrib1 = {{Page_POI.NAME, "大厦ＴＥＳＴ１"},
                {Page_POI.SELECT_TYPE, "大厦/写字楼"}};
        String infoFid =AddPOI(attrib1);


        String[][] attrib2 = {{Page_POI.NAME, "中餐馆ＴＥＳＴ１"},
                {Page_POI.SELECT_TYPE, "中餐馆"},
                {Page_POI.POI_FATHER, "大厦ＴＥＳＴ１"}};

        AddPOI(attrib2);

        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();
        Page_MultiList.Inst.ClickbyText("中餐馆ＴＥＳＴ１");
        Page_POI.Inst.Click(Page_POI.TOTAL_NAME);
        String temp = Page_POI.Inst.GetValue(Page_POI.NAME);
        assertEquals(temp, "大厦ＴＥＳＴ１-中餐馆ＴＥＳＴ１");
        Thread.sleep(3000);
        Page_POI.Inst.Click(Page_POI.TOTAL_NAME);
        temp = Page_POI.Inst.GetValue(Page_POI.NAME);
        assertEquals(temp, "中餐馆ＴＥＳＴ１");

        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test00211_poi_add() throws Exception
    {
        //卡车标识原则
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "收费站");
        String strTruck = Page_POI.Inst.GetValue(Page_POI.POI_TRUCK);
        //assertEquals("卡车+小汽车",strTruck);
        assertEquals("非卡车",strTruck);
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        int truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
        assertSame(0,truck);
    }

//    @Test
//    public void test00212_poi_add() throws Exception
//    {
//        //卡车标识原则 先在元数据库sc_point_truck中插入一条数据
//        //insert into SC_POINT_TRUCK values(37,"中餐馆","110101","澳门豆捞","304D","0","NULL",3,1)
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//
//        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ２");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_BRAND,"澳门豆捞");
//        String strTruck = Page_POI.Inst.GetValue(Page_POI.POI_TRUCK);
//        assertEquals("仅卡车",strTruck);
//        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        Sqlitetools.RefreshData();
//        int truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
//        assertSame(1,truck);
//    }

    @Test
    public void test00213_poi_add() throws Exception
    {
        //卡车标识原则 加油站  柴油
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ３");
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "加油站");
        String strTruck = Page_POI.Inst.GetValue(Page_POI.POI_TRUCK);
        assertEquals("非卡车",strTruck);
        Page_POI.Inst.Drag(1813,1272,1813,412,5);
        Page_POI.Inst.Drag(1813,1272,1813,412,5);
        Page_POI.Inst.Click(Page_POI.DIESEL);//柴油

        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        int truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
        assertSame(1,truck);
    }

    @Test
    public void test00214_poi_add() throws Exception
    {
        //卡车标识原则 加油站  柴油
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ４");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "厂家一览表外汽车零售及修理");
        Page_POI.Inst.SetValue(Page_POI.SELECT_BRAND,"一汽解放");
        String strTruck = Page_POI.Inst.GetValue(Page_POI.POI_TRUCK);
        assertEquals("仅卡车",strTruck);
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        int truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
        assertSame(1,truck);
    }

    @Test
    public void test00215_poi_add() throws Exception
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00216_poi_add() throws Exception
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
    public void test00217_poi_add() throws Exception
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
        synchronize(Page_GridManager.POI_UPDATE);

        Sqlitetools.RefreshData();
        int commitHisStatus = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"commitHisStatus");
        assertSame(0,commitHisStatus);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test00218_poi_add() throws Exception
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
        Page_POI.Inst.ClickbyText("无");
        Page_POI.Inst.Click(Page_POI.SAVE);

        synchronize(Page_GridManager.POI_UPDATE);
        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        assertFalse(Page_POI.Inst.isExistByName(Page_POI.SELECT_TYPE));
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test00219_poi_add() throws Exception
    {
        //充电桩 充电站不允许跨大分类
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "充电站");
        Page_POI.Inst.Click(Page_POI.SAVE);

        synchronize(Page_GridManager.POI_UPDATE);
        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("测试ＰＯＩ");
        assertFalse(Page_POI.Inst.isExistByName(Page_POI.SELECT_TYPE));
        Page_POI.Inst.Click(Page_POI.SAVE);
    }

    @Test
    public void test00221_poi_add() throws Exception
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
    public void test00222_poi_relationship_Tag() throws Exception
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

//    @Test
//    public void test00223_poi_relationship_Tag() throws Exception
//    {
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        //新增是切换tag页
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
//        Thread.sleep(3000);
//        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
//        Page_POI.Inst.SetValue(Page_POI.NAME,"小区");
//        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "120201");
//        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
//        Page_POI.Inst.Drag(1796,1241,1796,336,5);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.FEEDBACK4);
//        Page_POI.Inst.Click(Page_POI.TAG2);
//        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
//        Page_POI.Inst.Click(Page_POI.FEEDBACK1);
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK4));
//        Page_POI.Inst.Click(Page_POI.TAG2);
//        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK1));
//        Page_POI.Inst.Click(Page_POI.TAG1);
//        Page_POI.Inst.Click(Page_POI.SAVE);
//
//        infoFid = infoFid.replace("fid:", "");
//        infoFid = infoFid.replace("fid : ", "");
//
//        Sqlitetools.RefreshData();
//        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
//        assertSame(1,fineFlag);
//        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
//        assertSame(4,fineFeedback);
//    }

    @Test
    public void test00224_poi_relationship_Tag() throws Exception
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
        assertFalse(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.FEEDBACK0);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.FEEDBACK1);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK1));
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK4);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK4));
        Page_POI.Inst.Click(Page_POI.TAG2);
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK1));
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(4,fineFeedback);
    }

    @Test
    public void test00225_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00226_poi_relationship_Tag() throws Exception
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
        AddPOI(attribs);

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
    public void test00227_poi_relationship_Tag() throws Exception
    {
        //有子有父
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00228_poi_relationship_Tag() throws Exception
    {
        //有子有父删除子
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00229_poi_relationship_Tag() throws Exception
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
//    public void test00230_poi_relationship_Tag() throws Exception
//    {
//        //框选子
//        String[][] attrib1 = {{Page_POI.NAME, "中餐馆"},
//                {Page_POI.SELECT_TYPE, "110101"}};
//        AddPOI(attrib1);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00231_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00232_poi_relationship_Tag() throws Exception
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
        AddPOI(attribs);

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
    public void test00233_poi_relationship_Tag() throws Exception
    {
        //有子有父
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00234_poi_relationship_Tag() throws Exception
    {
        //有子有父删除子
        String[][] attrib1 = {{Page_POI.NAME, "住宅楼"},
                {Page_POI.SELECT_TYPE, "120202"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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

        Sqlitetools.RefreshData();
        fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test00235_poi_relationship_Tag() throws Exception
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
            //    public void test00236_poi_relationship_Tag() throws Exception
            //    {
            //        //框选子
            //        String[][] attrib1 = {{Page_POI.NAME, "中餐馆"},
            //                {Page_POI.SELECT_TYPE, "110101"}};
            //        AddPOI(attrib1);
            //
            //        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
            //        try
            //        {
            //            Thread.sleep(1000);
            //            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00237_poi_relationship_Tag() throws Exception
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
    public void test00238_poi_relationship_Tag() throws Exception
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
    public void test00239_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        Page_POI.Inst.ClickbyText("已采集");
        Page_POI.Inst.Click(Page_POI.SAVE);



        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    }



    @Test
    public void test00240_poi_relationship_Tag() throws Exception
    {
        //有子无父
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        //Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.Click(Page_POI.DOOR);
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("工业园区");//一定会报错，手动测试一下
        Page_POI.Inst.Click(Page_POI.SAVE);



        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("工业园区");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        Page_POI.Inst.Click(Page_POI.TAG1);
        Page_POI.Inst.Click(Page_POI.FEEDBACK2);
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(1,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(2,fineFeedback);
    }

    @Test
    public void test00241_poi_relationship_Tag() throws Exception
    {
        //有子有父
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        Page_POI.Inst.Click(Page_POI.DOOR);
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.Click(Page_POI.POPCLOSE);
        Page_POI.Inst.ClickbyText("工业园区");//一定会报错，手动测试一下
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("工业园区");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);//之前有过精细化状态  已采集  无
        Thread.sleep(1000);

        Page_MyData.Inst.ClickbyText("工业园区");
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
    public void test00242_poi_relationship_Tag() throws Exception
    {
        //有子有父删除子
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
        }
        catch (Exception e)
        {

        }
        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Thread.sleep(2000);
        Page_POI.Inst.SetValue(Page_POI.NAME,"工业园区");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "220300");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");
        Page_POI.Inst.Click(Page_POI.SAVE);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        Page_POI.Inst.Click(Page_POI.DOOR);
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.Click(Page_POI.POPCLOSE);
        Page_POI.Inst.ClickbyText("工业园区");//一定会报错，手动测试一下
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("工业园区");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区");
        Page_POI.Inst.Click(Page_POI.SAVE);
        Thread.sleep(1000);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("工业园区");
        Page_POI.Inst.Drag(1759,1259,1759,600,5);
        //Page_MainBoard.Inst.Drag(1759,1259,1759,600,5);
        assertFalse(Page_POI.Inst.isExistByName("未采集"));
        Page_POI.Inst.Click(Page_POI.SAVE);

        Sqlitetools.RefreshData();
        int fineFlag = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFlag");
        assertSame(0,fineFlag);
        int fineFeedback = (int)Sqlitetools.GetPoisDataByRowKey(infoFid,"fineFeedback");
        assertSame(0,fineFeedback);
    }

    @Test
    public void test00243_poi_relationship_Tag() throws Exception
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
//    public void test00244_poi_relationship_Tag() throws Exception
//    {
//        //框选子
//        String[][] attrib1 = {{Page_POI.NAME, "中餐馆"},
//                {Page_POI.SELECT_TYPE, "110101"}};
//        AddPOI(attrib1);
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
    public void test00245_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00246_poi_relationship_Tag() throws Exception
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
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");



        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        Page_MyData.Inst.ClickbyText("中餐馆");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("删除父子关系");
        Page_POI.Inst.ClickbyText("是");
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MyData.Inst.ClickbyText("综合医院");
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
    public void test00247_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00248_poi_relationship_Tag() throws Exception
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
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");



        String[][] attrib1 = {{Page_POI.NAME, "医疗机构"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00249_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        String[][] attrib1 = {{Page_POI.NAME, "教学楼１"},
                {Page_POI.SELECT_TYPE, "170100"}};
        AddPOI(attrib1);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
//    public void test00250_poi_relationship_Tag() throws Exception
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
//        AddPOI(attrib1);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
//    public void test00251_poi_relationship_Tag() throws Exception
//    {
//        //小区有父无子 不展示精细化卡片
//        String[][] attrib1 = {{Page_POI.NAME, "度假村"},
//                {Page_POI.SELECT_TYPE, "180302"}};
//        AddPOI(attrib1);
//
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
//        try
//        {
//            Thread.sleep(1000);
//            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00252_poi_relationship_Tag() throws Exception
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
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        String[][] attrib1 = {{Page_POI.NAME, "度假村"},
                {Page_POI.SELECT_TYPE, "180302"}};
        AddPOI(attrib1);


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00253_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00254_poi_relationship_Tag() throws Exception
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
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");


        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    public void test00255_poi_relationship_Tag() throws Exception
    {
        //小区有父无子 不展示精细化卡片
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
    @Test
    public void test00256_poi_relationship_Tag() throws Exception
    {
        //综合医院 有父有子删除子
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);

        //拍照并返回
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.SetValue(Page_POI.NAME,"会展中心");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "200101");
        String infoFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.ClickbyText("已采集");
        assertTrue(Page_POI.Inst.isChecked(Page_POI.FEEDBACK0));
        Page_POI.Inst.Click(Page_POI.SAVE);

        infoFid = infoFid.replace("fid:", "");
        infoFid = infoFid.replace("fid : ", "");

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        Page_POI.Inst.Drag(1796,1241,1796,336,5);
        Page_POI.Inst.Click(Page_POI.TAG2);
        Page_POI.Inst.Click(Page_POI.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        try
        {
            Thread.sleep(1000);
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        Page_POI.Inst.Click(Page_POI.DOOR);
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.Click(Page_POI.POPCLOSE);
        Page_POI.Inst.Click(Page_POI.FAILNAME);//报错，手动测试
        assertEquals("会展中心",Page_POI.POI_FATHER);
        //Page_POI.Inst.ClickbyText("会展中心");
        Page_POI.Inst.Click(Page_POI.SAVE);

        GotoMyData(Page_MyData.POI_TYPE);
        Page_MyData.Inst.ClickbyText("会展中心");
        Page_POI.Inst.Click(Page_POI.POI_FATHER);
        Page_POI.Inst.ClickbyText("     建立父POI     ");
        Page_POI.Inst.ClickbyText("小区");
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

        Page_MyData.Inst.ClickbyText("会展中心");
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

    @Test @IMPORTANT
    public void test00702_info_Point_testPath() throws Exception
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

        synchronize(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        //部分采纳
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT);
        Page_InfoAccept.Inst.Click(Page_InfoAccept.CONFRIM);
        Page_MainBoard.Inst.Click(Page_MainBoard.POINT_INFO);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
    }

    @Test @IMPORTANT
    public void test00802_info_Line_testPath() throws Exception
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
        synchronize(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        //搜索获取同步后自采集情报信息
        //部分采纳
        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT);
        Page_InfoAccept.Inst.Click(Page_InfoAccept.CONFRIM);
        Page_MainBoard.Inst.Click(Page_MainBoard.LINE_INFO);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
    }

    @Test @IMPORTANT
    public void test00902_info_Frame_testPath() throws Exception
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

        synchronize(Page_GridManager.INFO_UPDATE);

        SearchInfos(globalId);

        Page_InfoAccept.Inst.Click(Page_InfoAccept.PART_ACCEPT);
        Page_InfoAccept.Inst.Click(Page_InfoAccept.CONFRIM);
        Page_MainBoard.Inst.Click(Page_MainBoard.FRAME_INFO);
        Page_InfoPoint.Inst.Click(Page_InfoPoint.CANCEL);
    }

    @Test @IMPORTANT
    public void test01003_info_roadnamesign_add() throws Exception
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
    public void test01004_info_roadnamesign_add() throws Exception
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
  public void test01007_tips_roadnamesign_add() throws Exception
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
    public void test01008_info_roadnamesign_add() throws Exception
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
    public void test01010_tips_roadnamesign_add() throws Exception
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
    public void test01012_tips_roadnamesign_add() throws Exception
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
    public void test01013_tips_roadnamesign_add() throws Exception
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
    public void test01014_tips_roadnamesign_add() throws Exception
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
    public void test01015_tips_roadnamesign_add() throws Exception
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
    public void test01016_tips_roadnamesign_add() throws Exception
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
//    public void test01041_data_check() throws Exception
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
//    public void test010400_data_check() throws Exception
//    {
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//
//        AddPOI(attrib);
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
//    public void test010401_data_check() throws Exception
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
//    public void test010402_data_check() throws Exception
//    {
//        String[][] attrib= {
//                {Page_POI.NAME, "测试"},
//                {Page_POI.SELECT_TYPE, "中餐馆"}
//        };
//        AddPOI(attrib);
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
//    public void test010403_data_check() throws Exception
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
//        AddPOI(attrib);
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
//    public void test010404_data_check() throws Exception
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
//    public void test010405_data_check() throws Exception
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
//        AddPOI(attrib);
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
    public void test01042_data_check() throws Exception
    {
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
    public void test01043_data_check() throws Exception
    {
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
    public void test01044_data_check() throws Exception
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
    public void test01045_data_check() throws Exception
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
    public void test01046_data_check() throws Exception
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
//    public void test01047_data_check() throws Exception
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
    public void test01048_data_check() throws Exception
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
    public void test01049_data_check() throws Exception
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
    public void test01050_data_check() throws Exception
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
    public void test01052_data_check() throws Exception
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
    public void test01053_data_check() throws Exception
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

        Page_POI.Inst.ScrollClick(Page_POI.PERSION_GATE);
        Page_POI.Inst.Click(Page_POI.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-7","","");
    }

    @Test
    public void test01054_data_check() throws Exception
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

        Page_POI.Inst.ScrollClick(Page_POI.PERSION_GATE);
        Page_POI.Inst.Click(Page_POI.SAVE);

        AssertIndoorCheck("大门","中","FM-1104-6-7","","不能忽视");
    }

    @Test
    public void test01055_data_check() throws Exception
    {
        //测线与隧道tips相交时，需要制作立交
    	SearchLocation(LOC_K7);

        //在此link上创建隧道
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.StartEndPoint);
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.TUNNEL_BT);//隧道位置（起终点的）
        Page_MainBoard.Inst.Click(new Point(1280, 560));
        Page_StartEndPoint.Inst.Click(Page_StartEndPoint.SAVE);//起终点

        SearchLocation(LOC_K7);

        //绘制测线与含有隧道的link相交
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1310, 1410));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        AssertIndoorCheck("测线","中","FM-2001-5-9","新测线与隧道属性道路相交，需要制作立交","不能忽视");
    }

    @Test
    public void test01056_data_check() throws Exception
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
    public void test01059_data_check() throws Exception
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
    public void test01060_data_check() throws Exception
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
    public void test01061_data_check() throws Exception
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
    public void test01062_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign(",,", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01063_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("..", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01064_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("??", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01065_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("$$", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01066_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("、、", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01067_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("，，", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01068_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("．．", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01069_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("？？", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01070_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("＄＄", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }

    @Test
    public void test01071_data_check() throws Exception
    {
        //道路名标牌中不能含 $，。？、字符（包含全半角）
        AddRoadNameSign("、、", "116.42297", "39.96604");

        AssertIndoorCheck("Tips内容值域检查","高","FM-1122-2-4","道路名中不能含 $，。？、字符（包含全半角）","不能忽略");
    }
    @Test
    public void test01072_data_check() throws Exception
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
    public void test01073_data_check() throws Exception
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
    public void test01074_data_check() throws Exception
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
    public void test01075_data_check() throws Exception
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
    public void test01076_data_check() throws Exception
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
    public void test01077_data_check() throws Exception
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
    public void test01078_data_check() throws Exception
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
    public void test01079_data_check() throws Exception
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
    public void test01080_data_check() throws Exception
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
    public void test01081_data_check() throws Exception
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
    public void test01082_data_check() throws Exception
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
    public void test01083_data_check() throws Exception
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
    public void test01084_data_check() throws Exception
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
    public void test01085_data_check() throws Exception
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
    public void test01086_data_check() throws Exception
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
    public void test01087_data_check() throws Exception
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
    public void test01088_data_check() throws Exception
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
    public void test01089_data_check() throws Exception
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
    public void test01090_data_check() throws Exception
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
    public void test01091_data_check() throws Exception
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
    public void test01092_data_check() throws Exception
    {
        //卡车交限 测线9
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
    public void test01093_data_check() throws Exception
    {
        //卡车交限 测11 种别6
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        //DrawRoad(LinePoints, Page_SurveyLine.PEOPLE_CROSS_RD);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEOPLE_CROSS_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(2000);
        Page_Kind.Inst.Click(Page_Kind.COUNTY_RD);
        Thread.sleep(1000);

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
    public void test01094_data_check() throws Exception
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
    public void test01095_data_check() throws Exception
    {
        //卡车交限 测线10
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.Click(LinePoints[0]);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);

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
    public void test01096_data_check() throws Exception
    {
        //卡车交限 测10 种别4
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.KIND);
        Page_MainBoard.Inst.Click(LinePoints[1]);
        Thread.sleep(2000);
        Page_Kind.Inst.Click(Page_Kind.PROVINCIAL_RD);
        Thread.sleep(1000);

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
    public void test01058_data_check() throws Exception
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
    public void test01101_tips_CarInfo_add() throws Exception
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
    public void test01104_tips_CarInfo_add() throws Exception
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
    public void test01105_tips_CarInfo_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.T);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test01106_tips_CarInfo_add() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.LANE_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_LaneInfo.Inst.Click(Page_LaneInfo.MORE);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.X);
        Page_LaneInfo.Inst.Click(Page_LaneInfo.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "车信");
    }

    @Test
    public void test01107_tips_CarInfo_add() throws Exception
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
    public void test01108_tips_CarInfo_add() throws Exception
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
    public void test01109_tips_CarInfo_add() throws Exception
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
    public void test01110_tips_CarInfo_add() throws Exception
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
    public void test01111_tips_CarInfo_add() throws Exception
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
    public void test01112_tips_CarInfo_add() throws Exception
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
    public void test01113_tips_CarInfo_add() throws Exception
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
    public void test01114_tips_CarInfo_add() throws Exception
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
    public void test01115_tips_CarInfo_add() throws Exception
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
    public void test01116_tips_CarInfo_add() throws Exception
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
    public void test01117_tips_CarInfo_add() throws Exception
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
    public void test01118_tips_CarInfo_add() throws Exception
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
    public void test01119_tips_CarInfo_add() throws Exception
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
    public void test01148_tips_CarInfo_close() throws Exception
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
    public void test01201_tips_add_Click() throws Exception
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
    public void test01203_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DANGEROUS_INFO);
        Page_MainBoard.Inst.ClickCenter();

        Page_Dangerous.Inst.Click(Page_Dangerous.ICON_1);
        Page_Dangerous.Inst.Click(Page_Dangerous.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"危险信息");
    }

    @Test @IMPORTANT
    public void test01204_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TOLLGATE);
        Page_MainBoard.Inst.ClickCenter();

        Page_TollGate.Inst.ClickByText("领卡");
        Page_TollGate.Inst.Click(Page_TollGate.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"收费站");
    }

    @Test @IMPORTANT
    public void test01208_tips_add_Click() throws Exception
    {
        //单击手动设置点位信息，新增普通路口模式图
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.NORMAL_CROSSROAD_PICTURE);
        Page_MainBoard.Inst.ClickCenter();

        Page_NormalCrossPic.Inst.ClickByText("73100000");
        Page_NormalCrossPic.Inst.Click(Page_NormalCrossPic.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE,"普通路口模式图");
    }


    @Test @IMPORTANT
    public void test01209_tips_add_Click() throws Exception
    {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_ENTRY_MODE_PICTURE);
        Page_MainBoard.Inst.ClickCenter();

        Page_HighSpeedEntryPic.Inst.Click(Page_HighSpeedEntryPic.SAVE);
        CheckMyData(Page_MyData.TIPS_TYPE,"高速入口模式图");
    }

    @Test @IMPORTANT
    public void test01401_diagram_add() throws Exception
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
    public void test01402_diagram_add() throws Exception
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
    public void test01403_diagram_add() throws Exception
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
    public void test01404_diagram_add() throws Exception
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
    public void test01405_diagram_add() throws Exception
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
    public void test01406_diagram_add() throws Exception
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
    public void test01407_diagram_add() throws Exception
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
    public void test01408_diagram_add() throws Exception
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
    public void test01409_diagram_add() throws Exception
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
    public void test01410_diagram_add() throws Exception
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
    public void test01411_diagram_add() throws Exception
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
    public void test01601_tips_copy() throws Exception
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
//    public void test01602_tips_copy() throws Exception
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
    public void test01701_tips_add() throws Exception
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
        Page_MilePost.Inst.Click(Page_MilePost.INC);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MilePost.Inst.ClickCenter();
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MainBoard.Inst.ClickCenter();
        Page_MilePost.Inst.Click(Page_MilePost.DEC);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        CheckMyData(Page_MyData.TIPS_TYPE, "里程桩");
    }

    @Test @IMPORTANT
    public void test01703_tips_add() throws Exception
    {
    	if(FastMapPage.IS_OS_TEST)
    	{
    		return;
    	}

        String[] LOC_K8 = {"116.41222", "39.96192"};
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(1000);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(1000);
        Page_MilePost.Inst.Click(Page_MilePost.ROADNAME);
        Thread.sleep(1000);
        Page_MilePost.Inst.Click(Page_MilePost.MILE_EDIT);
        Thread.sleep(1000);
        Page_MilePost.Inst.Click(Page_MilePost.FIVE);
        Thread.sleep(1000);
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MilePost.Inst.Drag(400,200,300,200,5);
        Thread.sleep(2000);

        Page_MainBoard.Inst.ClickCenter();
        Page_MilePost.Inst.Click(Page_MilePost.INC);
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MilePost.Inst.Drag(400,200,100,200,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        String str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);
        assertTrue(str.equals("7"));
        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MilePost.Inst.ClickCenter();
        //Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);
        //Page_MilePost.Inst.ScrollClick(Page_MilePost.MILE_NO);
        Page_MilePost.Inst.Drag(1743,846,1743,300,5);
        Page_MilePost.Inst.Click(Page_MilePost.MILE_EDIT);
        Page_MilePost.Inst.Click(Page_MilePost.ZERO);
        Page_MilePost.Inst.Click(Page_MilePost.SAVE);

        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Page_MilePost.Inst.Drag(400,200,10,200,5);
        Thread.sleep(2000);
        Page_MainBoard.Inst.ClickCenter();
        str = Page_MilePost.Inst.GetValue(Page_MilePost.MILE_EDIT);

        Page_MilePost.Inst.SetValue(Page_MilePost.MILE_NO, "G001");

        assertTrue((str.equals("8")));

        Page_MilePost.Inst.Click(Page_MilePost.SAVE);
    }


    @Test
    public void test01702_tips_add() throws Exception
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
    public void test01704_tips_add() throws Exception
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


    @Test @IMPORTANT
    public void test01705_gate_add() throws Exception
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
    public void test01706_gate_add() throws Exception
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
    public void test01707_gate_add() throws Exception
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
    public void test01708_gate_add() throws Exception
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
    public void test01715_gate_add() throws Exception {
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
    public void test01716_gate_add() throws Exception {
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
    public void test01717_gate_add() throws Exception {
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
    public void test01718_gate_add() throws Exception {
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
    public void test01719_gate_add() throws Exception {
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
    public void test01720_gate_add() throws Exception {
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
    public void test01721_gate_add() throws Exception {
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
    public void test01722_gate_add() throws Exception {
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
    public void test01724_gate_add() throws Exception {
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
    public void test01725_gate_add() throws Exception {
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
    public void test01726_gate_add() throws Exception {
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
    public void test01727_gate_add() throws Exception {
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
    public void test01728_gate_add() throws Exception {
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
    public void test01729_gate_add() throws Exception
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
    public void test01730_gate_add() throws Exception
    {
        //大门 默认PG
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        boolean isChecked = Page_Gate.Inst.isChecked("PG");
        assertTrue(isChecked);
    }

    @Test
    public void test01802_tips_add() throws Exception
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
    public void test01803_tips_add() throws Exception
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
    public void test01804_tips_add() throws Exception
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
    public void test02101_note() throws Exception {
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
    public void test02102_note() throws Exception {
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
    public void test02103_note() throws Exception {
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
    public void test02104_note() throws Exception {
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
    public void test02105_note() throws Exception {
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
    public void test02106_note() throws Exception {
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
    public void test02107_note() throws Exception {
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
    public void test02109_note() throws Exception {
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
    public void test02110_note() throws Exception {
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
    public void test02202_speedlimitlane() throws Exception
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
    public void test02203_speedlimitlane() throws Exception
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
    public void test02204_speedlimitlane() throws Exception
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
    public void test02205_speedlimitlane() throws Exception
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
    public void test02206_speedlimitlane() throws Exception
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
    public void test02207_speedlimitlane() throws Exception
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
    public void test02209_speedlimitlane() throws Exception
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

    @Test
    public void test02210_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //点限速 关联 2测线还是 1link
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1038,200));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        //Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        Thread.sleep(2000);
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
        assertSame(type, 2);
    }

    @Test
    public void test02211_speedlimitlane() throws Exception
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
    public void test02212_speedlimitlane() throws Exception
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
    public void test02213_speedlimitlane() throws Exception
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
    public void test02214_speedlimitlane() throws Exception
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
    public void test02215_roadlimitlane() throws Exception
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
    public void test02216_roadlimitlane() throws Exception
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
    public void test02217_roadlimitlane() throws Exception
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
    public void test02218_roadlimitlane() throws Exception
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
    public void test02219_roadlimitlane() throws Exception
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
    public void test02220_roadlimitlane() throws Exception
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
    public void test02221_roadlimitlane() throws Exception
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
    public void test02222_roadlimitlane() throws Exception
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
    public void test02223_roadlimitlane() throws Exception
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
    public void test02224_roadlimitlane() throws Exception
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
    public void test02224_variablelimitlane() throws Exception
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
    public void test02225_variablelimitlane() throws Exception
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
    public void test02226_variablelimitlane() throws Exception
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
    public void test02227_variablelimitlane() throws Exception
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
    public void test02228_variablelimitlane() throws Exception
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
    public void test02229_variablelimitlane() throws Exception
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
    public void test02301_dangerusinfo() throws Exception
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
    public void test02302_dangerusinfo() throws Exception
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
    public void test02303_dangerusinfo() throws Exception
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
    public void test02304_dangerusinfo() throws Exception
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
    public void test02305_dangerusinfo() throws Exception
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
    public void test02306_dangerusinfo() throws Exception
    {
        //危险信息  关联 2 测线还是link 1
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1038,200));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PEDESTRIAN_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
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
        assertSame(type, 2);
    }

    @Test
    public void test02307_dangerusinfo() throws Exception
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
    public void test02308_dangerusinfo() throws Exception
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
    public void test02309_dangerusinfo() throws Exception
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
    public void test02310_dangerusinfo() throws Exception
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
    public void test02311_dangerusinfo() throws Exception
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
    public void test02401_tollgate() throws Exception
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
    public void test02402_tollgate() throws Exception
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
    public void test02403_tollgate() throws Exception
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
    public void test02404_tollgate() throws Exception
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
        Page_MainBoard.Inst.Drag(138,417,318,417,5);
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
    public void test02405_tollgate() throws Exception
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
        Page_MainBoard.Inst.Drag(138,417,318,417,5);
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
    public void test02406_tollgate() throws Exception
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
        Page_MainBoard.Inst.Drag(138,417,318,417,5);
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
    public void test02407_tollgate() throws Exception
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
    public void test02408_tollgate() throws Exception
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
    public void test02501_electroniceye() throws Exception
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
    public void test02502_electroniceye() throws Exception
    {
        //电子眼  公交车道显示时间 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_BUS_LANE);
        Thread.sleep(1000);
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
    public void test02503_electroniceye() throws Exception
    {
        //电子眼  环保限行 显示车辆类型 数据库赋值
        String[] EYE_LOC = {"116.40653", "39.91529"};
        SearchLocation(EYE_LOC);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POINT_ELECTRONIC_EYE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_ElecEye.Inst.Click(Page_ElecEye.EYE_ENV_PROT);
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
    public void test02504_electroniceye() throws Exception
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
    public void test02505_electroniceye() throws Exception
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
        //Thread.sleep(3000);
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitMyData();

        Sqlitetools.RefreshData();
        str = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject2 = new JSONObject(str);
        pair = jsonObject2.getString("pair");
        assertEquals("0",pair);

        AssertIndoorCheck("共存关系检查","中","FM-1109-6-8","区间测速应该存在配对关系","不能忽略");
    }

    @Test
    public void test02506_electroniceye() throws Exception
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
    public void test02507_electroniceye() throws Exception
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
    public void test02508_electroniceye() throws Exception
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
        Page_ElecEye.Inst.Click(Page_ElecEye.SAVE);
        ExitMyData();
    }

    @Test
    public void test02509_electroniceye() throws Exception
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
    public void test02601_trucklimit() throws Exception
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
    public void test02602_trucklimit() throws Exception
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
    public void test02603_trucklimit() throws Exception
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
    public void test02604_trucklimit() throws Exception
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
    public void test02605_trucklimit() throws Exception
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
    public void test02606_trucklimit() throws Exception
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
    public void test02607_trucklimit() throws Exception
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
    public void test02608_trucklimit() throws Exception
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
    public void test02609_trucklimit() throws Exception
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
    public void test02701_gradient() throws Exception
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
    public void test02702_gradient() throws Exception
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
    public void test02703_gradient() throws Exception
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
    public void test02704_gradient() throws Exception
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
    public void test02705_gradient() throws Exception
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
    public void test02706_gradient() throws Exception
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
    public void test02707_gradient() throws Exception
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
    public void test02801_conditionlimit() throws Exception
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
    public void test02802_conditionlimit() throws Exception
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
    public void test02803_conditionlimit() throws Exception
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
    public void test02804_conditionlimit() throws Exception
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
    public void test02805_conditionlimit() throws Exception
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
    public void test02806_conditionlimit() throws Exception
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
    public void test02901_noparking() throws Exception
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
    public void test02902_noparking() throws Exception
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
    public void test02903_noparking() throws Exception
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
    public void test02904_noparking() throws Exception
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
    public void test02905_noparking() throws Exception
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
    public void test02906_noparking() throws Exception
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
    public void test02907_noparking() throws Exception
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
    public void test02908_noparking() throws Exception
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
    public void test02909_noparking() throws Exception
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
    public void test02910_noparking() throws Exception
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
    public void test02911_noparking() throws Exception
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
    public void test03001_noparkingtruck() throws Exception
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
    public void test03002_noparkingtruck() throws Exception
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
    public void test03003_noparkingtruck() throws Exception
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
    public void test03004_noparkingtruck() throws Exception
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
    public void test03005_noparkingtruck() throws Exception
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
    public void test03006_noparkingtruck() throws Exception
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
    public void test03007_noparkingtruck() throws Exception
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
    public void test03008_noparkingtruck() throws Exception
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
    public void test03009_noparkingtruck() throws Exception
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
    public void test03010_noparkingtruck() throws Exception
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
    public void test03011_noparkingtruck() throws Exception
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
    public void test04001_PoiAddressHistory() throws Exception
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        public void test04002_PoiAddressHistory() throws Exception
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
            Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        public void test04003_PoiAddressHistory() throws Exception
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
                Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
                Page_MainBoard.Inst.ClickbyText("忽略捕捉新增");
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
        public void test04004_PoiAddressHistory() throws Exception
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
        public void test04005_PoiAddressHistory() throws Exception
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
    public void test05001_FunctionalArea() throws Exception
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
    public void test05002_FunctionalArea() throws Exception
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
    public void test05003_FunctionalArea() throws Exception
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
    public void test05004_FunctionalArea() throws Exception
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
    public void test05005_FunctionalArea() throws Exception
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
        String rowkey = Page_TruckLimitLane.Inst.GetRowKey();
        Sqlitetools.RefreshData();
        String temp = new String((byte[])Sqlitetools.GetTipsDataByRowKey(rowkey,"deep"));
        JSONObject jsonObject = new JSONObject(temp);

        int tp = jsonObject.getInt("tp");
        assertSame(tp,52);
    }

    @Test
    public void test05006_FunctionalArea() throws Exception
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
        Page_FunctionalArea.Inst.ClickbyText("修改形状");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.MODIFY_SAVE);
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);
        ExitMyData();
    }

    @Test
    public void test05101_trucklimitlane() throws Exception
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
    public void test05102_trucklimitlane() throws Exception
    {
        //卡车限速 手绘测线
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

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
    public void test05103_trucklimitlane() throws Exception
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
    public void test05104_trucklimitlane() throws Exception
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
    public void test05105_trucklimitlane() throws Exception
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
    public void test05106_trucklimitlane() throws Exception
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
    public void test05201_laneChangePoint() throws Exception
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
    public void test05202_laneChangePoint() throws Exception
    {
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

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
    public void test05203_laneChangePoint() throws Exception
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
    public void test05204_laneChangePoint() throws Exception
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
    public void test05205_laneChangePoint() throws Exception
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
    public void test05206_laneChangePoint() throws Exception
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
    public void test05207_laneChangePoint() throws Exception
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
    public void test05208_laneChangePoint() throws Exception {
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
    public void test05209_laneChangePoint() throws Exception {
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
    public void test05210_laneChangePoint() throws Exception {
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
    public void test05301_vehiclelane() throws Exception
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
    public void test05302_vehiclelane() throws Exception
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
    public void test05303_vehiclelane() throws Exception
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
    public void test05304_vehiclelane() throws Exception
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
    public void test05305_vehiclelane() throws Exception
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
    public void test05401_conditionlimit() throws Exception
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
    public void test05402_conditionlimit() throws Exception
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
    public void test05403_conditionlimit() throws Exception
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
    public void test05404_conditionlimit() throws Exception
    {
        //卡车条件限速
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

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
    public void test05405_conditionlimit() throws Exception
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
    public void test05501_startendpoint() throws Exception
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
    public void test05502_startendpoint() throws Exception
    {
        //起终点
        Point[] LinePoints = {new Point(1000, 1000), new Point(1000, 500)};
        DrawRoad(LinePoints, Page_SurveyLine.PEDESTRIAN_RD);

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
    public void test05503_startendpoint() throws Exception
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
    public void test05504_startendpoint() throws Exception
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
//    public void test05601_searchlink() throws Exception
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
//    public void test05602_searchlink() throws Exception
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
//    public void test05603_searchlink() throws Exception
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

//      @Test
//    public void test05601_truescene() throws Exception
//    {
//        //实景图默认高速出口2 请求编号可选 切换成1按键不可用
//        SearchLocation(LOC_K8);//北京的经纬度信息
//        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
//        Page_MainBoard.Inst.ClickCenter();
//        Page_TrueSence.Inst.isChecked(Page_TrueSence.HIGHWAY_LOAD_OUT);
//        assertTrue(Page_TrueSence.Inst.isExistByName("请求编号"));
//        Page_TrueSence.Inst.Click(Page_TrueSence.COMMON_LOAD);
//        assertFalse(Page_TrueSence.Inst.isExistByName("请求编号"));
//        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
//        Page_TrueSence.Inst.ClickbyText("请求编号");
//        assertFalse(Page_TrueSence.Inst.isExistByName("请求编号"));
//    }

    @Test
    public void test05602_truescene() throws Exception
    {
        //实景图默认 点击请求编号返回八位编码
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(2000);
        String strtemp = Page_TrueSence.Inst.GetValue(Page_TrueSence.ET_IMG_NUMBER);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        int length = strtemp.length();
        assertSame(8,length);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("实景图");
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_OUT);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(2000);
        strtemp = Page_TrueSence.Inst.GetValue(Page_TrueSence.ET_IMG_NUMBER);
        length = strtemp.length();
        assertSame(8,length);
    }

    @Test
    public void test05603_truescene() throws Exception
    {
        //实景图原库数据不可以更改类别 请求编号正常
        SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TRUE_SCENE);
        Page_MainBoard.Inst.ClickCenter();
        Page_TrueSence.Inst.Click(Page_TrueSence.HIGHWAY_LOAD_IN);
        Page_TrueSence.Inst.ClickbyText("请求编号");
        Thread.sleep(2000);
        Page_TrueSence.Inst.Click(Page_TrueSence.CAMERA);
        for (int i=0;i<6;i++)
        {
            Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
            Thread.sleep(2000);
        }
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_TrueSence.Inst.Click(Page_TrueSence.SAVE);

        GotoIndoorTools();
        Page_IndoorMyData.Inst.ClickbyText("实景图");
        Thread.sleep(1000);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.START_CHECK);
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CHECK_CONFIRM);
        ExitIndoorTools();

        synchronize(Page_GridManager.TIPS_UPDATE);

        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("实景图");
        assertFalse(Page_TrueSence.Inst.isExistByName(Page_TrueSence.HIGHWAY_LOAD_OUT));
    }

    @Test
    public void test05701_roadlimitlane() throws Exception
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
//    public void test05801_truescene() throws Exception
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
    public void test05801_highspeeddivider() throws Exception {
          //高速分歧
          SearchLocation(LOC_K8);
          Page_MainBoard.Inst.Trigger(TipsDeepDictionary.HIGH_SPEED_DIVIDER);
          Page_MainBoard.Inst.ClickCenter();
          String strClass = "android.widget.RadioButton";
          Page_HighSpeedDivider.Inst.ClickByClassIndex(strClass, 6);
          Page_HighSpeedDivider.Inst.Click(Page_HighSpeedDivider.SAVE);
      }

    @Test
    public void test05802_realsign() throws Exception {
        //Real Sign
        //SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.REAL_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_RealSign.Inst.Click(Page_RealSign.SAVE);
    }

    @Test
    public void test05803_directionboard() throws Exception {
        //Real Sign
        //SearchLocation(LOC_K8);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.DIRECTION_BOARD);
        Page_MainBoard.Inst.ClickCenter();
        Page_DirectionBoard.Inst.Click(Page_DirectionBoard.SAVE);
    }

//    @Test
//    public void test05805_truescene() throws Exception
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
    public void test05806_truescene() throws Exception
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
    public void test05807_truescene() throws Exception
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

    @Test
    public void test05808_mode() throws Exception {
        //资三  必须有任务
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);//进入场景
        assertTrue(Page_MainBoard.Inst.isExist(Page_MainBoard.MODE_ONE,500));
        Page_MainBoard.Inst.ClickCenter();

        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.INDOOR_MODE);
        assertTrue(Page_IndoorMyData.Inst.isExist(Page_IndoorMyData.INDOOR_MODE_ONE,500));
        Page_MainBoard.Inst.ClickCenter();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.BACK);
        Page_IndoorTools.Inst.Click(Page_IndoorTools.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);

        Page_MainBoard.Inst.Click(Page_MainBoard.MAIN_MENU);
        Page_MainMenu.Inst.Click(Page_MainMenu.GRID_MANAGER); //Grid管理
        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_NAME);
        Page_GridManager.Inst.Click(Page_GridManager.GRID_PRO_SATELLITE);
        Thread.sleep(3000);
        Page_GridManager.Inst.ClickbyText("资三影像");
        Thread.sleep(3000);
        Page_GridManager.Inst.ClickByText("取消");
    }







































}
