package com.Nightmare.Adapter;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


public class BaseFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
		TextView tv=new TextView(getActivity());
		String msg = this.getClass().getSimpleName();
		tv.setGravity(Gravity.CENTER);
		tv.setTextSize(16);
		tv.setText(msg);
		return tv;
	}
}
