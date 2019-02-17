package com.progragon.c.activity;

import android.app.Activity;
import android.content.Context;
import android.databinding.DataBindingUtil;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.progragon.c.R;
import com.progragon.c.databinding.ActivityMainBinding;
import com.progragon.c.handlers.MainActivityHandlers;

public class MainActivity extends AppCompatActivity {

    private final Context mContext = MainActivity.this;

    ActivityMainBinding binding;
    MainActivityHandlers handlers;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = DataBindingUtil.setContentView((Activity) mContext, R.layout.activity_main);

        handlers = new MainActivityHandlers(mContext);
        binding.setHandlers(handlers);
    }
}
