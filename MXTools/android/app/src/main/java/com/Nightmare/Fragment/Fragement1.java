package com.Nightmare.Fragment;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;

import com.Nightmare.Adapter.BaseFragment;

import java.lang.reflect.Field;
import java.util.Objects;

import M.X.R;

public class Fragement1 extends BaseFragment implements OnClickListener
{
	public static Animation a;
    public static Animation b;
    public static Animation c;
    public static Animation d;
	@SuppressLint("StaticFieldLeak")
	public static View rootView;
	Animation loadAnimation;
	private boolean isInitDataed = false;
	private boolean isInitUIed = false;


	@Override
	public void onClick(View p1)
	{

		int id = p1.getId();
		switch(id){
			case R.id.miui_ztlbj:
				getActivity().getSupportFragmentManager()
						.beginTransaction()
						.replace(R.id.miui, new Fragement1_ztlbj(), null)
						.addToBackStack(null)
						.commit();
				break;
			case R.id.miui_ztlsj:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.miui, new Fragement1_ztlsj(), null)
					.addToBackStack(null)
					.commit();
				break;
			case R.id.miui_zmbj:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.miui, new Fragement1_zmbj(), null)
					.addToBackStack(null)
					.commit();
				break;
			case R.id.miui_gddh:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.miui, new Fragement1_gddh(), null)
					.addToBackStack(null)
					.commit();
				break;
		}
	}
	@Override
	public void setUserVisibleHint(boolean isVisibleToUser) {
	super.setUserVisibleHint(isVisibleToUser);
	if (getUserVisibleHint()) {
	if (!isInitDataed && isInitUIed) {
	}
	}
}
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        final View rootView = inflater.inflate(R.layout.miui, container,
										 false);
		donghua();
		rootView.findViewById(R.id.miui_ztlbj).setOnClickListener(this);
		rootView.findViewById(R.id.miui_ztlsj).setOnClickListener(this);
		rootView.findViewById(R.id.miui_zmbj).setOnClickListener(this);
		rootView.findViewById(R.id.miui_gddh).setOnClickListener(this);
        final View a1=rootView.findViewById(R.id.miui_ztlbj);
        final View b1=rootView.findViewById(R.id.miui_ztlsj);
        final View c1=rootView.findViewById(R.id.miui_zmbj);
        final View d1=rootView.findViewById(R.id.miui_gddh);
        a= AnimationUtils.loadAnimation(getActivity(),R.anim.floating_action_button_show);
        b= AnimationUtils.loadAnimation(getActivity(),R.anim.floating_action_button_show);
        c= AnimationUtils.loadAnimation(getActivity(),R.anim.floating_action_button_show);
        d= AnimationUtils.loadAnimation(getActivity(),R.anim.floating_action_button_show);
        a.setStartOffset(60);
        b.setStartOffset(120);
        c.setStartOffset(180);
        d.setStartOffset(240);
        a1.setAnimation(a);
        b1.setAnimation(b);
        c1.setAnimation(c);
        d1.setAnimation(d);
		//加载动画
		if (getUserVisibleHint() && !isInitDataed) {
		                         }
		return rootView;
	}

	public static void donghua(){
	}

}
