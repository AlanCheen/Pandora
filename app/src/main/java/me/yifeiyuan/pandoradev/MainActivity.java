package me.yifeiyuan.pandoradev;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import me.yifeiyuan.pandora.LifecycleHandler;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new LifecycleHandler(this).sendEmptyMessage(1);
    }
}
