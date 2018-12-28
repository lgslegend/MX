package M.X;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.widget.Toast;

import com.Nightmare.About;
import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;
import com.pgyersdk.crash.PgyCrashManager;
import com.pgyersdk.feedback.PgyFeedback;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

import java.io.IOException;

import M.X.Plugin.JiXing;
import M.X.Plugin.DPI;
import io.flutter.app.FlutterActivity;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.PluginRegistry;
import io.flutter.plugins.GeneratedPluginRegistrant;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;
import static com.Nightmare.MainActivity.getEmojiStringByUnicode;


public class MainActivity extends FlutterActivity {
    private PackageInfo info;
    private SharedPreferences prefs;
    private int currentVersion;
    private String Model = "";
    private String mCurrentDPI = "";
    private static final String DrawerHeader = "DrawerHeader";
    private static final String First1 = "First1";
    private static final String First = "First";
    private static final String Toast0 = "Toast";
    private static final String Linux = "Linux";
    private static final String Third = "Third";
    private static final String Fourth = "Fourth";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        GeneratedPluginRegistrant.registerWith(this);
        registerCustomPlugin(this);
        PgyCrashManager.register(this);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            getWindow().setStatusBarColor(0);
        }
        DrawerHeader();//侧拉栏
        First1();
        Third();
        Fourth();
        Toast0();
        Linux();
        new Thread(new Runnable() {
            public void run() {
                try {
                    if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.sf.lcd_density\"\n") == null) {
                        Cmd.cmdT("mount -o rw,remount /system\n" +
                                "echo \"ro.sf.lcd_density=440\"  >> /system/build.prop");
                    }
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }

    private static void registerCustomPlugin(PluginRegistry registrar) {
        //这个应该可以延时
        JiXing.registerWith(registrar.registrarFor(JiXing.XingHao));
        DPI.registerWith(registrar.registrarFor(DPI.third3));
    }

    void Linux() {
        new MethodChannel(getFlutterView(), Linux).setMethodCallHandler(new MethodCallHandler() {
            @Override
            public void onMethodCall(final MethodCall call, Result result) {
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Cmd.cmdT(call.method);
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }).start();
            }
        });
    }

    void Toast0() {
        new MethodChannel(getFlutterView(), Toast0).setMethodCallHandler(new MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall call, Result result) {
                        Toast.makeText(MyApplication.getAppContext(), call.method + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                        //Toast.makeText(MainActivity.this,"正在执行相关脚本，请等待两秒左右" + com.Nightmare.MainActivity.getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();

            }
        });
    }

    void Third() {
        new MethodChannel(getFlutterView(), Third).setMethodCallHandler(new MethodCallHandler() {
            @Override
            public void onMethodCall(final MethodCall call, Result result) {
                String id = call.method;
                switch (id) {
                    case "DPI":
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Cmd.cmdT("mount -o rw,remount /system");
                                    Cmd.cmdT("wm size reset");
                                    String a = call.argument("string");
                                    Cmd.cmdT("wm density " + a);
                                } catch (IOException e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        result.success("hjh");
                        break;
                }
            }
        });
    }

    void Fourth() {
        new MethodChannel(getFlutterView(), Fourth).setMethodCallHandler(new MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall call, Result result) {
                String id = call.method;
                switch (id) {
                    case "HeiYu":
                        Toast.makeText(MyApplication.getAppContext(), "正在执行相关脚本，请等待两秒左右" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Cmd.cmd("chmod 777 /system/app/Brevent/lib/arm64/libbrevent.so");
                                    Cmd.cmd("/system/app/Brevent/lib/arm64/libbrevent.so");
                                } catch (Throwable e) {
                                    e.printStackTrace();
                                }
                            }
                        }).start();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(2000);
                                    Intent intent = new Intent();
                                    intent.setClassName("me.piebridge.brevent", "me.piebridge.brevent.ui.BreventActivity");
                                    MainActivity.this.startActivity(intent);
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).start();
                        break;
                    case "DongJie":
                        MyApplication.getAppContext().startActivity(new Intent().setClassName("com.smartapp.appfreezer", "com.smartapp.appfreezer.MainActivity"));
                        break;
                    case "KuiShe":
                        MyApplication.getAppContext().startActivity(new Intent().setClassName("com.audlabs.viperfx", "com.audlabs.viperfx.main.MainActivity"));
                        break;
                    case "DuBi":
                        MyApplication.getAppContext().startActivity(new Intent().setClassName("com.atmos.daxappUI", "com.atmos.daxappUI.MainActivity"));
                        break;
                }
            }
        });
    }

    void First1() {
        new MethodChannel(getFlutterView(), First1).setMethodCallHandler(new MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall call, Result result) {
                String id = call.method;
                switch (id) {
                    case "Single_CaoNiMa":
                        Toast.makeText(MyApplication.getAppContext(), "正在设置" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Cmd.cmdT("mount -o rw,remount /system\n" +
                                            "if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\" ]; then\n" +
                                            "mount -o rw,remount /system\n" +
                                            "else\n" +
                                            "cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\n" +
                                            "fi\n" +
                                            "cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip\n" +
                                            "cd /system/usr/Nightmare/2/Nightmare/4/$f/\n" +
                                            "/system/usr/Nightmare/mengyan -r /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip *\n" +
                                            "mv /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak1\n" +
                                            "if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak1\" ]; then\n" +
                                            "rm -rf /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                                            "mv /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak1 /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                                            "else\n" +
                                            "mount -o rw,remount /system\n" +
                                            "fi\n" +
                                            "chmod -R 0644 /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                                            "sleep 1\n");
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).start();
                        new Thread(new Runnable() {
                            public void run() {
                                try {
                                    Thread.sleep(2000);
                                    Cmd.cmdT("busybox killall com.android.systemui\n");
                                } catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).start();
                        break;
                }
            }
        });
    }

    void DrawerHeader() {
        new MethodChannel(getFlutterView(), DrawerHeader).setMethodCallHandler(new MethodCallHandler() {
            @Override
            public void onMethodCall(MethodCall call, Result result) {
                String id = call.method;
                switch (id) {
                    case "Check":
                        if (Build.VERSION.SDK_INT >= 23) {//判断当前系统的版本
                            int checkWriteStoragePermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
                            if (checkWriteStoragePermission != PERMISSION_GRANTED) {//如果没有被授予
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                                //请求获取该种权限
                            } else {
                                PgyUpdateManager.register(MainActivity.this,
                                        new UpdateManagerListener() {

                                            @Override
                                            public void onUpdateAvailable(final String result) {

                                                // 将新版本信息封装到AppBean中
                                                final AppBean appBean = getAppBeanFromString(result);
                                                new AlertDialog.Builder(MainActivity.this).setTitle("更新");
                                                new AlertDialog.Builder(MainActivity.this).setMessage("1212");
                                                new AlertDialog.Builder(MainActivity.this).setNegativeButton(
                                                        "确定",
                                                        new DialogInterface.OnClickListener() {

                                                            @Override
                                                            public void onClick(
                                                                    DialogInterface dialog,
                                                                    int which) {
                                                                startDownloadTask(
                                                                        MainActivity.this,
                                                                        appBean.getDownloadURL());
                                                            }
                                                        });
                                                new AlertDialog.Builder(MainActivity.this).show();
                                            }

                                            @Override
                                            public void onNoUpdateAvailable() {
                                                Toast.makeText(MyApplication.getAppContext(), "还没有更新", Toast.LENGTH_SHORT).show();
                                                //这里是没有跟新的
                                            }
                                        });
                            }
                        } else {
                        }
                        break;
                    case "BugReport":
                        if (Build.VERSION.SDK_INT >= 23) {//判断当前系统的版本
                            //判断是否已经赋予权限
                            int checkWriteStoragePermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
                            if (checkWriteStoragePermission != PERMISSION_GRANTED) {//如果没有被授予
                                ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                                //请求获取该种权限
                            } else {
                                int recordPermission = ContextCompat.checkSelfPermission(MainActivity.this, Manifest.permission.RECORD_AUDIO);//获取系统是否被授予该种权限
                                if (recordPermission != PERMISSION_GRANTED) {//如果没有被授予
                                    ActivityCompat.requestPermissions(MainActivity.this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
                                    //请求获取该种权限
                                } else {
                                }
                                PgyFeedback.getInstance().showDialog(MainActivity.this);//定义好的获取权限后的处理的事件
                            }
                        } else {
                        }
                        break;

                    case "Exit":
                        finish();
                        break;
                    case "About":

                        Intent intent = new Intent();
                        intent.setClass(MainActivity.this, About.class);
                        MainActivity.this.startActivity(intent);
                }

            }
        });

    }

    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {
                    Toast.makeText(MyApplication.getAppContext(), "" + "权限" + permissions[i] + "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(MyApplication.getAppContext(), "" + "权限" + permissions[i] + "申请失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }

}
