package com.liu.administratorexample.yunifang;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import java.util.Timer;
import java.util.TimerTask;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ImageView m_ynf_image;
    private Button jump;
    private int x = 3;
    private Thread thread1;
    private Timer timer;
    Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 200:
                    m_ynf_image.setImageResource(R.drawable.ynf);
                    thread1.start();
                    jump.setVisibility(View.VISIBLE);
                    break;
                case 300:
                    jump.setText("跳过" + x);
                    break;
            }
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        getXian();
    }

    private void getXian() {
        Thread thread = new Thread() {
            @Override
            public void run() {
                super.run();
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                handler.sendEmptyMessage(200);
            }
        };
        thread.start();
        thread1 = new Thread() {
            @Override
            public void run() {
                super.run();
                timer = new Timer();
                timer.schedule(new TimerTask() {
                    @Override
                    public void run() {
                        if (x > 0) {
                            handler.sendEmptyMessage(300);
                            x--;
                        }
                        if (x == 0) {
                            startActivity(new Intent(MainActivity.this, Home.class));
                            timer.cancel();
                        }
                    }
                }, 1000, 1000);
            }
        };
    }

    private void initView() {
        m_ynf_image = (ImageView) findViewById(R.id.m_ynf_image);
        jump = (Button) findViewById(R.id.jump);
        jump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.jump:
                startActivity(new Intent(MainActivity.this, Home.class));
//                timer.cancel();
                break;
        }
    }
}
