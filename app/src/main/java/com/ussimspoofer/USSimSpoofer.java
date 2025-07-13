package com.ussimspoofer;

import de.robv.android.xposed.IXposedHookLoadPackage;
import de.robv.android.xposed.XC_MethodHook;
import de.robv.android.xposed.XposedHelpers;
import de.robv.android.xposed.callbacks.XC_LoadPackage;

public class USSimSpoofer implements IXposedHookLoadPackage {

    // Target SIM spoof values (USA)
    private static final String SIM_COUNTRY_ISO = "us";
    private static final String NETWORK_COUNTRY_ISO = "us";
    private static final String SIM_OPERATOR = "310004";

    // Target package to spoof (change this to match your app)
    private static final String TARGET_PACKAGE = "com.zhiliaoapp.musically";

    @Override
    public void handleLoadPackage(XC_LoadPackage.LoadPackageParam lpparam) {
        if (!lpparam.packageName.equals(TARGET_PACKAGE)) return;

        try {
            Class<?> telephonyClass = Class.forName(
                "android.telephony.TelephonyManager",
                false,
                lpparam.classLoader
            );

            // Hook methods to spoof SIM data
            hookMethod(telephonyClass, "getSimCountryIso", SIM_COUNTRY_ISO);
            hookMethod(telephonyClass, "getNetworkCountryIso", NETWORK_COUNTRY_ISO);
            hookMethod(telephonyClass, "getSimOperator", SIM_OPERATOR);

        } catch (Throwable t) {
            // Error suppression 
        }
    }

    // Helper method to hook TelephonyManager methods
    private void hookMethod(Class<?> clazz, String methodName, final Object result) {
        XposedHelpers.findAndHookMethod(
            clazz,
            methodName,
            new XC_MethodHook() {
                @Override
                protected void afterHookedMethod(MethodHookParam param) {
                    param.setResult(result);
                }
            }
        );
    }
}
