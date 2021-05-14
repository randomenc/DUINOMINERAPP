package com.duino.Miner.v1;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.widget.Button;
import android.widget.TextView;
import com.chaquo.python.PyObject;
import com.chaquo.python.Python;
import com.chaquo.python.hello.R;

import android.view.View;
import android.os.Handler;
import android.widget.Toast;



public class MainActivity extends AppCompatActivity {
    Runnable runnable;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        setContentView(R.layout.activity_main); // sets the content view to main.xml
        final  Handler mHandler = new Handler();

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView mainlog = (TextView) findViewById(R.id.logbox);
        Button start = (Button) findViewById(R.id.startbutton);

        start.setOnClickListener(new View.OnClickListener() {

            public void onClick(View view) {
                Python py = Python.getInstance();
                PyObject pyObj = py.getModule("miner");
                Toast.makeText(MainActivity.this, "Mining Started, close app to stop!", Toast.LENGTH_SHORT).show();
                pyObj.callAttr("retrieve_server_ip", findViewById(R.id.username).toString());

            };
        });
    }
}