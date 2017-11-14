package com.itla.mudat;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ViewerActivity extends AppCompatActivity {

    private TextView received;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_viewer);

        Bundle params = getIntent().getExtras();

        this.received = (TextView) findViewById( R.id.received );

        this.received.setText(params.getString("value"));

    }
}
