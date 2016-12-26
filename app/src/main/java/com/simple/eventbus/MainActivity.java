package com.simple.eventbus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

public class MainActivity extends Activity {

    Button btn,btn1;
    TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EventBus.getDefault().register(this);

        btn = (Button) findViewById(R.id.btn_try);
        btn1 = (Button) findViewById(R.id.btn_try1);
        tv = (TextView)findViewById(R.id.tv);

        btn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, FirstActivity.class);
                startActivity(intent);
            }
        });


        btn1.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intent);
            }
        });

    }


    @Override
    protected void onDestroy(){
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }

    @Subscribe
    public void onEventMainThread(FirstEvent event) {
        String msg = event.getMsg();
        tv.setText(msg);
        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
    }

    @Subscribe
    public void onEventMainThread(SecondEvent event) {
//        String msg = event.getMsg();
//        tv.setText(msg);
//        Toast.makeText(this, msg, Toast.LENGTH_LONG).show();
        Log.d("harvic", "onEventMainThread收到了消息：" + event.getMsg());
    }

    @Subscribe
    public void onEventBackgroundThread(SecondEvent event){
        Log.d("harvic", "onEventBackground收到了消息：" + event.getMsg());
    }

    @Subscribe
    public void onEventAsync(SecondEvent event){
        Log.d("harvic", "onEventAsync收到了消息：" + event.getMsg());
    }

    public void onEvent(SecondEvent event) {
        Log.d("harvic", "OnEvent收到了消息：" + event.getMsg());
    }
}
