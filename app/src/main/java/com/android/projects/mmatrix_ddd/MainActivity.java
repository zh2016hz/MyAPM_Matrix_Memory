package com.android.projects.mmatrix_ddd;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.os.SystemClock;
import android.provider.Settings;
import android.view.View;

import com.tencent.matrix.trace.view.FrameDecorator;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MyFrameDecorator decorator = MyFrameDecorator.getInstance(this);


// 检测浮窗权限
        if (!canDrawOverlays()) {
            requestWindowPermission();
        } else {
            decorator.show();
        }
    }

    private void requestWindowPermission() {
        startActivityForResult( new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION, Uri.parse("package:"+getPackageName())),100);
    }

    private boolean canDrawOverlays() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            return Settings.canDrawOverlays(this);
        } else {
            return true;
        }
    }

    public void click(View view) {

        test1();
    }

    void test1() {
        SystemClock.sleep(400);
        test2();
    }

    void test2() {
        SystemClock.sleep(200);
    }
}