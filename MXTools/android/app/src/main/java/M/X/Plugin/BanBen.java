package M.X.Plugin;

import android.app.Activity;
import android.util.Log;
import com.Nightmare.Tools.Cmd;
import io.flutter.plugin.common.EventChannel;
import io.flutter.plugin.common.PluginRegistry;

public class BanBen implements EventChannel.StreamHandler {

    public static String BanBen = "Third3/Banben";
    private String Id = "";
    static EventChannel channe;

    private Activity activity;

//    static BasicMessageChannel basicMessageChannel;

    private BanBen(Activity activity) {
        this.activity = activity;
    }

    public static void registerWith(PluginRegistry.Registrar registrar) {
        channe = new EventChannel(registrar.messenger(), BanBen);
        BanBen instance = new BanBen(registrar.activity());
        channe.setStreamHandler(instance);
        // basicMessageChannel = new BasicMessageChannel<String> ("foo", StringCodec.INSTANCE);
    }

    @Override
    public void onListen(Object o, final EventChannel.EventSink eventSink) {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Id = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.id\" | busybox sed 's/ro.build.id=//g'\n");
                    eventSink.success(Id);
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
