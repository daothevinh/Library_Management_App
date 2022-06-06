package com.example.quanlythuvien;

import android.app.Application;

import androidx.multidex.MultiDexApplication;

import com.blankj.utilcode.util.Utils;

public class BaseApplication extends MultiDexApplication {
    @Override
    public void onCreate() {
        super.onCreate();
        Utils.init(this);
    }
}
