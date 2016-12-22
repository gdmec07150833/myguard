package cn.edu.s07150833gdmec.myguard.m1home.utils;

import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;

import java.io.File;


public class DownLoadUtils {
    /*
    下载APK的方法
    */
    public void downapk(String url, String targerFile, final MyCallBack myCallBack) {
        //创建HttpUtils 对象
        HttpUtils httpUtils = new HttpUtils();
        //调用HttpUtils下载的方法下载指定文件
        httpUtils.download(url, targerFile, new RequestCallBack<File>() {

            @Override
            public void onSuccess(ResponseInfo<File> argO) {
                myCallBack.onSuccess(argO);
            }

            @Override
            public void onFailure(HttpException argO, String arg1) {
                myCallBack.onFailure(argO, arg1);
            }

            @Override
            public void onLoading(long total, long current, boolean isUploading) {
                super.onLoading(total, current, isUploading);
                myCallBack.onLoadding(total, current, isUploading);
            }
        });
    }


    /*
    *接口，用于监听下载状态的接口
    */
    interface MyCallBack {
        /**
         * 下载成功时调用
         */
        void onSuccess(ResponseInfo<File> argO);

        /**
         * 下载失败时调用
         */
        void onFailure(HttpException argO, String arg1);

        /**
         * 下载中调用
         */
        void onLoadding(long total, long current, boolean isUploading);
    }
}
