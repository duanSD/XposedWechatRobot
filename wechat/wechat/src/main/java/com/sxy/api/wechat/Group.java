package com.sxy.api.wechat;

import android.database.Cursor;
import com.sxy.api.util.CommonUtils;
import java.util.List;
import java.util.Map;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.XposedHelpers;


public class Group {
    public static List<Map<String,Object>> getChatRoomInfo(ClassLoader classLoader){
        Class<?> clazz = XposedHelpers.findClass("******", classLoader);
        Object object = XposedHelpers.callStaticMethod(clazz,"AH");
        Cursor cursor =(Cursor) XposedHelpers.callMethod(object, "******", "******", null, 2);
        if ((cursor == null) || (!cursor.moveToFirst())) {
            XposedBridge.log("is null");
            return null;
        }
        List<Map<String, Object>> maps = CommonUtils.parseCursor(cursor);
        return maps;
    }
}
