package com.Nightmare;

import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.os.Looper;
import android.os.SystemClock;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Nightmare.Tools.Cmd;
import com.Nightmare.Tools.Resource;
import com.Nightmare.Tools.ZipTools;
import com.Nightmare.Tools.su;

import java.io.IOException;
import java.lang.reflect.Field;


import M.X.R;

import static com.Nightmare.MainActivity.getEmojiStringByUnicode;

public class Activity extends AppCompatActivity implements View.OnClickListener,View.OnLongClickListener {
    private SharedPreferences sp;
    private EditText ets;
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity);
        final View Logo=findViewById(R.id.Activity);
        Logo.setOnLongClickListener(this);
        Logo.setOnClickListener(this);
                try {
                    YiDong();
                    Animatio();
                    sp = getSharedPreferences("Password", Context.MODE_PRIVATE);
                    if(su.getProperty("ro.romer.id", "unknown").equals("Nightmare")){
                        Nightmare();
                    }
                    else{
                    }
                    if (sp.getString("Password", "").equals("无敌的梦魇兽")) {
                        Nightmare();
                    }
                    else {
                        Nightmar();
                    }
                }catch (Throwable throwable) {
                    throwable.printStackTrace();
                }

            }

     void Nightmar() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1800);
                    if(su.getProperty("ro.romer.id", "unknown").equals("Nightmare")){
                    }
                    else{
                        Looper.prepare();
                        Toast.makeText(getApplicationContext(),"当前不是D-ROM，所有功能未成功开启" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                        Looper.loop();
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    private void Nightmare() {
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(1800);
                    Animation a= AnimationUtils.loadAnimation(Activity. this, R.anim.fangsuo);
                    a.setFillAfter(true);
                    View Logo=findViewById(R.id.Activity);
                    Logo.startAnimation(a);
                    tiaozhuan();
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    private  void tiaozhuan(){
        new Thread(new Runnable() {
            public void run() {
                try {
                    Thread.sleep(400);
                    Intent intent = new Intent(Activity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(0, R.anim.suofang);
                } catch (Exception e) {
                    e.printStackTrace();
                }

            }
        }).start();
    }
    @Override

    public void onClick(View p1)
    {
        int id = p1.getId();
        switch(id){
            case R.id.Activity:
                findViewById(R.id.Activity).setOnClickListener(new View.OnClickListener() {
                    final static int COUNTS = 5;//点击次数
                    final static long DURATION = 1 * 1000;//规定有效时间
                    long[] mHits = new long[COUNTS];
                    @Override
                    public void onClick(View v) {
                        /**
                         * 实现双击方法
                         * src 拷贝的源数组
                         * srcPos 从源数组的那个位置开始拷贝.
                         * dst 目标数组
                         * dstPos 从目标数组的那个位子开始写数据
                         * length 拷贝的元素的个数
                         */
                        System.arraycopy(mHits, 1, mHits, 0, mHits.length - 1);
                        //实现左移，然后最后一个位置更新距离开机的时间，如果最后一个时间和最开始时间小于DURATION，即连续5次点击
                        mHits[mHits.length - 1] = SystemClock.uptimeMillis();
                        if (mHits[0] >= (SystemClock.uptimeMillis() - DURATION)) {
                            PASSWORD();
                            //String tips = "您已在[" + DURATION + "]ms内连续点击【" + mHits.length + "】次了！！！";
                            //Toast.makeText(Activity.this, tips, Toast.LENGTH_SHORT).show();
                        }
                    }
                });
        }
    }



    @Override
    public boolean onLongClick(View p1)
    {

        int id = p1.getId();
        switch(id){
            case R.id .Activity:
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
        return false;
    }

    public void Animatio(){
        new Thread(new Runnable() {
        public void run() {
            try {
                Thread.sleep(800);
                Animation a= AnimationUtils.loadAnimation(Activity. this, R.anim.xuanzuan);
                View Logo=findViewById(R.id.Activity);
                Logo.startAnimation(a);
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }).start();
    }
    public void YiDong(){

        Animation a=AnimationUtils.loadAnimation(Activity. this, R.anim.suofang);

        View Logo=findViewById(R.id.Activity);
        Logo.startAnimation(a);

    }
    public void PASSWORD(){
        sp= getSharedPreferences("Password", Context.MODE_PRIVATE);
        String Password = sp.getString("Password","你可以联系作者适配该机型");
        ets = new EditText(this);
        ets.setTextColor(Color.BLACK);

        AlertDialog Pass = new AlertDialog.Builder(this).setTitle("提示").setView(ets).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(DialogInterface dialog, int which) {
                sp.edit().putString("Password",ets.getText().toString()).apply();
                if(sp.getString("Password","").equals("无敌的梦魇兽")){
                    Toast.makeText(MyApplication.getAppContext(),"Ojbk" + getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
                    Dialog();
                }
            }
        }).show();
        try {
            Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
            mAlert.setAccessible(true);
            Object mAlertController = mAlert.get(Pass);
            //通过反射修改title字体大小和颜色

            Field mTitle = mAlertController.getClass().getDeclaredField("mTitleView");
            mTitle.setAccessible(true);
            TextView mTitleView = (TextView) mTitle.get(mAlertController);
            mTitleView.setTextSize(18);
            mTitleView.setTextColor(Color.BLACK);
            //通过反射修改message字体大小和颜色
            Field mMessage = mAlertController.getClass().getDeclaredField("mMessageView");
            mMessage.setAccessible(true);
            TextView mMessageView = (TextView) mMessage.get(mAlertController);
            mMessageView.setTextSize(16);
            mMessageView.setTextColor(Color.BLACK);
        } catch (IllegalAccessException e1) {
            e1.printStackTrace();
        } catch (NoSuchFieldException e2)
        {
            e2.printStackTrace();
        }
        ets.setText(Password);
    }
    private void Dialog(){
        final ProgressDialog dialog = new ProgressDialog(Activity.this);
        dialog.setProgressStyle(ProgressDialog.STYLE_SPINNER);// 设置进度条的形式为圆形转动的进度条
        //dialog.setCancelable(true);// 设置是否可以通过点击Back键取消
        dialog.setCanceledOnTouchOutside(false);// 设置在点击Dialog外是否取消Dialog进度条
        dialog.setIcon(R.drawable.ic_launcher);//
        // 设置提示的title的图标，默认是没有的，如果没有设置title的话只设置Icon是不会显示图标的
        dialog.setTitle("提示");
        // dismiss监听
        // 监听Key事件被传递给dialog
        // 监听cancel事件


        dialog.setOnCancelListener(new DialogInterface.OnCancelListener() {
            @Override
            public void onCancel(DialogInterface dialog) {
                //try {
                //  Thread.sleep(2000);
                //Cmd.cmd("mount -o rw,remount /system\n" +
                //      "chmod -R 0755 /system/usr/Nightmare/*\n");
                //} catch (Throwable e) {
                //  e.printStackTrace();
                //}
                Toast.makeText(MyApplication.getAppContext(),"资源初始化成功" + getEmojiStringByUnicode(128527),Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent();
                intent.setClass(Activity.this,Activity.class);
                startActivity(intent);
            }
        });
        //设置可点击的按钮，最多有三个(默认情况下)
        dialog.setButton(DialogInterface.BUTTON_NEGATIVE, "后台",
                new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                    }
                });

        dialog.setMessage("正在初始化资源");
        dialog.show();
        new Thread(new Runnable() {
            public void run() {
                try {
                    Resource.copyFilesFromRaw(Activity.this,R.raw.mengyan,"mengyan","/sdcard/Nightmare");
                    ZipTools.unZip(Activity.this, "Nightmare", "/sdcard/Nightmare");
                    Cmd.cmdT("mv /sdcard/Nightmare /system/usr");
                    dialog.cancel();
                } catch (IOException e){
                    e.printStackTrace();
                }
            }
        }).start();
    }
}

