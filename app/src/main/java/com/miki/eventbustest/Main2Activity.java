package com.miki.eventbustest;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.appcompat.app.AppCompatActivity;

public class Main2Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Button btn2 = (Button)findViewById(R.id.btn2);
        Button btn23 = (Button)findViewById(R.id.btn23);

        btn2.setOnClickListener(v -> publshMethod());
        btn23.setOnClickListener(v -> {
            Intent intent = new Intent(Main2Activity.this, Main3Activity.class);
            startActivity(intent);
        });
        EventBus.getDefault().register(this);
    }

    private void publshMethod() {
        String msg = "传递msg";
        EventBus.getDefault().post(MyEvent.getInstance(msg));
    }

    /**
     * 只根据发送的事情对象来启动订阅者
     * @param msg
     */
    @Subscribe
    public void onMsg(MyMsg msg) {
        Toast.makeText(this, "2:" + msg.message, Toast.LENGTH_SHORT).show();
        Log.d("ccg", "2222222222222222222 msg");
    }

    @Subscribe
    public void onEvent(MyEvent event) {
        Toast.makeText(this, "2:" + event.message, Toast.LENGTH_SHORT).show();
        Log.d("ccg", "2222222222222222 event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
