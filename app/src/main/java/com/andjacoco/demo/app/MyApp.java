package com.andjacoco.demo.app;

import android.app.Application;
import android.util.Log;

import com.andjacoco.demo.BuildConfig;

import org.jacoco.agent.rt.CodeCoverageManager;

public class MyApp extends Application {
    public static Application app;

    private static final String TAG = "MyApp";

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;
        Log.i(TAG, "初始化开始");
        CodeCoverageManager.init(app, BuildConfig.host);//内网 服务器地址);
        CodeCoverageManager.uploadData();
        Log.i(TAG, "初始化结束");
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            CodeCoverageManager.generateCoverageFile();
        }
    }
}
