package com.example.cityparcel.activity;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;

import com.example.cityparcel.R;

import java.util.Calendar;

public class BirthdayActivity extends AppCompatActivity {
    TextView Birthday,Anniversary;
    Button submit;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday);
        Birthday = findViewById(R.id.birth);
        Anniversary = findViewById(R.id.anniversary);
        submit = findViewById(R.id.submit);
        preferences = getSharedPreferences("MyApp",MODE_PRIVATE);
        editor=preferences.edit();
        Calendar calendar=Calendar.getInstance();
        calendar.add(Calendar.YEAR,-18);
        calendar.add(Calendar.YEAR,+18);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                editor.putString("birthday",Birthday.getText().toString());
                editor.putString("anniversary",Anniversary.getText().toString());
                editor.commit();
                Intent intent = new Intent(BirthdayActivity.this, HomeActivity.class);
                startActivity(intent);
                finish();
            }
        });
        Birthday.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(BirthdayActivity.this);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayofMonth, int month, int year) {
                        int i= month+1;
                        Log.e("TAG", "onDateSet: "+i );
                        Birthday.setText(dayofMonth + "-"+month+"-"+year);

                    }
                });
                datePickerDialog.show();
            }
        });
        Anniversary.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.N)
            @Override
            public void onClick(View view) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(BirthdayActivity.this);
                datePickerDialog.getDatePicker().setMaxDate(calendar.getTimeInMillis());
                datePickerDialog.setOnDateSetListener(new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker datePicker, int dayofMonth, int month, int year) {
                        int i= month+1;
                        Log.e("TAG", "onDateSet: "+i );
                        Anniversary.setText(dayofMonth + "-"+month+"-"+year);

                    }
                });
                datePickerDialog.show();
            }
        });
    }
}