package com.gl.week11class;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IntentFilter intentF = new IntentFilter();
        intentF.addAction(SomeService.WAKE_RECEIVER);
        registerReceiver(new MyReceiver(),intentF);

    }

    public void btnDownload(View view) {
        Log.d("ibrahim", "Button is OK");
        EditText edt = (EditText)findViewById(R.id.txtURL);
        Intent intent = new Intent(this, SomeService.class);
        intent.putExtra("url", edt.getText().toString());
        intent.setAction(SomeService.ACTION_DOWNLOAD);
        startService(intent);
    }
    private  class MyReceiver extends BroadcastReceiver{

        @Override
        public void onReceive(Context context, Intent intent) {
            Log.d("ibrahim","Bradcast received");
            Log.d("ibrahim", intent.getStringExtra("info"));
        }
    }
}
