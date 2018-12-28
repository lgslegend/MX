package com.Nightmare.Fragment;

import android.content.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import M.X.*;
import com.Nightmare.Adapter.BaseFragment;

public class Fragement5 extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.kuaijie01:
				Intent intent = new Intent();
				intent.setClassName("com.android.settings", "com.android.settings.TestingSettings");
				this.startActivity(intent);
				break;
			case R.id.kuaijie02:
				Intent intent1 = new Intent();
				intent1.setClassName("com.android.settings", "com.android.settings.DevelopmentSettings");
				this.startActivity(intent1);
		}
	}
	
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.kuaijie, container,  
										 false);
		rootView.findViewById(R.id.kuaijie01).setOnClickListener(this);
		rootView.findViewById(R.id.kuaijie02).setOnClickListener(this);
										 
										 
										 
        return rootView;
	}
}
