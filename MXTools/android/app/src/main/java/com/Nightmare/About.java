package com.Nightmare;


import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Toast;

import com.Nightmare.Tools.Cmd;

import M.X.MainActivity;
import M.X.R;

public class About extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener
{

	

	private void ToastShow(String string) {
		Toast.makeText(About.this, string + getEmojiStringByUnicode(128523), Toast.LENGTH_SHORT).show();
	}

	private String getEmojiStringByUnicode(int unicode) {
		return new String(Character.toChars(unicode));
	}

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
		setTitle("关于");
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		final View Logo=findViewById(R.id.imageView);
		Logo.setOnLongClickListener(this);
		Logo.setOnClickListener(this);
		findViewById(R.id.about).setOnLongClickListener(this);

		new Thread(new Runnable() {
				public void run() {
					try {

						YiDong();
						Animatio();
					}catch (Throwable throwable) {
						throwable.printStackTrace();
					}

				}
			}).start();
}


	//这里开始都是是核心代码↓↓↓↓↓



    @Override
	
	public void onClick(View p1)
	{
		int id = p1.getId();
		switch(id){
			case R.id.imageView:
				ToastShow("打开QQ中");
				new Thread(new Runnable() {
						public void run() {
							try {
								Animation();
							}catch (Throwable throwable) {
								throwable.printStackTrace();
							}
							QQ();
						}
					}).start();
		}
		}

	

	@Override
	public boolean onLongClick(View p1)
	{

		int id = p1.getId();
		switch(id){
			case R.id.about:
				
				break;
				
			case R.id.imageView:
				ToastShow("获取群链接中");
				Animation();
				new Thread(new Runnable() {
						public void run() {
							try {
								Qun();
							}catch (Throwable throwable) {
								throwable.printStackTrace();
							}
						}
					}).start();
		}
		return false;
	}

	
    public void WeiBo(View view) 
    {
	
		startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("http://weibo.com/SorrowDespair")));
	}

	public void Animatio(){
		new Thread(new Runnable() {
				public void run() {
					try {
						Thread.sleep(1000);
						Animation a= AnimationUtils.loadAnimation(About. this, R.anim.xuanzuan);
						final View Logo=findViewById(R.id.imageView);
						Logo.startAnimation(a);
					} catch (Exception e) {
						e.printStackTrace();
					}

				}
			}).start();}
	public void YiDong(){

		Animation a=AnimationUtils.loadAnimation(About. this, R.anim.floating_action_button_show);

		final View Logo=findViewById(R.id.imageView);
		Logo.startAnimation(a);

	}
	public void Animation(){

		Animation a=AnimationUtils.loadAnimation(About. this, R.anim.xuanzuan);

		final View Logo=findViewById(R.id.imageView);
		Logo.startAnimation(a);

	}
	public void Qun(){

		try
		{
			Thread.sleep(1200);
			this.startActivity(new Intent(Intent.ACTION_VIEW,Uri.parse("mqqapi://card/show_pslcard?src_type=internal&version=1&uin=96635152&card_type=group&source=qrcode")));}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}
	public void QQ(){
		try
		{
			Thread.sleep(1200);
			Intent intent =new Intent();
			intent.setData(Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=906262255"));
			intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
			startActivity(intent);
		}
		catch (Throwable throwable) {
			throwable.printStackTrace();
		}
	}



    private void pay() {
        try {
            Intent intent = new Intent();
            intent.setAction("android.intent.action.VIEW");
            intent.setData(Uri.parse("alipayqr://platformapi/startapp?saId=10000007&qrcode=" + "HTTPS://QR.ALIPAY.COM/FKX02850L1BSEYDOJNDZC9"));
            if (intent.resolveActivity(getPackageManager()) != null) {
                startActivity(intent);
                return;
            }
            intent.setData(Uri.parse("HTTPS://QR.ALIPAY.COM/FKX02850L1BSEYDOJNDZC9"));
            startActivity(intent);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	public void Cmd(final String string) {
		new Thread(new Runnable() {
				public void run() {
					try {
						Cmd.cmd(string);
					}catch (Throwable throwable) {
						throwable.printStackTrace();
					}
					
				}
			}).start();
	
		
		
	}
      

    protected void onDestroy() {
        super.onDestroy();

		overridePendingTransition(R.anim.floating_action_button_show, R.anim.floating_action_button_show);
		
    }
}

