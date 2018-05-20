package com.sxy.api.wechat;

import com.sxy.api.util.CommonUtils;
import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XposedBridge;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class XposedInit implements IXposedHookLoadPackage{
    @Override
    public void handleLoadPackage(final XC_LoadPackage.LoadPackageParam lpparam) throws Throwable {

        if(!lpparam.packageName.contains(Constent.PACKAGE_NAME)){
            return;
        }
        switch (CommonUtils.getVersion()){
            case "***":
                MessageHandler.listenerMessage(lpparam.classLoader);
                break;
            default:
                XposedBridge.log("this version is not support.");
        }
    }

}

