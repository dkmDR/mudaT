package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ActionsActivity extends AppCompatActivity {

    Button btnuser;
    Button btnbanner;
    Button btncategory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actions);

        btnuser = (Button) findViewById(R.id.btnUser);
        btnbanner = (Button) findViewById(R.id.btnBanner);
        btncategory = (Button) findViewById(R.id.btnCategory);

        this.clickEvents();

    }

    /**
     * all click envets by ActionsActivity
     */
    private void clickEvents(){

        btnuser.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent viewer = new Intent(ActionsActivity.this, UserslistActivity.class);

                startActivity(viewer);
            }
        });

        btncategory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(ActionsActivity.this, CategoryListActivity.class);

                startActivity(viewer);
            }
        });

        btnbanner.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(ActionsActivity.this, BannerListActivity.class);

                startActivity(viewer);
            }
        });

    }
}
