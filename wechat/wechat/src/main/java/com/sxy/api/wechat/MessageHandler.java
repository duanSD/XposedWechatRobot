package com.sxy.api.wechat;

import android.content.ContentValues;
import android.os.Bundle;
import com.sxy.api.util.ImageUtils;
import java.lang.reflect.Field;
import java.util.ArrayList;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedBridge;
import static de.robv.android.xposed.XposedHelpers.callMethod;
import static de.robv.android.xposed.XposedHelpers.callStaticMethod;
import static de.robv.android.xposed.XposedHelpers.findAndHookMethod;
import static de.robv.android.xposed.XposedHelpers.findClass;
import static de.robv.android.xposed.XposedHelpers.newInstance;


public class MessageHandler {

    public static void listenerMessage(final ClassLoader classLoader){
        findAndHookMethod("******", classLoader, "******", new XC_MethodHook() {
            @Override
            protected void afterHookedMethod(MethodHookParam param) throws Throwable {
                ContentValues result =(ContentValues) param.getResult();
                String sender = result.getAsString("username");
                String isSend = result.getAsString("isSend");
                String type = result.getAsString("msgType");
                String content = result.getAsString("content");
                if("0".equals(isSend)){
                    XposedBridge.log("type:"+type);
                    XposedBridge.log("sender:"+sender);
                    XposedBridge.log("content:"+content);
                }
            }
        });
    }
    public static void sendText(ClassLoader classLoader,String toUser,String content){
        Class<?> clazz = findClass("******", classLoader);
        Object obj = newInstance(clazz, toUser, content, 1, 0, null);
        Object sendTextObj = callStaticMethod(findClass("******", classLoader), "******");
        callMethod(sendTextObj, "******",obj,0);
    }
    public static void sendImg(ClassLoader classLoader, ArrayList addressList, String toUser){
        Class<?> clazz = findClass("******", classLoader);
        Object obj = callStaticMethod(clazz, "******");
        callMethod(obj, "******",addressList,true,0,0,toUser,0);
        callMethod(obj,"******",addressList.get(0));
        clazz = findClass("******", classLoader);
        callMethod(newInstance(clazz),"******");
    }

    public static void sendAppMsg(ClassLoader classLoader,String toUser,String picUrl,String url,String title,String desc) throws Exception {
        Class<?> clazz = findClass("******",classLoader);
        Bundle bundle = new Bundle();
        bundle.putString("******",title);
        bundle.putString("******",desc);
        bundle.putString("******","******");
        bundle.putString("******",url);
        bundle.putByteArray("******", ImageUtils.getImageFromNetByUrl(picUrl));
        Object wxmediaModel =  callStaticMethod(clazz,"******",bundle);

        clazz = findClass("******", classLoader);
        Object filedParam = newInstance(clazz);
        Field field = clazz.getField("eTM");
        field.set(filedParam,wxmediaModel);
        field = clazz.getField("fbk");
        field.set(filedParam,2);
        field = clazz.getField("toUser");
        field.set(filedParam,toUser);

        clazz = findClass("******", classLoader);
        Object methodParam = newInstance(clazz);
        field = clazz.getField("wft");
        field.setBoolean(methodParam, false);
        field = clazz.getField("fbj");
        field.set(methodParam,filedParam);

        clazz = findClass("******", classLoader);
        Object wk = newInstance(clazz, callStaticMethod(findClass("******", classLoader), "qh"));
        callMethod(wk,"******",methodParam);
    }

}
