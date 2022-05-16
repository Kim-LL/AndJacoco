package com.andjacoco.demo.utils;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

import android.Manifest;
import android.app.Activity;

import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

public class PermissionUtils {

    public static boolean checkPermission(Activity activity) {

        List<String> permissions = new ArrayList<>();

        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.WRITE_EXTERNAL_STORAGE) != PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.WRITE_EXTERNAL_STORAGE);
        }
        if (ContextCompat.checkSelfPermission(activity, Manifest.permission.INTERNET) != PERMISSION_GRANTED) {
            permissions.add(Manifest.permission.INTERNET);
        }
        if(permissions.isEmpty()){
            return true;
        }
        ActivityCompat.requestPermissions(activity, permissions.toArray(new String[0]), 0);
        return false;
    }
}
