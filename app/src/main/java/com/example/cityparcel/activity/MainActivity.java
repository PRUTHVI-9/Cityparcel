package com.example.cityparcel.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.LinearGradient;
import android.graphics.Shader;
import android.os.Build;
import android.os.Bundle;
import android.text.TextPaint;
import android.widget.TextView;

import com.example.cityparcel.R;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity {
    TextView foodie;
    SharedPreferences preferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        foodie = findViewById(R.id.foodie);
        preferences=getSharedPreferences("Myapp",MODE_PRIVATE);
        editor=preferences.edit();
        setTextViewColor(foodie, getResources().getColor(R.color.violet),
                getResources().getColor(R.color.blue),
                getResources().getColor(R.color.green),
                getResources().getColor(R.color.yellow),
                getResources().getColor(R.color.orangee),
                getResources().getColor(R.color.red));

        boolean isloginIn = preferences.getBoolean("is_login",false);
        boolean already1sttimelogin = preferences.getBoolean("please_login_again",false);
        boolean youVisited1sttime = preferences.getBoolean("you_visited_1st_time",true);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {

                if (youVisited1sttime){
                    startActivity(new Intent(MainActivity.this,ShoppingActivity.class));
                    editor.putBoolean("you_visited_1st_time",false);
                    editor.commit();
                    finish();
                }else if (isloginIn){
                    startActivity(new Intent(MainActivity.this,HomeActivity.class));
                    finish();
                }else {
                    startActivity(new Intent(MainActivity.this,SignInActivity.class));
                    finish();
                }
//                Intent intent = new Intent(MainActivity.this, ShoppingActivity.class);
//                startActivity(intent);
//                finish();
            }
        }, 2000);
    }
    private void setTextViewColor(TextView foodie,int...color){
        TextPaint paint = foodie.getPaint();
        float width = paint.measureText(foodie.getText().toString());

        Shader shader= new LinearGradient(0,0,width,foodie.getTextSize(),color,null,Shader.TileMode.CLAMP);
        foodie.getPaint().setShader(shader);
        foodie.setTextColor(color[0]);
    }


//    private void statusbarcolor(){
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M){
//            getWindow().setStatusBarColor(getResources().getColor(R.color.red,this.getTheme()));
//        }else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP){
//            getWindow().setStatusBarColor(getResources().getColor(R.color.red));
//
//        }
//    }
}