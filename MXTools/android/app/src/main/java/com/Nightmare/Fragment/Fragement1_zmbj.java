package com.Nightmare.Fragment;

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

public class Fragement1_zmbj extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.zmbj_a:
				Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				try
				{
					Cmd.cmd("sh /system/usr/Nightmare/bin/Home_4X5.sh");
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}
				Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				break;
			case R.id.zmbj_b:
				Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				try
				{
					Cmd.cmd("sh /system/usr/Nightmare/bin/Home_4X6.sh");
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}
				Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				break;
			case R.id.zmbj_c:
				Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				try
				{
					Cmd.cmd("sh /system/usr/Nightmare/bin/Home_5X5.sh");
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}
				Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				break;
			case R.id.zmbj_d:
				Toast.makeText(MyApplication.getAppContext(),"正在执行" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				try
				{
					Cmd.cmd("sh /system/usr/Nightmare/bin/Home_5X6.sh");
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}
				Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
				break;
		}
		
	}
	
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.miui_zmbj, container,  
										 false);
		rootView.findViewById(R.id.zmbj_a).setOnClickListener(this);
		rootView.findViewById(R.id.zmbj_b).setOnClickListener(this);
		rootView.findViewById(R.id.zmbj_c).setOnClickListener(this);
		rootView.findViewById(R.id.zmbj_d).setOnClickListener(this);
        return rootView;
	}
    
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        }
	
	
}
