package com.bignerdanch.android.activitytest;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class SecondActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("SecondActivity","id"+getTaskId());
        setContentView(R.layout.sencod_layout);
        Button button2 = (Button) findViewById(R.id.Button_2);
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SecondActivity.this,ThirdActivity.class);
                startActivity(intent);
                //intent.putExtra("data_return", "hello firstactivity");
                //setResult(RESULT_OK, intent);
                //finish();
            }
        });
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent();
        intent.putExtra("data_return", "hello firstactivity");
        setResult(RESULT_OK, intent);
        finish();
    }
    protected void onDestroy(){
        super.onDestroy();
        Log.d("FirstActivity","onDestroy");
    }
}


