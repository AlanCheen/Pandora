package me.yifeiyuan.pandoradev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import me.yifeiyuan.pandora.LifecycleHandler;
import me.yifeiyuan.pandora.ToastUtils;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LifecycleHandler(this).sendEmptyMessage(1);
    }

    public void onTestToastUtils(View view) {

        long time = System.currentTimeMillis();
        ToastUtils.debug("Time:" + time);
    }
}
