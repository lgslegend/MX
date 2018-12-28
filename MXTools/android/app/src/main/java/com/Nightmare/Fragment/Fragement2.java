package com.Nightmare.Fragment;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.Nightmare.Adapter.BaseFragment;
import M.X.R;
public class Fragement2 extends BaseFragment implements View.OnClickListener
{
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.xposed, container,
										 false);
        rootView.findViewById(R.id.xposed).setOnClickListener(this);
        rootView.findViewById(R.id.xposed1).setOnClickListener(this);
        rootView.findViewById(R.id.xposed2).setOnClickListener(this);
        rootView.findViewById(R.id.xposed3).setOnClickListener(this);
        rootView.findViewById(R.id.xposed4).setOnClickListener(this);
        rootView.findViewById(R.id.xposed5).setOnClickListener(this);
        rootView.findViewById(R.id.xposed6).setOnClickListener(this);
        rootView.findViewById(R.id.xposed7).setOnClickListener(this);
        rootView.findViewById(R.id.xposed8).setOnClickListener(this);
        return rootView;
}
    @Override
    public void onClick(View view) {
        int id = view.getId();
        switch(id){
            case R.id.xposed:
                getActivity().startActivity(new Intent().setClassName("de.robv.android.xposed.installer", "de.robv.android.xposed.installer.WelcomeActivity"));
                break;
            case R.id.xposed1:
                getActivity().startActivity(new Intent().setClassName("com.flarejune.perfectcolorbar", "com.flarejune.perfectcolorbar.ui.actMain"));
                break;
            case R.id.xposed2:
                getActivity().startActivity(new Intent().setClassName("me.veryyoung.qq.luckymoney", "me.veryyoung.qq.luckymoney.SettingsActivity"));
                break;
            case R.id.xposed3:
                getActivity().startActivity(new Intent().setClassName("me.veryyoung.wechat.luckymoney", "me.veryyoung.wechat.luckymoney.SettingsActivity"));
                break;
            case R.id.xposed4:
                getActivity().startActivity(new Intent().setClassName("com.fkzhang.qqxposed", "com.fkzhang.qqxposed.MainActivity"));
                break;
            case R.id.xposed5:
                getActivity().startActivity(new Intent().setClassName("com.fkzhang.wechatxposed", "com.fkzhang.wechatxposed.MainActivity"));
                break;
            case R.id.xposed6:
                getActivity().startActivity(new Intent().setClassName("com.skyolin.helper", "com.skyolin.helper.MainPreference"));
                break;
            case R.id.xposed7:
                getActivity().startActivity(new Intent().setClassName("liubaoyua.customtext", "liubaoyua.customtext.ui.AppListActivity"));
                break;
            case R.id.xposed8:
                getActivity().startActivity(new Intent().setClassName("com.sollyu.xposed.hook.model", "com.sollyu.xposed.hook.model.LauncherActivity"));
                break;
        }
    }
}
