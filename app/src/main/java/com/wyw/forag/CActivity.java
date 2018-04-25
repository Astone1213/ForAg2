package com.wyw.forag;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.InputStream;

public class CActivity extends AppCompatActivity {

    public static final String PREFS_NAME = "CounterDate_PREF";

    private  int earlyTime = 0;
    private  int latelyTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_c);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        final TextView result_textview = (TextView)findViewById(R.id.counter_textview_result);

        final SharedPreferences spfr = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences setting = getSharedPreferences(PREFS_NAME, 0);
        earlyTime = spfr.getInt("earlyTimes",0) ;
        latelyTime = spfr.getInt("latelyTimes",0);
        String t = "早睡天数："+String.valueOf(earlyTime)+" 晚睡天数:"+String.valueOf(latelyTime);
        result_textview.setText(t);


        Button yes_button = (Button) findViewById(R.id.counter_button_yes);
        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                earlyTime++;
                String t = "早睡天数："+String.valueOf(earlyTime)+" 晚睡天数:"+String.valueOf(latelyTime);
                result_textview.setText(t);
            }
        });

        Button no_button = (Button)findViewById(R.id.counter_button_no);
        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                latelyTime++;
                String t = "早睡天数："+String.valueOf(earlyTime)+" 晚睡天数:"+String.valueOf(latelyTime);
                result_textview.setText(t);
            }
        });

    }

    @Override
    protected void onStop() {
        super.onStop();
        SharedPreferences sprf = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = sprf.edit();
        editor.putInt("earlyTimes",earlyTime);
        editor.putInt("latelyTimes",latelyTime);
        editor.commit();
    }
}
