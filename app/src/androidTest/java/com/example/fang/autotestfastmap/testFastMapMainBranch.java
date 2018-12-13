package com.example.fang.autotestfastmap;

import com.fang.testAdapter.Point;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_FunctionalArea;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_PAS;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
import com.fastmap.ui.Page_Search;
import com.fastmap.ui.Page_SearchResultList;
import com.fastmap.ui.Page_TrueSence;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import static junit.framework.Assert.assertEquals;
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
}