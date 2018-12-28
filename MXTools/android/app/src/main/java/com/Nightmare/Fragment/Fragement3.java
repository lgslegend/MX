package com.Nightmare.Fragment;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.Tools.CPU.MainActivity;
import com.Nightmare.Tools.Cmd;

import java.io.IOException;

import M.X.R;

public class Fragement3 extends BaseFragment implements OnClickListener
{

	private EditText ets;

    SharedPreferences A;
    private String mCurrentDPI = "";
	

    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
				
        final View rootView = inflater.inflate(R.layout.xitong, container,
										 false);
		rootView.findViewById(R.id.setcpu).setOnClickListener(this);
		rootView.findViewById(R.id.jixing).setOnClickListener(this);

		new Thread(new Runnable() {
				public void run() {
					try {
						mCurrentDPI = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.sf.lcd_density\" | busybox sed 's/ro.sf.lcd_density=//g'\n");
						TextView textview = (TextView)rootView.findViewById(R.id.dpi);
						textview.setText("系统默认值:480 "+"当前DPI为:" + mCurrentDPI);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		rootView.findViewById(R.id.setdpi).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					A=getActivity().getSharedPreferences("DPI",Context.MODE_PRIVATE);
					ets = new EditText(getActivity());
					ets.setText(mCurrentDPI);
					new AlertDialog.Builder(getActivity())
						.setTitle("更改当前DPI")
						.setView(ets)
						.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								A.edit().putString("DPI",ets.getText().toString()).commit();
								 int parseInt = Integer.parseInt(A.getString("DPI",""));
								 if (parseInt < 100 || parseInt > 540) {
								 Toast.makeText(getActivity(), "请输入100到540之间的数字",Toast.LENGTH_SHORT).show();
								 }
								 else{
									 try
									 {
										 Cmd.cmd("mount -o rw,remount /system");
									 }
									 catch (Throwable throwable) {
										 throwable.printStackTrace();
									 }
								TextView textview = (TextView)rootView.findViewById(R.id.dpi);
								try
								{
									Thread.sleep(250);
								}
								catch (Throwable throwable) {
									throwable.printStackTrace();
								}
								try
									 {
										 Cmd.cmdT(String.format("busybox sed -i 's/ro.sf.lcd_density=%s/ro.sf.lcd_density=%s/g' /system/build.prop\n", new Object[]{mCurrentDPI, A.getString("DPI","")}));
								}
								catch (Throwable throwable) {
									throwable.printStackTrace();
								}
								try
								{
									if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.sf.lcd_density\"\n").contains(A.getString("DPI","")))
									{

										Toast.makeText(getActivity(), "\u6210\u529f\uff0c\u624b\u52a8\u91cd\u542f\u751f\u6548",Toast.LENGTH_SHORT).show();
										getActivity().getSupportFragmentManager() 
											.beginTransaction()
											.replace(R.id.xitong, new Fragement3(), null) 
											.commit();
										textview.setText("系统默认值:480 "+"当前DPI为:" + A.getString("DPI","")+"(已改动，重启生效)");
									}
								}
								catch (Throwable throwable) {
									throwable.printStackTrace();
								}

								 }
}
						}).setNegativeButton(R.string.Btn_Cancel, null).show();

					
					
					
					// TODO: Implement this method
				}
				
			
		});
			
		
		
		
		
		
		
        return rootView;
		
	}
	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.setcpu:
				getActivity().getSupportFragmentManager()
						.beginTransaction()
						.addToBackStack(null)
						.replace(R.id.xitong, new MainActivity())
						.commit();
                //Intent intent = new Intent();
                //intent.setClass(getActivity(),MainActivity.class);
                //startActivity(intent);
			break;
				//Intent intent = new Intent(getActivity(),ActivitySeting.class); 
				//startActivity(intent);
		
			case R.id.jixing:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.addToBackStack(null)
                        .replace(R.id.xitong, new Fragement3_jixing())
					.commit();
	}
}}
