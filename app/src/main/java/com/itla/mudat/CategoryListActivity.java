package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.CategoriesList;
import com.itla.mudat.Entity.Category;
import com.itla.mudat.Models.CategoryModel;

import java.io.Serializable;
import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    Button btnAddCreate;
    Button btnReturnHome;
    ListView categorylistview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);

        btnAddCreate = (Button) findViewById(R.id.add_new_category);
        btnReturnHome = (Button) findViewById(R.id.returnHomeFromCategory);


        categorylistview = (ListView) findViewById(R.id.category_list);

        this.fillListView();

    }

    private void fillListView() {

        CategoryModel categoryModel = new CategoryModel(this);

        List<Category> categoryList = categoryModel.search();

        categorylistview.setAdapter(new CategoriesList(categoryList, this, 1));

        this.clickEvents();

    }

    /**
     * all click envets by ActionsActivity
     */
    private void clickEvents(){

        btnAddCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent viewer = new Intent(CategoryListActivity.this, CategoryRegisterActivity.class);

                startActivity(viewer);
            }
        });

        btnReturnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent newView = new Intent(CategoryListActivity.this, ActionsActivity.class);
                startActivity(newView);
            }
        });

        categorylistview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent viewer = new Intent(CategoryListActivity.this, CategoryRegisterActivity.class);
                Category catt = (Category) categorylistview.getItemAtPosition(i);
                viewer.putExtra("category", catt);
                startActivity(viewer);
            }
        });

    }
}
