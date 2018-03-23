package com.fang.testAdapter;

import org.json.JSONObject;  
import java.lang.reflect.Method;
import java.sql.*;

/**
 * Created by fang on 18/1/29.
 */
public class Sqlitetools
{
    public static void initialize(String strDBPath)
    {
        mDBPath = strDBPath;
    }


    //注意因为sqlite使用了wal缓存机制，所以每次对数据库做增删改操作后，需要调用此函数刷新数据到coremap.sqlite3中，才能从coremap.sqlite3获取对应数据
    public static void RefreshData() throws Exception
    {
        testadapter.ReStartApp();

        Class clazz = Class.forName("com.example.fang.autotestfastmap.testFastMapBase");

        Method method = clazz.getMethod("loginProcess");
        method.invoke(null);
    }

    public String GetTipsDisplayText(String key) throws Exception
    {
    	return null;
    	
//        SQLiteDatabase db=SQLiteDatabase.openDatabase(mDBPath, null, SQLiteDatabase.OPEN_READONLY, null);
//
//        try
//        {
//            String sql = "select * from tips_geo_component where tipsRowkey=" + "\"" + key + "\"" + "and geoTableName=\"tips_point\"";
//            Cursor cursor = db.rawQuery(sql, null);
//            if (!cursor.moveToFirst())
//            {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            int coluid = cursor.getColumnIndex("geoUuid");
//            String uuid = cursor.getString(coluid);
//
//            sql = "select * from tips_point where uuid=" + "\"" + uuid + "\"";
//            cursor = db.rawQuery(sql, null);
//            if (!cursor.moveToFirst())
//            {
//                throw new Exception("can not find uuid:" + uuid + " in tips_geo_component");
//            }
//
//            String displayJson = cursor.getString(cursor.getColumnIndex("display_style"));
//
//            ArrayList<DISPLAY_TEXT> textList = new ArrayList<>();
//
//            JSONObject jsonObject = new JSONObject(displayJson);
//            JSONArray jsonArray = jsonObject.getJSONArray("icon");
//            for (int i = 0; i < jsonArray.length(); i++) {
//                JSONObject jsonSubObject = jsonArray.getJSONObject(i);
//                if (!jsonSubObject.has("name")) {
//                    continue;
//                }
//
//                String name = jsonSubObject.getString("name");
//                int row = jsonSubObject.getInt("row");
//                int col = jsonSubObject.getInt("column");
//
//                textList.add(new DISPLAY_TEXT(name, row, col));
//            }
//
//            String rlst = "";
//            for (DISPLAY_TEXT test : textList)
//            {
//                rlst += test.name;
//            }
//
//            return rlst;
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            db.close();
//        }
//
    }

    public static String GetRelateChildren(String infoFid) throws Exception
    {
    	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zhou.db,不存在则创建

        try
        {
            String sql = "select * from edit_pois where fid=" + "\"" + infoFid + "\"";
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
            if (!rs.next()) {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            byte[] relateChildren = rs.getBytes("relateChildren");

            return new String(relateChildren);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            connection.close();
        }
    }


    class DISPLAY_TEXT implements Comparable<DISPLAY_TEXT>
    {
        public DISPLAY_TEXT(String name, int row, int col)
        {
            this.name = name;
            this.row = row;
            this.col = col;
        }

        @Override
        public int compareTo(DISPLAY_TEXT p)
        {
            if(this.row > p.row)
            {
                return 1;
            }
            else if (this.row < p.row)
            {
                return -1;
            }
            else
            {
                if (this.col > p.col)
                {
                    return 1;
                }
                else if (this.col < p.col)
                {
                    return -1;
                }
                else
                {
                    return 0;
                }
            }
        }


        String name;
        int row;
        int col;

    }
    
    public static int GetBLOBdeep(String rowkey) throws Exception
    {
       	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zhou.db,不存在则创建

        try
        {
        	String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( sql );
            
            if (!rs.next()) 
            {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            byte[] deep = rs.getBytes("deep");

            String str = new String(deep);
            int type = 0;

            JSONObject jsonObject = new JSONObject(str);
            JSONObject fObject = jsonObject.getJSONObject("f");
            type = fObject.getInt("type");
            return type;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            connection.close();
        }
    }

    static String mDBPath;
    private static String Drivde="org.sqlite.JDBC";
	public static void update3rdPartyInfo(String globalId) throws SQLException, ClassNotFoundException
	{
		// TODO Auto-generated method stub
		
      	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zhou.db,不存在则创建
    	
        try
        {
        			
        	String sql = "update edit_tips set b_sourceCode = 6 where globalId=" + "\"" + globalId + "\"";
            
            Statement stmt = connection.createStatement();
            int rs = stmt.executeUpdate( sql );
            
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
        	connection.close();
        }
	}
}

