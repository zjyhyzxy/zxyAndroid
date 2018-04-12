package com.bignerdanch.android.activitytest;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class FirstActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.first_layout);
        Log.d("FirstActivity","id"+getTaskId());
        //Log.d("FirstActivity",this.toString());
        Button button1=(Button) findViewById(R.id.Button_1);
        button1.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                //Toast.makeText(FirstActivity.this,"you clicked Button 1", Toast.LENGTH_SHORT).show();
                //Intent intent = new Intent(Intent.ACTION_VIEW);
                //intent.setData(Uri.parse("http://www.baidu.com"));
                //startActivity(intent);
                //String data="hello SecondActivity";
                Intent intent =new Intent(FirstActivity.this,SecondActivity.class);
                //intent.putExtra("extra_data",data);
                startActivity(intent);
                //startActivityForResult(intent,1);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            case R.id.add_item:
                Toast.makeText(this,"you clicked add",Toast.LENGTH_LONG).show();
                break;
            case R.id.remove_item:
                Toast.makeText(this,"you clicked remove",Toast.LENGTH_LONG).show();
                break;
            default:
        }
        return true;
    }
    protected void onActivityResult(int requestCode,int resultCode,Intent data){
        switch(requestCode){
            case 1:
                if(resultCode==RESULT_OK){
                    String returnedData=data.getStringExtra("data_return");
                    Toast.makeText(FirstActivity.this,returnedData, Toast.LENGTH_SHORT).show();
                    //Log.d("FirstActivity",returnedData);
                }
                break;
            default:
        }
    }
    @Override
    protected void onRestart(){
        super.onRestart();
        Log.d("FirstActivity","onRestart");
    }


}
