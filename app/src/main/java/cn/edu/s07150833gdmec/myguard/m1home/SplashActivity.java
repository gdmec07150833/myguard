package cn.edu.s07150833gdmec.myguard.m1home;

import android.app.Activity;
import android.os.Bundle;
import android.view.Window;
import android.widget.TextView;

import cn.edu.s07150833gdmec.myguard.R;
import cn.edu.s07150833gdmec.myguard.m1home.utils.MyUtils;
import cn.edu.s07150833gdmec.myguard.m1home.utils.VersionUpdateUtils;

public class SplashActivity extends Activity {

    private TextView mVersionTV;
    private String mVersion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        mVersion= MyUtils.getVersion(getApplicationContext());
        initView();
        final VersionUpdateUtils updateUtils=new VersionUpdateUtils(mVersion,SplashActivity.this);
        new Thread(){
            public void run(){
                //获取服务器版本号
                updateUtils.getCloudVersion();
            };
        }.start();
    }
        //初始化控件
        private void initView(){
        mVersionTV= (TextView) findViewById(R.id.tv_splash_version);
        mVersionTV.setText("版本号"+mVersion);

    }
}
