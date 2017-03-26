package com.example.administrator.killdragonx;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;



public class CountDownActivity extends AppCompatActivity {

    @BindView(R.id.tv_countDown)
    TextView tvCountDown;
    @BindView(R.id.btn_stop)
    Button btnStop;
    private int[] n = {0};
    private int nn = 0;
    private boolean isFinish = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_count_down);
        ButterKnife.bind(this);

        init();
    }

    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            switch (msg.what) {
                case 0:
                    tvCountDown.setText(n[0] + "");
                    break;
            }
        }
    };




    private void init() {
        Intent intent = getIntent();
        final int number = intent.getIntExtra(MainActivity.COUNT_DOWN_NUMBER, 50);
        Thread t = new Thread(new Runnable() {
            @Override
            public void run() {
                while (!isFinish) {
                    n[0] = (int) (Math.random() * number);
                    handler.sendEmptyMessage(0);
                    try {
                        Thread.sleep(20);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        t.start();
    }

    @OnClick(R.id.btn_stop)
    public void onViewClicked() {
        isFinish = true;
    }
}
