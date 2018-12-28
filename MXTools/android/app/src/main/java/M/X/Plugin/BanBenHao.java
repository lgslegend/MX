package M.X.Plugin;

import android.app.Activity;
import android.util.Log;
import com.Nightmare.Tools.Cmd;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

public class BanBenHao implements EventChannel.StreamHandler {
    public static String BanBenHao = "Third3/BanBenHao";
    private String DisplayId = "";
    static EventChannel channe;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private BanBenHao(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channe = new EventChannel(registrar.messenger(), BanBenHao);
        BanBenHao instance = new BanBenHao(registrar.activity());
        channe.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    DisplayId = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.display.id\" | busybox sed 's/ro.build.display.id=//g'\n");
                    eventSink.success(DisplayId);
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
