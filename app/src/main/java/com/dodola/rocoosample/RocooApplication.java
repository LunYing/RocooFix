/*
 * Copyright (C) 2016 Baidu, Inc. All Rights Reserved.
 */
package com.dodola.rocoosample;

import android.app.Application;
import android.content.Context;

import com.dodola.rocoofix.RocooFix;

import java.io.File;

/**
 * Created by sunpengfei on 16/5/24.
 */
public class RocooApplication extends Application {
    @Override
    protected void attachBaseContext(Context base) {
        super.attachBaseContext(base);

        RocooFix.init(this);
        String path = "/sdcard/fix";
        File file = new File(path);
        if (!file.exists() && !file.isDirectory()) {
            file.mkdir();
        }
        File vFile = new File(path+"/patch.jar");
        if(vFile.exists()){
            RocooFix.applyPatch(this, path+"/patch.jar");
        }

    }
}
