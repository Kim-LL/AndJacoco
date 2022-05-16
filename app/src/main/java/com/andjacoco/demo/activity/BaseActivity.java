package com.andjacoco.demo.activity;

import android.content.pm.PackageManager;
import android.util.Log;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import com.andjacoco.demo.utils.PermissionUtils;

import org.jacoco.agent.rt.CodeCoverageManager;

/**
 * FileName: BaseActivity
 * Author: zhihao.wu@ttpai.cn
 * Date: 2020/9/23
 * Description:
 */
public class BaseActivity extends AppCompatActivity {

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d("TAG","BaseActivity onDestroy");
        PermissionUtils.checkPermission(this);
        CodeCoverageManager.generateCoverageFile();

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == 0) {
            // 说明这个是申请权限的返回
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] != PackageManager.PERMISSION_GRANTED) {
                    boolean showRequestPermission = ActivityCompat.shouldShowRequestPermissionRationale(this, permissions[i]);
                    if (showRequestPermission) {
                        PermissionUtils.checkPermission(this);
                        return;
                    }
                }
            }
        } else {
            super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        }
    }
}
