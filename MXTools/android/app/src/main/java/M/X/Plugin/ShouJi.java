package M.X.Plugin;

import android.app.Activity;
import android.util.Log;
import com.Nightmare.Tools.Cmd;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

public class ShouJi implements EventChannel.StreamHandler {
    public static String ShouJi = "Third3/ShouJi";
    private String Name = "";
    static EventChannel channe;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private ShouJi(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channe = new EventChannel(registrar.messenger(), ShouJi);
        ShouJi instance = new ShouJi(registrar.activity());
        channe.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Name = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.name\" | busybox sed 's/ro.product.name=//g'\n");
                    eventSink.success(Name);
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
