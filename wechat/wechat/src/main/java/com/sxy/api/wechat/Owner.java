package com.sxy.api.wechat;

import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;

public class Owner {

    public static String getMyID(ClassLoader classLoader){
        Class<?> clazz = findClass("******", classLoader);
        Object wxid = callStaticMethod(clazz, "pG");
        return wxid.toString();
    }
}
