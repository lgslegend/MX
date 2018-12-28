package M.X.Plugin;

import android.app.Activity;
import android.util.Log;
import com.Nightmare.Tools.Cmd;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

public class ChangShang implements EventChannel.StreamHandler {

    public static String ChangShang = "Third3/ChangShang";
    private String Manufacturer = "";
    static EventChannel channe;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private ChangShang(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {

        channe = new EventChannel(registrar.messenger(), ChangShang);
        ChangShang instance = new ChangShang(registrar.activity());
        channe.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Manufacturer = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.manufacturer\" | busybox sed 's/ro.product.manufacturer=//g'\n");
                    eventSink.success(Manufacturer);
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
