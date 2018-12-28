package com.Nightmare.Tools;

import android.util.Log;
import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.*;

/*指令集封装类*/


public class Cmd {
    public static boolean cmd(String str) throws Throwable {
        Exception e;
        Throwable th;
        Process process = null;
        DataOutputStream dataOutputStream = null;
        try {
            DataOutputStream dataOutputStream2 = new DataOutputStream(process.getOutputStream());
            try {
                dataOutputStream2.writeBytes(new StringBuilder(String.valueOf(str)).append("\n").toString());
                dataOutputStream2.writeBytes("exit\n");
                dataOutputStream2.flush();
                process.waitFor();
                if (dataOutputStream2 != null) {
                    try {
                        dataOutputStream2.close();
                    }catch (Throwable throwable) {
                        throwable.printStackTrace();
                    }
                }
                process.destroy();
                dataOutputStream = dataOutputStream2;
                return true;
            } catch (Exception e3) {
                e = e3;
                dataOutputStream = dataOutputStream2;
                try {
                    Log.d("*** DEBUG ***", "Unexpected error: " + e.getMessage());
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e4) {
                            return false;
                        }
                    }
                    process.destroy();
                    return false;
                } catch (Throwable th2) {
                    th = th2;
                    if (dataOutputStream != null) {
                        try {
                            dataOutputStream.close();
                        } catch (Exception e5) {
                            throw th;
                        }
                    }
                    process.destroy();
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
                dataOutputStream = dataOutputStream2;
                if (dataOutputStream != null) {
                    dataOutputStream.close();
                }
                process.destroy();
                throw th;
            }
        } catch (Exception e6) {
            e = e6;
            Log.d("*** DEBUG ***", "Unexpected error: " + e.getMessage());
            if (dataOutputStream != null) {
                dataOutputStream.close();
            }
            process.destroy();
            return false;
        }
    }

    public static String cmdT(String str) throws IOException {
        Process exec = Runtime.getRuntime().exec("su");
        DataOutputStream dataOutputStream = new DataOutputStream(exec.getOutputStream());
        DataInputStream dataInputStream = new DataInputStream(exec.getInputStream());
        dataOutputStream.writeBytes(new StringBuilder(String.valueOf(str)).append("\n").toString());
        dataOutputStream.writeBytes("exit\n");
        dataOutputStream.flush();
        return dataInputStream.readLine();
    }
}
