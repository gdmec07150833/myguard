package cn.edu.s07150833gdmec.myguard.m1home.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.net.Uri;
import java.io.File;

public class MyUtils {

    //@param context @raturn返回版本号

    public static String getVersion(Context context) {
        // PackageManager可以获取清单文件中的所有信息
        PackageManager manager = context.getPackageManager();
        try {
            //获取到一个应用程序的信息
            // getPackageNameO获取到当前程序的包名
            PackageInfo packagelnfo = manager.getPackageInfo(context.getPackageName(), 0);
            return packagelnfo.versionName;
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
            return "";
        }
    }

    public static void installApk(Activity activity) {
        Intent intent = new Intent("android.intent.action.VIEW");
        //添加默认分类
        intent.addCategory("android.intent.category.DEFAULT");
        //设置数据和类型在文件中
        intent.setDataAndType(
                Uri.fromFile(new File("/mnt/sdcard/mobilesafe2.0.apk")),
                "application/vnd.android.package-archive");
        //如果开启的activity退出的时候会回调当前activity的onActivityResult
        activity.startActivityForResult(intent, 0);
    }
}