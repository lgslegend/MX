package com.Nightmare.Tools;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class su {
    public static String getProperty(String key, String defaultValue) {
        String value = defaultValue;
        try {
            Class<?> c = Class.forName("android.os.SystemProperties");
            return (String) c.getMethod("get", new Class[]{String.class, String.class}).invoke(c, new Object[]{key, "unknown"});
        } catch (Exception e) {
            e.printStackTrace();
            return value;
        } catch (Throwable th) {
            return value;
        }
    }

    public static String Rootre(String su) {
        String value = "";
        try {
            BufferedReader mReader = new BufferedReader(new InputStreamReader(Runtime.getRuntime().exec(su).getInputStream()));
            StringBuffer mRespBuff = new StringBuffer();
            char[] buff = new char[1024];
            while (true) {
                int ch = mReader.read(buff);
                if (ch == -1) {
                    break;
                }
                mRespBuff.append(buff, 0, ch);
            }
            mReader.close();
            value = mRespBuff.toString();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return value;
    }
}
