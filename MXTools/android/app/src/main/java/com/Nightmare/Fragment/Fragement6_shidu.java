package com.Nightmare.Fragment;

import android.app.*;
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

public class Fragement6_shidu extends BaseFragment {
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fuzhu_shidu, container,  
										 false);
		rootView.findViewById(R.id.fuzhu_shidu).setOnClickListener(new OnClickListener(){

				@Override
				public void onClick(View p1)
				{
					new AlertDialog.Builder(getActivity(),R.style.MyAlertDialogStyle)
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
													"rm -rf /system/app/AnalyticsCore\n" +
													"rm -rf /system/app/AutoRegistration\n" +
													"rm -rf /system/app/AutoTest\n" +
													"rm -rf /system/app/BackupReceiver\n" +
													"rm -rf /system/app/BasicDreams\n" +
													"rm -rf /system/app/BrowserProviderProxy\n" +
													"rm -rf /system/app/btmultisim\n" +
													"rm -rf /system/app/CaptivePortalLogin\n" +
													"rm -rf /system/app/CarrierCacheService\n" +
													"rm -rf /system/app/CarrierConfigure\n" +
													"rm -rf /system/app/CarrierLoadService\n" +
													"rm -rf /system/app/DeviceInfo\n" +
													"rm -rf /system/app/DocumentsUI\n" +
													"rm -rf /system/app/EngineerTool\n" +
													"rm -rf /system/app/EngineerToolOp\n" +
													"rm -rf /system/app/FactoryMode\n" +
													"rm -rf /system/app/fastdormancy\n" +
													"rm -rf /system/app/FPService\n" +
													"rm -rf /system/app/InterfacePermissions\n" +
													"rm -rf /system/app/KSICibaEngine\n" +
													"rm -rf /system/app/LauncherUnreadSer\n" +
													"rm -rf /system/app/LunarInfoProvider\n" +
													"rm -rf /system/app/Metok\n" +
													"rm -rf /system/app/PhotoTable\n" +
													"rm -rf /system/app/PicoTts\n" +
													"rm -rf /system/app/PrintSpooler\n" +
													"rm -rf /system/app/QComQMIPermissions\n" +
													"rm -rf /system/etc/yellowpage\n" +
													"rm -rf /system/priv-app/MiGameCenterSDKService\n" +
													"sleep 1\n" +
													"reboot");
											Toast.makeText(MyApplication.getAppContext(), "执行成功" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
										} catch (Throwable throwable) {
											throwable.printStackTrace();
										}
									}
								}).start();
							}
						}).setNegativeButton(R.string.Btn_Cancel, null).show();
				}
				
			
		});
		
		
		
		
        return rootView;
	}
    public void onBackPressed() {
        getActivity().getSupportFragmentManager().popBackStack();
        }
	
	
}
