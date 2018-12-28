package com.Nightmare;
import android.content.*;
import android.net.Uri;
import android.widget.*;
import android.util.*;
import android.view.*;

import M.X.R;


public class Btn extends LinearLayout
{

	private Context mContext;
	
	public Btn(Context context) {    
		super(context, null);
		Btn.this.mContext=context; 
	}
	public Btn(Context context, AttributeSet attrs) {    
		super(context, attrs);
		Btn.this.mContext=context; 
		//在构造函数中将Xml中定义的布局解析出来。   
		LayoutInflater.from(context).inflate(R.layout.nightmare, this, true);
		findViewById(R.id.btn1).setOnLongClickListener(new OnLongClickListener(){

				@Override
				public boolean onLongClick(View p1)
				{
					Intent intent = new Intent();
					intent.setClassName("eu.chainfire.supersu", "eu.chainfire.supersu.MainActivity");
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
					mContext.startActivity(intent);
					return false;
				}
		});
		findViewById(R.id.btn2).setOnLongClickListener(new OnLongClickListener(){

			@Override
			public boolean onLongClick(View p1)
			{
                Intent intent =new Intent();
                intent.setData(Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=906262255"));
                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                mContext.startActivity(intent);
                return false;
			}
		});
		findViewById(R.id.btn3).setOnLongClickListener(new OnLongClickListener(){
				@Override
				public boolean onLongClick(View p1)
				{
					Intent intent = new Intent();
					intent.setClassName("com.nightmare", "MainActivity");
					intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_BROUGHT_TO_FRONT);
					mContext.startActivity(intent);
					return false;
				}
		});
	}
	
}
