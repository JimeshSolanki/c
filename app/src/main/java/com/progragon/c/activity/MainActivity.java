package com.progragon.c.activity;

import android.app.Activity;
import android.content.Context;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;

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
//        setContentView(R.layout.activity_main);
        binding = DataBindingUtil.setContentView((Activity) mContext, R.layout.activity_main);

        handlers = new MainActivityHandlers(mContext);
        binding.setHandlers(handlers);
    }
}
