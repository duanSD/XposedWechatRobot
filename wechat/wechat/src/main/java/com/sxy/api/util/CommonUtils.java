package com.sxy.api.util;

import android.content.Context;
import android.database.Cursor;
import com.sxy.api.wechat.Constent;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;


public class CommonUtils {

    public static String getVersion() throws Exception {
        Object activityThread = callStaticMethod(findClass("android.app.ActivityThread", null), "currentActivityThread");
        Context systemContext = (Context) callMethod(activityThread, "getSystemContext");
        String versionName = systemContext.getPackageManager().getPackageInfo(Constent.PACKAGE_NAME, 0).versionName;
        return versionName;
    }

    public static List<Map<String,Object>> parseCursor(Cursor cursor){
        ArrayList<Map<String,Object>> result = new ArrayList<>();
        while (cursor.moveToNext()){
            Map<String,Object> map = new HashMap<>();
            String[] columnNames = cursor.getColumnNames();
            for(String columnName:columnNames){
                String value = null;
                try {
                    value = cursor.getString(cursor.getColumnIndex(columnName));
                }catch (Exception e){
                    byte[] blob = cursor.getBlob(cursor.getColumnIndex(columnName));
                }

                map.put(columnName,value);
            }
            result.add(map);
        }
        return result;
    }


}
