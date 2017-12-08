package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.Entity.Category;
import com.itla.mudat.Models.CategoryModel;

public class CategoryRegisterActivity extends AppCompatActivity {

    EditText categoryName;
    Button btnCreate;
    Button btnReturntoList;
    CategoryModel cm;
    Category category;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_register);

        Bundle params = getIntent().getExtras();

        categoryName = (EditText) findViewById(R.id.categoryName);
        btnCreate = (Button) findViewById(R.id.btnCreateCategory);
        btnReturntoList = (Button) findViewById(R.id.showCategoryList);

        if (params != null && params.containsKey("category")) {
            this.fillFields(params);
        }

        cm = new CategoryModel(this);
        category = new Category();

        this.clickEvents();
    }

    private void fillFields(Bundle params) {

        this.category = (Category) params.getSerializable("category");

        categoryName.setText(this.category.getName().toString());

    }

    /**
     * all click envets by ActionsActivity
     */
    private void clickEvents(){

        btnCreate.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                CategoryRegisterActivity.this.category.setName(categoryName.getText().toString());

                CategoryRegisterActivity.this.cm.create(CategoryRegisterActivity.this.category);

                Toast toast = Toast.makeText(CategoryRegisterActivity.this, "category was created", Toast.LENGTH_SHORT);

                toast.show();
            }
        });

        btnReturntoList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(CategoryRegisterActivity.this, CategoryListActivity.class);

                startActivity(it);
            }
        });

    }
}
