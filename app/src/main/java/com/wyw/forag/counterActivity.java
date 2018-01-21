package com.wyw.forag;

import android.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class counterActivity extends AppCompatActivity {

    final Button yes_button = findViewById(R.id.counter_button_yes);
    final Button no_button = findViewById(R.id.counter_button_no);
//    final TextView isEarly_textview = findViewById(R.id.counter_textview_isEarly);
    final TextView result_textview = findViewById(R.id.counter_textview_result);

    private  int earlyTime = 0;
    private  int latelyTime = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_counter);

        yes_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                earlyTime++;

                AlertDialog.Builder builder = new AlertDialog.Builder(counterActivity.this);//MainActivity.this为当前环境
                builder.setIcon(android.R.drawable.ic_dialog_info);//提示图标
                builder.setTitle("yes");//提示框标题
                builder.setMessage("you are beautiful");//提示内容
                //   builder.setPositiveButton("确认", null);//确定按钮
                builder.create().show();

                String t = "早睡天数："+String.valueOf(earlyTime)+" 晚睡天数:"+String.valueOf(latelyTime);
                result_textview.setText(t);
            }
        });


        no_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                latelyTime++;

                AlertDialog.Builder builder = new AlertDialog.Builder(counterActivity.this);//MainActivity.this为当前环境
                builder.setIcon(android.R.drawable.ic_dialog_info);//提示图标
                builder.setTitle("no");//提示框标题
                builder.setMessage("small pig pig");//提示内容
                //   builder.setPositiveButton("确认", null);//确定按钮
                builder.create().show();

                String t = "早睡天数："+String.valueOf(earlyTime)+" 晚睡天数:"+String.valueOf(latelyTime);
                result_textview.setText(t);
            }
        });
    }
}
