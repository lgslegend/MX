package com.Nightmare.Fragment;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Toast;
import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MainActivity;
import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;
import M.X.R;

public class Fragement6_zidingyi extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id =p1.getId();
		switch(id){
			case R.id.zidingyi_jsq:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/Calculator\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_dzyj:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/Email\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}


								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;

			case R.id.zidingyi_wjgl:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/FileExplorer\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
			case R.id.zidingyi_dtbz:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/LiveWallpapers\n" +
												"rm -rf /system/app/LiveWallpapersPicker\n" +
												"sleep ");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_xmqb:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
										Cmd("sh /system/usr/Nightmare/bin/Lite_Mipay.sh");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_znz:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/MiuiCompass\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_sys:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/MiuiScanner\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_xmsp:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/MiuiVideo\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_bq:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/Notes\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_qjss:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/QuickSearchBox\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_sg:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/SogouInput\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_yyzs:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/VoiceAssist\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_xmzh:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/app/XiaomiVip\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_xmkb:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
										Cmd("sh /system/usr/Nightmare/bin/Lite_XMPass.sh");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_llq:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/Browser\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_rl:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/Calendar\n" +
												"rm -rf /system/priv-app/CalendarProvider\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_xzgl:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/DownloadProviderUi\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_xmkc:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/MiDrop\n" +
												"sleep 1");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_tk:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/MiuiGallery\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_yy:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/Music\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.zidingyi_tq:
				new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
					.setTitle(R.string.gf_dialog_title)
					.setMessage("确认删除吗？")
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
												"rm -rf /system/priv-app/Weather\n" +
												"sleep 1\n");
										Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
									} catch (Throwable throwable) {
										throwable.printStackTrace();
									}
								}
							}).start();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
		}
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fuzhu_zidingyi, container,  
										 false);
		rootView.findViewById(R.id.zidingyi_jsq).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_dzyj).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_wjgl).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_dtbz).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_xmqb).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_znz).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_sys).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_xmsp).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_bq).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_qjss).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_sg).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_yyzs).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_xmzh).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_xmkb).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_llq).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_rl).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_xzgl).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_xmkc).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_tk).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_yy).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi_tq).setOnClickListener(this);
        return rootView;
	}

	public void Cmd(final String string) {
		new Thread(new Runnable() {
				public void run() {
					try {
						Cmd.cmd(string);
					} catch (Throwable e) {
						e.printStackTrace();
					}
				}
			}).start();}
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        }
	
	
}
