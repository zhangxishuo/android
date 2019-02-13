package com.mengyunzhi.android.app;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.internal.BottomNavigationMenuView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView mTextMessage;

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_discover:
                    mTextMessage.setText(R.string.navigation_discover);
                    return true;
                case R.id.navigation_bookshelf:
                    mTextMessage.setText(R.string.navigation_bookshelf);
                    return true;
                case R.id.navigation_idea:
                    mTextMessage.setText(R.string.navigation_idea);
                    return true;
                case R.id.navigation_me:
                    mTextMessage.setText(R.string.navigation_me);
                    return true;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);

        navigation.setLabelVisibilityMode(1);

        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);
    }

}
