package com.Nightmare.Fragment;
import android.os.*;
import android.view.*;
import android.view.View.*;
import M.X.*;

import com.Nightmare.Adapter.BaseFragment;

public class Fragement6 extends BaseFragment implements OnClickListener
{

	@Override
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.shangdian:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.fuzhu, new Fragement6_shangdian(), null)
					.addToBackStack(null)
					.commit();
				break;
			case R.id.shidu:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.fuzhu, new Fragement6_shidu(), null)
					.addToBackStack(null)
					.commit();
				break;
			case R.id.jixian:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.fuzhu, new Fragement6_jixian(), null)
					.addToBackStack(null)
					.commit();
				break;
			case R.id.zidingyi:
				getActivity().getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.fuzhu, new Fragement6_zidingyi(), null)
					.addToBackStack(null)
					.commit();
				break;
		}
	}
    @Override  
    public View onCreateView(LayoutInflater inflater, ViewGroup container,  
							 Bundle savedInstanceState) {
        View rootView = inflater.inflate(R.layout.fuzhu, container,  
										 false);
		rootView.findViewById(R.id.shangdian).setOnClickListener(this);
		rootView.findViewById(R.id.shidu).setOnClickListener(this);
		rootView.findViewById(R.id.jixian).setOnClickListener(this);
		rootView.findViewById(R.id.zidingyi).setOnClickListener(this);
        return rootView;
	}
	
	
	
}
