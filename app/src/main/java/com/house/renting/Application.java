package com.house.renting;

import android.content.Context;

/**
 * Created by zeting
 * Date 2019-08-26.
 */
public class Application extends android.app.Application {
    private static android.app.Application sApplication;
    @Override
    public void onCreate() {
        super.onCreate();
        CommonUtils.init(this);
        sApplication = this;
    }
    public static Context getContext() {
        return sApplication;
    }
}
