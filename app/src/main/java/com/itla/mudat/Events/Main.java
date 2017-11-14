package com.itla.mudat.Events;

import android.view.View;
import android.widget.Button;

import com.itla.mudat.interfaces.*;

/**
 * Created by Miguel Peralta on 11/11/2017.
 */
public class Main implements Events
{

    @Override
    public int save() {
        return 0;
    }

    @Override
    public boolean delete() {
        return true;
    }

    @Override
    public boolean update() {
        return true;
    }

    @Override
    public void doing() {

    }

}
