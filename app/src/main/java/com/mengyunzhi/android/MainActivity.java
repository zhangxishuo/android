package com.mengyunzhi.android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.mengyunzhi.core.Yunzhi;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toast.makeText(Yunzhi.getContext(), "Context is success.", Toast.LENGTH_LONG).show();
    }
}
