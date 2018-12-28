package com.Nightmare;
import android.content.Context;
import android.graphics.Typeface;
import com.pgyersdk.crash.*;

import io.flutter.app.FlutterApplication;

public class MyApplication extends FlutterApplication {
    public static Typeface TypeFaceYaHei;
    private static Context context;

	private static MyApplication mApplication;

	public synchronized static MyApplication getInstance() {
		return mApplication;
}

	private void initData() {
		//当程序发生Uncaught异常的时候,由该类来接管程序,一定要在这里初始化
		//CrashHandler.getInstance().init(this);
	}
	
	
		
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();
		PgyCrashManager.register(this);
		initData();
    }

    public static Context getAppContext() {
        return context;
    }
}
