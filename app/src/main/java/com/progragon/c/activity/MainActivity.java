package com.progragon.c.activity;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.Context;

import androidx.databinding.DataBindingUtil;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import com.progragon.c.R;
import com.progragon.c.databinding.ActivityMainBinding;
import com.progragon.c.handlers.MainActivityHandlers;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private final Context mContext = MainActivity.this;

    ActivityMainBinding binding;
    MainActivityHandlers handlers;

    final Calendar myCalendar = Calendar.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView((Activity) mContext, R.layout.activity_main);

        handlers = new MainActivityHandlers(mContext);
        binding.setHandlers(handlers);

        Objects.requireNonNull(binding.tnlDateTime.getEditText()).setFocusable(false);
        Objects.requireNonNull(binding.tnlDateTime.getEditText()).setFocusableInTouchMode(false);

        binding.tnlDateTime.getEditText().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new DatePickerDialog(mContext, date, myCalendar
                        .get(Calendar.YEAR), myCalendar.get(Calendar.MONTH),
                        myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });
    }

    DatePickerDialog.OnDateSetListener date = new DatePickerDialog.OnDateSetListener() {

        @Override
        public void onDateSet(DatePicker view, int year, int monthOfYear,
                              int dayOfMonth) {
            // TODO Auto-generated method stub
            myCalendar.set(Calendar.YEAR, year);
            myCalendar.set(Calendar.MONTH, monthOfYear);
            myCalendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

            SimpleDateFormat sdf = new SimpleDateFormat("dd MMM yyyy", Locale.US);
            Objects.requireNonNull(binding.tnlDateTime.getEditText()).setText(sdf.format(myCalendar.getTime()));
        }
    };
}
