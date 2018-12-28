package com.Nightmare.Fragment;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.SharedPreferences;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import com.Nightmare.*;
import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MainActivity;
import com.Nightmare.MyApplication;
import com.Nightmare.Tools.Cmd;

import M.X.R;

public class Fragement3_jixing extends BaseFragment implements OnClickListener
{

	private EditText ets;
	SharedPreferences A;
    private String Model = "";
    private String Manufacturer = "";
    private String Brand = "";
    private String Name = "";
    private String Id = "";
    private String DisplayId = "";
    private String Device = "";
	@Override


	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.jixing_xgxh:
				A=getActivity().getSharedPreferences("Model", Context.MODE_PRIVATE);
				ets = new EditText(getActivity());
				ets.setText(Model);
				new AlertDialog.Builder(getActivity())
						.setTitle("修改当前型号")
						.setView(ets)
						.setPositiveButton("确定", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface p1, int p2)
							{
								A.edit().putString("Model",ets.getText().toString()).apply();
									try
									{
										Cmd.cmd("mount -o rw,remount /system");
									}
									catch (Throwable throwable) {
										throwable.printStackTrace();
									}
									try
									{
										Thread.sleep(250);
									}
									catch (Throwable throwable) {
										throwable.printStackTrace();
									}
									try
									{
										Cmd.cmdT(String.format("busybox sed -i 's/ro.product.model=%s/ro.product.model=%s/g' /system/build.prop\n", Model, A.getString("Model","")));
									}
									catch (Throwable throwable) {
										throwable.printStackTrace();
									}
									try
									{
										if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.model\"\n").contains(A.getString("Model","")))
										{

											Toast.makeText(getActivity(), "修改成功，手动重启生效",Toast.LENGTH_SHORT).show();
											getActivity().getSupportFragmentManager().popBackStack();
											getActivity().getSupportFragmentManager()
													.beginTransaction()
													.addToBackStack(null)
													.replace(R.id.xitong, new Fragement3_jixing(), null)
													.commit();
										}
									}
									catch (Throwable throwable) {
										throwable.printStackTrace();
									}

								}

						}).setNegativeButton(R.string.Btn_Cancel, null).show();
				break;
            case R.id.jixing_xgcs:
                A=getActivity().getSharedPreferences("Manufacturer", Context.MODE_PRIVATE);
                ets = new EditText(getActivity());
                ets.setText(Manufacturer);
                new AlertDialog.Builder(getActivity())
                        .setTitle("修改当前厂商")
                        .setView(ets)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface p1, int p2)
                            {
                                A.edit().putString("Manufacturer",ets.getText().toString()).apply();
                                try
                                {
                                    Cmd.cmd("mount -o rw,remount /system");
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Thread.sleep(250);
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Cmd.cmdT(String.format("busybox sed -i 's/ro.product.manufacturer=%s/ro.product.manufacturer=%s/g' /system/build.prop\n", Model, A.getString("Manufacturer","")));
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.manufacturer\"\n").contains(A.getString("Manufacturer","")))
                                    {
                                        Toast.makeText(getActivity(), "修改成功，手动重启生效",Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().popBackStack();
                                        getActivity().getSupportFragmentManager()
                                                .beginTransaction()
                                                .addToBackStack(null)
                                                .replace(R.id.xitong, new Fragement3_jixing(), null)
                                                .commit();
                                    }
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).setNegativeButton(R.string.Btn_Cancel, null).show();
                break;
            case R.id.jixing_xgpp:
                A=getActivity().getSharedPreferences("Brand", Context.MODE_PRIVATE);
                ets = new EditText(getActivity());
                ets.setText(Brand);
                new AlertDialog.Builder(getActivity())
                        .setTitle("修改当前品牌")
                        .setView(ets)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface p1, int p2)
                            {
                                A.edit().putString("Brand",ets.getText().toString()).apply();
                                try
                                {
                                    Cmd.cmd("mount -o rw,remount /system");
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Thread.sleep(250);
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Cmd.cmdT(String.format("busybox sed -i 's/ro.product.brand=%s/ro.product.brand=%s/g' /system/build.prop\n", Brand, A.getString("Brand","")));
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.brand\"\n").contains(A.getString("Brand","")))
                                    {
                                        Toast.makeText(getActivity(), "修改成功，手动重启生效",Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().popBackStack();
                                        getActivity().getSupportFragmentManager()
                                                .beginTransaction()
                                                .addToBackStack(null)
                                                .replace(R.id.xitong, new Fragement3_jixing(), null)
                                                .commit();
                                    }
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).setNegativeButton(R.string.Btn_Cancel, null).show();
                break;
            case R.id.jixing_xgsj:
                A=getActivity().getSharedPreferences("Name", Context.MODE_PRIVATE);
                ets = new EditText(getActivity());
                ets.setText(Name);
                new AlertDialog.Builder(getActivity())
                        .setTitle("修改当前手机名")
                        .setView(ets)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface p1, int p2)
                            {
                                A.edit().putString("Name",ets.getText().toString()).apply();
                                try
                                {
                                    Cmd.cmd("mount -o rw,remount /system");
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Thread.sleep(250);
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Cmd.cmdT(String.format("busybox sed -i 's/ro.product.name=%s/ro.product.name=%s/g' /system/build.prop\n", Name, A.getString("Name","")));
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.name\"\n").contains(A.getString("Name","")))
                                    {
                                        Toast.makeText(getActivity(), "修改成功，手动重启生效",Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().popBackStack();
                                        getActivity().getSupportFragmentManager()
                                                .beginTransaction()
                                                .addToBackStack(null)
                                                .replace(R.id.xitong, new Fragement3_jixing(), null)
                                                .commit();
                                    }
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).setNegativeButton(R.string.Btn_Cancel, null).show();
                break;
            case R.id.jixing_xgbb:
                A=getActivity().getSharedPreferences("Id", Context.MODE_PRIVATE);
                ets = new EditText(getActivity());
                ets.setText(Id);
                new AlertDialog.Builder(getActivity())
                        .setTitle("修改当前版本")
                        .setView(ets)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface p1, int p2)
                            {
                                A.edit().putString("Id",ets.getText().toString()).apply();
                                try
                                {
                                    Cmd.cmd("mount -o rw,remount /system");
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Thread.sleep(250);
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Cmd.cmdT(String.format("busybox sed -i 's/ro.build.id=%s/ro.build.id=%s/g' /system/build.prop\n", Name, A.getString("Id","")));
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.id\"\n").contains(A.getString("Id","")))
                                    {
                                        Toast.makeText(getActivity(), "修改成功，手动重启生效",Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().popBackStack();
                                        getActivity().getSupportFragmentManager()
                                                .beginTransaction()
                                                .addToBackStack(null)
                                                .replace(R.id.xitong, new Fragement3_jixing(), null)
                                                .commit();
                                    }
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).setNegativeButton(R.string.Btn_Cancel, null).show();
                break;
            case R.id.jixing_xgbbh:
                A=getActivity().getSharedPreferences("DisplayId", Context.MODE_PRIVATE);
                ets = new EditText(getActivity());
                ets.setText(DisplayId);
                new AlertDialog.Builder(getActivity())
                        .setTitle("修改当前版本号")
                        .setView(ets)
                        .setPositiveButton("确定", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface p1, int p2)
                            {
                                A.edit().putString("DisplayId",ets.getText().toString()).apply();
                                try
                                {
                                    Cmd.cmd("mount -o rw,remount /system");
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Thread.sleep(250);
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    Cmd.cmdT(String.format("busybox sed -i 's/ro.build.display.id=%s/ro.build.display.id=%s/g' /system/build.prop\n", Name, A.getString("DisplayId","")));
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                                try
                                {
                                    if (Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.display.id\"\n").contains(A.getString("DisplayId","")))
                                    {
                                        Toast.makeText(getActivity(), "修改成功，手动重启生效",Toast.LENGTH_SHORT).show();
                                        getActivity().getSupportFragmentManager().popBackStack();
                                        getActivity().getSupportFragmentManager()
                                                .beginTransaction()
                                                .addToBackStack(null)
                                                .replace(R.id.xitong, new Fragement3_jixing(), null)
                                                .commit();
                                    }
                                }
                                catch (Throwable throwable) {
                                    throwable.printStackTrace();
                                }
                            }
                        }).setNegativeButton(R.string.Btn_Cancel, null).show();
                break;
			case R.id.jixing_kqlx:
				try
				{
					Thread.sleep(250);
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}

				try
				{
					Cmd.cmdT(String.format("busybox sed -i 's/ro.product.manufacturer=%s/ro.product.manufacturer=%s/g' /system/build.prop\n", Manufacturer, "OPPO"));
					Cmd.cmdT(String.format("busybox sed -i 's/ro.product.model=%s/ro.product.model=%s/g' /system/build.prop\n", Model, "OPPO R11"));
					Cmd.cmdT(String.format("busybox sed -i 's/ro.product.brand=%s/ro.product.brand=%s/g' /system/build.prop\n", Brand, "OPPO"));
					Cmd.cmdT(String.format("busybox sed -i 's/ro.product.name=%s/ro.product.name=%s/g' /system/build.prop\n", Name, "R11"));
					Cmd.cmdT(String.format("busybox sed -i 's/ro.product.device=%s/ro.product.device=%s/g' /system/build.prop\n", Device, "R11"));
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}
                getActivity().getSupportFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.xitong, new Fragement3_jixing(), null)
                        .commit();
				Toast.makeText(MyApplication.getAppContext(),"开启成功，重启生效" + MainActivity.getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
				
				break;
				
			case R.id.jixing_hfmmz:
				try
				{
					Cmd.cmd("\n" +
							"mount -o rw,remount /system\n" +
							"\n" +
							"if [ -f \"/system/build.bak\" ]; then\n" +
							"\tmv /system/build.bak /system/build.prop\n" +
							"fi\n" +
							"\n" +
							"chmod -R 0644 /system/build.prop\n" +
							"\n" +
							"sleep 1\n");
				}
				catch (Throwable throwable) {
					throwable.printStackTrace();
				}
                getActivity().getSupportFragmentManager().popBackStack();
                getActivity().getSupportFragmentManager()
                        .beginTransaction()
                        .addToBackStack(null)
                        .replace(R.id.xitong, new Fragement3_jixing(), null)
                        .commit();
				break;

		}
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.xitong_jixing, container,  
										 false);
		rootView.findViewById(R.id.jixing_xgxh).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_xgcs).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_kqlx).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_xgpp).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_xgsj).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_xgbb).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_xgbbh).setOnClickListener(this);
		rootView.findViewById(R.id.jixing_hfmmz).setOnClickListener(this);

		new Thread(new Runnable() {
			public void run() {
				try
				{
					Cmd.cmdT("mount -o rw,remount /system\n" +
							"if [ -f \"/system/build.bak\" ]; then\n" +
							"\tmv /system/build.prop /system/build.prop\n" +
							"else\n" +
							"cp /system/build.prop /system/build.bak\n" +
							"fi");
				}catch (Throwable throwable) {
					throwable.printStackTrace();
				}
			}
		}).start();
		new Thread(new Runnable() {
				public void run() {
					try {
						Device = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.device\" | busybox sed 's/ro.product.device=//g'\n");
			
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		new Thread(new Runnable() {
				@SuppressLint("SetTextI18n")
                public void run() {
					try {
						Model = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.model\" | busybox sed 's/ro.product.model=//g'\n");
						TextView a = rootView.findViewById(R.id.jixing_a);
						a.setText("当前为:" + Model);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		new Thread(new Runnable() {
				@SuppressLint("SetTextI18n")
                public void run() {
					try {
						Manufacturer = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.manufacturer\" | busybox sed 's/ro.product.manufacturer=//g'\n");
						TextView b = (TextView)rootView.findViewById(R.id.jixing_b);
						b.setText("当前为:" + Manufacturer);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		new Thread(new Runnable() {
				@SuppressLint("SetTextI18n")
                public void run() {
					try {
						Brand = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.brand\" | busybox sed 's/ro.product.brand=//g'\n");
						TextView c = (TextView)rootView.findViewById(R.id.jixing_c);
						c.setText("当前为:" + Brand);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		new Thread(new Runnable() {
				@SuppressLint("SetTextI18n")
                public void run() {
					try {
						Name = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.product.name\" | busybox sed 's/ro.product.name=//g'\n");
						TextView d = (TextView)rootView.findViewById(R.id.jixing_d);
						d.setText("当前为:" + Name);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		new Thread(new Runnable() {
				@SuppressLint("SetTextI18n")
                public void run() {
					try {
						Id = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.id\" | busybox sed 's/ro.build.id=//g'\n");
						TextView e = (TextView)rootView.findViewById(R.id.jixing_e);
						e.setText("当前为:" + Id);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
		new Thread(new Runnable() {
				@SuppressLint("SetTextI18n")
                public void run() {
					try {
						DisplayId = Cmd.cmdT("cat /system/build.prop | busybox grep \"ro.build.display.id\" | busybox sed 's/ro.build.display.id=//g'\n");
						TextView f = (TextView)rootView.findViewById(R.id.jixing_f);
						f.setText("当前为:" + DisplayId);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			}).start();
										 

							
        return rootView;
	}
    
    public void onBackPressed() {
		getActivity().getSupportFragmentManager().popBackStack();
	}
}
