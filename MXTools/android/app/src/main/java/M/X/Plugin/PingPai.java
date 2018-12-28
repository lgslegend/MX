package M.X.Plugin;

import android.app.Activity;
import android.util.Log;
import com.Nightmare.Tools.Cmd;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

public class PingPai implements EventChannel.StreamHandler {
    public static String PingPai = "Third3/PingPai";
    private String Brand = "";
    static EventChannel channe;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private PingPai(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channe = new EventChannel(registrar.messenger(), PingPai);
        PingPai instance = new PingPai(registrar.activity());
        channe.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Brand = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.brand\" | busybox sed 's/ro.product.brand=//g'\n");
                    eventSink.success(Brand);
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
