package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.Toast;

import com.itla.mudat.Adapters.CategoriesList;
import com.itla.mudat.Entity.Banner;
import com.itla.mudat.Entity.Category;
import com.itla.mudat.Models.BannerModel;
import com.itla.mudat.Models.CategoryModel;

import java.util.List;

public class BannersActivity extends AppCompatActivity {

//    ListView categorylistview;
    Button btnmybanners;
    Button btncreate;
    Spinner spnCategories;

    EditText bannerPrice;
    EditText bannerTitle;
    EditText bannerDetail;

    Category categorySelected;
    Banner banner;
    BannerModel bannerModel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_banners);

//        categorylistview = findViewById(R.id.banner_category_list);
        btnmybanners = findViewById(R.id.my_banners);
        btncreate = findViewById(R.id.banner_save);
        spnCategories = findViewById(R.id.category_options);

        bannerPrice = findViewById(R.id.banner_price);
        bannerTitle = findViewById(R.id.banner_title);
        bannerDetail = findViewById(R.id.banner_details);

        bannerModel = new BannerModel(this);

        this.fillCategory();
    }

    private void fillCategory() {

        CategoryModel categoryModel = new CategoryModel(this);

        List<Category> categoryList = categoryModel.search();

//        categorylistview.setAdapter(new CategoriesList(categoryList, this, 2));

        spnCategories.setAdapter(new CategoriesList(categoryList, this, 1));

        this.clickEvents();

    }

    private void clickEvents(){

        btnmybanners.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent viewer = new Intent(BannersActivity.this, BannerListActivity.class);

                startActivity(viewer);
            }
        });

        btncreate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                BannersActivity.this.banner = new Banner();

                BannersActivity.this.banner.setTitle(BannersActivity.this.bannerTitle.getText().toString());
                BannersActivity.this.banner.setPrice( Double.parseDouble( BannersActivity.this.bannerPrice.getText().toString() ) );
                BannersActivity.this.banner.setDetails(BannersActivity.this.bannerDetail.getText().toString());
                BannersActivity.this.banner.setCategory(categorySelected);

                BannersActivity.this.bannerModel.create(BannersActivity.this.banner);

                Toast toast = Toast.makeText(BannersActivity.this, "Banner was created", Toast.LENGTH_SHORT);

                toast.show();

            }
        });

        spnCategories.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                categorySelected = (Category) adapterView.getItemAtPosition(i);
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

    }
}
