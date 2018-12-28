package com.Nightmare.Fragment;

import android.app.*;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;

import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MainActivity;
import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;

import M.X.R;

public class Fragement1_ztlsj extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.ztlsj_xsnlxqsj:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							try
							{
								Cmd.cmd("sh /system/usr/Nightmare/bin/Clock_1.sh");
							}
							catch (Throwable throwable) {
								throwable.printStackTrace();
							}
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
			case R.id.ztlsj_xsnlsj:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							try
							{
								Cmd.cmd("sh /system/usr/Nightmare/bin/Clock_2.sh");
							}
							catch (Throwable throwable) {
								throwable.printStackTrace();
							}
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
			case R.id.ztlsj_xsxqsj:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							try
							{
								Cmd.cmd("sh /system/usr/Nightmare/bin/Clock_3.sh");
							}
							catch (Throwable throwable) {
								throwable.printStackTrace();
							}
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
			case R.id.ztlsj_jsssj:
				new AlertDialog.Builder(getActivity())
					.setTitle(R.string.gf_dialog_title)
					.setMessage("此操作将会重启系统")
					.setPositiveButton(R.string.Btn_Sure,
					new DialogInterface.OnClickListener() {
						@Override
						public void onClick(DialogInterface p1, int p2)
						{
							Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
							try
							{
								Cmd.cmd("sh /system/usr/Nightmare/bin/Clock_4.sh");
							}
							catch (Throwable throwable) {
								throwable.printStackTrace();
							}
							Toast.makeText(MyApplication.getAppContext(),"执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
						}
					}).setNegativeButton(R.string.Btn_Cancel, null).show();
		}
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.miui_ztlsj, container,  
										 false);
		rootView.findViewById(R.id.ztlsj_xsnlxqsj).setOnClickListener(this);
		rootView.findViewById(R.id.ztlsj_xsnlsj).setOnClickListener(this);
		rootView.findViewById(R.id.ztlsj_xsxqsj).setOnClickListener(this);
		rootView.findViewById(R.id.ztlsj_jsssj).setOnClickListener(this);
        return rootView;
	}
    
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        }
	
	
}
