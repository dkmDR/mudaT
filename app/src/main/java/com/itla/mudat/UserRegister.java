package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.itla.mudat.Entity.User;
import com.itla.mudat.Entity.UserType;
import com.itla.mudat.Models.UserModel;

import java.util.List;

public class UserRegister extends AppCompatActivity {

    private EditText name;
    private EditText id;
    private EditText email;
    private EditText phone;
    private EditText password;
    private EditText confirmPassword;
    private Button btnRegister;
    private User users;
    private UserModel usermodel;
    private Button btnShowMe;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_user_register);

        Bundle params = getIntent().getExtras();

        if (params != null && params.containsKey("user")) {
            this.users = (User) params.getSerializable("user");
        }

        this.name = (EditText) findViewById(R.id.name);
        this.id = (EditText) findViewById(R.id.id);
        this.email = (EditText) findViewById(R.id.email);
        this.phone = (EditText) findViewById(R.id.phone);
        this.password = (EditText) findViewById(R.id.password);
        this.confirmPassword = (EditText) findViewById(R.id.passwordConfirm);
        this.btnRegister = (Button) findViewById(R.id.register);
        this.btnShowMe = (Button) findViewById(R.id.showme);

        this.usermodel = new UserModel(this);

        this.btnRegister.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

                if ( UserRegister.this.users == null )
                    UserRegister.this.users = new User();

                UserRegister.this.users.setName(UserRegister.this.name.getText().toString());
                UserRegister.this.users.setEmail(UserRegister.this.email.getText().toString());
                UserRegister.this.users.setPhone(UserRegister.this.phone.getText().toString());
                UserRegister.this.users.setPassword(UserRegister.this.password.getText().toString());
                UserRegister.this.users.setConfirmPassword(UserRegister.this.confirmPassword.getText().toString());
                UserRegister.this.users.setType(UserType.customer);
                UserRegister.this.users.setIdt(UserRegister.this.id.getText().toString());

//                Log.i("User Register", UserRegister.this.users.toString());

                UserRegister.this.usermodel.create(UserRegister.this.users);

                Toast message = Toast.makeText(UserRegister.this,"The user was created", Toast.LENGTH_SHORT);
                message.show();

            }
        });

        this.btnShowMe.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

//                List<User> list = UserRegister.this.usermodel.search();
//
//                Log.i("Users", list.toString());

                Intent it = new Intent(UserRegister.this, UserslistActivity.class);

                startActivity(it);
            }
        });

    }

    public void fillFields( Bundle params ){

        if (params != null && params.containsKey("user")) {
            this.users = (User) params.getSerializable("user");
        }

    }
}
