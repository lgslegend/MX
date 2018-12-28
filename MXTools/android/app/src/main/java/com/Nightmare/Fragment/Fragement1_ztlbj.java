package com.Nightmare.Fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;

import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MainActivity;
import com.Nightmare.MyApplication;
import M.X.R;
import com.Nightmare.Tools.Cmd;

public class Fragement1_ztlbj extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
            case R.id.ztlbj_caonima:
                Toast.makeText(MyApplication.getAppContext(),"正在设置" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
				new Thread(new Runnable() {
					public void run() {
                        try
                        {
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
                        }catch (Throwable throwable) {
							throwable.printStackTrace();
						}
						}
				}).start();
                new Thread(new Runnable() {
                    public void run() {
                        try
                        {
                            Thread.sleep(500);
                            Cmd.cmdT("busybox killall com.android.systemui\n");
                        }catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                }).start();
                break;
			case R.id.ztlbj_ios:
				Toast.makeText(MyApplication.getAppContext(),"正在设置" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
				new Thread(new Runnable() {
					public void run() {
						try
						{
							Cmd.cmdT("mount -o rw,remount /system\n" +
									"if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\" ]; then\n" +
									"mount -o rw,remount /system\n" +
									"else\n" +
									"cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\n" +
									"fi\n" +
									"cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip\n" +
									"cd /system/usr/Nightmare/2/Nightmare/2/$f/\n" +
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
						}catch (Throwable throwable) {
							throwable.printStackTrace();
						}
					}
				}).start();
				new Thread(new Runnable() {
					public void run() {
						try
						{
							Thread.sleep(500);
							Cmd.cmdT("busybox killall com.android.systemui\n");
						}catch (Throwable throwable) {
							throwable.printStackTrace();
						}
					}
				}).start();
				break;
			case R.id.ztlbj_sjjz:
				Toast.makeText(MyApplication.getAppContext(),"正在设置" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
				new Thread(new Runnable() {
					public void run() {
						try
						{
							Cmd.cmd("mount -o rw,remount /system\n" +
									"if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\" ]; then\n" +
									"mount -o rw,remount /system\n" +
									"else\n" +
									"cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\n" +
									"fi\n" +
									"cp /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk /system/priv-app/MiuiSystemUI/MiuiSystemUI.zip\n" +
									"cd /system/usr/Nightmare/2/Nightmare/3/$f/\n" +
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
						}catch (Throwable throwable) {
							throwable.printStackTrace();
						}
					}
				}).start();
				new Thread(new Runnable() {
					public void run() {
						try
						{
							Thread.sleep(500);
							Cmd.cmd("busybox killall com.android.systemui\n");
						}catch (Throwable throwable) {
							throwable.printStackTrace();
						}
					}
				}).start();
				break;
			case R.id.ztlbj_default:
				Toast.makeText(MyApplication.getAppContext(),"正在设置" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
                new Thread(new Runnable() {
                    public void run() {
                        try {
                            Thread.sleep(250);
                            Cmd.cmdT("mount -o rw,remount /system\n" +
                                    "if [ -f \"/system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2\" ]; then\n" +
                                    "mv /system/priv-app/MiuiSystemUI/MiuiSystemUI.bak2 /system/priv-app/MiuiSystemUI/MiuiSystemUI.apk\n" +
                                    "else\n" +
                                    "mount -o rw,remount /system\n" +
                                    "fi\n" +
                                    "chmod -R 0644 /system/media/theme/default/com.android.systemui\n" +
                                    "sleep 1\n" +
                                    "busybox killall com.android.systemui\n");
                        }catch (Throwable throwable) {
							throwable.printStackTrace();
						}
					}
                }).start();
				break;
		}
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.miui_ztlbj, container,  
										 false);
		rootView.findViewById(R.id.ztlbj_sjjz).setOnClickListener(this);
		rootView.findViewById(R.id.ztlbj_ios).setOnClickListener(this);
		rootView.findViewById(R.id.ztlbj_default).setOnClickListener(this);
		rootView.findViewById(R.id.ztlbj_caonima).setOnClickListener(this);

        return rootView;
	}
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        }
	
	
}
