package com.bignerdanch.android.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ThirdActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("ThirdActivity","id"+getTaskId());
        setContentView(R.layout.third_layout);
        Button button3=(Button) findViewById(R.id.Button_3);
        button3.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(FirstActivity.this,"you clicked Button 1", Toast.LENGTH_SHORT).show();
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse("http://www.baidu.com"));
                startActivity(intent);
            }
        });
    }
}
