package com.example.administrator.killdragonx;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    public static final String COUNT_DOWN_NUMBER = "count down number";
    @BindView(R.id.et_number)
    EditText etNumber;
    @BindView(R.id.btn_begin)
    Button btnBegin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_begin)
    public void onViewClicked() {
        int number = 50;
        try {
            number = Integer.parseInt(etNumber.getText().toString());
        } catch (NumberFormatException e) {
            e.printStackTrace();
        }

        Intent intent = new Intent(this, CountDownActivity.class);
        intent.putExtra(COUNT_DOWN_NUMBER, number);
        startActivity(intent);
    }

}
