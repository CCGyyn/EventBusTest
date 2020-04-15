package com.miki.eventbustest;

import android.os.Bundle;
import android.util.Log;
import android.widget.Button;
import android.widget.Toast;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;

import androidx.appcompat.app.AppCompatActivity;

public class Main3Activity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        EventBus.getDefault().register(this);
        Button btn3 = (Button)findViewById(R.id.btn3);
        Button btn33 = (Button)findViewById(R.id.btn33);
        btn3.setOnClickListener(v -> EventBus.getDefault().post(MyEvent.getInstance("3 myevent")));
        btn33.setOnClickListener(V -> EventBus.getDefault().post(MyMsg.getInstance("3 MyMsg")));
    }

    @Subscribe
    public void onmsg(MyEvent m) {
        Toast.makeText(this, "33:" + m.message, Toast.LENGTH_SHORT).show();
        Log.d("ccg", "333333333333333333 event");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        EventBus.getDefault().unregister(this);
    }
}
