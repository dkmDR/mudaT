package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ListView;

import com.itla.mudat.Adapters.UserList;
import com.itla.mudat.Entity.User;
import com.itla.mudat.Models.UserModel;

import java.util.List;

public class UserslistActivity extends AppCompatActivity {

    Button btnAdd;
    ListView userList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_userslist);

        btnAdd = (Button) findViewById(R.id.btnAdd);
        userList = (ListView) findViewById(R.id.userList);

        this.fillListView();
    }

    private void fillListView() {

        UserModel userModel = new UserModel(this);

        List<User> usrList = userModel.search();

        userList.setAdapter(new UserList(usrList, this));

        this.clickEvents();

    }

    private void clickEvents() {

        btnAdd.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent viewer = new Intent(UserslistActivity.this, UserRegister.class);

                startActivity(viewer);
            }
        });

        userList.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent viewer = new Intent(UserslistActivity.this, UserRegister.class);
                User us = (User) userList.getItemAtPosition(i);
                viewer.putExtra("user", us);
                startActivity(viewer);
            }
        });

    }
}
