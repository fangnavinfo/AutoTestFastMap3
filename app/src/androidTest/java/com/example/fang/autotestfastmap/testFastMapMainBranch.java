package com.example.fang.autotestfastmap;

import android.support.test.uiautomator.UiObject2;

import com.fang.testAdapter.FindResource;
import com.fang.testAdapter.Point;
import com.fang.testAdapter.Sqlitetools;
import com.fang.testAdapter.testadapter;
import com.fastmap.ui.Page_BusPriorityLane;
import com.fastmap.ui.Page_ChangeLaneNotice;
import com.fastmap.ui.Page_DirectionBoard;
import com.fastmap.ui.Page_FunctionalArea;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_HovLine;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_InfoPoint;
import com.fastmap.ui.Page_Light;
import com.fastmap.ui.Page_LightControl;
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
import com.fastmap.ui.Page_TurnLeftLane;

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

}