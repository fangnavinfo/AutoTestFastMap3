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

}