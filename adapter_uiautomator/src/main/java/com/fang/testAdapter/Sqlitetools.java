package com.fang.testAdapter;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import org.json.JSONArray;
import org.json.JSONObject;


import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.HashMap;

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
        SQLiteDatabase db=SQLiteDatabase.openDatabase(mDBPath, null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            String sql = "select * from tips_geo_component where tipsRowkey=" + "\"" + key + "\"" + "and geoTableName=\"tips_point\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst())
            {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            int coluid = cursor.getColumnIndex("geoUuid");
            String uuid = cursor.getString(coluid);

            sql = "select * from tips_point where uuid=" + "\"" + uuid + "\"";
            cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst())
            {
                throw new Exception("can not find uuid:" + uuid + " in tips_geo_component");
            }

            String displayJson = cursor.getString(cursor.getColumnIndex("display_style"));

            ArrayList<DISPLAY_TEXT> textList = new ArrayList<>();

            JSONObject jsonObject = new JSONObject(displayJson);
            JSONArray jsonArray = jsonObject.getJSONArray("icon");
            for (int i = 0; i < jsonArray.length(); i++) {
                JSONObject jsonSubObject = jsonArray.getJSONObject(i);
                if (!jsonSubObject.has("name")) {
                    continue;
                }

                String name = jsonSubObject.getString("name");
                int row = jsonSubObject.getInt("row");
                int col = jsonSubObject.getInt("column");

                textList.add(new DISPLAY_TEXT(name, row, col));
            }

            String rlst = "";
            for (DISPLAY_TEXT test : textList)
            {
                rlst += test.name;
            }

            return rlst;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }


    }

    public static void update3rdPartyInfo(String globalId) throws Exception
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READWRITE);

        boolean b = false;
        try
        {
            ContentValues cv = new ContentValues();
            cv.put("b_sourceCode", 6);
            cv.put("i_varField", "[{\"属性的名称1\":\"属性内容1\",\"属性名称2\":\"属性内容2属性内容2属性内容2属性内容2属性内容2属性内容2属性内容2\"}]");
            cv.put("t_sync", 1);
            cv.put("b_reliability", 1);
            cv.put("i_level", 3);
            cv.put("t_isPublished", 1);
            //String whereClause="globalId=?";

            //String [] whereArgs = {globalId};

            //db.execSQL("PRAGMA journal_mode=DELETE ");

            db.update("edit_infos", cv, null, null);
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }
    }

//    public static String GetRelateChildren(String infoFid) throws Exception
//    {
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READONLY, null);
//
//        try
//        {
//            String sql = "select * from edit_pois where fid=" + "\"" + infoFid + "\"";
//            Cursor cursor = db.rawQuery(sql, null);
//            if (!cursor.moveToFirst()) {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            int relateChildrenIndex = cursor.getColumnIndex("relateChildren");
//            byte[] relateChildren = cursor.getBlob(relateChildrenIndex);
//
//            return new String(relateChildren);
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            db.close();
//        }
//    }

    public static Object GePoiDataByFid(String fid, String colu) throws Exception
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            HashMap<String, String> TipsTableInfo = new HashMap<>();
            Cursor c = db.rawQuery("PRAGMA table_info(\"edit_pois\")", null);
            if (c.moveToFirst())
            {
                do
                {
                    TipsTableInfo.put(c.getString(1),  c.getString(2));
                } while (c.moveToNext());
            }
            c.close();

            String sql = "select * from edit_pois where fid=" + "\"" + fid + "\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst())
            {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            int index = cursor.getColumnIndex(colu);
            switch (TipsTableInfo.get(colu))
            {
                case "integer":
                    return cursor.getInt(index);
                case "text":
                    return cursor.getString(index);
                case "blob":
                    return cursor.getBlob(index);
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
            db.close();
        }
    }

    public static Object GetTipsDataByRowKey(String rowkey, String colu) throws Exception
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            HashMap<String, String> TipsTableInfo = new HashMap<>();
            Cursor c = db.rawQuery("PRAGMA table_info(\"edit_tips\")", null);
            if (c.moveToFirst())
            {
                do
                {
                    TipsTableInfo.put(c.getString(1),  c.getString(2));
                } while (c.moveToNext());
            }
            c.close();

            String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst())
            {
                throw new Exception("query result is null, exec sql:" + sql);
            }

            int index = cursor.getColumnIndex(colu);
            switch (TipsTableInfo.get(colu))
            {
                case "integer":
                    return cursor.getInt(index);
                case "text":
                    return cursor.getString(index);
                case "blob":
                    return cursor.getBlob(index);
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
            db.close();
        }
    }

//    public static int GetBLOBdeep(String rowkey) throws Exception
//    {
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READONLY, null);
//
//        try
//        {
//            String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
//            Cursor cursor = db.rawQuery(sql, null);
//            if (!cursor.moveToFirst()) {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            int BLOBIndex = cursor.getColumnIndex("deep");
//            byte[] BOLBContent = cursor.getBlob(BLOBIndex);
//            String str = new String(BOLBContent);
//            int type = 0;
//            try {
//                JSONObject jsonObject = new JSONObject(str);
//                JSONObject fObject = jsonObject.getJSONObject("f");
//                type = fObject.getInt("type");
//            } catch (JSONException e) {
//                e.printStackTrace();
//            }
//            return type;
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            db.close();
//        }
//    }
//
//    public static int GetinConfirm(String rowkey) throws Exception
//    {
//        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"coremap.sqlite", null, SQLiteDatabase.OPEN_READONLY, null);
//        int inConfirm = 0;
//        try
//        {
//            String sql = "select * from edit_tips where rowkey=" + "\"" + rowkey + "\"";
//            Cursor cursor = db.rawQuery(sql, null);
//            if (!cursor.moveToFirst()) {
//                throw new Exception("query result is null, exec sql:" + sql);
//            }
//
//            int BLOBIndex = cursor.getColumnIndex("inConfirm");
//            inConfirm = cursor.getInt(BLOBIndex);
//        }
//        catch (Exception e)
//        {
//            throw e;
//        }
//        finally
//        {
//            db.close();
//        }
//        return inConfirm;
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

    static public int[] GetKeyboardInfo(String type) throws Exception
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"keyboard.db", null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            String sql = "select * from dragviews where tipstype=" + "\"" + type + "\"";
            Cursor cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                db.close();

                throw new Exception("query result is null, exec sql:" + sql);
            }

            int areaCodeIntegrated = cursor.getInt(cursor.getColumnIndex("areaCodeIntegrated"));
            int timeIntegrated = cursor.getInt(cursor.getColumnIndex("timeIntegrated"));

            sql = "select count(*) from dragviews where areaCodeIntegrated=" + areaCodeIntegrated;
            cursor = db.rawQuery(sql, null);
            if (!cursor.moveToFirst()) {
                db.close();

                throw new Exception("query result is null, exec sql:" + sql);
            }

            Long count = cursor.getLong(0);
            if (count > 1) {
                return new int[]{areaCodeIntegrated, timeIntegrated};
            } else {
                return new int[]{areaCodeIntegrated, 0};
            }
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }
    }

    static public HashMap<long[], String> GetKeyboardLeft() throws Exception
    {
        return GetKeyboardByAreaRange(200, 300, "areaCodeIntegrated", "timeIntegrated");
    }

    static public HashMap<long[], String> GetKeyboardBottom() throws Exception
    {
        return GetKeyboardByAreaRange(100, 200, "areaCodeIntegrated", "timeIntegrated");
    }

    static public HashMap<long[], String> GetKeyboardRight() throws Exception
    {
        return GetKeyboardByAreaRange(300, 400, "areaCodeIntegrated", "timeIntegrated");
    }

    static public HashMap<long[], String> GetKeyboardRightWithQC() throws Exception
    {
        return GetKeyboardByAreaRange(300, 400, "areaCodeRoad", "timeRoad");
    }

    static public HashMap<long[], String> GetKeyboardLeftWithQC() throws Exception
    {
        return GetKeyboardByAreaRange(200, 300, "areaCodeRoad", "timeRoad");
    }

    static public HashMap<long[], String> GetKeyboardBottomWithQC() throws Exception
    {
        return GetKeyboardByAreaRange(100, 200, "areaCodeRoad", "timeRoad");
    }


    static private HashMap<long[], String> GetKeyboardByAreaRange(int min, int max, String outter, String inner)
    {
        SQLiteDatabase db = SQLiteDatabase.openDatabase(mDBPath+"keyboard.db", null, SQLiteDatabase.OPEN_READONLY, null);

        try
        {
            HashMap<long[], String> mapResult = new HashMap<>();

            String sql = "select * from dragviews where " + outter +">"+ min + " and " + outter + "<" + max + " order by " + outter +","+inner;
            Cursor cursor = db.rawQuery(sql, null);
            while (cursor.moveToNext())
            {
                String type = cursor.getString(cursor.getColumnIndex("tipstype"));
                long[]  location = new long[]{cursor.getInt(cursor.getColumnIndex(outter)), cursor.getLong(cursor.getColumnIndex(inner))};
                mapResult.put(location, type);
            }

            return mapResult;
        }
        catch (Exception e)
        {
            throw e;
        }
        finally
        {
            db.close();
        }
    }

    static String mDBPath;

}

