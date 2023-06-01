package com.jawla.ecom;

import android.content.Intent;
import android.os.Bundle;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.view.WindowManager;
import android.widget.Button;

public class SplashScreenActivity extends AppCompatActivity {
//LinearLayout a1,a2;
Button btnSplashscreen;
//Animation uptoDown,Downtoup;






    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash_screen);

        Thread myThread = new Thread(){
            @Override
            public void run() {
                try {
                    sleep(4000);
                    Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                    startActivity(intent);
                    finish();
                }catch (InterruptedException e){
                    e.printStackTrace();
                }

            }
        };

        myThread.start();

//
//        btnSplashscreen = (Button)findViewById(R.id.btnsplash);
//        a1 = (LinearLayout)findViewById(R.id.a1);
//        a2 = (LinearLayout)findViewById(R.id.a2);
//        uptoDown = AnimationUtils.loadAnimation(this,R.anim.uptodown);
//        Downtoup = AnimationUtils.loadAnimation(this,R.anim.downtoup);
//        a1.setAnimation(uptoDown);
//        a2.setAnimation(Downtoup);

//
//        btnSplashscreen.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(SplashScreenActivity.this, MainActivity.class);
//                startActivity(intent);
//            }
//        });
    }


}
