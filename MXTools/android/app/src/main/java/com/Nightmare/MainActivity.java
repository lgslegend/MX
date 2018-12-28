package com.Nightmare;


import android.Manifest;
import android.animation.ArgbEvaluator;
import android.annotation.SuppressLint;
import android.app.AlertDialog;
import android.app.ProgressDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.GravityCompat;
import android.support.v4.view.ViewPager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.text.TextUtils;
import android.view.MenuItem;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.DecelerateInterpolator;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.Nightmare.Adapter.MainFragmentAdapter;
import com.Nightmare.Tools.Cmd;
import com.Nightmare.Tools.Resource;
import com.Nightmare.Tools.StatusBarUtils;
import com.Nightmare.Tools.VibratorUtil;
import com.Nightmare.Tools.ZipTools;
import com.Nightmare.Tools.su;
import com.pgyersdk.feedback.PgyFeedback;
import com.pgyersdk.javabean.AppBean;
import com.pgyersdk.update.PgyUpdateManager;
import com.pgyersdk.update.UpdateManagerListener;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Field;

import M.X.R;

import static android.content.pm.PackageManager.PERMISSION_GRANTED;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener, View.OnClickListener, NavigationView.OnNavigationItemSelectedListener {
    private final static int REQUEST_CODE_ASK_WRITE_EXTERNAL_STORAGE = 0x123;
    private final static int REQUEST_CODE_ASK_RECORD_EXTERNAL_STORAGE = 0x123;
    private PackageInfo info;
    private SharedPreferences sp;
    private SharedPreferences prefs;
    private EditText ets;
    private int currentVersion;
    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawer;
    private TabLayout tablayout;
    private ViewPager viewpager;
    private View navHeaderView;
    private View my;

    public MainActivity() {
        mainActivity = this;
    }

    public static MainActivity getMainActivity() {
        return mainActivity;
    }


    private static MainActivity mainActivity;

    public void function() {

    }

    public static String getEmojiStringByUnicode(int unicode) {
        return new String(Character.toChars(unicode));
    }

    /*private void ToastShow(String string) {
        Toast.makeText(MyApplication.getAppContext(), string + getEmojiStringByUnicode(128523), 0).show();
    }*/
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        overridePendingTransition(R.anim.suofang2, 0);
        super.onCreate(savedInstanceState);
        //initUI();
        initView();
        FirstOpen();
        //CheckRoot();

    }

    /* private void initUI()
     {


     }*/
    private void CheckRoot() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                } catch (Throwable e) {

                    Toast.makeText(MyApplication.getAppContext(), "ROOT权限未获取，部分功能无法使用" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                    e.printStackTrace();
                }

            }
        }).start();
    }

    private void FirstOpen() {
        //检测是否是第一次启动
        try {
            info = getPackageManager().getPackageInfo(getPackageName(), 0);
        } catch (PackageManager.NameNotFoundException e) {
            e.printStackTrace();
        }
        currentVersion = info.versionCode;
        prefs = PreferenceManager.getDefaultSharedPreferences(MainActivity.this);
        int lastVersion = prefs.getInt("VERSION_KEY", 0);
        if (currentVersion > lastVersion) {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("更新日志");
            builder.setMessage(
                    "版本 v1.03 (2018年10月15日）\n" +
                            "兼容安卓8.0，重写大量代码\n" +
                            "\n" +
                            "版本 v1.02 (2018年07月01日)\n" +
                            "软件界面换新，代码全部重写，采用NavigationView+ToolBar+TabLayout+ViewPager+Fragment布局\n" +
                            "\n" +
                            "版本 v1.01 (2018年02月13日)\n" +
                            "修复一些可执行的脚本\n" +
                            "\n" +
                            "版本 v1.0 (2018年02月04日)\n" +
                            "程序的开始\n" +
                            "PreferenceFragment继承AppCompatActivity布局，局限性大\n" +
                            "简单的布局，简单的代码，实用的功能\n" +
                            "采用大量线程处理\n" +
                            "软件不开源,禁止盗用反编译后得到的源码\n");
            builder.setPositiveButton("不再显示",
                    new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface p1, int p2) {
                            Toast.makeText(MyApplication.getAppContext(), "正在后台解压资源，请停留该软件几秒" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                            Dialog();
                            prefs.edit().putInt("VERSION_KEY", currentVersion).apply();
                        }
                    });
        }
        //如果当前版本大于上次版本，该版本属于第一次启动
        //将当前版本写入preference中，则下次启动的时候，据此判断，不再为首次启动          prefs.edit().putInt("VERSION_KEY",currentVersion).commit();
    }/* else {//不是第一次启动，跳过引导页直接到欢迎界面
            ToastShow("不是第一次启动");
        }*/


    @SuppressLint("ResourceAsColor")
    private void initView() {
        //全屏
        //getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getWindow().requestFeature(Window.FEATURE_NO_TITLE);
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
                    | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            window.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
                    | View.SYSTEM_UI_FLAG_LAYOUT_STABLE);
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(Color.TRANSPARENT);
            window.setNavigationBarColor(Color.TRANSPARENT);
        }
        sp = getSharedPreferences("Password", Context.MODE_PRIVATE);
        if (sp.getString("Password", "").equals("无敌的梦魇兽")) {
            setContentView(R.layout.activity_main);
        } else {
            setContentView(R.layout.activity_main0);
        }
        setTitle("");
        toolbar = findViewById(R.id.toolbar);
        toolbar.setOnLongClickListener(this);
        navigationView = findViewById(R.id.nav_view);
        drawer = findViewById(R.id.drawer_layout);
        setSupportActionBar(toolbar);
        final Animation showToolBarAnima = AnimationUtils.loadAnimation(this, android.R.anim.slide_in_left);
        showToolBarAnima.setStartOffset(400);
        navigationView.setItemIconTintList(null);//侧拉栏颜色为彩色

        Resources resource = (Resources) getBaseContext().getResources();
        ColorStateList csl = (ColorStateList) resource.getColorStateList(R.color.navigation_menu_item_color);
        navigationView.setItemTextColor(csl);


        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close) {
            @Override
            public void onDrawerOpened(View drawerView) {
                Animation();
                super.onDrawerOpened(drawerView);
            }

            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

        };
        drawer.setOnClickListener(this);
        drawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);
        navigationView.inflateHeaderView(R.layout.nav_header_main);
        navigationView.inflateMenu(R.menu.activity_main_drawer);
        navHeaderView = navigationView.getHeaderView(0);
        my = navHeaderView.findViewById(R.id.tangxueyi);
        my.setOnClickListener(this);
        my.setOnLongClickListener(this);
        if (sp.getString("Password", "").equals("无敌的梦魇兽")) {
            tablayout = findViewById(R.id.tablayout);
            viewpager = findViewById(R.id.viewpager);
            //getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewpager + ":0");
            /*通过findFragmentById获取Fragment*/
            /*通过fragment.getView()获取视图，然后在获取fragment中的button*/
            // Fragment Fragement1 = getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewpager + ":0");
            //final View a1= this.getSupportFragmentManager().findFragmentByTag("android:switcher:" + R.id.viewpager + ":1").getView().findViewById(R.id.xposed2);

            getSupportFragmentManager().findFragmentById(R.id.miui_ztlbj);

            viewpager.setOffscreenPageLimit(1);
            MainFragmentAdapter adapter = new MainFragmentAdapter(getSupportFragmentManager());
            viewpager.setAdapter(adapter);
            tablayout.setTabMode(TabLayout.MODE_SCROLLABLE);//设置TabLayout的模式为滚动模式
            //与viepager进行绑定,TabLayout的标签页通过PagerAdapter的getPagerTitle方法获取
            tablayout.setupWithViewPager(viewpager);

            viewpager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
                @Override
                public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {
                    ArgbEvaluator evaluator = new ArgbEvaluator();
                    if (position == 0) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_1)); //先设置第0页时还没有滑动时tablayout的颜色
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_1));   //先设置第0页时还没有滑动时toolbar的颜色
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.theme_primary), getResources().getColor(R.color.tab_1));
                        tablayout.setBackgroundColor(evaluate);//设置背景颜色为算出的两种颜色之间的过渡色
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                        toolbar.setAnimation(showToolBarAnima);
                    }
                  /*  if (0 < position && position < 1) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_1));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_1));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_1), getResources().getColor(R.color.theme_primary));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();

                    }*/
                    if (position == 1) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_2)); //先设置第0页时还没有滑动时tablayout的颜色
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_2));   //先设置第0页时还没有滑动时toolbar的颜色
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_1), getResources().getColor(R.color.tab_2));
                        tablayout.setBackgroundColor(evaluate);//设置背景颜色为算出的两种颜色之间的过渡色
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }
                   /*if (1 < position && position < 2) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_2));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_2));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_2), getResources().getColor(R.color.tab_1));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }*/

                    if (position == 2) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_3));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_3));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_2), getResources().getColor(R.color.tab_3));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }

                   /* if (2 < position && position < 3) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_3));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_3));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_3), getResources().getColor(R.color.tab_2));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }*/


                    if (position == 3) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_4));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_4));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_3), getResources().getColor(R.color.tab_4));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }

                    /*if (3 < position && position < 4) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_4));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_4));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_4), getResources().getColor(R.color.tab_3));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }*/

                    if (position == 4) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_5));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_5));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_4), getResources().getColor(R.color.tab_5));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }

                  /*  if (4 < position && position < 5) {
                        tablayout.setBackgroundColor(getResources().getColor(R.color.tab_5));
                        toolbar.setBackgroundColor(getResources().getColor(R.color.tab_5));
                        int evaluate = (Integer) evaluator.evaluate(positionOffset, getResources().getColor(R.color.tab_5), getResources().getColor(R.color.tab_4));
                        tablayout.setBackgroundColor(evaluate);
                        toolbar.setBackgroundColor(evaluate);
                        StatusBarUtils.instance(MainActivity.this).setColor(evaluate).
                                setStyle(StatusBarUtils.TYPE.FILL).init();
                    }*/


                }

                @Override
                public void onPageSelected(int position) {
                }

                @Override
                public void onPageScrollStateChanged(int state) {
                }
            });

        }
        new Thread(new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                try {
                    String PhoneId = (su.getProperty("ro.product.manufacturer", ""));
                    TextView textview = navHeaderView.findViewById(R.id.JiXing);
                    textview.setText("当前机型 : " + PhoneId);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();
        new Thread(new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                try {
                    PackageManager pm = getPackageManager();
                    PackageInfo info = pm.getPackageInfo(getPackageName(), 0);
                    TextView textview = navHeaderView.findViewById(R.id.Version);
                    textview.setText("v" + info.versionName);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }).start();

        new Thread(new Runnable() {
            @SuppressLint("SetTextI18n")
            public void run() {
                TextView textview = navHeaderView.findViewById(R.id.ROOT);
                try {
                    Process process = null;
                    DataOutputStream dataOutputStream = null;
                    DataInputStream dataInputStream = null;
                    StringBuilder wifiConf = new StringBuilder();
                    try {
                        process = Runtime.getRuntime().exec("su");
                        dataOutputStream = new DataOutputStream(process.getOutputStream());
                        dataInputStream = new DataInputStream(process.getInputStream());
                        dataOutputStream.writeBytes("cat /system/build.prop\n");
                        dataOutputStream.writeBytes("exit\n");
                        dataOutputStream.flush();
                        InputStreamReader inputStreamReader = new InputStreamReader(dataInputStream, "UTF-8");
                        BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
                        String line = null;
                        while ((line = bufferedReader.readLine()) != null) {
                            wifiConf.append(line);
                        }
                        bufferedReader.close();
                        inputStreamReader.close();
                        process.waitFor();
                    } catch (Exception e) {
                        return;
                    } finally {

                        if (TextUtils.isEmpty(wifiConf.toString())) {
                            textview.setText("未获取ROOT权限");
                            Toast.makeText(MyApplication.getAppContext(), "请先获取ROOT权限", Toast.LENGTH_LONG).show();
                        }

                        try {
                            if (dataOutputStream != null) {
                                dataOutputStream.close();
                            }
                            if (dataInputStream != null) {
                                dataInputStream.close();
                            }
                            process.destroy();
                        } catch (Throwable throwable) {
                            throwable.printStackTrace();
                        }
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
                try {
                    Cmd.cmdT("mount -o rw,remount /data" +
                            "mount -o rw,remount /system");
                } catch (Throwable throwable) {
                    throwable.printStackTrace();
                }
            }
        }).start();


    }

    @Override
    public void onClick(View p1) {
        int id = p1.getId();
        switch (id) {
            case R.id.tangxueyi:
                long[] myp = {0, 60};
                VibratorUtil.Vibrate(MainActivity.this, myp, false); // 震动100ms
                Snackbar.make(p1, "欢迎使用Nightmare高级设置" + getEmojiStringByUnicode(128527), Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Animation();
            case R.id.nav_view:
                Animation();
                break;
            case R.id.drawer_layout:
                Animation();
        }
    }

    @Override
    public boolean onLongClick(View p1) {

        int id = p1.getId();
        switch (id) {
            case R.id.toolbar:
                if (sp.getString("Password", "").equals("无敌的梦魇兽")) {
                } else {
                    PASSWORD();
                }
            case R.id.nav_view:
                Animation();
                break;
            case R.id.drawer_layout:
                Animation();
        }
        return false;
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();


        }
    }

    //@Override
    //  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    //  getMenuInflater().inflate(R.menu.main, menu);
    //  return true;
    //   }

    // @Override
    /*public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_settings) {
		try
		{*/
    //Thread.sleep(1200);
    //Intent intent =new Intent();
    //intent.setData(Uri.parse("mqqwpa://im/chat?chat_type=wpa&uin=906262255"));
    //intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    //startActivity(intent);
    //}
    //catch (InterruptedException e)
    //{}


    // return true;
    //}

    //     return super.onOptionsItemSelected(item);
    //}
//
       /* @Override
        public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
            switch (requestCode){
                case REQUEST_CODE_ASK_WRITE_EXTERNAL_STORAGE:
                    if(grantResults[0] == PERMISSION_GRANTED){
                    }else{
                        Toast.makeText(this, "" + "储存权限申请失败", Toast.LENGTH_SHORT).show();
                    }
                    break;
                    case REQUEST_CODE_ASK_RECORD_EXTERNAL_STORAGE
                default:
                    super.onRequestPermissionsResult(requestCode, permissions, grantResults);
            }
        }*/
    @Override
    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == 1) {
            for (int i = 0; i < permissions.length; i++) {
                if (grantResults[i] == PERMISSION_GRANTED) {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请成功", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "" + "权限" + permissions[i] + "申请失败", Toast.LENGTH_SHORT).show();
                }
            }
        }
    }


    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem p1) {
        int id = p1.getItemId();
        switch (id) {
            case R.id.check:
                if (Build.VERSION.SDK_INT >= 23) {//判断当前系统的版本
                    int checkWriteStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
                    if (checkWriteStoragePermission != PERMISSION_GRANTED) {//如果没有被授予
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        //请求获取该种权限
                    } else {
                        CheckNewVersion();//定义好的获取权限后的处理的事件
                    }
                } else {
                }
                break;
            case R.id.bug:
                if (Build.VERSION.SDK_INT >= 23) {//判断当前系统的版本
                    //判断是否已经赋予权限
                    int checkWriteStoragePermission = ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE);//获取系统是否被授予该种权限
                    if (checkWriteStoragePermission != PERMISSION_GRANTED) {//如果没有被授予
                        ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, 1);
                        //请求获取该种权限
                    } else {
                        int recordPermission = ContextCompat.checkSelfPermission(this, Manifest.permission.RECORD_AUDIO);//获取系统是否被授予该种权限
                        if (recordPermission != PERMISSION_GRANTED) {//如果没有被授予
                            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.RECORD_AUDIO}, 1);
                            //请求获取该种权限
                        } else {
                        }
                        PgyFeedback.getInstance().showDialog(MainActivity.this);//定义好的获取权限后的处理的事件
                    }
                } else {
                }
                break;
            case R.id.juanzeng:
                AlertDialog juanzeng = new AlertDialog.Builder(this)
                        .setTitle("捐赠").setMessage(R.string.nightmare).setPositiveButton("捐赠一丢丢！！！",
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface p1, int p2) {
                                        pay();
                                    }
                                }).setNegativeButton("滚!!!", null).show();
                try {
                    Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
                    mAlert.setAccessible(true);
                    Object mAlertController = mAlert.get(juanzeng);
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
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
                break;
            case R.id.about:
                Intent intent = new Intent();
                intent.setClass(this, About.class);
                this.startActivity(intent);
                break;
            case R.id.reboot:
                AlertDialog reboot = new AlertDialog.Builder(this)
                        .setTitle(R.string.gf_dialog_title)
                        .setMessage("确认要重启系统吗")
                        .setPositiveButton(R.string.Btn_Sure,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface p1, int p2) {
                                        try {
                                            Cmd.cmd("reboot");
                                        } catch (Throwable throwable) {
                                            throwable.printStackTrace();
                                        }
                                    }
                                }).setNegativeButton(R.string.Btn_Cancel, null).show();
                try {
                    Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
                    mAlert.setAccessible(true);
                    Object mAlertController = mAlert.get(reboot);
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
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
                break;
            case R.id.reboot_rec:
                AlertDialog reboot_rec = new AlertDialog.Builder(this)
                        .setTitle(R.string.gf_dialog_title)
                        .setMessage("确认要重启进入recovery吗")
                        .setPositiveButton(R.string.Btn_Sure,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface p1, int p2) {
                                        try {
                                            Cmd.cmd("reboot recovery");
                                        } catch (Throwable throwable) {
                                            throwable.printStackTrace();
                                        }
                                    }
                                }).setNegativeButton(R.string.Btn_Cancel, null).show();
                try {
                    Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
                    mAlert.setAccessible(true);
                    Object mAlertController = mAlert.get(reboot_rec);
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
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
                break;
            case R.id.reboot_fast:
                AlertDialog reboot_fast = new AlertDialog.Builder(this)
                        .setTitle(R.string.gf_dialog_title)
                        .setMessage("确认要重启进入fastboot吗")
                        .setPositiveButton(R.string.Btn_Sure,
                                new DialogInterface.OnClickListener() {
                                    @Override
                                    public void onClick(DialogInterface p1, int p2) {
                                        try {
                                            Cmd.cmd("reboot fastboot");


                                        } catch (Throwable throwable) {
                                            throwable.printStackTrace();
                                        }
                                    }
                                }).setNegativeButton(R.string.Btn_Cancel, null).show();
                try {
                    Field mAlert = AlertDialog.class.getDeclaredField("mAlert");
                    mAlert.setAccessible(true);
                    Object mAlertController = mAlert.get(reboot_fast);
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
                } catch (NoSuchFieldException e2) {
                    e2.printStackTrace();
                }
                break;
            case R.id.exit:
                finish();


                DrawerLayout drawer = findViewById(R.id.drawer_layout);
                drawer.closeDrawer(GravityCompat.START);
                return true;
        }
        return false;
    }


    public void CheckNewVersion() {
        PgyUpdateManager.register(MainActivity.this,
                new UpdateManagerListener() {

                    @Override
                    public void onUpdateAvailable(final String result) {

                        // 将新版本信息封装到AppBean中
                        final AppBean appBean = getAppBeanFromString(result);
                        new AlertDialog.Builder(MainActivity.this)
                                .setTitle("更新")
                                .setMessage("")
                                .setNegativeButton(
                                        "确定",
                                        new DialogInterface.OnClickListener() {

                                            @Override
                                            public void onClick(
                                                    DialogInterface dialog,
                                                    int which) {
                                                startDownloadTask(
                                                        MainActivity.this,
                                                        appBean.getDownloadURL());
                                            }
                                        }).show();
                    }

                    @Override
                    public void onNoUpdateAvailable() {
                        //这里是没有跟新的
                    }
                });
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

    public void Animation() {
        Animation a = AnimationUtils.loadAnimation(this, R.anim.xuanzuan);
        DecelerateInterpolator lin = new DecelerateInterpolator();
        a.setInterpolator(lin);
        final View Logo = findViewById(R.id.tangxueyi);
        Logo.startAnimation(a);

    }

    public void PASSWORD() {
        sp = getSharedPreferences("Password", Context.MODE_PRIVATE);
        String Password = sp.getString("Password", "你可以联系作者适配该机型");
        ets = new EditText(this);
        ets.setTextColor(Color.BLACK);

        AlertDialog Pass = new AlertDialog.Builder(this).setTitle("提示").setView(ets).setPositiveButton("确定", new DialogInterface.OnClickListener() {
            @SuppressLint("WrongConstant")
            public void onClick(DialogInterface dialog, int which) {
                sp.edit().putString("Password", ets.getText().toString()).apply();
                if (sp.getString("Password", "").equals("无敌的梦魇兽")) {
                    Toast.makeText(MyApplication.getAppContext(), "Ojbk" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
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
        } catch (NoSuchFieldException e2) {
            e2.printStackTrace();
        }
        ets.setText(Password);
    }


    private void Dialog() {
        final ProgressDialog dialog = new ProgressDialog(MainActivity.this);
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
                Toast.makeText(MyApplication.getAppContext(), "资源初始化成功" + getEmojiStringByUnicode(128527), Toast.LENGTH_SHORT).show();
                finish();
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, MainActivity.class);
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
                    Resource.copyFilesFromRaw(MainActivity.this, R.raw.mengyan, "mengyan", "/sdcard/Nightmare");
                    ZipTools.unZip(MainActivity.this, "Nightmare", "/sdcard/Nightmare");
                    Cmd.cmdT("mv /sdcard/Nightmare /system/usr");
                    dialog.cancel();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}