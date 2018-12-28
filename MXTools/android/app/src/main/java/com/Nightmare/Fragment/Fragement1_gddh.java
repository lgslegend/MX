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

public class Fragement1_gddh extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id =p1.getId();
		switch(id){
			case R.id.gddh_a:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							Cmd("sh /system/usr/Nightmare/bin/Framework_default.sh");
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.gddh_b:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							Cmd("sh /system/usr/Nightmare/bin/Framework_ios.sh");
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;

			case R.id.gddh_c:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							Cmd("sh /system/usr/Nightmare/bin/Framework_NiNE.sh");
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
			case R.id.gddh_d:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							Cmd("sh /system/usr/Nightmare/bin/Framework_iuNi.sh");
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.gddh_e:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							Cmd("sh /system/usr/Nightmare/bin/Framework_BLuR.sh");
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
			case R.id.gddh_f:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							Cmd("sh /system/usr/Nightmare/bin/Framework_dX8.sh");
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
							
		}
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.miui_gddh, container,  
										 false);
		rootView.findViewById(R.id.gddh_a).setOnClickListener(this);
		rootView.findViewById(R.id.gddh_b).setOnClickListener(this);
		rootView.findViewById(R.id.gddh_c).setOnClickListener(this);
		rootView.findViewById(R.id.gddh_d).setOnClickListener(this);
		rootView.findViewById(R.id.gddh_e).setOnClickListener(this);
		rootView.findViewById(R.id.gddh_f).setOnClickListener(this);
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
