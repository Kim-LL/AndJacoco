package com.andjacoco.demo;

import android.app.Application;
import android.util.Log;

import org.jacoco.agent.rt.CodeCoverageManager;

public class MyApp extends Application {
    public static Application app;

    @Override
    public void onCreate() {
        super.onCreate();
        app = this;

        CodeCoverageManager.init(app, BuildConfig.host);//内网 服务器地址);
        CodeCoverageManager.uploadData();

        //新增方法测试
        addTest();
    }

    private void addTest() {
        int i = 20;
        int j = 2;
        int z = i/j;
        Log.i("jacoco-log", String.valueOf(z));
    }

    @Override
    public void onTrimMemory(int level) {
        super.onTrimMemory(level);
        if (level == TRIM_MEMORY_UI_HIDDEN) {
            Log.i("jacoco-log","onTrimMemory generateCoverageFile");
            CodeCoverageManager.generateCoverageFile();
        }
    }
}
