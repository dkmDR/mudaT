package com.itla.mudat.Events;

import android.view.View;
import android.widget.Button;

import com.itla.mudat.interfaces.Events;

/**
 * Created by Miguel Peralta on 11/11/2017.
 */
public class CustomButton {

    public CustomButton(Button btn) {

        btn.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){

            }
        });

    }

}
