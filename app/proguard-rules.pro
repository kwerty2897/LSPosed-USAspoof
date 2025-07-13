# General optimizations
-optimizationpasses 5
-dontusemixedcaseclassnames
-dontskipnonpubliclibraryclasses
-dontpreverify

# Keep classes that implement Xposed entry point
-keep class * implements de.robv.android.xposed.IXposedHookLoadPackage { *; }

# Keep hook parameter annotations
-keepclassmembers class * {
    @de.robv.android.xposed.XposedBridge$BeforeHookParam *;
    @de.robv.android.xposed.XposedBridge$AfterHookParam *;
}

# Keep Application class
-keep public class * extends android.app.Application

# Keep all Xposed classes and interfaces
-keep class de.robv.android.xposed.** { *; }
-keep interface de.robv.android.xposed.** { *; }
