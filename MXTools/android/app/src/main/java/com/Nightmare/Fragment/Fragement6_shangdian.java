package com.Nightmare.Fragment;

import android.app.*;
import android.content.*;
import android.graphics.Color;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import M.X.*;
import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MainActivity;
import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;

import java.lang.reflect.Field;

public class Fragement6_shangdian extends BaseFragment {
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fuzhu_shangdian, container,  
										 false);
		rootView.findViewById(R.id.fuzhu_shangdian).setOnClickListener(new OnClickListener(){
				@Override
				public void onClick(View p1)
				{
					AlertDialog shangdian = new AlertDialog.Builder(getActivity())
						.setTitle(R.string.gf_dialog_title)
						.setMessage("此操作将会重启系统")
						.setPositiveButton(R.string.Btn_Sure,
						new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								Toast.makeText(MyApplication.getAppContext(),"正在执行相关脚本" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
								new Thread(new Runnable() {
									public void run() {
										try
										{
                                            Thread.sleep(250);
											Cmd.cmd("mount -o rw,remount /system\n" +
													"mv /system/app/MiuiSuperMarket/MiuiSuperMarket.bak /system/app/MiuiSuperMarket/MiuiSuperMarket.apk\n" +
													"sleep 1\n" +
													"reboot\n");
                                            Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
										} catch (Throwable throwable) {
											throwable.printStackTrace();
										}
									}
								}).start();

							}
						}).setNegativeButton(R.string.Btn_Cancel, null).show();

					try {
						Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
						mAlert.setAccessible(true);
						Object mAlertController = mAlert.get(shangdian);
						//通过反射修改title字体大小和颜色
						Field mTitle = mAlertController.getClass().getDeclaredField("mTitleView");
						mTitle.setAccessible(true);
						TextView mTitleView = (TextView) mTitle.get(mAlertController);
						mTitleView.setTextSize(20);
						mTitleView.setTextColor(Color.BLACK);
						//通过反射修改message字体大小和颜色
						Field mMessage = mAlertController.getClass().getDeclaredField("mMessageView");
						mMessage.setAccessible(true);
						TextView mMessageView = (TextView) mMessage.get(mAlertController);
						mMessageView.setTextSize(18);
						mMessageView.setTextColor(Color.BLACK);
					} catch (IllegalAccessException e1) {
						e1.printStackTrace();
					} catch (NoSuchFieldException e2)
					{
						e2.printStackTrace();
					}
				}
		});
        return rootView;
	}


	public void onBackPressed() {
		//很明显,判断Fragment栈里面有没有回退.
		//如果Fragment回退栈有还有Fragment
		//则回退一次Fragment,没有才调用onBackPressedNotHandled();
		//
		Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
	}

}
