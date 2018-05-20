package com.sxy.api.wechat;

import android.database.Cursor;
import com.sxy.api.util.CommonUtils;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;
import static de.robv.android.xposed.XposedHelpers.newInstance;


public class Friend {

    public static List<Map<String, Object>> listFriend(ClassLoader classLoader){
        Class<?> clazz = findClass("******", classLoader);
        Object object = callStaticMethod(clazz,"AH");
        clazz = findClass("******", classLoader);
        object = newInstance(clazz, object);
        String arg1 = "******";
        String arg2 = null;
        List arg3 = new ArrayList();
        arg3.add("******");
        arg3.add("******");
        arg3.add("******");
        arg3.add("******");
        List arg4 = new ArrayList();
        arg4.add("******");
        boolean arg5 = true;
        boolean arg6 = true;
        Cursor cursor = (Cursor)callMethod(object, "******", arg1, arg2, arg3, arg4, arg5, arg6);
        List<Map<String, Object>> list = CommonUtils.parseCursor(cursor);
        return list;
    }

}
