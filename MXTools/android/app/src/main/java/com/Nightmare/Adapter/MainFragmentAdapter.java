package com.Nightmare.Adapter;



import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.view.ViewGroup;

import com.Nightmare.Fragment.Fragement1;
import com.Nightmare.Fragment.Fragement2;
import com.Nightmare.Fragment.Fragement3;
import com.Nightmare.Fragment.Fragement4;
import com.Nightmare.Fragment.Fragement5;
import com.Nightmare.Fragment.Fragement6;

public class MainFragmentAdapter extends FragmentPagerAdapter
{
    private  String[] TABLAYOUT_ID={"MIUI布局修改","Xposed框架","系统修改","实用工具","系统快捷","辅助功能"};
    public MainFragmentAdapter(FragmentManager fm) {
        super(fm);
    }
    @Override
    public Fragment getItem(int position) {
        BaseFragment fragment=null;
        try {
            Thread.sleep(1800);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        switch (position){
            case  0:
                fragment=new Fragement1();
                break;
            case  1:
                fragment=new Fragement2();
                break;
            case  2:
                fragment=new Fragement3();
                break;
			case  3:
				fragment = new Fragement4();
				break;
			case  4:
				fragment = new Fragement5();
				break;
			case  5:
				fragment=new Fragement6();
        }
        return fragment;
    }
    @Override
    public int getCount() {
        return TABLAYOUT_ID.length;
    }
    @Override
    public CharSequence getPageTitle(int position) {
        return TABLAYOUT_ID[position];
    }
	}
	

