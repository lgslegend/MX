package M.X.Plugin;

import android.app.Activity;
import android.util.Log;
import com.Nightmare.Tools.Cmd;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

public class JiXing implements EventChannel.StreamHandler {
    public static String XingHao = "Third3/JiXing";
    public static String ChangShang = "Third3/ChangShang";
    private static final String Third = "Third";
    private String Brand = "";
    private String Manufacturer = "";
    private String Model = "";
    private String Name = "";
    private String Id = "";
    private String DisplayId = "";
    static EventChannel channel;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private JiXing(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channel = new EventChannel(registrar.messenger(), XingHao);
        JiXing instance = new JiXing(registrar.activity());
        channel.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Model = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.model\" | busybox sed 's/ro.product.model=//g'\n");
                    Manufacturer = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.manufacturer\" | busybox sed 's/ro.product.manufacturer=//g'\n");
                    Brand = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.brand\" | busybox sed 's/ro.product.brand=//g'\n");
                    Name = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.name\" | busybox sed 's/ro.product.name=//g'\n");
                    Id = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.id\" | busybox sed 's/ro.build.id=//g'\n");
                    DisplayId = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.display.id\" | busybox sed 's/ro.build.display.id=//g'\n");
                    eventSink.success(Model+Manufacturer+Brand+Name+Id+DisplayId);
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
