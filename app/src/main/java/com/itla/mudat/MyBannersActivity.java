package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.BannerList;
import com.itla.mudat.Entity.Banner;
import com.itla.mudat.Models.BannerModel;

import java.util.List;

public class MyBannersActivity extends AppCompatActivity {

    Button btnReturnAction;
    ListView bannerlist;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_banners);

        btnReturnAction = (Button) findViewById(R.id.go_to_advert);
        bannerlist = (ListView) findViewById(R.id.my_advert_list);

        this.fillListView();
    }

    private void fillListView() {

        BannerModel bannerModel = new BannerModel(this);
        List<Banner> bannerList = bannerModel.search();
        bannerlist.setAdapter(new BannerList(bannerList, this, 2));

        this.clickEvents();

    }

    private void clickEvents(){

        btnReturnAction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(MyBannersActivity.this, BannerListActivity.class);

                startActivity(viewer);
            }
        });

        bannerlist.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent viewer = new Intent(MyBannersActivity.this, BannersActivity.class);
                Banner catt = (Banner) bannerlist.getItemAtPosition(i);
                viewer.putExtra("advert", catt);
                startActivity(viewer);
            }
        });

    }
}
