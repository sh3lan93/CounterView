package com.shalan.mohamed.itemcounter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Toast;

import com.shalan.mohamed.itemcounterview.CounterListener;
import com.shalan.mohamed.itemcounterview.IncDecView;

public class MainActivity extends AppCompatActivity implements CounterListener {

    private IncDecView incDecView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        incDecView = findViewById(R.id.itemCounter);
        incDecView.setCounterListener(this);
    }

    @Override
    public void onIncClick(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }

    @Override
    public void onDecClick(String value) {
        Toast.makeText(this, value, Toast.LENGTH_LONG).show();
    }
}
