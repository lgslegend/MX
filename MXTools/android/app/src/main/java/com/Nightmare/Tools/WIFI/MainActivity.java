package com.Nightmare.Tools.WIFI;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.ContextThemeWrapper;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.Nightmare.Adapter.BaseFragment;
import com.Nightmare.MyApplication;

import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import M.X.R;

import static android.content.Context.CLIPBOARD_SERVICE;

/**
 * Wing_Li
 * 2016/7/6.
 */
public class MainActivity extends BaseFragment{

    private ListView mListView;
    private TextView mHeaderHint;

    private ArrayList<WifiInfo> mWifiInfoList;
    private MyAdapter myAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Context contextTheme = new ContextThemeWrapper(getActivity(),R.style.AppTheme_Main);

        LayoutInflater themeInflater = inflater.cloneInContext(contextTheme);

        final View rootView = inflater.inflate(R.layout.wifi, container,
                false);

        mHeaderHint = (TextView)rootView.findViewById(R.id.header_hint);
        mListView = (ListView)rootView.findViewById(R.id.listview);


        setListView();
        return rootView;
    }

    @Override
    public void onStart() {
        super.onStart();
        getWifiInfo();
    }

    private void setListView() {
        myAdapter = new MyAdapter();
        mListView.setAdapter(myAdapter);
        mListView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                ClipboardManager cmb = (ClipboardManager)getActivity().getSystemService(CLIPBOARD_SERVICE);
                cmb.setPrimaryClip(ClipData.newPlainText("密码：", mWifiInfoList.get(position)
                        .getPassword()));
                Toast.makeText(MyApplication.getAppContext(),"复制成功", Toast.LENGTH_SHORT).show();
                return true;
            }
        });
    }

    private void getWifiInfo() {
        Process process = null;
        DataOutputStream dataOutputStream = null;
        DataInputStream dataInputStream = null;
        StringBuffer wifiConf = new StringBuffer();
        try {
            process = Runtime.getRuntime().exec("su");
            dataOutputStream = new DataOutputStream(process.getOutputStream());
            dataInputStream = new DataInputStream(process.getInputStream());
            dataOutputStream.writeBytes("cat /data/misc/wifi/wpa_supplicant.conf\n");
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
                mHeaderHint.setText("请确保ROOT权限存在");
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
            }catch (Throwable throwable) {
                throwable.printStackTrace();
            }
        }

        mWifiInfoList = new ArrayList<>();

        Pattern network = Pattern.compile("network=\\{([^\\}]+)\\}", Pattern.DOTALL);
        Matcher networkMatcher = network.matcher(wifiConf.toString());
        WifiInfo wifiInfo;
        while (networkMatcher.find()) {
            String networkBlock = networkMatcher.group();
            Pattern ssid = Pattern.compile("ssid=\"([^\"]+)\"");
            Matcher ssidMatcher = ssid.matcher(networkBlock);
            if (ssidMatcher.find()) {
                wifiInfo = new WifiInfo();
                wifiInfo.setName(ssidMatcher.group(1));
                Pattern psk = Pattern.compile("psk=\"([^\"]+)\"");
                Matcher pskMatcher = psk.matcher(networkBlock);
                if (pskMatcher.find()) {
                    wifiInfo.setPassword(pskMatcher.group(1));
                } else {
                    wifiInfo.setPassword("无密码");
                }
                mWifiInfoList.add(wifiInfo);
            }
        }
        // 列表倒序
        Collections.reverse(mWifiInfoList);
        myAdapter.notifyDataSetChanged();
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return mWifiInfoList == null ? 0 : mWifiInfoList.size();
        }

        @Override
        public WifiInfo getItem(int position) {
            return mWifiInfoList.get(position);
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder holder;
            if (convertView == null) {
                holder = new ViewHolder();
                convertView = LayoutInflater.from(getActivity()).inflate(R.layout.wifi1, null);
                holder.name = (TextView) convertView.findViewById(R.id.item_name);
                holder.password = (TextView) convertView.findViewById(R.id.item_password);

                convertView.setTag(holder);
            } else {
                holder = (ViewHolder) convertView.getTag();
            }

            WifiInfo wifi = getItem(position);

            holder.name.setText("名称：" + wifi.getName());
            holder.password.setText("密码：" + wifi.getPassword());

            return convertView;
        }

        class ViewHolder {
            TextView name;
            TextView password;
        }
    }



}
