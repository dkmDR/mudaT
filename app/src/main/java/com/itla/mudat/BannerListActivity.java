package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.BannerList;
import com.itla.mudat.Entity.Banner;
import com.itla.mudat.Models.BannerModel;

import java.util.List;

public class BannerListActivity extends AppCompatActivity {

    Button btnBannerRegister;
    Button btnReturnAction;
    ListView bannerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banner_list);

        btnBannerRegister = (Button) findViewById(R.id.add_new_banner);
        btnReturnAction = (Button) findViewById(R.id.banner_to_action);
        bannerlist = (ListView) findViewById(R.id.banner_list_view);

        this.fillListView();
    }

    private void fillListView() {

        BannerModel bannerModel = new BannerModel(this);
        List<Banner> bannerList = bannerModel.search();
        bannerlist.setAdapter(new BannerList(bannerList, this));

        this.clickEvents();

    }

    private void clickEvents(){

        btnBannerRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(BannerListActivity.this, BannersActivity.class);

                startActivity(viewer);
            }
        });

        btnReturnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(BannerListActivity.this, ActionsActivity.class);

                startActivity(viewer);
            }
        });

    }
}
