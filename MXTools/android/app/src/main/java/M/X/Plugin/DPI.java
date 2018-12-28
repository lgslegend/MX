package M.X.Plugin;

import android.app.Activity;
import android.content.Context;
import android.graphics.Point;
import android.os.Build;
import android.util.Log;

import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;

import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

import android.util.DisplayMetrics;
import android.view.Display;
import android.view.WindowManager;

public class DPI implements EventChannel.StreamHandler {
    public static String third3 = "Third3";
    private static final String Third = "Third";
    private String mCurrentDPI = "";
    static EventChannel channel;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private DPI(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channel = new EventChannel(registrar.messenger(), third3);
        DPI instance = new DPI(registrar.activity());
        channel.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    WindowManager wm = (WindowManager) MyApplication.getAppContext().getSystemService(Context.WINDOW_SERVICE);
                    assert wm != null;
                    Display display = wm.getDefaultDisplay();
                    DisplayMetrics dm = MyApplication.getAppContext().getResources().getDisplayMetrics();
                    //获取系统显示尺寸
                    Point outSize = new Point();
                    if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN_MR1) {
                        display.getRealSize(outSize);
                    }
                    int mWidth = outSize.x;
                    int mHeight = outSize.y;
                    eventSink.success("" + dm.densityDpi + mWidth + mHeight);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    @Override
    public void onCancel(Object o) {
        Log.i("FlutterPluginCounter", "FlutterPluginCounter:onCancel");
    }

}
