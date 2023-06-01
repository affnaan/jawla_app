package com.jawla.ecom;

import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import java.util.Locale;

public class CountdowntimerActivity extends AppCompatActivity {

    private static final long  START_TIME_IN_MILLS = 200000;


    private TextView mTextViewCountdown;
    private Button mButtonStartPAuse, mButtonReset;

       private CountDownTimer mCountDownTimer;

       private boolean mTimerRunning;

       private long mTimeleftinMilles = START_TIME_IN_MILLS;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(R.layout.activity_countdowntimer);

        mTextViewCountdown = findViewById(R.id.text_view_countdown);

        mButtonStartPAuse = findViewById(R.id.button_start_pause);
        mButtonReset= findViewById(R.id.button_reset);

        mButtonStartPAuse.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mTimerRunning){
                    pauseTimer();

                }
                else {
                    startTimer();

                }
            }
        });

        mButtonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                resetTimer();
            }
        });
        updateCountDownText();
    }
    private void startTimer()
    {
mCountDownTimer = new CountDownTimer(mTimeleftinMilles, 1000) {
    @Override
    public void onTick(long millisUntilFinished) {
        mTimeleftinMilles = millisUntilFinished;
        updateCountDownText();
    }

    @Override
    public void onFinish() {

        mTimerRunning = false;
        mButtonStartPAuse.setText("Start");
        mButtonStartPAuse.setVisibility(View.INVISIBLE);
        mButtonReset.setVisibility(View.VISIBLE);

    }
}.start();

mTimerRunning = true;
mButtonStartPAuse.setText("pause");
mButtonReset.setVisibility(View.INVISIBLE);
    }

private void pauseTimer() {

        mCountDownTimer.cancel();
        mTimerRunning = false;
        mButtonStartPAuse.setText("Start");
        mButtonReset.setVisibility(View.VISIBLE);
}

private void resetTimer() {
        mTimeleftinMilles = START_TIME_IN_MILLS;
        updateCountDownText();
        mButtonReset.setVisibility(View.INVISIBLE);
}

private void updateCountDownText (){

        int minutes = (int) (mTimeleftinMilles / 1000) / 60;
        int seconds = (int) (mTimeleftinMilles / 1000) %  60;


        String timeLeftFormated = String.format(Locale.getDefault(),"%02d:%02d", minutes, seconds);


        mTextViewCountdown.setText(timeLeftFormated);

    }
}
