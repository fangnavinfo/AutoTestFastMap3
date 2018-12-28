package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.UiObject2;

import com.fang.testAdapter.Point;
import com.fang.testAdapter.Sqlitetools;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_ChangeLaneNotice;
import com.fastmap.ui.Page_DirectionBoard;
import com.fastmap.ui.Page_FunctionalArea;
import com.fastmap.ui.Page_HovLine;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_InfoPoint;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MilePost;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_PAS;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_RealSign;
import com.fastmap.ui.Page_RoadNameSign;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_Set;
import com.fastmap.ui.Page_TruckForbidden;
import com.fastmap.ui.Page_TrueSence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.BufferedInputStream;
import java.sql.Blob;
import java.util.List;

import static junit.framework.Assert.assertEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapMainBranch extends testFastMapBase {
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

        testFastMapBase.setClassUp();

    }

    @After
    public void setAfter() //throws IOException, InterruptedException {
    {

        //super.setAfter();
        CPUMonitor.Assert();
    }

    @Test
    public void test998_00211_poi_add() throws Exception
    {
        //卡车标识原则
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//拍照
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME, "测试ＰＯＩ１");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "收费站");
        String strTruck = Page_POI.Inst.GetValue(Page_POI.POI_TRUCK);
        assertEquals("非卡车",strTruck);
        String strFid = Page_POI.Inst.GetValue(Page_POI.FID);
        Page_POI.Inst.Click(Page_POI.SAVE);
        strFid = strFid.replace("fid:", "");
        strFid = strFid.replace("fid : ", "");
        Sqlitetools.RefreshData();
        int truck = (int)Sqlitetools.GetPoisDataByRowKey(strFid,"truck");
        assertSame(0,truck);
    }

    @Test
    public void test998_00213_poi_add() throws Exception
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
    public void test998_00214_poi_add() throws Exception
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
    public void test003_1_pas_input_update_check() throws Exception {
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
    public void test003_2_pas_input_update_check() throws Exception {
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
    public void test003_3_pas_input_update_check() throws Exception {
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
    public void test003_4_pas_input_update_check() throws Exception {
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
    public void test003_5_pas_input_update_check() throws Exception {
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
    public void test003_6_pas_input_update_check() throws Exception {
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
    public void test003_7_pas_input_update_check() throws Exception {
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
    public void test003_8_pas_input_update_check() throws Exception {
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

    //精细化开关优化
    @Test
    public void test004_1_layer_check() throws Exception {
        // 创建点门牌
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.PAS_ADD_9004);

        Page_PAS.Inst.SetValue(Page_PAS.NAME, "测试ＰＡＳ");
        Page_PAS.Inst.SetValue(Page_PAS.ADDRESS, "101");
        Page_PAS.Inst.Click(Page_PAS.ODD);
        Page_PAS.Inst.Click(Page_PAS.ROAD_TYPE);
        Page_PAS.Inst.Click(Page_PAS.BUILDING_PAS);
        Page_PAS.Inst.Click(Page_PAS.SAVE);

        Thread.sleep(3000);

        //点击要素
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(Page_PAS.Inst.isExistByName("保存"));

        Page_PAS.Inst.Click(Page_PAS.CANCEL);

        //隐藏要素
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);

        //点击要素
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(!Page_TrueSence.Inst.isExistByName("保存"));

        //还原渲染开关
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);
    }

    @Test
    public void test004_2_layer_check() throws Exception {
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.FUNCTIONAL_SURFACE);
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2-100,testadapter.getDisplayHeight()/2-100));
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2-100,testadapter.getDisplayHeight()/2+100));
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2+100,testadapter.getDisplayHeight()/2+100));
        Page_MainBoard.Inst.Click(new Point(testadapter.getDisplayWidth()/2+100,testadapter.getDisplayHeight()/2-100));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.COMPLETE);

        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.AIRPORT);
        Page_FunctionalArea.Inst.SetValue(Page_FunctionalArea.NAME, "测试");
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.SAVE);

        Thread.sleep(3000);

        Page_MainBoard.Inst.ClickCenter();
        assertTrue(Page_FunctionalArea.Inst.isExistByName("保存"));
        Page_FunctionalArea.Inst.Click(Page_FunctionalArea.CANCEL);

        //隐藏要素
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);

        //点击要素
        Page_MainBoard.Inst.ClickCenter();

        assertTrue(Page_FunctionalArea.Inst.isExistByName("保存"));

        //还原渲染开关
        Page_MainBoard.Inst.Click(Page_MainBoard.MODE);
        Page_MainBoard.Inst.Click(Page_MainBoard.REFINEMENT);
        Page_MainBoard.Inst.Click(Page_MainBoard.CLOSE);
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

        assertTrue(Page_POI.Inst.isExistByName("道路名"));

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



}