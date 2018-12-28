package com.Nightmare.Fragment;
import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import M.X.*;
import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MainActivity;
import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;

public class Fragement4 extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.brevent:
				Toast.makeText(MyApplication.getAppContext(),"正在执行相关脚本，请等待两秒左右" + MainActivity.getEmojiStringByUnicode(128527), 0).show();
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
							try
							{
								Thread.sleep(2000);
								Intent intent = new Intent();
								intent.setClassName("me.piebridge.brevent", "me.piebridge.brevent.ui.BreventActivity");
								getActivity().startActivity(intent);
							}
							catch (Throwable throwable) {
								throwable.printStackTrace();
							}
						}
					}).start();
				break;
			case R.id.dongjie:
				getActivity().startActivity(new Intent().setClassName("com.smartapp.appfreezer", "com.smartapp.appfreezer.MainActivity"));
				break;
			case R.id.kuishe:
				getActivity().startActivity(new Intent().setClassName("com.audlabs.viperfx", "com.audlabs.viperfx.main.MainActivity"));
				break;
			case R.id.dubi:
				getActivity().startActivity(new Intent().setClassName("com.atmos.daxappUI", "com.atmos.daxappUI.MainActivity"));
				break;
			case R.id.wifipassword:
				getActivity().getSupportFragmentManager()
						.beginTransaction()
						.addToBackStack(null)
						.replace(R.id.gongju, new com.Nightmare.Tools.WIFI.MainActivity())
						.commit();
		}
		
		
		
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.gongju, container,  
										 false);
		rootView.findViewById(R.id.brevent).setOnClickListener(this);
		rootView.findViewById(R.id.dongjie).setOnClickListener(this);
		rootView.findViewById(R.id.kuishe).setOnClickListener(this);
		rootView.findViewById(R.id.dubi).setOnClickListener(this);
		rootView.findViewById(R.id.wifipassword).setOnClickListener(this);
										 
										 
										 
										 
										 
        return rootView;
		}
	
}
