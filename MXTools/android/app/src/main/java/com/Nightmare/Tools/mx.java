package com.Nightmare.Tools;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class mx  extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
					startActivity(new Intent().setClassName("com.nightmare", "MainActivity"));
    }
}
