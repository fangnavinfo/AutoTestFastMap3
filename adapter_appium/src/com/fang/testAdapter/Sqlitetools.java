package com.fang.testAdapter;

import java.lang.reflect.Method;
import java.sql.*;
import java.util.HashMap;

/**
 * Created by fang on 18/1/29.
 */
public class Sqlitetools
{
//    public static void initialize(String strDBPath)
//    {
//        mDBPath = strDBPath;
//    }


    //注意因为sqlite使用了wal缓存机制，所以每次对数据库做增删改操作后，需要调用此函数刷新数据到coremap.sqlite3中，才能从coremap.sqlite3获取对应数据
    public static void RefreshData() throws Exception
    {   
    	if(isWrite)
    	{
    		isWrite = false;
    		testadapter.ClearCollect();
    		testadapter.UpLoadFileToFastMap("coremap.sqlite");

    		return;
    	}
    	
        Class clazz = Class.forName("com.example.fang.autotestfastmap.testFastMapBase");
        
        testadapter.ReStartApp();
        
        Thread.sleep(2000);
        
        testadapter.DownLoadFileFromFastMap("coremap.sqlite", "coremap.sqlite");
        testadapter.DownLoadFileFromFastMap("coremap.shm", "coremap.shm");
        testadapter.DownLoadFileFromFastMap("coremap.wal", "coremap.wal");
        
        Process prm1 = Runtime.getRuntime().exec("mv ./temp/coremap.shm ./temp/coremap.sqlite-shm");
        prm1.waitFor();
        
        Process prm2 = Runtime.getRuntime().exec("mv ./temp/coremap.wal ./temp/coremap.sqlite-wal");
        prm2.waitFor();
        
        Process psql = Runtime.getRuntime().exec("cd temp && sqlite3 coremap.sqlite VACUUM");
        psql.waitFor();
        
        Method methodout = clazz.getMethod("loginProcess");
        methodout.invoke(null);
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

//    public static String GetRelateChildren(String infoFid) throws Exception
//    {
//    	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
//    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zhou.db,不存在则创建
//
//        try
//        {
//            String sql = "select * from edit_pois where fid=" + "\"" + infoFid + "\"";
//            
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery( sql );
//            
//            if (!rs.next()) {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            byte[] relateChildren = rs.getBytes("relateChildren");
//
//            return new String(relateChildren);
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            connection.close();
//        }
//    }


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
    
//    public static int GetBLOBdeep(String rowkey) throws Exception
//    {
//       	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
//    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zhou.db,不存在则创建
//
//        try
//        {
//        	String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
//            
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery( sql );
//            
//            if (!rs.next()) 
//            {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            byte[] deep = rs.getBytes("deep");
//
//            String str = new String(deep);
//            int type = 0;
//
//            JSONObject jsonObject = new JSONObject(str);
//            JSONObject fObject = jsonObject.getJSONObject("f");
//            type = fObject.getInt("type");
//            return type;
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            connection.close();
//        }
//    }

//    public static int Get(String rowkey) throws Exception
//    {
//       	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
//    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zhou.db,不存在则创建
//
//        try
//        {
//        	String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
//            
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery( sql );
//            
//            if (!rs.next()) 
//            {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            byte[] deep = rs.getBytes("deep");
//
//            String str = new String(deep);
//            int type = 0;
//
//            JSONObject jsonObject = new JSONObject(str);
//            JSONObject fObject = jsonObject.getJSONObject("f");
//            type = fObject.getInt("type");
//            return type;
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            connection.close();
//        }
//    }
//    
//    public static int GetinConfirm(String rowkey) throws Exception
//    {
//       	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
//    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");//连接数据库zh
//    	
//        int inConfirm = 0;
//        try
//        {
//            String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
//            Statement stmt = connection.createStatement();
//            ResultSet rs = stmt.executeQuery( sql );
//            
//            if (!rs.next()) 
//            {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            byte[] deep = rs.getBytes("deep");
//            
//
//            inConfirm = rs.getInt("inConfirm");
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//        	connection.close();
//        }
//        return inConfirm;
//    }
    
    static final String mDBPath = "./temp/";
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

	public static Object GetTipsDataByRowKey(String rowkey, String colu) throws Exception 
	{
      	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");

        try
        {
            HashMap<String, String> TipsTableInfo = new HashMap<>();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "PRAGMA table_info(\"edit_tips\")" );
            
            if (!rs.next()) 
            {
            	throw new Exception();
            }

            do
            {
                TipsTableInfo.put(rs.getString(2),  rs.getString(3));
            } while (rs.next());
            

            String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
            rs = stmt.executeQuery(sql);
            if (!rs.next())
            {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            switch (TipsTableInfo.get(colu))
            {
                case "integer":
                    return rs.getInt(colu);
                case "text":
                    return rs.getString(colu);
                case "blob":
                    return rs.getBytes(colu);
                default:
                    throw new UnsupportedOperationException("column:" + colu + ", type:" + TipsTableInfo.get(colu));
            }
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

	public static Object GePoiDataByFid(String infoFid, String colu) throws Exception
	{
      	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");

        try
        {
            HashMap<String, String> TipsTableInfo = new HashMap<>();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "PRAGMA table_info(\"edit_Pois\")" );
            
            if (!rs.next()) 
            {
            	throw new Exception();
            }

            do
            {
                TipsTableInfo.put(rs.getString(2),  rs.getString(3));
            } while (rs.next());
            

            String sql = "select * from edit_Pois where fid=" + "\"" + infoFid + "\"";
            rs = stmt.executeQuery(sql);
            if (!rs.next())
            {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            switch (TipsTableInfo.get(colu))
            {
                case "integer":
                    return rs.getInt(colu);
                case "text":
                    return rs.getString(colu);
                case "blob":
                    return rs.getBytes(colu);
                default:
                    throw new UnsupportedOperationException("column:" + colu + ", type:" + TipsTableInfo.get(colu));
            }
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
	
	public static void UpdatePoiData(String infoFid, String colu, Object value) throws Exception
	{
      	Class.forName(Drivde);// 加载驱动,连接sqlite的jdbc
    	Connection connection=DriverManager.getConnection("jdbc:sqlite:" + mDBPath +"/coremap.sqlite");

        try
        {
            HashMap<String, String> TipsTableInfo = new HashMap<>();
            
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery( "PRAGMA table_info(\"edit_Pois\")" );
            
            if (!rs.next()) 
            {
            	throw new Exception();
            }

            do
            {
                TipsTableInfo.put(rs.getString(2),  rs.getString(3));
            } while (rs.next());
            
            PreparedStatement prep = connection.prepareStatement("UPDATE edit_Pois SET " + colu + " = ? WHERE fid=" + "\"" + infoFid + "\"");
            		
            
            switch (TipsTableInfo.get(colu))
            {
                case "integer":
                	prep.setInt(1, (int)value);
                    break;
                case "text":
                	prep.setString(1, (String)value);
                    break;
                case "blob":
                	String str = (String) value;
                	if(str == null)
                	{
                		throw new UnsupportedOperationException("column:" + colu + ", type:" + TipsTableInfo.get(colu));
                	}
                	
                	prep.setBytes(1, str.getBytes("UTF-8"));
                    break;
                default:
                    throw new UnsupportedOperationException("column:" + colu + ", type:" + TipsTableInfo.get(colu));
            }
            
            prep.executeUpdate();
            
            Process prm1 = Runtime.getRuntime().exec("mv ./temp/coremap.shm ./temp/coremap.sqlite-shm");
            prm1.waitFor();
            
            Process prm2 = Runtime.getRuntime().exec("mv ./temp/coremap.wal ./temp/coremap.sqlite-wal");
            prm2.waitFor();
            
            Process psql = Runtime.getRuntime().exec("cd temp && sqlite3 coremap.sqlite VACUUM");
            psql.waitFor();
            
            isWrite = true;
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
	
    public static void updatePoiFloorInfo(String fid1, String fid2) throws Exception
    {
    	UpdatePoiData(fid1, "indoor", "{\"type\":0,\"floor\":\"１层\"}");
    	UpdatePoiData(fid2, "indoor", "{\"type\":0,\"floor\":\"２层\"}");
    	
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READWRITE);
//
//        boolean b = false;
//        try
//        {
//            ContentValues cv1 = new ContentValues();
//            cv1.put("indoor", "{\"type\":0,\"floor\":\"１层\"}");
//            ContentValues cv2 = new ContentValues();
//            cv2.put("indoor", "{\"type\":0,\"floor\":\"２层\"}");
//
//            String whereClause="fid=?";
//
//            String [] whereArgs1 = {fid1};
//            String [] whereArgs2 = {fid2};
//
//            //db.execSQL("PRAGMA journal_mode=DELETE ");
//
//            db.update("edit_pois", cv1, whereClause, whereArgs1);
//
//            db.update("edit_pois", cv2, whereClause, whereArgs2);
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            db.close();
//        }
    }
    
    public static boolean isWrite = false;
}

