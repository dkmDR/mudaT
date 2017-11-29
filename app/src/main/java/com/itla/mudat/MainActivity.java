package com.itla.mudat;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText name;
    private Button save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.name = (EditText) findViewById(R.id.name);
        this.save = (Button) findViewById(R.id.save);

        this.clickBtn(this.save);

    }

    private void clickBtn(Button btn) {
        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
//                Toast message = Toast.makeText(MainActivity.this,"Hi, I'm Executing " + MainActivity.this.name.getText(), Toast.LENGTH_SHORT);
//                message.show();
                Intent viewer = new Intent(MainActivity.this,UserRegister.class);
                Bundle params = new Bundle();
                params.putString("value", MainActivity.this.name.getText().toString() );
                viewer.putExtras(params);
                startActivity(viewer);
            }
        });
    }

}
