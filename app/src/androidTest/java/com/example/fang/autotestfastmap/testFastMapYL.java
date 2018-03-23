package com.example.fang.autotestfastmap;

import com.fang.testAdapter.FastMapPage;
import com.fang.testAdapter.Point;
import com.fang.testAdapter.Sqlitetools;
import com.fastmap.ui.Page_AddPoint;
import com.fastmap.ui.Page_Dangerous;
import com.fastmap.ui.Page_ElecEye;
import com.fastmap.ui.Page_Gate;
import com.fastmap.ui.Page_GridManager;
import com.fastmap.ui.Page_HighSpeedEntryPic;
import com.fastmap.ui.Page_IndoorMyData;
import com.fastmap.ui.Page_IndoorTool;
import com.fastmap.ui.Page_InfoAccept;
import com.fastmap.ui.Page_InfoFrame;
import com.fastmap.ui.Page_InfoLine;
import com.fastmap.ui.Page_InfoPoint;
import com.fastmap.ui.Page_LaneInfo;
import com.fastmap.ui.Page_MainBoard;
import com.fastmap.ui.Page_MainMenu;
import com.fastmap.ui.Page_MilePost;
import com.fastmap.ui.Page_MyData;
import com.fastmap.ui.Page_NormalCrossPic;
import com.fastmap.ui.Page_Note;
import com.fastmap.ui.Page_POI;
import com.fastmap.ui.Page_POI_Camera;
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

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import java.io.IOException;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertTrue;

/**
 * Created by fang on 17/11/21.
 */

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testFastMapYL extends testFastMapBase
{
    @BeforeClass
    public static void setClassUp() throws Exception
    {
        //testFastMapBase.setClassUp("collector1","123456");//"collector1","123456"
    }

    @AfterClass
    public static void setClassDown() throws InterruptedException, IOException
    {
    }

    @Before
    public void setUp() throws Exception {
        testFastMapBase.setClassUp("collector1","123456");
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
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;

        //我的数据
        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ２");
    }

    @Test
    public void test00205_poi_add() throws Exception
    {
        //产品全貌开关开，新增POI点查看相机设置
        //Page_MainBoard.Inst.Drag();
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
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);

        CheckMyData(Page_MyData.POI_TYPE, "测试ＰＯＩ３");
    }

    @Test
    public void test00206_poi_add() throws Exception
    {
        //产品全貌开关开
        //Page_MainBoard.Inst.Drag();
        //SetConfInfo();//产品全貌开关开
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.POI_ADD_9001);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_LOW);

        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);//现在的低分辨率(但是这个直不计入本地文件)，产品全貌图
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.SetValue(Page_POI.NAME,"测试ＰＯＩ４");
        Page_POI.Inst.SetValue(Page_POI.SELECT_TYPE, "中餐馆");
        Page_POI.Inst.Click(Page_POI.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.SHUIPAI_TYPE);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.RADIO_HIG);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);

        Page_POI.Inst.Click(Page_POI.CAMERA); //看是否保存设置(水牌，高)
        Thread.sleep(1000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_POI.Inst.Click(Page_POI.SAVE);
        //poiNum++;

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
        Page_MyData.Inst.SelectData("自采集情报(道路)(点)", "测试点ＩＮＦＯ");

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
        Page_InfoLine.Inst.Click(Page_InfoLine.LEVEL_1);
        Page_InfoLine.Inst.Click(Page_InfoLine.CAMERA);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.TAKE_PIC);
        Thread.sleep(3000);
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_InfoLine.Inst.Click(Page_InfoLine.SAVE);

        //查看我的数据
        GotoMyData(Page_MyData.INFO_TYPE);
        Page_MyData.Inst.SelectData("自采集情报(道路)(线)", "测试线ＩＮＦＯ");

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
        Page_MyData.Inst.SelectData("自采集情报(道路)(面)", "测试面ＩＮＦＯ");

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
        Page_MainBoard.Inst.Drag(900,356,870,1165,10);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);
        Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(1310, 1410));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.HIGH_SPEED);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        Page_MainBoard.Inst.ClickCenter();
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("道路名标牌");
        String rowkey = Page_RoadNameSign.Inst.GetValue(Page_RoadNameSign.ROWKEY);
        rowkey = rowkey.substring(rowkey.length()-38,rowkey.length());
        Sqlitetools.RefreshData();
        int type = Sqlitetools.GetBLOBdeep(rowkey);
        //assertTrue(type==2);
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
        String rowkey = Page_RoadNameSign.Inst.GetValue(Page_RoadNameSign.ROWKEY);
        rowkey = rowkey.substring(rowkey.length()-38,rowkey.length());
        Sqlitetools.RefreshData();
        int type = Sqlitetools.GetBLOBdeep(rowkey);
        assertSame(type,1);
    }

    @Test
    public void test01016_tips_roadnamesign_add() throws Exception
    {
        //新增道路名标牌关联不上node(不关联node(link交接处))
        Page_MainBoard.Inst.Click(Page_MainBoard.ZOOM_IN);
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ROAD_NAME_SIGN);
        //Page_MainBoard.Inst.ClickCenter();
        Page_MainBoard.Inst.Click(new Point(461,481));//关联node
        Page_POI_Camera.Inst.Click(Page_POI_Camera.BACK);
        Page_RoadNameSign.Inst.SetValue(Page_RoadNameSign.NAME, "qwe");
        Page_RoadNameSign.Inst.Click(Page_RoadNameSign.SAVE);
        GotoMyData(Page_MyData.TIPS_TYPE);
        Page_MyData.Inst.ClickbyText("道路名标牌");
        String rowkey = Page_RoadNameSign.Inst.GetValue(Page_RoadNameSign.ROWKEY);
        rowkey = rowkey.substring(rowkey.length()-38,rowkey.length());
        Sqlitetools.RefreshData();
        int type = Sqlitetools.GetBLOBdeep(rowkey);
        assertFalse(type==3);
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
    
    @Test @IMPORTANT
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

    @Test
    public void test01702_tips_add() throws Exception
    {
 //   	SearchLocation(LOC_K8);

        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TYPE_TEST_LINE_10002);//手绘测线
        Page_SurveyLine.Inst.Click(Page_SurveyLine.PROVINCIAL_RD);
        Page_SurveyLine.Inst.Click(Page_SurveyLine.LANE_NUM_1);
        Page_MainBoard.Inst.Click(new Point(426,1185));
        Page_MainBoard.Inst.Click(new Point(1000,1185));
        Page_SurveyLine.Inst.Click(Page_SurveyLine.SAVE);
        
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.ADD_POINT_1700);//打点
        Page_MilePost.Inst.Click(Page_MilePost.MILEPOST);
        Thread.sleep(2000);

        Page_MainBoard.Inst.Click(new Point(426,1185));
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
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01706_gate_add() throws Exception
    {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01707_gate_add() throws Exception
    {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01708_gate_add() throws Exception
    {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }


    @Test
    public void test01715_gate_add() throws Exception {
        //大门 PG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01716_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01717_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TIMECAR);
        Page_TimeCtl.Inst.Click(Page_TimeCtl.CONFIRM);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

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
        //tipsNum++;

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
        //tipsNum++;

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
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

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
        //tipsNum++;

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
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01725_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01726_gate_add() throws Exception {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.BICYCLE);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

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
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01728_gate_add() throws Exception {
        //大门 KG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
    }

    @Test
    public void test01729_gate_add() throws Exception
    {
        //大门 EG默认值车辆和行人 取消勾选时间清空
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.GATETYPE);
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_Gate.Inst.Click(Page_Gate.EG);
        Page_Gate.Inst.Click(Page_Gate.TRICYCLE);
        Page_Gate.Inst.Click(Page_Gate.PG);
        Page_Gate.Inst.Click(Page_Gate.KG);
        Page_Gate.Inst.Click(Page_Gate.SAVE);//保存
        Thread.sleep(2000);
        //tipsNum++;

        CheckMyData(Page_MyData.TIPS_TYPE, "大门");
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
        Page_RoadNameSign.Inst.ClickByText("确认");

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
        Thread.sleep(2000);
        Page_Note.Inst.ClickByText("保存");
        
        GotoIndoorTools();
        Thread.sleep(2000);
        assertTrue(Page_IndoorMyData.Inst.isExistByName("便签"));
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.BACK);
    }

    @Test
    public void test02107_note() throws Exception {
        //在便签属性页--绘制--室内整理工具--筛选便签
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.TIPS_TYPE_NOTE);
        Page_MainBoard.Inst.Drag(404,1068,967,756,5);
        Thread.sleep(2000);
        Page_Note.Inst.ClickByText("保存");
        
        GotoIndoorTools();
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER);//筛选
        Page_IndoorMyData.Inst.SetValue(Page_IndoorMyData.FILTER_EDTOR,"便签");
        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.FILTER_EDTOR);

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.CONFIRM);
        Thread.sleep(2000);

        assertTrue(Page_IndoorMyData.Inst.isExistByName("便签"));

        Page_IndoorMyData.Inst.Click(Page_IndoorMyData.BACK);
        Page_IndoorTool.Inst.Click(Page_IndoorTool.BACK);
        Page_MainMenu.Inst.Click(Page_MainMenu.BACK);
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
    public void test02201_speedlimitlane() throws Exception
    {
        if (FastMapPage.IS_OS_TEST)
        {
            return;
        }

        //车道限速 去除有最低限速就要有最高限速的限制
        Page_MainBoard.Inst.Trigger(TipsDeepDictionary.SPEED_LIMIT_POINT);//只能通过点限速去点击车道限速
        Page_MainBoard.Inst.ClickCenter();
        Thread.sleep(2000);
        Page_SpeedLimit.Inst.Click(Page_SpeedLimit.ROADLIMIT);
        Thread.sleep(1000);

        Page_MainBoard.Inst.Drag(82,628,352,628,10);
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

}
